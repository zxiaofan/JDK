/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.nio.sctp;

/**
 * Defines notification handler results.
 *
 * <P> The {@code HandlerResult} is used to determine the behavior of the
 * channel after it handles a notification from the SCTP stack. Essentially its
 * value determines if the channel should try to receive another notification or
 * a message before returning.
 *
 * @since 1.7
 */
public enum HandlerResult {
    /**
     * Try to receieve another message or notification.
     */
    CONTINUE,

    /**
     * Return without trying to receive any more data.
     */
    RETURN;
}
