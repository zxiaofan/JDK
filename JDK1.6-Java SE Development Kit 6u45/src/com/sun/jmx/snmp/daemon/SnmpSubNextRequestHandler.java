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

package com.sun.jmx.snmp.daemon;

// java imports
//
import java.util.Vector;

// jmx imports
//
import com.sun.jmx.snmp.SnmpEngine;
import com.sun.jmx.snmp.SnmpPdu;
import com.sun.jmx.snmp.SnmpValue;
import com.sun.jmx.snmp.SnmpVarBind;
import com.sun.jmx.snmp.SnmpVarBindList;
import com.sun.jmx.snmp.SnmpOid;
import com.sun.jmx.snmp.SnmpDefinitions;
import com.sun.jmx.snmp.SnmpStatusException;
// SNMP Runtime import
//
import com.sun.jmx.snmp.agent.SnmpMibAgent;
import com.sun.jmx.snmp.agent.SnmpMibRequest;
import com.sun.jmx.snmp.daemon.SnmpAdaptorServer;
import com.sun.jmx.snmp.internal.SnmpIncomingRequest;

/* NPCTE fix for bugId 4492741, esc 0 */
import com.sun.jmx.snmp.ThreadContext;
/* end of NPCTE fix for bugId 4492741 */

class SnmpSubNextRequestHandler extends SnmpSubRequestHandler {
    private SnmpAdaptorServer server = null;
    /**
     * The constuctor initialize the subrequest with the whole varbind
     * list contained in the original request.
     */
    protected SnmpSubNextRequestHandler(SnmpAdaptorServer server,
					SnmpMibAgent agent, 
					SnmpPdu req) {
        super(agent,req);
	init(req, server);
    }
    
    protected SnmpSubNextRequestHandler(SnmpEngine engine,
					SnmpAdaptorServer server,
					SnmpIncomingRequest incRequest,
					SnmpMibAgent agent, 
					SnmpPdu req) {
	super(engine, incRequest, agent, req);
	init(req, server);
	if(isDebugOn())
	    debug("SnmpSubNextRequestHandler", "Constructor :" + this);
    }
    
    private void init(SnmpPdu req, SnmpAdaptorServer server) {
	this.server = server;
	
        // The translation table is easy in this case ...
        //
        final int max= translation.length;
        final SnmpVarBind[] list= req.varBindList;
        final NonSyncVector nonSyncVarBind = ((NonSyncVector)varBind);
        for(int i=0; i < max; i++) {
            translation[i]= i;
            // we need to allocate a new SnmpVarBind. Otherwise the first
            // sub request will modify the list...
            //
	    final SnmpVarBind newVarBind = 
		new SnmpVarBind(list[i].oid, list[i].value);
            nonSyncVarBind.addNonSyncElement(newVarBind);
        }
    }

    public void run() {
    
        try {
	    /* NPCTE fix for bugId 4492741, esc 0, 16-August-2001 */
     	    final ThreadContext oldContext =
                ThreadContext.push("SnmpUserData",data);
	    try { 
		if (isTraceOn()) {
		    trace("run", "[" + Thread.currentThread() + 
			  "]:getNext operation on " + agent.getMibName());
		}
      
		// Always call with V2. So the merge of the responses will 
		// be easier.
		//
		agent.getNext(createMibRequest(varBind, snmpVersionTwo, data));
	    } finally {
                ThreadContext.restore(oldContext);
            }
	    /* end of NPCTE fix for bugId 4492741 */
      
      
        } catch(SnmpStatusException x) {
            errorStatus = x.getStatus() ;
            errorIndex=  x.getErrorIndex();
            if (isDebugOn()) {
                debug("run", "[" + Thread.currentThread() + 
		      "]:an Snmp error occured during the operation");
		debug("run",x);
            }
        }
        catch(Exception x) {
            errorStatus = SnmpDefinitions.snmpRspGenErr ;
	    if (isTraceOn()) {
                trace("run", "[" + Thread.currentThread() + 
		      "]:a generic error occured during the operation");
	    }
            if (isDebugOn()) {
		debug("run","Error is: " + x);
		debug("run",x);
            }
        }
        if (isTraceOn()) {
            trace("run", "[" + Thread.currentThread() + 
		  "]:operation completed");
        }
    }

