/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

#ifndef _JAVA_H_
#define _JAVA_H_

/*
 * Get system specific defines.
 */
#include "jni.h"
#include "java_md.h"
#include "jli_util.h"

/*
 * Pointers to the needed JNI invocation API, initialized by LoadJavaVM.
 */
typedef jint (JNICALL *CreateJavaVM_t)(JavaVM **pvm, void **env, void *args);
typedef jint (JNICALL *GetDefaultJavaVMInitArgs_t)(void *args);

typedef struct {
    CreateJavaVM_t CreateJavaVM;
    GetDefaultJavaVMInitArgs_t GetDefaultJavaVMInitArgs;
} InvocationFunctions;

/*
 * Prototypes for launcher functions in the system specific java_md.c.
 */

jboolean
LoadJavaVM(const char *jvmpath, InvocationFunctions *ifn);

void
GetXUsagePath(char *buf, jint bufsize);

jboolean
GetApplicationHome(char *buf, jint bufsize);

const char *
GetArch();

void CreateExecutionEnvironment(int *_argc,
				       char ***_argv,
				       char jrepath[],
				       jint so_jrepath,
				       char jvmpath[],
				       jint so_jvmpath,
				       char **original_argv);

/*
 * Report an error message to stderr or a window as appropriate.  The
 * flag always is set to JNI_TRUE if message is to be reported to both
 * strerr and windows and set to JNI_FALSE if the message should only
 * be sent to a window.
 */
void ReportErrorMessage(char * message, jboolean always);
void ReportErrorMessage2(char * format, char * string, jboolean always);

/*
 * Report an exception which terminates the vm to stderr or a window
 * as appropriate.
 */
void ReportExceptionDescription(JNIEnv * env);

jboolean RemovableMachineDependentOption(char * option);
void PrintMachineDependentOptions();

const char *jlong_format_specifier();
/*
 * Block current thread and continue execution in new thread
 */
int ContinueInNewThread(int (JNICALL *continuation)(void *), 
                        jlong stack_size, void * args);

/* sun.java.launcher.* platform properties. */
void SetJavaLauncherPlatformProps(void);

/* 
 * Functions defined in java.c and used in java_md.c.
 */
jint ReadKnownVMs(const char *jrepath, char * arch, jboolean speculative); 
char *CheckJvmType(int *argc, char ***argv, jboolean speculative);
void AddOption(char *str, void *info);

/*
 * Make launcher spit debug output.
 */
extern jboolean _launcher_debug;

#endif /* _JAVA_H_ */
