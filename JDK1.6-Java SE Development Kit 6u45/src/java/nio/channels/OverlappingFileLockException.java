/*
 * @(#)OverlappingFileLockException.java	%I% %E%
 *
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
 * 
 * This software is the proprietary information of Oracle.
 * Use is subject to license terms.
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio.channels;


/**
 * Unchecked exception thrown when an attempt is made to acquire a lock on a
 * region of a file that overlaps a region already locked by the same Java
 * virtual machine, or when another thread is already waiting to lock an
 * overlapping region of the same file.
 *
 * @version %I%, %E%
 * @since 1.4
 */

public class OverlappingFileLockException
    extends IllegalStateException
{

    /**
     * Constructs an instance of this class.
     */
    public OverlappingFileLockException() { }

}
