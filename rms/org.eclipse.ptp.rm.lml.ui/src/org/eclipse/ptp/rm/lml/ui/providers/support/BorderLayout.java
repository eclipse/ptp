/**
 * Copyright (c) 2011 Forschungszentrum Juelich GmbH
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Claudia Knobloch,FZ Juelich
 */
package org.eclipse.ptp.rm.lml.ui.providers.support;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

public class BorderLayout extends Layout {
	public static class BorderData {
		public int field;

		public BorderData() {
			this.field = MFIELD;
		}

		public BorderData(int field) {
			this.field = field;
		}
	}

	public static final int NWFIELD = 0;
	public static final int NFIELD = 1;
	public static final int NEFIELD = 2;
	public static final int WFIELD = 3;
	public static final int MFIELD = 4;
	public static final int EFIELD = 5;
	public static final int SWFIELD = 6;
	public static final int SFIELD = 7;

	public static final int SEFIELD = 8;

	Point[] points;
	Control[] controls;

	int width;
	int height;

	private void getControlsAndPoints(Control[] children, boolean flushCache) {
		controls = new Control[9];
		points = new Point[9];
		for (final Control element : children) {

			final Object layoutData = element.getLayoutData();
			if (!(layoutData instanceof BorderData)) {
				continue;
			}
			final BorderData borderData = (BorderData) layoutData;
			if (borderData != null || (borderData.field < 0 || borderData.field > 8)) {
				controls[borderData.field] = element;
				points[borderData.field] = element.computeSize(SWT.DEFAULT, SWT.DEFAULT, flushCache);
			}
		}

		for (int i = 0; i < controls.length; i++) {
			final Control control = controls[i];
			if (control == null) {
				points[i] = new Point(0, 0);
			}
		}
	}

	private int max(int i1, int i2, int i3) {
		final int j = i1 >= i2 ? i1 : i2;
		return j >= i3 ? j : i3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.widgets.Layout#computeSize(org.eclipse.swt.widgets.Composite,
	 * int, int, boolean)
	 */
	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		if (flushCache || points == null) {
			getControlsAndPoints(composite.getChildren(), flushCache);
		}

		width = max(
				points[NWFIELD].x + points[NFIELD].x + points[NEFIELD].x,
				points[WFIELD].x + points[MFIELD].x + points[EFIELD].x,
				points[SWFIELD].x + points[SFIELD].x + points[SEFIELD].x);
		height = max(
				points[NWFIELD].y + points[NFIELD].y + points[NEFIELD].y,
				points[WFIELD].y + points[MFIELD].y + points[EFIELD].y,
				points[SWFIELD].y + points[SFIELD].y + points[SEFIELD].y);

		return new Point(wHint == SWT.DEFAULT ? width : wHint, hHint == SWT.DEFAULT ? height : hHint);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.widgets.Layout#layout(org.eclipse.swt.widgets.Composite,
	 * boolean)
	 */
	@Override
	protected void layout(Composite composite, boolean flushCache) {
		if (flushCache || points == null) {
			getControlsAndPoints(composite.getChildren(), flushCache);
		}
		final Rectangle clientArea = composite.getClientArea();

		if (controls[NWFIELD] != null) {
			controls[NWFIELD].setBounds(
					clientArea.x,
					clientArea.y,
					points[WFIELD].x,
					points[NFIELD].y);
		}
		if (controls[NFIELD] != null) {
			controls[NFIELD].setBounds(
					clientArea.x + points[WFIELD].x,
					clientArea.y,
					clientArea.width - points[WFIELD].x - points[EFIELD].x,
					points[NFIELD].y);
		}
		if (controls[NEFIELD] != null) {
			controls[NEFIELD].setBounds(
					clientArea.x + clientArea.width - points[EFIELD].x,
					clientArea.y,
					points[EFIELD].x,
					points[NFIELD].y);
		}
		if (controls[WFIELD] != null) {
			controls[WFIELD].setBounds(
					clientArea.x,
					clientArea.y + points[NFIELD].y,
					points[WFIELD].x,
					clientArea.height - points[NFIELD].y - points[SFIELD].y);
		}
		if (controls[MFIELD] != null) {
			controls[MFIELD].setBounds(
					clientArea.x + points[WFIELD].x,
					clientArea.y + points[NFIELD].y,
					clientArea.width - points[WFIELD].x - points[EFIELD].x,
					clientArea.height - points[NFIELD].y - points[SFIELD].y);
		}
		if (controls[EFIELD] != null) {
			controls[EFIELD].setBounds(
					clientArea.x + clientArea.width - points[EFIELD].x,
					clientArea.y + points[NFIELD].y,
					points[EFIELD].x,
					clientArea.height - points[NFIELD].y - points[SFIELD].y);
		}
		if (controls[SWFIELD] != null) {
			controls[SWFIELD].setBounds(
					clientArea.x,
					clientArea.y + clientArea.height - points[NFIELD].y,
					points[WFIELD].x,
					points[SFIELD].y);
		}
		if (controls[SFIELD] != null) {
			controls[SFIELD].setBounds(
					clientArea.x + points[WFIELD].x,
					clientArea.y + clientArea.height - points[SFIELD].y,
					clientArea.width - points[WFIELD].x - points[EFIELD].x,
					points[SFIELD].y);
		}
		if (controls[SEFIELD] != null) {
			controls[SEFIELD].setBounds(
					clientArea.x + clientArea.width - points[EFIELD].x,
					clientArea.y + clientArea.height - points[SFIELD].y,
					points[EFIELD].x,
					points[SFIELD].y);
		}

	}

}