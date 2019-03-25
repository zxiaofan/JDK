/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jaotc.binformat.pecoff;

import java.io.File;
import java.io.FileOutputStream;

final class PECoffContainer {

    private final File outputFile;
    private FileOutputStream outputStream;
    private long fileOffset;

    PECoffContainer(String fileName) {

        outputFile = new File(fileName);
        if (outputFile.exists()) {
            outputFile.delete();
        }

        try {
            outputStream = new FileOutputStream(outputFile);
        } catch (Exception e) {
            System.out.println("PECoffContainer: Can't create file " + fileName);
        }
        fileOffset = 0;
    }

    void close() {
        try {
            outputStream.close();
        } catch (Exception e) {
            System.out.println("PECoffContainer: close failed");
        }
    }

    void writeBytes(byte[] bytes) {
        if (bytes == null) {
            return;
        }
        try {
            outputStream.write(bytes);
        } catch (Exception e) {
            System.out.println("PECoffContainer: writeBytes failed");
        }
        fileOffset += bytes.length;
    }

    // Write bytes to output file with up front alignment padding
    void writeBytes(byte[] bytes, int alignment) {
        if (bytes == null) {
            return;
        }
        try {
            // Pad to alignment
            while ((fileOffset & (alignment - 1)) != 0) {
                outputStream.write(0);
                fileOffset++;
            }
            outputStream.write(bytes);
        } catch (Exception e) {
            System.out.println("PECoffContainer: writeBytes failed");
        }
        fileOffset += bytes.length;
    }
}
