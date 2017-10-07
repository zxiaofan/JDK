/*
 * Copyright (c) 2004, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.soap;

/**
 * A representation of a node (element) in an XML document.
 * This interface extends the standard DOM Node interface with methods for
 * getting and setting the value of a node, for
 * getting and setting the parent of a node, and for removing a node.
 *
 * @since 1.6
 */
public interface Node extends org.w3c.dom.Node {
    /**
     * Returns the value of this node if this is a {@code Text} node or the
     * value of the immediate child of this node otherwise.
     * If there is an immediate child of this {@code Node} that it is a
     * {@code Text} node then it's value will be returned. If there is
     * more than one {@code Text} node then the value of the first
     * {@code Text} Node will be returned.
     * Otherwise {@code null} is returned.
     *
     * @return a {@code String} with the text of this node if this is a
     *          {@code Text} node or the text contained by the first
     *          immediate child of this {@code Node} object that is a
     *          {@code Text} object if such a child exists;
     *          {@code null} otherwise.
     */
    public String getValue();

    /**
     * If this is a Text node then this method will set its value,
     * otherwise it sets the value of  the immediate (Text) child of this node.
     * The value of the immediate child of this node can be set only if, there is
     * one child node and that node is a {@code Text} node, or if
     * there are no children in which case a child {@code Text} node will be
     * created.
     *
     * @param value {@code value} to set on the {@code Text} node
     * @exception IllegalStateException if the node is not a {@code Text}
     *              node and either has more than one child node or has a child
     *              node that is not a {@code Text} node.
     *
     * @since 1.6, SAAJ 1.2
     */
    public void setValue(String value);

    /**
     * Sets the parent of this {@code Node} object to the given
     * {@code SOAPElement} object.
     *
     * @param parent the {@code SOAPElement} object to be set as
     *       the parent of this {@code Node} object
     *
     * @exception SOAPException if there is a problem in setting the
     *                          parent to the given element
     * @see #getParentElement
     */
    public void setParentElement(SOAPElement parent) throws SOAPException;

    /**
     * Returns the parent element of this {@code Node} object.
     * This method can throw an {@code UnsupportedOperationException}
     * if the tree is not kept in memory.
     *
     * @return the {@code SOAPElement} object that is the parent of
     *         this {@code Node} object or {@code null} if this
     *         {@code Node} object is root
     *
     * @exception UnsupportedOperationException if the whole tree is not
     *            kept in memory
     * @see #setParentElement
     */
    public SOAPElement getParentElement();

    /**
     * Removes this {@code Node} object from the tree.
     */
    public void detachNode();

    /**
     * Notifies the implementation that this {@code Node}
     * object is no longer being used by the application and that the
     * implementation is free to reuse this object for nodes that may
     * be created later.
     * <P>
     * Calling the method {@code recycleNode} implies that the method
     * {@code detachNode} has been called previously.
     */
    public void recycleNode();

}
