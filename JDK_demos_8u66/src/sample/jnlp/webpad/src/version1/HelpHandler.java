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


import javax.help.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.jnlp.DownloadService;
import javax.jnlp.DownloadServiceListener;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;

public class HelpHandler {

   static private DownloadService _ds = null;

    static public final String helpsetName = "HolidayHistory.hs";

    static public HelpBroker _hb = null;

    static public void  showHelp(final ActionEvent evt) {
        new Thread() {
            public void run() {
                showHelpHelper(evt);
            }
        }.start();
    }

    static public void showHelpHelper(ActionEvent evt) {
        checkForDownload();
        initializeHelpSystem();
        new CSH.DisplayHelpFromSource(_hb).actionPerformed(evt);
    }

    static public synchronized void initializeHelpSystem() {
        if (_hb != null) return;
        try {
            JOptionPane pane = new JOptionPane("Initializing help system. Please Wait...",
                                               JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = pane.createDialog(null, "WebPad Help System");
            dialog.setModal(false);
            dialog.setVisible(true);

            HelpSet hs = null;
            ClassLoader cl = HelpHandler.class.getClassLoader();
            URL hsURL = HelpSet.findHelpSet(cl, helpsetName);
            hs = new HelpSet(cl, hsURL);
            _hb = hs.createHelpBroker();
            _hb.initPresentation();
            dialog.setVisible(false);
        } catch (Exception ee) {
            System.out.println("HelpSet " + helpsetName + " not found");
            return;
        }
    }

    static private void checkForDownload() {
        try {
             _ds = (DownloadService)ServiceManager.lookup("javax.jnlp.DownloadService");
        } catch (UnavailableServiceException e) {
          _ds = null;

        }

        if (_ds != null) {
        try {

           if (_ds.isPartCached("help")) {
                System.out.println("Help System is cached");
                return;
            }
            _ds.loadPart("help", _ds.getDefaultProgressWindow());
          } catch(Exception e) {
            e.printStackTrace();
          }
        }
  }
}
