/*
 * Copyright (c) 2014, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the API of the Java SE Platform.
 *
 * <dl class="notes">
 * <dt>Optional for the Java SE Platform:</dt>
 * <dd>
 *   <a href="{@docRoot}/../specs/jni/index.html">Java Native Interface (JNI)</a><br>
 *   <a href="{@docRoot}/../specs/jvmti.html">Java Virtual Machine Tool Interface (JVM TI)</a><br>
 *   <a href="{@docRoot}/../specs/jdwp/jdwp-spec.html">Java Debug Wire Protocol (JDWP)</a><br>
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
    requires transitive java.net.http;
    requires transitive java.prefs;
    requires transitive java.rmi;
    requires transitive java.scripting;
    requires transitive java.security.jgss;
    requires transitive java.security.sasl;
    requires transitive java.sql;
    requires transitive java.sql.rowset;
    requires transitive java.transaction.xa;
    requires transitive java.xml;
    requires transitive java.xml.crypto;
}
