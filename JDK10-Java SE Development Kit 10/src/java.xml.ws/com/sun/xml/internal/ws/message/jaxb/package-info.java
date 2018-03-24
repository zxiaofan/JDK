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

/**
 * {@link com.sun.xml.internal.ws.api.message.Message} implementation for JAXB.
 *
 * <pre>
 * TODO:
 *      Because a producer of a message doesn't generally know
 *      when a message is consumed, it's difficult for
 *      the caller to do a proper instance caching. Perhaps
 *      there should be a layer around JAXBContext that does that?
 * </pre>
 */
package com.sun.xml.internal.ws.message.jaxb;

import com.sun.xml.internal.ws.api.message.Message;
