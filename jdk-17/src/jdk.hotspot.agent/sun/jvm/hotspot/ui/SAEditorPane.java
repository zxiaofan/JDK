/*
 * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.io.*;
import java.awt.event.*;
import java.awt.im.InputContext;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

/** A simple subclass of JEditorPane for displaying uneditable html
 */

public class SAEditorPane extends JEditorPane {

  public SAEditorPane() {
    setEditable(false);
    setContentType("text/html");
  }

  /**
      Override getSelectedText so that <br> elements produce \n when
      text is copied out of the window.
   */

  public String getSelectedText() {
    StringBuilder result = new StringBuilder();
    Document doc = getDocument();

    int start = getSelectionStart();
    int end = getSelectionEnd();

    try {
      // Create an iterator using the root element
      ElementIterator it = new ElementIterator(doc.getDefaultRootElement());

      // Iterate all content elements (which are leaves)
      Element e;
      String separator = System.getProperty("line.separator");
      while ((e = it.next()) != null) {
        if (e.isLeaf()) {
          int rangeStart = e.getStartOffset();
          int rangeEnd = e.getEndOffset();

          if (rangeEnd < start || rangeStart > end) continue;
          if (end < rangeEnd) rangeEnd = end;
          if (start > rangeStart) rangeStart = start;
          try {
            String line = getText(rangeStart, rangeEnd-rangeStart);
            if (e.getName().equals("br"))
              result.append(separator);
            else
              result.append(line);
          } catch (BadLocationException ex) {
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result.toString();
  }

  public void setText(String text) {
    super.setText(text);
    // put the cursor at the top instead of leaving it at the end.
    setCaretPosition(0);
  }
}
