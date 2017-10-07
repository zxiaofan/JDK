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

import java.awt.*;
import javax.swing.ImageIcon;

public class SplashScreen extends Window
{

    public SplashScreen(Frame f)
    {
        super(f);
        setBackground(Color.white);
        java.net.URL url = getClass().getResource("/images/SplashScreen.jpg");
        if(url != null)
        {
            screen = new ImageIcon(url);
            MediaTracker mt = new MediaTracker(this);
            mt.addImage(screen.getImage(), 0);
            try
            {
                mt.waitForAll();
            }
            catch(Exception ex) { }
        }
    }

    public void setVisible(boolean val)
    {
        if(screen == null)
            return;
        if(val)
        {
            setSize(screen.getIconWidth(), screen.getIconHeight());
            setLocation(-500, -500);
            super.setVisible(true);
            Dimension d = getToolkit().getScreenSize();
            Insets i = getInsets();
            int w = screen.getIconWidth() + i.left + i.right;
            int h = screen.getIconHeight() + i.top + i.bottom;
            setSize(w, h);
            setLocation(d.width / 2 - w / 2, d.height / 2 - h / 2);
        } else
        {
            super.setVisible(false);
        }
    }

    public void paint(Graphics g)
    {
        if(screen != null)
        {
            Dimension d = getSize();
            g.setColor(Color.black);
            g.drawRect(0, 0, d.width - 1, d.height - 1);
            g.drawImage(screen.getImage(), 1, 1, this);
        }
    }

    private ImageIcon screen;
}
