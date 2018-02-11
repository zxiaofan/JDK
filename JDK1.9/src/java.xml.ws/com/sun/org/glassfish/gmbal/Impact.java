/*
 * Copyright (c) 2008, 2012, Oracle and/or its affiliates. All rights reserved.
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


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sun.org.glassfish.gmbal;

/**
 *
 * @author ken
 */
public enum Impact {
    /** Indicates that an action is read-like, generally only returning
     * information without modifying any state.
     * Corresponds to MBeanOperationInfo.INFO.
     */
    INFO,

    /** Indicates that an action is write-like, and may modify the state
     * of an MBean in some way.
     * Corresponds to MBeanOperationInfo.ACTION.
     */
    ACTION,

    /** Indicates that an action is both read-like and write-like.
     * Corresponds to MBeanOperationInfo.ACTION_INFO.
     */
    ACTION_INFO,

    /** Indicates that an action has an unknown nature.
     * Corresponds to MBeanOperationInfo.UNKNOWN.
     */
    UNKNOWN
}
