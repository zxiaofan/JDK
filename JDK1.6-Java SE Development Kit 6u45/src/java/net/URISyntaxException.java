/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.net;


/**
 * Checked exception thrown to indicate that a string could not be parsed as a
 * URI reference.
 *
 * @author Mark Reinhold
 * @version %I%, %E%
 * @see URI
 * @since 1.4
 */

public class URISyntaxException
    extends Exception
{
    private String input;
    private int index;

    /**
     * Constructs an instance from the given input string, reason, and error
     * index.
     *
     * @param  input   The input string
     * @param  reason  A string explaining why the input could not be parsed
     * @param  index   The index at which the parse error occurred,
     *                 or <tt>-1</tt> if the index is not known
     *
     * @throws  NullPointerException
     *          If either the input or reason strings are <tt>null</tt>
     *
     * @throws  IllegalArgumentException
     *          If the error index is less than <tt>-1</tt>
     */
    public URISyntaxException(String input, String reason, int index) {
	super(reason);
	if ((input == null) || (reason == null))
	    throw new NullPointerException();
	if (index < -1)
	    throw new IllegalArgumentException();
	this.input = input;
	this.index = index;
    }

    /**
     * Constructs an instance from the given input string and reason.  The
     * resulting object will have an error index of <tt>-1</tt>.
     *
     * @param  input   The input string
     * @param  reason  A string explaining why the input could not be parsed
     *
     * @throws  NullPointerException
     *          If either the input or reason strings are <tt>null</tt>
     */
    public URISyntaxException(String input, String reason) {
	this(input, reason, -1);
    }

    /**
     * Returns the input string.
     *
     * @return  The input string
     */
    public String getInput() {
	return input;
    }

    /**
     * Returns a string explaining why the input string could not be parsed.
     *
     * @return  The reason string
     */
    public String getReason() {
	return super.getMessage();
    }

    /**
     * Returns an index into the input string of the position at which the
     * parse error occurred, or <tt>-1</tt> if this position is not known.
     *
     * @return  The error index
     */
    public int getIndex() {
	return index;
    }

    /**
     * Returns a string describing the parse error.  The resulting string
     * consists of the reason string followed by a colon character
     * (<tt>':'</tt>), a space, and the input string.  If the error index is
     * defined then the string <tt>" at index "</tt> followed by the index, in
     * decimal, is inserted after the reason string and before the colon
     * character.
     *
     * @return  A string describing the parse error
     */
    public String getMessage() {
	StringBuffer sb = new StringBuffer();
	sb.append(getReason());
	if (index > -1) {
	    sb.append(" at index ");
	    sb.append(index);
	}
	sb.append(": ");
	sb.append(input);
	return sb.toString();
    }

}
