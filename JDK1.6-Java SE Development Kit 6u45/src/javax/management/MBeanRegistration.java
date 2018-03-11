/*
 * @(#)MBeanRegistration.java	4.17 04/02/11
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.management;


/**
 * Can be implemented by an MBean in order to
 * carry out operations before and after being registered or unregistered from
 * the MBean server.
 *
 * @since 1.5
 */
public interface MBeanRegistration   {


    /**
     * Allows the MBean to perform any operations it needs before
     * being registered in the MBean server.  If the name of the MBean
     * is not specified, the MBean can provide a name for its
     * registration.  If any exception is raised, the MBean will not be
     * registered in the MBean server.
     *
     * @param server The MBean server in which the MBean will be registered.
     *
     * @param name The object name of the MBean.  This name is null if
     * the name parameter to one of the <code>createMBean</code> or
     * <code>registerMBean</code> methods in the {@link MBeanServer}
     * interface is null.  In that case, this method must return a
     * non-null ObjectName for the new MBean.
     *
     * @return The name under which the MBean is to be registered.
     * This value must not be null.  If the <code>name</code>
     * parameter is not null, it will usually but not necessarily be
     * the returned value.
     *
     * @exception java.lang.Exception This exception will be caught by
     * the MBean server and re-thrown as an {@link
     * MBeanRegistrationException}.
     */
    public ObjectName preRegister(MBeanServer server,
				  ObjectName name) throws java.lang.Exception;

    /**
     * Allows the MBean to perform any operations needed after having been
     * registered in the MBean server or after the registration has failed.
     *
     * @param registrationDone Indicates whether or not the MBean has
     * been successfully registered in the MBean server. The value
     * false means that the registration phase has failed.
     */
    public void postRegister(Boolean registrationDone);

    /**
     * Allows the MBean to perform any operations it needs before
     * being unregistered by the MBean server.
     *
     * @exception java.lang.Exception This exception will be caught by
     * the MBean server and re-thrown as an {@link
     * MBeanRegistrationException}.
     */
    public void preDeregister() throws java.lang.Exception ;

    /**
     * Allows the MBean to perform any operations needed after having been
     * unregistered in the MBean server.
     */
    public void postDeregister();

 }
