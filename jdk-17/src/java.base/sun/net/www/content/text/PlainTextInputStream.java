/*
 * Copyright (c) 1996, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.www.content.text;
import java.io.InputStream;
import java.io.FilterInputStream;

/**
 * PlainTextInputStream class extends the FilterInputStream class.
 * Currently all calls to the PlainTextInputStream object will call
 * the corresponding methods in the FilterInputStream class.  Hence
 * for now its use is more semantic.
 *
 * @author Sunita Mani
 */
public class PlainTextInputStream extends FilterInputStream {

    /**
     * Calls FilterInputStream's constructor.
     * @param is an InputStream
     */
    PlainTextInputStream(InputStream is) {
        super(is);
    }
}
