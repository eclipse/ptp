//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.30 at 02:17:45 PM CEST 
//


package org.eclipse.ptp.rm.jaxb.core.data.lml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nodedisplayelement7 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nodedisplayelement7">
 *   &lt;complexContent>
 *     &lt;extension base="{http://eclipse.org/ptp/lml}nodedisplayelement">
 *       &lt;sequence>
 *         &lt;element name="el8" type="{http://eclipse.org/ptp/lml}nodedisplayelement8" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodedisplayelement7", propOrder = {
    "el8"
})
public class Nodedisplayelement7
    extends Nodedisplayelement
{

    protected List<Nodedisplayelement8> el8;

    /**
     * Gets the value of the el8 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the el8 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEl8().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Nodedisplayelement8 }
     * 
     * 
     */
    public List<Nodedisplayelement8> getEl8() {
        if (el8 == null) {
            el8 = new ArrayList<Nodedisplayelement8>();
        }
        return this.el8;
    }

}
