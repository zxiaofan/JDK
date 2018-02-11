/*
 * Copyright (c) 2010, 2011, Oracle and/or its affiliates. All rights reserved.
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

/*
 *******************************************************************************
 * Copyright (C) 2010, International Business Machines Corporation and         *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 */
package sun.util.locale;

public class ParseStatus {
    int parseLength;
    int errorIndex;
    String errorMsg;

    public ParseStatus() {
        reset();
    }

    public void reset() {
        parseLength = 0;
        errorIndex = -1;
        errorMsg = null;
    }

    public boolean isError() {
        return (errorIndex >= 0);
    }

    public int getErrorIndex() {
        return errorIndex;
    }

    public int getParseLength() {
        return parseLength;
    }

    public String getErrorMessage() {
        return errorMsg;
    }
}
