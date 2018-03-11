/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.impl.presentation.rmi;

import com.sun.corba.se.spi.presentation.rmi.PresentationManager ;

public class StubFactoryFactoryProxyImpl extends StubFactoryFactoryDynamicBase 
{
    public PresentationManager.StubFactory makeDynamicStubFactory( 
	PresentationManager pm, PresentationManager.ClassData classData, 
	ClassLoader classLoader ) 
    {
	return new StubFactoryProxyImpl( classData, classLoader ) ;
    }
}
