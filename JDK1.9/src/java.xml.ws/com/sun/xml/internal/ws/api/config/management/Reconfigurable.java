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

package com.sun.xml.internal.ws.api.config.management;

import javax.xml.ws.WebServiceException;

/**
 * Allows to trigger a reconfiguration action on an object.
 *
 * @author Fabian Ritzmann
 */
public interface Reconfigurable {

    /**
     * Executes any action when an endpoint is reconfigured.
     *
     * @throws WebServiceException Thrown if the reconfiguration failed.
     */
    void reconfigure() throws WebServiceException;

}
