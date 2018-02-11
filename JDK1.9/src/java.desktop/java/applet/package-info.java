/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * The APIs in this package are all deprecated. Alternative technologies such as
 * Java Web Start or installable applications should be used instead.
 * See <a href="http://openjdk.java.net/jeps/289">JEP 289</a> and
 * the Oracle White Paper
 * <a href="http://www.oracle.com/technetwork/java/javase/migratingfromapplets-2872444.pdf">
 * "Migrating from Java Applets to plugin-free Java technologies"</a> for more
 * information.
 *
 * @since 1.0
 */
package java.applet;
