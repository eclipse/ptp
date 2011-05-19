/*******************************************************************************
 * Copyright (c) 2011 University of Illinois All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html 
 * 	
 * Contributors: 
 * 	Albert L. Rossi - design and implementation
 ******************************************************************************/
package org.eclipse.ptp.rm.jaxb.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.ptp.rm.core.rmsystem.AbstractRemoteResourceManagerConfiguration;
import org.eclipse.ptp.rm.jaxb.core.data.ResourceManagerData;
import org.eclipse.ptp.rm.jaxb.core.messages.Messages;
import org.eclipse.ptp.services.core.IServiceProvider;

/**
 * Configuration object used for persisting values between sessions. Also
 * contains (in memory) the JAXB data object tree and the active instance of the
 * environment map.<br>
 * <br>
 * There are actually three such configurations associated with a JAXB resource
 * manager instance: the base configuration, and the control and monitor
 * configurations. The latter two contain references to their parent base
 * provider. <br>
 * This abstract class provides the access and construction functionality for
 * the data tree and the variable map.
 * 
 * @author arossi
 * 
 */
public abstract class AbstractJAXBResourceManagerConfiguration extends AbstractRemoteResourceManagerConfiguration implements
		IJAXBResourceManagerConfiguration {

	protected ResourceManagerData rmdata;
	protected IVariableMap map;

	/**
	 * @param namespace
	 *            base, control or monitor
	 * @param provider
	 *            base provider configuration
	 */
	protected AbstractJAXBResourceManagerConfiguration(String namespace, IServiceProvider provider) {
		super(namespace, provider);
	}

	/*
	 * Clears in-memory objects (non-Javadoc)
	 * 
	 * @see org.eclipse.ptp.rm.jaxb.core.IJAXBResourceManagerConfiguration#
	 * clearReferences()
	 */
	public void clearReferences() {
		map.clear();
		map = null;
		clearRMData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ptp.rm.jaxb.core.IJAXBResourceManagerConfiguration#
	 * getResourceManagerData()
	 */
	public ResourceManagerData getResourceManagerData() throws Throwable {
		if (rmdata == null) {
			realizeRMDataFromXML();
		}
		if (rmdata == null) {
			throw new InstantiationError(Messages.FailedToCreateRmData);
		}
		return rmdata;
	}

	/*
	 * Called by the service selector. (non-Javadoc)
	 * 
	 * @see org.eclipse.ptp.rm.jaxb.core.IJAXBResourceManagerConfiguration#
	 * setRMConfigurationURL(java.net.URL)
	 */
	public void setRMConfigurationURL(URL location) {
		URL current = getRMConfigurationURL();
		if (location != null && current != location) {
			String url = location.toExternalForm();
			putString(JAXBCoreConstants.RM_XSD_URL, url);
			clearRMData();
		}
	}

	/**
	 * Nulls out the tree as well as related service ids.
	 */
	private void clearRMData() {
		rmdata = null;
		setRemoteServicesId(null);
		setConnectionName(null);
		setInvocationOptions(JAXBCoreConstants.ZEROSTR);
		setLocalAddress(JAXBCoreConstants.ZEROSTR);
	}

	/**
	 * @return the location of the configuration XML used to construct the data
	 *         tree.
	 */
	private URL getRMConfigurationURL() {
		String loc = getString(JAXBCoreConstants.RM_XSD_URL, JAXBCoreConstants.ZEROSTR);
		if (JAXBCoreConstants.ZEROSTR.equals(loc)) {
			return null;
		}
		try {
			return new URL(loc);
		} catch (MalformedURLException e) {
			return null;
		}
	}

	/**
	 * Unmarshals the XML into the JAXB data tree.
	 * 
	 * @throws unmarshaling
	 *             exceptions
	 */
	private void realizeRMDataFromXML() throws Throwable {
		URL location = getRMConfigurationURL();
		if (location == null) {
			rmdata = null;
		} else {
			rmdata = JAXBInitializationUtils.initializeRMData(location);
		}
	}

}