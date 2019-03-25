/*
 * Copyright (c) 1999, 2018, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.sampled;

/**
 * A {@code CompoundControl}, such as a graphic equalizer, provides control over
 * two or more related properties, each of which is itself represented as a
 * {@code Control}.
 *
 * @author Kara Kytle
 * @since 1.3
 */
public abstract class CompoundControl extends Control {

    /**
     * The set of member controls.
     */
    private final Control[] controls;

    /**
     * Constructs a new compound control object with the given parameters.
     *
     * @param  type the type of control represented this compound control object
     * @param  memberControls the set of member controls
     */
    protected CompoundControl(Type type, Control[] memberControls) {
        super(type);
        this.controls = memberControls;
    }

    /**
     * Returns the set of member controls that comprise the compound control.
     *
     * @return the set of member controls
     */
    public Control[] getMemberControls() {
        return controls.clone();
    }

    /**
     * Provides a string representation of the control.
     *
     * @return a string description
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < controls.length; i++) {
            if (i != 0) {
                sb.append(", ");
                if ((i + 1) == controls.length) {
                    sb.append("and ");
                }
            }
            sb.append(controls[i].getType());
        }

        return new String(getType() + " Control containing " + sb + " Controls.");
    }

    /**
     * An instance of the {@code CompoundControl.Type} inner class identifies
     * one kind of compound control.
     *
     * @author Kara Kytle
     * @since 1.3
     */
    public static class Type extends Control.Type {

        /**
         * Constructs a new compound control type.
         *
         * @param  name the name of the new compound control type
         */
        protected Type(final String name) {
            super(name);
        }
    }
}
