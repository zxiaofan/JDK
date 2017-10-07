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

package com.sun.xml.internal.ws.fault;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Locale;

/**
 * <pre>
 *    &lt;env:Text xml:lang="en">Sender Timeout</env:Text>
 * </pre>
 */
@XmlType(name = "TextType", namespace = "http://www.w3.org/2003/05/soap-envelope")
class TextType {
    private @XmlValue String text;

    /**
     * xml:lang attribute. What should be value of namespace for "xml"
     */
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace", required = true)
    private String lang;

    TextType() {
    }

    TextType(String text) {
        this.text = text;
        this.lang = Locale.getDefault().getLanguage();
    }

    String getText(){
        return text;
    }
}
