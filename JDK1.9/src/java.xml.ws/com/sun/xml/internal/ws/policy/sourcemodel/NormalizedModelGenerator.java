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

import com.sun.xml.internal.ws.policy.AssertionSet;
import com.sun.xml.internal.ws.policy.NestedPolicy;
import com.sun.xml.internal.ws.policy.Policy;
import com.sun.xml.internal.ws.policy.PolicyAssertion;
import com.sun.xml.internal.ws.policy.PolicyException;
import com.sun.xml.internal.ws.policy.privateutil.LocalizationMessages;
import com.sun.xml.internal.ws.policy.privateutil.PolicyLogger;

/**
 * Create a fully normalized WS-Policy infoset.
 *
 * @author Fabian Ritzmann
 */
class NormalizedModelGenerator extends PolicyModelGenerator {

    private static final PolicyLogger LOGGER = PolicyLogger.getLogger(NormalizedModelGenerator.class);

    private final PolicySourceModelCreator sourceModelCreator;


    NormalizedModelGenerator(PolicySourceModelCreator sourceModelCreator) {
        this.sourceModelCreator = sourceModelCreator;
    }

    @Override
    public PolicySourceModel translate(final Policy policy) throws PolicyException {
        LOGGER.entering(policy);

        PolicySourceModel model = null;

        if (policy == null) {
            LOGGER.fine(LocalizationMessages.WSP_0047_POLICY_IS_NULL_RETURNING());
        } else {
            model = this.sourceModelCreator.create(policy);
            final ModelNode rootNode = model.getRootNode();
            final ModelNode exactlyOneNode = rootNode.createChildExactlyOneNode();
            for (AssertionSet set : policy) {
                final ModelNode alternativeNode = exactlyOneNode.createChildAllNode();
                for (PolicyAssertion assertion : set) {
                    final AssertionData data = AssertionData.createAssertionData(assertion.getName(), assertion.getValue(), assertion.getAttributes(), assertion.isOptional(), assertion.isIgnorable());
                    final ModelNode assertionNode = alternativeNode.createChildAssertionNode(data);
                    if (assertion.hasNestedPolicy()) {
                        translate(assertionNode, assertion.getNestedPolicy());
                    }
                    if (assertion.hasParameters()) {
                        translate(assertionNode, assertion.getParametersIterator());
                    }
                }
            }
        }

        LOGGER.exiting(model);
        return model;
    }

    @Override
    protected ModelNode translate(final ModelNode parentAssertion, final NestedPolicy policy) {
        final ModelNode nestedPolicyRoot = parentAssertion.createChildPolicyNode();
        final ModelNode exactlyOneNode = nestedPolicyRoot.createChildExactlyOneNode();
        final AssertionSet set = policy.getAssertionSet();
        final ModelNode alternativeNode = exactlyOneNode.createChildAllNode();
        translate(alternativeNode, set);
        return nestedPolicyRoot;
    }

}
