/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

 /*
   * This code is ported to XAWT from MAWT based on awt_mgrsel.c
   * and XSettings.java code written originally by Valeriy Ushakov
   * Author : Bino George
   */

package sun.awt.X11;

public interface  XMSelectionListener {

   /*
    * This method is called when the owner changes
    */
   public void ownerChanged(int screen, XMSelection sel, long newOwner, long data, long timestamp);

   /*
    * This method is called when the owner dies
    */
   public void ownerDeath(int screen, XMSelection sel, long deadOwner);

   /*
    * This method is for selection change notification
    *
    * This method will only get called if you use the default constructor
    * or expilicitly specify PropertyChangeMask.
    */

   public void selectionChanged(int screen, XMSelection sel, long owner, XPropertyEvent event);

}
