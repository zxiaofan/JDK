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

/**
 * @author Vivek Pandey
 *
 * class representing jaxws:exception
 *
 */
public class Exception {

    public Exception(){}

    public Exception(CustomName name){
        this.className = name;
    }

    private CustomName className;
    /**
     * @return Returns the className.
     */
    public CustomName getClassName() {
        return className;
    }
    /**
     * @param className The className to set.
     */
    public void setClassName(CustomName className) {
        this.className = className;
    }
}
