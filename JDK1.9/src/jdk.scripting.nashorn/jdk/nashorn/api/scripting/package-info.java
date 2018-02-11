/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * This package provides the {@code javax.script} integration, which is the preferred way to use Nashorn.
 * You will ordinarily do this to obtain an instance of a Nashorn script engine:
 * <pre>
 * import javax.script.*;
 * ...
 * ScriptEngine nashornEngine = new ScriptEngineManager().getEngineByName("Nashorn");
 * </pre>
 * <p>Nashorn script engines implement the optional {@link javax.script.Invocable} and {@link javax.script.Compilable}
 * interfaces, allowing for efficient pre-compilation and repeated execution of scripts. In addition,
 * this package provides nashorn specific extension classes, interfaces and methods. See
 * {@link jdk.nashorn.api.scripting.NashornScriptEngineFactory} for further details.
 *
 * @since 1.8u40
 */
package jdk.nashorn.api.scripting;
