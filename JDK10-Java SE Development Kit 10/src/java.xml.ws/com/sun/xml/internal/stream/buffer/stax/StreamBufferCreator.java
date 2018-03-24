/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.buffer.stax;

import com.sun.xml.internal.stream.buffer.AbstractCreator;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link AbstractCreator} with additional convenience code.
 *
 * @author Paul Sandoz
 * @author Venu
 * @author Kohsuke Kawaguchi
 */
abstract class StreamBufferCreator extends AbstractCreator {

    private boolean checkAttributeValue = false;

    protected List<String> attributeValuePrefixes = new ArrayList<String>();

    protected void storeQualifiedName(int item, String prefix, String uri, String localName) {
        if (uri != null && uri.length() > 0) {
            if (prefix != null && prefix.length() > 0) {
                item |= FLAG_PREFIX;
                storeStructureString(prefix);
            }

            item |= FLAG_URI;
            storeStructureString(uri);
        }

        storeStructureString(localName);

        storeStructure(item);
    }

    protected final void storeNamespaceAttribute(String prefix, String uri) {
        int item = T_NAMESPACE_ATTRIBUTE;

        if (prefix != null && prefix.length() > 0) {
            item |= FLAG_PREFIX;
            storeStructureString(prefix);
        }

        if (uri != null && uri.length() > 0) {
            item |= FLAG_URI;
            storeStructureString(uri);
        }

        storeStructure(item);
    }

    protected final void storeAttribute(String prefix, String uri, String localName, String type, String value) {
        storeQualifiedName(T_ATTRIBUTE_LN, prefix, uri, localName);

        storeStructureString(type);
        storeContentString(value);
        if(checkAttributeValue && value.indexOf("://") == -1){  // the condition after && avoids looking inside URIs
            int firstIndex = value.indexOf(":");
            int lastIndex = value.lastIndexOf(":");  // Check last index of : as some SAML namespace have multiple ":"s
            if(firstIndex != -1 && lastIndex == firstIndex){
                String valuePrefix = value.substring(0, firstIndex);
                if(!attributeValuePrefixes.contains(valuePrefix)){
                    attributeValuePrefixes.add(valuePrefix);
                }
            }
        }
    }

    public final List getAttributeValuePrefixes(){
        return attributeValuePrefixes;
    }

    protected final void storeProcessingInstruction(String target, String data) {
        storeStructure(T_PROCESSING_INSTRUCTION);
        storeStructureString(target);
        storeStructureString(data);
    }

    public final boolean isCheckAttributeValue(){
        return checkAttributeValue;
    }

    public final void setCheckAttributeValue(boolean value){
        this.checkAttributeValue = value;
    }
}
