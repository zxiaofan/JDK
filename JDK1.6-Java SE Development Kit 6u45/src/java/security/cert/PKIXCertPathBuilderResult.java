/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.security.cert;

import java.security.PublicKey;

/**
 * This class represents the successful result of the PKIX certification 
 * path builder algorithm. All certification paths that are built and
 * returned using this algorithm are also validated according to the PKIX
 * certification path validation algorithm.
 *
 * <p>Instances of <code>PKIXCertPathBuilderResult</code> are returned by 
 * the <code>build</code> method of <code>CertPathBuilder</code>
 * objects implementing the PKIX algorithm.
 *
 * <p>All <code>PKIXCertPathBuilderResult</code> objects contain the 
 * certification path constructed by the build algorithm, the
 * valid policy tree and subject public key resulting from the build 
 * algorithm, and a <code>TrustAnchor</code> describing the certification 
 * authority (CA) that served as a trust anchor for the certification path.
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @see CertPathBuilderResult
 *
 * @version	%I% %G%
 * @since	1.4
 * @author	Anne Anderson
 */
public class PKIXCertPathBuilderResult extends PKIXCertPathValidatorResult 
    implements CertPathBuilderResult {

    private CertPath certPath;

    /**
     * Creates an instance of <code>PKIXCertPathBuilderResult</code>
     * containing the specified parameters.
     *
     * @param certPath the validated <code>CertPath</code>
     * @param trustAnchor a <code>TrustAnchor</code> describing the CA that
     * served as a trust anchor for the certification path
     * @param policyTree the immutable valid policy tree, or <code>null</code>
     * if there are no valid policies
     * @param subjectPublicKey the public key of the subject
     * @throws NullPointerException if the <code>certPath</code>, 
     * <code>trustAnchor</code> or <code>subjectPublicKey</code> parameters 
     * are <code>null</code>
     */
    public PKIXCertPathBuilderResult(CertPath certPath, 
	TrustAnchor trustAnchor, PolicyNode policyTree, 
	PublicKey subjectPublicKey)
    {
	super(trustAnchor, policyTree, subjectPublicKey);
	if (certPath == null)
	    throw new NullPointerException("certPath must be non-null");
	this.certPath = certPath;
    }

    /**
     * Returns the built and validated certification path. The 
     * <code>CertPath</code> object does not include the trust anchor.
     * Instead, use the {@link #getTrustAnchor() getTrustAnchor()} method to 
     * obtain the <code>TrustAnchor</code> that served as the trust anchor
     * for the certification path.
     *
     * @return the built and validated <code>CertPath</code> (never 
     * <code>null</code>)
     */
    public CertPath getCertPath() {
	return certPath;
    }

    /**
     * Return a printable representation of this 
     * <code>PKIXCertPathBuilderResult</code>.
     *
     * @return a <code>String</code> describing the contents of this
     *         <code>PKIXCertPathBuilderResult</code>
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("PKIXCertPathBuilderResult: [\n");
        sb.append("  Certification Path: " + certPath + "\n");
        sb.append("  Trust Anchor: " + getTrustAnchor().toString() + "\n");
        sb.append("  Policy Tree: " + String.valueOf(getPolicyTree()) + "\n");
        sb.append("  Subject Public Key: " + getPublicKey() + "\n");
        sb.append("]");
        return sb.toString();
    }
}
