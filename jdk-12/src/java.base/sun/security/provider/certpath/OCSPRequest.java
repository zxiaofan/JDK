/*
 * Copyright (c) 2003, 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.provider.certpath;

import java.io.IOException;
import java.security.cert.Extension;
import java.util.Collections;
import java.util.List;

import sun.security.util.HexDumpEncoder;
import sun.security.util.*;
import sun.security.x509.PKIXExtensions;

/**
 * This class can be used to generate an OCSP request and send it over
 * an output stream. Currently we do not support signing requests.
 * The OCSP Request is specified in RFC 2560 and
 * the ASN.1 definition is as follows:
 * <pre>
 *
 * OCSPRequest     ::=     SEQUENCE {
 *      tbsRequest                  TBSRequest,
 *      optionalSignature   [0]     EXPLICIT Signature OPTIONAL }
 *
 *   TBSRequest      ::=     SEQUENCE {
 *      version             [0]     EXPLICIT Version DEFAULT v1,
 *      requestorName       [1]     EXPLICIT GeneralName OPTIONAL,
 *      requestList                 SEQUENCE OF Request,
 *      requestExtensions   [2]     EXPLICIT Extensions OPTIONAL }
 *
 *  Signature       ::=     SEQUENCE {
 *      signatureAlgorithm      AlgorithmIdentifier,
 *      signature               BIT STRING,
 *      certs               [0] EXPLICIT SEQUENCE OF Certificate OPTIONAL
 *   }
 *
 *  Version         ::=             INTEGER  {  v1(0) }
 *
 *  Request         ::=     SEQUENCE {
 *      reqCert                     CertID,
 *      singleRequestExtensions     [0] EXPLICIT Extensions OPTIONAL }
 *
 *  CertID          ::= SEQUENCE {
 *       hashAlgorithm  AlgorithmIdentifier,
 *       issuerNameHash OCTET STRING, -- Hash of Issuer's DN
 *       issuerKeyHash  OCTET STRING, -- Hash of Issuers public key
 *       serialNumber   CertificateSerialNumber
 * }
 *
 * </pre>
 *
 * @author      Ram Marti
 */

class OCSPRequest {

    private static final Debug debug = Debug.getInstance("certpath");
    private static final boolean dump = debug != null && Debug.isOn("ocsp");

    // List of request CertIds
    private final List<CertId> certIds;
    private final List<Extension> extensions;
    private byte[] nonce;

    /*
     * Constructs an OCSPRequest. This constructor is used
     * to construct an unsigned OCSP Request for a single user cert.
     */
    OCSPRequest(CertId certId) {
        this(Collections.singletonList(certId));
    }

    OCSPRequest(List<CertId> certIds) {
        this.certIds = certIds;
        this.extensions = Collections.<Extension>emptyList();
    }

    OCSPRequest(List<CertId> certIds, List<Extension> extensions) {
        this.certIds = certIds;
        this.extensions = extensions;
    }

    byte[] encodeBytes() throws IOException {

        // encode tbsRequest
        DerOutputStream tmp = new DerOutputStream();
        DerOutputStream requestsOut = new DerOutputStream();
        for (CertId certId : certIds) {
            DerOutputStream certIdOut = new DerOutputStream();
            certId.encode(certIdOut);
            requestsOut.write(DerValue.tag_Sequence, certIdOut);
        }

        tmp.write(DerValue.tag_Sequence, requestsOut);
        if (!extensions.isEmpty()) {
            DerOutputStream extOut = new DerOutputStream();
            for (Extension ext : extensions) {
                ext.encode(extOut);
                if (ext.getId().equals(
                        PKIXExtensions.OCSPNonce_Id.toString())) {
                    nonce = ext.getValue();
                }
            }
            DerOutputStream extsOut = new DerOutputStream();
            extsOut.write(DerValue.tag_Sequence, extOut);
            tmp.write(DerValue.createTag(DerValue.TAG_CONTEXT,
                                         true, (byte)2), extsOut);
        }

        DerOutputStream tbsRequest = new DerOutputStream();
        tbsRequest.write(DerValue.tag_Sequence, tmp);

        // OCSPRequest without the signature
        DerOutputStream ocspRequest = new DerOutputStream();
        ocspRequest.write(DerValue.tag_Sequence, tbsRequest);

        byte[] bytes = ocspRequest.toByteArray();

        if (dump) {
            HexDumpEncoder hexEnc = new HexDumpEncoder();
            debug.println("OCSPRequest bytes...\n\n" +
                hexEnc.encode(bytes) + "\n");
        }

        return bytes;
    }

    List<CertId> getCertIds() {
        return certIds;
    }

    byte[] getNonce() {
        return nonce;
    }
}
