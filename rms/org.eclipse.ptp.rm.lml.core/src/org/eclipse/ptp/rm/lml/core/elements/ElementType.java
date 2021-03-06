//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.13 at 09:16:36 AM CET 
//

package org.eclipse.ptp.rm.lml.core.elements;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * Abstract element type for either scheme- or
 * data-elements. This element is repeated (max-min+1)
 * times, if step in the scheme-section is 1. max should be
 * higher then min. If max is left out, max will be set to
 * min (max=min). min="0", max="0" means there is only one
 * element.
 * 
 * 
 * <p>
 * Java class for element_type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="element_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="min" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="list" type="{http://eclipse.org/ptp/lml}list_type" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "element_type")
@XmlSeeAlso({
		Nodedisplayelement.class,
		SchemeElement.class,
		DataElement.class
})
public class ElementType {

	@XmlAttribute
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger min;
	@XmlAttribute
	@XmlSchemaType(name = "nonNegativeInteger")
	protected BigInteger max;
	@XmlAttribute
	protected String list;

	/**
	 * Gets the value of the min property.
	 * 
	 * @return
	 *         possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getMin() {
		return min;
	}

	/**
	 * Sets the value of the min property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setMin(BigInteger value) {
		this.min = value;
	}

	/**
	 * Gets the value of the max property.
	 * 
	 * @return
	 *         possible object is {@link BigInteger }
	 * 
	 */
	public BigInteger getMax() {
		return max;
	}

	/**
	 * Sets the value of the max property.
	 * 
	 * @param value
	 *            allowed object is {@link BigInteger }
	 * 
	 */
	public void setMax(BigInteger value) {
		this.max = value;
	}

	/**
	 * Gets the value of the list property.
	 * 
	 * @return
	 *         possible object is {@link String }
	 * 
	 */
	public String getList() {
		return list;
	}

	/**
	 * Sets the value of the list property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setList(String value) {
		this.list = value;
	}

}
