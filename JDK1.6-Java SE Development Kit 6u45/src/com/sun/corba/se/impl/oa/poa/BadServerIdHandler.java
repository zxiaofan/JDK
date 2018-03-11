/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * %Z%%Y%%M% %I% %D%
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

package com.sun.corba.se.impl.oa.poa;

import com.sun.corba.se.spi.ior.ObjectKey;

/**
 * The bad server id handler is used to locate persistent objects.
 * The Locator object registers the BadServerIdHandler with the ORB
 * and when requests for persistent objects for servers (other than
 * itself) comes, it throws a ForwardException with the IOR pointing
 * to the active server.
 */
public interface BadServerIdHandler
{
    void handle(ObjectKey objectKey) ;
}
