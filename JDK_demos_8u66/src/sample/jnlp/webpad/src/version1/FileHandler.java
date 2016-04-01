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
import java.awt.print.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.font.*;
import javax.swing.text.*;

import javax.jnlp.FileOpenService;
import javax.jnlp.FileSaveService;
import javax.jnlp.PrintService;
import javax.jnlp.FileContents;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import java.io.*;

public class FileHandler {

    static private FileOpenService _fos = null;
    static private FileSaveService _fss = null;
    static private PrintService _ps = null;

    static private FileContents _fc = null;

    static private JTextComponent editor = null;

    static public boolean isEnabled() {
        return true;
    }

    static public String open() {
        initialize();
        try {
            _fc = _fos.openFileDialog(null, null);
            return readFromFile(_fc);
        } catch(IOException ioe) {
            ioe.printStackTrace(System.out);
            return null;
        }
    };

    static public void save(String txt) {
        initialize();
        try {
            // Show save dialog if no name is already given
            if (_fc == null) {
                _fc = _fss.saveFileDialog(null, null, new StringBufferInputStream(txt), null);
                // file saved, done
                return;
            }
            // use this only when filename is known
            if (_fc != null) {
                writeToFile(txt, _fc);
            }
        } catch(IOException ioe) {
            ioe.printStackTrace(System.out);
            return;
        }
    };

    static public void saveAs(String txt) {
        initialize();
        try {
            if (_fc == null) {
                // If not already saved. Save-as is like save
                save(txt);
                return;
            } else {
                _fc = _fss.saveAsFileDialog(null, null, _fc);
            }
        } catch(IOException ioe) {
            ioe.printStackTrace(System.out);
            return;
        }
    };

    static public void print(JTextComponent textArea) {
        editor = textArea;

        // Creating printjob on a separate user thread
        // to workaround a known awt bug 4394889/4218471.
        // window does n't get repainted when print dialog displayed.

        new Thread() {
            public void run() {
                initialize();
                try {
                    if (_ps != null) {
                    _ps.print(new WebpadPrinter());
                     return;
                    }
                    } catch(Exception e) {
                     e.printStackTrace(System.out);
                     return;
                    }
                  }
                }.start();
    };

    static private void writeToFile(String txt, FileContents fc) throws IOException {
        int sizeNeeded = txt.length() * 2;
        if (sizeNeeded  > fc.getMaxLength()) fc.setMaxLength(sizeNeeded);
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(_fc.getOutputStream(true)));
        os.write(txt);
        os.close();
    }

    static private String readFromFile(FileContents fc) throws IOException {
        if (fc == null) return null;
        BufferedReader br = new BufferedReader(new InputStreamReader(_fc.getInputStream()));
        StringBuffer sb = new StringBuffer((int)_fc.getLength());
        String line = br.readLine();
        while(line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        br.close();
        return sb.toString();
    }

    static private synchronized void initialize() {
        if (_fss != null) return;
        try {
            _fos = (FileOpenService)ServiceManager.lookup("javax.jnlp.FileOpenService");
            _fss = (FileSaveService)ServiceManager.lookup("javax.jnlp.FileSaveService");
            _ps = (PrintService)ServiceManager.lookup("javax.jnlp.PrintService");
        } catch(UnavailableServiceException e) {
           _fos = null;
           _fss = null;
           _ps = null;
        }
    }


static class WebpadPrinter implements Printable {

        public int print(Graphics g, PageFormat pageFormat,
            int pageIndex) {
                Graphics2D g2d = (Graphics2D)g;

                try {
                return paintText(g2d, pageFormat, pageIndex);
                } catch (Exception e) {
                        e.printStackTrace();
                        return Printable.NO_SUCH_PAGE;
                 }
                }

        int paintText(Graphics2D g2d, PageFormat pageFormat,
            int pageIndex) throws Exception {
                String holdString;

                int pageImgHeight = (int)pageFormat.getImageableHeight();
                int pageHeight = (int)pageFormat.getHeight();

                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                g2d.setFont(editor.getGraphics().getFont());
                g2d.setColor(Color.black);

                String dispText = null;
                try {
                dispText = editor.getText(0, editor.getDocument().getLength());
                } catch (BadLocationException e) {
                        throw new Exception(e.getMessage());
                }
                FontRenderContext frc = g2d.getFontRenderContext();
                Rectangle2D rect = g2d.getFont().getMaxCharBounds(frc);
                double charWidth = rect.getWidth();
                double charHeight = rect.getHeight() + 2.0d;
                double maxLineWidth = pageFormat.getImageableWidth();
                int maxCharsPerLine = (int)(maxLineWidth / (double)charWidth);

                String [] lines = getLines(dispText);

                int numLines = lines.length;
                double canvasHeight = charHeight * (double)numLines;
                int linesPerPage = (int)(pageImgHeight / charHeight);
                int numPages = numLines / linesPerPage + 1;

                int startLineNum = linesPerPage * pageIndex;

                int linesForThisPage = getNumLinesForPage(lines, pageIndex, linesPerPage);
                int endLineNum = startLineNum + linesForThisPage - 1;


                if (startLineNum >= lines.length) {
                        return Printable.NO_SUCH_PAGE;
                }

                String [] linesToPrint = new String[linesForThisPage];

                System.arraycopy(lines, startLineNum, linesToPrint, 0, linesForThisPage);

                float y = 10.0f;
                LineMetrics lm = g2d.getFont().getLineMetrics("A", frc);
                double yinc = lm.getHeight() + 2.0;
                for (int i = 0; i<linesToPrint.length; i++) {
                        g2d.drawString(linesToPrint[i], 10.0f, y);
                        y = (float)((double)y + yinc);
                }
                return Printable.PAGE_EXISTS;

              }

        String [] getLines(String text) {
                // breaks string at '\n' into string array
                StringTokenizer st = new StringTokenizer(text,"\n",true);
                Vector v = new Vector();
                while(st.hasMoreTokens()) {

                /*
                ** This implementation is to workaround a know
                ** StringTokenizer bug 4140850 due to which
                ** empty lines if any inside the document were not
                ** getting printed.
                */

                       String s = st.nextToken();
                       if (s.equals("\n")) {
                          v.add("");
                       } else {
                          v.add(s);
                          if (st.hasMoreTokens())
                            st.nextToken(); // Skip '\n' separator
                       }
                }
                return (String [])v.toArray(new String[0]);
        }

     int getNumLinesForPage(String [] lines, int pageIndex, int linesPerPage)
        {
        if (lines.length < (pageIndex + 1) * linesPerPage) {
                int val = lines.length - pageIndex * linesPerPage;
                return val;
           } else {
                return linesPerPage;
           }
         }


   }
}
