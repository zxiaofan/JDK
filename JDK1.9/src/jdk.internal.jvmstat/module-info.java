/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Defines an internal API for monitoring a HotSpot Java Virtual Machine using
 * its shared memory instrumentation buffer
 *
 * @since 9
 */
module jdk.internal.jvmstat {
    exports sun.jvmstat.monitor to
        jdk.attach,
        jdk.jcmd,
        jdk.jconsole,
        jdk.jstatd;
    exports sun.jvmstat.monitor.event to
        jdk.jcmd,
        jdk.jstatd;
    exports sun.jvmstat.perfdata.monitor to
        jdk.jstatd;

    uses sun.jvmstat.monitor.MonitoredHostService;

    provides sun.jvmstat.monitor.MonitoredHostService with
        sun.jvmstat.perfdata.monitor.protocol.file.MonitoredHostFileService,
        sun.jvmstat.perfdata.monitor.protocol.local.MonitoredHostLocalService;
}

