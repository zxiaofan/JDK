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
 * Defines the Scripting API.
 *
 * <p> The JDK implementation of this module includes a language-independent
 * command-line script shell, <em>{@index jrunscript jrunscript tool}</em>,
 * that supports executing JavaScript and other languages if its corresponding
 * script engine is installed.
 *
 * <dl style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">
 * <dt class="simpleTagLabel">Tool Guides:
 * <dd> {@extLink jrunscript_tool_reference jrunscript}</dd>
 * </dl>
 *
 * @uses javax.script.ScriptEngineFactory
 *
 * @moduleGraph
 * @since 9
 */
module java.scripting {
    exports javax.script;

    uses javax.script.ScriptEngineFactory;
}
