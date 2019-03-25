/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.replacements.processor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic.Kind;

/**
 * Pretty much copied from HotSpotSignature but using a different method for resolving types. This
 * class should be rewritten, its just a quick hack to get signatures working.
 */
final class APHotSpotSignature {

    private final List<String> arguments = new ArrayList<>();
    private final String returnType;
    private final String originalString;
    private TypeMirror[] argumentTypes;
    private TypeMirror returnTypeCache;

    APHotSpotSignature(String signature) {
        assert signature.length() > 0;
        this.originalString = signature;

        if (signature.charAt(0) == '(') {
            int cur = 1;
            while (cur < signature.length() && signature.charAt(cur) != ')') {
                int nextCur = parseSignature(signature, cur);
                arguments.add(signature.substring(cur, nextCur));
                cur = nextCur;
            }

            cur++;
            int nextCur = parseSignature(signature, cur);
            returnType = signature.substring(cur, nextCur);
            if (nextCur != signature.length()) {
                throw new RuntimeException("Invalid trailing characters.");
            }
        } else {
            returnType = null;
        }
    }

    private static int parseSignature(String signature, int start) {
        int cur = start;
        char first;
        do {
            first = signature.charAt(cur++);
        } while (first == '[');

        switch (first) {
            case 'L':
                while (signature.charAt(cur) != ';') {
                    cur++;
                }
                cur++;
                break;
            case 'V':
            case 'I':
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'J':
            case 'S':
            case 'Z':
                break;
            default:
                throw new RuntimeException("Invalid character at index " + cur + " in signature: " + signature);
        }
        return cur;
    }

    public int getParameterCount(boolean withReceiver) {
        return arguments.size() + (withReceiver ? 1 : 0);
    }

    public TypeMirror getParameterType(ProcessingEnvironment env, int index) {
        if (argumentTypes == null) {
            argumentTypes = new TypeMirror[arguments.size()];
        }
        TypeMirror type = argumentTypes[index];
        if (arguments.get(index) == null) {
            throw new RuntimeException(String.format("Invalid argument at index %s.", index));
        }

        if (type == null) {
            argumentTypes[index] = lookupType(env, arguments.get(index));
        }
        return argumentTypes[index];
    }

    private static TypeMirror lookupType(ProcessingEnvironment env, String binaryName) {
        if (binaryName.length() == 1) {
            TypeKind kind = fromPrimitiveOrVoidTypeChar(binaryName.charAt(0));
            if (kind.isPrimitive()) {
                return env.getTypeUtils().getPrimitiveType(kind);
            } else if (kind == TypeKind.VOID) {
                return env.getTypeUtils().getNoType(kind);
            }
        }

        String canonicalName = binaryName;
        if (canonicalName.startsWith("L") && canonicalName.endsWith(";")) {
            canonicalName = canonicalName.substring(1, canonicalName.length() - 1);
        }
        env.getMessager().printMessage(Kind.ERROR, canonicalName);

        int arrayDims = 0;
        while (canonicalName.startsWith("[")) {
            canonicalName = canonicalName.substring(1, canonicalName.length());
            arrayDims++;
        }

        canonicalName = canonicalName.replaceAll("/", ".");
        TypeElement typeElement = env.getElementUtils().getTypeElement(canonicalName);
        if (typeElement == null) {
            throw new RuntimeException(String.format("Type with name %s not found.", canonicalName));
        }
        TypeMirror mirror = typeElement.asType();
        for (int i = 0; i < arrayDims; i++) {
            mirror = env.getTypeUtils().getArrayType(mirror);
        }
        return mirror;
    }

    /**
     * Returns the kind from the character describing a primitive or void.
     *
     * @param ch the character
     * @return the kind
     */
    public static TypeKind fromPrimitiveOrVoidTypeChar(char ch) {
        switch (ch) {
            case 'Z':
                return TypeKind.BOOLEAN;
            case 'C':
                return TypeKind.CHAR;
            case 'F':
                return TypeKind.FLOAT;
            case 'D':
                return TypeKind.DOUBLE;
            case 'B':
                return TypeKind.BYTE;
            case 'S':
                return TypeKind.SHORT;
            case 'I':
                return TypeKind.INT;
            case 'J':
                return TypeKind.LONG;
            case 'V':
                return TypeKind.VOID;
        }
        throw new IllegalArgumentException("unknown primitive or void type character: " + ch);
    }

    public TypeMirror getReturnType(ProcessingEnvironment env) {
        if (returnTypeCache == null) {
            if (returnType == null) {
                throw new RuntimeException("Invalid return type.");
            }
            returnTypeCache = lookupType(env, returnType);
        }
        return returnTypeCache;
    }

    @Override
    public String toString() {
        return "Signature<" + originalString + ">";
    }
}
