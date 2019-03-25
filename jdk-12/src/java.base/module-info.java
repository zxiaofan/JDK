/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the foundational APIs of the Java SE Platform.
 *
 * <dl>
 * <dt class="simpleTagLabel" style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">Providers:</dt>
 * <dd> The JDK implementation of this module provides an implementation of
 *      the {@index jrt jrt} {@linkplain java.nio.file.spi.FileSystemProvider
 *      file system provider} to enumerate and read the class and resource
 *      files in a run-time image.
 *      The jrt file system can be created by calling
 *      {@link java.nio.file.FileSystems#newFileSystem
 *      FileSystems.newFileSystem(URI.create("jrt:/"))}.
 *      </dd>
 * <dt class="simpleTagLabel" style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">Tool Guides:</dt>
 * <dd style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif"> {@extLink java_tool_reference java launcher},
 *      {@extLink keytool_tool_reference keytool}</dd>
 * </dl>
 *
 * @provides java.nio.file.spi.FileSystemProvider
 *
 * @uses java.lang.System.LoggerFinder
 * @uses java.net.ContentHandlerFactory
 * @uses java.net.spi.URLStreamHandlerProvider
 * @uses java.nio.channels.spi.AsynchronousChannelProvider
 * @uses java.nio.channels.spi.SelectorProvider
 * @uses java.nio.charset.spi.CharsetProvider
 * @uses java.nio.file.spi.FileSystemProvider
 * @uses java.nio.file.spi.FileTypeDetector
 * @uses java.security.Provider
 * @uses java.text.spi.BreakIteratorProvider
 * @uses java.text.spi.CollatorProvider
 * @uses java.text.spi.DateFormatProvider
 * @uses java.text.spi.DateFormatSymbolsProvider
 * @uses java.text.spi.DecimalFormatSymbolsProvider
 * @uses java.text.spi.NumberFormatProvider
 * @uses java.time.chrono.AbstractChronology
 * @uses java.time.chrono.Chronology
 * @uses java.time.zone.ZoneRulesProvider
 * @uses java.util.spi.CalendarDataProvider
 * @uses java.util.spi.CalendarNameProvider
 * @uses java.util.spi.CurrencyNameProvider
 * @uses java.util.spi.LocaleNameProvider
 * @uses java.util.spi.ResourceBundleControlProvider
 * @uses java.util.spi.ResourceBundleProvider
 * @uses java.util.spi.TimeZoneNameProvider
 * @uses java.util.spi.ToolProvider
 * @uses javax.security.auth.spi.LoginModule
 *
 * @moduleGraph
 * @since 9
 */
