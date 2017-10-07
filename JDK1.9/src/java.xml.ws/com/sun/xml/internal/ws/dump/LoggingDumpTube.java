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

import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.pipe.Fiber;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.sun.xml.internal.ws.api.pipe.Tube;
import com.sun.xml.internal.ws.api.pipe.TubeCloner;
import com.sun.xml.internal.ws.api.pipe.helper.AbstractFilterTubeImpl;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import com.sun.xml.internal.ws.dump.MessageDumper.ProcessingState;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marek Potociar <marek.potociar at sun.com>
 */
public class LoggingDumpTube extends AbstractFilterTubeImpl {
    public static enum Position {
        Before(MessageDumper.ProcessingState.Received, MessageDumper.ProcessingState.Processed),
        After(MessageDumper.ProcessingState.Processed, MessageDumper.ProcessingState.Received);

        private final MessageDumper.ProcessingState requestState;
        private final MessageDumper.ProcessingState responseState;

        private Position(ProcessingState requestState, ProcessingState responseState) {
            this.requestState = requestState;
            this.responseState = responseState;
        }
    }

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    //
    private MessageDumper messageDumper;
    private final Level loggingLevel;
    private final Position position;
    private final int tubeId;

    public LoggingDumpTube(Level loggingLevel, Position position, Tube tubelineHead) {
        super(tubelineHead);

        this.position = position;
        this.loggingLevel = loggingLevel;

        this.tubeId = ID_GENERATOR.incrementAndGet();
    }

    public void setLoggedTubeName(String loggedTubeName) {
        assert messageDumper == null; // must not set a new message dumper once already set
        this.messageDumper = new MessageDumper(loggedTubeName, Logger.getLogger(loggedTubeName), loggingLevel);
    }

    /**
     * Copy constructor.
     */
    private LoggingDumpTube(LoggingDumpTube original, TubeCloner cloner) {
        super(original, cloner);

        this.messageDumper = original.messageDumper;
        this.loggingLevel = original.loggingLevel;
        this.position = original.position;

        this.tubeId = ID_GENERATOR.incrementAndGet();
    }

    public LoggingDumpTube copy(TubeCloner cloner) {
        return new LoggingDumpTube(this, cloner);
    }


    @Override
    public NextAction processRequest(Packet request) {
        if (messageDumper.isLoggable()) {
            Packet dumpPacket = (request != null) ? request.copy(true) : null;
            messageDumper.dump(MessageDumper.MessageType.Request, position.requestState, Converter.toString(dumpPacket), tubeId, Fiber.current().owner.id);
        }

        return super.processRequest(request);
    }

    @Override
    public NextAction processResponse(Packet response) {
        if (messageDumper.isLoggable()) {
            Packet dumpPacket = (response != null) ? response.copy(true) : null;
            messageDumper.dump(MessageDumper.MessageType.Response, position.responseState, Converter.toString(dumpPacket), tubeId, Fiber.current().owner.id);
        }

        return super.processResponse(response);
    }

    @Override
    public NextAction processException(Throwable t) {
        if (messageDumper.isLoggable()) {
            messageDumper.dump(MessageDumper.MessageType.Exception, position.responseState, Converter.toString(t), tubeId, Fiber.current().owner.id);
        }

        return super.processException(t);
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }
}
