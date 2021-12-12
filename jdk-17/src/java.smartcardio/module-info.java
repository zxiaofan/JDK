/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Defines the Java Smart Card I/O API.
 *
 * @moduleGraph
 * @since 9
 */
module java.smartcardio {
    exports javax.smartcardio;

    provides java.security.Provider with
        sun.security.smartcardio.SunPCSC;
}

