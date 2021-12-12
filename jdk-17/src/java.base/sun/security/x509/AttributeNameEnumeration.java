/*
 * Copyright (c) 1997, 2019, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package sun.security.x509;

import java.util.Vector;
import java.util.Enumeration;

/**
 * <p>This class provides the Enumeration implementation used
 * by all the X509 certificate attributes to return the attribute
 * names contained within them.
 *
 * @author Amit Kapoor
 * @author Hemma Prafullchandra
 */
public class AttributeNameEnumeration extends Vector<String> {

    @java.io.Serial
    private static final long serialVersionUID = -6067440240757099134L;

    /**
     * The default constructor for this class.
     */
    public AttributeNameEnumeration() {
        super(4,2);
    }
}
