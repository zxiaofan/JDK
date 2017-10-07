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

import com.sun.xml.internal.ws.addressing.policy.AddressingPolicyValidator;
import com.sun.xml.internal.ws.config.management.policy.ManagementPolicyValidator;
import com.sun.xml.internal.ws.encoding.policy.EncodingPolicyValidator;
import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;
import com.sun.xml.internal.ws.policy.PolicyException;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.util.Arrays;

/**
 * Provides methods for assertion validation.
 *
 * @author Fabian Ritzmann
 */
public class ValidationProcessor extends AssertionValidationProcessor {

    private static final PolicyAssertionValidator[] JAXWS_ASSERTION_VALIDATORS = {
        new AddressingPolicyValidator(),
        new EncodingPolicyValidator(),
        new ManagementPolicyValidator()
    };

    /**
     * This constructor instantiates the object with a set of dynamically
     * discovered PolicyAssertionValidators.
     *
     * @throws PolicyException Thrown if the set of dynamically discovered
     *   PolicyAssertionValidators is empty.
     */
    private ValidationProcessor() throws PolicyException {
        super(Arrays.asList(JAXWS_ASSERTION_VALIDATORS));
    }

    /**
     * Factory method that returns singleton instance of the class.
     *
     * @return singleton An instance of the class.
     * @throws PolicyException If instantiation failed.
     */
    public static ValidationProcessor getInstance() throws PolicyException {
        return new ValidationProcessor();
    }

}
