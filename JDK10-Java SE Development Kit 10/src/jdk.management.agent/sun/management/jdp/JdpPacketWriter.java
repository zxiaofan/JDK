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

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * JdpPacketWriter responsible for writing a packet
 * <p>This class assembles a set of key/value pairs to valid JDP packet,
 * ready to be sent across a Net</p>
 */
public final class JdpPacketWriter {

    private final ByteArrayOutputStream baos;
    private final DataOutputStream pkt;

    /**
     * Create a JDP packet, add mandatory magic and version headers
     *
     * @throws IOException
     */
    public JdpPacketWriter()
            throws IOException {
        baos = new ByteArrayOutputStream();
        pkt = new DataOutputStream(baos);

        pkt.writeInt(JdpGenericPacket.getMagic());
        pkt.writeShort(JdpGenericPacket.getVersion());
    }

    /**
     * Put string entry to packet
     *
     * @param entry - string to put (utf-8 encoded)
     * @throws IOException
     */
    public void addEntry(String entry)
            throws IOException {
        /* DataOutputStream.writeUTF() do essentially
         *  the same as:
         *    pkt.writeShort(entry.getBytes("UTF-8").length);
         *    pkt.write(entry.getBytes("UTF-8"));
         */
        pkt.writeUTF(entry);
    }

    /**
     * Put key/value pair to packet
     *
     * @param key - key to put (utf-8 encoded)
     * @param val - value to put (utf-8 encoded)
     * @throws IOException
     */
    public void addEntry(String key, String val)
            throws IOException {
        /* Silently skip key if value is null.
         * We don't need to distinguish between key missing
         * and key has no value cases
         */
        if (val != null) {
            addEntry(key);
            addEntry(val);
        }
    }

    /**
     * Return assembled packet as a byte array
     *
     * @return packet bytes
     */
    public byte[] getPacketBytes() {
        return baos.toByteArray();
    }
}
