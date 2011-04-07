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

import org.eclipse.ptp.rm.jaxb.core.IAssign;
import org.eclipse.ptp.rm.jaxb.core.IJAXBNonNLSConstants;
import org.eclipse.ptp.rm.jaxb.core.data.Match;
import org.eclipse.ptp.rm.jaxb.core.data.Regex;

public class MatchImpl implements IJAXBNonNLSConstants {

	private RegexImpl regex;
	private final TargetImpl target;
	private List<IAssign> assign;
	private final boolean moveToTop;
	private boolean matched;

	public MatchImpl(String uuid, Match match, TargetImpl target) {
		this.target = target;
		this.moveToTop = match.isMoveToTop();
		this.matched = false;

		Regex r = match.getExpression();
		if (r != null) {
			regex = new RegexImpl(r);
		}

		List<Object> assign = match.getAddOrAppendOrPut();
		if (!assign.isEmpty()) {
			this.assign = new ArrayList<IAssign>();
			for (Object o : assign) {
				AbstractAssign.add(uuid, o, this.assign);
			}
		}
	}

	public void clear() {
		matched = false;
	}

	public synchronized int doMatch(String sequence) throws Throwable {
		int end = 0;
		String[] tokens = null;

		if (regex == null) {
			matched = true;
			return sequence.length();
		} else {
			tokens = regex.getMatched(sequence);
			if (tokens == null) {
				return end;
			}
			/*
			 * return pos of the unmatched remainder
			 */
			matched = true;
			end = regex.getLastChar();
		}

		if (target == null || assign == null) {
			return end;
		}

		for (IAssign a : assign) {
			Object t = target.getTarget(a);
			a.setTarget(t);
			a.assign(tokens);
		}

		return end;
	}

	public boolean getMatched() {
		return matched;
	}

	public boolean getMoveToTop() {
		return moveToTop;
	}

	public RegexImpl getRegex() {
		return regex;
	}
}