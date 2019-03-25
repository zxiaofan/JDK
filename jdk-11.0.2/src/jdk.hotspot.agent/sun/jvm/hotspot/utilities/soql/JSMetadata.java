/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.utilities.soql;

import sun.jvm.hotspot.oops.Metadata;

/** This is JavaScript wrapper for a metadata object in debuggee.*/

public abstract class JSMetadata extends DefaultScriptObject {
   public JSMetadata(Metadata metadata, JSJavaFactory factory) {
       this.metadata = metadata;
       this.factory = factory;
   }

   public final Metadata getMetadata() {
       return metadata;
   }

   public boolean equals(Object o) {
      if (o == null || !(o instanceof JSMetadata)) {
         return false;
      }

      JSMetadata other = (JSMetadata) o;
      return metadata.equals(other.metadata);
   }

   public int hashCode() {
      return metadata.hashCode();
   }

   public String toString() {
     return "Metadata " + metadata.getAddress().toString();
   }

   private final Metadata metadata;
   protected final JSJavaFactory factory;
}
