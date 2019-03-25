/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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
/**
 * Package that defines the interface between a Java application that wants to install code and the
 * runtime. The runtime provides in implementation of the {@link jdk.vm.ci.code.CodeCacheProvider}
 * interface. The method
 * {@link jdk.vm.ci.code.CodeCacheProvider#addCode(jdk.vm.ci.meta.ResolvedJavaMethod, CompiledCode, jdk.vm.ci.meta.SpeculationLog, InstalledCode)}
 * can be used to install code.
 */
package jdk.vm.ci.code;
