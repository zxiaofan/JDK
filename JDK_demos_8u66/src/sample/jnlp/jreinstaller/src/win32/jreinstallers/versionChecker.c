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

#include <stdio.h>
#include <windows.h>

// Returns the version, as two unsigned longs, of the passed in path.
// If there is an error, or the version can't be determined, this will
// return null.
// It is the callers responsibility to free the return value if it is
// non-null.
DWORD *getVersion(const char *path) {
    int        handle;
    int        size;

    if ((size = GetFileVersionInfoSize((char *)path, &handle)) > 0) {
        void     *data;

        data = malloc(size);
        if (GetFileVersionInfo((char *)path, 0, size, data)) {
            VS_FIXEDFILEINFO     info;
            void                 *infoData;
            int                  infoLength;

            if (VerQueryValue(data, "\\", &infoData, &infoLength)) {
                VS_FIXEDFILEINFO   *defaultInfo = (VS_FIXEDFILEINFO *)infoData;
                unsigned long      *retValue = (DWORD *)malloc(sizeof(DWORD)
                                                               * 2);

                retValue[0] = defaultInfo->dwFileVersionMS;
                retValue[1] = defaultInfo->dwFileVersionLS;
                return retValue;
            }
        }
    }
    return NULL;
}

int isValidMSVCRTVersion(DWORD versionMS, DWORD versionLS) {
    static char         *DLL_NAME = "MSVCRT.DLL";
    char                *systemDir;
    char                *dllPath;
    char                buff[MAX_PATH];
    UINT                retValue = GetSystemDirectory(buff, MAX_PATH);
    int                 freeSystemDir = 0;
    DWORD               *version;
    DWORD               systemMS, systemLS;

    if (retValue > MAX_PATH) {
        systemDir = (char *)malloc(sizeof(char) * (retValue + 1));
        if (GetSystemDirectory(systemDir, retValue) != retValue) {
            free(systemDir);
            // Couldn't get system directory, assume valid
            return 1;
        }
        freeSystemDir = 1;
    }
    else if (retValue == 0) {
        // Couldn't get system directory, assume valid
        return 1;
    }
    else {
        systemDir = buff;
    }
    dllPath = (char *)malloc(sizeof(char) * (retValue + strlen(DLL_NAME) + 2));
    strncpy(dllPath, systemDir, retValue);
    if (dllPath[retValue] == '\\') {
        strcpy(dllPath + retValue, DLL_NAME);
    }
    else {
        dllPath[retValue] = '\\';
        strcpy(dllPath + retValue + 1, DLL_NAME);
    }
    version = getVersion(dllPath);
    free(dllPath);
    if (freeSystemDir) {
        free(systemDir);
    }
    if (version == NULL) {
        // No version, assume invalid
        return 0;
    }
    systemMS = version[0];
    systemLS = version[1];
    free(version);
    if (systemMS > versionMS) {
        // Newer version
        return 1;
    }
    else if (systemMS < versionMS) {
        // Older version
        return 0;
    }
    if (systemLS >= versionLS) {
        // Newer or same version
        return 1;
    }
    // Older version
    return 0;
}
