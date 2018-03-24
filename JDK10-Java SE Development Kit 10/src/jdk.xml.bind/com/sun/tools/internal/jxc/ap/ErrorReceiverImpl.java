/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.jxc.ap;

import com.sun.tools.internal.xjc.ErrorReceiver;
import org.xml.sax.SAXParseException;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.tools.Diagnostic;

/**
 * @author Kohsuke Kawaguchi
 */
final class ErrorReceiverImpl extends ErrorReceiver {
    private final Messager messager;
    private final boolean debug;

    public ErrorReceiverImpl(Messager messager, boolean debug) {
        this.messager = messager;
        this.debug = debug;
    }

    public ErrorReceiverImpl(Messager messager) {
        this(messager,false);
    }

    public ErrorReceiverImpl(ProcessingEnvironment env) {
        this(env.getMessager());
    }

    public void error(SAXParseException exception) {
        messager.printMessage(Diagnostic.Kind.ERROR, exception.getMessage());
        messager.printMessage(Diagnostic.Kind.ERROR, getLocation(exception));
        printDetail(exception);
    }

    public void fatalError(SAXParseException exception) {
        messager.printMessage(Diagnostic.Kind.ERROR, exception.getMessage());
        messager.printMessage(Diagnostic.Kind.ERROR, getLocation(exception));
        printDetail(exception);
    }

    public void warning(SAXParseException exception) {
        messager.printMessage(Diagnostic.Kind.WARNING, exception.getMessage());
        messager.printMessage(Diagnostic.Kind.WARNING, getLocation(exception));
        printDetail(exception);
    }

    public void info(SAXParseException exception) {
        printDetail(exception);
    }

    private String getLocation(SAXParseException e) {
        // TODO: format the location information for printing
        return "";
    }

    private void printDetail(SAXParseException e) {
        if(debug) {
            e.printStackTrace(System.out);
        }
    }
}
