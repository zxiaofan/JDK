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

import java.awt.*;
import java.awt.event.*;

import java.util.Enumeration;
import java.util.Vector;

import javax.swing.*;

import javax.jnlp.BasicService;
import javax.jnlp.ServiceManager;
import javax.jnlp.PersistenceService;
import javax.jnlp.UnavailableServiceException;
import javax.jnlp.FileContents;
import java.io.*;
import java.net.*;


/**
 * Demonstrates the JLF Actions classes.
 *
 * - The actions use the JLF icons, text and mnemonics.
 * - Actions are shared between the JToolBar and JMenuBar.
 * - if an Action is enabled/disabled then it will be disabled in both places.
 * - When a mouse is over a toolbar button or a menu item, then the long
 *   description of that action will be displayed in the status bar.
 * - Abstracts the actionPerformed method from the Action class to a handler.
 *
 *
 */

public class WebPad extends JFrame implements ActionListener {

    // These are the actions defined for the application
    private AboutAction aboutAction;
    private CutAction cutAction;
    private CopyAction copyAction;
    private PasteAction pasteAction;
    private OpenAction openAction;
    private SaveAction saveAction;
    private SaveAsAction saveAsAction;
    private PrintAction printAction;
    private HelpAction helpAction;
    private ExitAction exitAction;
    private PublishAction publishAction;
    private ShowAction showAction;

    private ClassLoader cl;
    // Vector for holding all the actions.
    private Vector actions;

    // Status bar
    private JLabel status;

    // Text area which acts as a clipboard.
    private JTextArea textArea;

    // This adapter handles Mouse over messages on toolbar buttons and
    // menu items.
    private MouseHandler mouseHandler;

    // Popup Menu with the actions.
    private JPopupMenu popup;

    private PersistenceService ps;
    private BasicService bs;
    private FileContents fc;

    public WebPad() {
        super("WebPad");

        cl = this.getClass().getClassLoader();
        initActions();

        status = createStatusBar();
        mouseHandler = new MouseHandler(status);

        setJMenuBar(createMenu());
        getContentPane().add(createToolBar(), BorderLayout.NORTH);
        getContentPane().add(createPanel(), BorderLayout.CENTER);
        getContentPane().add(status, BorderLayout.SOUTH);

        popup = createPopupMenu();

        initPersistence();

        addWindowListener(new WindowAdapter()  {
                    public void windowClosing(WindowEvent evt)  {
                        System.exit(0);
                    }
                });

    }

    // This method should be called before creating the UI
    // to create all the Actions
    private void initActions()  {
        actions = new Vector();

        aboutAction = new AboutAction();
        registerAction(aboutAction);

        cutAction = new CutAction();
        registerAction(cutAction);

        copyAction = new CopyAction();
        registerAction(copyAction);

        pasteAction = new PasteAction();
        registerAction(pasteAction);


        openAction = new OpenAction();
        registerAction(openAction);

        saveAction = new SaveAction();
        registerAction(saveAction);

        saveAsAction = new SaveAsAction();
        registerAction(saveAsAction);

        printAction = new PrintAction();
        registerAction(printAction);

        exitAction = new ExitAction();
        registerAction(exitAction);

        helpAction = new HelpAction();
        registerAction(helpAction);

        publishAction = new PublishAction();
        registerAction(publishAction);

        showAction = new ShowAction();
        registerAction(showAction);
    }

    private void registerAction(JLFAbstractAction action)  {
        action.addActionListener(this);
        actions.addElement(action);
    }

    // Creates the application menu bar.
    private JMenuBar createMenu()  {
        JMenuBar menuBar = new JMenuBar();

        JMenuItem menuItem;

        // Build the File menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        if (FileHandler.isEnabled()) {
            menuItem = fileMenu.add(openAction);
            menuItem.addMouseListener(mouseHandler);
            menuItem = fileMenu.add(saveAction);
            menuItem.addMouseListener(mouseHandler);
            menuItem = fileMenu.add(saveAsAction);
            menuItem.addMouseListener(mouseHandler);
            menuItem = fileMenu.add(printAction);
            menuItem.addMouseListener(mouseHandler);
            fileMenu.add(new JSeparator());
        }
        menuItem = fileMenu.add(exitAction);
        menuItem.addMouseListener(mouseHandler);

