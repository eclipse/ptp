/*******************************************************************************
 * Copyright (c) 2011 University of Illinois All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html 
 * 	
 * Contributors: 
 * 	Albert L. Rossi - design and implementation
 ******************************************************************************/
package org.eclipse.ptp.rm.jaxb.ui.util;

import java.util.List;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ICheckable;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.ptp.rm.jaxb.core.data.AttributeViewer;
import org.eclipse.ptp.rm.jaxb.core.data.CompositeDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.FillLayoutDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.FormAttachmentDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.FormDataDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.FormLayoutDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.GridDataDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.GridLayoutDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.LayoutDataDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.LayoutDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.RowDataDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.RowLayoutDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.TabFolderDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.TabItemDescriptor;
import org.eclipse.ptp.rm.jaxb.core.data.ViewerItems;
import org.eclipse.ptp.rm.jaxb.core.data.Widget;
import org.eclipse.ptp.rm.jaxb.core.variables.RMVariableMap;
import org.eclipse.ptp.rm.jaxb.ui.IJAXBUINonNLSConstants;
import org.eclipse.ptp.rm.jaxb.ui.data.AttributeViewerCellData;
import org.eclipse.ptp.rm.jaxb.ui.data.AttributeViewerChildNodeData;
import org.eclipse.ptp.rm.jaxb.ui.data.AttributeViewerData;
import org.eclipse.ptp.rm.jaxb.ui.data.AttributeViewerMap;
import org.eclipse.ptp.rm.jaxb.ui.data.AttributeViewerNodeData;
import org.eclipse.ptp.rm.jaxb.ui.data.AttributeViewerRowData;
import org.eclipse.ptp.rm.jaxb.ui.data.WidgetMap;
import org.eclipse.ptp.rm.jaxb.ui.launch.JAXBRMConfigurableAttributesTab;
import org.eclipse.ptp.rm.jaxb.ui.messages.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;

public class LaunchTabBuilder implements IJAXBUINonNLSConstants {

	private final JAXBRMConfigurableAttributesTab tab;
	private WidgetMap widgetMap;
	private AttributeViewerMap viewerMap;

	public LaunchTabBuilder(JAXBRMConfigurableAttributesTab tab) {
		this.tab = tab;
	}

	public void build(Composite parent) throws Throwable {
		List<Object> top = tab.getController().getTabFolderOrComposite();
		for (Object o : top) {
			if (o instanceof CompositeDescriptor) {
				addComposite((CompositeDescriptor) o, parent);
			} else if (o instanceof TabFolderDescriptor) {
				addFolder((TabFolderDescriptor) o, parent);
			}
		}
	}

	private void addAttributeViewer(AttributeViewer descriptor, Composite parent) {
		Layout layout = createLayout(descriptor.getLayout());
		Object data = createLayoutData(descriptor.getLayoutData());
		int style = WidgetBuilderUtils.getStyle(descriptor.getStyle());
		Button showHide = WidgetBuilderUtils.createCheckButton(parent, Messages.ToggleShowHideSelectedAttributes, null);
		ColumnViewer viewer = null;
		if (TABLE.equals(descriptor.getType())) {
			viewer = addCheckboxTableViewer(parent, data, layout, style, descriptor);
		} else if (TREE.equals(descriptor.getType())) {
			viewer = addCheckboxTreeViewer(parent, data, layout, style, descriptor);
		}
		addRows(viewer, descriptor);
		addToggleShowHideSelected(showHide, viewer);
		addToViewerMap(viewer, descriptor);
	}

	private ColumnViewer addCheckboxTableViewer(Composite parent, Object data, Layout layout, int style, AttributeViewer descriptor) {
		style |= (SWT.CHECK | SWT.FULL_SELECTION);
		Table t = WidgetBuilderUtils.createTable(parent, style, data);
		CheckboxTableViewer viewer = new CheckboxTableViewer(t);
		WidgetBuilderUtils.setupAttributeTable(viewer, WidgetBuilderUtils.getColumnDescriptors(descriptor), null,
				descriptor.isSort(), descriptor.isTooltip());
		return viewer;
	}

