/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.fxml.builder;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.DefaultProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Builder;

/**
 * JavaFX scene builder.
 */
@DefaultProperty("root")
public class JavaFXSceneBuilder implements Builder<Scene> {
    private Parent root = null;
    private double width = -1;
    private double height = -1;
    private Paint fill = Color.WHITE;
    private ArrayList<String> stylesheets = new ArrayList<String>();

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < -1) {
            throw new IllegalArgumentException();
        }

        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < -1) {
            throw new IllegalArgumentException();
        }

        this.height = height;
    }

    public Paint getFill() {
        return fill;
    }

    public void setFill(Paint fill) {
        if (fill == null) {
            throw new NullPointerException();
        }

        this.fill = fill;
    }

    public List<String> getStylesheets() {
        return stylesheets;
    }

    @Override
    public Scene build() {
        Scene scene = new Scene(root, width, height, fill);

        for (String stylesheet : stylesheets) {
            scene.getStylesheets().add(stylesheet);
        }

        return scene;
    }
}
