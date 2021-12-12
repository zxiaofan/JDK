/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.access;

import java.io.Console;
import java.nio.charset.Charset;

public interface JavaIOAccess {
    Console console();
    Charset charset();
}