module java.base {
    // source file: file:///scratch/opt/mach5/mesos/work_dir/slaves/2dd962d0-8988-479b-a804-57ab764ada59-S1254/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/f2448e11-af07-4931-ba4b-f7fcc53664cb/runs/1f786c06-50de-4f58-8401-8213090807ac/workspace/open/src/java.base/share/classes/module-info.java
    //              file:///scratch/opt/mach5/mesos/work_dir/slaves/2dd962d0-8988-479b-a804-57ab764ada59-S1254/frameworks/1735e8a2-a1db-478c-8104-60c8b0af87dd-0196/executors/f2448e11-af07-4931-ba4b-f7fcc53664cb/runs/1f786c06-50de-4f58-8401-8213090807ac/workspace/open/src/java.base/unix/classes/module-info.java.extra
    exports java.io;
    exports java.lang;
    exports java.lang.annotation;
    exports java.lang.constant;
    exports java.lang.invoke;
    exports java.lang.module;
    exports java.lang.ref;
    exports java.lang.reflect;
    exports java.math;
    exports java.net;
    exports java.net.spi;
    exports java.nio;
    exports java.nio.channels;
    exports java.nio.channels.spi;
    exports java.nio.charset;
    exports java.nio.charset.spi;
    exports java.nio.file;
    exports java.nio.file.attribute;
    exports java.nio.file.spi;
    exports java.security;
    exports java.security.acl;
    exports java.security.cert;
    exports java.security.interfaces;
    exports java.security.spec;
    exports java.text;
    exports java.text.spi;
    exports java.time;
    exports java.time.chrono;
    exports java.time.format;
    exports java.time.temporal;
    exports java.time.zone;
    exports java.util;
    exports java.util.concurrent;
    exports java.util.concurrent.atomic;
    exports java.util.concurrent.locks;
    exports java.util.function;
    exports java.util.jar;
    exports java.util.regex;
    exports java.util.spi;
    exports java.util.stream;
    exports java.util.zip;
    exports javax.crypto;
    exports javax.crypto.interfaces;
    exports javax.crypto.spec;
    exports javax.net;
    exports javax.net.ssl;
    exports javax.security.auth;
    exports javax.security.auth.callback;
    exports javax.security.auth.login;
    exports javax.security.auth.spi;
    exports javax.security.auth.x500;
    exports javax.security.cert;
    exports com.sun.security.ntlm to java.security.sasl;
    exports jdk.internal to jdk.jfr;
    exports jdk.internal.access to
        java.desktop,
        java.logging,
        java.management,
        java.naming,
        java.rmi,
        jdk.jlink,
        jdk.net;
    exports jdk.internal.event to jdk.jfr;
    exports jdk.internal.jimage to jdk.jlink;
    exports jdk.internal.jimage.decompressor to jdk.jlink;
    exports jdk.internal.jmod to
        jdk.compiler,
        jdk.jlink;
    exports jdk.internal.loader to
        java.instrument,
        java.logging;
    exports jdk.internal.logger to java.logging;
    exports jdk.internal.misc to
        java.desktop,
        java.logging,
        java.management,
        java.naming,
        java.net.http,
        java.rmi,
        java.security.jgss,
        java.xml,
        jdk.attach,
        jdk.charsets,
        jdk.compiler,
        jdk.internal.vm.ci,
        jdk.jfr,
        jdk.jshell,
        jdk.scripting.nashorn,
        jdk.scripting.nashorn.shell,
        jdk.unsupported;
    exports jdk.internal.module to
        java.instrument,
        java.management.rmi,
        jdk.jartool,
        jdk.jfr,
        jdk.jlink;
    exports jdk.internal.org.objectweb.asm to
        jdk.jartool,
        jdk.jfr,
        jdk.jlink,
        jdk.scripting.nashorn;
    exports jdk.internal.org.objectweb.asm.commons to
        jdk.jfr,
        jdk.scripting.nashorn;
    exports jdk.internal.org.objectweb.asm.signature to jdk.scripting.nashorn;
    exports jdk.internal.org.objectweb.asm.tree to
        jdk.jfr,
        jdk.jlink;
    exports jdk.internal.org.objectweb.asm.util to
        jdk.jfr,
        jdk.scripting.nashorn;
    exports jdk.internal.org.xml.sax to jdk.jfr;
    exports jdk.internal.org.xml.sax.helpers to jdk.jfr;
    exports jdk.internal.perf to
        java.management,
        jdk.internal.jvmstat,
        jdk.management.agent;
    exports jdk.internal.ref to java.desktop;
    exports jdk.internal.reflect to
        java.logging,
        java.sql,
        java.sql.rowset,
        jdk.dynalink,
        jdk.scripting.nashorn,
        jdk.unsupported;
    exports jdk.internal.util.jar to jdk.jartool;
    exports jdk.internal.util.xml to jdk.jfr;
    exports jdk.internal.util.xml.impl to jdk.jfr;
    exports jdk.internal.vm to
        jdk.internal.jvmstat,
        jdk.management.agent;
    exports jdk.internal.vm.annotation to
        jdk.internal.vm.ci,
        jdk.unsupported;
    exports sun.net to
        java.net.http,
        jdk.naming.dns;
    exports sun.net.dns to
        java.security.jgss,
        jdk.naming.dns;
    exports sun.net.ext to jdk.net;
    exports sun.net.util to
        java.desktop,
        java.net.http,
        jdk.jconsole;
    exports sun.net.www to
        java.net.http,
        jdk.jartool;
    exports sun.net.www.protocol.http to java.security.jgss;
    exports sun.nio.ch to
        java.management,
        jdk.crypto.cryptoki,
        jdk.net,
        jdk.sctp;
    exports sun.nio.cs to
        java.desktop,
        jdk.charsets;
    exports sun.reflect.annotation to jdk.compiler;
    exports sun.reflect.generics.reflectiveObjects to java.desktop;
    exports sun.reflect.misc to
        java.datatransfer,
        java.desktop,
        java.management,
        java.management.rmi,
        java.rmi,
        java.sql.rowset;
    exports sun.security.action to
        java.desktop,
        java.security.jgss;
    exports sun.security.internal.interfaces to jdk.crypto.cryptoki;
    exports sun.security.internal.spec to jdk.crypto.cryptoki;
    exports sun.security.jca to
        java.smartcardio,
        jdk.crypto.cryptoki,
        jdk.crypto.ec,
        jdk.naming.dns;
    exports sun.security.pkcs to
        jdk.crypto.ec,
        jdk.jartool;
    exports sun.security.provider to
        java.rmi,
        java.security.jgss,
        jdk.crypto.cryptoki,
        jdk.security.auth;
    exports sun.security.provider.certpath to java.naming;
    exports sun.security.rsa to jdk.crypto.cryptoki;
    exports sun.security.timestamp to jdk.jartool;
    exports sun.security.tools to jdk.jartool;
    exports sun.security.util to
        java.desktop,
        java.naming,
        java.rmi,
        java.security.jgss,
        java.security.sasl,
        java.smartcardio,
        java.xml.crypto,
        jdk.crypto.cryptoki,
        jdk.crypto.ec,
        jdk.jartool,
        jdk.security.auth,
        jdk.security.jgss;
    exports sun.security.util.math to jdk.crypto.ec;
    exports sun.security.util.math.intpoly to jdk.crypto.ec;
    exports sun.security.validator to jdk.jartool;
    exports sun.security.x509 to
        jdk.crypto.cryptoki,
        jdk.crypto.ec,
        jdk.jartool;
    exports sun.util.cldr to jdk.jlink;
    exports sun.util.locale.provider to
        java.desktop,
        jdk.jlink,
        jdk.localedata;
    exports sun.util.logging to
        java.desktop,
        java.logging,
        java.prefs;
    exports sun.util.resources to jdk.localedata;