        // Build the edit menu
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        menuItem = editMenu.add(cutAction);
        menuItem.addMouseListener(mouseHandler);
        menuItem = editMenu.add(copyAction);
        menuItem.addMouseListener(mouseHandler);
        menuItem = editMenu.add(pasteAction);
        menuItem.addMouseListener(mouseHandler);

        // Build the help menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        menuItem = helpMenu.add(helpAction);
        menuItem.addMouseListener(mouseHandler);
        menuItem = helpMenu.add(aboutAction);
        menuItem.addMouseListener(mouseHandler);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        if (WebHandler.isEnabled()) {
            JMenu webMenu = new JMenu("Web");
            webMenu.setMnemonic('W');
            menuItem = webMenu.add(publishAction);
            menuItem.addMouseListener(mouseHandler);
            menuItem = webMenu.add(showAction);
            menuItem.addMouseListener(mouseHandler);
            menuBar.add(webMenu);
        }
        menuBar.add(helpMenu);

        return menuBar;
    }

    private JToolBar createToolBar()  {
        JToolBar toolbar = new JToolBar();

        JButton button;

        button = toolbar.add(cutAction);
        button.addMouseListener(mouseHandler);
        button = toolbar.add(copyAction);
        button.addMouseListener(mouseHandler);
        button = toolbar.add(pasteAction);
        button.addMouseListener(mouseHandler);
        toolbar.addSeparator();
        button = toolbar.add(aboutAction);
        button.addMouseListener(mouseHandler);

        return toolbar;
    }

    private JPopupMenu createPopupMenu()  {
        JPopupMenu menu = new JPopupMenu();

        JMenuItem menuItem;

        menuItem = menu.add(cutAction);
        menuItem.addMouseListener(mouseHandler);
        menuItem = menu.add(copyAction);
        menuItem.addMouseListener(mouseHandler);
        menuItem = menu.add(pasteAction);
        menuItem.addMouseListener(mouseHandler);
        menu.addSeparator();
        menuItem = menu.add(aboutAction);
        menuItem.addMouseListener(mouseHandler);

        return menu;
    }

    // Panel which allows for the enabling and disabling of all the actions.
    private JPanel createPanel()  {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        if(e.isPopupTrigger()) {
                            popup.show(textArea, e.getX(), e.getY());
                        }
                    }
                    public void mouseReleased(MouseEvent e) {
                        if(e.isPopupTrigger()) {
                            popup.show(textArea, e.getX(), e.getY());
                        }
                    }
                });

        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(450, 200));
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Creates the status bar.
    private JLabel createStatusBar()  {
        status = new JLabel("Ready...");
        status.setBorder(BorderFactory.createEtchedBorder());

        return status;
    }

    /*
     * This method acts as the Action handler delegate for all the actions.
     * The Cut, Copy and Paste Actions operate on the JTextArea.
     */
    public void actionPerformed(ActionEvent evt)  {
        String command = evt.getActionCommand();

        // Compare the action command to the known actions.
        if (command.equals(aboutAction.getActionCommand()))  {
            // The about action was invoked
            JOptionPane.showMessageDialog(this, aboutAction.getLongDescription(), aboutAction.getShortDescription(), JOptionPane.INFORMATION_MESSAGE);
        } else if (command.equals(cutAction.getActionCommand())) {
            ClipboardHandler.toClipboard(textArea.getSelectedText());
            textArea.replaceSelection("");
        } else if (command.equals(copyAction.getActionCommand())) {
            ClipboardHandler.toClipboard(textArea.getSelectedText());
        } else if (command.equals(pasteAction.getActionCommand())) {
            String txt = ClipboardHandler.fromClipboard();
            textArea.replaceSelection(txt);
        } else if (command.equals(helpAction.getActionCommand())) {
            HelpHandler.showHelp(evt);
        } else if (command.equals(exitAction.getActionCommand())) {
            saveScratch(textArea.getText());
            System.exit(0);
        } else if (command.equals(openAction.getActionCommand())) {
            String t = FileHandler.open();
            if (t != null) textArea.setText(t);
        } else if (command.equals(saveAction.getActionCommand())) {
            FileHandler.save(textArea.getText());
        } else if (command.equals(saveAsAction.getActionCommand())) {
            FileHandler.saveAs(textArea.getText());
        } else if (command.equals(printAction.getActionCommand())) {
            FileHandler.print(textArea);
        } else if (command.equals(publishAction.getActionCommand())) {
            WebHandler.publish(textArea.getText());
        } else if (command.equals(showAction.getActionCommand())) {
            WebHandler.show();
        }
    }


