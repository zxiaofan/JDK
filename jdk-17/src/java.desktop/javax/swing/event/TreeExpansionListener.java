/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.event;

import java.util.EventListener;

/**
  * The listener that's notified when a tree expands or collapses
  * a node.
  * For further documentation and examples see
  * <a
  href="https://docs.oracle.com/javase/tutorial/uiswing/events/treeexpansionlistener.html">How to Write a Tree Expansion Listener</a>,
  * a section in <em>The Java Tutorial.</em>
  *
  * @author Scott Violet
  */

public interface TreeExpansionListener extends EventListener
{
    /**
     * Called whenever an item in the tree has been expanded.
     *
     * @param event a {@code TreeExpansionEvent} containing a {@code TreePath}
     *              object for the expanded node
     */
    public void treeExpanded(TreeExpansionEvent event);

    /**
     * Called whenever an item in the tree has been collapsed.
     *
     * @param event a {@code TreeExpansionEvent} containing a {@code TreePath}
     *              object for the collapsed node
     */
    public void treeCollapsed(TreeExpansionEvent event);
}
