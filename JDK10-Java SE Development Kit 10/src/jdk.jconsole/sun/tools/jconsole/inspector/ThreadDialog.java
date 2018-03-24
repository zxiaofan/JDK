/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 */

package sun.tools.jconsole.inspector;

// java import
import java.awt.*;
import javax.swing.*;
//

public class ThreadDialog implements Runnable {

    Component parentComponent;
    Object message;
    String title;
    int messageType;

    public ThreadDialog(Component parentComponent,
                        Object message,
                        String title,
                        int messageType) {
        this.parentComponent = parentComponent;
        this.message = message;
        this.title = title;
        this.messageType = messageType;
    }

    public void run() {
        JOptionPane pane = new JOptionPane(message, messageType);
        JDialog dialog = pane.createDialog(parentComponent, title);
        dialog.setResizable(true);
        dialog.setVisible(true);
    }
}
