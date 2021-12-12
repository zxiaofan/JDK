/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

/*
 * Utilities for WebSocket status codes.
 *
 *     1. https://tools.ietf.org/html/rfc6455#section-7.4
 *     2. http://www.iana.org/assignments/websocket/websocket.xhtml#close-code-number
 */
final class StatusCodes {

    static final int PROTOCOL_ERROR    = 1002;
    static final int NO_STATUS_CODE    = 1005;
    static final int CLOSED_ABNORMALLY = 1006;
    static final int NOT_CONSISTENT    = 1007;

    private StatusCodes() { }

    static boolean isLegalToSendFromClient(int code) {
        if (!isLegal(code)) {
            return false;
        }
        // Codes from unreserved range
        if (code > 4999) {
            return false;
        }
        // Codes below are not allowed to be sent using a WebSocket client API
        return switch (code) {
            // 1012, 1013, 1014: codes sent by servers
            case PROTOCOL_ERROR, NOT_CONSISTENT, 1003, 1009, 1010, 1012, 1013, 1014 -> false;
            default -> true;
        };
    }

    static boolean isLegalToReceiveFromServer(int code) {
        if (!isLegal(code)) {
            return false;
        }
        return code != 1010;  // code sent by clients
    }

    private static boolean isLegal(int code) {
        // 2-byte unsigned integer excluding first 1000 numbers from the range
        // [0, 999] which are never used
        if (code < 1000 || code > 65535) {
            return false;
        }
        // Codes from the range below has no known meaning under the WebSocket
        // specification (i.e. unassigned/undefined)
        if ((code >= 1016 && code <= 2999) || code == 1004) {
            return false;
        }
        // Codes below cannot appear on the wire. It's always an error either
        // to send a frame with such a code or to receive one.
        return switch (code) {
            case NO_STATUS_CODE, CLOSED_ABNORMALLY, 1015 -> false;
            default -> true;
        };
    }
}
