/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.paint;

public abstract class Paint {

    public enum Type {
        COLOR("Color", false, false),
        LINEAR_GRADIENT("LinearGradient", true, false),
        RADIAL_GRADIENT("RadialGradient", true, false),
        IMAGE_PATTERN("ImagePattern", false, true);

        private String name;
        private boolean isGradient;
        private boolean isImagePattern;
        private Type(String name, boolean isGradient, boolean isImagePattern) {
            this.name = name;
            this.isGradient = isGradient;
            this.isImagePattern = isImagePattern;
        }
        public String getName() {
            return name;
        }
        public boolean isGradient() {
            return isGradient;
        }
        public boolean isImagePattern() {
            return isImagePattern;
        }
    }

    private final Type type;
    private final boolean proportional;
    private final boolean isMutable;

    Paint(Type type, boolean proportional, boolean isMutable) {
        this.type = type;
        this.proportional = proportional;
        this.isMutable = isMutable;
    }


    public final Type getType() {
        return type;
    }

    public boolean isProportional() {
        return proportional;
    }

    public abstract boolean isOpaque();

    public boolean isMutable() {
        return isMutable;
    }

}
