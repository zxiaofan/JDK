/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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

/**
 * An implementation of Association
 */
public class AssociationImpl extends Association {
    public AssociationImpl(int associationID,
                           int maxInStreams,
                           int maxOutStreams) {
        super(associationID, maxInStreams, maxOutStreams);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        return sb.append("[associationID:")
                 .append(associationID())
                 .append(", maxIn:")
                 .append(maxInboundStreams())
                 .append(", maxOut:")
                 .append(maxOutboundStreams())
                 .append("]")
                 .toString();
    }
}

