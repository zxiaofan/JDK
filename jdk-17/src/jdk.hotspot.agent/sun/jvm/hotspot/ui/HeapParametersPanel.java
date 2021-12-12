/*
 * Copyright (c) 2000, 2002, Oracle and/or its affiliates. All rights reserved.
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
import java.io.*;
import javax.swing.*;

import sun.jvm.hotspot.memory.*;
import sun.jvm.hotspot.runtime.*;

/** Provides information about heap. FIXME: add back in information
    about card marking table (was present before GC interface). */

public class HeapParametersPanel extends JPanel {
  public HeapParametersPanel() {
    super();

    setLayout(new BorderLayout());

    // Simple at first
    JScrollPane scroller = new JScrollPane();
    JTextArea textArea = new JTextArea();
    textArea = new JTextArea();
    textArea.setEditable(false);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    scroller.getViewport().add(textArea);
    add(scroller, BorderLayout.CENTER);

    Universe u = VM.getVM().getUniverse();
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    PrintStream tty = new PrintStream(bos);
    tty.println("Heap Parameters:");
    u.heap().printOn(tty);

    textArea.setText(bos.toString());
  }
}
