/*
 * Copyright (c) 1995, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.applet;

import java.net.URL;

/**
 * When an applet is first created, an applet stub is attached to it using the
 * applet's {@code setStub} method. This stub serves as the interface between
 * the applet and the browser environment or applet viewer environment in which
 * the application is running.
 *
 * @author Arthur van Hoff
 * @see java.applet.Applet#setStub(java.applet.AppletStub)
 * @since 1.0
 * @deprecated The Applet API is deprecated, no replacement.
 */
@Deprecated(since = "9", forRemoval = true)
@SuppressWarnings("removal")
public interface AppletStub {

    /**
     * Determines if the applet is active. An applet is active just before its
     * {@code start} method is called. It becomes inactive just before its
     * {@code stop} method is called.
     *
     * @return {@code true} if the applet is active; {@code false} otherwise
     */
    boolean isActive();

    /**
     * Gets the {@code URL} of the document in which the applet is embedded. For
     * example, suppose an applet is contained within the document:
     * <blockquote><pre>
     *    http://www.oracle.com/technetwork/java/index.html
     * </pre></blockquote>
     * The document base is:
     * <blockquote><pre>
     *    http://www.oracle.com/technetwork/java/index.html
     * </pre></blockquote>
     *
     * @return the {@link java.net.URL} of the document that contains the applet
     * @see java.applet.AppletStub#getCodeBase()
     */
    URL getDocumentBase();

    /**
     * Gets the base {@code URL}. This is the {@code URL} of the directory which
     * contains the applet.
     *
     * @return the base {@link java.net.URL} of the directory which contains the
     *         applet
     * @see java.applet.AppletStub#getDocumentBase()
     */
    URL getCodeBase();

    /**
     * Returns the value of the named parameter in the HTML tag. For example, if
     * an applet is specified as
     * <blockquote><pre>
     * &lt;applet code="Clock" width=50 height=50&gt;
     * &lt;param name=Color value="blue"&gt;
     * &lt;/applet&gt;
     * </pre></blockquote>
     * <p>
     * then a call to {@code getParameter("Color")} returns the value
     * {@code "blue"}.
     *
     * @param  name a parameter name
     * @return the value of the named parameter, or {@code null} if not set
     */
    String getParameter(String name);

    /**
     * Returns the applet's context.
     *
     * @return the applet's context
     */
    AppletContext getAppletContext();

    /**
     * Called when the applet wants to be resized.
     *
     * @param  width the new requested width for the applet
     * @param  height the new requested height for the applet
     */
    void appletResize(int width, int height);
}
