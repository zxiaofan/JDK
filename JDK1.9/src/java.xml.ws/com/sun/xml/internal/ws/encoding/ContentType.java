/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

/*
 * @(#)ContentType.java       1.7 02/03/27
 */



package com.sun.xml.internal.ws.encoding;

import javax.xml.ws.WebServiceException;

/**
 * This class represents a MIME ContentType value. It provides
 * methods to parse a ContentType string into individual components
 * and to generate a MIME style ContentType string.
 *
 * @version 1.7, 02/03/27
 * @author  John Mani
 */
public final class ContentType {

    private String primaryType; // primary type
    private String subType;     // subtype
    private ParameterList list; // parameter list

    /**
     * Constructor that takes a Content-Type string. The String
     * is parsed into its constituents: primaryType, subType
     * and parameters. A ParseException is thrown if the parse fails.
     *
     * @param   s       the Content-Type string.
     * @exception WebServiceException if the parse fails.
     */
    public ContentType(String s) throws WebServiceException {
        HeaderTokenizer h = new HeaderTokenizer(s, HeaderTokenizer.MIME);
        HeaderTokenizer.Token tk;

        // First "type" ..
        tk = h.next();
        if (tk.getType() != HeaderTokenizer.Token.ATOM)
            throw new WebServiceException();
        primaryType = tk.getValue();

        // The '/' separator ..
        tk = h.next();
        if ((char)tk.getType() != '/')
            throw new WebServiceException();

        // Then "subType" ..
        tk = h.next();
        if (tk.getType() != HeaderTokenizer.Token.ATOM)
            throw new WebServiceException();
        subType = tk.getValue();

        // Finally parameters ..
        String rem = h.getRemainder();
        if (rem != null)
            list = new ParameterList(rem);
    }


    /**
     * Return the primary type.
     * @return the primary type
     */
    public String getPrimaryType() {
            return primaryType;
    }

    /**
     * Return the subType.
     * @return the subType
     */
    public String getSubType() {
            return subType;
    }

    /**
     * Return the MIME type string, without the parameters.
     * The returned value is basically the concatenation of
     * the primaryType, the '/' character and the secondaryType.
     *
     * @return the type
     */
    public String getBaseType() {
            return primaryType + '/' + subType;
    }

    /**
     * Return the specified parameter value. Returns <code>null</code>
     * if this parameter is absent.
     *
     * @param name parameter name
     * @return  parameter value
     */
    public String getParameter(String name) {
        if (list == null)
            return null;

        return list.get(name);
    }

    /**
     * Return a ParameterList object that holds all the available
     * parameters. Returns null if no parameters are available.
     *
     * @return  ParameterList
     */
    public ParameterList getParameterList() {
            return list;
    }

}
