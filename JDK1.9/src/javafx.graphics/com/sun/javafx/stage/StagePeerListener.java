/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.stage;

import java.security.AccessController;
import java.security.PrivilegedAction;
import javafx.stage.Stage;


public class StagePeerListener extends WindowPeerListener {
    private final Stage stage;
    private final StageAccessor stageAccessor;

    public static interface StageAccessor {
        public void setIconified(Stage stage, boolean iconified);
        public void setMaximized(Stage stage, boolean maximized);
        public void setResizable(Stage stage, boolean resizable);
        public void setFullScreen(Stage stage, boolean fs);
        public void setAlwaysOnTop(Stage stage, boolean aot);
    }

    public StagePeerListener(Stage stage, StageAccessor stageAccessor) {
        super(stage);
        this.stage = stage;
        this.stageAccessor = stageAccessor;
    }


    @Override
    public void changedIconified(boolean iconified) {
        stageAccessor.setIconified(stage, iconified);
    }

    @Override
    public void changedMaximized(boolean maximized) {
        stageAccessor.setMaximized(stage, maximized);
    }

    @Override
    public void changedResizable(boolean resizable) {
        stageAccessor.setResizable(stage, resizable);
    }

    @Override
    public void changedFullscreen(boolean fs) {
        stageAccessor.setFullScreen(stage, fs);
    }

    @Override
    public void changedAlwaysOnTop(boolean aot) {
        stageAccessor.setAlwaysOnTop(stage, aot);
    }


}
