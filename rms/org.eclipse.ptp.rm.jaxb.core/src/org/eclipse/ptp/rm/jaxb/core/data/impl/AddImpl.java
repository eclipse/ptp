/*******************************************************************************
 * Copyright (c) 2011 University of Illinois All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html 
 * 	
 * Contributors: 
 * 	Albert L. Rossi - design and implementation
 ******************************************************************************/
package org.eclipse.ptp.rm.jaxb.core.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ptp.rm.jaxb.core.data.Add;
import org.eclipse.ptp.rm.jaxb.core.data.Entry;

public class AddImpl extends AbstractAssign {

	private final List<Entry> entries;

	public AddImpl(String uuid, Add add) {
		this.uuid = uuid;
		field = add.getField();
		entries = add.getEntry();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object[] getValue(Object previous, String[] values) throws Throwable {
		List<String> list = null;
		if (previous != null && previous instanceof List<?>) {
			list = (List<String>) previous;
		} else {
			list = new ArrayList<String>();
		}

		if (!entries.isEmpty()) {
			for (Entry e : entries) {
				Object v = getValue(e, values);
				if (v != null) {
					list.add(v.toString());
				}
			}
		}
		return new Object[] { list };
	}
}
