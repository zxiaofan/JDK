/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.xsom;

/**
 * Model group.
 *
 * @author
 *  Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface XSModelGroup extends XSComponent, XSTerm, Iterable<XSParticle>
{
    /**
     * Type-safe enumeration for kind of model groups.
     * Constants are defined in the {@link XSModelGroup} interface.
     */
    public static enum Compositor {
        ALL("all"),CHOICE("choice"),SEQUENCE("sequence");

        private Compositor(String _value) {
            this.value = _value;
        }

        private final String value;
        /**
         * Returns the human-readable compositor name.
         *
         * @return
         *      Either "all", "sequence", or "choice".
         */
        public String toString() {
            return value;
        }
    }
    /**
     * A constant that represents "all" compositor.
     */
    static final Compositor ALL = Compositor.ALL;
    /**
     * A constant that represents "sequence" compositor.
     */
    static final Compositor SEQUENCE = Compositor.SEQUENCE;
    /**
     * A constant that represents "choice" compositor.
     */
    static final Compositor CHOICE = Compositor.CHOICE;

    Compositor getCompositor();

    /**
     * Gets <i>i</i>-ith child.
     */
    XSParticle getChild(int idx);
    /**
     * Gets the number of children.
     */
    int getSize();

    /**
     * Gets all the children in one array.
     */
    XSParticle[] getChildren();
}
