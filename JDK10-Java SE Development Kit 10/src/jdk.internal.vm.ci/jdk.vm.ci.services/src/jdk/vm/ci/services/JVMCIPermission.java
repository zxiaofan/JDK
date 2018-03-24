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
 */
package jdk.vm.ci.services;

import java.security.BasicPermission;

/**
 * This class represents the permission to access JVMCI services.
 */
public class JVMCIPermission extends BasicPermission {

    private static final long serialVersionUID = 6346818963934448226L;

    public JVMCIPermission() {
        super("jvmci");
    }
}
