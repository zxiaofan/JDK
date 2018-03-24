/*
 * Copyright (c) 1997, 2000, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;

import sun.security.util.*;

/**
 * This interface specifies the abstract methods which have to be
 * implemented by all the members of the GeneralNames ASN.1 object.
 *
 * @author Amit Kapoor
 * @author Hemma Prafullchandra
 */
public interface GeneralNameInterface {
    /**
     * The list of names supported.
     */
    public static final int NAME_ANY = 0;
    public static final int NAME_RFC822 = 1;
    public static final int NAME_DNS = 2;
    public static final int NAME_X400 = 3;
    public static final int NAME_DIRECTORY = 4;
    public static final int NAME_EDI = 5;
    public static final int NAME_URI = 6;
    public static final int NAME_IP = 7;
    public static final int NAME_OID = 8;

    /**
     * The list of constraint results.
     */
    public static final int NAME_DIFF_TYPE = -1; /* input name is different type from name (i.e. does not constrain) */
    public static final int NAME_MATCH = 0;      /* input name matches name */
    public static final int NAME_NARROWS = 1;    /* input name narrows name */
    public static final int NAME_WIDENS = 2;     /* input name widens name */
    public static final int NAME_SAME_TYPE = 3;  /* input name does not match, narrow, or widen, but is same type */

    /**
     * Return the type of the general name, as
     * defined above.
     */
    int getType();

    /**
     * Encode the name to the specified DerOutputStream.
     *
     * @param out the DerOutputStream to encode the GeneralName to.
     * @exception IOException thrown if the GeneralName could not be
     *            encoded.
     */
    void encode(DerOutputStream out) throws IOException;

    /**
     * Return type of constraint inputName places on this name:<ul>
     *   <li>NAME_DIFF_TYPE = -1: input name is different type from name (i.e. does not constrain).
     *   <li>NAME_MATCH = 0: input name matches name.
     *   <li>NAME_NARROWS = 1: input name narrows name (is lower in the naming subtree)
     *   <li>NAME_WIDENS = 2: input name widens name (is higher in the naming subtree)
     *   <li>NAME_SAME_TYPE = 3: input name does not match or narrow name, but is same type.
     * </ul>.  These results are used in checking NameConstraints during
     * certification path verification.
     *
     * @param inputName to be checked for being constrained
     * @return constraint type above
     * @throws UnsupportedOperationException if name is same type, but comparison operations are
     *          not supported for this name type.
     */
    int constrains(GeneralNameInterface inputName) throws UnsupportedOperationException;

    /**
     * Return subtree depth of this name for purposes of determining
     * NameConstraints minimum and maximum bounds and for calculating
     * path lengths in name subtrees.
     *
     * @return distance of name from root
     * @throws UnsupportedOperationException if not supported for this name type
     */
    int subtreeDepth() throws UnsupportedOperationException;
}
