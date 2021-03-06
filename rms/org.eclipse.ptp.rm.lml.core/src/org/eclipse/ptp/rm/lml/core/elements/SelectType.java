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
import javax.xml.bind.annotation.XmlType;

/**
 * One select tag describes a selection of a subset
 * within a table.
 * It is used for filtering. All table rows are traversed and they
 * are checked against the relation given by the rel-attribute.
 * If the comparison term is true, the table row will stay in the
 * filtered result, otherwise it is removed. Example: a table has the
 * row totalcores. The user is only interested in big jobs with more
 * than 1000 cores. A select tag must be added with the value=1000
 * and the rel=gt. Thus, only the table rows with more than 1000 cores
 * are transferred to the client.
 * The select tags are executed subsequently. This allows the selection
 * of a subset from another subset generated by a previous select.
 * 
 * 
 * <p>
 * Java class for select_type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="select_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rel" type="{http://eclipse.org/ptp/lml}select_relation_type" default="=~" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "select_type")
public class SelectType {

	@XmlAttribute(required = true)
	protected String value;
	@XmlAttribute
	protected String rel;

	/**
	 * Gets the value of the value property.
	 * 
	 * @return
	 *         possible object is {@link String }
	 * 
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the value of the rel property.
	 * 
	 * @return
	 *         possible object is {@link String }
	 * 
	 */
	public String getRel() {
		if (rel == null) {
			return "=~";
		} else {
			return rel;
		}
	}

	/**
	 * Sets the value of the rel property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRel(String value) {
		this.rel = value;
	}

}
