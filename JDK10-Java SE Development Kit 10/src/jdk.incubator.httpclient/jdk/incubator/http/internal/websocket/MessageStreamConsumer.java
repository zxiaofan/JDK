/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

    void onText(CharSequence data, MessagePart part);

    void onBinary(ByteBuffer data, MessagePart part);

    void onPing(ByteBuffer data);

    void onPong(ByteBuffer data);

    void onClose(int statusCode, CharSequence reason);

    /*
     * Indicates the end of stream has been reached and there will be no further
     * messages.
     */
    void onComplete();

    void onError(Throwable e);
}
