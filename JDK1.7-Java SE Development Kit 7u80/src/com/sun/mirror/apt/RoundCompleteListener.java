/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.mirror.apt;

/**
 * Listener for the completion of a round of annotation processing.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  This interface has no
 * direct analog in the standardized API because the different round
 * model renders it unnecessary.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface RoundCompleteListener extends AnnotationProcessorListener {
    /**
     * Invoked after all processors for a round have run to completion.
     *
     * @param event An event for round completion
     */
    void roundComplete(RoundCompleteEvent event);
}
