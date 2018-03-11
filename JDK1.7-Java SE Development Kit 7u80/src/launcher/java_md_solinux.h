/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

#ifndef JAVA_MD_SOLINUX_H
#define JAVA_MD_SOLINUX_H

#ifdef HAVE_GETHRTIME
/*
 * Support for doing cheap, accurate interval timing.
 */
#include <sys/time.h>
#define CounterGet()              (gethrtime()/1000)
#define Counter2Micros(counts)    (counts)
#else  /* ! HAVE_GETHRTIME */
#define CounterGet()              (0)
#define Counter2Micros(counts)    (1)
#endif /* HAVE_GETHRTIME */

/* pointer to environment */
extern char **environ;

/*
 *      A collection of useful strings. One should think of these as #define
 *      entries, but actual strings can be more efficient (with many compilers).
 */
#ifdef __linux__
static const char *system_dir   = "/usr/java";
static const char *user_dir     = "/java";
#else /* Solaris */
static const char *system_dir   = "/usr/jdk";
static const char *user_dir     = "/jdk";
#endif

#include <dlfcn.h>
#ifdef __solaris__
#include <thread.h>
#else
#include <pthread.h>
#endif

#define JVM_DLL         "libjvm.so"
#define JAVA_DLL        "libjava.so"
#define LD_LIBRARY_PATH "LD_LIBRARY_PATH"

#endif /* JAVA_MD_SOLINUX_H */
