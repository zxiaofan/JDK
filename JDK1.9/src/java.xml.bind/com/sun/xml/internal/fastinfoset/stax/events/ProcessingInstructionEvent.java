/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset.stax.events ;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.ProcessingInstruction;


public class ProcessingInstructionEvent extends EventBase implements ProcessingInstruction {

    private String targetName;
    private String _data;

    public ProcessingInstructionEvent() {
        init();
    }

    public ProcessingInstructionEvent(String targetName, String data) {
        this.targetName = targetName;
        _data = data;
        init();
    }

    protected void init() {
        setEventType(XMLStreamConstants.PROCESSING_INSTRUCTION);
    }

    public String getTarget() {
        return targetName;
    }

    public void setTarget(String targetName) {
        this.targetName = targetName;
    }

    public void setData(String data) {
        _data = data;
    }

    public String getData() {
        return _data;
    }

    public String toString() {
        if(_data != null && targetName != null)
            return "<?" + targetName + " " + _data + "?>";
        if(targetName != null)
            return "<?" + targetName + "?>";
        if(_data != null)
            return "<?" + _data + "?>";
        else
            return "<??>";
    }

}
