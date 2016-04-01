package sample.jnlp.webpad.src.version1;
/*
 * Copyright (c) 2006, 2010, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * Neither the name of Oracle nor the names of contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MICROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import javax.swing.event.EventListenerList;

/**
 * Abstract Action for the JLF. Defines some useful methods.
 *
 */
public abstract class JLFAbstractAction extends AbstractAction {

    // The listener to action events (usually the main UI)
    private EventListenerList listeners;

    // Image directory URL
    public static final String JLF_IMAGE_DIR = "/toolbarButtonGraphics/general/";

    /**
     * The key used for storing a large icon for the action,
     * used for toolbar buttons.
     * <p>
     * Note: Eventually this key belongs in the javax.swing.Action interface.
     */
    public static final String LARGE_ICON = "LargeIcon";

    //
    // These next public methods may belong in the AbstractAction class.
    //

    /**
     * Gets the value from the key Action.ACTION_COMMAND_KEY
     */
    public String getActionCommand()  {
        return (String)getValue(Action.ACTION_COMMAND_KEY);
    }

    /**
     * Gets the value from the key Action.SHORT_DESCRIPTION
     */
    public String getShortDescription()  {
        return (String)getValue(Action.SHORT_DESCRIPTION);
    }

    /**
     * Gets the value from the key Action.LONG_DESCRIPTION
     */
    public String getLongDescription()  {
        return (String)getValue(Action.LONG_DESCRIPTION);
    }

    /* Should finish the implementation and add get/set methods for all the
     * javax.swing.Action keys:

     Action.NAME
     Action.SMALL_ICON
     ActionConstants.LARGE_ICON
     Action.MNEMONIC_KEY
     */


    // ActionListener registration and invocation.

    /**
     * Forwards the ActionEvent to the registered listener.
     */
    public void actionPerformed(ActionEvent evt)  {
        if (listeners != null) {
            Object[] listenerList = listeners.getListenerList();

            // Recreate the ActionEvent and stuff the value of the ACTION_COMMAND_KEY
            ActionEvent e = new ActionEvent(evt.getSource(), evt.getID(),
                                                (String)getValue(Action.ACTION_COMMAND_KEY));
            for (int i = 0; i <= listenerList.length-2; i += 2) {
                ((ActionListener)listenerList[i+1]).actionPerformed(e);
            }
        }
    }

    public void addActionListener(ActionListener l)  {
        if (listeners == null) {
            listeners = new EventListenerList();
        }
        listeners.add(ActionListener.class, l);
    }

    public void removeActionListener(ActionListener l)  {
        if (listeners == null) {
            return;
        }
        listeners.remove(ActionListener.class, l);
    }

    /**
     * Returns the Icon associated with the name from the resources.
     * The resouce should be in the path.
     * @param name Name of the icon file i.e., help16.gif
     * @return the name of the image or null if the icon is not found.
     */
    public ImageIcon getIcon(String name)  {
        if (name != null) {
            String imagePath = JLF_IMAGE_DIR + name;
            URL url = this.getClass().getResource(imagePath);
            if (url != null)  return new ImageIcon(url);
        }
        return null;
    }
}
