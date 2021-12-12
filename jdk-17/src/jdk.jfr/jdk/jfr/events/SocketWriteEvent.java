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
import jdk.jfr.DataAmount;
import jdk.jfr.Name;
import jdk.jfr.internal.Type;

@Name(Type.EVENT_NAME_PREFIX + "SocketWrite")
@Label("Socket Write")
@Category("Java Application")
@Description("Writing data to a socket")
public final class SocketWriteEvent extends AbstractJDKEvent {

    // The order of these fields must be the same as the parameters in
    // EventHandler::write(..., String, String, int, long)

    @Label("Remote Host")
    public String host;

    @Label("Remote Address")
    public String address;

    @Label("Remote Port")
    public int port;

    @Label("Bytes Written")
    @Description("Number of bytes written to the socket")
    @DataAmount
    public long bytesWritten;
}
