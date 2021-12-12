/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;

/**
 * A helper class which prints the content of input streams to print streams.
 */
public class PrintStreamPrinter {

    /**
     * Reads characters in UTF-8 format from the input stream and prints them
     * with the given print stream. Closes the input stream before it returns.
     *
     * @return The number of printed characters.
     */
    public static long drainUTF8(InputStream is, PrintStream ps) throws IOException {
        long result = 0;

        try (BufferedInputStream bis = new BufferedInputStream(is);
             InputStreamReader isr = new InputStreamReader(bis, "UTF-8")) {
            char c[] = new char[256];
            int n;

            do {
                n = isr.read(c);

                if (n > 0) {
                    result += n;
                    ps.print(n == c.length ? c : Arrays.copyOf(c, n));
                }
            } while (n > 0);
        }

        return result;
    }
}
