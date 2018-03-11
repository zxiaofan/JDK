/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.spi.orbutil.fsm;

import com.sun.corba.se.impl.orbutil.fsm.StateEngineImpl ;

/**
 * Factory for creating the standard state machine implementation.
 *
 * @version %W% %E%
 * @author Ken Cavanaugh
 */
public class StateEngineFactory {
    private StateEngineFactory() {}

    public static StateEngine create()
    {
	return new StateEngineImpl() ;
    }
}
