/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.server.log;

import com.sun.tools.sjavac.Log;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LoggingOutputStream extends FilterOutputStream {

    private static final byte[] LINE_SEP = System.lineSeparator().getBytes();

    private final Log.Level level;
    private final String linePrefix;
    private EolTrackingByteArrayOutputStream buf = new EolTrackingByteArrayOutputStream();

    public LoggingOutputStream(OutputStream out, Log.Level level, String linePrefix) {
        super(out);
        this.level = level;
        this.linePrefix = linePrefix;
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b);
        buf.write(b);
        if (buf.isLineComplete()) {
            String line = new String(buf.toByteArray(), 0, buf.size() - LINE_SEP.length);
            Log.log(level, linePrefix + line);
            buf = new EolTrackingByteArrayOutputStream();
        }
    }

    private static class EolTrackingByteArrayOutputStream extends ByteArrayOutputStream {
        private static final byte[] EOL = System.lineSeparator().getBytes();
        private boolean isLineComplete() {
            if (count < EOL.length) {
                return false;
            }
            for (int i = 0; i < EOL.length; i++) {
                if (buf[count - EOL.length + i] != EOL[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
