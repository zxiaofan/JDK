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

import com.sun.xml.internal.ws.config.management.policy.ManagementAssertionCreator;
import com.sun.xml.internal.ws.policy.PolicyException;
import com.sun.xml.internal.ws.policy.privateutil.PolicyLogger;
import com.sun.xml.internal.ws.policy.sourcemodel.PolicyModelTranslator;
import com.sun.xml.internal.ws.policy.spi.PolicyAssertionCreator;
import com.sun.xml.internal.ws.resources.ManagementMessages;

import java.util.Arrays;

/**
 * This class provides a method for translating a PolicySourceModel structure to a
 * normalized Policy expression. The resulting Policy is disconnected from its model,
 * thus any additional changes in the model will have no effect on the Policy expression.
 *
 * @author Fabian Ritzmann
 */
public class ModelTranslator extends PolicyModelTranslator {

    private static final PolicyLogger LOGGER = PolicyLogger.getLogger(ModelTranslator.class);

    private static final PolicyAssertionCreator[] JAXWS_ASSERTION_CREATORS = {
        new ManagementAssertionCreator()
    };

    private static final ModelTranslator translator;
    private static final PolicyException creationException;

    static {
        ModelTranslator tempTranslator = null;
        PolicyException tempException = null;
        try {
            tempTranslator = new ModelTranslator();
        } catch (PolicyException e) {
            tempException = e;
            LOGGER.warning(ManagementMessages.WSM_1007_FAILED_MODEL_TRANSLATOR_INSTANTIATION(), e);
        } finally {
            translator = tempTranslator;
            creationException = tempException;
        }
    }

    private ModelTranslator() throws PolicyException {
        super(Arrays.asList(JAXWS_ASSERTION_CREATORS));
    }

    /**
     * Method returns thread-safe policy model translator instance.
     *
     * @return A policy model translator instance.
     * @throws PolicyException If instantiating a PolicyAssertionCreator failed.
     */
    public static ModelTranslator getTranslator() throws PolicyException {
        if (creationException != null) {
            throw LOGGER.logSevereException(creationException);
        }
        else {
            return translator;
        }
    }

}
