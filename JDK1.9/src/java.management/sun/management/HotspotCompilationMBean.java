/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.management;

import sun.management.counter.Counter;

/**
 * Hotspot internal management interface for the compilation system.
 */
public interface HotspotCompilationMBean {

    /**
     * Returns the number of compiler threads.
     *
     * @return the number of compiler threads.
     */
    public int getCompilerThreadCount();

    /**
     * Returns the statistic of all compiler threads.
     *
     * @return a list of {@link CompilerThreadStat} object containing
     * the statistic of a compiler thread.
     *
     */
    @Deprecated
    public java.util.List<CompilerThreadStat> getCompilerThreadStats();

    /**
     * Returns the total number of compiles.
     *
     * @return the total number of compiles.
     */
    public long getTotalCompileCount();

    /**
     * Returns the number of bailout compiles.
     *
     * @return the number of bailout compiles.
     */
    public long getBailoutCompileCount();

    /**
     * Returns the number of invalidated compiles.
     *
     * @return the number of invalidated compiles.
     */
    public long getInvalidatedCompileCount();

    /**
     * Returns the method information of the last compiled method.
     *
     * @return a {@link MethodInfo} of the last compiled method.
     */
    public MethodInfo getLastCompile();

    /**
     * Returns the method information of the last failed compile.
     *
     * @return a {@link MethodInfo} of the last failed compile.
     */
    public MethodInfo getFailedCompile();

    /**
     * Returns the method information of the last invalidated compile.
     *
     * @return a {@link MethodInfo} of the last invalidated compile.
     */
    public MethodInfo getInvalidatedCompile();

    /**
     * Returns the number of bytes for the code of the
     * compiled methods.
     *
     * @return the number of bytes for the code of the compiled methods.
     */
    public long getCompiledMethodCodeSize();

    /**
     * Returns the number of bytes occupied by the compiled methods.
     *
     * @return the number of bytes occupied by the compiled methods.
     */
    public long getCompiledMethodSize();

    /**
     * Returns a list of internal counters maintained in the Java
     * virtual machine for the compilation system.
     *
     * @return a list of internal counters maintained in the VM
     * for the compilation system.
     */
    public java.util.List<Counter> getInternalCompilerCounters();
}
