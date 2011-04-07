/*******************************************************************************
 * Copyright (c) 2011 University of Illinois All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html 
 * 	
 * Contributors: 
 * 	Albert L. Rossi - design and implementation
 ******************************************************************************/
package org.eclipse.ptp.rm.jaxb.core.runnable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ptp.rm.jaxb.core.IJAXBNonNLSConstants;
import org.eclipse.ptp.rm.jaxb.core.JAXBCorePlugin;
import org.eclipse.ptp.rm.jaxb.core.data.Attribute;
import org.eclipse.ptp.rm.jaxb.core.data.ManagedFile;
import org.eclipse.ptp.rm.jaxb.core.data.ManagedFiles;
import org.eclipse.ptp.rm.jaxb.core.data.Property;
import org.eclipse.ptp.rm.jaxb.core.messages.Messages;
import org.eclipse.ptp.rm.jaxb.core.utils.CoreExceptionUtils;
import org.eclipse.ptp.rm.jaxb.core.utils.FileUtils;
import org.eclipse.ptp.rm.jaxb.core.utils.RemoteServicesDelegate;
import org.eclipse.ptp.rm.jaxb.core.variables.RMVariableMap;

/**
 * A managed file is a client-side file which needs to be moved to the resource
 * to which the job will be submitted.
 * 
 * @author arossi
 * 
 */
public class ManagedFilesJob extends Job implements IJAXBNonNLSConstants {

	private final String uuid;
	private final String sourceDir;
	private final String stagingDir;
	private final List<ManagedFile> files;
	private final RemoteServicesDelegate delegate;
	private boolean success;

	public ManagedFilesJob(String uuid, ManagedFiles files, RemoteServicesDelegate delegate) throws CoreException {
		super(Messages.ManagedFilesJob);
		this.uuid = uuid;
		this.delegate = delegate;
		String key = files.getFileSourceLocation();
		if (key == null) {
			sourceDir = System.getProperty(JAVA_TMP_DIR);
		} else {
			sourceDir = RMVariableMap.getActiveInstance().getString(uuid, key);
		}
		stagingDir = RMVariableMap.getActiveInstance().getString(uuid, files.getFileStagingLocation());
		this.files = files.getFile();
	}

	public boolean getSuccess() {
		return success;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		success = false;
		SubMonitor progress = SubMonitor.convert(monitor, files.size() * 10);
		/*
		 * for now we handle the files serially
		 */
		for (ManagedFile file : files) {
			try {
				File localFile = maybeWriteFile(file);
				progress.worked(5);
				/**
				 * no support for Windows as target ...
				 */
				String target = stagingDir + REMOTE_PATH_SEP + localFile.getName();
				copyFileToRemoteHost(localFile.getAbsolutePath(), target, progress);
				if (file.isDeleteAfterUse()) {
					localFile.delete();
				}
				Property p = new Property();
				p.setName(file.getName());
				if (delegate.getLocalFileManager() == delegate.getRemoteFileManager()) {
					p.setValue(new File(System.getProperty(JAVA_USER_HOME), target).getAbsolutePath());
				} else {
					p.setValue(target);
				}
				RMVariableMap.getActiveInstance().getVariables().put(p.getName(), p);
			} catch (Throwable t) {
				progress.done();
				return CoreExceptionUtils.getErrorStatus(Messages.ManagedFilesJobError, t);
			}
			progress.worked(5);
		}
		progress.done();
		success = true;
		return Status.OK_STATUS;
	}

	/*
	 * Copy local data from a path (can be a file or directory) from the local
	 * host to the remote host.
	 * 
	 * @param localPath
	 * 
	 * @param remotePath
	 * 
	 * @param configuration
	 * 
	 * @throws CoreException
	 */
	private void copyFileToRemoteHost(String localPath, String remotePath, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 15);
		try {
			progress.newChild(5);
			FileUtils.copy(delegate.getLocalFileManager(), localPath, delegate.getRemoteFileManager(), remotePath, progress);
		} finally {
			progress.done();
		}
	}

	private File maybeWriteFile(ManagedFile file) throws IOException, CoreException {
		String name = RMVariableMap.getActiveInstance().getString(uuid, file.getName());
		File localFile = new File(sourceDir, name);
		String contents = file.getContents();
		FileWriter fw = null;
		try {
			if (contents == null) {
				if (!localFile.exists() || !localFile.isFile()) {
					throw new FileNotFoundException(localFile.getAbsolutePath());
				}
			} else {
				if (file.isUniqueIdPrefix()) {
					localFile = new File(sourceDir, UUID.randomUUID() + name);
				}
				if (file.isResolveContents()) {
					contents = RMVariableMap.getActiveInstance().getString(uuid, contents);
				} else {
					/*
					 * magic to avoid attempted resolution of unknown shell
					 * variables
					 */
					int start = contents.indexOf(OPENVRM);
					int end = contents.length();
					if (start >= 0) {
						start += OPENVRM.length();
						end = contents.indexOf(PD);
						if (end < 0) {
							end = contents.indexOf(CLOSV);
						}
						String key = contents.substring(start, end);
						Object o = RMVariableMap.getActiveInstance().getVariables().get(key);
						if (o instanceof Property) {
							contents = String.valueOf(((Property) o).getValue());
						} else if (o instanceof Attribute) {
							contents = String.valueOf(((Attribute) o).getValue());
						}
					}
				}
				fw = new FileWriter(localFile, false);
				fw.write(contents);
				fw.flush();
			}
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException t) {
				JAXBCorePlugin.log(t);
			}
		}
		return localFile;
	}
}