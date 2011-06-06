//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.05.10 at 09:53:19 AM CEST 
//


package org.eclipse.ptp.rm.lml.internal.core.elements;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for object_name.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="object_name">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="job"/>
 *     &lt;enumeration value="node"/>
 *     &lt;enumeration value="system"/>
 *     &lt;enumeration value="queue"/>
 *     &lt;enumeration value="scheduler"/>
 *     &lt;enumeration value="class"/>
 *     &lt;enumeration value="partition"/>
 *     &lt;enumeration value="partmap"/>
 *     &lt;enumeration value="smallpartition"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "object_name")
@XmlEnum
public enum ObjectName {

    @XmlEnumValue("job")
    JOB("job"),
    @XmlEnumValue("node")
    NODE("node"),
    @XmlEnumValue("system")
    SYSTEM("system"),
    @XmlEnumValue("queue")
    QUEUE("queue"),
    @XmlEnumValue("scheduler")
    SCHEDULER("scheduler"),
    @XmlEnumValue("class")
    CLASS("class"),
    @XmlEnumValue("partition")
    PARTITION("partition"),
    @XmlEnumValue("partmap")
    PARTMAP("partmap"),
    @XmlEnumValue("smallpartition")
    SMALLPARTITION("smallpartition");
    private final String value;

    ObjectName(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ObjectName fromValue(String v) {
        for (ObjectName c: ObjectName.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}