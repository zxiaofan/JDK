/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.xmlschema.bindinfo;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Represents three constants of globalBindings/@optionalProperty.
 *
 * @author Kohsuke Kawaguchi
 */
public enum OptionalPropertyMode {
    @XmlEnumValue("primitive")
    PRIMITIVE,
    @XmlEnumValue("wrapper")
    WRAPPER,
    @XmlEnumValue("isSet")
    ISSET
}
