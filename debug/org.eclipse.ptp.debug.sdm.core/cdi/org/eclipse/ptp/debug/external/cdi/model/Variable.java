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
/*******************************************************************************
 * Copyright (c) 2000, 2004 QNX Software Systems and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     QNX Software Systems - Initial API and implementation
 *******************************************************************************/
package org.eclipse.ptp.debug.external.cdi.model;

import org.eclipse.cdt.debug.core.cdi.CDIException;
import org.eclipse.cdt.debug.core.cdi.model.ICDIValue;
import org.eclipse.cdt.debug.core.cdi.model.ICDIVariable;
import org.eclipse.cdt.debug.core.cdi.model.type.ICDIIntType;
import org.eclipse.cdt.debug.core.cdi.model.type.ICDIType;
import org.eclipse.ptp.debug.external.cdi.model.type.IntValue;

/**
 */
public abstract class Variable extends VariableDescriptor implements ICDIVariable {
	
	Value value;
	
	String fValue;
	
	public Variable(VariableDescriptor obj, String val) {
		super(obj);
		fValue = val;
	}

	public Variable(Target target, Thread thread, StackFrame frame, String n, String q, int pos, int depth, String val) {
		super(target, thread, frame, n, q, pos, depth);
		fValue = val;
	}
	
	public void setValue(ICDIValue value) throws CDIException {
		System.out.println("Variable.setValue()");
	}
	
	public void setValue(String expression) throws CDIException {
		System.out.println("Variable.setValue()");
	}
	
	public ICDIValue getValue() throws CDIException {
		System.out.println("Variable.getValue()");
		if (value == null) {
			ICDIType t = getType();
			if (t instanceof ICDIIntType) {
				value = new IntValue(this);
			} else {
				value = new Value(this);
			}
		}
		return value;
	}
	
	public boolean isEditable() throws CDIException {
		System.out.println("Variable.isEditable()");
		return false;
	}
	
	public void setFormat(int format) throws CDIException {
		System.out.println("Variable.setFormat()");
	}
	
	public boolean equals(ICDIVariable var) {
		System.out.println("Variable.equals()");
		if (var instanceof Variable) {
			Variable variable = (Variable) var;
			return fName.equals(variable.fName);
		}
		return super.equals(var);
	}

	public void dispose() throws CDIException {
		System.out.println("Variable.dispose()");
	}
}
