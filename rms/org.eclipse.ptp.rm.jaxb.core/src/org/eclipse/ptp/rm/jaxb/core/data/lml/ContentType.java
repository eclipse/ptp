//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.14 at 08:46:16 AM CET 
//

package org.eclipse.ptp.rm.jaxb.core.data.lml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for content_type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="content_type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="jobs"/>
 *     &lt;enumeration value="nodes"/>
 *     &lt;enumeration value="users"/>
 *     &lt;enumeration value="groups"/>
 *     &lt;enumeration value="classes"/>
 *     &lt;enumeration value="queues"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "content_type")
@XmlEnum
public enum ContentType {

	@XmlEnumValue("jobs")
	JOBS("jobs"),
	@XmlEnumValue("nodes")
	NODES("nodes"),
	@XmlEnumValue("users")
	USERS("users"),
	@XmlEnumValue("groups")
	GROUPS("groups"),
	@XmlEnumValue("classes")
	CLASSES("classes"),
	@XmlEnumValue("queues")
	QUEUES("queues"),
	@XmlEnumValue("other")
	OTHER("other");
	private final String value;

	ContentType(String v) {
		value = v;
	}

	public String value() {
		return value;
	}

	public static ContentType fromValue(String v) {
		for (ContentType c : ContentType.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
