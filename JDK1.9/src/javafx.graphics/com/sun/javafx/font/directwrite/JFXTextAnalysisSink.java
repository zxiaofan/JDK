/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.font.directwrite;

/* JFX implementation for IDWriteTextAnalysisSink and IDWriteTextAnalysisSource */
class JFXTextAnalysisSink extends IUnknown {
    JFXTextAnalysisSink(long ptr) {
        super(ptr);
    }

    boolean Next() {
        return OS.Next(ptr);
    }

    int GetStart() {
        return OS.GetStart(ptr);
    }

    int GetLength() {
        return OS.GetLength(ptr);
    }

    DWRITE_SCRIPT_ANALYSIS GetAnalysis() {
        return OS.GetAnalysis(ptr);
    }
}
