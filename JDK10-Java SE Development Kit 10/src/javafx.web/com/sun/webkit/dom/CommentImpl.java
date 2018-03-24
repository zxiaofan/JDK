/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.dom;

import org.w3c.dom.Comment;

public class CommentImpl extends CharacterDataImpl implements Comment {
    CommentImpl(long peer) {
        super(peer);
    }

    static Comment getImpl(long peer) {
        return (Comment)create(peer);
    }

}

