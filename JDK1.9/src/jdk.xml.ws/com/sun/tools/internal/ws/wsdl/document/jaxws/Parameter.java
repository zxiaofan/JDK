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

package com.sun.tools.internal.ws.wsdl.document.jaxws;

import javax.xml.namespace.QName;

/**
 * @author Vivek Pandey
 *
 * class representing jaxws:parameter
 *
 */
public class Parameter {
    private String part;
    private QName element;
    private String name;
    private String messageName;

    /**
     * @param part
     * @param element
     * @param name
     */
    public Parameter(String msgName, String part, QName element, String name) {
        this.part = part;
        this.element = element;
        this.name = name;
        this.messageName = msgName;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    /**
     * @return Returns the element.
     */
    public QName getElement() {
        return element;
    }

    /**
     * @param element The element to set.
     */
    public void setElement(QName element) {
        this.element = element;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the part.
     */
    public String getPart() {
        return part;
    }

    /**
     * @param part The part to set.
     */
    public void setPart(String part) {
        this.part = part;
    }
}
