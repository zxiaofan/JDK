/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
 * A SOAPElement implementation may support this interface to allow MTOM attachments.
 *
 * @author shih-chang.chen@oracle.com
 */
public interface MtomEnabled {
    BinaryText addBinaryText(byte[] bytes);
    BinaryText addBinaryText(String contentType, byte[] bytes);
    BinaryText addBinaryText(String href, DataHandler dl);
}
