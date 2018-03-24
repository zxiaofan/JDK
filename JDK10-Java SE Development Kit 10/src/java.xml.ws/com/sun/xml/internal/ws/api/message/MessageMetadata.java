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

package com.sun.xml.internal.ws.api.message;

import com.sun.xml.internal.ws.api.model.WSDLOperationMapping;

/**
 * In order for the Message to get properties from the Packet ...
 *
 * @author shih-chang.chen@oracle.com
 */
public interface MessageMetadata {
    public WSDLOperationMapping getWSDLOperationMapping();
}
