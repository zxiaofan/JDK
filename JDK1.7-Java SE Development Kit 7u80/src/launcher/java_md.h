/*
 * Copyright (c) 1998, 2012, Oracle and/or its affiliates. All rights reserved.
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

#ifndef JAVA_MD_H
#define JAVA_MD_H

/*
 * This file contains common defines and includes for Solaris, Linux and MacOSX.
 */
#include <limits.h>
#include <unistd.h>
#include <sys/param.h>
#include "manifest_info.h"
#include "jli_util.h"

#define PATH_SEPARATOR          ':'
#define FILESEP                 "/"
#define FILE_SEPARATOR          '/'
#define IS_FILE_SEPARATOR(c) ((c) == '/')
#ifndef MAXNAMELEN
#define MAXNAMELEN              PATH_MAX
#endif

/*
 * Common function prototypes and sundries.
 */
char *LocateJRE(manifest_info *info);
void ExecJRE(char *jre, char **argv);
int UnsetEnv(char *name);
char *FindExecName(char *program);
const char *SetExecname(char **argv);
const char *GetExecName();
static jboolean GetJVMPath(const char *jrepath, const char *jvmtype,
                           char *jvmpath, jint jvmpathsize, const char * arch,
                           int bitsWanted);
static jboolean GetJREPath(char *path, jint pathsize, const char * arch,
                           jboolean speculative);

#ifdef MACOSX
#include "java_md_macosx.h"
#else  /* !MACOSX */
#include "java_md_solinux.h"
#endif /* MACOSX */

#endif /* JAVA_MD_H */
