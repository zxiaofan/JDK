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

package com.sun.tools.internal.ws.processor.model.jaxb;

import com.sun.tools.internal.ws.processor.model.AbstractType;

import javax.xml.namespace.QName;

/**
 * @author Vivek Pandey
 *
 * Represents RpcLit member parts
 */
public class RpcLitMember extends AbstractType {

    //wsdl:part type attribute java mapped object
    private String javaTypeName;
    private QName schemaTypeName;

    /**
     *
     */
    public RpcLitMember() {
        super();
        // TODO Auto-generated constructor stub
    }
    public RpcLitMember(QName name, String javaTypeName){
        setName(name);
        this.javaTypeName = javaTypeName;
    }
    public RpcLitMember(QName name, String javaTypeName, QName schemaTypeName){
        setName(name);
        this.javaTypeName = javaTypeName;
        this.schemaTypeName = schemaTypeName;
    }

    /**
     * @return Returns the type.
     */
    public String getJavaTypeName() {
        return javaTypeName;
    }
    /**
     * @param type The type to set.
     */
    public void setJavaTypeName(String type) {
        this.javaTypeName = type;
    }

    /**
     * @return Returns the type.
     */
    public QName getSchemaTypeName() {
        return schemaTypeName;
    }
    /**
     * @param type The type to set.
     */
    public void setSchemaTypeName(QName type) {
        this.schemaTypeName = type;
    }
}
