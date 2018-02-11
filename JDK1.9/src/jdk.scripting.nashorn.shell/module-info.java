/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
 * Defines Nashorn shell module.
 *
 * <p>This module includes the command line tool <em>{@index jjs jjs tool}</em>
 * to invoke the Nashorn engine.
 *
 * <dl style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">
 * <dt class="simpleTagLabel">Tool Guides:
 * <dd>{@extLink jjs_tool_reference jjs}
 * </dl>
 *
 * @moduleGraph
 * @since 9
 */
module jdk.scripting.nashorn.shell {
    requires java.compiler;
    requires java.desktop;
    requires jdk.internal.le;
    requires jdk.scripting.nashorn;
}

