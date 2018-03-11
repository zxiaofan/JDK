/*
 * %W%	%E%
 *
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
 * Use is subject to license terms.
 */

#ifndef _JLI_UTIL_H
#define _JLI_UTIL_H

#include <stdlib.h>

void *JLI_MemAlloc(size_t size);
void *JLI_MemRealloc(void *ptr, size_t size);
char *JLI_StringDup(const char *s1);
void  JLI_MemFree(void *ptr);

#endif	/* _JLI_UTIL_H */
