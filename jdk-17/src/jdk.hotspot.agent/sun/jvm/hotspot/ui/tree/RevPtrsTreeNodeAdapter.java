/*
 * Copyright (c) 2002, 2020, Oracle and/or its affiliates. All rights reserved.
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
import java.io.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.utilities.*;

/** Who directly points to this node. */

public class RevPtrsTreeNodeAdapter extends FieldTreeNodeAdapter {
  private static FieldIdentifier fid = new NamedFieldIdentifier("_revPtrs");

  private List<LivenessPathElement> children;

  public RevPtrsTreeNodeAdapter(Oop oop) {
    this(oop, false);
  }

  public RevPtrsTreeNodeAdapter(Oop oop, boolean treeTableMode) {
    super(fid, treeTableMode);
    children = VM.getVM().getRevPtrs().get(oop);
  }

  public int getChildCount() {
    return children != null ? children.size() : 0;
  }

  public SimpleTreeNode getChild(int index) {
    LivenessPathElement lpe = children.get(index);
    IndexableFieldIdentifier ifid = new IndexableFieldIdentifier(index);
    Oop oop = lpe.getObj();
    if (oop != null) {
      return new OopTreeNodeAdapter(oop, ifid, getTreeTableMode());
    } else {
      NamedFieldIdentifier nfi = (NamedFieldIdentifier)lpe.getField();
      return new RootTreeNodeAdapter(nfi.getName(), ifid, getTreeTableMode());
    }
  }

  public boolean isLeaf() {
    return false;
  }

  public int getIndexOfChild(SimpleTreeNode child) {
    FieldIdentifier id = ((FieldTreeNodeAdapter) child).getID();
    IndexableFieldIdentifier ifid = (IndexableFieldIdentifier)id;
    return ifid.getIndex();
  }

  public String getName()  { return "<<Reverse pointers>>"; }
  public String getValue() { return ""; }
}
