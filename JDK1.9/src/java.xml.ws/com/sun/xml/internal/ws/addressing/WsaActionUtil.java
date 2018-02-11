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

package com.sun.xml.internal.ws.addressing;

import com.sun.xml.internal.ws.api.model.CheckedException;
import com.sun.xml.internal.ws.api.model.JavaMethod;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * @author Rama Pulavarthi
 */
public class WsaActionUtil {

    @SuppressWarnings("FinalStaticMethod")
    public static final String getDefaultFaultAction(JavaMethod method, CheckedException ce) {
        String tns = method.getOwner().getTargetNamespace();
        String delim = getDelimiter(tns);
        if (tns.endsWith(delim)) {
            tns = tns.substring(0, tns.length() - 1);
        }

        return new StringBuilder(tns).append(delim).append(
                method.getOwner().getPortTypeName().getLocalPart()).append(
                delim).append(method.getOperationName()).append(delim).append("Fault").append(delim).append(ce.getExceptionClass().getSimpleName()).toString();
    }

    private static String getDelimiter(String tns) {
        String delim = "/";
        // TODO: is this the correct way to find the separator ?
        try {
            URI uri = new URI(tns);
            if ((uri.getScheme() != null) && uri.getScheme().equalsIgnoreCase("urn")) {
                delim = ":";
            }
        } catch (URISyntaxException e) {
            LOGGER.warning("TargetNamespace of WebService is not a valid URI");
        }
        return delim;
    }
    private static final Logger LOGGER =
            Logger.getLogger(WsaActionUtil.class.getName());
}
