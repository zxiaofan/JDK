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

package javax.rmi.CORBA;

/**
 * This class is used to marshal java.lang.Class objects over IIOP.
 */
public class ClassDesc implements java.io.Serializable {

    /**
     * @serial The class's RepositoryId.
     */
    private String repid;

    /**
     * @serial A space-separated list of codebase URLs.
     */
    private String codebase;
}
