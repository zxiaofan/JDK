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



// java import
//
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Vector;
import java.security.acl.NotOwnerException;

// SNMP Runtime import
//
import com.sun.jmx.trace.Trace;
  
/**
 * The class defines an abstract representation of a host.
 *
 * @version	%I%	%G%
 * @author	Sun Microsystems, Inc.
 */
abstract class Host extends SimpleNode implements Serializable {
  
    public Host(int id) {
        super(id);
    }

    public Host(Parser p, int id) {
        super(p, id);
    }
  
    protected abstract PrincipalImpl createAssociatedPrincipal()
        throws UnknownHostException;
  
    protected abstract String getHname();

    public void buildAclEntries(PrincipalImpl owner, AclImpl acl) {
        // Create a principal
        //
        PrincipalImpl p=null;
        try {
            p = createAssociatedPrincipal();
        } catch(UnknownHostException e) {
            if (isDebugOn()) {
                debug("buildAclEntries", "Cannot create ACL entry for " + e.getMessage());
            }
	    throw new IllegalArgumentException("Cannot create ACL entry for " + e.getMessage());
        }

        // Create an AclEntry
        //
        AclEntryImpl entry= null;
        try {
            entry = new AclEntryImpl(p);
            // Add permission
            //
            registerPermission(entry);
            acl.addEntry(owner, entry);
        } catch(UnknownHostException e) {
            if (isDebugOn()) {
                debug("buildAclEntries", "Cannot create ACL entry for " + e.getMessage());
            }
            return;
        } catch(NotOwnerException a) {
            if (isDebugOn()) {
                debug("buildAclEntries", "Not owner of ACL " + a.getMessage());
            }
            return;
        }
    }
    
    private void registerPermission(AclEntryImpl entry) {
        JDMHost host= (JDMHost) jjtGetParent(); 
        JDMManagers manager= (JDMManagers) host.jjtGetParent();
        JDMAclItem acl= (JDMAclItem) manager.jjtGetParent();
        JDMAccess access= (JDMAccess) acl.getAccess();
        access.putPermission(entry);
        JDMCommunities comm= (JDMCommunities) acl.getCommunities();
        comm.buildCommunities(entry);
    } 

    public void buildTrapEntries(Hashtable dest) {
        
        JDMHostTrap host= (JDMHostTrap) jjtGetParent(); 
        JDMTrapInterestedHost hosts= (JDMTrapInterestedHost) host.jjtGetParent();
        JDMTrapItem trap = (JDMTrapItem) hosts.jjtGetParent();
        JDMTrapCommunity community = (JDMTrapCommunity) trap.getCommunity();
        String comm = community.getCommunity();
	
        InetAddress add = null;
        try {
            add = java.net.InetAddress.getByName(getHname());
        } catch(UnknownHostException e) {
            if (isDebugOn()) {
                debug("buildTrapEntries", "Cannot create TRAP entry for " + e.getMessage());
            }
            return;
        }
	
        Vector list = null;
        if (dest.containsKey(add)){
            list = (Vector) dest.get(add);
            if (!list.contains(comm)){
                list.addElement(comm);
            }
        } else {
            list = new Vector();
            list.addElement(comm);
            dest.put(add,list);
        }
    }
    
    public void buildInformEntries(Hashtable dest) {
    
        JDMHostInform host= (JDMHostInform) jjtGetParent(); 
        JDMInformInterestedHost hosts= (JDMInformInterestedHost) host.jjtGetParent();
        JDMInformItem inform = (JDMInformItem) hosts.jjtGetParent();
        JDMInformCommunity community = (JDMInformCommunity) inform.getCommunity();
        String comm = community.getCommunity();
	
        InetAddress add = null;
        try {
            add = java.net.InetAddress.getByName(getHname());
        } catch(UnknownHostException e) {
            if (isDebugOn()) {
                debug("buildInformEntries", "Cannot create INFORM entry for " + e.getMessage());
            }
            return;
        }
	
        Vector list = null;
        if (dest.containsKey(add)){
            list = (Vector) dest.get(add);
            if (!list.contains(comm)){
                list.addElement(comm);
            }
        } else {
            list = new Vector();
            list.addElement(comm);
            dest.put(add,list);
        }
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

    void debug(String func, String info) {
        debug(dbgTag, func, info);
    }
    
    String dbgTag = "Host";
}
