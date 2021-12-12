/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.datatransfer;

import java.io.Serial;
import java.util.EventObject;

/**
 * {@code FlavorEvent} is used to notify interested parties that available
 * {@link DataFlavor}s have changed in the {@link Clipboard} (the event source).
 *
 * @author Alexander Gerasimov
 * @see FlavorListener
 * @since 1.5
 */
public class FlavorEvent extends EventObject {

    /**
     * Use serialVersionUID from JDK 1.5 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -5842664112252414548L;

    /**
     * Constructs a {@code FlavorEvent} object.
     *
     * @param  source the {@code Clipboard} that is the source of the event
     * @throws IllegalArgumentException if the {@code source} is {@code null}
     */
    public FlavorEvent(Clipboard source) {
        super(source);
    }
}
