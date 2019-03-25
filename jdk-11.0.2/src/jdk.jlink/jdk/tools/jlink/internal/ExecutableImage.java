/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.tools.jlink.internal;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;

/**
 * An executable runtime image. Contains the information about the executable
 * image created.
 */
public interface ExecutableImage {

    /**
     * Image home directory,
     *
     * @return The home directory.
     */
    public Path getHome();

    /**
     * The names of the modules located in the image.
     *
     * @return The set of modules.
     */
    public Set<String> getModules();

    /**
     * The list of arguments required to execute the image.
     *
     * @return The list of arguments.
     */
    public List<String> getExecutionArgs();

    /**
     * Store new arguments required to execute the image.
     *
     * @param args Additional arguments
     */
    public void storeLaunchArgs(List<String> args);
}
