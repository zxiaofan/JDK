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

import com.sun.codemodel.internal.JClass;
import com.sun.tools.internal.ws.processor.model.java.JavaException;
import com.sun.tools.internal.ws.wsdl.framework.Entity;

import javax.xml.namespace.QName;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author WS Development Team
 */
public class Fault extends ModelObject {

    public Fault(Entity entity) {
        super(entity);
    }

    public Fault(String name, Entity entity) {
        super(entity);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block b) {
        block = b;
    }

    public JavaException getJavaException() {
        return javaException;
    }

    public void setJavaException(JavaException e) {
        javaException = e;
    }

    public void accept(ModelVisitor visitor) throws Exception {
        visitor.visit(this);
    }

    public Iterator getSubfaults() {
        if (subfaults.isEmpty()) {
            return null;
        }
        return subfaults.iterator();
    }

    /* serialization */
    public Set getSubfaultsSet() {
        return subfaults;
    }

    /* serialization */
    public void setSubfaultsSet(Set s) {
        subfaults = s;
    }

    public Iterator getAllFaults() {
        Set allFaults = getAllFaultsSet();
        if (allFaults.isEmpty()) {
            return null;
        }
        return allFaults.iterator();
    }

    public Set getAllFaultsSet() {
        Set transSet = new HashSet();
        Iterator iter = subfaults.iterator();
        while (iter.hasNext()) {
            transSet.addAll(((Fault)iter.next()).getAllFaultsSet());
        }
        transSet.addAll(subfaults);
        return transSet;
    }

    public QName getElementName() {
        return elementName;
    }

    public void setElementName(QName elementName) {
        this.elementName = elementName;
    }

    public String getJavaMemberName() {
        return javaMemberName;
    }

    public void setJavaMemberName(String javaMemberName) {
        this.javaMemberName = javaMemberName;
    }

    /**
     * @return Returns the wsdlFault.
     */
    public boolean isWsdlException() {
            return wsdlException;
    }
    /**
     * @param wsdlFault The wsdlFault to set.
     */
    public void setWsdlException(boolean wsdlFault) {
            this.wsdlException = wsdlFault;
    }

    public void setExceptionClass(JClass ex){
        exceptionClass = ex;
    }

    public JClass getExceptionClass(){
        return exceptionClass;
    }

    private boolean wsdlException = true;
    private String name;
    private Block block;
    private JavaException javaException;
    private Set subfaults = new HashSet();
    private QName elementName = null;
    private String javaMemberName = null;
    private JClass exceptionClass;

    public String getWsdlFaultName() {
        return wsdlFaultName;
    }

    public void setWsdlFaultName(String wsdlFaultName) {
        this.wsdlFaultName = wsdlFaultName;
    }

    private String wsdlFaultName;
}
