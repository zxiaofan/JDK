/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * @(#)InternalBindingValue.java	1.17 99/07/16
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

import org.omg.CORBA.Object;
import org.omg.CosNaming.BindingType;
import java.io.Serializable;

/**
 * Class InternalBindingKey acts as a container for two objects, namely
 * a org.omg.CosNaming::Binding and an CORBA object reference, which are the two
 * components associated with the binding.
 */
public class InternalBindingValue
		implements Serializable
{
    public BindingType theBindingType;
    // The value stores both Stringified Object Reference and
    // Non-Stringified Object Reference. This is done to avoid
    // calling orb.string_to_object( ) everytime. Instead it
    // will be set once and then the result will be used everytime.
    public String strObjectRef;
    transient private org.omg.CORBA.Object theObjectRef;
  
    // Default constructor
    public InternalBindingValue() {
    }

    // Normal constructor
    public InternalBindingValue(BindingType b, String o) {
	// Objectreference or Context
	theBindingType = b;
	strObjectRef = o;
    }

    public org.omg.CORBA.Object getObjectRef( )
    {
	return theObjectRef;
    }

    public void setObjectRef( org.omg.CORBA.Object ObjectRef )
    {
	theObjectRef = ObjectRef;
    }
    
}
