/*******************************************************************************
 * Copyright (c) 2005 The Regents of the University of California. 
 * This material was produced under U.S. Government contract W-7405-ENG-36 
 * for Los Alamos National Laboratory, which is operated by the University 
 * of California for the U.S. Department of Energy. The U.S. Government has 
 * rights to use, reproduce, and distribute this software. NEITHER THE 
 * GOVERNMENT NOR THE UNIVERSITY MAKES ANY WARRANTY, EXPRESS OR IMPLIED, OR 
 * ASSUMES ANY LIABILITY FOR THE USE OF THIS SOFTWARE. If software is modified 
 * to produce derivative works, such modified software should be clearly marked, 
 * so as not to confuse it with the version available from LANL.
 * 
 * Additionally, this program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * LA-CC 04-115
 *******************************************************************************/
package org.eclipse.ptp.ui.views;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ptp.core.IPProcess;
import org.eclipse.ptp.internal.ui.actions.ChangeSetAction;
import org.eclipse.ptp.internal.ui.actions.CreateSetAction;
import org.eclipse.ptp.internal.ui.actions.DeleteSetAction;
import org.eclipse.ptp.internal.ui.actions.RemoveElementAction;
import org.eclipse.ptp.ui.IManager;
import org.eclipse.ptp.ui.IPTPUIConstants;
import org.eclipse.ptp.ui.PTPUIPlugin;
import org.eclipse.ptp.ui.actions.ParallelAction;
import org.eclipse.ptp.ui.model.IElement;
import org.eclipse.ptp.ui.model.IElementHandler;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;

/**
 * @author Clement chu
 * 
 */
public abstract class AbstractParallelSetView extends AbstractParallelElementView {
	protected List clipboard = new ArrayList();
	// selected element
	protected String cur_selected_element_id = IManager.EMPTY_ID;
	// default actions
	protected ParallelAction createSetAction = null;
	protected ParallelAction deleteSetAction = null;
	protected ParallelAction deleteProcessAction = null;
	protected ParallelAction changeSetAction = null;

