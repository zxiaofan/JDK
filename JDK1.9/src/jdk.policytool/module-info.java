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
 * Defines the GUI tool for managing policy files
 * called <em>{@index policytool policytool}</em>.
 *
 * <dl style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">
 * <dt class="simpleTagLabel">Tool Guides:
 * <dd>{@extLink policytool_tool_reference policytool}
 * </dl>
 *
 * @since 9
 * @deprecated
 */
@Deprecated(since="9", forRemoval=true)
module jdk.policytool {
    requires java.desktop;
    requires java.logging;
    requires java.management;
    requires java.security.jgss;
    requires java.sql;
    requires jdk.net;
    requires jdk.security.jgss;
}
