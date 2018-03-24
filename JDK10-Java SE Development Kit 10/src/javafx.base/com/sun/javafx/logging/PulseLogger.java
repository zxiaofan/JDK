/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.logging;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class PulseLogger {

    public static final boolean PULSE_LOGGING_ENABLED;

    private static final Logger[] loggers;

    static {
        List<Logger> list = new ArrayList();
        Logger logger = PrintLogger.getInstance();
        if (logger != null) {
            list.add(logger);
        }
        try {
            Class klass = Class.forName("com.sun.javafx.logging.JFRLogger");
            if (klass != null) {
                Method method = klass.getDeclaredMethod("getInstance");
                logger = (Logger) method.invoke(null);
                if (logger != null) {
                    list.add(logger);
                }
            }
        }
        catch (NoClassDefFoundError | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // Ignore
        }

        loggers = list.toArray(new Logger[list.size()]);
        PULSE_LOGGING_ENABLED = loggers.length > 0;
    }

    public static void pulseStart() {
        for (Logger logger: loggers) {
            logger.pulseStart();
        }
    }

    public static void pulseEnd() {
        for (Logger logger: loggers) {
            logger.pulseEnd();
        }
    }

    public static void renderStart() {
        for (Logger logger: loggers) {
            logger.renderStart();
        }
    }

    public static void renderEnd() {
        for (Logger logger: loggers) {
            logger.renderEnd();
        }
    }

    public static void addMessage(String message) {
        for (Logger logger: loggers) {
            logger.addMessage(message);
        }
    }

    public static void incrementCounter(String counter) {
        for (Logger logger: loggers) {
            logger.incrementCounter(counter);
        }
    }

    public static void newPhase(String name) {
        for (Logger logger: loggers) {
            logger.newPhase(name);
        }
    }

    public static void newInput(String name) {
        for (Logger logger: loggers) {
            logger.newInput(name);
        }
    }
}
