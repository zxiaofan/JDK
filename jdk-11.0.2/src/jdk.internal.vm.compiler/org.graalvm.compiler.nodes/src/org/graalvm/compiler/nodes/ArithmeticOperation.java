/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.Op;

/**
 * An {@code ArithmeticOperation} is an operation that does primitive value arithmetic without side
 * effect.
 */
public interface ArithmeticOperation {

    Op getArithmeticOp();
}
