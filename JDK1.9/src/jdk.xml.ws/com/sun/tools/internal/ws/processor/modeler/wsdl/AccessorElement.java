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

package com.sun.tools.internal.ws.processor.modeler.wsdl;

import javax.xml.namespace.QName;


/**
 * @author Vivek Pandey
 *
 * Rpc/Lit AccessorElement to be used to generate pseudo schema
 */
class AccessorElement {

    private QName type;
    private String name;


    /**
     * @param type
     * @param name
     */
    public AccessorElement(String name, QName type) {
        this.type = type;
        this.name = name;
    }
    /**
     * @return Returns the type.
     */
    public QName getType() {
        return type;
    }
    /**
     * @param type The type to set.
     */
    public void setType(QName type) {
        this.type = type;
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
}
