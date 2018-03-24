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

/** Unchecked exception type used for all gmbal exceptions.
 *
 * @author ken
 */
public class GmbalException extends RuntimeException {
    private static final long serialVersionUID = -7478444176079980162L;
    public GmbalException( String msg ) {
        super( msg ) ;
    }

    public GmbalException( String msg, Throwable thr ) {
        super( msg, thr ) ;
    }
}
