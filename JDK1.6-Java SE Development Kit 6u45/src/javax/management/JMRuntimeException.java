/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.management; 


/**
 * Runtime exceptions emitted by JMX implementations.
 *
 * @since 1.5
 */
public class JMRuntimeException extends RuntimeException   { 
     
    /* Serial version */
    private static final long serialVersionUID = 6573344628407841861L;

    /**
     * Default constructor.
     */
    public JMRuntimeException() {
	super();
    }
    
    /**
     * Constructor that allows a specific error message to be specified.
     *
     * @param message the detail message.
     */
    public JMRuntimeException(String message) {
	super(message);
    }
    
    /**
     * Constructor with a nested exception.  This constructor is
     * package-private because it arrived too late for the JMX 1.2
     * specification.  A later version may make it public.
     */
    JMRuntimeException(String message, Throwable cause) {
	super(message);

	/* Make a best effort to set the cause, but if we don't
	   succeed, too bad, you don't get that useful debugging
	   information.  We jump through hoops here so that we can
	   work on platforms prior to J2SE 1.4 where the
	   Throwable.initCause method was introduced.  If we change
	   the public interface of JMRuntimeException in a future
	   version we can add getCause() so we don't need to do this.  */
	try {
	    java.lang.reflect.Method initCause =
		Throwable.class.getMethod("initCause",
					  new Class[] {Throwable.class});
	    initCause.invoke(this, new Object[] {cause});
	} catch (Exception e) {
	    // OK: just means we won't have debugging info
	}
    }
}
