/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.spi.encoding ;

import com.sun.corba.se.impl.encoding.CDRInputStream ;
import com.sun.corba.se.pept.encoding.InputObject ;

public abstract class CorbaInputObject 
    extends CDRInputStream
    implements InputObject
{
}
