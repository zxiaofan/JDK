/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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

@Name(Type.EVENT_NAME_PREFIX + "JavaExceptionThrow")
@Label("Java Exception")
@Category("Java Application")
@Description("An object derived from java.lang.Exception has been created")
public final class ExceptionThrownEvent extends AbstractJDKEvent {

    @Label("Message")
    public String message;

    @Label("Class")
    public Class<?> thrownClass;
}
