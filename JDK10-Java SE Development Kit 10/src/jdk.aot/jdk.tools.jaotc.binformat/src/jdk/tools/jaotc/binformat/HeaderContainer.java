/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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
 */

package jdk.tools.jaotc.binformat;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class HeaderContainer {

    private static final int CURRENT_VERSION = 1;
    private final ReadOnlyDataContainer container;

    // int _version;
    // int _class_count;
    // int _method_count;
    // int _klasses_got_size;
    // int _metadata_got_size;
    // int _oop_got_size;
    // int _jvm_version_offset;

    public HeaderContainer(String jvmVersion, ReadOnlyDataContainer container) {
        try {
            byte[] filler = new byte[4 * 7];
            container.appendBytes(filler);

            // Store JVM version string at the end of header section.
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(bout);
            out.writeUTF(jvmVersion);
            out.writeShort(0); // Terminate by 0.
            byte[] b = bout.toByteArray();
            container.appendBytes(b, 0, b.length);
        } catch (IOException e) {
            throw new InternalError("Failed to append bytes to header section", e);
        }

        this.container = container;
        this.container.putIntAt(0 * 4, CURRENT_VERSION);
        this.container.putIntAt(6 * 4, 7 * 4); // JVM version string offset
    }

    public String getContainerName() {
        return container.getContainerName();
    }

    public ReadOnlyDataContainer getContainer() {
        return container;
    }

    public void setClassesCount(int count) {
        this.container.putIntAt(1 * 4, count);
    }

    public void setMethodsCount(int count) {
        this.container.putIntAt(2 * 4, count);
    }

    public void setKlassesGotSize(int size) {
        this.container.putIntAt(3 * 4, size);
    }

    public void setMetadataGotSize(int size) {
        this.container.putIntAt(4 * 4, size);
    }

    public void setOopGotSize(int size) {
        this.container.putIntAt(5 * 4, size);
    }

}
