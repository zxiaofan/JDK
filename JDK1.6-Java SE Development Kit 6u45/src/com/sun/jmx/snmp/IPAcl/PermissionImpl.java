/*
 * %Z%file      %M%
 * %Z%author    Sun Microsystems, Inc.
 * %Z%version   %I%
 * %Z%date      %D%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */


package com.sun.jmx.snmp.IPAcl;



import java.io.Serializable;


/**
 * Permission is represented as a String.
 *
 * @see java.security.acl.Permission
 * @version     %I%     %G%
 * @author      Sun Microsystems, Inc
 */

class PermissionImpl implements java.security.acl.Permission, Serializable {
  private String perm = null;
  
  /**
   * Constructs a permission.
   *
   * @param s the string representing the permission.
   */
  public PermissionImpl(String s) {
	perm = s;
  }
  
  public int hashCode() {
	return super.hashCode();	
  }
  
  /**
   * Returns true if the object passed matches the permission represented in. 
   *
   * @param p the Permission object to compare with. 
   * @return true if the Permission objects are equal, false otherwise.
   */
  public boolean equals(Object p){
	if (p instanceof PermissionImpl){
	  return perm.equals(((PermissionImpl)p).getString());
	} else {
	  return false;
	}
  }
  
  /**
   * Prints a string representation of this permission. 
   *
   * @return a string representation of this permission. 
   */
  public String toString(){
	return perm.toString();
  }
  
  /**
   * Prints the permission. 
   *
   * @return a string representation of this permission. 
   */
  public String getString(){
	return perm;
  }
}

