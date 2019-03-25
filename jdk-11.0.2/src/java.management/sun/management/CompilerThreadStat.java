/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

/**
 */
@Deprecated
public class CompilerThreadStat implements java.io.Serializable {
    private String name;
    private long taskCount;
    private long compileTime;
    private MethodInfo lastMethod;

    CompilerThreadStat(String name, long taskCount, long time, MethodInfo lastMethod) {
        this.name = name;
        this.taskCount = taskCount;
        this.compileTime = time;
        this.lastMethod = lastMethod;
    };

    /**
     * Returns the name of the compiler thread associated with
     * this compiler thread statistic.
     *
     * @return the name of the compiler thread.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of compile tasks performed by the compiler thread
     * associated with this compiler thread statistic.
     *
     * @return the number of compile tasks performed by the compiler thread.
     */
    public long getCompileTaskCount() {
        return taskCount;
    }

    /**
     * Returns the accumulated elapsed time spent by the compiler thread
     * associated with this compiler thread statistic.
     *
     * @return the accumulated elapsed time spent by the compiler thread.
     */
    public long getCompileTime() {
        return compileTime;
    }

    /**
     * Returns the information about the last method compiled by
     * the compiler thread associated with this compiler thread statistic.
     *
     * @return a {@link MethodInfo} object for the last method
     * compiled by the compiler thread.
     */
    public MethodInfo getLastCompiledMethodInfo() {
        return lastMethod;
    }

    public String toString() {
        return getName() + " compileTasks = " + getCompileTaskCount()
            + " compileTime = " + getCompileTime();
    }

    private static final long serialVersionUID = 6992337162326171013L;

}
