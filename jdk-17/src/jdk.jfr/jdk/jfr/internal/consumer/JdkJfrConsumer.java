/*
 * Copyright (c) 2019, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import jdk.jfr.Configuration;
import jdk.jfr.EventType;
import jdk.jfr.consumer.MetadataEvent;
import jdk.jfr.consumer.RecordedClass;
import jdk.jfr.consumer.RecordedClassLoader;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordedFrame;
import jdk.jfr.consumer.RecordedMethod;
import jdk.jfr.consumer.RecordedObject;
import jdk.jfr.consumer.RecordedStackTrace;
import jdk.jfr.consumer.RecordedThread;
import jdk.jfr.consumer.RecordedThreadGroup;
import jdk.jfr.consumer.RecordingFile;
import jdk.jfr.internal.Type;

/*
 * Purpose of this class is to give package private access to
 * the jdk.jfr.consumer package
 */
public abstract class JdkJfrConsumer {

    private static JdkJfrConsumer instance;

    // Initialization will trigger setAccess being called
    private static void forceInitialization() {
        try {
            Class<?> c = RecordedObject.class;
            Class.forName(c.getName(), true, c.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new InternalError("Should not happen");
        }
    }

    public static void setAccess(JdkJfrConsumer access) {
        instance = access;
    }

    public static JdkJfrConsumer instance() {
        if (instance == null) {
            forceInitialization();
        }
        return instance;
    }

    public abstract List<Type> readTypes(RecordingFile file) throws IOException;

    public abstract boolean isLastEventInChunk(RecordingFile file);

    public abstract Object getOffsetDataTime(RecordedObject event, String name);

    public abstract RecordedClass newRecordedClass(ObjectContext objectContext, long id, Object[] values);

    public abstract RecordedClassLoader newRecordedClassLoader(ObjectContext objectContext, long id, Object[] values);

    public abstract RecordedStackTrace newRecordedStackTrace(ObjectContext objectContext, Object[] values);

    public abstract RecordedThreadGroup newRecordedThreadGroup(ObjectContext objectContext, Object[] values);

    public abstract RecordedFrame newRecordedFrame(ObjectContext objectContext, Object[] values);

    public abstract RecordedThread newRecordedThread(ObjectContext objectContext, long id, Object[] values);

    public abstract RecordedMethod newRecordedMethod(ObjectContext objectContext, Object[] values);

    public abstract RecordedEvent newRecordedEvent(ObjectContext objectContext, Object[] objects, long l, long m);

    public abstract Comparator<? super RecordedEvent> eventComparator();

    public abstract void setStartTicks(RecordedEvent event, long startTicks);

    public abstract void setEndTicks(RecordedEvent event, long endTicks);

    public abstract Object[] eventValues(RecordedEvent event);

    public abstract MetadataEvent newMetadataEvent(List<EventType> previous, List<EventType> current, List<Configuration> configuration);

}
