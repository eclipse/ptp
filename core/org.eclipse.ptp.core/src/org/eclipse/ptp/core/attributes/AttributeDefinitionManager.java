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
package org.eclipse.ptp.core.attributes;

import java.math.BigInteger;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

public class AttributeDefinitionManager {

	private final HashMap<String, IAttributeDefinition<?,?,?>> attributeDefs =
		new HashMap<String, IAttributeDefinition<?,?,?>>();
	
	public AttributeDefinitionManager() {
	}
	
	/**
	 * Create an attribute definition
	 * 
	 * @param attr
	 */
	public void setAttributeDefinition(IAttributeDefinition<?,?,?> attrDef) {
		if (!attributeDefs.containsKey(attrDef.getId())) {
			attributeDefs.put(attrDef.getId(), attrDef);
		}
	}
	
	/**
	 * @param attrDefs
	 */
	public void setAttributeDefinitions(IAttributeDefinition<?,?,?>[] attrDefs) {
		for (IAttributeDefinition<?,?,?> attrDef : attrDefs) {
			setAttributeDefinition(attrDef);
		}
	}
	
	/**
	 * Lookup an attribute definition
	 * 
	 * @param attrId
	 * @return attribute definition
	 */
	public IAttributeDefinition<?,?,?> getAttributeDefinition(String attrId) {
		return attributeDefs.get(attrId);
	}
	
	/**
	 * Clear attribute definitions
	 */
	public void clear() {
		attributeDefs.clear();
	}
	
	/**
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @return
	 */
	public BigIntegerAttributeDefinition createBigIntegerAttributeDefinition(final String uniqueId,
			final String name, final String description, final BigInteger defaultValue) {

		BigIntegerAttributeDefinition def = new BigIntegerAttributeDefinition(uniqueId, name,
				description, defaultValue);
		setAttributeDefinition(def);
		return def;
	}
	
	/**
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @return
	 */
	public BooleanAttributeDefinition createBooleanAttributeDefinition(final String uniqueId,
			final String name, final String description, final Boolean defaultValue) {
		BooleanAttributeDefinition def = new BooleanAttributeDefinition(uniqueId, name,
				description, defaultValue);
		setAttributeDefinition(def);
		return def;
	}
	
	/**
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @param outputDateFormat
	 * @return
	 */
	public DateAttributeDefinition createDateAttributeDefinition(final String uniqueId, final String name, final String description, final Date defaultValue, final DateFormat outputDateFormat) {
		DateAttributeDefinition def = new DateAttributeDefinition(uniqueId, name, description, defaultValue, outputDateFormat);
		setAttributeDefinition(def);
		return def;
	}
	
	/**
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @param outputDateFormat
	 * @param min
	 * @param max
	 * @return
	 * @throws IllegalValueException
	 */
	public DateAttributeDefinition createDateAttributeDefinition(final String uniqueId, final String name, final String description, final Date defaultValue, final DateFormat outputDateFormat, final Date min, final Date max) throws IllegalValueException {
		DateAttributeDefinition def = new DateAttributeDefinition(uniqueId, name, description, defaultValue, outputDateFormat, min, max);
		setAttributeDefinition(def);
		return def;
	}

	/**
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @return
	 */
	public DoubleAttributeDefinition createDoubleAttributeDefinition(final String uniqueId, final String name, final String description, final Double defaultValue) {
		DoubleAttributeDefinition def = new DoubleAttributeDefinition(uniqueId, name, description, defaultValue);
		setAttributeDefinition(def);
		return def;
	}
	
	/**
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @param min
	 * @param max
	 * @return
	 * @throws IllegalValueException
	 */
	public DoubleAttributeDefinition createDoubleAttributeDefinition(final String uniqueId, final String name, final String description, final Double defaultValue, final Double min, final Double max) throws IllegalValueException {
		DoubleAttributeDefinition def = new DoubleAttributeDefinition(uniqueId, name, description, defaultValue, min, max);
		setAttributeDefinition(def);
		return def;
	}

	/**
	 * @param <E>
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @return
	 */
	public <E extends Enum<E>> EnumeratedAttributeDefinition<E> createEnumeratedAttributeDefinition(
			final String uniqueId, final String name, final String description,
			final E defaultValue) {
		EnumeratedAttributeDefinition<E> def = 
			new EnumeratedAttributeDefinition<E>(uniqueId, name, description, defaultValue);
		setAttributeDefinition(def);
		return def;
	}
	
	/**
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @return
	 */
	public IntegerAttributeDefinition createIntegerAttributeDefinition(final String uniqueId, final String name, final String description, final Integer defaultValue) {
		IntegerAttributeDefinition def = new IntegerAttributeDefinition(uniqueId, name, description, defaultValue);
		setAttributeDefinition(def);
		return def;
	}

	/**
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @param min
	 * @param max
	 * @return
	 * @throws IllegalValueException
	 */
	public IntegerAttributeDefinition createIntegerAttributeDefinition(final String uniqueId, final String name, final String description, final Integer defaultValue, final Integer min, final Integer max) throws IllegalValueException {
		IntegerAttributeDefinition def = new IntegerAttributeDefinition(uniqueId, name, description, defaultValue, min, max);
		setAttributeDefinition(def);
		return def;
	}

	/**
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @return
	 */
	public StringAttributeDefinition createStringAttributeDefinition(final String uniqueId, final String name, final String description, final String defaultValue) {
		StringAttributeDefinition def = new StringAttributeDefinition(uniqueId, name, description, defaultValue);
		setAttributeDefinition(def);
		return def;
	}
	
	/**
	 * @param <T>
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @return
	 */
	public <T extends Comparable<T>> ArrayAttributeDefinition<T> createArrayAttributeDefinition(
			final String uniqueId, final String name, final String description,
			final T[] defaultValue) {
		ArrayAttributeDefinition<T> def = new ArrayAttributeDefinition<T>(uniqueId, name,
				description, defaultValue);
		setAttributeDefinition(def);
		return def;
	}

	/**
	 * @param uniqueId
	 * @param name
	 * @param description
	 * @param defaultValue
	 * @param values
	 * @return
	 * @throws IllegalValueException
	 */
	public StringSetAttributeDefinition createStringSetAttributeDefinition(
			String uniqueId, String name, String description,
			String defaultValue, String[] values) throws IllegalValueException {
		return new StringSetAttributeDefinition(uniqueId, name, description, defaultValue,
				values);
	}
}
