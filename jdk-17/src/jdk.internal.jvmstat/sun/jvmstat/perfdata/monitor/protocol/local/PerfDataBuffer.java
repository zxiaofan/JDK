/*
 * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvmstat.perfdata.monitor.protocol.local;

import jdk.internal.perf.Perf;
import sun.jvmstat.monitor.*;
import sun.jvmstat.perfdata.monitor.*;
import java.util.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.lang.reflect.Constructor;
import java.security.AccessController;

/**
 * The concrete PerfDataBuffer implementation for the <em>local:</em>
 * protocol for the HotSpot PerfData monitoring implementation.
 * <p>
 * This class is responsible for acquiring access to the shared memory
 * instrumentation buffer for the target HotSpot Java Virtual Machine.
 *
 * @author Brian Doherty
 * @since 1.5
 */
// Suppreess unchecked conversion warning at line 34.
//@SuppressWarnings("unchecked")
public class PerfDataBuffer extends AbstractPerfDataBuffer {
    @SuppressWarnings("removal")
    private static final Perf perf = AccessController.doPrivileged(new Perf.GetPerfAction());

    /**
     * Create a PerfDataBuffer instance for accessing the specified
     * instrumentation buffer.
     *
     * @param vmid the <em>local:</em> URI specifying the target JVM.
     *
     * @throws MonitorException
     */
    public PerfDataBuffer(VmIdentifier vmid) throws MonitorException {
        try {
            // Try 1.4.2 and later first
            ByteBuffer bb = perf.attach(vmid.getLocalVmId(), vmid.getMode());
            createPerfDataBuffer(bb, vmid.getLocalVmId());

        } catch (IllegalArgumentException e) {
            // now try 1.4.1 by attempting to directly map the files.
            try {
                String filename = PerfDataFile.getTempDirectory()
                                  + PerfDataFile.dirNamePrefix
                                  + Integer.toString(vmid.getLocalVmId());

                File f = new File(filename);

                FileChannel fc = new RandomAccessFile(f, "r").getChannel();
                ByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0L,
                                       (int)fc.size());
                fc.close();
                createPerfDataBuffer(bb, vmid.getLocalVmId());

            } catch (FileNotFoundException e2) {
                // re-throw the exception from the 1.4.2 attach method
                throw new MonitorException(vmid.getLocalVmId() + " not found",
                                           e);
            } catch (IOException e2) {
                throw new MonitorException("Could not map 1.4.1 file for "
                                           + vmid.getLocalVmId(), e2);
            }
        } catch (IOException e) {
            throw new MonitorException("Could not attach to "
                                       + vmid.getLocalVmId(), e);
        }
    }
}
