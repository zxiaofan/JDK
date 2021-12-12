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
import java.util.*;
import javax.swing.*;

import sun.jvm.hotspot.runtime.*;

/** Shows values of Java System properties. */

public class SysPropsPanel extends JPanel {
    private SAEditorPane         flagsPane;

    public SysPropsPanel() {
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        flagsPane = new SAEditorPane();
        flagsPane.setText(getFlags());

        add(new JScrollPane(flagsPane), BorderLayout.CENTER);
    }

    private String getFlags() {
       final StringBuilder buf = new StringBuilder();
       buf.append("<html><head><title>System Properties</title></head><body>");
       buf.append("<table border='1'>");

       Properties sysProps = VM.getVM().getSystemProperties();
       if (sysProps != null) {
          Enumeration keys = sysProps.keys();
          while (keys.hasMoreElements()) {
             Object key = keys.nextElement();
             buf.append("<tr><td>");
             buf.append(key.toString());
             buf.append("</td><td>");
             buf.append(sysProps.get(key).toString());
             buf.append("</td></tr>");
          }
       } else {
          buf.append("<tr><td>System Properties info not available!</td></tr>");
       }
       buf.append("</table>");
       buf.append("</body></html>");
       return buf.toString();
    }
}
