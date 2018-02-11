/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset.tools;

import com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSource;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class FI_SAX_XML extends TransformInputOutput {

    public FI_SAX_XML() {
    }

    public void parse(InputStream finf, OutputStream xml) throws Exception {
        Transformer tx = TransformerFactory.newInstance().newTransformer();
        tx.transform(new FastInfosetSource(finf), new StreamResult(xml));
    }

    public static void main(String[] args) throws Exception {
        FI_SAX_XML p = new FI_SAX_XML();
        p.parse(args);
    }
}
