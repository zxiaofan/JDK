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

package com.sun.xml.internal.ws.message.source;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.SOAPVersion;
import com.sun.xml.internal.ws.api.message.AttachmentSet;
import com.sun.xml.internal.ws.api.message.HeaderList;
import com.sun.xml.internal.ws.api.message.Message;
import com.sun.xml.internal.ws.api.message.MessageHeaders;
import com.sun.xml.internal.ws.message.AttachmentSetImpl;
import com.sun.xml.internal.ws.message.stream.PayloadStreamReaderMessage;
import com.sun.xml.internal.ws.streaming.SourceReaderFactory;

import javax.xml.transform.Source;

/**
 * {@link Message} backed by {@link Source} as payload
 *
 * @author Vivek Pandey
 */
public class PayloadSourceMessage extends PayloadStreamReaderMessage {

    public PayloadSourceMessage(@Nullable MessageHeaders headers,
        @NotNull Source payload, @NotNull AttachmentSet attSet,
        @NotNull SOAPVersion soapVersion) {

        super(headers, SourceReaderFactory.createSourceReader(payload, true),
                attSet, soapVersion);
    }

    public PayloadSourceMessage(Source s, SOAPVersion soapVer) {
        this(null, s, new AttachmentSetImpl(), soapVer);
    }

}
