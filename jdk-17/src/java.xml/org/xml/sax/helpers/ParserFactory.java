/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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

package org.xml.sax.helpers;

import jdk.xml.internal.SecuritySupport;

/**
 * Java-specific class for dynamically loading SAX parsers.
 *
 * <p><strong>Note:</strong> This class is designed to work with the now-deprecated
 * SAX1 {@link org.xml.sax.Parser Parser} class.  SAX2 applications should use
 * {@link org.xml.sax.helpers.XMLReaderFactory XMLReaderFactory} instead.</p>
 *
 * <p>ParserFactory is not part of the platform-independent definition
 * of SAX; it is an additional convenience class designed
 * specifically for Java XML application writers.  SAX applications
 * can use the static methods in this class to allocate a SAX parser
 * dynamically at run-time based either on the value of the
 * `org.xml.sax.parser' system property or on a string containing the class
 * name.</p>
 *
 * <p>Note that the application still requires an XML parser that
 * implements SAX1.</p>
 *
 * @deprecated This class works with the deprecated
 *             {@link org.xml.sax.Parser Parser}
 *             interface.
 * @since 1.4, SAX 1.0
 * @author David Megginson
 * @version 2.0.1 (sax2r2)
 */
@SuppressWarnings( "deprecation" )
@Deprecated(since="1.5")
public class ParserFactory {

    /**
     * Private null constructor.
     */
    private ParserFactory ()
    {
    }


    /**
     * Create a new SAX parser using the `org.xml.sax.parser' system property.
     *
     * <p>The named class must exist and must implement the
     * {@link org.xml.sax.Parser Parser} interface.</p>
     *
     * @return a new SAX parser
     * @throws java.lang.NullPointerException There is no value
     *            for the `org.xml.sax.parser' system property.
     * @throws java.lang.ClassNotFoundException The SAX parser
     *            class was not found (check your CLASSPATH).
     * @throws IllegalAccessException The SAX parser class was
     *            found, but you do not have permission to load
     *            it.
     * @throws InstantiationException The SAX parser class was
     *            found but could not be instantiated.
     * @throws java.lang.ClassCastException The SAX parser class
     *            was found and instantiated, but does not implement
     *            org.xml.sax.Parser.
     * @see #makeParser(java.lang.String)
     * @see org.xml.sax.Parser
     */
    public static org.xml.sax.Parser makeParser ()
        throws ClassNotFoundException,
        IllegalAccessException,
        InstantiationException,
        NullPointerException,
        ClassCastException
    {
        String className = SecuritySupport.getSystemProperty("org.xml.sax.parser");
        if (className == null) {
            throw new NullPointerException("No value for sax.parser property");
        } else {
            return makeParser(className);
        }
    }


    /**
     * Create a new SAX parser object using the class name provided.
     *
     * <p>The named class must exist and must implement the
     * {@link org.xml.sax.Parser Parser} interface.</p>
     *
     * @param className A string containing the name of the
     *                  SAX parser class.
     * @return a new SAX parser
     * @throws java.lang.ClassNotFoundException The SAX parser
     *            class was not found (check your CLASSPATH).
     * @throws IllegalAccessException The SAX parser class was
     *            found, but you do not have permission to load
     *            it.
     * @throws InstantiationException The SAX parser class was
     *            found but could not be instantiated.
     * @throws java.lang.ClassCastException The SAX parser class
     *            was found and instantiated, but does not implement
     *            org.xml.sax.Parser.
     * @see #makeParser()
     * @see org.xml.sax.Parser
     */
    public static org.xml.sax.Parser makeParser (String className)
        throws ClassNotFoundException,
        IllegalAccessException,
        InstantiationException,
        ClassCastException
    {
        return NewInstance.newInstance (org.xml.sax.Parser.class,
                SecuritySupport.getClassLoader(), className);
    }

}
