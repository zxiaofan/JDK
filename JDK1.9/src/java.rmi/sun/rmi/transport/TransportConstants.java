/*
 * Copyright (c) 1996, Oracle and/or its affiliates. All rights reserved.
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

package sun.rmi.transport;

public class TransportConstants {
    /** Transport magic number: "JRMI"*/
    public static final int Magic = 0x4a524d49;
    /** Transport version number */
    public static final short Version = 2;

    /** Connection uses stream protocol */
    public static final byte StreamProtocol = 0x4b;
    /** Protocol for single operation per connection; no ack required */
    public static final byte SingleOpProtocol = 0x4c;
    /** Connection uses multiplex protocol */
    public static final byte MultiplexProtocol = 0x4d;

    /** Ack for transport protocol */
    public static final byte ProtocolAck = 0x4e;
    /** Negative ack for transport protocol (protocol not supported) */
    public static final byte ProtocolNack = 0x4f;

    /** RMI call */
    public static final byte Call = 0x50;
    /** RMI return */
    public static final byte Return = 0x51;
    /** Ping operation */
    public static final byte Ping = 0x52;
    /** Acknowledgment for Ping operation */
    public static final byte PingAck = 0x53;
    /** Acknowledgment for distributed GC */
    public static final byte DGCAck = 0x54;

    /** Normal return (with or without return value) */
    public static final byte NormalReturn = 0x01;
    /** Exceptional return */
    public static final byte ExceptionalReturn = 0x02;
}
