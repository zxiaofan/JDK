/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jshell;

/**
 * Wraps an throwable thrown in the executing client.
 * An instance of <code>EvalException</code> can be returned in the
 * {@link jdk.jshell.SnippetEvent#exception()} query.
 * The name of the throwable thrown is available from
 * {@link jdk.jshell.EvalException#getExceptionClassName()}.
 * Message and stack can be queried by methods on <code>Exception</code>.
 * <p>
 * Note that in stack trace frames representing JShell Snippets,
 * <code>StackTraceElement.getFileName()</code> will return "#" followed by
 * the Snippet id and for snippets without a method name (for example an
 * expression) <code>StackTraceElement.getMethodName()</code> will be the
 * empty string.
 *
 * @since 9
 */
@SuppressWarnings("serial")             // serialVersionUID intentionally omitted
public class EvalException extends JShellException {
    private final String exceptionClass;

    EvalException(String message, String exceptionClass,
            StackTraceElement[] stackElements, JShellException cause) {
        super(message, cause);
        this.exceptionClass = exceptionClass;
        this.setStackTrace(stackElements);
    }

    /**
     * Returns the name of the Throwable subclass which was thrown in the
     * executing client. Note this class may not be loaded in the controlling
     * process.
     * See
     * {@link java.lang.Class#getName() Class.getName()} for the format of the string.
     * @return the name of the exception class as a String
     */
    public String getExceptionClassName() {
        return exceptionClass;
    }

    /**
     * Returns the wrapped cause of the throwable in the executing client
     * represented by this {@code EvalException} or {@code null} if the cause is
     * nonexistent or unknown.
     *
     * @return the cause wrapped in a {@code EvalException} or
     * {@link UnresolvedReferenceException} or return {@code null} if the cause
     * is nonexistent or unknown.
     * @since 11
     */
    @Override
    public JShellException getCause() {
        return (JShellException) super.getCause();
    }
}
