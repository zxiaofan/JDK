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

package com.sun.xml.internal.ws.api.pipe;

import javax.xml.ws.WebServiceFeature;

/**
 * Feature used to request starting a fiber synchronous to the calling
 * thread but allowing it to later switch to run asynchronously to that thread.
 *
 * @since 2.2.6
 */
public class SyncStartForAsyncFeature
  extends WebServiceFeature {

  public SyncStartForAsyncFeature() {
    enabled = true;
  }

  @Override
  public String getID() {
    return SyncStartForAsyncFeature.class.getSimpleName();
  }
}
