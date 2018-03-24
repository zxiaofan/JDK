/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.server;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.server.ResourceInjector;
import com.sun.xml.internal.ws.api.server.WSWebServiceContext;
import com.sun.xml.internal.ws.util.InjectionPlan;

import javax.xml.ws.WebServiceContext;

/**
 * Default {@link ResourceInjector}.
 *
 * @see ResourceInjector#STANDALONE
 * @author Kohsuke Kawaguchi
 */
public final class DefaultResourceInjector extends ResourceInjector {
    public void inject(@NotNull WSWebServiceContext context, @NotNull Object instance) {
        InjectionPlan.<Object, WebServiceContext>buildInjectionPlan(
            instance.getClass(),WebServiceContext.class,false).inject(instance,context);
    }

}
