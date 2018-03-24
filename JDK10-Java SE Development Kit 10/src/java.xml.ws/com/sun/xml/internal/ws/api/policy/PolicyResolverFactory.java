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

import com.sun.xml.internal.ws.util.ServiceFinder;
import com.sun.xml.internal.ws.policy.jaxws.DefaultPolicyResolver;

/**
 * PolicyResolverFactory provides a way to override Effective Policy Resolution for a Service or Client.
 * JAX-WS provides DEFAULT_POLICY_RESOLVER implementation that
 *      on server-side validates that Policy has single alternative in the scope of each subject
 *      on client-side updates with the effective policy by doing alternative selection.
 *
 * Extensions can override this to consult other forms of configuration to give the effective PolicyMap.
 *
 * @author Rama Pulavarthi
 */
public abstract class PolicyResolverFactory {

    public abstract PolicyResolver doCreate();

    public static PolicyResolver create(){
        for (PolicyResolverFactory factory : ServiceFinder.find(PolicyResolverFactory.class)) {
            PolicyResolver policyResolver = factory.doCreate();
            if (policyResolver != null) {
                return policyResolver;
            }
        }
         // return default policy resolver.
        return DEFAULT_POLICY_RESOLVER;
    }

    /**
     * JAX-WS provided DEFAULT_POLICY_RESOLVER implementation that
     *      on server-side validates that Policy has single alternative in the scope of each subject
     *      on client-side updates with the effective policy by doing alternative selection.
     */
    public static final PolicyResolver DEFAULT_POLICY_RESOLVER =  new DefaultPolicyResolver();


}
