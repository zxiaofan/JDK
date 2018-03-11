/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package java.awt.peer;

import java.awt.Dimension;

/**
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface ListPeer extends ComponentPeer {
    int[] getSelectedIndexes();
    void add(String item, int index);
    void delItems(int start, int end);
    void removeAll();
    void select(int index);
    void deselect(int index);
    void makeVisible(int index);
    void setMultipleMode(boolean b);
    Dimension getPreferredSize(int rows);
    Dimension getMinimumSize(int rows);

    /**
     * DEPRECATED:  Replaced by add(String, int).
     */
    void addItem(String item, int index);

    /**
     * DEPRECATED:  Replaced by removeAll().
     */
    void clear();

    /**
     * DEPRECATED:  Replaced by setMultipleMode(boolean).
     */
    void setMultipleSelections(boolean v);

    /**
     * DEPRECATED:  Replaced by getPreferredSize(int).
     */
    Dimension preferredSize(int v);

    /**
     * DEPRECATED:  Replaced by getMinimumSize(int).
     */
    Dimension minimumSize(int v);
}
