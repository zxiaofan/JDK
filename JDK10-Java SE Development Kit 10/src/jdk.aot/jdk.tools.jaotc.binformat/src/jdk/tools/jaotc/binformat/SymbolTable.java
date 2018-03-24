/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

public interface SymbolTable {
    void addSymbol(Symbol symInfo);

    Symbol getSymbol(String symName);

    Symbol createSymbol(int offset, Symbol.Kind kind, Symbol.Binding binding, int size, String name);
}
