/*******************************************************************************
 * Copyright (c) 2011 University of Tennessee and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Roland Schulz - initial API and implementation
 *******************************************************************************/

package org.eclipse.ptp.rdt.sync.core.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Random;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.ptp.internal.rdt.sync.git.core.GitRemoteSyncConnection;
import org.eclipse.ptp.rdt.sync.core.PreferenceSyncFileFilterStorage;
import org.eclipse.ptp.rdt.sync.core.SyncConfig;
import org.eclipse.ptp.rdt.sync.core.SyncConfigManager;
import org.eclipse.remote.core.IRemoteConnection;
import org.eclipse.remote.core.IRemoteConnectionManager;
import org.eclipse.remote.core.IRemoteConnectionWorkingCopy;
import org.eclipse.remote.core.IRemoteFileManager;
import org.eclipse.remote.core.IRemoteServices;
import org.eclipse.remote.core.RemoteServices;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;

@SuppressWarnings("restriction")
public class TemporaryGitRemoteSyncConnection extends ExternalResource {
	private GitRemoteSyncConnection fGITConn;
	private IRemoteConnection fRemoteConnection;
	private TemporaryFolder localFolder;
	private static Random random = new Random();
	private IRemoteFileManager fileManager;
	private final BasicGitSyncTests test;
	private String remoteFolder;
	private IRemoteConnectionManager connMgr;

	public TemporaryGitRemoteSyncConnection(BasicGitSyncTests basicGitSyncTests) {
		test = basicGitSyncTests;
	}

	@Override
	protected void before() throws Throwable {
		create();
	}

	@Override
	protected void after() {
		delete();
	}

	public GitRemoteSyncConnection getGITConn() {
		return fGITConn;
	}

	public TemporaryFolder getLocalFolder() {
		return localFolder;
	}

	public String getRemoteFolder() {
		return remoteFolder;
	}

	public IRemoteFileManager getFileManager() {
		return fileManager;
	}

	private void create() throws Exception {
		long n = random.nextInt(1000000);
		remoteFolder = test.remoteBaseDir + "/junit" + n;

		/* setup remote connection */
		IRemoteServices fRemoteServices;

		fRemoteServices = RemoteServices.getRemoteServices("org.eclipse.remote.JSch");
		assertNotNull(fRemoteServices);

		connMgr = fRemoteServices.getConnectionManager();
		assertNotNull(connMgr);

		// TODO: understand why it is causes problem when all connections are called the same. Should be fine because
		// connections are deleted. There seems to be a problem in RemoteTools with creating a new connection with the same name
		IRemoteConnectionWorkingCopy wc = connMgr.newConnection("test_connection" + n); //$NON-NLS-1$  
		wc.setAddress(test.host);
		wc.setUsername(test.username);
		wc.setPassword(test.password);
		fRemoteConnection = wc.save();
		assertNotNull(fRemoteConnection);

		if (!fRemoteConnection.isOpen()) {
			fRemoteConnection.open(null);
		}

		fileManager = fRemoteConnection.getFileManager();

		/* local folder */
		localFolder = new TemporaryFolder();
		localFolder.create();

		/* remote folder (just delete - is created by GitRemoteSyncConnection) */
		fileManager.getResource(remoteFolder).delete(EFS.NONE, null);

		SyncConfig syncConfig = SyncConfigManager.newConfig("tmp", "Git", fRemoteConnection, remoteFolder);
		PreferenceSyncFileFilterStorage fileFilter = new PreferenceSyncFileFilterStorage();
		fileFilter.loadBuiltInDefaultFilter();
		fGITConn = new GitRemoteSyncConnection(null, localFolder.getRoot().getPath(), syncConfig, fileFilter, null);
	}

	private void delete() {
		String failMessage = "";

		fGITConn.close();
		localFolder.delete();

		try {
			fileManager.getResource(remoteFolder).delete(EFS.NONE, null);
		} catch (Exception e) {
			e.printStackTrace();
			failMessage += e.getMessage(); // don't fail yet - try to clean up as much as possible
		}

		fRemoteConnection.close();
		try {
			connMgr.removeConnection(fRemoteConnection);
		} catch (Exception e) {
			e.printStackTrace();
			failMessage += e.getMessage(); // don't fail yet - try to clean up as much as possible
		}

		if (!failMessage.equals("")) {
			fail(failMessage);
		}
	}

	public IRemoteConnection getRemoteConn() {
		return fRemoteConnection;
	}
}
