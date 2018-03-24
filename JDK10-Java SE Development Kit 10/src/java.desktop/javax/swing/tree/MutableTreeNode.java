/*
 * Copyright (c) 1997, 1999, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.tree;

/**
 * Defines the requirements for a tree node object that can change --
 * by adding or removing child nodes, or by changing the contents
 * of a user object stored in the node.
 *
 * @see DefaultMutableTreeNode
 * @see javax.swing.JTree
 *
 * @author Rob Davis
 * @author Scott Violet
 */

public interface MutableTreeNode extends TreeNode
{
    /**
     * Adds <code>child</code> to the receiver at <code>index</code>.
     * <code>child</code> will be messaged with <code>setParent</code>.
     *
     * @param child node to be added
     * @param index index of the receiver
     */
    void insert(MutableTreeNode child, int index);

    /**
     * Removes the child at <code>index</code> from the receiver.
     *
     * @param index index of child to be removed
     */
    void remove(int index);

    /**
     * Removes <code>node</code> from the receiver. <code>setParent</code>
     * will be messaged on <code>node</code>.
     *
     * @param node node to be removed from the receiver
     */
    void remove(MutableTreeNode node);

    /**
     * Resets the user object of the receiver to <code>object</code>.
     *
     * @param object object to be set as a receiver
     */
    void setUserObject(Object object);

    /**
     * Removes the receiver from its parent.
     */
    void removeFromParent();

    /**
     * Sets the parent of the receiver to <code>newParent</code>.
     *
     * @param newParent node to be set as parent of the receiver
     */
    void setParent(MutableTreeNode newParent);
}
