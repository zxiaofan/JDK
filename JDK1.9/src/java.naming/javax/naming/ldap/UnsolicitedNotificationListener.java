/*
 * Copyright (c) 1999, 2010, Oracle and/or its affiliates. All rights reserved.
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

package javax.naming.ldap;

import javax.naming.event.NamingListener;

/**
 * This interface is for handling {@code UnsolicitedNotificationEvent}.
 * "Unsolicited notification" is defined in
 * <A HREF="http://www.ietf.org/rfc/rfc2251.txt">RFC 2251</A>.
 * It allows the server to send unsolicited notifications to the client.
 * An {@code UnsolicitedNotificationListener} must:
 *<ol>
 * <li>Implement this interface and its method
 * <li>Implement {@code NamingListener.namingExceptionThrown()} so
 * that it will be notified of exceptions thrown while attempting to
 * collect unsolicited notification events.
 * <li>Register with the context using one of the {@code addNamingListener()}
 * methods from {@code EventContext} or {@code EventDirContext}.
 * Only the {@code NamingListener} argument of these methods are applicable;
 * the rest are ignored for an {@code UnsolicitedNotificationListener}.
 * (These arguments might be applicable to the listener if it implements
 * other listener interfaces).
 *</ol>
 *
 * @author Rosanna Lee
 * @author Scott Seligman
 * @author Vincent Ryan
 *
 * @see UnsolicitedNotificationEvent
 * @see UnsolicitedNotification
 * @see javax.naming.event.EventContext#addNamingListener
 * @see javax.naming.event.EventDirContext#addNamingListener
 * @see javax.naming.event.EventContext#removeNamingListener
 * @since 1.3
 */
public interface UnsolicitedNotificationListener extends NamingListener {

    /**
     * Called when an unsolicited notification has been received.
     *
     * @param evt The non-null UnsolicitedNotificationEvent
     */
     void notificationReceived(UnsolicitedNotificationEvent evt);
}
