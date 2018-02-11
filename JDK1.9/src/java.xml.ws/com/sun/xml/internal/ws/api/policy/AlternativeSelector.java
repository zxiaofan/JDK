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

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import com.sun.xml.internal.ws.policy.EffectivePolicyModifier;
import com.sun.xml.internal.ws.policy.PolicyException;

/**
 *
 * @author Fabian Ritzmann
 */
public class AlternativeSelector extends EffectiveAlternativeSelector {

    public static void doSelection(final EffectivePolicyModifier modifier) throws PolicyException {
        final ValidationProcessor validationProcessor = ValidationProcessor.getInstance();
        selectAlternatives(modifier, validationProcessor);
    }

}
