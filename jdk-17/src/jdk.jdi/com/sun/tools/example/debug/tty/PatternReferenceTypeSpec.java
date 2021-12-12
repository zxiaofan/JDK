/*
 * Copyright (c) 1998, 2020, Oracle and/or its affiliates. All rights reserved.
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

/*
 * This source code is provided to illustrate the usage of a given feature
 * or technique and has been deliberately simplified. Additional steps
 * required for a production-quality application, such as security checks,
 * input validation and proper error handling, might not be present in
 * this sample code.
 */


package com.sun.tools.example.debug.tty;

import com.sun.jdi.*;
import com.sun.jdi.request.ClassPrepareRequest;
import java.util.StringTokenizer;


class PatternReferenceTypeSpec implements ReferenceTypeSpec {
    final String classId;
    String stem;

    PatternReferenceTypeSpec(String classId) throws ClassNotFoundException {
        this.classId = classId;
        stem = classId;
        if (classId.startsWith("*")) {
            stem = stem.substring(1);
        } else if (classId.endsWith("*")) {
            stem = stem.substring(0, classId.length() - 1);
        }
        checkClassName(stem);
    }

    /**
     * Is this spec unique or is it a class pattern?
     */
    public boolean isUnique() {
        return classId.equals(stem);
    }

    /**
     * Does the specified ReferenceType match this spec.
     */
    @Override
    public boolean matches(ReferenceType refType) {
        if (classId.startsWith("*")) {
            return refType.name().endsWith(stem);
        } else if (classId.endsWith("*")) {
            return refType.name().startsWith(stem);
        } else {
            return refType.name().equals(classId);
        }
    }

    @Override
    public ClassPrepareRequest createPrepareRequest() {
        ClassPrepareRequest request =
            Env.vm().eventRequestManager().createClassPrepareRequest();
        request.addClassFilter(classId);
        request.addCountFilter(1);
        return request;
    }

    @Override
    public int hashCode() {
        return classId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PatternReferenceTypeSpec) {
            PatternReferenceTypeSpec spec = (PatternReferenceTypeSpec)obj;

            return classId.equals(spec.classId);
        } else {
            return false;
        }
    }

    private void checkClassName(String className) throws ClassNotFoundException {
        int slashIdx = className.indexOf("/");

        // Slash is present in hidden class names only. It looks like p.Foo/0x1234.
        if (slashIdx != -1) {
            // A hidden class name is ending with a slash following by a suffix.
            int lastSlashIdx = className.lastIndexOf("/");
            int lastDotIdx = className.lastIndexOf(".");

            // There must be just one slash with a following suffix but no dots.
            if (slashIdx != lastSlashIdx || lastDotIdx > slashIdx || slashIdx + 1 == className.length()) {
                throw new ClassNotFoundException();
            }
            // Check prefix and suffix separately.
            String[] parts = className.split("/");
            assert parts.length == 2;
            className = parts[0];
            String hcSuffix = parts[1];
            if (!isUnqualifiedName(hcSuffix)) {
                throw new ClassNotFoundException();
            }
        }

        // Do stricter checking of class name validity on deferred
        //  because if the name is invalid, it will
        // never match a future loaded class, and we'll be silent
        // about it.
        StringTokenizer tokenizer = new StringTokenizer(className, ".");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            // Each dot-separated piece must be a valid identifier
            // and the first token can also be "*". (Note that
            // numeric class ids are not permitted. They must
            // match a loaded class.)
            if (!isJavaIdentifier(token)) {
                throw new ClassNotFoundException();
            }
        }
    }

    private boolean isUnqualifiedName(String s) {
        if (s.length() == 0) {
            return false;
        }
        // unqualified names should have no characters: ".;/["
        return !s.matches("[.;/\091]*"); // \091 is '['
    }

    private boolean isJavaIdentifier(String s) {
        if (s.length() == 0) {
            return false;
        }

        int cp = s.codePointAt(0);
        if (! Character.isJavaIdentifierStart(cp)) {
            return false;
        }

        for (int i = Character.charCount(cp); i < s.length(); i += Character.charCount(cp)) {
            cp = s.codePointAt(i);
            if (! Character.isJavaIdentifierPart(cp)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return classId;
    }
}
