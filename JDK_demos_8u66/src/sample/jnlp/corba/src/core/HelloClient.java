package sample.jnlp.corba.src.core;
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

import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import javax.rmi.*;
import java.util.Vector;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelloClient {

    static JTextArea textArea;
    java.awt.Container contentPane;
    JFrame t;

    public static void  main( String args[] ) {
        Context ic;
        Object objref;
        HelloInterface hi;

        HelloClient helloClient = new HelloClient();
        try {
            ic = new InitialContext();
        } catch (NamingException e) {
            System.out.println("failed to obtain context" + e);
            textArea.append("Failed to obtain Context \n");
            e.printStackTrace();
            return;
        }
        // STEP 1: Get the Object reference from the Name Service
        // using JNDI call.
        try {
            objref = ic.lookup("HelloService");
            System.out.println("Client: Obtained a ref. to Hello server.");
            textArea.append("Client Obtained a reference to Hello Server \n");
        } catch (NamingException e) {
            System.out.println("failed to lookup object reference");
            textArea.append("Failed to lookup object reference\n");
            e.printStackTrace();
            return;
        }

        // STEP 2: Narrow the object reference to the concrete type and
        // invoke the method.
        try {
            hi = (HelloInterface) PortableRemoteObject.narrow(
                objref, HelloInterface.class);
            hi.sayHello( " Java Web Start Application - HelloClient " );
            textArea.append("Invoked method sayHello() successfully \n");
        } catch (ClassCastException e) {
            System.out.println("narrow failed");
            textArea.append("Narrow Failed\n");
            e.printStackTrace();
            return;
        } catch( Exception e ) {
            System.err.println( "Exception " + e + "Caught" );
            e.printStackTrace( );
            return;
        }
        textArea.append("Thanks for choosing Java Web Start\n");
    }

    public HelloClient()
    {


        t = new JFrame("RMI-IIOP CORBA Sample");
        contentPane = t.getContentPane();
        contentPane.setLayout( new FlowLayout() );
        contentPane.setBackground(Color.white);
        textArea = new JTextArea();
        contentPane.add(textArea);
        textArea.setText("Welcome to HelloWorld RMI Client-Server demo\n");
        textArea.append("RMI Client started by Java Web Start.\n");
        t.addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent e)
          {
          t.setVisible(false);
          System.exit(0);
          }
         });
        t.pack();
        t.setSize(500,400);
        t.setVisible(true);
  }

}
