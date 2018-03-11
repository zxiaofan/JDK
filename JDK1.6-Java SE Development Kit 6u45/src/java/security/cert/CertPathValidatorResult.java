/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.security.cert;

/**
 * A specification of the result of a certification path validator algorithm.
 * <p>
 * The purpose of this interface is to group (and provide type safety 
 * for) all certification path validator results. All results returned 
 * by the {@link CertPathValidator#validate CertPathValidator.validate}
 * method must implement this interface.  
 *
 * @see CertPathValidator
 *
 * @version 	%I% %G%
 * @since	1.4
 * @author	Yassir Elley
 */
public interface CertPathValidatorResult extends Cloneable {

    /**
     * Makes a copy of this <code>CertPathValidatorResult</code>. Changes to the
     * copy will not affect the original and vice versa.
     *
     * @return a copy of this <code>CertPathValidatorResult</code>
     */
    Object clone();
}
