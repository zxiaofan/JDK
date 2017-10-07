/*
 * Copyright (c) 2004, 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javax.xml.soap;

/**
 * A representation of an XML name.  This interface provides methods for
 * getting the local and namespace-qualified names and also for getting the
 * prefix associated with the namespace for the name. It is also possible
 * to get the URI of the namespace.
 * <P>
 * The following is an example of a namespace declaration in an element.
 * {@code <wombat:GetLastTradePrice xmlns:wombat="http://www.wombat.org/trader">}
 * ("xmlns" stands for "XML namespace".)
 * The following
 * shows what the methods in the {@code Name} interface will return.
 * <UL>
 *  <LI>{@code getQualifiedName} will return "prefix:LocalName" =
 *      "WOMBAT:GetLastTradePrice"
 *  <LI>{@code getURI} will return "http://www.wombat.org/trader"
 *  <LI>{@code getLocalName} will return "GetLastTracePrice"
 *  <LI>{@code getPrefix} will return "WOMBAT"
 * </UL>
 * <P>
 * XML namespaces are used to disambiguate SOAP identifiers from
 * application-specific identifiers.
 * <P>
 * {@code Name} objects are created using the method
 * {@code SOAPEnvelope.createName}, which has two versions.
 * One method creates {@code Name} objects with
 * a local name, a namespace prefix, and a namespace URI.
 *  and the second creates {@code Name} objects with just a local name.
 * The following line of
 * code, in which <i>se</i> is a {@code SOAPEnvelope} object, creates a new
 * {@code Name} object with all three.
 * <pre>{@code
 *     Name name = se.createName("GetLastTradePrice", "WOMBAT",
 *                                "http://www.wombat.org/trader");
 * }</pre>
 * The following line of code gives an example of how a {@code Name} object
 * can be used. The variable <i>element</i> is a {@code SOAPElement} object.
 * This code creates a new {@code SOAPElement} object with the given name and
 * adds it to <i>element</i>.
 * <pre>{@code
 *     element.addChildElement(name);
 * }</pre>
 * <P>
 * The {@code Name} interface may be deprecated in a future release of SAAJ
 * in favor of {@code javax.xml.namespace.QName}
 * @see SOAPEnvelope#createName(String, String, String) SOAPEnvelope.createName
 * @see SOAPFactory#createName(String, String, String) SOAPFactory.createName
 * @since 1.6
 */
public interface Name {
    /**
     * Gets the local name part of the XML name that this {@code Name}
     * object represents.
     *
     * @return a string giving the local name
     */
    String getLocalName();

    /**
     * Gets the namespace-qualified name of the XML name that this
     * {@code Name} object represents.
     *
     * @return the namespace-qualified name as a string
     */
    String getQualifiedName();

    /**
     * Returns the prefix that was specified when this {@code Name} object
     * was initialized. This prefix is associated with the namespace for the XML
     * name that this {@code Name} object represents.
     *
     * @return the prefix as a string
     */
    String getPrefix();

    /**
     * Returns the URI of the namespace for the XML
     * name that this {@code Name} object represents.
     *
     * @return the URI as a string
     */
    String getURI();
}
