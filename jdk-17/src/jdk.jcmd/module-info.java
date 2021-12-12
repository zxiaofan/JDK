/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Defines tools for diagnostics and troubleshooting a JVM
 * such as the <em>{@index jcmd jcmd tool}</em>, <em>{@index jps jps tool}</em>,
 * <em>{@index jstat jstat tool}</em> tools.
 *
 * @toolGuide jcmd
 * @toolGuide jinfo
 * @toolGuide jmap
 * @toolGuide jps
 * @toolGuide jstack
 * @toolGuide jstat
 *
 * @moduleGraph
 * @since 9
 */
module jdk.jcmd {
    requires jdk.attach;
    requires jdk.internal.jvmstat;
}
