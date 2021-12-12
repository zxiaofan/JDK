/*
 * Copyright (c) 2004, 2020, Oracle and/or its affiliates. All rights reserved.
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


import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/** Provides an editable text field with history. */

public class HistoryComboBox extends JComboBox<String> {
  static final int HISTORY_LENGTH = 15;

  public HistoryComboBox() {
    setEditable(true);
    addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Object text = getSelectedItem();
          if (text != null) {
            setText((String)text);
          }
        }
      });
  }

  public String getText() {
    Object text = getSelectedItem();
    if (text == null) {
      return "";
    }
    return (String)text;
  }

  public void setText(String text) {
    removeItem(text);
    insertItemAt(text, 0);
    setSelectedItem(text);
    int length = getModel().getSize();
    while (length > HISTORY_LENGTH) {
      removeItemAt(--length);
    }
  }
}
