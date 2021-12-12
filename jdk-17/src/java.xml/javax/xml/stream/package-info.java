/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

/**
 * <p>
 * Defines interfaces and classes for the Streaming API for XML (StAX).
 *
 * <p>
 * StAX provides two basic functions: the cursor API allowing users to
 * read and write XML efficiently, and the event iterator API promoting
 * ease of use that is event based, easy to extend and pipeline.
 * The event iterator API is intended to layer on top of the cursor API.
 *
 * <p>
 * The cursor API defines two interfaces: {@link XMLStreamReader}
 * and {@link XMLStreamWriter}, while the event iterator API defines:
 * {@link XMLEventReader} and {@link XMLEventWriter}.
 *
 * <p>
 * StAX supports plugability with {@link XMLInputFactory} and
 * {@link XMLOutputFactory} that define how an implementation is
 * located through a process as described in the {@code newFactory}
 * methods.
 *
 *
 * @since 1.6
 */

package javax.xml.stream;
