/*
 * Copyright (c) 2001, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdi;

import com.sun.jdi.AbsentInformationException;

class StratumLineInfo implements LineInfo {
    private final String stratumID;
    private final int lineNumber;
    private final String sourceName;
    private final String sourcePath;

    StratumLineInfo(String stratumID, int lineNumber,
                    String sourceName, String sourcePath) {
        this.stratumID = stratumID;
        this.lineNumber = lineNumber;
        this.sourceName = sourceName;
        this.sourcePath = sourcePath;
    }

    public String liStratum() {
        return stratumID;
    }

    public int liLineNumber() {
        return lineNumber;
    }

    public String liSourceName() throws AbsentInformationException {
        if (sourceName == null) {
            throw new AbsentInformationException();
        }
        return sourceName;
    }

    public String liSourcePath() throws AbsentInformationException {
        if (sourcePath == null) {
            throw new AbsentInformationException();
        }
        return sourcePath;
    }
}
