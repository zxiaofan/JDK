/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the core Java SE API.
 * <P>
 * The modules defining the CORBA and Java EE APIs are not required by
 * this module, but they are required by the
 * <a href="java.se.ee-summary.html">{@code java.se.ee}</a> module.
 *
 * <dl>
 * <dt class="simpleTagLabel" style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">Optional for the Java SE Platform:</dt>
 * <dd>
 *   <a href="../specs/jni/index.html">Java Native Interface (JNI)</a><br>
 *   <a href="../specs/jvmti.html">Java Virtual Machine Tool Interface (JVM TI)</a><br>
 *   <a href="../specs/jdwp/jdwp-spec.html">Java Debug Wire Protocol (JDWP)</a><br>
 * </dd>
 * </dl>
 *
 * @moduleGraph
 * @since 9
 */
module java.se {
    requires transitive java.compiler;
    requires transitive java.datatransfer;
    requires transitive java.desktop;
    requires transitive java.instrument;
    requires transitive java.logging;
    requires transitive java.management;
    requires transitive java.management.rmi;
    requires transitive java.naming;
    requires transitive java.prefs;
    requires transitive java.rmi;
    requires transitive java.scripting;
    requires transitive java.security.jgss;
    requires transitive java.security.sasl;
    requires transitive java.sql;
    requires transitive java.sql.rowset;
    requires transitive java.xml;
    requires transitive java.xml.crypto;
}
