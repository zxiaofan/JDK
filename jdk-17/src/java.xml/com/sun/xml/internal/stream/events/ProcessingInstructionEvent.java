/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.events ;

import java.io.Writer;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.ProcessingInstruction;

/** Implements Processing Instruction Event
 *
 *@author Neeraj Bajaj, Sun Microsystems.
 *
 */


public class ProcessingInstructionEvent extends DummyEvent
implements ProcessingInstruction {

    /** Processing Instruction Name */
    private String fName;
    /** Processsing instruction content */
    private String fContent;

    public ProcessingInstructionEvent() {
        init();
    }

    public ProcessingInstructionEvent(String targetName, String data) {
        this(targetName,data,null);
    }

    public ProcessingInstructionEvent(String targetName, String data,Location loc) {
        init();
        this.fName = targetName;
        fContent = data;
        setLocation(loc);
    }

    protected void init() {
        setEventType(XMLStreamConstants.PROCESSING_INSTRUCTION);
    }

    public String getTarget() {
        return fName;
    }

    public void setTarget(String targetName) {
        fName = targetName;
    }

    public void setData(String data) {
        fContent = data;
    }

    public String getData() {
        return fContent;
    }

    public String toString() {
        if(fContent != null && fName != null)
            return "<?" + fName + " " + fContent + "?>";
        if(fName != null)
            return "<?" + fName + "?>";
        if(fContent != null)
            return "<?" + fContent + "?>";
        else
            return "<??>";
    }

    protected void writeAsEncodedUnicodeEx(java.io.Writer writer)
    throws java.io.IOException
    {
        writer.write(toString());
    }

}
