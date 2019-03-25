/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.graphbuilderconf;

import org.graalvm.compiler.core.common.type.StampPair;
import org.graalvm.compiler.nodes.calc.FloatingNode;

public interface ParameterPlugin extends GraphBuilderPlugin {

    FloatingNode interceptParameter(GraphBuilderTool b, int index, StampPair stamp);
}
