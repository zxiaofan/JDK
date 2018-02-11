/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.incubator.http.internal.hpack;

import java.nio.ByteBuffer;

interface BinaryRepresentationWriter {

    boolean write(HeaderTable table, ByteBuffer destination);

    BinaryRepresentationWriter reset();
}
