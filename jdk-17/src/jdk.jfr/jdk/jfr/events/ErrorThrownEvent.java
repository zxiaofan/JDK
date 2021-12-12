/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.events;

import jdk.jfr.Category;
import jdk.jfr.Description;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.internal.Type;

@Name(Type.EVENT_NAME_PREFIX + "JavaErrorThrow")
@Label("Java Error")
@Category("Java Application")
@Description("An object derived from java.lang.Error has been created. OutOfMemoryErrors are ignored")
public final class ErrorThrownEvent extends AbstractJDKEvent {

    // The order of these fields must be the same as the parameters in
    // EventHandler::write(..., String, Class)

    @Label("Message")
    public String message;

    @Label("Class")
    public Class<?> thrownClass;
}