	private ColumnViewer addCheckboxTreeViewer(Composite parent, Object data, Layout layout, int style, AttributeViewer descriptor) {
		style |= (SWT.CHECK | SWT.FULL_SELECTION);
		Tree t = WidgetBuilderUtils.createTree(parent, style, data);
		CheckboxTreeViewer viewer = new CheckboxTreeViewer(t);
		WidgetBuilderUtils.setupAttributeTree(viewer, WidgetBuilderUtils.getColumnDescriptors(descriptor), null,
				descriptor.isSort(), descriptor.isTooltip());
		return viewer;
	}

	private Composite addComposite(CompositeDescriptor descriptor, Composite parent) {
		Layout layout = createLayout(descriptor.getLayout());
		Object data = createLayoutData(descriptor.getLayoutData());
		int style = WidgetBuilderUtils.getStyle(descriptor.getStyle());
		Composite composite = null;
		if (descriptor.isGroup()) {
			composite = WidgetBuilderUtils.createGroup(parent, style, layout, data, descriptor.getTitle());
		} else {
			composite = WidgetBuilderUtils.createComposite(parent, style, layout, data);
		}
		List<Object> widget = descriptor.getTabFolderOrCompositeOrWidget();
		for (Object o : widget) {
			if (o instanceof TabFolderDescriptor) {
				addFolder((TabFolderDescriptor) o, composite);
			} else if (o instanceof CompositeDescriptor) {
				addComposite((CompositeDescriptor) o, composite);
			} else if (o instanceof Widget) {
				addWidget((Widget) o, composite);
			} else if (o instanceof AttributeViewer) {
				addAttributeViewer((AttributeViewer) o, composite);
			}
		}
		String color = descriptor.getBackground();
		if (color != null) {
			composite.setBackground(WidgetBuilderUtils.getColor(color));
		}
		color = descriptor.getForeground();
		if (color != null) {
			composite.setBackground(WidgetBuilderUtils.getColor(color));
		}
		return composite;
	}

	private TabFolder addFolder(TabFolderDescriptor descriptor, Composite parent) {
		TabFolder folder = new TabFolder(parent, WidgetBuilderUtils.getStyle(descriptor.getStyle()));
		Layout layout = createLayout(descriptor.getLayout());
		if (layout != null) {
			folder.setLayout(layout);
		}
		Object data = createLayoutData(descriptor.getLayoutData());
		if (data != null) {
			folder.setLayoutData(data);
		}
		String tt = descriptor.getTooltip();
		if (tt != null) {
			folder.setToolTipText(tt);
		}
		List<TabItemDescriptor> items = descriptor.getItem();
		int index = 0;
		for (TabItemDescriptor i : items) {
			addItem(folder, i, index++);
		}

		String color = descriptor.getBackground();
		if (color != null) {
			folder.setBackground(WidgetBuilderUtils.getColor(color));
		}
		color = descriptor.getForeground();
		if (color != null) {
			folder.setBackground(WidgetBuilderUtils.getColor(color));
		}
		return folder;
	}

	private void addItem(TabFolder folder, TabItemDescriptor descriptor, int index) {
		int style = WidgetBuilderUtils.getStyle(descriptor.getStyle());
		TabItem item = WidgetBuilderUtils.createTabItem(folder, style, descriptor.getTitle(), descriptor.getTooltip(), index);
		Composite control = WidgetBuilderUtils.createComposite(folder, 1);
		item.setControl(control);
		String tt = descriptor.getTooltip();
		if (tt != null) {
			item.setToolTipText(tt);
		}
		List<Object> children = descriptor.getCompositeOrTabFolderOrWidget();
		for (Object o : children) {
			if (o instanceof TabFolderDescriptor) {
				addFolder((TabFolderDescriptor) o, control);
			} else if (o instanceof CompositeDescriptor) {
				addComposite((CompositeDescriptor) o, control);
			} else if (o instanceof Widget) {
				addWidget((Widget) o, control);
			}
		}
	}

