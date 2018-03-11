/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.impl.presentation.rmi ;

import java.lang.reflect.InvocationHandler ;
import java.lang.reflect.Proxy ;

import com.sun.corba.se.spi.presentation.rmi.PresentationManager ;
import com.sun.corba.se.spi.presentation.rmi.DynamicStub ;

import com.sun.corba.se.spi.orbutil.proxy.InvocationHandlerFactory ;
import com.sun.corba.se.spi.orbutil.proxy.LinkedInvocationHandler ;

public abstract class StubFactoryDynamicBase extends StubFactoryBase  
{
    protected final ClassLoader loader ;

    public StubFactoryDynamicBase( PresentationManager.ClassData classData, 
	ClassLoader loader ) 
    {
	super( classData ) ;

	// this.loader must not be null, or the newProxyInstance call
	// will fail.  
	if (loader == null) {
	    ClassLoader cl = Thread.currentThread().getContextClassLoader();
	    if (cl == null)
		cl = ClassLoader.getSystemClassLoader();
	    this.loader = cl ;
	} else {
	    this.loader = loader ;
	}
    }

    public abstract org.omg.CORBA.Object makeStub() ;
}
