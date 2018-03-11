/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

#ifndef _VERSION_COMP_H
#define	_VERSION_COMP_H

/*
 * Function prototypes.
 */
int JLI_ExactVersionId(char *id1, char *id2);
int JLI_PrefixVersionId(char *id1, char *id2);
int JLI_AcceptableRelease(char *release, char *version_string);
int JLI_ValidVersionString(char *version_string);

#endif /* _VERSION_COMP_H */
