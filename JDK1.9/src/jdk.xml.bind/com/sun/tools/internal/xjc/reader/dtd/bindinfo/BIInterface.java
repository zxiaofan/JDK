/*
 * Copyright (c) 1997, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.dtd.bindinfo;

import java.util.StringTokenizer;

import org.w3c.dom.Element;
import org.xml.sax.Locator;

/**
 * {@code <interface>} declaration in the binding file.
 */
public final class BIInterface
{
    BIInterface( Element e ) {
        this.dom = e;
        name = DOMUtil.getAttribute(e,"name");
        members = parseTokens(DOMUtil.getAttribute(e,"members"));

        if(DOMUtil.getAttribute(e,"properties")!=null) {
            fields = parseTokens(DOMUtil.getAttribute(e,"properties"));
            throw new AssertionError("//interface/@properties is not supported");
        } else    // no property was specified
            fields = new String[0];
    }

    /** {@code <interface>} element in the binding file. */
    private final Element dom;

    /** Name of the generated Java interface. */
    private final String name;

    /**
     * Gets the name of this interface.
     * This name should also used as the class name.
     */
    public String name() { return name; }


    private final String[] members;

    /**
     * Gets the names of interfaces/classes that implement
     * this interface.
     */
    public String[] members() { return members.clone(); }


    private final String[] fields;

    /** Gets the names of fields in this interface. */
    public String[] fields() { return fields.clone(); }


    /** Gets the location where this declaration is declared. */
    public Locator getSourceLocation() {
        return DOMLocator.getLocationInfo(dom);
    }



    /** splits a list into an array of strings. */
    private static String[] parseTokens( String value ) {
        StringTokenizer tokens = new StringTokenizer(value);

        String[] r = new String[tokens.countTokens()];
        int i=0;
        while(tokens.hasMoreTokens())
            r[i++] = tokens.nextToken();

        return r;
    }
}
