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
package org.eclipse.ptp.ui.model.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.ptp.ui.model.IContainer;
import org.eclipse.ptp.ui.model.IElement;
import org.eclipse.ptp.ui.model.IElementSet;
import org.eclipse.ptp.ui.model.IElementHandler;

/**
 * @author clement chu
 *
 */
public class ElementHandler extends Container implements IElementHandler {
	protected List registerElements = new ArrayList();

	public ElementHandler() {
		super(null, SET_ROOT_ID, SET_ROOT_ID, false, IContainer.SET_TYPE);
		//create root 
		add(new ElementSet(this, SET_ROOT_ID, SET_ROOT_ID));
	}
	public IElementSet getSetRoot() {
		if (size() == 0)
			add(new ElementSet(this, SET_ROOT_ID, SET_ROOT_ID));
		
		return (IElementSet)get(SET_ROOT_ID);
	}
 	
	public void clearAll() {
		for (Iterator i=elementMap.values().iterator(); i.hasNext();) {
			((IContainer)i.next()).clearAll();
		}
		super.clearAll();
	}
	
	public IElement[] get() {
		return (IElement[])getSets();
	}		
	public IElementSet[] getSortedSets() {
		return (IElementSet[])getSorted();
	}
	public IElementSet[] getSets() {
		return (IElementSet[])elementMap.values().toArray(new IElementSet[elementMap.size()]);
	}
	public IElementSet getSet(String id) {
		return (IElementSet)get(id);
	}
	public IElementSet getSet(int index) {
		return (IElementSet)get(index);
	}
	public IElementSet[] getSetsWithElement(String id) {
		List aList = new ArrayList();
		IElementSet[] sets = getSortedSets();
		for (int i=0; i<sets.length; i++) {
			if (sets[i].contains(id))
				aList.add(sets[i]);
		}
		return (IElementSet[])aList.toArray(new IElementSet[aList.size()]);
	}

	public boolean containsRegisterElement(String eid) {
		return registerElements.contains(eid);
	}
	public void addRegisterElement(String eid) {
		if (!containsRegisterElement(eid))
			registerElements.add(eid);
	}
	public void removeRegisterElement(String eid) {
		if (containsRegisterElement(eid))
			registerElements.remove(eid);
	}
	public String[] getRegisteredElementsID() {
		return (String[])registerElements.toArray(new String[registerElements.size()]);
	}
	public void removeAllRegisterElements() {
		registerElements.clear();
	}
	public int totalRegisterElements() {
		return registerElements.size();
	}
}
