/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Provides the classes necessary to create an applet and the classes an applet
 * uses to communicate with its applet context.
 * <p>
 * The applet framework involves two entities: the <i>applet</i> and the
 * <i>applet context</i>. An applet is an embeddable window (see the Panel
 * class) with a few extra methods that the applet context can use to
 * initialize, start, and stop the applet.
 * <p>
 * The applet context is an application that is responsible for loading and
 * running applets. For example, the applet context could be a Web browser or an
 * applet development environment.
 * <p>
 * The APIs in this package are all deprecated without replacement.
 *
 * @since 1.0
 */
package java.applet;
