/*
 * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
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

@Name(Type.EVENT_NAME_PREFIX + "FileForce")
@Label("File Force")
@Category("Java Application")
@Description("Force updates to be written to file")
public final class FileForceEvent extends AbstractJDKEvent {

    // The order of these fields must be the same as the parameters in
    // EventHandler::write(..., String, boolean)

    @Label("Path")
    @Description("Full path of the file")
    public String path;

    @Label("Update Metadata")
    @Description("Whether the file metadata is updated")
    public boolean metaData;
}
