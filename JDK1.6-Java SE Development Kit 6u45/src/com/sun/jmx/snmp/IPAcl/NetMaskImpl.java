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



import java.util.Vector;
import java.util.Enumeration;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.net.InetAddress;

import java.security.Principal; 
import java.security.acl.Group; 

import com.sun.jmx.trace.Trace;

/**
 * This class is used to represent a subnet mask (a group of hosts matching the same 
 * IP mask).
 * 
 * @see java.security.acl.Group
 * @version     4.5     02/03/00
 * @author      Sun Microsystems, Inc
 */

class NetMaskImpl extends PrincipalImpl implements Group, Serializable {
    protected byte[] subnet = null;
    protected int prefix = -1;
    /**
     * Constructs an empty group.
     * @exception UnknownHostException Not implemented
     */
    public NetMaskImpl () throws UnknownHostException {
    }
  
    private byte[] extractSubNet(byte[] b) {
	int addrLength = b.length;
	byte[] subnet = null;
	if(isDebugOn()) {
	    debug("extractSubNet","BINARY ARRAY :");
	    StringBuffer buff = new StringBuffer();
	    for(int i =0; i < addrLength; i++) {
		buff.append((int)(b[i] &0xFF) +":");
	    }
	    debug("extractSubNet", buff.toString());
	}
	
	// 8 is a byte size. Common to any InetAddress (V4 or V6).
	int fullyCoveredByte = prefix / 8;
	if(fullyCoveredByte == addrLength) {
	    if(isDebugOn()) {
		debug("extractSubNet"," The mask is the complete address, strange..." + addrLength);
	    }
	    subnet = b;
	    return subnet;
	}
	if(fullyCoveredByte > addrLength) {
	    if(isDebugOn()) {
		debug("extractSubNet"," The number of covered byte is longer than the address. BUG");
	    }
	    throw new IllegalArgumentException("The number of covered byte is longer than the address.");
	}
	int partialyCoveredIndex = fullyCoveredByte;
	if(isDebugOn()) {
	    debug("extractSubNet"," Partialy covered index : " + partialyCoveredIndex);
	}
	byte toDeal = b[partialyCoveredIndex];
	if(isDebugOn()) {
	    debug("extractSubNet"," Partialy covered byte : " + toDeal);
	}
	
	// 8 is a byte size. Common to any InetAddress (V4 or V6).
	int nbbits = prefix % 8;
	int subnetSize = 0;
	
	if(nbbits == 0) 
	subnetSize = partialyCoveredIndex;
	else
	subnetSize = partialyCoveredIndex + 1;
	
	if(isDebugOn()) {
	    debug("extractSubNet"," Remains : " + nbbits);
	}
	
	byte mask = 0;
	for(int i = 0; i < nbbits; i++) {
	    mask |= (1 << (7 - i));
	}
	if(isDebugOn()) {
	    debug("extractSubNet","Mask value" + (int) (mask & 0xFF));
	}
	
	byte maskedValue = (byte) ((int)toDeal & (int)mask);
	
	if(isDebugOn()) {
	    debug("extractSubNet","Masked byte :"  + (int) (maskedValue &0xFF));
	}
	subnet = new byte[subnetSize];
	if(isDebugOn()) {
	    debug("extractSubNet","Resulting subnet : ");
	}
	for(int i = 0; i < partialyCoveredIndex; i++) {
	    subnet[i] = b[i];
	    
	    if(isDebugOn()) {
		debug("extractSubNet",(int) (subnet[i] & 0xFF) +":");
	    }
	}
	
	if(nbbits != 0) {
	    subnet[partialyCoveredIndex] = maskedValue;
	    if(isDebugOn()) {
		debug("extractSubNet"," Last subnet byte : " + (int) (subnet[partialyCoveredIndex] &0xFF));
	    }
	}
	return subnet;
    }

  /**
   * Constructs a group using the specified subnet mask. 
   * THIS ALGORITHM IS V4 and V6 compatible.
   *
   * @exception UnknownHostException if the subnet mask cann't be built.
   */
  public NetMaskImpl (String a, int prefix) throws UnknownHostException {
	super(a);
	this.prefix = prefix;
	subnet = extractSubNet(getAddress().getAddress());
  }
  
