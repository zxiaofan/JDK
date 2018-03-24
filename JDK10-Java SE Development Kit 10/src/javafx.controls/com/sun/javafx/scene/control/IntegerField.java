/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Skin;
import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

/**
 *
 */
public class IntegerField extends InputField {
    /**
     * The value of the IntegerField. If null, the value will be treated as "0", but
     * will still actually be null.
     */
    private IntegerProperty value = new SimpleIntegerProperty(this, "value");
    public final int getValue() { return value.get(); }
    public final void setValue(int value) { this.value.set(value); }
    public final IntegerProperty valueProperty() { return value; }

    private IntegerProperty maxValue = new SimpleIntegerProperty(this, "maxValue", -1);
    public final int getMaxValue() { return maxValue.get(); }
    public final void setMaxValue(int maxVal) {this.maxValue.set(maxVal); }
    public final IntegerProperty maxValueProperty() { return maxValue; }
    /**
     * Creates a new IntegerField. The style class is set to "money-field".
     */
    public IntegerField() {
       this(-1); // setting to default
    }
    public IntegerField(int maxVal) {
        getStyleClass().setAll("integer-field");
        setMaxValue(maxVal);
    }

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    /** {@inheritDoc} */
    @Override protected Skin<?> createDefaultSkin() {
        return new IntegerFieldSkin(this);
    }
}
