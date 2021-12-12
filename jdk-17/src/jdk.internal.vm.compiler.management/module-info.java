/*
 * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Registers JVMCI compiler specific management interfaces for the JVM.
 *
 * This is an empty and upgradeable module that is a placeholder for an
 * external implementation of a JVMCI compiler. It must be upgradeable so
 * that it can be replaced when jlinking a new JDK image without failing
 * the hash check for the qualified exports in jdk.internal.vm.ci's
 * module descriptor.
 *
 * @moduleGraph
 * @since 10
 */
module jdk.internal.vm.compiler.management {
    requires jdk.internal.vm.ci;
}

