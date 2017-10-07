/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.policy.sourcemodel;

import com.sun.xml.internal.ws.policy.privateutil.LocalizationMessages;
import com.sun.xml.internal.ws.policy.privateutil.PolicyLogger;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Marek Potociar
 */
final class PolicyReferenceData {
    private static final PolicyLogger LOGGER = PolicyLogger.getLogger(PolicyReferenceData.class);

    private static final URI DEFAULT_DIGEST_ALGORITHM_URI;
    private static final URISyntaxException CLASS_INITIALIZATION_EXCEPTION;
    static {
        URISyntaxException tempEx = null;
        URI tempUri = null;
        try {
            tempUri = new URI("http://schemas.xmlsoap.org/ws/2004/09/policy/Sha1Exc");
        } catch (URISyntaxException e) {
            tempEx = e;
        } finally {
            DEFAULT_DIGEST_ALGORITHM_URI = tempUri;
            CLASS_INITIALIZATION_EXCEPTION = tempEx;
        }
    }

    private final URI referencedModelUri;
    private final String digest;
    private final URI digestAlgorithmUri;

    /** Creates a new instance of PolicyReferenceData */
    public PolicyReferenceData(URI referencedModelUri) {
        this.referencedModelUri = referencedModelUri;
        this.digest = null;
        this.digestAlgorithmUri = null;
    }

    public PolicyReferenceData(URI referencedModelUri, String expectedDigest, URI usedDigestAlgorithm) {
        if (CLASS_INITIALIZATION_EXCEPTION != null) {
            throw LOGGER.logSevereException(new IllegalStateException(LocalizationMessages.WSP_0015_UNABLE_TO_INSTANTIATE_DIGEST_ALG_URI_FIELD(), CLASS_INITIALIZATION_EXCEPTION));
        }

        if (usedDigestAlgorithm != null && expectedDigest == null) {
            throw LOGGER.logSevereException(new IllegalArgumentException(LocalizationMessages.WSP_0072_DIGEST_MUST_NOT_BE_NULL_WHEN_ALG_DEFINED()));
        }

        this.referencedModelUri = referencedModelUri;
        if (expectedDigest == null) {
            this.digest = null;
            this.digestAlgorithmUri = null;
        } else {
            this.digest = expectedDigest;

            if (usedDigestAlgorithm == null) {
                this.digestAlgorithmUri = DEFAULT_DIGEST_ALGORITHM_URI;
            } else {
                this.digestAlgorithmUri = usedDigestAlgorithm;
            }
        }
    }

    public URI getReferencedModelUri() {
        return referencedModelUri;
    }

    public String getDigest() {
        return digest;
    }

    public URI getDigestAlgorithmUri() {
        return digestAlgorithmUri;
    }

    /**
     * An {@code Object.toString()} method override.
     */
    @Override
    public String toString() {
        return toString(0, new StringBuffer()).toString();
    }

    /**
     * A helper method that appends indented string representation of this instance to the input string buffer.
     *
     * @param indentLevel indentation level to be used.
     * @param buffer buffer to be used for appending string representation of this instance
     * @return modified buffer containing new string representation of the instance
     */
    public StringBuffer toString(final int indentLevel, final StringBuffer buffer) {
        final String indent = PolicyUtils.Text.createIndent(indentLevel);
        final String innerIndent = PolicyUtils.Text.createIndent(indentLevel + 1);

        buffer.append(indent).append("reference data {").append(PolicyUtils.Text.NEW_LINE);
        buffer.append(innerIndent).append("referenced policy model URI = '").append(referencedModelUri).append('\'').append(PolicyUtils.Text.NEW_LINE);
        if (digest == null) {
            buffer.append(innerIndent).append("no digest specified").append(PolicyUtils.Text.NEW_LINE);
        } else {
            buffer.append(innerIndent).append("digest algorith URI = '").append(digestAlgorithmUri).append('\'').append(PolicyUtils.Text.NEW_LINE);
            buffer.append(innerIndent).append("digest = '").append(digest).append('\'').append(PolicyUtils.Text.NEW_LINE);
        }
        buffer.append(indent).append('}');

        return buffer;
    }
}
