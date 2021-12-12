/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import sun.jvm.hotspot.debugger.*;

/** Wraps a MemoryPanel with a field allowing the user to type in an
    address. */

public class MemoryViewer extends JPanel {
  public MemoryViewer(final Debugger debugger, boolean is64Bit) {
    super();
    final MemoryPanel memory = new MemoryPanel(debugger, is64Bit);
    memory.setBorder(GraphicsUtilities.newBorder(5));
    JPanel addressPanel = new JPanel();
    addressPanel.setLayout(new BoxLayout(addressPanel, BoxLayout.X_AXIS));
    addressPanel.add(new JLabel("Address: "));
    final JTextField addressField = new JTextField(20);
    addressPanel.add(addressField);
    addressField.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          try {
            memory.makeVisible(debugger.parseAddress(addressField.getText()));
          } catch (NumberFormatException ex) {
          }
        }
      });
    setLayout(new BorderLayout());
    add(addressPanel, BorderLayout.NORTH);
    add(memory, BorderLayout.CENTER);
  }
}
