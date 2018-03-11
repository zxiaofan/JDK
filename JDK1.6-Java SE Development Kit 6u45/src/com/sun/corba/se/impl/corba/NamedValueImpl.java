/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * Licensed Materials - Property of IBM
 * RMI-IIOP v1.0
 * Copyright IBM Corp. 1998 1999  All Rights Reserved
 *
 * US Government Users Restricted Rights - Use, duplication or
 * disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

package com.sun.corba.se.impl.corba;

import org.omg.CORBA.NamedValue;
import org.omg.CORBA.Any;

import com.sun.corba.se.spi.orb.ORB ;

public class NamedValueImpl extends NamedValue 
{
    private String _name;
    private Any    _value;
    private int    _flags;
    private ORB    _orb;
 
    public NamedValueImpl(ORB orb) 
    {
        // Note: This orb could be an instanceof ORBSingleton or ORB
        _orb = orb;
        _value = new AnyImpl(_orb);
    }

    public NamedValueImpl(ORB orb,
			  String name, 
			  Any value, 
			  int flags) 
    {
        // Note: This orb could be an instanceof ORBSingleton or ORB
        _orb	= orb;
        _name 	= name;
        _value	= value;
        _flags      = flags;
    }
    
    public String name() 
    {
        return _name;
    }

    public Any value()
    {
        return _value;
    }

    public int flags()
    {
        return _flags;
    }
}
