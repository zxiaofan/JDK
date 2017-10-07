/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

/* FROM mail.jar */
package com.sun.xml.internal.org.jvnet.mimepull;

import java.io.*;

/**
 * This class is to support reading CRLF terminated lines that
 * contain only US-ASCII characters from an input stream. Provides
 * functionality that is similar to the deprecated
 * <code>DataInputStream.readLine()</code>. Expected use is to read
 * lines as String objects from a RFC822 stream.
 *
 * It is implemented as a FilterInputStream, so one can just wrap
 * this class around any input stream and read bytes from this filter.
 *
 * @author John Mani
 */

final class LineInputStream extends FilterInputStream {

    private char[] lineBuffer = null; // reusable byte buffer
    private static int MAX_INCR = 1024*1024;    // 1MB

    public LineInputStream(InputStream in) {
        super(in);
    }

    /**
     * Read a line containing only ASCII characters from the input
     * stream. A line is terminated by a CR or NL or CR-NL sequence.
     * A common error is a CR-CR-NL sequence, which will also terminate
     * a line.
     * The line terminator is not returned as part of the returned
     * String. Returns null if no data is available. <p>
     *
     * This class is similar to the deprecated
     * <code>DataInputStream.readLine()</code>
     */
    public String readLine() throws IOException {
        //InputStream in = this.in;
        char[] buf = lineBuffer;

        if (buf == null) {
            buf = lineBuffer = new char[128];
        }

        int c1;
        int room = buf.length;
        int offset = 0;

        while ((c1 = in.read()) != -1) {
            if (c1 == '\n') {
                break;
            } else if (c1 == '\r') {
                // Got CR, is the next char NL ?
                boolean twoCRs = false;
                if (in.markSupported()) {
                    in.mark(2);
                }
                int c2 = in.read();
                if (c2 == '\r') {               // discard extraneous CR
                    twoCRs = true;
                    c2 = in.read();
                }
                if (c2 != '\n') {
                    /*
                     * If the stream supports it (which we hope will always
                     * be the case), reset to after the first CR.  Otherwise,
                     * we wrap a PushbackInputStream around the stream so we
                     * can unread the characters we don't need.  The only
                     * problem with that is that the caller might stop
                     * reading from this LineInputStream, throw it away,
                     * and then start reading from the underlying stream.
                     * If that happens, the pushed back characters will be
                     * lost forever.
                     */
                    if (in.markSupported()) {
                        in.reset();
                    } else {
                        if (!(in instanceof PushbackInputStream)) {
                            in /*= this.in*/ = new PushbackInputStream(in, 2);
                        }
                        if (c2 != -1) {
                            ((PushbackInputStream)in).unread(c2);
                        }
                        if (twoCRs) {
                            ((PushbackInputStream)in).unread('\r');
                        }
                    }
                }
                break; // outa here.
            }

            // Not CR, NL or CR-NL ...
            // .. Insert the byte into our byte buffer
            if (--room < 0) { // No room, need to grow.
                if (buf.length < MAX_INCR) {
                    buf = new char[buf.length * 2];
                } else {
                    buf = new char[buf.length + MAX_INCR];
                }
                room = buf.length - offset - 1;
                System.arraycopy(lineBuffer, 0, buf, 0, offset);
                lineBuffer = buf;
            }
            buf[offset++] = (char)c1;
        }

        if ((c1 == -1) && (offset == 0)) {
            return null;
        }

        return String.copyValueOf(buf, 0, offset);
    }
}
