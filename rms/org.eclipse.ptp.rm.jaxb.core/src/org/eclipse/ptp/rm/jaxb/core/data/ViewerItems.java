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
 * Java class for viewer-items complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="viewer-items">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="include">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="allDiscovered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                 &lt;attribute name="allPredefined" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                 &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *                 &lt;attribute name="headers" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *                 &lt;attribute name="tooltip" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ref" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "viewer-items", propOrder = { "include", "ref" })
public class ViewerItems {

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
	 *       &lt;attribute name="allDiscovered" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
	 *       &lt;attribute name="allPredefined" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
	 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
	 *       &lt;attribute name="headers" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
	 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
	 *       &lt;attribute name="tooltip" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class Include {

		@XmlAttribute
		protected Boolean allDiscovered;
		@XmlAttribute
		protected Boolean allPredefined;
		@XmlAttribute
		protected Boolean description;
		@XmlAttribute
		protected Boolean headers;
		@XmlAttribute
		protected Boolean name;
		@XmlAttribute
		protected Boolean tooltip;

		/**
		 * Gets the value of the allDiscovered property.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		public boolean isAllDiscovered() {
			if (allDiscovered == null) {
				return false;
			} else {
				return allDiscovered;
			}
		}

		/**
		 * Gets the value of the allPredefined property.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		public boolean isAllPredefined() {
			if (allPredefined == null) {
				return false;
			} else {
				return allPredefined;
			}
		}

		/**
		 * Gets the value of the description property.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		public boolean isDescription() {
			if (description == null) {
				return true;
			} else {
				return description;
			}
		}

		/**
		 * Gets the value of the headers property.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		public boolean isHeaders() {
			if (headers == null) {
				return true;
			} else {
				return headers;
			}
		}

		/**
		 * Gets the value of the name property.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		public boolean isName() {
			if (name == null) {
				return true;
			} else {
				return name;
			}
		}

		/**
		 * Gets the value of the tooltip property.
		 * 
		 * @return possible object is {@link Boolean }
		 * 
		 */
		public boolean isTooltip() {
			if (tooltip == null) {
				return true;
			} else {
				return tooltip;
			}
		}

		/**
		 * Sets the value of the allDiscovered property.
		 * 
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setAllDiscovered(Boolean value) {
			this.allDiscovered = value;
		}

		/**
		 * Sets the value of the allPredefined property.
		 * 
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setAllPredefined(Boolean value) {
			this.allPredefined = value;
		}

		/**
		 * Sets the value of the description property.
		 * 
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setDescription(Boolean value) {
			this.description = value;
		}

		/**
		 * Sets the value of the headers property.
		 * 
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setHeaders(Boolean value) {
			this.headers = value;
		}

		/**
		 * Sets the value of the name property.
		 * 
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setName(Boolean value) {
			this.name = value;
		}

		/**
		 * Sets the value of the tooltip property.
		 * 
		 * @param value
		 *            allowed object is {@link Boolean }
		 * 
		 */
		public void setTooltip(Boolean value) {
			this.tooltip = value;
		}

	}

	@XmlElement(required = true)
	protected ViewerItems.Include include;

	protected List<String> ref;

	/**
	 * Gets the value of the include property.
	 * 
	 * @return possible object is {@link ViewerItems.Include }
	 * 
	 */
	public ViewerItems.Include getInclude() {
		return include;
	}

	/**
	 * Gets the value of the ref property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the ref property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getRef().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public List<String> getRef() {
		if (ref == null) {
			ref = new ArrayList<String>();
		}
		return this.ref;
	}

	/**
	 * Sets the value of the include property.
	 * 
	 * @param value
	 *            allowed object is {@link ViewerItems.Include }
	 * 
	 */
	public void setInclude(ViewerItems.Include value) {
		this.include = value;
	}

}
