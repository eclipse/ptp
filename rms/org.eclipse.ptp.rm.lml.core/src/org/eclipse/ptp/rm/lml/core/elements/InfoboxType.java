//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.13 at 09:16:36 AM CET 
//

package org.eclipse.ptp.rm.lml.core.elements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java class for infobox_type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="infobox_type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://eclipse.org/ptp/lml}gobject_type">
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}NCName" default="notype" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infobox_type")
public class InfoboxType
		extends GobjectType
{

	@XmlAttribute
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "NCName")
	protected String type;

	/**
	 * Gets the value of the type property.
	 * 
	 * @return
	 *         possible object is {@link String }
	 * 
	 */
	public String getType() {
		if (type == null) {
			return "notype";
		} else {
			return type;
		}
	}

	/**
	 * Sets the value of the type property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setType(String value) {
		this.type = value;
	}

}
