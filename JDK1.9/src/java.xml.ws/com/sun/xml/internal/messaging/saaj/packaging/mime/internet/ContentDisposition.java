/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * @(#)ContentDisposition.java        1.6 02/03/27
 */



package com.sun.xml.internal.messaging.saaj.packaging.mime.internet;


/**
 * This class represents a MIME ContentDisposition value. It provides
 * methods to parse a ContentDisposition string into individual components
 * and to generate a MIME style ContentDisposition string.
 *
 * @version 1.6, 02/03/27
 * @author  John Mani
 */

public class ContentDisposition {

    private String disposition; // disposition
    private ParameterList list; // parameter list

    /**
     * No-arg Constructor.
     */
    public ContentDisposition() { }

    /**
     * Constructor.
     *
     * @param   disposition     disposition
     * @param   list    ParameterList
     * @since           JavaMail 1.2
     */
    public ContentDisposition(String disposition, ParameterList list) {
        this.disposition = disposition;
        this.list = list;
    }

    /**
     * Constructor that takes a ContentDisposition string. The String
     * is parsed into its constituents: dispostion and parameters.
     * A ParseException is thrown if the parse fails.
     *
     * @param   s       the ContentDisposition string.
     * @exception       ParseException if the parse fails.
     * @since           JavaMail 1.2
     */
    public ContentDisposition(String s) throws ParseException {
        HeaderTokenizer h = new HeaderTokenizer(s, HeaderTokenizer.MIME);
        HeaderTokenizer.Token tk;

        // First "disposition" ..
        tk = h.next();
        if (tk.getType() != HeaderTokenizer.Token.ATOM)
            throw new ParseException();
        disposition = tk.getValue();

        // Then parameters ..
        String rem = h.getRemainder();
        if (rem != null)
            list = new ParameterList(rem);
    }

    /**
     * Return the disposition value.
     * @return the disposition
     * @since           JavaMail 1.2
     */
    public String getDisposition() {
        return disposition;
    }

    /**
     * Return the specified parameter value. Returns <code>null</code>
     * if this parameter is absent.
     * @param name parameter name.
     * @return  parameter value
     * @since           JavaMail 1.2
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
     * @since           JavaMail 1.2
     */
    public ParameterList getParameterList() {
        return list;
    }

    /**
     * Set the primary type. Overrides existing primary type.
     * @param   disposition disposition value
     * @since           JavaMail 1.2
     */
    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    /**
     * Set the specified parameter. If this parameter already exists,
     * it is replaced by this new value.
     *
     * @param   name    parameter name
     * @param   value   parameter value
     * @since           JavaMail 1.2
     */
    public void setParameter(String name, String value) {
        if (list == null)
            list = new ParameterList();

        list.set(name, value);
    }

    /**
     * Set a new ParameterList.
     * @param   list    ParameterList
     * @since           JavaMail 1.2
     */
    public void setParameterList(ParameterList list) {
        this.list = list;
    }

    /**
     * Retrieve a RFC2045 style string representation of
     * this ContentDisposition. Returns <code>null</code> if
     * the conversion failed.
     *
     * @return  RFC2045 style string
     * @since           JavaMail 1.2
     */
    @Override
    public String toString() {
        if (disposition == null)
            return null;

        if (list == null)
            return disposition;

        StringBuilder sb = new StringBuilder(disposition);

        // append the parameter list
        // use the length of the string buffer + the length of
        // the header name formatted as follows "Content-Disposition: "
        sb.append(list.toString(sb.length() + 21));
        return sb.toString();
    }
}
