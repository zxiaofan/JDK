/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.apt;

/**
 * Event for the completion of a round of annotation processing.
 *
 * <p>While this class extends the serializable <tt>EventObject</tt>, it
 * cannot meaningfully be serialized because all of the annotation
 * processing tool's internal state would potentially be needed.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */
public abstract class RoundCompleteEvent extends java.util.EventObject {
    private RoundState rs;

    /**
     * The current <tt>AnnotationProcessorEnvironment</tt> is regarded
     * as the source of events.
     *
     * @param source The source of events
     * @param rs     The state of the round
     */
    protected RoundCompleteEvent(AnnotationProcessorEnvironment source,
				 RoundState rs) {
	super(source);
	this.rs = rs;
    }
    
    /**
     * Return round state.
     */
    public RoundState getRoundState() {
	return rs;
    }
    
    /**
     * Return source.
     */
    public AnnotationProcessorEnvironment getSource() {
	return (AnnotationProcessorEnvironment)super.getSource();
    }
}
