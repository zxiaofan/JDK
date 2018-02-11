/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset.stax;

import java.util.HashMap;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import com.sun.xml.internal.fastinfoset.CommonResourceBundle;

public class StAXManager {
    protected static final String STAX_NOTATIONS = "javax.xml.stream.notations";
    protected static final String STAX_ENTITIES = "javax.xml.stream.entities";

    HashMap features = new HashMap();

    public static final int CONTEXT_READER = 1;
    public static final int CONTEXT_WRITER = 2;


    /** Creates a new instance of StAXManager */
    public StAXManager() {
    }

    public StAXManager(int context) {
        switch(context){
            case CONTEXT_READER:{
                initConfigurableReaderProperties();
                break;
            }
            case CONTEXT_WRITER:{
                initWriterProps();
                break;
            }
        }
    }

    public StAXManager(StAXManager manager){

        HashMap properties = manager.getProperties();
        features.putAll(properties);
    }

    private HashMap getProperties(){
        return features ;
    }

    private void initConfigurableReaderProperties(){
        //spec v1.0 default values
        features.put(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.TRUE);
        features.put(XMLInputFactory.IS_VALIDATING, Boolean.FALSE);
        features.put(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.TRUE);
        features.put(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.TRUE);
        features.put(XMLInputFactory.IS_COALESCING, Boolean.FALSE);
        features.put(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);
        features.put(XMLInputFactory.REPORTER, null);
        features.put(XMLInputFactory.RESOLVER, null);
        features.put(XMLInputFactory.ALLOCATOR, null);
        features.put(STAX_NOTATIONS,null );
    }

    private void initWriterProps(){
        features.put(XMLOutputFactory.IS_REPAIRING_NAMESPACES , Boolean.FALSE);
    }

    /**
     * public void reset(){
     * features.clear() ;
     * }
     */
    public boolean containsProperty(String property){
        return features.containsKey(property) ;
    }

    public Object getProperty(String name){
        checkProperty(name);
        return features.get(name);
    }

    public void setProperty(String name, Object value){
        checkProperty(name);
        if (name.equals(XMLInputFactory.IS_VALIDATING) &&
                Boolean.TRUE.equals(value)){
            throw new IllegalArgumentException(CommonResourceBundle.getInstance().getString("message.validationNotSupported") +
                    CommonResourceBundle.getInstance().getString("support_validation"));
        } else if (name.equals(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES) &&
                Boolean.TRUE.equals(value)) {
            throw new IllegalArgumentException(CommonResourceBundle.getInstance().getString("message.externalEntities") +
                    CommonResourceBundle.getInstance().getString("resolve_external_entities_"));
        }
        features.put(name,value);

    }

    public void checkProperty(String name) {
        if (!features.containsKey(name))
            throw new IllegalArgumentException(CommonResourceBundle.getInstance().getString("message.propertyNotSupported", new Object[]{name}));
    }

    public String toString(){
        return features.toString();
    }

}
