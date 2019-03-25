/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.util.logging;

/**
 * This {@code Handler} publishes log records to {@code System.err}.
 * By default the {@code SimpleFormatter} is used to generate brief summaries.
 * <p>
 * <b>Configuration:</b>
 * By default each {@code ConsoleHandler} is initialized using the following
 * {@code LogManager} configuration properties where {@code <handler-name>}
 * refers to the fully-qualified class name of the handler.
 * If properties are not defined
 * (or have invalid values) then the specified default values are used.
 * <ul>
 * <li>   &lt;handler-name&gt;.level
 *        specifies the default level for the {@code Handler}
 *        (defaults to {@code Level.INFO}). </li>
 * <li>   &lt;handler-name&gt;.filter
 *        specifies the name of a {@code Filter} class to use
 *        (defaults to no {@code Filter}). </li>
 * <li>   &lt;handler-name&gt;.formatter
 *        specifies the name of a {@code Formatter} class to use
 *        (defaults to {@code java.util.logging.SimpleFormatter}). </li>
 * <li>   &lt;handler-name&gt;.encoding
 *        the name of the character set encoding to use (defaults to
 *        the default platform encoding). </li>
 * </ul>
 * <p>
 * For example, the properties for {@code ConsoleHandler} would be:
 * <ul>
 * <li>   java.util.logging.ConsoleHandler.level=INFO </li>
 * <li>   java.util.logging.ConsoleHandler.formatter=java.util.logging.SimpleFormatter </li>
 * </ul>
 * <p>
 * For a custom handler, e.g. com.foo.MyHandler, the properties would be:
 * <ul>
 * <li>   com.foo.MyHandler.level=INFO </li>
 * <li>   com.foo.MyHandler.formatter=java.util.logging.SimpleFormatter </li>
 * </ul>
 *
 * @since 1.4
 */
public class ConsoleHandler extends StreamHandler {

    /**
     * Create a {@code ConsoleHandler} for {@code System.err}.
     * <p>
     * The {@code ConsoleHandler} is configured based on
     * {@code LogManager} properties (or their default values).
     *
     */
    public ConsoleHandler() {
        // configure with specific defaults for ConsoleHandler
        super(Level.INFO, new SimpleFormatter(), null);

        setOutputStreamPrivileged(System.err);
    }

    /**
     * Publish a {@code LogRecord}.
     * <p>
     * The logging request was made initially to a {@code Logger} object,
     * which initialized the {@code LogRecord} and forwarded it here.
     *
     * @param  record  description of the log event. A null record is
     *                 silently ignored and is not published
     */
    @Override
    public void publish(LogRecord record) {
        super.publish(record);
        flush();
    }

    /**
     * Override {@code StreamHandler.close} to do a flush but not
     * to close the output stream.  That is, we do <b>not</b>
     * close {@code System.err}.
     */
    @Override
    public void close() {
        flush();
    }
}
