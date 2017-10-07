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

package jdk.incubator.http.internal.websocket;

import jdk.incubator.http.WebSocket.MessagePart;

import java.nio.ByteBuffer;

/*
 * A callback for consuming messages and related events on the stream.
 */
interface MessageStreamConsumer {

    void onText(MessagePart part, CharSequence data);

    void onBinary(MessagePart part, ByteBuffer data);

    void onPing(ByteBuffer data);

    void onPong(ByteBuffer data);

    void onClose(int statusCode, CharSequence reason);

    void onError(Exception e);

    /*
     * Indicates the end of stream has been reached and there will be no further
     * messages.
     */
    void onComplete();
}
