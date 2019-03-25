/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.print;

import javax.print.PrintService;

/**
 * Implement this to be called back when a complete list of services is
 * available.
 * This is useful for cases where retrieving this list of services may
 * be time consuming and rather than block on this, other work can be done
 * in the interim.
 */
public interface BackgroundLookupListener {

    /**
     * Called once to notify that the complete list of services is
     * retrieved. This call back may be immediate if the list is already
     * available.
     */
    public void notifyServices(PrintService[] services);

}
