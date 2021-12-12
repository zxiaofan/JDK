/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.utilities;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.oops.*;

/** Describes a path from an object back to the root which is keeping
    it alive. Elements of the path are (object, field) pairs, where
    the object is expressed as a @link{sun.jvm.hotspot.oops.Oop}, and
    where the field is expressed as a
    @link{sun.jvm.hotspot.oops.FieldIdentifier}. If the element
    reflects a root, the Oop will be null. If the element is the end
    of the path, the FieldIdentifier will be null. */

public class LivenessPath {
  LivenessPath() {
    stack = new Stack<>();
  }

  /** Number of elements in the path */
  public int size() {
    return stack.size();
  }

  /** Fetch the element at the given index; 0-based */
  public LivenessPathElement get(int index) throws ArrayIndexOutOfBoundsException {
    return (LivenessPathElement) stack.get(index);
  }

  public void printOn(PrintStream tty) {
    for (int j = 0; j < size(); j++) {
      LivenessPathElement el = get(j);
      tty.print("  - ");
      if (el.getObj() != null) {
        Oop.printOopValueOn(el.getObj(), tty);
      }
      if (el.getField() != null) {
        if (el.getObj() != null) {
          tty.print(", field ");
        }
        tty.print(el.getField().getName());
      }
      tty.println();
    }
  }

  /** Indicates whether this path is "complete", i.e., whether the
      last element is a root. Convenience routine for LivenessAnalysis. */
  boolean isComplete() {
    if (size() == 0)
      return false;
    return peek().isRoot();
  }

  // Convenience routine for LivenessAnalysis
  LivenessPathElement peek() {
    return (LivenessPathElement) stack.peek();
  }

  // Convenience routine for LivenessAnalysis
  void push(LivenessPathElement el) {
    stack.push(el);
  }

  // Convenience routine for LivenessAnalysis
  void pop() {
    stack.pop();
  }

  // Make a copy of the contents of the path -- the
  // LivenessPathElements are not duplicated, only the containing path
  LivenessPath copy() {
    LivenessPath dup = new LivenessPath();
    for (int i = 0; i < stack.size(); i++) {
      dup.stack.push(stack.get(i));
    }
    return dup;
  }

  //---------------------------------------------------------------------------
  // Internals only below this point
  //
  private Stack<LivenessPathElement> stack;
}
