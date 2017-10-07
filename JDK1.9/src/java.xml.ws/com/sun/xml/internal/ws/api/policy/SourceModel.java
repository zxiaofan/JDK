/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.policy;

import com.sun.xml.internal.ws.addressing.policy.AddressingPrefixMapper;
import com.sun.xml.internal.ws.config.management.policy.ManagementPrefixMapper;
import com.sun.xml.internal.ws.encoding.policy.EncodingPrefixMapper;
import com.sun.xml.internal.ws.policy.sourcemodel.PolicySourceModel;
import com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.NamespaceVersion;
import com.sun.xml.internal.ws.policy.spi.PrefixMapper;

import java.util.Arrays;

/**
 * This class is a root of unmarshalled policy source structure. Each instance of
 * the class contains factory method to create new  com.sun.xml.internal.ws.policy.sourcemodel.ModelNode
 * instances associated with the actual model instance.
 *
 * @author Fabian Ritzmann
 */
public class SourceModel extends PolicySourceModel {

    private static final PrefixMapper[] JAXWS_PREFIX_MAPPERS = {
        new AddressingPrefixMapper(),
        new EncodingPrefixMapper(),
        new ManagementPrefixMapper()
    };


    /**
     * Private constructor that creates a new policy source model instance without any
     * id or name identifier. The namespace-to-prefix map is initialized with mapping
     * of policy namespace to the default value set by
     * {@link PolicyConstants#POLICY_NAMESPACE_PREFIX POLICY_NAMESPACE_PREFIX constant}.
     *
     * @param nsVersion The WS-Policy version.
     */
    private SourceModel(NamespaceVersion nsVersion) {
        this(nsVersion, null, null);
    }

    /**
     * Private constructor that creates a new policy source model instance with given
     * id or name identifier and a set of PrefixMappers.
     *
     * @param nsVersion The WS-Policy version.
     * @param policyId Relative policy reference within an XML document. May be {@code null}.
     * @param policyName Absolute IRI of policy expression. May be {@code null}.
     */
    private SourceModel(NamespaceVersion nsVersion, String policyId, String policyName) {
        super(nsVersion, policyId, policyName, Arrays.asList(JAXWS_PREFIX_MAPPERS));
    }

    /**
     * Factory method that creates new policy source model instance.
     *
     * @param nsVersion The policy version
     * @return Newly created policy source model instance.
     */
    public static PolicySourceModel createSourceModel(final NamespaceVersion nsVersion) {
        return new SourceModel(nsVersion);
    }

    /**
     * Factory method that creates new policy source model instance and initializes it according to parameters provided.
     *
     * @param nsVersion The policy version
     * @param policyId local policy identifier - relative URI. May be {@code null}.
     * @param policyName global policy identifier - absolute policy expression URI. May be {@code null}.
     * @return Newly created policy source model instance with its name and id properly set.
     */
    public static PolicySourceModel createSourceModel(final NamespaceVersion nsVersion,
            final String policyId, final String policyName) {
        return new SourceModel(nsVersion, policyId, policyName);
    }

}
