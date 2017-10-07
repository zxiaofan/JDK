/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.control;

import com.sun.javafx.scene.layout.RegionHelper;
import com.sun.javafx.util.Utils;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Control;

/*
 * Used to access internal methods of Control.
 */
public class ControlHelper extends RegionHelper {
    private static final ControlHelper theInstance;
    private static ControlAccessor controlAccessor;

    static {
        theInstance = new ControlHelper();
        Utils.forceInit(Control.class);
    }

    private static ControlHelper getInstance() {
        return theInstance;
    }

    public static void initHelper(Control control) {
        setHelper(control, getInstance());
    }

    public static void superProcessCSS(Node node) {
        ((ControlHelper) getHelper(node)).superProcessCSSImpl(node);
    }

    public static StringProperty skinClassNameProperty(Control control) {
        return controlAccessor.skinClassNameProperty(control);
    }

    void superProcessCSSImpl(Node node) {
        super.processCSSImpl(node);
    }

    protected void processCSSImpl(Node node) {
        controlAccessor.doProcessCSS(node);
    }


    public static void setControlAccessor(final ControlAccessor newAccessor) {
        if (controlAccessor != null) {
            throw new IllegalStateException();
        }

        controlAccessor = newAccessor;
    }

    public interface ControlAccessor {
        void doProcessCSS(Node node);
        StringProperty skinClassNameProperty(Control control);
    }

}
