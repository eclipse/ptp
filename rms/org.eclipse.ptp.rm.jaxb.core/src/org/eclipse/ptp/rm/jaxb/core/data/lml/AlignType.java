//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.14 at 08:46:16 AM CET 
//

package org.eclipse.ptp.rm.jaxb.core.data.lml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for align_type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="align_type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WEST"/>
 *     &lt;enumeration value="EAST"/>
 *     &lt;enumeration value="NORTH"/>
 *     &lt;enumeration value="SOUTH"/>
 *     &lt;enumeration value="CENTER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "align_type")
@XmlEnum
public enum AlignType {

	WEST,
	EAST,
	NORTH,
	SOUTH,
	CENTER;

	public String value() {
		return name();
	}

	public static AlignType fromValue(String v) {
		return valueOf(v);
	}

}
