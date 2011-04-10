/*******************************************************************************
 * Copyright (c) 2011 University of Illinois All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html 
 * 	
 * Contributors: 
 * 	Albert L. Rossi - design and implementation
 ******************************************************************************/
package org.eclipse.ptp.rm.jaxb.core.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.eclipse.ptp.rm.jaxb.core.IJAXBNonNLSConstants;
import org.eclipse.ptp.rm.jaxb.core.JAXBCorePlugin;
import org.eclipse.ptp.rm.jaxb.core.data.Attribute;
import org.eclipse.ptp.rm.jaxb.core.data.Control;
import org.eclipse.ptp.rm.jaxb.core.data.Property;
import org.eclipse.ptp.rm.jaxb.core.data.ResourceManagerData;
import org.eclipse.ptp.rm.jaxb.core.variables.RMVariableMap;
import org.xml.sax.SAXException;

/**
 * Convenience methods for validating and unmarshaling XML using JAXB.
 * 
 * @author arossi
 * 
 */
public class JAXBInitializationUtils implements IJAXBNonNLSConstants {

	private JAXBInitializationUtils() {
	}

	/**
	 * Retrieves Property and Attribute definitions from the data tree and adds
	 * them to the environment map.
	 * 
	 * @param rmData
	 *            the JAXB data tree
	 * @param instance
	 *            the active instance of the resource manager environment map
	 */
	public static void initializeMap(ResourceManagerData rmData, RMVariableMap instance) {
		Control control = rmData.getControlData();
		instance.clear();
		Map<String, Object> env = instance.getVariables();
		addProperties(env, control);
		addAttributes(env, control);
		instance.setInitialized(true);
	}

	/**
	 * Delegates to {@link #unmarshalResourceManagerData(URL)}
	 * 
	 * @param xml
	 *            location of the configuration file.
	 * @return the constructed data tree
	 * @throws IOException
	 * @throws SAXException
	 * @throws URISyntaxException
	 * @throws JAXBException
	 */
	public static ResourceManagerData initializeRMData(URL xml) throws IOException, SAXException, URISyntaxException, JAXBException {
		return unmarshalResourceManagerData(xml);
	}

	/**
	 * Validates the XML against the internal XSD for JAXB resource managers.
	 * 
	 * @param instance
	 *            location of the configuration file.
	 * @throws SAXException
	 *             if invalid
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void validate(URL instance) throws SAXException, IOException, URISyntaxException {
		URL xsd = JAXBCorePlugin.getResource(RM_XSD);
		SchemaFactory factory = SchemaFactory.newInstance(XMLSchema);
		Schema schema = factory.newSchema(xsd);
		Validator validator = schema.newValidator();
		Source source = new StreamSource(instance.openStream());
		validator.validate(source);
	}

	/**
	 * Adds the attributes.
	 * 
	 * @param env
	 *            the active instance of the resource manager environment map
	 * @param control
	 *            JAXB data subtree for control part of resource manager
	 */
	private static void addAttributes(Map<String, Object> env, Control control) {
		List<Attribute> jobAttributes = control.getAttribute();
		for (Attribute jobAttribute : jobAttributes) {
			String name = jobAttribute.getName();
			env.put(name, jobAttribute);
		}
	}

	/**
	 * Adds the properties.
	 * 
	 * @param env
	 *            the active instance of the resource manager environment map
	 * @param control
	 *            JAXB data subtree for control part of resource manager
	 */
	private static void addProperties(Map<String, Object> env, Control control) {
		List<Property> properties = control.getProperty();
		for (Property property : properties) {
			env.put(property.getName(), property);
		}
	}

	/**
	 * First validates the xml, then gets the JAXB context and calls the JAXB
	 * unmarshaller from it.
	 * 
	 * @param xml
	 *            location of the configuration file.
	 * @return the constructed data tree
	 * @throws JAXBException
	 *             problem encountered during unmarshaling
	 * @throws IOException
	 * @throws SAXException
	 *             validation error
	 * @throws URISyntaxException
	 */
	private static ResourceManagerData unmarshalResourceManagerData(URL xml) throws JAXBException, IOException, SAXException,
			URISyntaxException {
		validate(xml);
		JAXBContext jc = JAXBContext.newInstance(JAXB_CONTEXT, JAXBInitializationUtils.class.getClassLoader());
		Unmarshaller u = jc.createUnmarshaller();
		JAXBElement<?> o = (JAXBElement<?>) u.unmarshal(xml.openStream());
		ResourceManagerData rmdata = (ResourceManagerData) o.getValue();
		return rmdata;
	}
}
