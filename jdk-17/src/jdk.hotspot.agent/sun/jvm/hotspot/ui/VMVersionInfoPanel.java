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

/** Shows VM version information */

public class VMVersionInfoPanel extends JPanel {
    private JEditorPane         versionPane;

    public VMVersionInfoPanel() {
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());
        versionPane = new JEditorPane();
        versionPane.setContentType("text/html");
        versionPane.setEditable(false);
        versionPane.setText(getVersionInfo());

        add(versionPane, BorderLayout.CENTER);
    }

    private String getVersionInfo() {
       VM vm = VM.getVM();
       StringBuilder buf = new StringBuilder();
       buf.append("<html><head><title>VM Version Info</title></head>");
       buf.append("<body><table border='1'>");

       // VM type
       buf.append("<tr><td><b>VM Type</b></td>");
       buf.append("<td>");
       if (vm.isCore()) {
          buf.append("<b>core</b>");
       } else if(vm.isClientCompiler()) {
          buf.append("<b>client</b>");
       } else if(vm.isServerCompiler()) {
          buf.append("<b>server</b>");
       } else {
          buf.append("<b>unknown</b>");
       }
       buf.append("</td></tr>");

       // VM release
       String release = vm.getVMRelease();
       if (release != null) {
          buf.append("<tr><td><b>VM Release</td><td><b>");
          buf.append(release);
          buf.append("</b></td></tr>");
       }

       // VM internal info
       String internalInfo = vm.getVMInternalInfo();
       if (internalInfo != null) {
          buf.append("<tr><td><b>VM Internal Info</td><td><b>");
          buf.append(internalInfo);
          buf.append("</b></td></tr>");
       }

       buf.append("</table></body></html>");
       return buf.toString();
    }
}
