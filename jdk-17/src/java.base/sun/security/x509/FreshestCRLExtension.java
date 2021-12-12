/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.List;

import sun.security.util.*;

/**
 * Represents the Freshest CRL Extension.
 *
 * <p>
 * The extension identifies how delta CRL information for a
 * complete CRL is obtained.
 *
 * <p>
 * The extension is defined in Section 5.2.6 of
 * <a href="http://tools.ietf.org/html/rfc5280">Internet X.509 PKI
 * Certificate and Certificate Revocation List (CRL) Profile</a>.
 *
 * <p>
 * Its ASN.1 definition is as follows:
 * <pre>
 *     id-ce-freshestCRL OBJECT IDENTIFIER ::=  { id-ce 46 }
 *
 *     FreshestCRL ::= CRLDistributionPoints
 * </pre>
 *
 * @since 1.6
 */
public class FreshestCRLExtension extends CRLDistributionPointsExtension {

    /**
     * Attribute name.
     */
    public static final String NAME = "FreshestCRL";

    /**
     * Creates a freshest CRL extension.
     * The criticality is set to false.
     *
     * @param distributionPoints the list of delta CRL distribution points.
     */
    public FreshestCRLExtension(List<DistributionPoint> distributionPoints)
        throws IOException {

        super(PKIXExtensions.FreshestCRL_Id, false, distributionPoints, NAME);
    }

    /**
     * Creates the extension from the passed DER encoded value of the same.
     *
     * @param critical true if the extension is to be treated as critical.
     * @param value an array of DER encoded bytes of the actual value.
     * @exception IOException on decoding error.
     */
    public FreshestCRLExtension(Boolean critical, Object value)
    throws IOException {
        super(PKIXExtensions.FreshestCRL_Id, critical.booleanValue(), value,
            NAME);
    }

    /**
     * Writes the extension to the DerOutputStream.
     *
     * @param out the DerOutputStream to write the extension to.
     * @exception IOException on encoding errors.
     */
    public void encode(OutputStream out) throws IOException {
        super.encode(out, PKIXExtensions.FreshestCRL_Id, false);
    }
}
