/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.consumer;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.jfr.EventType;
import jdk.jfr.ValueDescriptor;

public final class ObjectContext {
    private final Map<ValueDescriptor, ObjectContext> contextLookup;
    private final TimeConverter timeConverter;

    public final EventType eventType;
    public final List<ValueDescriptor> fields;

    ObjectContext(EventType eventType, List<ValueDescriptor> fields, TimeConverter timeConverter) {
        this.contextLookup = new HashMap<>();
        this.eventType = eventType;
        this.fields = fields;
        this.timeConverter = timeConverter;
    }

    private ObjectContext(ObjectContext parent, ValueDescriptor descriptor) {
        this.eventType = parent.eventType;
        this.contextLookup = parent.contextLookup;
        this.timeConverter = parent.timeConverter;
        this.fields = descriptor.getFields();
    }

    public ObjectContext getInstance(ValueDescriptor descriptor) {
        ObjectContext context = contextLookup.get(descriptor);
        if (context == null) {
            context = new ObjectContext(this, descriptor);
            contextLookup.put(descriptor, context);
        }
        return context;
    }

    public long convertTimestamp(long ticks) {
        return timeConverter.convertTimestamp(ticks);
    }

    public long convertTimespan(long ticks) {
        return timeConverter.convertTimespan(ticks);
    }

    public ZoneId getZoneOffset() {
        return timeConverter.getZoneOffset();
    }
}
