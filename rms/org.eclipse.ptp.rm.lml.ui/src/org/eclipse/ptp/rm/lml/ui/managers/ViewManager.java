/**
 * Copyright (c) 2009 IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial Implementation
 *
 * Modified by:
 * 		Claudia Konbloch, Forschungszentrum Juelich GmbH
 */

package org.eclipse.ptp.rm.lml.ui.managers;

import org.eclipse.ptp.rm.lml.core.ILMLManager;
import org.eclipse.ptp.rm.lml.core.LMLCorePlugin;
import org.eclipse.ptp.rm.lml.core.events.ILguiAddedEvent;
import org.eclipse.ptp.rm.lml.core.events.ILguiRemovedEvent;
import org.eclipse.ptp.rm.lml.core.events.ILguiSelectedEvent;
import org.eclipse.ptp.rm.lml.core.listeners.IViewListener;
import org.eclipse.ptp.rm.lml.core.model.ILguiItem;
import org.eclipse.ptp.rm.lml.ui.ILMLUIConstants;
import org.eclipse.ptp.rm.lml.ui.LMLUIPlugin;
import org.eclipse.ptp.rm.lml.ui.providers.EventForwarder;
import org.eclipse.ptp.rm.lml.ui.providers.LMLViewPart;
import org.eclipse.ptp.rm.lml.ui.views.NodesView;
import org.eclipse.ptp.rm.lml.ui.views.TableView;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

public class ViewManager {
	
	public class ViewListener implements IViewListener {

		public void handleEvent(ILguiAddedEvent e) {
			deleteOldViews();
			selectedLgui = e.getLguiItem();
			generateNewViews();
			
			selectedLgui.getObjectStatus().addComponent(new EventForwarder());
		}

		public void handleEvent(ILguiRemovedEvent e) {
				
		}

		public void handleEvent(ILguiSelectedEvent e) {
			deleteOldViews();
			selectedLgui = e.getLguiItem();
			if (selectedLgui != null) {
				generateNewViews();
			}
		}
		
	}
	
	protected ILguiItem selectedLgui = null;
	
	public ILMLManager lmlManager = null;
	
	public IViewListener viewListener = new ViewListener();
	
	public int i = 0;
	
	public int j = 0;
	
	
	public ViewManager() {
		lmlManager = LMLCorePlugin.getDefault().getLMLManager();
		lmlManager.addListener(viewListener);
	}
	
	public void shutDown() {
		lmlManager.removeListener(viewListener);
	}
	
	private void deleteOldViews() {
		if (selectedLgui == null) {
			return;
		}
		IWorkbenchPage activePage = LMLUIPlugin.getActiveWorkbenchWindow().getActivePage();
		IViewReference[] views = activePage.getViewReferences();
		
		for (IViewReference view : views) {
			if(!view.getPartName().equals("LML")) {
				if (view.getView(false) instanceof LMLViewPart) {
					((LMLViewPart) view.getView(false)).prepareDispose();
				}
				activePage.hideView(view);
				view = null;
			}
		}	
	}
	
	private void generateNewViews() {
		IWorkbenchPage activePage = LMLUIPlugin.getActiveWorkbenchWindow().getActivePage();
		String[] activeTableLayoutsGid = selectedLgui.getLayoutAccess().getActiveTableLayoutsGid(); 
		for (String gid : activeTableLayoutsGid) {
			try {
				IViewPart view = activePage.showView(ILMLUIConstants.VIEW_TABLE, Integer.toString(i), activePage.VIEW_VISIBLE);
				((TableView) view).generateTable(gid);
				view.setFocus();
				i++;
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		String[] activeNodedisplayLayoutGid = selectedLgui.getLayoutAccess().getActiveNodedisplayLayoutGid();
		for (String gid : activeNodedisplayLayoutGid) {
			try {
				IViewPart view = activePage.showView(ILMLUIConstants.VIEW_PARALLELNODES, Integer.toString(j), activePage.VIEW_VISIBLE);
				((NodesView)view).generateNodesdisplay(gid);
				j++;
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}
}