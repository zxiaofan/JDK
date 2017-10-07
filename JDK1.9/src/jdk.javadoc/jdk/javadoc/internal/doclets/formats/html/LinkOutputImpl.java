/*
 * Copyright (c) 2003, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.formats.html;

import jdk.javadoc.internal.doclets.toolkit.util.links.LinkOutput;

/**
 * Stores output of a link.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 */
public class LinkOutputImpl implements LinkOutput {

    /**
     * The output of the link.
     */
    public StringBuilder output;

    /**
     * Construct a new LinkOutputImpl.
     */
    public LinkOutputImpl() {
        output = new StringBuilder();
    }

    /**
     * {@inheritDoc}
     */
    public void append(Object o) {
        output.append(o instanceof String ?
            (String) o : ((LinkOutputImpl)o).toString());
    }

    /**
     * {@inheritDoc}
     */
    public void insert(int offset, Object o) {
        output.insert(offset, o.toString());
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return output.toString();
    }

}
