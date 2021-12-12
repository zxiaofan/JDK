/*
 * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
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
import javax.swing.*;

import sun.jvm.hotspot.runtime.*;

/** Shows values of Java command line flags */

public class VMFlagsPanel extends JPanel {
    private JEditorPane         flagsPane;

    public VMFlagsPanel() {
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        flagsPane = new JEditorPane();
        flagsPane.setContentType("text/html");
        flagsPane.setEditable(false);
        flagsPane.setText(getFlags());

        add(new JScrollPane(flagsPane), BorderLayout.CENTER);
    }

    private String getFlags() {
       VM.Flag[] flags = VM.getVM().getCommandLineFlags();
       StringBuilder buf = new StringBuilder();
       buf.append("<html><head><title>VM Command Line Flags</title></head><body>");
       if (flags == null) {
          buf.append("<b>Command Flag info not available (use 1.4.1_03 or later)!</b>");
       } else {
          buf.append("<table border='1'>");
          for (int f = 0; f < flags.length; f++) {
             buf.append("<tr><td>");
             buf.append(flags[f].getName());
             buf.append("</td><td>");
             buf.append(flags[f].getValue());
             buf.append("</td>");
          }
          buf.append("</table>");
       }

       buf.append("</body></html>");
       return buf.toString();
    }
}
