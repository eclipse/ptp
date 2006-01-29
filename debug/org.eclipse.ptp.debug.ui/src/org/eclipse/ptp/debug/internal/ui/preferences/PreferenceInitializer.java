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
package org.eclipse.ptp.debug.internal.ui.preferences;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ptp.debug.core.IPDebugConstants;
import org.eclipse.ptp.debug.core.PTPDebugCorePlugin;
import org.eclipse.ptp.debug.ui.PTPDebugUIPlugin;

/**
 * @author Clement chu
 * 
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		IPreferenceStore store = PTPDebugUIPlugin.getDefault().getPreferenceStore();
		URL url = Platform.find(Platform.getBundle(PTPDebugCorePlugin.PLUGIN_ID), new Path("/"));
		if (url != null) {
			try {
				File path = new File(Platform.asLocalURL(url).getPath());
				String ipath = path.getAbsolutePath();
				int idx = ipath.indexOf(PTPDebugCorePlugin.PLUGIN_ID);
				String ipath2 = ipath.substring(0, idx) + "org.eclipse.ptp.debug.sdm/sdm";
				store.setDefault(IPDebugConstants.PREF_PTP_DEBUGGER_FILE, ipath2);
			} catch(IOException e) { 
			}
		}
		store.setDefault(IPDebugConstants.PREF_PTP_DEBUGGER_ARGS, IPDebugConstants.PREF_DEFAULT_DEUBGGER_ARGS);
		
		store.setDefault(IPDebugConstants.PREF_SHOW_FULL_PATHS, false);
		store.setDefault(IPDebugConstants.PREF_PTP_DEBUG_REGISTER_PROC_0, true);
	}
}
