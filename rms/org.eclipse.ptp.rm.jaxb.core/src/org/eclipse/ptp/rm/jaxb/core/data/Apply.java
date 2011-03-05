//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.04 at 07:47:50 PM CST 
//

package org.eclipse.ptp.rm.jaxb.core.data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{}apply" maxOccurs="unbounded"/>
 *           &lt;element ref="{}match" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="delim" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="for" type="{http://www.w3.org/2001/XMLSchema}int" default="0" />
 *       &lt;attribute name="includeDelim" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="until" type="{http://www.w3.org/2001/XMLSchema}string" default="EOS" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "apply", "match" })
@XmlRootElement(name = "apply")
public class Apply {

	protected List<Apply> apply;
	protected List<Match> match;
	@XmlAttribute
	protected String delim;
	@XmlAttribute(name = "for")
	protected Integer _for;
	@XmlAttribute
	protected Boolean includeDelim;
	@XmlAttribute
	protected String until;

	/**
	 * Gets the value of the apply property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the apply property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getApply().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Apply }
	 * 
	 * 
	 */
	public List<Apply> getApply() {
		if (apply == null) {
			apply = new ArrayList<Apply>();
		}
		return this.apply;
	}

	/**
	 * Gets the value of the delim property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDelim() {
		return delim;
	}

	/**
	 * Gets the value of the for property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public int getFor() {
		if (_for == null) {
			return 0;
		} else {
			return _for;
		}
	}

	/**
	 * Gets the value of the match property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the match property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getMatch().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Match }
	 * 
	 * 
	 */
	public List<Match> getMatch() {
		if (match == null) {
			match = new ArrayList<Match>();
		}
		return this.match;
	}

	/**
	 * Gets the value of the until property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUntil() {
		if (until == null) {
			return "EOS"; //$NON-NLS-1$
		} else {
			return until;
		}
	}

	/**
	 * Gets the value of the includeDelim property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public boolean isIncludeDelim() {
		if (includeDelim == null) {
			return false;
		} else {
			return includeDelim;
		}
	}

	/**
	 * Sets the value of the delim property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDelim(String value) {
		this.delim = value;
	}

	/**
	 * Sets the value of the for property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setFor(Integer value) {
		this._for = value;
	}

	/**
	 * Sets the value of the includeDelim property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setIncludeDelim(Boolean value) {
		this.includeDelim = value;
	}

	/**
	 * Sets the value of the until property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUntil(String value) {
		this.until = value;
	}

}