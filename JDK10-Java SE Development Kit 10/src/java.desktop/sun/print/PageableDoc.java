/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.print;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import java.awt.print.Pageable;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;

public class PageableDoc implements Doc {

    private Pageable pageable;

    public PageableDoc(Pageable pageable) {
       this.pageable = pageable;
    }

   public DocFlavor getDocFlavor() {
       return DocFlavor.SERVICE_FORMATTED.PAGEABLE;
   }

   public DocAttributeSet getAttributes() {
       return new HashDocAttributeSet();
   }

   public Object getPrintData() throws IOException {
      return pageable;
   }

   public Reader getReaderForText()
      throws UnsupportedEncodingException, IOException {

      return null;
   }

   public InputStream getStreamForBytes() throws IOException {
      return null;
   }
}
