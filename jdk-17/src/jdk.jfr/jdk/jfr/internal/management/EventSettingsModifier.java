/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal.management;

import java.util.Map;

/**
 * Purpose of the interface is to be able to provide an implementation of
 * EventSettings in the jdk.management.jfr module.
 *
 */
public interface EventSettingsModifier {

    void with(String name, String value);

    Map<String, String> toMap();

}
