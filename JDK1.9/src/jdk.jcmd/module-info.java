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
 * Defines tools for diagnostics and troubleshooting a JVM
 * such as the <em>{@index jcmd jcmd tool}</em>, <em>{@index jps jps tool}</em>,
 * <em>{@index jstat jstat tool}</em> tools.
 *
 * <dl style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">
 * <dt class="simpleTagLabel">Tool Guides:
 * <dd>
 * {@extLink jcmd_tool_reference jcmd},
 * {@extLink jinfo_tool_reference jinfo},
 * {@extLink jmap_tool_reference jmap},
 * {@extLink jps_tool_reference jps},
 * {@extLink jstack_tool_reference jstack},
 * {@extLink jstat_tool_reference jstat}
 * </dl>
 *
 * @moduleGraph
 * @since 9
 */
module jdk.jcmd {
    requires jdk.attach;
    requires jdk.internal.jvmstat;
}
