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

package com.sun.tools.internal.ws.processor.model;

import com.sun.tools.internal.ws.wsdl.framework.Entity;

import javax.xml.namespace.QName;

public class HeaderFault extends Fault {

    public HeaderFault(Entity entity) {
        super(entity);
    }

    public HeaderFault(String name, Entity entity) {
        super(name, entity);
    }

    public QName getMessage() {
        return _message;
    }

    public void setMessage(QName message) {
        _message = message;
    }

    public String getPart() {
        return _part;
    }

    public void setPart(String part) {
        _part = part;
    }

    private QName _message;
    private String _part;
}
