//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.19 at 11:21:28 AM CDT 
//

package org.eclipse.ptp.rm.jaxb.core.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for property-type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="property-type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="default" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="link-value-to" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" default="java.lang.String" />
 *       &lt;attribute name="visible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "property-type", propOrder = { "_default", "value", "linkValueTo" })
public class PropertyType {

	@XmlElement(name = "default")
	protected String _default;
	protected Object value;
	@XmlElement(name = "link-value-to")
	protected String linkValueTo;
	@XmlAttribute
	protected String name;
	@XmlAttribute
	protected Boolean readOnly;
	@XmlAttribute
	protected String type;
	@XmlAttribute
	protected Boolean visible;

	/**
	 * Gets the value of the default property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDefault() {
		return _default;
	}

	/**
	 * Gets the value of the linkValueTo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLinkValueTo() {
		return linkValueTo;
	}

	/**
	 * Gets the value of the name property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getType() {
		if (type == null) {
			return "java.lang.String"; //$NON-NLS-1$
		} else {
			return type;
		}
	}

	/**
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link Object }
	 * 
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Gets the value of the readOnly property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public boolean isReadOnly() {
		if (readOnly == null) {
			return false;
		} else {
			return readOnly;
		}
	}

	/**
	 * Gets the value of the visible property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public boolean isVisible() {
		if (visible == null) {
			return true;
		} else {
			return visible;
		}
	}

	/**
	 * Sets the value of the default property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDefault(String value) {
		this._default = value;
	}

	/**
	 * Sets the value of the linkValueTo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLinkValueTo(String value) {
		this.linkValueTo = value;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Sets the value of the readOnly property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setReadOnly(Boolean value) {
		this.readOnly = value;
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

	/**
	 * Sets the value of the value property.
	 * 
	 * @param value
	 *            allowed object is {@link Object }
	 * 
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Sets the value of the visible property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setVisible(Boolean value) {
		this.visible = value;
	}

}