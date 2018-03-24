/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.ui;

import javax.swing.text.*;

/** This class implements a special type of document in which edits
    can only be performed at the end, from "mark" to the end of the
    document. Thanks to Scott Violet for suggesting to subclass a
    Document implementation for this purpose. (Can't do it with
    DocumentEvents or UndoableEditEvents; however, in 1.4, there will
    be a DocumentFilter which will allow this kind of functionality.)  */

public class EditableAtEndDocument extends PlainDocument {
  private int mark;

  public void insertString(int offset, String text, AttributeSet a)
    throws BadLocationException {
    int len = getLength();
    super.insertString(len, text, a);
  }

  public void remove(int offs, int len) throws BadLocationException {
    int start = offs;
    int end = offs + len;

    int markStart = mark;
    int markEnd = getLength();

    if ((end < markStart) || (start > markEnd)) {
      // no overlap
      return;
    }

    // Determine interval intersection
    int cutStart = Math.max(start, markStart);
    int cutEnd = Math.min(end, markEnd);
    super.remove(cutStart, cutEnd - cutStart);
  }

  public void setMark() {
    mark = getLength();
  }

  public String getMarkedText() throws BadLocationException {
    return getText(mark, getLength() - mark);
  }

  /** Used to reset the contents of this document */
  public void clear() {
    try {
      super.remove(0, getLength());
      setMark();
    }
    catch (BadLocationException e) {
    }
  }
}
