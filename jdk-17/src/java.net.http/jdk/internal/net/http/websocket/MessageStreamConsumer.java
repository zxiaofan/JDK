/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http.websocket;

import java.nio.ByteBuffer;

/*
 * A callback for consuming messages and related events on the stream.
 */
interface MessageStreamConsumer {

    void onText(CharSequence data, boolean last);

    void onBinary(ByteBuffer data, boolean last);

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
