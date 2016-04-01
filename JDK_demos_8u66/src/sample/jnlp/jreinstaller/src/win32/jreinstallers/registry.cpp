/*
 * Copyright (c) 2006, 2010, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 * -Redistribution in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * Neither the name of Oracle nor the names of contributors may
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any kind. ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MICROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */

#include <jni.h>
#include <windows.h>
#include <winreg.h>
#include <stdio.h>


/* This is the default buffer size used for RegQueryValue values.
 */
#define DEFAULT_ALLOC MAX_PATH


/* We'll only allocate a buffer as big as MAX_ALLOC for RegQueryValue values.
 */
#define MAX_ALLOC 262144


static jclass keyValueClass;
static jmethodID keyValueCtorID;


extern "C" {

JNIEXPORT void JNICALL Java_jnlp_sample_JreInstaller_WinRegistry_initIDs
  (JNIEnv *env, jclass)
{
    jclass keyValueClassLref = env->FindClass("jnlp/JreInstaller/WinRegistry$KeyValue");
    if (keyValueClassLref == NULL) {
        return;  /* exception thrown */
    }
    keyValueClass = (jclass)(env->NewGlobalRef(keyValueClassLref));
    if (keyValueClass == NULL) {
        return;  /* exception thrown */
    }

    keyValueCtorID = env->GetMethodID(keyValueClass, "<init>", "(I[B)V");
    if (keyValueCtorID == NULL) {
        return;  /* exception thrown */
    }
}


/*
 * Call RegOpenKeyExA (the ascii version of RegOpenKeyEx) and return
 * the open HKEY or 0 if something goes wrong.
 */
JNIEXPORT jint JNICALL Java_jnlp_sample_JreInstaller_WinRegistry_sysOpenKey
  (JNIEnv *env, jclass, jint hKey, jstring subKey, jint sam)
{
    const char *subKeyStr = env->GetStringUTFChars(subKey, NULL);
    if (subKeyStr == NULL) {
        return 0;  /* exception thrown */
    }
    HKEY hKeyResult = 0;
    int err = RegOpenKeyExA((HKEY)hKey, subKeyStr, 0, sam, &hKeyResult);
    env->ReleaseStringUTFChars(subKey, subKeyStr);
    return (err == NO_ERROR) ? (jint)hKeyResult : 0;
}


JNIEXPORT jint JNICALL Java_jnlp_sample_JreInstaller_WinRegistry_sysCloseKey
  (JNIEnv *, jclass, jint hKey)
{
    return RegCloseKey((HKEY)hKey);
}


/*
 * Call RegQueryValueExA (the ascii version of RegQueryValueEx) and
 * return a Registry.KeyValue object that contains the returned
 * binary value (as an array of bytes) and integer type code.  Note
 * that this function will potentially make two attempts to get the
 * value: 1st with a DEFAULT_ALLOC sized stack allocated buffer and,
 * if that fails because the buffer isn't large enough, with
 * a MAX_ALLOC sized buffer.
 *
 * If the key can't be found or any other error occurs in the
 * RegQueryValueEx call, then return NULL.
 */
JNIEXPORT jobject JNICALL Java_jnlp_sample_JreInstaller_WinRegistry_sysQueryKey
  (JNIEnv *env, jclass, jint hKey, jstring name)
{
    const char *nameStr = env->GetStringUTFChars(name, NULL);
    if (name == NULL) {
        return NULL;  /* exception thrown */
    }

    DWORD dataType, dataLength = DEFAULT_ALLOC;
    BYTE dataBuffer[DEFAULT_ALLOC], *data = dataBuffer;
    BOOL freeData = FALSE;
    int err = RegQueryValueExA((HKEY)hKey, nameStr, 0, &dataType, data, &dataLength);
    if (err == ERROR_MORE_DATA) {
        if ((dataLength <= 0) || (dataLength > MAX_ALLOC)) {
            return NULL;
        }
        else if ((data = (BYTE *)malloc(dataLength)) == NULL) {
            return NULL;
        }
        freeData = TRUE;
        err = RegQueryValueExA((HKEY)hKey, nameStr, 0, &dataType, data, &dataLength);
    }

    env->ReleaseStringUTFChars(name, nameStr);

    if (err != ERROR_SUCCESS) {
        return NULL;
    }

    jbyteArray dataArray = env->NewByteArray(dataLength);
    if (dataArray == NULL) {
        if (freeData) {
            free(data);
        }
        return NULL;  /* exception thrown */
    }
    env->SetByteArrayRegion(dataArray, 0, dataLength, (jbyte *)data);

    if (freeData) {
        free(data);
    }

    return env->NewObject(keyValueClass, keyValueCtorID, dataType, dataArray);
}


/**
 * Returns the value returned by the Win32 GetWindowsDirectory() function
 * or NULL.  On NT this is typically "C:\WINNT".
 */
JNIEXPORT jstring JNICALL Java_jnlp_sample_JreInstaller_WinRegistry_getWindowsDirectory
  (JNIEnv *env, jclass)
{
    char path[MAX_PATH];
    UINT n = GetWindowsDirectory(path, MAX_PATH);
    if ((n == 0) || (n >= MAX_PATH)) {
        return NULL;
    }
    else {
        return env->NewStringUTF(path);
    }
}


/*
 * Creates a new key in the registry at the passed in path.
 */
JNIEXPORT jint JNICALL Java_jnlp_sample_JreInstaller_WinRegistry_sysCreateKey
  (JNIEnv *env, jclass, jint hKey, jstring path, jint sam)
{
    const char *pathStr = env->GetStringUTFChars(path, NULL);
    if (pathStr == NULL) {
        return 0;  /* exception thrown */
    }
    HKEY hKeyResult = 0;
    DWORD disposition;
    int err = RegCreateKeyEx((HKEY)hKey, pathStr, 0, "REG_SZ",
                             REG_OPTION_NON_VOLATILE, sam, NULL,
                             &hKeyResult, &disposition);
    env->ReleaseStringUTFChars(path, pathStr);
    return (err == NO_ERROR) ? (jint)hKeyResult : 0;
}

/*
 * Sets the value of a particular key.
 */
JNIEXPORT jboolean JNICALL Java_jnlp_sample_JreInstaller_WinRegistry_sysSetStringValue
  (JNIEnv *env, jclass, jint hKey, jstring name, jstring value)
{
    const char *nameStr = env->GetStringUTFChars(name, NULL);
    if (nameStr == NULL) {
        return 0;  /* exception thrown */
    }
    const char *valueStr = env->GetStringUTFChars(value, NULL);
    if (valueStr == NULL) {
        env->ReleaseStringUTFChars(name, nameStr);
        return 0;  /* exception thrown */
    }
    HKEY hKeyResult = 0;
    int err = RegSetValueEx((HKEY)hKey, nameStr, 0, REG_SZ,
                            (const unsigned char *)valueStr,
                            strlen(valueStr) + 1);
    env->ReleaseStringUTFChars(name, nameStr);
    env->ReleaseStringUTFChars(value, valueStr);
    return (err == NO_ERROR) ? JNI_TRUE : JNI_FALSE;
}

/*
 * Sets the value of a particular key.
 */
JNIEXPORT jboolean JNICALL Java_jnlp_sample_JreInstaller_WinRegistry_sysDeleteKey
  (JNIEnv *env, jclass, jint hKey, jstring subKey)
{
    const char *subKeyStr = env->GetStringUTFChars(subKey, NULL);
    if (subKeyStr == NULL) {
        return 0;  /* exception thrown */
    }
    HKEY hKeyResult = 0;
    int err = RegDeleteKey((HKEY)hKey, subKeyStr);
    env->ReleaseStringUTFChars(subKey, subKeyStr);
    return (err == NO_ERROR) ? JNI_TRUE : JNI_FALSE;
}

/*
 * Reboots Windows
 */
JNIEXPORT jboolean JNICALL Java_jnlp_sample_JreInstaller_WinRegistry_sysReboot
  (JNIEnv *env, jclass)
{
  HANDLE tokenHandle;
  LUID luid;
  TOKEN_PRIVILEGES tpriv;

  // Give our token the SHUTDOWN privilege
  if (!OpenProcessToken(GetCurrentProcess(),
                        TOKEN_ADJUST_PRIVILEGES,
                        &tokenHandle)) {
    if (GetLastError()!=ERROR_CALL_NOT_IMPLEMENTED) {
      return JNI_FALSE;
    }
  } else {
    if (!LookupPrivilegeValue(NULL, SE_SHUTDOWN_NAME, &luid)) {
      // non NT should return CALL NOT IMPLEMENTED
      // fail silently in this case
      if (GetLastError()!=ERROR_CALL_NOT_IMPLEMENTED) {
        return JNI_FALSE;
      }
    } else {
      tpriv.PrivilegeCount=1;
      tpriv.Privileges[0].Luid=luid;
      tpriv.Privileges[0].Attributes=SE_PRIVILEGE_ENABLED;
      if (!AdjustTokenPrivileges(tokenHandle, FALSE, &tpriv, 0,NULL,NULL)) {
        if (GetLastError()!=ERROR_CALL_NOT_IMPLEMENTED) {
          return JNI_FALSE;
        }
      }
    }
  }

  if (SUCCEEDED(ExitWindowsEx(EWX_REBOOT, NULL))) return JNI_TRUE;
  else return JNI_FALSE;

}

} /* extern "C" */
