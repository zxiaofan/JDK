/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.spi.legacy.interceptor;

import com.sun.corba.se.spi.oa.ObjectAdapter;

public interface IORInfoExt
{
    public int getServerPort(String type)
	throws
	    UnknownType;

    public ObjectAdapter getObjectAdapter();
}

// End of file.