    /**
     * The method updates the varbind list of the subrequest.
     */
    protected  void updateRequest(SnmpVarBind var, int pos) {
	if(isDebugOn())
	    debug("updateRequest", "Copy :" + var);
        int size= varBind.size();
        translation[size]= pos;
	final SnmpVarBind newVarBind = 
	    new SnmpVarBind(var.oid, var.value);
	if(isDebugOn())
	    debug("updateRequest", "Copied :" + newVarBind);
	
	varBind.addElement(newVarBind);
    }
    /**
     * The method updates a given var bind list with the result of a 
     * previsouly invoked operation.
     * Prior to calling the method, one must make sure that the operation was
     * successful. As such the method getErrorIndex or getErrorStatus should be
     * called.
     */
    protected void updateResult(SnmpVarBind[] result) {
  
        final int max=varBind.size();
        for(int i= 0; i< max ; i++) {
            // May be we should control the position ...
            //
            final int index= translation[i];
            final SnmpVarBind elmt= 
		(SnmpVarBind)((NonSyncVector)varBind).elementAtNonSync(i);

            final SnmpVarBind vb= result[index];
            if (vb == null) {
                result[index]= elmt;
		/* NPCTE fix for bugid 4381195 esc 0. <J.C.> < 17-Oct-2000> */
	        // if ((elmt != null) &&  (elmt.value == null) && 
		//    (version == snmpVersionTwo)) 
		//    elmt.value = SnmpVarBind.endOfMibView;
 		/* end of NPCTE fix for bugid 4381195 */
                continue;
            }

            final SnmpValue val= vb.value;
            if ((val == null)|| (val == SnmpVarBind.endOfMibView)){
		/* NPCTE fix for bugid 4381195 esc 0. <J.C.> < 17-Oct-2000> */
		if ((elmt != null) &&
		    (elmt.value != SnmpVarBind.endOfMibView)) 
		    result[index]= elmt;
		// else if ((val == null) && (version == snmpVersionTwo)) 
		//    vb.value = SnmpVarBind.endOfMibView;
		continue;
 		/* end of NPCTE fix for bugid 4381195 */
            }
     
	    /* NPCTE fix for bugid 4381195 esc 0. <J.C.> < 17-Oct-2000> */
	    if (elmt == null) continue;
	    /* end of NPCTE fix for bugid 4381195 */

	    if (elmt.value == SnmpVarBind.endOfMibView) continue;


            // Now we need to take the smallest oid ...
            //
	    int comp = elmt.oid.compareTo(vb.oid);
            if (comp < 0) {
	      // Take the smallest (lexicographically)
                //
                result[index]= elmt;
            }
	    else {
		if(comp == 0) {
		    // Must compare agent used for reply
		    // Take the deeper within the reply
		    if(isDebugOn()) {
			trace("updateResult"," oid overlapping. Oid : " + 
			      elmt.oid + "value :" + elmt.value);
			trace("updateResult","Already present varBind : " + 
			      vb);
		    }
		    
		    SnmpOid oid = vb.oid;
		    SnmpMibAgent deeperAgent = server.getAgentMib(oid);

		    if(isDebugOn())
			trace("updateResult","Deeper agent : " + deeperAgent);
		    if(deeperAgent == agent) {
			if(isDebugOn())
			trace("updateResult","The current agent is the deeper one. Update the value with the current one");
			result[index].value = elmt.value;
		    }

		    /*
		      Vector v = new Vector();
		      SnmpMibRequest getReq = createMibRequest(v,
		      version,
		      null);
		      SnmpVarBind realValue = new SnmpVarBind(oid);
		      getReq.addVarBind(realValue);
		      try {
		      deeperAgent.get(getReq);
		      } catch(SnmpStatusException e) {
		      e.printStackTrace();
		      }
		      
		      if(isDebugOn())
		      trace("updateResult", "Biggest priority value is : " + 
		      realValue.value);
		      
		      result[index].value = realValue.value;
		    */
		}
	    }
	}
    }    

    protected String makeDebugTag() {
        return "SnmpSubNextRequestHandler";
    }
}
