package sample.jnlp.raf.src;
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

/*
 * This program uses JNLP API to write to a file
 * that is selected by the user. We then read
 * whatever is written in the file and display
 * it in the text area.
 */


/*
 * Please note that this application sleeps for 2 seconds
 * everytime some text is added to the text area.
 * This is done purely for demonstration purpose.
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import java.applet.*;
import javax.swing.*;
import javax.jnlp.*;

public class randomFile
{
        FileOpenService fos;
        JNLPRandomAccessFile raf;
        FileContents fc;
        static int count=0;
        JTextArea textArea;
        java.awt.Container contentPane;
        JFrame t;

     public randomFile()
     {
        t = new JFrame("JNLPRandomAccessFile API demo");
        contentPane = t.getContentPane();
        contentPane.setLayout( new FlowLayout() );
        contentPane.setBackground(Color.white);
        textArea = new JTextArea();
        contentPane.add(textArea);
        textArea.setText("Demonstrating usage of random access file. \n");
        textArea.append("It behaves like a large array of bytes stored in the file system \n");
        textArea.append("Pick a file to open on the local system \n");
        t.addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent e)
         {
          destroy();
          t.setVisible(false);
          System.exit(0);
         }

        });
        t.pack();
        t.setSize(500,400);
        t.setVisible(true);


        // Look up a FileOpenService

        try {
        fos = (FileOpenService)ServiceManager.lookup("javax.jnlp.FileOpenService");
        } catch (UnavailableServiceException e) {
        fos = null;
        }

        if (fos != null) {
        try {
        // get a file with FileOpenService
        fc = fos.openFileDialog(null, null);

        // If valid file contents
        if (fc != null) {
        long grantedLength = fc.getLength();
        if (grantedLength + 1024 > fc.getMaxLength()) {
        // attempt to increase the maximum file size defined by
        // the client
        grantedLength = fc.setMaxLength(grantedLength + 1024);
           }

        // Open the file for read write
        raf = fc.getRandomAccessFile("rw");
        textArea.append("File selected : ");
        textArea.append(fc.getName());
        textArea.append("\n");
        textArea.append("Created a random access file in read/write mode....   \n");
          try
          {
          Thread.sleep(2000);
          } catch (InterruptedException e){
           // the VM doesn't want us to sleep anymore,
           // so get back to work
          }

        }
        } catch (Exception e) {
           e.printStackTrace();
         }
        }
      }


  public void write()
     {

      String msg="JAVA WEB START CAN STUN YOU.. ";

       if (fos != null && fc != null) {
       try {
         textArea.append("Seek to the begining of the file for write... \n");

          try
          {
          Thread.sleep(2000);
          } catch (InterruptedException e){
           // the VM doesn't want us to sleep anymore,
           // so get back to work
          }

           // seek to the beginning and write
         raf.seek(0);

           /* This message will be written at the begining
           ** of the file. It will overwrite if it is already
           ** existing.
           */
           textArea.append("Writing a string to the file using UTF-8 encoding...   \n");

           try
           {
            Thread.sleep(2000);
            } catch (InterruptedException e){
             // the VM doesn't want us to sleep anymore,
             // so get back to work
            }

           raf.writeUTF("CONGRATS !!. WRITE & READ PERFORMED SUCCESSFULLY ");
           raf.seek(raf.length()-1);

           textArea.append("Seek to end of the file for next write...   \n");
            try
            {
             Thread.sleep(2000);
            } catch (InterruptedException e){
             // the VM doesn't want us to sleep anymore,
             // so get back to work
            }

           /*
           ** This message will always be written at the end of
           ** file. It will be written once for every write you
           ** make to the file indicating number of times this
           ** message was written to the same file.
           */

           textArea.append("Writing another string as a sequence of bytes  \n");
           try
           {
            Thread.sleep(2000);
           } catch (InterruptedException e){
            // the VM doesn't want us to sleep anymore,
            // so get back to work
           }

           raf.writeBytes("\n" + msg + count++);
           } catch (Exception e) {
              e.printStackTrace();
           }
        }

       }

  public void destroy() {
      if (fos != null && fc != null) {
       try {
           // close the file
              raf.close();
              } catch (Exception e) {
                e.printStackTrace();
              }
            }
          }

    public void read()
    {
       if (fos != null && fc != null) {
        try
        {


           textArea.append("Now reading whatever was written..   \n");
           textArea.append("Reading one line at a time from the begining of the File..   \n");

             try
             {
             Thread.sleep(2000);
             } catch (InterruptedException e){
              // the VM doesn't want us to sleep anymore,
              // so get back to work
             }


        /*
        ** Starting from the begining, it will read one line
        ** at a time from the file and append it with newline
        ** character.
        */
           textArea.append("\n");
           raf.seek(0);
           String line = raf.readUTF();
           while (line != null)
           {
            textArea.append(line);
            textArea.append("\n");
            line = raf.readLine();

           }

           textArea.append("\n");
            try
            {
             Thread.sleep(2000);
            } catch (InterruptedException e){
               // the VM doesn't want us to sleep anymore,
               // so get back to work
            }

         textArea.append("Thanks for choosing Java Web Start..   \n");

         } catch (Exception e) {
             e.printStackTrace();
         }
       }
     }

  public static void main(String args[])
     {

       randomFile randomfile = new randomFile();
       randomfile.write();
       randomfile.read();

     }
}
