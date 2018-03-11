/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * %W% %E%
 *
 * Copyright (c) 1993, 1997, Oracle and/or its affiliates. All rights reserved. 901 San Antonio Road,
 * Palo Alto, California, 94303, U.S.A.  All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 *
 * CopyrightVersion 1.2
 *
 */

package com.sun.corba.se.impl.naming.pcosnaming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;

import org.omg.CORBA.Policy;
import org.omg.CORBA.LocalObject;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.Servant;
import org.omg.PortableServer.ForwardRequest;
import org.omg.PortableServer.ServantLocator;
import org.omg.PortableServer.LifespanPolicyValue;
import org.omg.PortableServer.RequestProcessingPolicyValue;
import org.omg.PortableServer.IdAssignmentPolicyValue;
import org.omg.PortableServer.ServantRetentionPolicyValue;
import org.omg.PortableServer.ServantLocatorPackage.CookieHolder;

import com.sun.corba.se.spi.orb.ORB;

/**
 * @version     1.6, 99/10/07
 * @author      Rohit Garg
 * @since       JDK1.2
 */

public class ServantManagerImpl extends org.omg.CORBA.LocalObject implements ServantLocator
{

    // computed using serialver tool

    private static final long serialVersionUID = 4028710359865748280L;
    private ORB orb;

    private NameService theNameService;

    private File logDir;

    private Hashtable contexts;

    private CounterDB counterDb;

    private int counter;

    private final static String objKeyPrefix = "NC";

    ServantManagerImpl(ORB orb, File logDir, NameService aNameService)
    {
	this.logDir = logDir;
	this.orb    = orb;
	// initialize the counter database
	counterDb   = new CounterDB(logDir);
	contexts    = new Hashtable();
	theNameService = aNameService;
    }


    public Servant preinvoke(byte[] oid, POA adapter, String operation, 
			     CookieHolder cookie) throws ForwardRequest
    {

	String objKey = new String(oid);

	Servant servant = (Servant) contexts.get(objKey);

	if (servant == null)
	{
		 servant =  readInContext(objKey);
	}

	return servant;
    }

    public void postinvoke(byte[] oid, POA adapter, String operation,
			   java.lang.Object cookie, Servant servant)
    {
	// nada
    }

    public NamingContextImpl readInContext(String objKey)
    {
	NamingContextImpl context = (NamingContextImpl) contexts.get(objKey);
	if( context != null )
	{
		// Returning Context from Cache
		return context;
	}	

	File contextFile = new File(logDir, objKey);
	if (contextFile.exists()) {
	    try {
		FileInputStream fis = new FileInputStream(contextFile);
		ObjectInputStream ois = new ObjectInputStream(fis);
		context = (NamingContextImpl) ois.readObject();
		context.setORB( orb );
		context.setServantManagerImpl( this );
		context.setRootNameService( theNameService );
		ois.close();
	    } catch (Exception ex) {
	    }
	}

	if (context != null)
	{
		contexts.put(objKey, context);
	}
	return context;
    }

    public NamingContextImpl addContext(String objKey, 
					NamingContextImpl context)
    {
	File contextFile =  new File(logDir, objKey);

	if (contextFile.exists()) 
	{
	    context = readInContext(objKey);
	}
	else {
	    try {
		FileOutputStream fos = new FileOutputStream(contextFile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(context);
		oos.close();
	    } catch (Exception ex) {
	    }
	}
	try
	{
		contexts.remove( objKey );
	}
	catch( Exception e)
	{
	}
	contexts.put(objKey, context);

	return context;
    }	

    public void updateContext( String objKey,
				   NamingContextImpl context )
    {
	File contextFile =  new File(logDir, objKey);
	if (contextFile.exists()) 
	{
		contextFile.delete( );
		contextFile =  new File(logDir, objKey);
	}
		
        try {
		FileOutputStream fos = new FileOutputStream(contextFile);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(context);
		oos.close();
	    } catch (Exception ex) {
		ex.printStackTrace( );
	    }
    }

    public static String getRootObjectKey()
    {
	return objKeyPrefix + CounterDB.rootCounter;
    }

    public String getNewObjectKey()
    {
	return objKeyPrefix + counterDb.getNextCounter();
    }



}

class CounterDB implements Serializable
{

    CounterDB (File logDir)
    {
        counterFileName = "counter";
	counterFile = new File(logDir, counterFileName);
	if (!counterFile.exists()) {
	    counter = new Integer(rootCounter);
    	    writeCounter();
	} else {
	    readCounter();
	}
    }

    private void readCounter()
    {
	try {
	    FileInputStream fis = new FileInputStream(counterFile);
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    counter = (Integer) ois.readObject();
	    ois.close();
	} catch (Exception ex) {
				}
    }

    private void writeCounter()
    {
	try {
	    counterFile.delete();
	    FileOutputStream fos = new FileOutputStream(counterFile);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(counter);
	    oos.flush();
	    oos.close();

	} catch (Exception ex) {
	}
    }

    public synchronized int getNextCounter()
    {
	int counterVal = counter.intValue();
	counter = new Integer(++counterVal); 
	writeCounter();

	return counterVal;
    }

	

    private Integer counter;

    private static String counterFileName = "counter";

    private transient File counterFile;

    public  final static int rootCounter = 0;
}
