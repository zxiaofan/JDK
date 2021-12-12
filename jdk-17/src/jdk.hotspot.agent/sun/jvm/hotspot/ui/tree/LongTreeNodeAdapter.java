/*
 * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
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

import sun.jvm.hotspot.oops.*;

/** Encapsulates a long value in a tree handled by SimpleTreeModel */

public class LongTreeNodeAdapter extends FieldTreeNodeAdapter {
  private long val;
  private boolean hexFormat = false;

  public LongTreeNodeAdapter(long val, FieldIdentifier id) {
    this(val, id, false);
  }

  public LongTreeNodeAdapter(long val, FieldIdentifier id, boolean treeTableMode) {
    super(id, treeTableMode);
    this.val = val;
  }

  public void setHexFormat(boolean hexFormat) {
    this.hexFormat = hexFormat;
  }

  public boolean getHexFormat() {
    return hexFormat;
  }

  public int getChildCount() {
    return 0;
  }

  public SimpleTreeNode getChild(int index) {
    return null;
  }

  public boolean isLeaf() {
    return true;
  }

  public int getIndexOfChild(SimpleTreeNode child) {
    return 0;
  }

  public String getValue() {
    if (hexFormat) {
      return "0x" + Long.toHexString(val);
    } else {
      return Long.toString(val);
    }
  }
}
