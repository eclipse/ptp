//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.21 at 02:35:28 PM CDT 
//

package org.eclipse.ptp.rm.jaxb.core.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * A regular expression or an EFS string used to validate an attribute value.
 * 
 * 
 * <p>
 * Java class for validator-type complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="validator-type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element name="regex" type="{http://org.eclipse.ptp/rm}regex-type" minOccurs="0"/>
 *           &lt;element name="file-info" type="{http://org.eclipse.ptp/rm}file-match-type" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element name="error-message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validator-type", propOrder = { "regex", "fileInfo", "errorMessage" })
public class ValidatorType {

	protected RegexType regex;
	@XmlElement(name = "file-info")
	protected FileMatchType fileInfo;
	@XmlElement(name = "error-message")
	protected String errorMessage;

	/**
	 * Gets the value of the errorMessage property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Gets the value of the fileInfo property.
	 * 
	 * @return possible object is {@link FileMatchType }
	 * 
	 */
	public FileMatchType getFileInfo() {
		return fileInfo;
	}

	/**
	 * Gets the value of the regex property.
	 * 
	 * @return possible object is {@link RegexType }
	 * 
	 */
	public RegexType getRegex() {
		return regex;
	}

	/**
	 * Sets the value of the errorMessage property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setErrorMessage(String value) {
		this.errorMessage = value;
	}

	/**
	 * Sets the value of the fileInfo property.
	 * 
	 * @param value
	 *            allowed object is {@link FileMatchType }
	 * 
	 */
	public void setFileInfo(FileMatchType value) {
		this.fileInfo = value;
	}

	/**
	 * Sets the value of the regex property.
	 * 
	 * @param value
	 *            allowed object is {@link RegexType }
	 * 
	 */
	public void setRegex(RegexType value) {
		this.regex = value;
	}

}