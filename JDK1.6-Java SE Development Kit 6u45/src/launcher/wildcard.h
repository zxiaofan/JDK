/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

#ifndef WILDCARD_H_
#define WILDCARD_H_

#ifdef EXPAND_CLASSPATH_WILDCARDS
const char *JLI_WildcardExpandClasspath(const char *classpath);
#else
#define JLI_WildcardExpandClasspath(s) (s)
#endif

#endif /* include guard */
