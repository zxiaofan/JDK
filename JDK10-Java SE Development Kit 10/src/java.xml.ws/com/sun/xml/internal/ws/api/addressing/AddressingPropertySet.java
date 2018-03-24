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

package com.sun.xml.internal.ws.api.addressing;

import com.sun.xml.internal.ws.api.message.Packet;
import com.oracle.webservices.internal.api.message.BasePropertySet;
import javax.xml.ws.handler.MessageContext;
import java.util.List;
import java.util.Map;

/**
 * <p>This property set exists so the upper stack can SET addressing info
 * on a PER-REQUEST basis (instead of a per proxy/dispatch basis via OneWayFeature).</p>
 *
 * <p>This class is NOT used for reading addressing header values.</p>
 */
public class AddressingPropertySet extends BasePropertySet {

    // NOTE: Setting ACTION on client side is covered by standard BindingProvider.

    public static final String ADDRESSING_FAULT_TO = "com.sun.xml.internal.ws.api.addressing.fault.to";
    private String faultTo;
    @Property(ADDRESSING_FAULT_TO)
    public String getFaultTo()                 { return faultTo; }
    public void   setFaultTo(final String x)   { faultTo = x;    }

    public static final String ADDRESSING_MESSAGE_ID = "com.sun.xml.internal.ws.api.addressing.message.id";
    private String messageId;
    public String getMessageId()               { return messageId; }
    public void   setMessageId(final String x) { messageId = x;    }

    public static final String ADDRESSING_RELATES_TO = "com.sun.xml.internal.ws.api.addressing.relates.to";
    @Property(ADDRESSING_RELATES_TO)
    private String relatesTo;
    public String getRelatesTo()               { return relatesTo; }
    public void   setRelatesTo(final String x) { relatesTo = x;    }

    public static final String ADDRESSING_REPLY_TO = "com.sun.xml.internal.ws.api.addressing.reply.to";
    @Property(ADDRESSING_REPLY_TO)
    private String replyTo;
    public String getReplyTo()                 { return replyTo; }
    public void   setReplyTo(final String x)   { replyTo = x;    }

    ////////////////////////////////////////////////////
    //
    // PropertySet boilerplate
    //

    private static final PropertyMap model;

    static {
        model = parse(AddressingPropertySet.class);
    }

    @Override
    protected PropertyMap getPropertyMap() {
        return model;
    }
}
