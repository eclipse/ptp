//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.26 at 05:14:19 PM CDT 
//

package org.eclipse.ptp.rm.jaxb.core.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for widget complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="widget">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grid-data" type="{http://org.eclipse.ptp/rm}grid-data-descriptor" minOccurs="0"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="style" type="{http://org.eclipse.ptp/rm}style" minOccurs="0"/>
 *         &lt;element name="tooltip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayValue" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="arg" type="{http://org.eclipse.ptp/rm}arg" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="readOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="saveAs" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" default="text">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="label"/>
 *             &lt;enumeration value="text"/>
 *             &lt;enumeration value="checkbox"/>
 *             &lt;enumeration value="spinner"/>
 *             &lt;enumeration value="combo"/>
 *             &lt;enumeration value="pushButton"/>
 *             &lt;enumeration value="radioButton"/>
 *             &lt;enumeration value="browseDirectoryButton"/>
 *             &lt;enumeration value="browseExistingFileButton"/>
 *             &lt;enumeration value="browseOrCreateFileButton"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="valueFrom" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "widget", propOrder = { "gridData", "label", "style", "tooltip", "value", "displayValue" })
public class Widget {

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained
	 * within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="arg" type="{http://org.eclipse.ptp/rm}arg" maxOccurs="unbounded"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "arg" })
	public static class DisplayValue {

		@XmlElement(required = true)
		protected List<Arg> arg;

		/**
		 * Gets the value of the arg property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a
		 * snapshot. Therefore any modification you make to the returned list
		 * will be present inside the JAXB object. This is why there is not a
		 * <CODE>set</CODE> method for the arg property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getArg().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list {@link Arg }
		 * 
		 * 
		 */
		public List<Arg> getArg() {
			if (arg == null) {
				arg = new ArrayList<Arg>();
			}
			return this.arg;
		}

	}

	@XmlElement(name = "grid-data")
	protected GridDataDescriptor gridData;
	protected String label;
	protected Style style;
	protected String tooltip;
	protected String value;
	protected Widget.DisplayValue displayValue;
	@XmlAttribute
	protected Boolean readOnly;
	@XmlAttribute
	protected String saveAs;
	@XmlAttribute
	protected String type;

	@XmlAttribute
	protected String valueFrom;

	/**
	 * Gets the value of the displayValue property.
	 * 
	 * @return possible object is {@link Widget.DisplayValue }
	 * 
	 */
	public Widget.DisplayValue getDisplayValue() {
		return displayValue;
	}

	/**
	 * Gets the value of the gridData property.
	 * 
	 * @return possible object is {@link GridDataDescriptor }
	 * 
	 */
	public GridDataDescriptor getGridData() {
		return gridData;
	}

	/**
	 * Gets the value of the label property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Gets the value of the saveAs property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSaveAs() {
		return saveAs;
	}

	/**
	 * Gets the value of the style property.
	 * 
	 * @return possible object is {@link Style }
	 * 
	 */
	public Style getStyle() {
		return style;
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
	 * Gets the value of the type property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getType() {
		if (type == null) {
			return "text"; //$NON-NLS-1$
		} else {
			return type;
		}
	}

	/**
	 * Gets the value of the value property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Gets the value of the valueFrom property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValueFrom() {
		return valueFrom;
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
	 * Sets the value of the displayValue property.
	 * 
	 * @param value
	 *            allowed object is {@link Widget.DisplayValue }
	 * 
	 */
	public void setDisplayValue(Widget.DisplayValue value) {
		this.displayValue = value;
	}

	/**
	 * Sets the value of the gridData property.
	 * 
	 * @param value
	 *            allowed object is {@link GridDataDescriptor }
	 * 
	 */
	public void setGridData(GridDataDescriptor value) {
		this.gridData = value;
	}

	/**
	 * Sets the value of the label property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLabel(String value) {
		this.label = value;
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
	 * Sets the value of the saveAs property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSaveAs(String value) {
		this.saveAs = value;
	}

	/**
	 * Sets the value of the style property.
	 * 
	 * @param value
	 *            allowed object is {@link Style }
	 * 
	 */
	public void setStyle(Style value) {
		this.style = value;
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
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Sets the value of the valueFrom property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValueFrom(String value) {
		this.valueFrom = value;
	}

}
