/*
 * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
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
package java.net;

import java.util.Properties;
import sun.security.action.GetPropertyAction;

/**
 * This class defines a factory for creating DatagramSocketImpls. It defaults
 * to creating plain DatagramSocketImpls, but may create other DatagramSocketImpls
 * by setting the impl.prefix system property.
 *
 * For Windows versions lower than Windows Vista a TwoStacksPlainDatagramSocketImpl
 * is always created. This impl supports IPv6 on these platform where available.
 *
 * On Windows platforms greater than Vista that support a dual layer TCP/IP stack
 * a DualStackPlainDatagramSocketImpl is created for DatagramSockets. For MulticastSockets
 * a TwoStacksPlainDatagramSocketImpl is always created. This is to overcome the lack
 * of behavior defined for multicasting over a dual layer socket by the RFC.
 *
 * @author Chris Hegarty
 */

class DefaultDatagramSocketImplFactory
{
    private static final Class<?> prefixImplClass;

    /* java.net.preferIPv4Stack */
    private static final boolean preferIPv4Stack;

    /* True if exclusive binding is on for Windows */
    private static final boolean exclusiveBind;

    static {
        Class<?> prefixImplClassLocal = null;

        Properties props = GetPropertyAction.privilegedGetProperties();
        preferIPv4Stack = Boolean.parseBoolean(
                props.getProperty("java.net.preferIPv4Stack"));

        String exclBindProp = props.getProperty("sun.net.useExclusiveBind", "");
        exclusiveBind = (exclBindProp.isEmpty())
                ? true
                : Boolean.parseBoolean(exclBindProp);

        // impl.prefix
        String prefix = null;
        try {
            prefix = props.getProperty("impl.prefix");
            if (prefix != null)
                prefixImplClassLocal = Class.forName("java.net."+prefix+"DatagramSocketImpl");
        } catch (Exception e) {
            System.err.println("Can't find class: java.net." +
                                prefix +
                                "DatagramSocketImpl: check impl.prefix property");
        }

        prefixImplClass = prefixImplClassLocal;
    }

    /**
     * Creates a new <code>DatagramSocketImpl</code> instance.
     *
     * @param   isMulticast true if this impl is to be used for a MutlicastSocket
     * @return  a new instance of <code>PlainDatagramSocketImpl</code>.
     */
    static DatagramSocketImpl createDatagramSocketImpl(boolean isMulticast)
        throws SocketException {
        if (prefixImplClass != null) {
            try {
                @SuppressWarnings("deprecation")
                Object result = prefixImplClass.newInstance();
                return (DatagramSocketImpl) result;
            } catch (Exception e) {
                throw new SocketException("can't instantiate DatagramSocketImpl");
            }
        } else {
            // Always use TwoStacksPlainDatagramSocketImpl since we need
            // to support multicasting at DatagramSocket level
            return new TwoStacksPlainDatagramSocketImpl(exclusiveBind && !isMulticast, isMulticast);
        }
    }
}
