/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.settings;

import jdk.jfr.SettingControl;

/**
 * SettingControls that derive from this class avoids executing settings
 * modifications in a AccessController.doPrivilege(...) block.
 */
public abstract class JDKSettingControl extends SettingControl {
}
