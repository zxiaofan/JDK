/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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
package javax.xml.crypto.dsig.spec;

import javax.xml.crypto.dsig.SignatureMethod;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Objects;

/**
 * Parameters for the <a href="http://www.w3.org/2007/05/xmldsig-more#rsa-pss">
 * XML Signature RSASSA-PSS Algorithm</a>. The parameters are represented as a
 * {@link PSSParameterSpec} object.
 * <p>
 * The XML Schema Definition is defined as:
 * <pre><code>
 *    &lt;xs:element name="RSAPSSParams" type="pss:RSAPSSParamsType"&gt;
 *        &lt;xs:annotation&gt;
 *            &lt;xs:documentation&gt;
 *    Top level element that can be used in xs:any namespace="#other"
 *    wildcard of ds:SignatureMethod content.
 *            &lt;/xs:documentation&gt;
 *        &lt;/xs:annotation&gt;
 *    &lt;/xs:element&gt;
 *    &lt;xs:complexType name="RSAPSSParamsType"&gt;
 *        &lt;xs:sequence&gt;
 *            &lt;xs:element ref="ds:DigestMethod" minOccurs="0"/&gt;
 *            &lt;xs:element name="MaskGenerationFunction"
 *               type="pss:MaskGenerationFunctionType" minOccurs="0"/&gt;
 *            &lt;xs:element name="SaltLength" type="xs:int"
 *               minOccurs="0"/&gt;
 *            &lt;xs:element name="TrailerField" type="xs:int"
 *               minOccurs="0"/&gt;
 *        &lt;/xs:sequence&gt;
 *    &lt;/xs:complexType&gt;
 *    &lt;xs:complexType name="MaskGenerationFunctionType"&gt;
 *        &lt;xs:sequence&gt;
 *            &lt;xs:element ref="ds:DigestMethod" minOccurs="0"/&gt;
 *        &lt;/xs:sequence&gt;
 *        &lt;xs:attribute name="Algorithm" type="xs:anyURI"
 *           default="http://www.w3.org/2007/05/xmldsig-more#MGF1"/&gt;
 *    &lt;/xs:complexType&gt;
 * </code></pre>
 *
 * @since 17
 * @see SignatureMethod#RSA_PSS
 * @see <a href="https://www.ietf.org/rfc/rfc6931.txt">RFC 6931</a>
 */
public final class RSAPSSParameterSpec implements SignatureMethodParameterSpec {

    private final PSSParameterSpec spec;

    /**
     * Creates a new {@code RSAPSSParameterSpec} object with the specified
     * {@link PSSParameterSpec} object.
     *
     * @param spec the input {@code PSSParameterSpec} object
     *
     * @throws NullPointerException if {@code spec} is null
     */
    public RSAPSSParameterSpec(PSSParameterSpec spec) {
        this.spec = Objects.requireNonNull(spec);
    }

    /**
     * Returns the {@code PSSParameterSpec} object inside.
     *
     * @return the {@code PSSParameterSpec} object inside
     */
    public PSSParameterSpec getPSSParameterSpec() {
        return spec;
    }
}
