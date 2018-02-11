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

package com.sun.xml.internal.ws.config.metro.util;

import com.sun.istack.internal.logging.Logger;

import javax.xml.ws.WebServiceException;

/**
 *
 * @author Fabian Ritzmann
 */
public class ParserUtil {

    private static final Logger LOGGER = Logger.getLogger(ParserUtil.class);

    private ParserUtil() {
    }

    /**
     * Return true if the value is "true" or "1". Return false if the value is
     * "false" or "0". Throw an exception otherwise. The test is case sensitive.
     *
     * @param value The String representation of the value. Must not be null.
     * @return True if the value is "true" or "1". False if the value is
     *   "false" or "0".
     * @throws PolicyException If the value is not "true", "false", "0" or "1".
     */
    public static boolean parseBooleanValue(String value) throws WebServiceException {
        if ("true".equals(value) || "1".equals(value)) {
            return true;
        }
        else if ("false".equals(value) || "0".equals(value)) {
            return false;
        }
        // TODO logging message
        throw LOGGER.logSevereException(new WebServiceException("invalid boolean value"));
    }

}
