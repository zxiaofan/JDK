/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdi;

/**
 * This class is used by the back end to do thread synchronization.
 * We don't want to use java.lang.Object(s) for two reasons: we can't
 * filter them out, and this class should use less heap.
 */

public class LockObject {
}
