/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmediaimpl.platform.ios;

import com.sun.media.jfxmedia.MediaError;
import com.sun.media.jfxmedia.locator.Locator;
import com.sun.media.jfxmediaimpl.MediaUtils;
import com.sun.media.jfxmediaimpl.NativeMedia;
import com.sun.media.jfxmediaimpl.platform.Platform;

final class IOSMedia extends NativeMedia {

   /**
    * Handle to the native media player.
    */
   private long refNativeMedia;

   IOSMedia(Locator locator) {
       super(locator);
       init();
   }

   @Override
   public Platform getPlatform() {
       return IOSPlatform.getPlatformInstance();
   }

   private void init() {
       final long[] nativeMediaHandle = new long[1];
       final Locator loc = getLocator();
       final MediaError err = MediaError.getFromCode(iosInitNativeMedia(loc,
               loc.getContentType(), loc.getContentLength(),
               nativeMediaHandle));
       if (err != MediaError.ERROR_NONE) {
           MediaUtils.nativeError(this, err);
       }
       this.refNativeMedia = nativeMediaHandle[0];
   }

   long getNativeMediaRef() {
       return refNativeMedia;
   }

   @Override
   public synchronized void dispose() {
       if (0 != refNativeMedia) {
           iosDispose(refNativeMedia);
           refNativeMedia = 0L;
       }
   }

   private native int iosInitNativeMedia(Locator locator,
                                              String contentType,
                                              long sizeHint,
                                              long[] nativeMediaHandle);

   private native void iosDispose(long refNativeMedia);
}
