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

package jdk.internal.module;

import java.lang.module.ModuleReference;
import static jdk.internal.module.ClassFileConstants.*;

/**
 * Represents the Module Resolution flags.
 */
public final class ModuleResolution {

    final int value;

    ModuleResolution(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static ModuleResolution empty() {
        return new ModuleResolution(0);
    }

    public boolean doNotResolveByDefault() {
        return (value & DO_NOT_RESOLVE_BY_DEFAULT) != 0;
    }

    public boolean hasDeprecatedWarning() {
        return (value & WARN_DEPRECATED) != 0;
    }

    public boolean hasDeprecatedForRemovalWarning() {
        return (value & WARN_DEPRECATED_FOR_REMOVAL) != 0;
    }

    public boolean hasIncubatingWarning() {
        return (value & WARN_INCUBATING) != 0;
    }

    public ModuleResolution withDoNotResolveByDefault() {
        return new ModuleResolution(value | DO_NOT_RESOLVE_BY_DEFAULT);
    }

    public ModuleResolution withDeprecated() {
        if ((value & (WARN_DEPRECATED_FOR_REMOVAL | WARN_INCUBATING)) != 0)
            throw new InternalError("cannot add deprecated to " + value);
        return new ModuleResolution(value | WARN_DEPRECATED);
    }

    public ModuleResolution withDeprecatedForRemoval() {
        if ((value & (WARN_DEPRECATED | WARN_INCUBATING)) != 0)
            throw new InternalError("cannot add deprecated for removal to " + value);
        return new ModuleResolution(value | WARN_DEPRECATED_FOR_REMOVAL);
    }

    public ModuleResolution withIncubating() {
        if ((value & (WARN_DEPRECATED | WARN_DEPRECATED_FOR_REMOVAL)) != 0)
            throw new InternalError("cannot add incubating to " + value);
        return new ModuleResolution(value | WARN_INCUBATING);
    }

    public static boolean doNotResolveByDefault(ModuleReference mref) {
        // get the DO_NOT_RESOLVE_BY_DEFAULT flag, if any
        if (mref instanceof ModuleReferenceImpl) {
            ModuleResolution mres = ((ModuleReferenceImpl) mref).moduleResolution();
            if (mres != null)
                return mres.doNotResolveByDefault();
        }

        return false;
    }

    public static boolean hasIncubatingWarning(ModuleReference mref) {
        if (mref instanceof ModuleReferenceImpl) {
            ModuleResolution mres = ((ModuleReferenceImpl) mref).moduleResolution();
            if (mres != null)
                return mres.hasIncubatingWarning();
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "[value=" + value + "]";
    }
}
