/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.event;

/**
 * Event details relating to deserialization.
 */

public final class DeserializationEvent extends Event {
    public boolean filterConfigured;
    public String filterStatus;
    public Class<?> type;
    public int arrayLength;
    public long objectReferences;
    public long depth;
    public long bytesRead;
    public Class<?> exceptionType;
    public String exceptionMessage;
}
