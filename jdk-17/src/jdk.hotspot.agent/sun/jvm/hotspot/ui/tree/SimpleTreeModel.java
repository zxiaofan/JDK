/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.ui.tree;

import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

/** A very simple tree model which allows the root to be set, so we
    can reuse the same model for various types of data; the
    specialization is contained within the nodes. This tree model
    operates on SimpleTreeNodes. */

public class SimpleTreeModel implements TreeModel {
  private static final SimpleTreeNode singletonNullRoot = new SimpleTreeNode() {
      public int getChildCount()                        { return 0;      }
      public SimpleTreeNode getChild(int index)         { return null;   }
      public boolean isLeaf()                           { return true;   }
      public int getIndexOfChild(SimpleTreeNode child)  { return 0;      }
      public String toString()                          { return ""; }
      public String getName()                           { return toString(); }
      public String getValue()                          { return toString(); }
    };
  private SimpleTreeNode root = singletonNullRoot;
  private List<TreeModelListener> listeners = new ArrayList<>();

  public void setRoot(SimpleTreeNode node) {
    if (node != null) {
      root = node;
    } else {
      root = singletonNullRoot;
    }
    fireTreeStructureChanged();
  }

  public Object getRoot() {
    return root;
  }

  public Object getChild(Object parent, int index) {
    return ((SimpleTreeNode) parent).getChild(index);
  }

  public int getChildCount(Object parent) {
    return ((SimpleTreeNode) parent).getChildCount();
  }

  public boolean isLeaf(Object node) {
    if (node == null) {
      return true;
    }
    return ((SimpleTreeNode) node).isLeaf();
  }

  /** Unsupported operation */
  public void valueForPathChanged(TreePath path, Object newValue) {
    throw new UnsupportedOperationException();
  }

  public int getIndexOfChild(Object parent, Object child) {
    return ((SimpleTreeNode) parent).getIndexOfChild((SimpleTreeNode) child);
  }

  public void addTreeModelListener(TreeModelListener l) {
    listeners.add(l);
  }

  public void removeTreeModelListener(TreeModelListener l) {
    listeners.remove(l);
  }

  public void fireTreeStructureChanged() {
    TreeModelEvent e = new TreeModelEvent(getRoot(), new Object[] { getRoot() }, null, null);
    for (Iterator iter = listeners.iterator(); iter.hasNext(); ) {
      TreeModelListener l = (TreeModelListener) iter.next();
      l.treeStructureChanged(e);
    }
  }
}
