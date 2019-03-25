/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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
/*
 * $Id: DigestMethod.java,v 1.6 2005/05/10 16:03:46 mullan Exp $
 */
package javax.xml.crypto.dsig;

import javax.xml.crypto.AlgorithmMethod;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import java.security.spec.AlgorithmParameterSpec;

/**
 * A representation of the XML <code>DigestMethod</code> element as
 * defined in the <a href="http://www.w3.org/TR/xmldsig-core/">
 * W3C Recommendation for XML-Signature Syntax and Processing</a>.
 * The XML Schema Definition is defined as:
 * <pre>
 *   &lt;element name="DigestMethod" type="ds:DigestMethodType"/&gt;
 *     &lt;complexType name="DigestMethodType" mixed="true"&gt;
 *       &lt;sequence&gt;
 *         &lt;any namespace="##any" minOccurs="0" maxOccurs="unbounded"/&gt;
 *           &lt;!-- (0,unbounded) elements from (1,1) namespace --&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Algorithm" type="anyURI" use="required"/&gt;
 *     &lt;/complexType&gt;
 * </pre>
 *
 * A <code>DigestMethod</code> instance may be created by invoking the
 * {@link XMLSignatureFactory#newDigestMethod newDigestMethod} method
 * of the {@link XMLSignatureFactory} class.
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 * @see XMLSignatureFactory#newDigestMethod(String, DigestMethodParameterSpec)
 */
public interface DigestMethod extends XMLStructure, AlgorithmMethod {

    // All methods can be found in RFC 6931.

    /**
     * The <a href="http://www.w3.org/2000/09/xmldsig#sha1">
     * SHA1</a> digest method algorithm URI.
     */
    String SHA1 = "http://www.w3.org/2000/09/xmldsig#sha1";

    /**
     * The <a href="http://www.w3.org/2001/04/xmldsig-more#sha224">
     * SHA224</a> digest method algorithm URI.
     *
     * @since 11
     */
    String SHA224 = "http://www.w3.org/2001/04/xmldsig-more#sha224";

    /**
     * The <a href="http://www.w3.org/2001/04/xmlenc#sha256">
     * SHA256</a> digest method algorithm URI.
     */
    String SHA256 = "http://www.w3.org/2001/04/xmlenc#sha256";

    /**
     * The <a href="http://www.w3.org/2001/04/xmldsig-more#sha384">
     * SHA384</a> digest method algorithm URI.
     *
     * @since 11
     */
    String SHA384 = "http://www.w3.org/2001/04/xmldsig-more#sha384";

    /**
     * The <a href="http://www.w3.org/2001/04/xmlenc#sha512">
     * SHA512</a> digest method algorithm URI.
     */
    String SHA512 = "http://www.w3.org/2001/04/xmlenc#sha512";

    /**
     * The <a href="http://www.w3.org/2001/04/xmlenc#ripemd160">
     * RIPEMD-160</a> digest method algorithm URI.
     */
    String RIPEMD160 = "http://www.w3.org/2001/04/xmlenc#ripemd160";

    /**
     * The <a href="http://www.w3.org/2007/05/xmldsig-more#sha3-224">
     * SHA3-224</a> digest method algorithm URI.
     *
     * @since 11
     */
    String SHA3_224 = "http://www.w3.org/2007/05/xmldsig-more#sha3-224";

    /**
     * The <a href="http://www.w3.org/2007/05/xmldsig-more#sha3-256">
     * SHA3-256</a> digest method algorithm URI.
     *
     * @since 11
     */
    String SHA3_256 = "http://www.w3.org/2007/05/xmldsig-more#sha3-256";

    /**
     * The <a href="http://www.w3.org/2007/05/xmldsig-more#sha3-384">
     * SHA3-384</a> digest method algorithm URI.
     *
     * @since 11
     */
    String SHA3_384 = "http://www.w3.org/2007/05/xmldsig-more#sha3-384";

    /**
     * The <a href="http://www.w3.org/2007/05/xmldsig-more#sha3-512">
     * SHA3-512</a> digest method algorithm URI.
     *
     * @since 11
     */
    String SHA3_512 = "http://www.w3.org/2007/05/xmldsig-more#sha3-512";

    /**
     * Returns the algorithm-specific input parameters associated with this
     * <code>DigestMethod</code>.
     *
     * <p>The returned parameters can be typecast to a {@link
     * DigestMethodParameterSpec} object.
     *
     * @return the algorithm-specific parameters (may be <code>null</code> if
     *    not specified)
     */
    AlgorithmParameterSpec getParameterSpec();
}
