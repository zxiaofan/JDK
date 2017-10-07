/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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
package sun.net;

import java.net.URL;

/**
 * ProgressMeteringPolicy is an interface for determining progress metering policy.
 *
 * @author Stanley Man-Kit Ho
 */
public interface ProgressMeteringPolicy
{
    /**
     * Return true if metering should be turned on for a particular network input stream.
     */
    public boolean shouldMeterInput(URL url, String method);

    /**
     * Return update notification threshold.
     */
    public int getProgressUpdateThreshold();
}
