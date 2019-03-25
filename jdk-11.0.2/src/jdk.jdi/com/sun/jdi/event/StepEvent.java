/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi.event;

import com.sun.jdi.request.StepRequest;

/**
 * Notification of step completion in the target VM.
 * The step event is generated immediately before the code at its location
 * is executed. Thus, if the step is entering a new method (as might occur
 * with {@link StepRequest#STEP_INTO StepRequest.STEP_INTO})
 * the location of the event is the first instruction of the method.
 * When a step leaves a method, the location of the event will be the
 * first instruction after the call in the calling method; note that
 * this location may not be at a line boundary, even if
 * {@link StepRequest#STEP_LINE StepRequest.STEP_LINE} was used.
 *
 * @see StepRequest
 * @see EventQueue
 *
 * @author Robert Field
 * @since  1.3
 */
public interface StepEvent extends LocatableEvent {
}
