/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit;

import com.sun.webkit.graphics.WCImage;
import com.sun.webkit.graphics.WCRectangle;

public interface UIClient {

    public WebPage createPage(
            boolean menu, boolean status, boolean toolbar, boolean resizable);
    public void closePage();
    public void showView();
    public WCRectangle getViewBounds();
    public void setViewBounds(WCRectangle bounds);

    public void setStatusbarText(String text);

    public void alert(String text);
    public boolean confirm(String text);
    public String prompt(String text, String defaultValue);

    public boolean canRunBeforeUnloadConfirmPanel();
    public boolean runBeforeUnloadConfirmPanel(String message);

    public String[] chooseFile(String initialFileName, boolean multiple, String mimeFilters);
    public void print();

    public void startDrag(
            WCImage frame,
            int imageOffsetX, int imageOffsetY,
            int eventPosX, int eventPosY,
            String[] mimeTypes, Object[] values,
            boolean isImageSource);
    public void confirmStartDrag();
    public boolean isDragConfirmed();
}
