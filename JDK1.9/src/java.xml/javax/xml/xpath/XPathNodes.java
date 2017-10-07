/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.xpath;

import java.util.Iterator;
import org.w3c.dom.Node;

/**
 * XPathNodes represents a set of nodes selected by a location path as specified
 * in <a href="http://www.w3.org/TR/xpath/#node-sets">XML Path Language (XPath)
 * Version 1.0, 3.3 Node-sets</a>.
 *
 * @since 9
 */
public interface XPathNodes extends Iterable<Node> {

    /**
     * Returns an iterator of the Nodes.
     *
     * @return an Iterator.
     */
    @Override
    public abstract Iterator<Node> iterator();

    /**
     * Returns the number of items in the result
     *
     * @return The number of items in the result
     */
    public abstract int size();

    /**
     * Returns a Node at the specified position
     *
     * @param index Index of the element to return.
     * @return The Node at the specified position.
     * @throws javax.xml.xpath.XPathException If the index is out of range
     * (index &lt; 0 || index &gt;= size())
     */
    public abstract Node get(int index)
            throws XPathException;
}
