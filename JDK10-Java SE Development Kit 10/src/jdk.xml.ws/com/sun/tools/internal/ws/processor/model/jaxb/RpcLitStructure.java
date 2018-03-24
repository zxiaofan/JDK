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
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek Pandey
 *
 * RPC Structure that will be used to create RpcLitPayload latter
 */
public class RpcLitStructure extends AbstractType {
    private List<RpcLitMember> members;
    private JAXBModel jaxbModel;

    /**
     *
     */
    public RpcLitStructure() {
        super();
        // TODO Auto-generated constructor stub
    }
    public RpcLitStructure(QName name, JAXBModel jaxbModel){
        setName(name);
        this.jaxbModel = jaxbModel;
        this.members = new ArrayList<RpcLitMember>();

    }
    public RpcLitStructure(QName name, JAXBModel jaxbModel, List<RpcLitMember> members){
        setName(name);
        this.members = members;
    }

    public void accept(JAXBTypeVisitor visitor) throws Exception {
        visitor.visit(this);
    }

    public List<RpcLitMember> getRpcLitMembers(){
        return members;
    }

    public List<RpcLitMember> setRpcLitMembers(List<RpcLitMember> members){
        return this.members = members;
    }

    public void addRpcLitMember(RpcLitMember member){
        members.add(member);
    }
    /**
     * @return Returns the jaxbModel.
     */
    public JAXBModel getJaxbModel() {
        return jaxbModel;
    }
    /**
     * @param jaxbModel The jaxbModel to set.
     */
    public void setJaxbModel(JAXBModel jaxbModel) {
        this.jaxbModel = jaxbModel;
    }

    public boolean isLiteralType() {
        return true;
    }
}
