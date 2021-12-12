/*
 * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
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
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.StackTrace;
import jdk.jfr.internal.Type;

@Name(Type.EVENT_NAME_PREFIX + "ActiveSetting")
@Label("Recording Setting")
@Category("Flight Recorder")
@StackTrace(false)
public final class ActiveSettingEvent extends AbstractJDKEvent {

    public static final ThreadLocal<ActiveSettingEvent> EVENT = new ThreadLocal<ActiveSettingEvent>() {
        @Override
        protected ActiveSettingEvent initialValue() {
            return new ActiveSettingEvent();
        }
    };

    @Label("Event Id")
    public long id;

    @Label("Setting Name")
    public String name;

    @Label("Setting Value")
    public String value;
}
