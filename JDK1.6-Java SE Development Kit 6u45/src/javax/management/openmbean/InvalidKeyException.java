/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.management.openmbean;

/**
 * This runtime exception is thrown to indicate that a method parameter which was expected to be 
 * an item name of a <i>composite data</i> or a row index of a <i>tabular data</i> is not valid.
 *
 * @version     %I%  %E%
 * @author      Sun Microsystems, Inc.
 *
 * @since 1.5
 * @since.unbundled JMX 1.1
 */
public class InvalidKeyException extends IllegalArgumentException {

    private static final long serialVersionUID = 4224269443946322062L;

    /**
     * An InvalidKeyException with no detail message.
     */
    public InvalidKeyException() {
	super();
    }

    /**
     * An InvalidKeyException with a detail message.
     *
     * @param msg the detail message.
     */
    public InvalidKeyException(String msg) {
	super(msg);
    }

}
