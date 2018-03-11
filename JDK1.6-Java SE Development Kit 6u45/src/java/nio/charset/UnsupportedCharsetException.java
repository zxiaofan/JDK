/*
 * @(#)UnsupportedCharsetException.java	%I% %E%
 *
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
 * 
 * This software is the proprietary information of Oracle.
 * Use is subject to license terms.
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio.charset;


/**
 * Unchecked exception thrown when no support is available
 * for a requested charset.
 *
 * @version %I%, %E%
 * @since 1.4
 */

public class UnsupportedCharsetException
    extends IllegalArgumentException
{

    private String charsetName;

    /**
     * Constructs an instance of this class. </p>
     *
     * @param  charsetName
     *         The name of the unsupported charset
     */
    public UnsupportedCharsetException(String charsetName) {
        super(String.valueOf(charsetName));
	this.charsetName = charsetName;
    }

    /**
     * Retrieves the name of the unsupported charset. </p>
     *
     * @return  The name of the unsupported charset
     */
    public String getCharsetName() {
        return charsetName;
    }

}
