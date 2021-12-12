/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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


package jdk.javadoc.internal.doclets.toolkit;

import java.util.List;

import jdk.javadoc.internal.doclets.toolkit.util.DocPath;
/**
 * The interface for copying doc-files to the output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */

public interface DocFilesHandler {
    void copyDocFiles() throws DocletException;
    List<DocPath> getStylesheets() throws DocletException;
}
