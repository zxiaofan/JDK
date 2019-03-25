/*
 * Copyright (c) 2003, 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.management;

import javax.management.ListenerNotFoundException;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Abstract helper class for notification emitter support.
 */
public abstract class NotificationEmitterSupport implements NotificationEmitter {

    protected NotificationEmitterSupport() {
    }

    private Object listenerLock = new Object();

    // Implementation of NotificationEmitter interface
    // Cloned from JMX NotificationBroadcasterSupport class.
    public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter,
                                        Object handback) {

        if (listener == null) {
            throw new IllegalArgumentException ("Listener can't be null") ;
        }

        /* Adding a new listener takes O(n) time where n is the number
           of existing listeners.  If you have a very large number of
           listeners performance could degrade.  That's a fairly
           surprising configuration, and it is hard to avoid this
           behaviour while still retaining the property that the
           listenerList is not synchronized while notifications are
           being sent through it.  If this becomes a problem, a
           possible solution would be a multiple-readers single-writer
           setup, so any number of sendNotification() calls could run
           concurrently but they would exclude an
           add/removeNotificationListener.  A simpler but less
           efficient solution would be to clone the listener list
           every time a notification is sent.  */
        synchronized (listenerLock) {
            List<ListenerInfo> newList = new ArrayList<>(listenerList.size() + 1);
            newList.addAll(listenerList);
            newList.add(new ListenerInfo(listener, filter, handback));
            listenerList = newList;
        }
    }

    public void removeNotificationListener(NotificationListener listener)
        throws ListenerNotFoundException {

        synchronized (listenerLock) {
            List<ListenerInfo> newList = new ArrayList<>(listenerList);
            /* We scan the list of listeners in reverse order because
               in forward order we would have to repeat the loop with
               the same index after a remove.  */
            for (int i=newList.size()-1; i>=0; i--) {
                ListenerInfo li = newList.get(i);

                if (li.listener == listener)
                    newList.remove(i);
            }
            if (newList.size() == listenerList.size())
                throw new ListenerNotFoundException("Listener not registered");
            listenerList = newList;
        }
    }

    public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter,
                                           Object handback)
            throws ListenerNotFoundException {

        boolean found = false;

        synchronized (listenerLock) {
            List<ListenerInfo> newList = new ArrayList<>(listenerList);
            final int size = newList.size();
            for (int i = 0; i < size; i++) {
                ListenerInfo li =  newList.get(i);

                if (li.listener == listener) {
                    found = true;
                    if (li.filter == filter
                        && li.handback == handback) {
                        newList.remove(i);
                        listenerList = newList;
                        return;
                    }
                }
            }
        }

        if (found) {
            /* We found this listener, but not with the given filter
             * and handback.  A more informative exception message may
             * make debugging easier.  */
            throw new ListenerNotFoundException("Listener not registered " +
                                                "with this filter and " +
                                                "handback");
        } else {
            throw new ListenerNotFoundException("Listener not registered");
        }
    }

    public void sendNotification(Notification notification) {

        if (notification == null) {
            return;
        }

        List<ListenerInfo> currentList;
        synchronized (listenerLock) {
            currentList = listenerList;
        }

        final int size = currentList.size();
        for (int i = 0; i < size; i++) {
            ListenerInfo li =  currentList.get(i);

            if (li.filter == null
                || li.filter.isNotificationEnabled(notification)) {
                try {
                    li.listener.handleNotification(notification, li.handback);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new AssertionError("Error in invoking listener");
                }
            }
        }
    }

    public boolean hasListeners() {
        synchronized (listenerLock) {
            return !listenerList.isEmpty();
        }
    }

    private class ListenerInfo {
        public NotificationListener listener;
        NotificationFilter filter;
        Object handback;

        public ListenerInfo(NotificationListener listener,
                            NotificationFilter filter,
                            Object handback) {
            this.listener = listener;
            this.filter = filter;
            this.handback = handback;
        }
    }

    /**
     * Current list of listeners, a List of ListenerInfo.  The object
     * referenced by this field is never modified.  Instead, the field
     * is set to a new object when a listener is added or removed,
     * within a synchronized(this).  In this way, there is no need to
     * synchronize when traversing the list to send a notification to
     * the listeners in it.  That avoids potential deadlocks if the
     * listeners end up depending on other threads that are themselves
     * accessing this NotificationBroadcasterSupport.
     */
    private List<ListenerInfo> listenerList = Collections.emptyList();

    abstract public MBeanNotificationInfo[] getNotificationInfo();
}
