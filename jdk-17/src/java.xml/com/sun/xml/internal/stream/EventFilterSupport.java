/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream;

import java.util.NoSuchElementException;
import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.EventReaderDelegate;

/**
 *
 * @author  Neeraj Bajaj, Sun Microsystems
 *
 */
public class EventFilterSupport extends EventReaderDelegate {

    //maintain a reference to EventFilter
    EventFilter fEventFilter ;
    /** Creates a new instance of EventFilterSupport */
    public EventFilterSupport(XMLEventReader eventReader, EventFilter eventFilter) {
        setParent(eventReader);
        fEventFilter = eventFilter;
    }

    public Object next(){
        try{
            return nextEvent();
        }catch(XMLStreamException ex){
            throw new NoSuchElementException();
        }
    }

    public boolean hasNext(){
        try{
            return peek() != null ? true : false ;
        }catch(XMLStreamException ex){
            return false;
        }
    }

    public XMLEvent nextEvent()throws XMLStreamException{
        while (super.hasNext()) {
            //get the next event by calling XMLEventReader
            XMLEvent event = super.nextEvent();

            //if this filter accepts this event then return this event
            if(fEventFilter.accept(event)){
                return event;
            }
        }
        throw new NoSuchElementException();
    }//nextEvent()

     public XMLEvent nextTag() throws XMLStreamException{
         while (super.hasNext()) {
             XMLEvent event = super.nextTag();
             //if the filter accepts this event return this event.
             if(fEventFilter.accept(event)){
                return event;
             }
         }
         throw new NoSuchElementException();
     }

     public XMLEvent peek() throws XMLStreamException{
         while (true) {
             XMLEvent event = super.peek();
             if(event == null)return null;
             //if the filter accepts this event return this event.
             if(fEventFilter.accept(event)){
                return event;
             }
             //call super.next(), and then peek again.
             super.next();
         }
     }

}//EventFilterSupport