    uses java.lang.System.LoggerFinder;
    uses java.net.ContentHandlerFactory;
    uses java.net.spi.URLStreamHandlerProvider;
    uses java.nio.channels.spi.AsynchronousChannelProvider;
    uses java.nio.channels.spi.SelectorProvider;
    uses java.nio.charset.spi.CharsetProvider;
    uses java.nio.file.spi.FileSystemProvider;
    uses java.nio.file.spi.FileTypeDetector;
    uses java.security.Provider;
    uses java.text.spi.BreakIteratorProvider;
    uses java.text.spi.CollatorProvider;
    uses java.text.spi.DateFormatProvider;
    uses java.text.spi.DateFormatSymbolsProvider;
    uses java.text.spi.DecimalFormatSymbolsProvider;
    uses java.text.spi.NumberFormatProvider;
    uses java.time.chrono.AbstractChronology;
    uses java.time.chrono.Chronology;
    uses java.time.zone.ZoneRulesProvider;
    uses java.util.spi.CalendarDataProvider;
    uses java.util.spi.CalendarNameProvider;
    uses java.util.spi.CurrencyNameProvider;
    uses java.util.spi.LocaleNameProvider;
    uses java.util.spi.ResourceBundleControlProvider;
    uses java.util.spi.ResourceBundleProvider;
    uses java.util.spi.TimeZoneNameProvider;
    uses java.util.spi.ToolProvider;
    uses javax.security.auth.spi.LoginModule;
    uses jdk.internal.logger.DefaultLoggerFinder;
    uses sun.text.spi.JavaTimeDateTimePatternProvider;
    uses sun.util.locale.provider.LocaleDataMetaInfo;
    uses sun.util.resources.LocaleData.CommonResourceBundleProvider;
    uses sun.util.resources.LocaleData.SupplementaryResourceBundleProvider;
    uses sun.util.spi.CalendarProvider;
    provides java.nio.file.spi.FileSystemProvider with jdk.internal.jrtfs.JrtFileSystemProvider;
}
