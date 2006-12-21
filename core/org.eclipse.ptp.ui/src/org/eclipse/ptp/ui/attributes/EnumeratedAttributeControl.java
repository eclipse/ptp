/*******************************************************************************
 * Copyright (c) 2006 The Regents of the University of California. 
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
/**
 * 
 */
package org.eclipse.ptp.ui.attributes;

import org.eclipse.ptp.core.attributes.EnumeratedAttribute;
import org.eclipse.ptp.core.attributes.IAttribute;
import org.eclipse.ptp.core.attributes.IAttribute.IllegalValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;

/**
 * @author rsqrd
 *
 */
public class EnumeratedAttributeControl extends AbstractAttributeControl {

	/**
	 * @author rsqrd
	 *
	 */
	public class EnumSelectionListener implements SelectionListener {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent e) {
			final Control control = getControl();
			int selected = -1;
			if (control instanceof List) {
				List list = (List) control;
				selected = list.getSelectionIndex();
			}
			else if (control instanceof Combo) {
				Combo combo = (Combo) control;
				selected = combo.getSelectionIndex();
			}
			try {
				attribute.setValueIndex(selected);
			} catch (IllegalValue exc) {
				// shouldn't happen
				throw new RuntimeException(exc);
			}
		}

	}

	private final EnumeratedAttribute attribute;
	private final SelectionListener listener = new EnumSelectionListener();
	private int initialSelection;

	/**
	 * @param parent
	 * @param style
	 */
	public EnumeratedAttributeControl(Composite parent, int style, EnumeratedAttribute attribute) {
		super(parent, style);
		this.attribute = attribute;
		initialSelection = attribute.getValueIndex();
		// should always be valid
		setValid(true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ptp.ui.attributes.AbstractAttributeControl#getAttribute()
	 */
	public IAttribute getAttribute() {
		return attribute;
	}

	public String getControlText() {
		// same as the attribute value,
		// since it is always valid
		return attribute.getStringRep();
	}

	@Override
	public void resetToInitialValue() {
		setSelection(initialSelection);
	}

	@Override
	public void setCurrentToInitialValue() {
		initialSelection = attribute.getValueIndex();
	}

	public void setValue(String value) throws IllegalValue {
		EnumeratedAttribute newAttr = attribute.create(value);
		setSelection(newAttr.getValueIndex());
	}

	private void setSelection(int selection) {
		final Control control = getControl();
		if (control instanceof List) {
			List list = (List) control;
			list.setSelection(selection);
		}
		else if (control instanceof Combo) {
			Combo combo = (Combo) control;
			combo.select(selection);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ptp.ui.attributes.AbstractAttributeControl#doCreateControl(org.eclipse.swt.widgets.Composite, int)
	 */
	protected Control doCreateControl(Composite parent, int style) {
		final String[] items = attribute.getEnumerations().toArray(new String[0]);
		Control control = null;
		if ((style & SWT.RADIO) != 0) {
			
		}
		else if ((style & SWT.DROP_DOWN) != 0) {
			Combo combo = new Combo(parent, style | SWT.READ_ONLY);
			combo.setItems(items);
			combo.select(attribute.getValueIndex());
			combo.addSelectionListener(listener);
			control = combo;
		}
		else {
			List list = new List(parent, style | SWT.SINGLE);
			list.setItems(items);
			list.setSelection(attribute.getValueIndex());
			list.addSelectionListener(listener);
			control = list;
		}
		return control;
	}

}
