/*******************************************************************************
 * Copyright (c) 2011 University of Illinois All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html 
 * 	
 * Contributors: 
 * 	Albert L. Rossi - design and implementation
 ******************************************************************************/
package org.eclipse.ptp.rm.jaxb.core.rm;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.ptp.remote.core.IRemoteServices;
import org.eclipse.ptp.rm.core.rmsystem.AbstractRemoteResourceManagerConfiguration;
import org.eclipse.ptp.rm.jaxb.core.IJAXBNonNLSConstants;
import org.eclipse.ptp.rm.jaxb.core.IJAXBResourceManagerConfiguration;
import org.eclipse.ptp.rm.jaxb.core.JAXBCorePlugin;
import org.eclipse.ptp.rm.jaxb.core.data.ResourceManagerData;
import org.eclipse.ptp.rm.jaxb.core.data.Site;
import org.eclipse.ptp.rm.jaxb.core.messages.Messages;
import org.eclipse.ptp.rm.jaxb.core.utils.JAXBInitializationUtils;
import org.eclipse.ptp.rm.jaxb.core.variables.RMVariableMap;
import org.eclipse.ptp.services.core.IServiceProvider;

public class JAXBServiceProvider extends AbstractRemoteResourceManagerConfiguration implements IJAXBResourceManagerConfiguration,
		IJAXBNonNLSConstants {

	private ResourceManagerData rmdata;
	private RMVariableMap map;
	private IRemoteServices service;

	public JAXBServiceProvider() {
	}

	public JAXBServiceProvider(String namespace, IServiceProvider provider) {
		super(namespace, provider);
		setDescription(Messages.JAXBServiceProvider_defaultDescription);
	}

	public void clearReferences() {
		map.clear();
		map = null;
		rmdata = null;
		service = null;
	}

	public String getDefaultControlHost() {
		if (rmdata != null) {
			Site site = rmdata.getSiteData();
			URI defaultURI = null;
			if (site != null) {
				try {
					defaultURI = new URI(site.getControlConnection());
					if (defaultURI != null) {
						return defaultURI.getHost();
					}
				} catch (URISyntaxException t) {
					JAXBCorePlugin.log(t);
				}
			}
		}
		return ZEROSTR;
	}

	public String getDefaultControlPath() {
		if (rmdata != null) {
			Site site = rmdata.getSiteData();
			URI defaultURI = null;
			if (site != null) {
				try {
					defaultURI = new URI(site.getControlConnection());
					if (defaultURI != null) {
						return defaultURI.getPath();
					}
				} catch (URISyntaxException t) {
					JAXBCorePlugin.log(t);
				}
			}
		}
		return ZEROSTR;
	}

	public String getDefaultControlPort() {
		if (rmdata != null) {
			Site site = rmdata.getSiteData();
			URI defaultURI = null;
			if (site != null) {
				try {
					defaultURI = new URI(site.getControlConnection());
					if (defaultURI != null) {
						int p = defaultURI.getPort();
						if (p != -1) {
							return ZEROSTR + p;
						}
					}
				} catch (URISyntaxException t) {
					JAXBCorePlugin.log(t);
				}
			}
		}
		return ZEROSTR;
	}

	public String getDefaultMonitorHost() {
		if (rmdata != null) {
			Site site = rmdata.getSiteData();
			URI defaultURI = null;
			if (site != null) {
				try {
					defaultURI = new URI(site.getMonitorServerInstall());
					if (defaultURI != null) {
						return defaultURI.getHost();
					}
				} catch (URISyntaxException t) {
					JAXBCorePlugin.log(t);
				}
			}
		}
		return ZEROSTR;
	}

	public String getDefaultMonitorPath() {
		if (rmdata != null) {
			Site site = rmdata.getSiteData();
			URI defaultURI = null;
			if (site != null) {
				try {
					String uri = site.getMonitorServerInstall();
					if (uri != null && uri.length() > 0) {
						defaultURI = new URI(site.getMonitorServerInstall());
						return defaultURI.getPath();
					}
				} catch (URISyntaxException t) {
					JAXBCorePlugin.log(t);
				}
			}
		}
		return ZEROSTR;
	}

	public String getDefaultMonitorPort() {
		if (rmdata != null) {
			Site site = rmdata.getSiteData();
			URI defaultURI = null;
			if (site != null) {
				try {
					defaultURI = new URI(site.getMonitorServerInstall());
					int p = defaultURI.getPort();
					if (p != -1) {
						return ZEROSTR + p;
					}
				} catch (URISyntaxException t) {
					JAXBCorePlugin.log(t);
				}
			}
		}
		return ZEROSTR;
	}

	public String[] getExternalRMInstanceXMLLocations() {
		String list = getString(EXTERNAL_RM_XSD_PATHS, ZEROSTR);
		return list.split(CM);
	}

	public ResourceManagerData getResourceManagerData() {
		return rmdata;
	}

	@Override
	public String getResourceManagerId() {
		return getId();
	}

	public URL getRMConfigurationURL() {
		String loc = getString(RM_XSD_URL, ZEROSTR);
		if (ZEROSTR.equals(loc)) {
			return null;
		}
		try {
			return new URL(loc);
		} catch (MalformedURLException e) {
			return null;
		}
	}

	public IRemoteServices getService() {
		return service;
	}

	public void realizeRMDataFromXML() throws Throwable {
		URL location = getRMConfigurationURL();
		if (location == null) {
			rmdata = null;
		} else {
			rmdata = JAXBInitializationUtils.initializeRMData(location);
		}
	}

	public void setActive() throws Throwable {
		map = RMVariableMap.setActiveInstance(map);
		if (!map.isInitialized()) {
			if (rmdata == null) {
				realizeRMDataFromXML();
			}
			if (rmdata == null) {
				throw new InstantiationError(Messages.FailedToCreateRmData);
			}
			JAXBInitializationUtils.initializeMap(rmdata, map);

		}
	}

	public void setDefaultNameAndDesc() {
		String name = getName();
		if (name == null) {
			name = JAXB;
		}
		String conn = getConnectionName();
		if (conn != null && !conn.equals(ZEROSTR)) {
			name += AMP + conn;
		}
		setName(name);
		setDescription(Messages.JAXBServiceProvider_defaultDescription);
	}

	public void setExternalRMInstanceXMLLocations(String[] locations) {
		if (locations == null || locations.length == 0) {
			putString(EXTERNAL_RM_XSD_PATHS, ZEROSTR);
		} else {
			StringBuffer list = new StringBuffer(locations[0]);
			for (int i = 1; i < locations.length; i++) {
				list.append(CM).append(locations[i]);
			}
			putString(EXTERNAL_RM_XSD_PATHS, list.toString());
		}
	}

	public void setRMConfigurationURL(URL location) {
		URL current = getRMConfigurationURL();
		if (location != null && current != location) {
			String url = location.toExternalForm();
			putString(RM_XSD_URL, url);
			clearRMData();
		}
	}

	public void setService(IRemoteServices service) {
		this.service = service;
	}

	// @Override
	protected void clearRMData() {
		rmdata = null;
		setRemoteServicesId(null);
		setConnectionName(null);
		setInvocationOptions(ZEROSTR);
		setLocalAddress(ZEROSTR);
	}
}