/*
 * This method will check to see if there is anything stored in
 * PersistenceStorage. If so, it will read it. If not, we will
 * just create a new Persistence Storage. This is implemented
 * mainly for the Webpad app to remember/recall what was
 * displayed in the TextArea before the App was exited
*/

 private void initPersistence()
 {

     long maxSize = 8192;
     long fileSize = 0;
     boolean persExists = true;
     URL url = null;
     BufferedReader br = null;
     String fName = "README";

     try {
      ps = (PersistenceService)ServiceManager.lookup("javax.jnlp.PersistenceService");
      bs = (BasicService)ServiceManager.lookup("javax.jnlp.BasicService");
       } catch (UnavailableServiceException e) {
           ps = null;
           bs = null;
       }

    if (ps != null && bs != null)
    {


    /*
    ** When the app is executed for the first time, there will be no
    ** Persistence Storage existing, so an Exception will be thrown.
    **/


       try
       {

       URL codebase = bs.getCodeBase();

       url = new URL(codebase.toString() + "perstest");

       fc = ps.get(url);
       maxSize = fc.getMaxLength();
       fileSize = fc.getLength();
       } catch (IOException ioe) {

     /*
     ** There will no persistence storage when the app is executed for
     ** for the first time on the client machine.
     */
           persExists = false;
       }

     /* If there is no persistence storage, open the default README file.
     ** If persistence exists, but there was nothing in the scratch pad
     ** still open the default README file. Deliberately checking for
     ** length > 1, because in some cases it is writing one byte to the
     ** file even though it is a null character. Maybe due to some bug.
     ** If we had some valid contents in scratch pad, then retrieve
     ** it from Persistence storage and display it.
     */
       try {
         if (persExists = true && fileSize > 1)
         {
          br = new BufferedReader(new InputStreamReader(fc.getInputStream()));
         }
         else
         {
           URL fNameURL = cl.getResource(fName);
           if (fNameURL != null) {
               br = new BufferedReader(new InputStreamReader(fNameURL.openStream()));
               fileSize = 4096;
           }
         }

          StringBuffer sb = new StringBuffer((int)fileSize);
          if (br != null) {
              String line = br.readLine();
              while(line != null) {
                  sb.append(line);
                  sb.append("\n");
                  line = br.readLine();
              }

              textArea.setText(sb.toString());
              br.close();
          }
         } catch (IOException ioe) {
             ioe.printStackTrace();
         }

         try {

          ps.delete(url);

         } catch (IOException ioe) {

        /*
        ** This exception will be raised when the app is executed
        ** for the first time in ps.delete.
        */
        }

        try
        {
            ps.create(url, maxSize);
            fc = ps.get(url);
        } catch (IOException ioe) {
                ioe.printStackTrace();
        }
    }
 }


  /*
  ** This method will be called upon exit to store whatever is in the
 ** scratch pad into the Persistence Storage. Whenever the app is started
 ** next time, the same content will be displayed again.
 **/

  private void saveScratch(String txt)
  {

      try
      {
        int sizeNeeded = txt.length() * 2;
        if (sizeNeeded  > fc.getMaxLength()) fc.setMaxLength(sizeNeeded);
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(fc.getOutputStream(false)));
        os.write(txt);
        os.close();
      } catch(Exception e) {
         e.printStackTrace();
      }

  }

    /**
     * This adapter is constructed to handle mouse over component events.
     */
    private class MouseHandler extends MouseAdapter  {

        private JLabel label;
        private String oldMsg;

        /**
         * ctor for the adapter.
         * @param label the JLabel which will recieve value of the
         *              Action.LONG_DESCRIPTION key.
         */
        public MouseHandler(JLabel label)  {
            setLabel(label);
            oldMsg = label.getText();
        }

        public void setLabel(JLabel label)  {
            this.label = label;
        }

        public void mouseEntered(MouseEvent evt)  {
            if (evt.getSource() instanceof AbstractButton)  {
                AbstractButton button = (AbstractButton)evt.getSource();
                Action action = button.getAction(); // getAction is new in JDK 1.3
                if (action != null)  {
                    oldMsg = label.getText();
                    String message = (String)action.getValue(Action.LONG_DESCRIPTION);
                    label.setText(message);
                }
            }
        }

        public void mouseExited(MouseEvent evt) {
            label.setText(oldMsg);
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args)  {
        WebPad demo = new WebPad();
        demo.pack();
        demo.setVisible(true);
    }
}
