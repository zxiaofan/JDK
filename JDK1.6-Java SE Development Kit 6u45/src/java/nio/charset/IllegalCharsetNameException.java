/*
 * @(#)IllegalCharsetNameException.java	%I% %E%
 *
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
 * 
 * This software is the proprietary information of Oracle.
 * Use is subject to license terms.
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio.charset;


/**
 * Unchecked exception thrown when a string that is not a
 * <a href=Charset.html#names>legal charset name</a> is used as such.
 *
 * @version %I%, %E%
 * @since 1.4
 */

public class IllegalCharsetNameException
    extends IllegalArgumentException
{

    private String charsetName;

    /**
     * Constructs an instance of this class. </p>
     *
     * @param  charsetName
     *         The illegal charset name
     */
    public IllegalCharsetNameException(String charsetName) {
        super(String.valueOf(charsetName));
	this.charsetName = charsetName;
    }

    /**
     * Retrieves the illegal charset name. </p>
     *
     * @return  The illegal charset name
     */
    public String getCharsetName() {
        return charsetName;
    }

}
