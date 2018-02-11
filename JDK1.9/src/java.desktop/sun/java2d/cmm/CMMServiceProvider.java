/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.cmm;

public abstract class CMMServiceProvider {
    public final PCMM getColorManagementModule() {
        if (CMSManager.canCreateModule()) {
            return getModule();
        }
        return null;
    }

    protected abstract PCMM getModule();
}