	public void dispose() {
		clipboard.clear();
		super.dispose();
	}
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		IToolBarManager toolBarMgr = getViewSite().getActionBars().getToolBarManager();
		createToolBarGroups(toolBarMgr);
		createToolBarActions(toolBarMgr);
		IMenuManager menuMgr = getViewSite().getActionBars().getMenuManager();
		createMenuActions(menuMgr);
		createContextMenu();
		initialView();
		PTPUIPlugin.refreshRuntimeSystem();
	}
	protected void createToolBarGroups(IToolBarManager toolBarMgr) {
		toolBarMgr.add(new Separator(IPTPUIConstants.IUINAVIGATORGROUP));
		toolBarMgr.add(new Separator(IPTPUIConstants.IUIACTIONGROUP));
		toolBarMgr.add(new Separator(IPTPUIConstants.IUISETGROUP));
		toolBarMgr.add(new Separator(IPTPUIConstants.IUISETGROUP));
		toolBarMgr.add(new Separator(IPTPUIConstants.IUICHANGESETGROUP));
		toolBarMgr.add(new Separator(IPTPUIConstants.IUIEMPTYGROUP));
	}
	protected void buildInToolBarActions(IToolBarManager toolBarMgr) {
		createSetAction = new CreateSetAction(this);
		deleteSetAction = new DeleteSetAction(this);
		deleteProcessAction = new RemoveElementAction(this);
		changeSetAction = new ChangeSetAction(this);
		toolBarMgr.appendToGroup(IPTPUIConstants.IUISETGROUP, createSetAction);
		toolBarMgr.appendToGroup(IPTPUIConstants.IUISETGROUP, deleteSetAction);
		toolBarMgr.appendToGroup(IPTPUIConstants.IUISETGROUP, deleteProcessAction);
		toolBarMgr.appendToGroup(IPTPUIConstants.IUICHANGESETGROUP, changeSetAction);
	}
	protected void createToolBarActions(IToolBarManager toolBarMgr) {
		buildInToolBarActions(toolBarMgr);
	}
	protected void createMenuActions(IMenuManager menuMgr) {}
	protected void createContextMenu() {
		MenuManager menuMgr = new MenuManager("#popupmenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(canvas);
		canvas.setMenu(menu);
		// Be sure to register it so that other plug-ins can add actions.
		getSite().registerContextMenu(menuMgr, this);
	}
	protected void fillContextMenu(IMenuManager manager) {
		manager.add(new Separator(IPTPUIConstants.IUIACTIONGROUP));
		manager.add(new Separator(IPTPUIConstants.IUIEMPTYGROUP));
		manager.add(new Separator(IPTPUIConstants.IUICHANGESETGROUP));
		manager.add(new ChangeSetAction(this));
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	public void update() {
		updateAction();
		updateTitle();
	}
	public void updateTitle() {
		if (cur_element_set != null)
			changeTitle(manager.getName(getCurrentID()), cur_element_set.getID(), cur_set_size);
		else
			changeTitle(EMPTY_TITLE);
	}
	protected void updateAction() {
		boolean deleteActionEnable = (manager.getCurrentSetId().length() == 0 || manager.getCurrentSetId().equals(IElementHandler.SET_ROOT_ID));
		deleteSetAction.setEnabled(!deleteActionEnable);
		deleteProcessAction.setEnabled(!deleteActionEnable);
		createSetAction.setEnabled(cur_set_size > 0);
		IElementHandler elementHandler = getCurrentElementHandler();
		changeSetAction.setEnabled(!(elementHandler == null || elementHandler.size() == 0));
	}
	protected void openProcessViewer(final IPProcess element) {
		if (element == null)
			return;
		BusyIndicator.showWhile(getDisplay(), new Runnable() {
			public void run() {
				try {
					PTPUIPlugin.getActivePage().openEditor(new ProcessEditorInput(element), IPTPUIConstants.VIEW_PARALLELProcess);
				} catch (PartInitException e) {
					PTPUIPlugin.log(e);
				}
			}
		});
	}
	/*******************************************************************************************************************************************************************************************************************************************************************************************************
	 * IIconCanvasActionListener
	 ******************************************************************************************************************************************************************************************************************************************************************************************************/	
	public void handleAction(int type, int[] indexes) {
		if (cur_element_set == null)
			return;
		
		IElement[] elements = canvas.getElements(indexes);
		switch (type) {
		case IIconCanvasActionListener.COPY_ACTION:
			if (elements.length > 0) {
				clipboard.clear();
				clipboard.add(elements);
			}
			break;
		case IIconCanvasActionListener.CUT_ACTION:
			if (elements.length > 0) {
				if (!cur_element_set.isRootSet()) {
					manager.removeFromSet(elements, cur_element_set.getID(), cur_element_set.getElementHandler());
					clipboard.clear();
					clipboard.add(elements);
					selectSet(cur_element_set.getElementHandler().getSet(cur_element_set.getID()));
					updateTitle();
					refresh();
				}
			}
			break;
		case IIconCanvasActionListener.PASTE_ACTION:
			if (clipboard.size() > 0) {
				IElement[] clipElements = (IElement[])clipboard.get(0);
				if (cur_element_set.isRootSet())
					createSetAction.run(clipElements);
				else {
					manager.addToSet(clipElements, cur_element_set.getID(), cur_element_set.getElementHandler());
					selectSet(cur_element_set.getElementHandler().getSet(cur_element_set.getID()));					
					update();
					refresh();
				}
			}
			break;
		case IIconCanvasActionListener.DELETE_ACTION:
			if (elements.length > 0) {
				if (!cur_element_set.isRootSet()) {
					deleteProcessAction.run(elements);
				}
			}
			break;
		}
	}
}
