/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
package sun.management.jdp;

import java.io.IOException;

/**
 * Packet to broadcast
 *
 * <p>Each packet have to contain MAGIC and PROTOCOL_VERSION in order to be
 * recognized as a valid JDP packet.</p>
 *
 * <p>Default implementation build packet as a set of UTF-8 encoded Key/Value pairs
 * are stored as an ordered list of values, and are sent to the server
 * in that order.</p>
 *
 * <p>
 * Packet structure:
 *
 * 4 bytes JDP magic (0xC0FFE42)
 * 2 bytes JDP protocol version (01)
 *
 * 2 bytes size of key
 * x bytes key (UTF-8 encoded)
 * 2 bytes size of value
 * x bytes value (UTF-8 encoded)
 *
 * repeat as many times as necessary ...
 * </p>
  */
public interface JdpPacket {

    /**
     * This method responsible to assemble packet and return a byte array
     * ready to be sent across a Net.
     *
     * @return assembled packet as an array of bytes
     * @throws IOException
     */
    public byte[] getPacketData() throws IOException;

}
