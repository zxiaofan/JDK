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


package com.sun.java.swing.action;

import javax.swing.ImageIcon;

class ActionUtilities
{

    ActionUtilities()
    {
    }

    public ImageIcon getIcon(String name)
    {
        String imagePath = "/toolbarButtonGraphics/" + name;
        java.net.URL url = getClass().getResource(imagePath);
        if(url != null)
            return new ImageIcon(url);
        else
            return null;
    }

    public static final String IMAGE_DIR = "/toolbarButtonGraphics/";

}
