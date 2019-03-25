/*
 * Copyright (c) 2000, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

// A MetadataVisitor can be used to inspect all fields within an object.
// Fields include vm fields, java fields, indexable fields.

public interface MetadataVisitor extends FieldVisitor {
  // Called before visiting an object
  public void prologue();

  // Called after visiting an object
  public void epilogue();

  public void setObj(Metadata obj);

  // Returns the object being visited
  public Metadata getObj();
};
