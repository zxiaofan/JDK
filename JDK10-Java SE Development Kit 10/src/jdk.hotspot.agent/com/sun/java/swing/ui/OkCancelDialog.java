/*
 * Copyright (c) 2000, 2008, Oracle and/or its affiliates. All rights reserved.
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


package com.sun.java.swing.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;

// Referenced classes of package com.sun.java.swing.ui:
//            OkCancelButtonPanel, CommonUI

public class OkCancelDialog extends JDialog
    implements ActionListener
{

    public OkCancelDialog(String title, JPanel panel)
    {
        this(title, panel, true);
    }

    public OkCancelDialog(String title, JPanel panel, boolean modal)
    {
        setTitle(title);
        setModal(modal);
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(panel, "Center");
        pane.add(new OkCancelButtonPanel(this), "South");
        pack();
        CommonUI.centerComponent(this);
    }

    public boolean isOk()
    {
        return okPressed;
    }

    public void actionPerformed(ActionEvent evt)
    {
        String command = evt.getActionCommand();
        if(command.equals("ok-command"))
        {
            okPressed = true;
            setVisible(false);
            dispose();
        } else
        if(command.equals("cancel-command"))
        {
            okPressed = false;
            setVisible(false);
            dispose();
        }
    }

    private boolean okPressed;
}
