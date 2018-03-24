/*
 * Copyright (c) 2010, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmediaimpl.platform;

import com.sun.media.jfxmedia.Media;
import com.sun.media.jfxmedia.MediaPlayer;
import com.sun.media.jfxmedia.MetadataParser;
import com.sun.media.jfxmedia.locator.Locator;
import com.sun.media.jfxmedia.logging.Logger;
import com.sun.media.jfxmediaimpl.platform.java.JavaPlatform;
import com.sun.media.jfxmediaimpl.HostUtils;
import com.sun.media.jfxmediaimpl.platform.gstreamer.GSTPlatform;
import com.sun.media.jfxmediaimpl.platform.osx.OSXPlatform;
import com.sun.media.jfxmediaimpl.platform.ios.IOSPlatform;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Core media platform management code.
 */
public final class PlatformManager {
    private static String enabledPlatforms;
    static {
        AccessController.doPrivileged((PrivilegedAction) () -> {
            getPlatformSettings();
            return null;
        });
    }

    private static void getPlatformSettings() {
        // get enabled platforms, comma separated list, e.g., -Djfxmedia.platforms=GSTPlatform,OSXPlatform
        enabledPlatforms = System.getProperty("jfxmedia.platforms", "").toLowerCase();
    }

    private static boolean isPlatformEnabled(String name) {
        if (null == enabledPlatforms || enabledPlatforms.length() == 0) {
            // everything enabled
            return true;
        }
        return (enabledPlatforms.indexOf(name.toLowerCase()) != -1);
    }

    private static final class PlatformManagerInitializer {
        private static final PlatformManager globalInstance = new PlatformManager();
    }

    public static PlatformManager getManager() {
        return PlatformManagerInitializer.globalInstance;
    }

    private final List<Platform> platforms;

    private PlatformManager() {
        platforms = new ArrayList<Platform>();

        Platform platty;

        /*
         * We don't want to fully initialize the platforms here for performance
         * reasons but some platforms may be dependent on native resources that
         * need to be loaded, those platforms need to be given a chance to load
         * those resources (without initializing) and determine if the natives
         * are available.
         */

        // Now "universal" platform(s)
        if (isPlatformEnabled("JavaPlatform")) {
            platty = JavaPlatform.getPlatformInstance();
            if (null != platty) {
                platforms.add(platty);
            }
        }

        if (!HostUtils.isIOS() && isPlatformEnabled("GSTPlatform")) {
            platty = GSTPlatform.getPlatformInstance();
            if (null != platty) {
                platforms.add(platty);
            }
        }

        // Add after GSTPlatform so it's used as a fallback
        if (HostUtils.isMacOSX() && isPlatformEnabled("OSXPlatform")) {
            platty = OSXPlatform.getPlatformInstance();
            if (null != platty) {
                platforms.add(platty);
            }
        }

        if (HostUtils.isIOS() && isPlatformEnabled("IOSPlatform")) {
            platty = IOSPlatform.getPlatformInstance();
            if (null != platty) {
                platforms.add(platty);
            }
        }

        if (Logger.canLog(Logger.DEBUG)) {
            StringBuilder sb = new StringBuilder("Enabled JFXMedia platforms: ");
            for (Platform p : platforms) {
                sb.append("\n   - ");
                sb.append(p.getClass().getName());
            }
            Logger.logMsg(Logger.DEBUG, sb.toString());
        }
    }

    public synchronized void loadPlatforms() {
        // Use an iterator so we can remove on failure
        Iterator<Platform> iter = platforms.iterator();
        while (iter.hasNext()) {
            Platform platty = iter.next();
            if (!platty.loadPlatform()) {
                if (Logger.canLog(Logger.DEBUG)) {
                    Logger.logMsg(Logger.DEBUG, "Failed to load platform: "+platty);
                }
                // remove it so it can't be reused
                iter.remove();
            }
        }
    }

    public List<String> getSupportedContentTypes() {
        ArrayList<String> outTypes = new ArrayList<String>();

        if (!platforms.isEmpty()) {
            for (Platform platty : platforms) {
                if (Logger.canLog(Logger.DEBUG)) {
                    Logger.logMsg(Logger.DEBUG, "Getting content types from platform: "+platty);
                }
                String[] npt = platty.getSupportedContentTypes();
                if (npt != null) {
                    for (String type : npt) {
                        if (!outTypes.contains(type)) {
                            outTypes.add(type);
                        }
                    }
                }
            }
        }

        return outTypes;
    }

    public List<String> getSupportedProtocols() {
        ArrayList<String> outProtocols = new ArrayList<String>();

        if (!platforms.isEmpty()) {
            for (Platform platty : platforms) {
                String[] npt = platty.getSupportedProtocols();
                if (npt != null) {
                    for (String p : npt) {
                        if (!outProtocols.contains(p)) {
                            outProtocols.add(p);
                        }
                    }
                }
            }
        }

        return outProtocols;
    }

    public MetadataParser createMetadataParser(Locator source) {
        for (Platform platty : platforms) {
            MetadataParser parser = platty.createMetadataParser(source);
            if (parser != null) {
                return parser;
            }
        }

        return null;
    }

    // FIXME: Make Media non-platform specific, it doesn't need to be
    public Media createMedia(Locator source) {
        String mimeType = source.getContentType();
        String protocol = source.getProtocol();
        // go down the list until we get one that can be created
        for (Platform platty : platforms) {
            if (platty.canPlayContentType(mimeType) && platty.canPlayProtocol(protocol)) {
                Media outMedia = platty.createMedia(source);
                if (null != outMedia) {
                    return outMedia;
                }
            }
        }

        return null;
    }

    public MediaPlayer createMediaPlayer(Locator source) {
        String mimeType = source.getContentType();
        String protocol = source.getProtocol();
        // go down the list until we get one that can be created
        for (Platform platty : platforms) {
            if (platty.canPlayContentType(mimeType) && platty.canPlayProtocol(protocol)) {
                MediaPlayer outPlayer = platty.createMediaPlayer(source);
                if (null != outPlayer) {
                    return outPlayer;
                }
            }
        }

        return null;
    }
}
