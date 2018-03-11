/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.jmx.defaults;

/**
 * This contains the property list defined for this
 * JMX implementation.
 *
 * @version     %I%     %G%
 * @author      Sun Microsystems, Inc
 *
 * @since 1.5
 */
public class JmxProperties {

    // private constructor defined to "hide" the default public constructor
    private JmxProperties() {
    }
    
    // PUBLIC STATIC CONSTANTS
    //------------------------
    
    /**
     * References the property that specifies the directory where
     * the native libraries will be stored before the MLet Service
     * loads them into memory.
     * <p>
     * Property Name: <B>jmx.mlet.library.dir</B>
     */
    public static final String JMX_INITIAL_BUILDER = 
	"javax.management.builder.initial";

    /**
     * References the property that specifies the directory where
     * the native libraries will be stored before the MLet Service
     * loads them into memory.
     * <p>
     * Property Name: <B>jmx.mlet.library.dir</B>
     */
    public static final String MLET_LIB_DIR = "jmx.mlet.library.dir";

    /**
     * References the property that specifies the full name of the JMX
     * specification implemented by this product.
     * <p>
     * Property Name: <B>jmx.specification.name</B>
     */
    public static final String JMX_SPEC_NAME = "jmx.specification.name";
    
    /**
     * References the property that specifies the version of the JMX
     * specification implemented by this product.
     * <p>
     * Property Name: <B>jmx.specification.version</B>
     */
     public static final String JMX_SPEC_VERSION = "jmx.specification.version";
    
    /**
     * References the property that specifies the vendor of the JMX
     * specification implemented by this product.
     * <p>
     * Property Name: <B>jmx.specification.vendor</B>
     */
    public static final String JMX_SPEC_VENDOR = "jmx.specification.vendor";
    
    /**
     * References the property that specifies the full name of this product
     * implementing the  JMX specification.
     * <p>
     * Property Name: <B>jmx.implementation.name</B>
     */
    public static final String JMX_IMPL_NAME = "jmx.implementation.name";
    
    /**
     * References the property that specifies the name of the vendor of this
     * product implementing the  JMX specification.
     * <p>
     * Property Name: <B>jmx.implementation.vendor</B>
     */
    public static final String JMX_IMPL_VENDOR = "jmx.implementation.vendor";
    
    /**
     * References the property that specifies the version of this product
     * implementing the  JMX specification.
     * <p>
     * Property Name: <B>jmx.implementation.version</B>
     */
    public static final String JMX_IMPL_VERSION = "jmx.implementation.version";

}
