/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.dump;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marek Potociar <marek.potociar at sun.com>
 */
final class MessageDumper {

    static enum MessageType {
        Request("Request message"),
        Response("Response message"),
        Exception("Response exception");

        private final String name;

        private MessageType(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static enum ProcessingState {
        Received("received"),
        Processed("processed");

        private final String name;

        private ProcessingState(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    private final String tubeName;
    private final Logger logger;
    private Level loggingLevel;


    public MessageDumper(String tubeName, Logger logger, Level loggingLevel) {
        this.tubeName = tubeName;
        this.logger = logger;
        this.loggingLevel = loggingLevel;
    }

    final boolean isLoggable() {
        return logger.isLoggable(loggingLevel);
    }

    final void setLoggingLevel(Level level) {
        this.loggingLevel = level;
    }

    final String createLogMessage(MessageType messageType, ProcessingState processingState, int tubeId, String engineId, String message) {
        return String.format("%s %s in Tube [ %s ] Instance [ %d ] Engine [ %s ] Thread [ %s ]:%n%s",
                messageType,
                processingState,
                tubeName,
                tubeId,
                engineId,
                Thread.currentThread().getName(),
                message);
    }

    final String dump(MessageType messageType, ProcessingState processingState, String message, int tubeId, String engineId) {
        String logMessage = createLogMessage(messageType, processingState, tubeId, engineId, message);
        logger.log(loggingLevel, logMessage);

        return logMessage;
    }
}
