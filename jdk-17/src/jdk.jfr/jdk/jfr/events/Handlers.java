/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
import jdk.jfr.internal.handlers.EventHandler;
import jdk.jfr.internal.Utils;

public final class Handlers {
    public static final EventHandler SOCKET_READ = Utils.getHandler(SocketReadEvent.class);
    public static final EventHandler SOCKET_WRITE = Utils.getHandler(SocketWriteEvent.class);
    public static final EventHandler FILE_READ = Utils.getHandler(FileReadEvent.class);
    public static final EventHandler FILE_WRITE = Utils.getHandler(FileWriteEvent.class);
    public static final EventHandler FILE_FORCE = Utils.getHandler(FileForceEvent.class);
    public static final EventHandler ERROR_THROWN = Utils.getHandler(ErrorThrownEvent.class);
    public static final EventHandler EXCEPTION_THROWN = Utils.getHandler(ExceptionThrownEvent.class);
}
