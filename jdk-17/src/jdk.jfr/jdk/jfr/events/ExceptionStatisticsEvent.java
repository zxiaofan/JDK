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
import jdk.jfr.StackTrace;
import jdk.jfr.internal.Type;

@Name(Type.EVENT_NAME_PREFIX + "ExceptionStatistics")
@Label("Exception Statistics")
@Category({ "Java Application", "Statistics" })
@Description("Number of objects derived from java.lang.Throwable that have been created")
@StackTrace(false)
public final class ExceptionStatisticsEvent extends AbstractJDKEvent {

    @Label("Exceptions Created")
    public long throwables;
}
