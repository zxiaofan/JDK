/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.org.jvnet.staxex;

import javax.activation.DataHandler;

/**
 * BinaryText represents a MTOM attachment.
 *
 * @author shih-chang.chen@oracle.com
 */
public interface BinaryText {
    public String getHref();
    public DataHandler getDataHandler();
}
