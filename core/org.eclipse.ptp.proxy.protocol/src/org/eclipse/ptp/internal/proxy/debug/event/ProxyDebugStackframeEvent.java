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

package org.eclipse.ptp.internal.proxy.debug.event;

import org.eclipse.ptp.proxy.debug.client.ProxyDebugStackFrame;
import org.eclipse.ptp.proxy.debug.event.AbstractProxyDebugEvent;
import org.eclipse.ptp.proxy.debug.event.IProxyDebugStackframeEvent;

public class ProxyDebugStackframeEvent extends AbstractProxyDebugEvent implements IProxyDebugStackframeEvent {
	private ProxyDebugStackFrame[] frames;

	public ProxyDebugStackframeEvent(int transID, String bits, ProxyDebugStackFrame[] frames) {
		super(transID, EVENT_DBG_FRAMES, bits);
		this.frames = frames;
	}

	public ProxyDebugStackFrame[] getFrames() {
		return this.frames;
	}

	@Override
	public String toString() {
		String res = "EVENT_DBG_FRAMES transid=" + getTransactionID() + " " + this.getBitSet().toString(); //$NON-NLS-1$ //$NON-NLS-2$
		for (int i = 0; i < frames.length; i++) {
			res += "\n " + frames[i].toString(); //$NON-NLS-1$
		}
		return res;
	}
}
