/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt.event;

import java.util.EventListener;

/**
 * The listener interface for receiving text events. 
 * 
 * The class that is interested in processing a text event
 * implements this interface. The object created with that 
 * class is then registered with a component using the 
 * component's <code>addTextListener</code> method. When the
 * component's text changes, the listener object's 
 * <code>textValueChanged</code> method is invoked.
 *
 * @author Georges Saab
 * @version %I% %G%
 *
 * @see TextEvent
 * @see <a href="http://java.sun.com/docs/books/tutorial/post1.0/ui/textlistener.html">Tutorial: Writing a Text Listener</a>
 *
 * @since 1.1
 */
public interface TextListener extends EventListener {

    /**
     * Invoked when the value of the text has changed.
     * The code written for this method performs the operations
     * that need to occur when text changes.
     */   
    public void textValueChanged(TextEvent e);

}
