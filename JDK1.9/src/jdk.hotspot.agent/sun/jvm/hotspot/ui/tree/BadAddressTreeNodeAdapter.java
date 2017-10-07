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
 */

package sun.jvm.hotspot.ui.tree;

import java.io.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.runtime.VM;

/** Simple wrapper for displaying bad addresses in the Inspector */

public class BadAddressTreeNodeAdapter extends FieldTreeNodeAdapter {
  private String message;

  private static String generateMessage(long addr, String kind) {
    return "** BAD " + kind + " " + Long.toHexString(addr) + " **";
  }

  public BadAddressTreeNodeAdapter(Address addr, MetadataField field, boolean treeTableMode) {
    super(field.getID(), treeTableMode);
    message = generateMessage(addr.minus(null), "METADATA");
  }

  public BadAddressTreeNodeAdapter(Address addr, OopField field, boolean treeTableMode) {
    super(field.getID(), treeTableMode);
    message = generateMessage(addr.minus(null), "OOP");
  }

  public BadAddressTreeNodeAdapter(OopHandle addr, FieldIdentifier id, boolean treeTableMode) {
    super(id, treeTableMode);
    message = generateMessage(addr.minus(null), "OOP");
  }

  /** The address may be null (for address fields of structures which
      are null); the FieldIdentifier may also be null (for the root
      node). */
  public BadAddressTreeNodeAdapter(long addr, FieldIdentifier id, boolean treeTableMode) {
    super(id, treeTableMode);
    message = generateMessage(addr, "ADDRESS");
  }

  public int getChildCount() {
    return 0;
  }

  public SimpleTreeNode getChild(int index) {
    throw new RuntimeException("Should not call this");
  }

  public boolean isLeaf() {
    return true;
  }

  public int getIndexOfChild(SimpleTreeNode child) {
    throw new RuntimeException("Should not call this");
  }

  public String getValue() {
    return message;
      }
    }