  /**
   * Adds the specified member to the group. 
   *
   * @param p the principal to add to this group. 
   * @return true if the member was successfully added, false if the 
   *      principal was already a member. 
   */
  public boolean addMember(Principal p) {
	// we don't need to add members because the ip address is a subnet mask 
	return true;	
  }

  public int hashCode() {
	return super.hashCode();	
  }
  
  /**
   * Compares this group to the specified object. Returns true if the object
   * passed in matches the group represented.
   *
   * @param p the object to compare with.
   * @return true if the object passed in matches the subnet mask, 
   *    false otherwise.
   */
    public boolean equals (Object p) {
	if (p instanceof PrincipalImpl || p instanceof NetMaskImpl){
	    PrincipalImpl received = (PrincipalImpl) p;
	    InetAddress addr = received.getAddress();
	    if(isDebugOn()) {
		debug("equals","Received Address : " + addr);
	    }
	    byte[] recAddr = addr.getAddress();
	    for(int i = 0; i < subnet.length; i++) {
		if(isDebugOn()) {
		    debug("equals","(recAddr[i]) :" + (recAddr[i] & 0xFF)); 
		    debug("equals","(recAddr[i] & subnet[i]) :" +
			  ( (int) (recAddr[i] & (int)subnet[i]) &0xFF) +
			  "subnet[i] :" + (int) (subnet[i] &0xFF));
		}
		if((recAddr[i] & subnet[i]) != subnet[i]) {
		    if(isDebugOn()) {
			debug("equals","FALSE");
		    }
		    return false;
		}
	    }
	    if(isDebugOn()) {
		debug("equals","TRUE");
	    }
	    return true;
	} else
	    return false;
    }
  /**
   * Returns true if the passed principal is a member of the group.
   *
   * @param p the principal whose membership is to be checked.
   * @return true if the principal is a member of this group, false otherwise. 
   */
  public boolean isMember(Principal p) {
	if ((p.hashCode() & super.hashCode()) == p.hashCode()) return true;
	else return false;
  }
  
  /**
   * Returns an enumeration which contains the subnet mask.
   *
   * @return an enumeration which contains the subnet mask.
   */
  public Enumeration members(){
	Vector v = new Vector(1);
	v.addElement(this);
	return v.elements();
  }
  
  /**
   * Removes the specified member from the group. (Not implemented)
   *
   * @param p the principal to remove from this group.
   * @return allways return true.
   */
  public boolean removeMember(Principal p) {
	return true;
  }
  
  /**
   * Prints a string representation of this group.
   *
   * @return  a string representation of this group.
   */
  public String toString() {
	return ("NetMaskImpl :"+ super.getAddress().toString() + "/" + prefix);
  }

    // TRACES & DEBUG
    //---------------
    
    boolean isTraceOn() {
        return Trace.isSelected(Trace.LEVEL_TRACE, Trace.INFO_SNMP);
    }

    void trace(String clz, String func, String info) {
        Trace.send(Trace.LEVEL_TRACE, Trace.INFO_SNMP, clz, func, info);
    }

    void trace(String func, String info) {
        trace(dbgTag, func, info);
    }
    
    boolean isDebugOn() {
        return Trace.isSelected(Trace.LEVEL_DEBUG, Trace.INFO_SNMP);
    }

    void debug(String clz, String func, String info) {
        Trace.send(Trace.LEVEL_DEBUG, Trace.INFO_SNMP, clz, func, info);
    }

    void debug(String clz, String func, Throwable exception) {
        Trace.send(Trace.LEVEL_DEBUG, Trace.INFO_SNMP, clz, func, exception);
    }

    void debug(String func, String info) {
        debug(dbgTag, func, info);
    }
    
    void debug(String func, Throwable exception) {
        debug(dbgTag, func, exception);
    }
    
    String dbgTag = "NetMaskImpl"; 
}


