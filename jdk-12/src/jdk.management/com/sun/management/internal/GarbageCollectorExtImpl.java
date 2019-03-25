/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.management.internal;

import com.sun.management.GarbageCollectionNotificationInfo;
import com.sun.management.GarbageCollectorMXBean;
import com.sun.management.GcInfo;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import sun.management.GarbageCollectorImpl;
import sun.management.ManagementFactoryHelper;

/**
 * Implementation class for the garbage collector.
 * Standard and committed hotspot-specific metrics if any.
 *
 * ManagementFactory.getGarbageCollectorMXBeans() returns a list
 * of instances of this class.
 */
public class GarbageCollectorExtImpl extends GarbageCollectorImpl
    implements GarbageCollectorMXBean {

    public GarbageCollectorExtImpl(String name) {
        super(name);
    }

    // The memory pools are static and won't be changed.
    // TODO: If the hotspot implementation begins to have pools
    // dynamically created and removed, this needs to be modified.
    private String[] poolNames = null;
    private synchronized String[] getAllPoolNames() {
        if (poolNames == null) {
            // The order of all memory pool names is important as GcInfo is also created with same order.
            poolNames = ManagementFactoryHelper.getAllMemoryPoolNames();
        }
        return poolNames;
    }

    public GcInfo getLastGcInfo() {
        GcInfo info = getGcInfoBuilder().getLastGcInfo();
        return info;
    }

    private final static String notifName =
        "javax.management.Notification";

    private final static String[] gcNotifTypes = {
        GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION
    };

    public MBeanNotificationInfo[] getNotificationInfo() {
        return new MBeanNotificationInfo[]{
            new MBeanNotificationInfo(gcNotifTypes,
            notifName,
            "GC Notification")
        };
    }

    private static long seqNumber = 0;
    private static long getNextSeqNumber() {
        return ++seqNumber;
    }

    protected void createGCNotification(long timestamp,
                              String gcName,
                              String gcAction,
                              String gcCause,
                              GcInfo gcInfo)  {
        if (!hasListeners()) {
            return;
        }
        Notification notif = new Notification(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION,
                                              getObjectName(),
                                              getNextSeqNumber(),
                                              timestamp,
                                              gcName);
        GarbageCollectionNotificationInfo info =
            new GarbageCollectionNotificationInfo(gcName,
                                                  gcAction,
                                                  gcCause,
                                                  gcInfo);

        CompositeData cd =
            GarbageCollectionNotifInfoCompositeData.toCompositeData(info);
        notif.setUserData(cd);
        sendNotification(notif);
    }

    public synchronized void addNotificationListener(NotificationListener listener,
                                                     NotificationFilter filter,
                                                     Object handback)
    {
        boolean before = hasListeners();
        super.addNotificationListener(listener, filter, handback);
        boolean after = hasListeners();
        if (!before && after) {
            setNotificationEnabled(this, true);
        }
    }

    public synchronized void removeNotificationListener(NotificationListener listener)
        throws ListenerNotFoundException {
        boolean before = hasListeners();
        super.removeNotificationListener(listener);
        boolean after = hasListeners();

        if (before && !after) {
            setNotificationEnabled(this,false);
        }
    }

    public synchronized void removeNotificationListener(NotificationListener listener,
                                                        NotificationFilter filter,
                                                        Object handback)
            throws ListenerNotFoundException
    {
        boolean before = hasListeners();
        super.removeNotificationListener(listener,filter,handback);
        boolean after = hasListeners();
        if (before && !after) {
            setNotificationEnabled(this,false);
        }
    }

    private GcInfoBuilder gcInfoBuilder;
    // Invoked also by the VM
    private synchronized GcInfoBuilder getGcInfoBuilder() {
        if(gcInfoBuilder == null) {
            gcInfoBuilder = new GcInfoBuilder(this, getAllPoolNames());
        }
        return gcInfoBuilder;
    }

    private native void setNotificationEnabled(GarbageCollectorMXBean gc,
                                                 boolean enabled);

    // Invoked by the VM
    private static java.lang.management.GarbageCollectorMXBean
        createGarbageCollector(String name, String type) {

        return new GarbageCollectorExtImpl(name);
    }
}