	private void addRows(ColumnViewer viewer, AttributeViewer descriptor) {
		RMVariableMap rmMap = RMVariableMap.getActiveInstance();
		AttributeViewerData data = new AttributeViewerData();
		ViewerItems items = descriptor.getItems();
		AttributeViewerCellData row = null;
		if (items.isAllPredefined()) {
			for (Object o : rmMap.getVariables().values()) {
				row = getCellViewer(viewer, o);
				if (row.isVisible()) {
					data.addRow(row);
				}
			}
		} else {
			List<String> refs = items.getRef();
			for (String ref : refs) {
				Object o = rmMap.getVariables().get(ref);
				if (o != null) {
					row = getCellViewer(viewer, o);
					if (row.isVisible()) {
						data.addRow(row);
					}
				}
			}
		}
		if (items.isAllDiscovered()) {
			for (Object o : rmMap.getDiscovered().values()) {
				row = getCellViewer(viewer, o);
				if (row.isVisible()) {
					data.addRow(row);
				}
			}
		}
		viewer.setInput(data);
		ICheckable checkable = (ICheckable) viewer;
		for (AttributeViewerCellData rd : data.getRows()) {
			checkable.setChecked(rd, rd.isSelected());
		}
	}

	private void addToggleShowHideSelected(Button checkbutton, final ColumnViewer viewer) {
		checkbutton.addSelectionListener(new SelectionListener() {
			private final ViewerFilter filter = new ViewerFilter() {
				@Override
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof AttributeViewerCellData) {
						return ((ICheckable) viewer).getChecked(element);
					} else if (element instanceof AttributeViewerChildNodeData) {
						Object parent = ((AttributeViewerChildNodeData) element).getParent();
						return ((ICheckable) viewer).getChecked(parent);
					}
					return false;
				}
			};

			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			public void widgetSelected(SelectionEvent e) {
				Button b = (Button) e.getSource();
				if (!b.getSelection()) {
					viewer.addFilter(filter);
				} else {
					viewer.removeFilter(filter);
				}
				WidgetActionUtils.refreshViewer(viewer);
			}
		});
		checkbutton.setSelection(true);
	}

	private void addToViewerMap(ColumnViewer viewer, AttributeViewer descriptor) {
		if (viewerMap == null) {
			viewerMap = new AttributeViewerMap();
			tab.getHandlers().add(viewerMap);
		}
		viewerMap.add(viewer, descriptor);
	}

	private void addToWidgetMap(Control control, Widget widget) {
		if (widgetMap == null) {
			widgetMap = new WidgetMap();
			tab.getHandlers().add(widgetMap);
		}
		widgetMap.add(control, widget);
	}

	private Control addWidget(Widget widget, Composite parent) {
		Control control = new WidgetBuilder(widget, RMVariableMap.getActiveInstance(), tab).createControl(parent);
		addToWidgetMap(control, widget);
		return control;
	}

	private Layout createLayout(LayoutDescriptor layout) {
		if (layout != null) {
			if (layout.getFillLayout() != null) {
				FillLayoutDescriptor fillLayout = layout.getFillLayout();
				return WidgetBuilderUtils.createFillLayout(fillLayout.getType(), fillLayout.getMarginHeight(),
						fillLayout.getMarginWidth(), fillLayout.getSpacing());
			} else if (layout.getRowLayout() != null) {
				RowLayoutDescriptor rowLayout = layout.getRowLayout();
				return WidgetBuilderUtils.createRowLayout(rowLayout.isCenter(), rowLayout.isFill(), rowLayout.isJustify(),
						rowLayout.isPack(), rowLayout.getMarginHeight(), rowLayout.getMarginWidth(), rowLayout.getMarginTop(),
						rowLayout.getMarginBottom(), rowLayout.getMarginLeft(), rowLayout.getMarginRight(), rowLayout.getSpacing());
			} else if (layout.getGridLayout() != null) {
				GridLayoutDescriptor gridLayout = layout.getGridLayout();
				return WidgetBuilderUtils.createGridLayout(gridLayout.getNumColumns(), gridLayout.isMakeColumnsEqualWidth(),
						gridLayout.getHorizontalSpacing(), gridLayout.getVerticalSpacing(), gridLayout.getMarginWidth(),
						gridLayout.getMarginHeight(), gridLayout.getMarginLeft(), gridLayout.getMarginRight(),
						gridLayout.getMarginTop(), gridLayout.getMarginBottom());
			} else if (layout.getFormLayout() != null) {
				FormLayoutDescriptor formLayout = layout.getFormLayout();
				return WidgetBuilderUtils.createFormLayout(formLayout.getMarginHeight(), formLayout.getMarginWidth(),
						formLayout.getMarginTop(), formLayout.getMarginBottom(), formLayout.getMarginLeft(),
						formLayout.getMarginRight(), formLayout.getSpacing());
			}
		}
		return null;
	}

	private AttributeViewerCellData getCellViewer(ColumnViewer viewer, Object data) {
		if (viewer instanceof TreeViewer) {
			Object[] properties = viewer.getColumnProperties();
			return new AttributeViewerNodeData(data, properties.length == 2);
		} else {
			return new AttributeViewerRowData(data);
		}
	}

	static Object createLayoutData(LayoutDataDescriptor layoutData) {
		if (layoutData != null) {
			if (layoutData.getRowData() != null) {
				RowDataDescriptor rowData = layoutData.getRowData();
				return WidgetBuilderUtils.createRowData(rowData.getHeight(), rowData.getWidth(), rowData.isExclude());
			} else if (layoutData.getGridData() != null) {
				GridDataDescriptor gridData = layoutData.getGridData();
				int style = WidgetBuilderUtils.getStyle(gridData.getStyle());
				int hAlign = WidgetBuilderUtils.getStyle(gridData.getHorizontalAlign());
				int vAlign = WidgetBuilderUtils.getStyle(gridData.getVerticalAlign());
				return WidgetBuilderUtils.createGridData(style, gridData.isGrabExcessHorizontal(), gridData.isGrabExcessVertical(),
						gridData.getWidthHint(), gridData.getHeightHint(), gridData.getMinWidth(), gridData.getMinHeight(),
						gridData.getHorizontalSpan(), gridData.getVerticalSpan(), hAlign, vAlign);

			} else if (layoutData.getFormData() != null) {
				FormDataDescriptor formData = layoutData.getFormData();
				FormAttachment top = null;
				FormAttachment bottom = null;
				FormAttachment left = null;
				FormAttachment right = null;
				FormAttachmentDescriptor fad = formData.getTop();
				if (fad != null) {
					top = WidgetBuilderUtils.createFormAttachment(fad.getAlignment(), fad.getDenominator(), fad.getNumerator(),
							fad.getOffset());
				}
				fad = formData.getBottom();
				if (fad != null) {
					bottom = WidgetBuilderUtils.createFormAttachment(fad.getAlignment(), fad.getDenominator(), fad.getNumerator(),
							fad.getOffset());
				}
				fad = formData.getLeft();
				if (fad != null) {
					left = WidgetBuilderUtils.createFormAttachment(fad.getAlignment(), fad.getDenominator(), fad.getNumerator(),
							fad.getOffset());
				}
				fad = formData.getRight();
				if (fad != null) {
					right = WidgetBuilderUtils.createFormAttachment(fad.getAlignment(), fad.getDenominator(), fad.getNumerator(),
							fad.getOffset());
				}
				return WidgetBuilderUtils.createFormData(formData.getHeight(), formData.getWidth(), top, bottom, left, right);
			}
		}
		return null;
	}
}
