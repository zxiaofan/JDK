/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.apt;

/**
 * Listener for the completion of a round of annotation processing.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */
public interface RoundCompleteListener extends AnnotationProcessorListener {
    /**
     * Invoked after all processors for a round have run to completion.
     *
     * @param event An event for round completion
     */
    void roundComplete(RoundCompleteEvent event);
}
