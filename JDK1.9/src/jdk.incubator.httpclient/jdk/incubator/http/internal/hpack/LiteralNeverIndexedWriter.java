/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

final class LiteralNeverIndexedWriter extends IndexNameValueWriter {

    LiteralNeverIndexedWriter() {
        super(0b0001_0000, 4);
    }
}
