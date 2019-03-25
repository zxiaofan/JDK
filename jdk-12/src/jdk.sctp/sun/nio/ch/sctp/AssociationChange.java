/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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
package sun.nio.ch.sctp;

import com.sun.nio.sctp.Association;
import com.sun.nio.sctp.AssociationChangeNotification;
import java.lang.annotation.Native;

/**
 * An implementation of AssociationChangeNotification
 */
public class AssociationChange extends AssociationChangeNotification
    implements SctpNotification
{
    /* static final ints so that they can be referenced from native */
    @Native private final static int SCTP_COMM_UP = 1;
    @Native private final static int SCTP_COMM_LOST = 2;
    @Native private final static int SCTP_RESTART = 3;
    @Native private final static int SCTP_SHUTDOWN = 4;
    @Native private final static int SCTP_CANT_START = 5;

    private Association association;

    /* assocId is used to lookup the association before the notification is
     * returned to user code */
    private int assocId;
    private AssocChangeEvent event;
    private int maxOutStreams;
    private int maxInStreams;

    /* Invoked from native */
    private AssociationChange(int assocId,
                              int intEvent,
                              int maxOutStreams,
                              int maxInStreams) {
        switch (intEvent) {
            case SCTP_COMM_UP :
                this.event = AssocChangeEvent.COMM_UP;
                break;
            case SCTP_COMM_LOST :
                this.event = AssocChangeEvent.COMM_LOST;
                break;
            case SCTP_RESTART :
                this.event = AssocChangeEvent.RESTART;
                break;
            case SCTP_SHUTDOWN :
                this.event = AssocChangeEvent.SHUTDOWN;
                break;
            case SCTP_CANT_START :
                this.event = AssocChangeEvent.CANT_START;
                break;
            default :
                throw new AssertionError(
                      "Unknown Association Change Event type: " + intEvent);
        }

        this.assocId = assocId;
        this.maxOutStreams = maxOutStreams;
        this.maxInStreams = maxInStreams;
    }

    @Override
    public int assocId() {
        return assocId;
    }

    @Override
    public void setAssociation(Association association) {
        this.association = association;
    }

    @Override
    public Association association() {
        assert association != null;
        return association;
    }

    @Override
    public AssocChangeEvent event() {
        return event;
    }

    int maxOutStreams() {
        return maxOutStreams;
    }

    int maxInStreams() {
        return maxInStreams;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" [");
        sb.append("Association:").append(association);
        sb.append(", Event: ").append(event).append("]");
        return sb.toString();
    }
}
