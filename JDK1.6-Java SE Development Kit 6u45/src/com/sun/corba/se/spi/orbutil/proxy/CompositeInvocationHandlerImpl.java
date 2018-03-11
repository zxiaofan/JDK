package com.sun.corba.se.spi.orbutil.proxy ;

import java.io.Serializable ;

import java.util.Map ;
import java.util.LinkedHashMap ;
  
import java.lang.reflect.Proxy ;
import java.lang.reflect.Method ;
import java.lang.reflect.InvocationHandler ;

import com.sun.corba.se.spi.logging.CORBALogDomains ;
import com.sun.corba.se.impl.logging.ORBUtilSystemException ;

public class CompositeInvocationHandlerImpl implements 
    CompositeInvocationHandler
{
    private Map classToInvocationHandler = new LinkedHashMap() ;
    private InvocationHandler defaultHandler = null ;

    public void addInvocationHandler( Class interf, 
	InvocationHandler handler ) 
    {
	classToInvocationHandler.put( interf, handler ) ;
    }

    public void setDefaultHandler( InvocationHandler handler ) 
    {
	defaultHandler = handler ;
    }

    public Object invoke( Object proxy, Method method, Object[] args )
	throws Throwable
    {
	// Note that the declaring class in method is the interface
	// in which the method was defined, not the proxy class.
	Class cls = method.getDeclaringClass() ;
	InvocationHandler handler = 
	    (InvocationHandler)classToInvocationHandler.get( cls ) ;

	if (handler == null) {
	    if (defaultHandler != null)
		handler = defaultHandler ;
	    else {
		ORBUtilSystemException wrapper = ORBUtilSystemException.get( 
		    CORBALogDomains.UTIL ) ;
		throw wrapper.noInvocationHandler( "\"" + method.toString() + 
		    "\"" ) ;
	    }
	}

	// handler should never be null here.

	return handler.invoke( proxy, method, args ) ;
    }
}
