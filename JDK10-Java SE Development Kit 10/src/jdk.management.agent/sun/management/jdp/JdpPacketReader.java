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

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * JdpPacketReader responsible for reading a packet <p>This class gets a byte
 * array as it came from a Net, validates it and breaks a part </p>
 */
public final class JdpPacketReader {

    private final DataInputStream pkt;
    private Map<String, String> pmap = null;

    /**
     * Create packet reader, extract and check magic and version
     *
     * @param packet - packet received from a Net
     * @throws JdpException
     */
    public JdpPacketReader(byte[] packet)
            throws JdpException {
        ByteArrayInputStream bais = new ByteArrayInputStream(packet);
        pkt = new DataInputStream(bais);

        try {
            int magic = pkt.readInt();
            JdpGenericPacket.checkMagic(magic);
        } catch (IOException e) {
            throw new JdpException("Invalid JDP packet received, bad magic");
        }

        try {
            short version = pkt.readShort();
            JdpGenericPacket.checkVersion(version);
        } catch (IOException e) {
            throw new JdpException("Invalid JDP packet received, bad protocol version");
        }
    }

    /**
     * Get next entry from packet
     *
     * @return the entry
     * @throws EOFException
     * @throws JdpException
     */
    public String getEntry()
            throws EOFException, JdpException {

        try {
            short len = pkt.readShort();
            // Artificial setting the "len" field to Short.MAX_VALUE may cause a reader to allocate
            // to much memory. Prevent this possible DOS attack.
            if (len < 1 && len > pkt.available()) {
                throw new JdpException("Broken JDP packet. Invalid entry length field.");
            }

            byte[] b = new byte[len];
            if (pkt.read(b) != len) {
                throw new JdpException("Broken JDP packet. Unable to read entry.");
            }
            return new String(b, "UTF-8");

        } catch (EOFException e) {
            throw e;
        } catch (UnsupportedEncodingException ex) {
            throw new JdpException("Broken JDP packet. Unable to decode entry.");
        } catch (IOException e) {
            throw new JdpException("Broken JDP packet. Unable to read entry.");
        }


    }

    /**
     * return packet content as a key/value map
     *
     * @return map containing packet entries pair of entries treated as
     * key,value
     * @throws IOException
     * @throws JdpException
     */
    public Map<String, String> getDiscoveryDataAsMap()
            throws JdpException {
        // return cached map if possible
        if (pmap != null) {
            return pmap;
        }

        String key = null, value = null;

        final Map<String, String> tmpMap = new HashMap<>();
        try {
            while (true) {
                key = getEntry();
                value = getEntry();
                tmpMap.put(key, value);
            }
        } catch (EOFException e) {
            // EOF reached on reading value, report broken packet
            // otherwise ignore it.
            if (value == null) {
                throw new JdpException("Broken JDP packet. Key without value." + key);
            }
        }

        pmap = Collections.unmodifiableMap(tmpMap);
        return pmap;
    }
}
