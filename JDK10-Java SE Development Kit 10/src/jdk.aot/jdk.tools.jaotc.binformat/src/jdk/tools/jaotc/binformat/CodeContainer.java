/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jaotc.binformat;

/**
 * A container that holds information about code section. This is simply a ByteContainer.
 */
public final class CodeContainer extends ByteContainer {

    public CodeContainer(String containerName, SymbolTable symbolTable) {
        super(containerName, symbolTable);
    }
}
