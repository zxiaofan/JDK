/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvmstat.perfdata.monitor.protocol.file;

import sun.jvmstat.monitor.*;
import sun.jvmstat.perfdata.monitor.*;
import java.io.*;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * The concrete PerfDataBuffer implementation for the <em>file:</em>
 * protocol for the HotSpot PerfData monitoring implemetation.
 * <p>
 * This class is responsible for acquiring access to the instrumentation
 * buffer stored in a file referenced by a file URI.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class PerfDataBuffer extends AbstractPerfDataBuffer {

    /**
     * Create a PerfDataBuffer instance for accessing the specified
     * instrumentation buffer.
     *
     * @param vmid the <em>file:</em> URI to the instrumentation buffer file
     *
     * @throws MonitorException
     */
    public PerfDataBuffer(VmIdentifier vmid) throws MonitorException {
        File f = new File(vmid.getURI());
        String mode = vmid.getMode();

        try {
            FileChannel fc = new RandomAccessFile(f, mode).getChannel();
            ByteBuffer bb = null;

            if (mode.compareTo("r") == 0) {
                bb = fc.map(FileChannel.MapMode.READ_ONLY, 0L, (int)fc.size());
            } else if (mode.compareTo("rw") == 0) {
                bb = fc.map(FileChannel.MapMode.READ_WRITE, 0L, (int)fc.size());
            } else {
                throw new IllegalArgumentException("Invalid mode: " + mode);
            }

            fc.close();               // doesn't need to remain open

            createPerfDataBuffer(bb, 0);
        } catch (FileNotFoundException e) {
            throw new MonitorException("Could not find " + vmid.toString());
        } catch (IOException e) {
            throw new MonitorException("Could not read " + vmid.toString());
        }
    }
}
