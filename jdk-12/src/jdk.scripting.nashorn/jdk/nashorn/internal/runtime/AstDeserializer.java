/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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
package jdk.nashorn.internal.runtime;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.zip.InflaterInputStream;
import jdk.nashorn.internal.ir.FunctionNode;

/**
 * This static utility class performs deserialization of FunctionNode ASTs from a byte array.
 * The format is a standard Java serialization stream, deflated.
 */
final class AstDeserializer {
    static FunctionNode deserialize(final byte[] serializedAst) {
        return AccessController.doPrivileged(new PrivilegedAction<FunctionNode>() {
            @Override
            public FunctionNode run() {
                try {
                    return (FunctionNode)new ObjectInputStream(new InflaterInputStream(
                        new ByteArrayInputStream(serializedAst))).readObject();
                } catch (final ClassNotFoundException | IOException e) {
                    // This is internal, can't happen
                    throw new AssertionError("Unexpected exception deserializing function", e);
                }
            }
        });
    }
}
