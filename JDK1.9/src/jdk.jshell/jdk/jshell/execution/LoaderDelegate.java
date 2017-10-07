/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jshell.execution;

import jdk.jshell.spi.ExecutionControl.ClassBytecodes;
import jdk.jshell.spi.ExecutionControl.ClassInstallException;
import jdk.jshell.spi.ExecutionControl.EngineTerminationException;
import jdk.jshell.spi.ExecutionControl.InternalException;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;

/**
 * This interface specifies the loading specific subset of
 * {@link jdk.jshell.spi.ExecutionControl}.  For use in encapsulating the
 * {@link java.lang.ClassLoader} implementation.
 *
 * @since 9
 */
public interface LoaderDelegate {

    /**
     * Attempts to load new classes.
     *
     * @param cbcs the class name and bytecodes to load
     * @throws ClassInstallException exception occurred loading the classes,
     * some or all were not loaded
     * @throws NotImplementedException if not implemented
     * @throws EngineTerminationException the execution engine has terminated
     */
    void load(ClassBytecodes[] cbcs)
            throws ClassInstallException, NotImplementedException, EngineTerminationException;

    /**
     * Notify that classes have been redefined.
     *
     * @param cbcs the class names and bytecodes that have been redefined
     */
    public void classesRedefined(ClassBytecodes[] cbcs);

    /**
     * Adds the path to the execution class path.
     *
     * @param path the path to add
     * @throws EngineTerminationException the execution engine has terminated
     * @throws InternalException an internal problem occurred
     */
    void addToClasspath(String path)
            throws EngineTerminationException, InternalException;

    /**
     * Finds the class with the specified binary name.
     *
     * @param name the binary name of the class
     * @return the Class Object
     * @throws ClassNotFoundException if the class could not be found
     */
    Class<?> findClass(String name) throws ClassNotFoundException;
}
