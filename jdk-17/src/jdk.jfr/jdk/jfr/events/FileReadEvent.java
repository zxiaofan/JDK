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

@Name(Type.EVENT_NAME_PREFIX + "FileRead")
@Label("File Read")
@Category("Java Application")
@Description("Reading data from a file")
public final class FileReadEvent extends AbstractJDKEvent {

    // The order of these fields must be the same as the parameters in
    // EventHandler::write(..., String, long, boolean)

    @Label("Path")
    @Description("Full path of the file")
    public String path;

    @Label("Bytes Read")
    @Description("Number of bytes read from the file (possibly 0)")
    @DataAmount
    public long bytesRead;

    @Label("End of File")
    @Description("If end of file was reached")
    public boolean endOfFile;
}
