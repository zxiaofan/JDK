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


package com.sun.jmx.snmp;


// java import
//
import java.util.Vector;
import java.util.Enumeration;
import java.util.Hashtable;

//RI import
import com.sun.jmx.snmp.SnmpOidTable;
import com.sun.jmx.snmp.SnmpOidRecord;
import com.sun.jmx.snmp.SnmpStatusException;

// SNMP Runtime import
//
import com.sun.jmx.trace.Trace;

/**
 * Contains metadata definitions for MIB variables. 
 * A name can be resolved against a table of MIB variables.
 * Each entry in the table is an <CODE>SnmpOidRecord</CODE> object that contains a name, a dot-separated OID string, 
 * and the corresponding SMI type of the variable. 
 * <P>
 * If you need to load a specific <CODE>SnmpOidTable</CODE>, just call the static method
 * {@link com.sun.jmx.snmp.SnmpOid#setSnmpOidTable <CODE>SnmpOid.setSnmpOidTable(<I>myOidTable</I>)</CODE>}.
 * <P>
 * <p><b>This API is a Sun Microsystems internal API  and is subject 
 * to change without notice.</b></p>
 * @see com.sun.jmx.snmp.SnmpOidRecord
 * 
 * @version     %I%     %G%
 * @author      Sun Microsystems, Inc
 */

public class SnmpOidTableSupport implements SnmpOidTable {

    /**
     * Creates an <CODE>SnmpOidTableSupport</CODE> with the specified name.
     * This name identifies the MIB to which belong  the MIB variables contained 
     * in this <CODE>SnmpOidTableSupport</CODE> object.
     * @param name The OID table name.
     */
    public SnmpOidTableSupport(String name) {	
        myName=name;
    }
  
    /**
     * Searches for a MIB variable given its logical name and returns an {@link com.sun.jmx.snmp.SnmpOidRecord} object 
     * containing information on the variable.
     *
     * @param name The name of the MIB variable.
     * @return The <CODE>SnmpOidRecord</CODE> object containing information on the variable.
     * @exception SnmpStatusException If the variable is not found.
     */
    public SnmpOidRecord resolveVarName(String name) throws SnmpStatusException {

        SnmpOidRecord var  = (SnmpOidRecord)oidStore.get(name) ;	
        if (var != null) {
            return var;
        } else {
            throw new SnmpStatusException("Variable name <" + name + "> not found in Oid repository") ;
        }
    }

    /**
     * Searches for a MIB variable given its OID and returns an {@link com.sun.jmx.snmp.SnmpOidRecord} object 
     * containing information on the variable.
     *
     * @param oid The OID of the MIB variable.
     * @return The <CODE>SnmpOidRecord</CODE> object containing information on the variable.
     * @exception SnmpStatusException If the variable is not found.
     */
    public SnmpOidRecord resolveVarOid(String oid) throws SnmpStatusException {

        // Try to see if the variable name is actually an OID to resolve.
        //
        int index = oid.indexOf('.') ;
        if (index < 0) {
            throw new SnmpStatusException("Variable oid <" + oid + "> not found in Oid repository") ;
        }
        if (index == 0) {
            // The oid starts with a '.' ala CMU.
            //
            oid= oid.substring(1, oid.length());
        }
      
        // Go through the oidStore ... Good luck !
        //
        for(Enumeration list= oidStore.elements(); list.hasMoreElements(); ) {
            SnmpOidRecord element= (SnmpOidRecord) list.nextElement();
            if (element.getOid().equals(oid))
                return element;
        }

        throw new SnmpStatusException("Variable oid <" + oid + "> not found in Oid repository") ;
    }   

    /**
     * Returns a list that can be used to traverse all the entries in this <CODE>SnmpOidTable</CODE>.
     * @return A vector of {@link com.sun.jmx.snmp.SnmpOidRecord} objects.
     */     
    public Vector getAllEntries() {

        Vector elementsVector = new Vector();
        // get the locally defined elements ...
        for (Enumeration e = oidStore.elements();
             e.hasMoreElements(); ) {
            elementsVector.addElement(e.nextElement());
        }
        return elementsVector ;
    }

    /**
     * Loads a list of variables into the storage area,
     * which is kept in memory. If you have new MIB variables,
     * this method can be called to load them.
     * @param mibs The list of variables to load.
     */
    public synchronized void loadMib(SnmpOidRecord[] mibs) {
        try {
            for (int i = 0; ; i++) {
                SnmpOidRecord s = mibs[i] ;
                if (isTraceOn()) {
                    trace("loadMib", "load " + s.getName());
                }
                oidStore.put(s.getName(), s) ;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }        

    /**
     * Checks if the specified <CODE>Object</CODE> is equal to this <CODE>SnmpOidTableSupport</CODE>.
     * @param object The <CODE>Object</CODE> to be compared.
     * @return <CODE>true</CODE> if <CODE>object</CODE> is an <CODE>SnmpOidTableSupport</CODE> instance and equals to this,
     * <CODE>false</CODE> otherwise.
     */
    public boolean equals(Object object) {

        if (!(object instanceof SnmpOidTableSupport)) {
            return false;
        }
        SnmpOidTableSupport val = (SnmpOidTableSupport) object;  
        return myName.equals(val.getName());     
    }

    /**
     * Returns the name identifying this <CODE>SnmpOidTableSupport</CODE> object.
     * @return The OID table name.
     */
    public String getName() {
        return myName;
    }
    /*
     * ------------------------------------------
     *   PRIVATE METHODS
     * ------------------------------------------
     */

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
    
    String dbgTag = "SnmpOidTableSupport";
    
    private Hashtable oidStore = new Hashtable() ; // storage area.
    private String myName;
}
