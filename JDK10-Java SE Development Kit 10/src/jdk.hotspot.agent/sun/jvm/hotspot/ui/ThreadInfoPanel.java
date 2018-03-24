/*
 * Copyright (c) 2001, 2002, Oracle and/or its affiliates. All rights reserved.
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

/** Provides implementation level info about a Java Thread */

public class ThreadInfoPanel extends JPanel {

    private JTextArea textArea;

    public ThreadInfoPanel() {
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Simple at first
        JScrollPane scroller = new JScrollPane();
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scroller.getViewport().add(textArea);
        add(scroller, BorderLayout.CENTER);
    }


    public ThreadInfoPanel(final JavaThread thread) {
        initUI();
        setJavaThread(thread);
    }

    public void setJavaThread(final JavaThread thread) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream tty = new PrintStream(bos);
        tty.println("Thread Info: " + thread.getThreadName());
        thread.printInfoOn(tty);

        textArea.setText(bos.toString());
    }
}
