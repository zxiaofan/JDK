/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

/**
 * Thrown to indicate that an assertion has failed.
 *
 * <p>The seven one-argument public constructors provided by this
 * class ensure that the assertion error returned by the invocation:
 * <pre>
 *     new AssertionError(<i>expression</i>)
 * </pre>
 * has as its detail message the <i>string conversion</i> of
 * <i>expression</i> (as defined in <a
 * href="http://java.sun.com/docs/books/jls/second_edition/html/j.title.doc.html">
 * <i>The Java Language Specification, Second Edition</i></a>, 
 * <a href="http://java.sun.com/docs/books/jls/second_edition/html/expressions.doc.html#40220">
 * Section  15.18.1.1</a>), regardless of the type of <i>expression</i>.
 *
 * @version %I%, %G%
 * @since   1.4
 */
public class AssertionError extends Error {
    /**
     * Constructs an AssertionError with no detail message.
     */
    public AssertionError() {
    }

    /**
     * This internal constructor does no processing on its string argument,
     * even if it is a null reference.  The public constructors will
     * never call this constructor with a null argument.
     */
    private AssertionError(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs an AssertionError with its detail message derived
     * from the specified object, which is converted to a string as
     * defined in <i>The Java Language Specification, Second
     * Edition</i>, Section 15.18.1.1.
     *<p>
     * If the specified object is an instance of <tt>Throwable</tt>, it
     * becomes the <i>cause</i> of the newly constructed assertion error.
     *
     * @param detailMessage value to be used in constructing detail message
     * @see   Throwable#getCause()
     */
    public AssertionError(Object detailMessage) {
        this("" +  detailMessage);
        if (detailMessage instanceof Throwable)
            initCause((Throwable) detailMessage);
    }

    /**
     * Constructs an AssertionError with its detail message derived
     * from the specified <code>boolean</code>, which is converted to
     * a string as defined in <i>The Java Language Specification,
     * Second Edition</i>, Section 15.18.1.1.
     *
     * @param detailMessage value to be used in constructing detail message
     */
    public AssertionError(boolean detailMessage) {
        this("" +  detailMessage);
    }

    /**
     * Constructs an AssertionError with its detail message derived
     * from the specified <code>char</code>, which is converted to a
     * string as defined in <i>The Java Language Specification, Second
     * Edition</i>, Section 15.18.1.1.
     *
     * @param detailMessage value to be used in constructing detail message
     */
    public AssertionError(char detailMessage) {
        this("" +  detailMessage);
    }

    /**
     * Constructs an AssertionError with its detail message derived
     * from the specified <code>int</code>, which is converted to a
     * string as defined in <i>The Java Language Specification, Second
     * Edition</i>, Section 15.18.1.1.
     *
     * @param detailMessage value to be used in constructing detail message
     */
    public AssertionError(int detailMessage) {
        this("" +  detailMessage);
    }

    /**
     * Constructs an AssertionError with its detail message derived
     * from the specified <code>long</code>, which is converted to a
     * string as defined in <i>The Java Language Specification, Second
     * Edition</i>, Section 15.18.1.1.
     *
     * @param detailMessage value to be used in constructing detail message
     */
    public AssertionError(long detailMessage) {
        this("" +  detailMessage);
    }

    /**
     * Constructs an AssertionError with its detail message derived
     * from the specified <code>float</code>, which is converted to a
     * string as defined in <i>The Java Language Specification, Second
     * Edition</i>, Section 15.18.1.1.
     *
     * @param detailMessage value to be used in constructing detail message
     */
    public AssertionError(float detailMessage) {
        this("" +  detailMessage);
    }

    /**
     * Constructs an AssertionError with its detail message derived
     * from the specified <code>double</code>, which is converted to a
     * string as defined in <i>The Java Language Specification, Second
     * Edition</i>, Section 15.18.1.1.
     *
     * @param detailMessage value to be used in constructing detail message
     */
    public AssertionError(double detailMessage) {
        this("" +  detailMessage);
    }
}
