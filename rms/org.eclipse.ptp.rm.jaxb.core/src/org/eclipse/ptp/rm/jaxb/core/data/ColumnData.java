//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.02 at 05:41:26 PM CDT 
//

package org.eclipse.ptp.rm.jaxb.core.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for column-data complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="column-data">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="font" type="{http://org.eclipse.ptp/rm}font-descriptor" minOccurs="0"/>
 *         &lt;element name="tooltip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="alignment" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="background" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="foreground" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="moveable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="resizable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}int" default="-1" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "column-data", propOrder = { "font", "tooltip" })
public class ColumnData {

	protected FontDescriptor font;
	protected String tooltip;
	@XmlAttribute
	protected String alignment;
	@XmlAttribute
	protected String background;
	@XmlAttribute
	protected String foreground;
	@XmlAttribute
	protected Boolean moveable;
	@XmlAttribute
	protected String name;
	@XmlAttribute
	protected Boolean resizable;
	@XmlAttribute
	protected Integer width;

	/**
	 * Gets the value of the alignment property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAlignment() {
		return alignment;
	}

	/**
	 * Gets the value of the background property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBackground() {
		return background;
	}

	/**
	 * Gets the value of the font property.
	 * 
	 * @return possible object is {@link FontDescriptor }
	 * 
	 */
	public FontDescriptor getFont() {
		return font;
	}

	/**
	 * Gets the value of the foreground property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getForeground() {
		return foreground;
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
	 * Gets the value of the tooltip property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTooltip() {
		return tooltip;
	}

	/**
	 * Gets the value of the width property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public int getWidth() {
		if (width == null) {
			return -1;
		} else {
			return width;
		}
	}

	/**
	 * Gets the value of the moveable property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public boolean isMoveable() {
		if (moveable == null) {
			return false;
		} else {
			return moveable;
		}
	}

	/**
	 * Gets the value of the resizable property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public boolean isResizable() {
		if (resizable == null) {
			return true;
		} else {
			return resizable;
		}
	}

	/**
	 * Sets the value of the alignment property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAlignment(String value) {
		this.alignment = value;
	}

	/**
	 * Sets the value of the background property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBackground(String value) {
		this.background = value;
	}

	/**
	 * Sets the value of the font property.
	 * 
	 * @param value
	 *            allowed object is {@link FontDescriptor }
	 * 
	 */
	public void setFont(FontDescriptor value) {
		this.font = value;
	}

	/**
	 * Sets the value of the foreground property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setForeground(String value) {
		this.foreground = value;
	}

	/**
	 * Sets the value of the moveable property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setMoveable(Boolean value) {
		this.moveable = value;
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
	 * Sets the value of the resizable property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setResizable(Boolean value) {
		this.resizable = value;
	}

	/**
	 * Sets the value of the tooltip property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTooltip(String value) {
		this.tooltip = value;
	}

	/**
	 * Sets the value of the width property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setWidth(Integer value) {
		this.width = value;
	}

}
