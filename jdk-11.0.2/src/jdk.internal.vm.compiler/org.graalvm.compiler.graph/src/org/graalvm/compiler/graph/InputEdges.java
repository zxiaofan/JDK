/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.graph;

import static org.graalvm.compiler.graph.Edges.Type.Inputs;

import java.util.ArrayList;

import org.graalvm.compiler.graph.NodeClass.InputInfo;
import org.graalvm.compiler.nodeinfo.InputType;

public final class InputEdges extends Edges {

    private final InputType[] inputTypes;
    private final boolean[] isOptional;

    public InputEdges(int directCount, ArrayList<InputInfo> edges) {
        super(Inputs, directCount, edges);

        this.inputTypes = new InputType[edges.size()];
        this.isOptional = new boolean[edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            this.inputTypes[i] = edges.get(i).inputType;
            this.isOptional[i] = edges.get(i).optional;
        }
    }

    public static void translateInto(InputEdges inputs, ArrayList<InputInfo> infos) {
        for (int index = 0; index < inputs.getCount(); index++) {
            infos.add(new InputInfo(inputs.offsets[index], inputs.getName(index), inputs.getType(index), inputs.getDeclaringClass(index), inputs.inputTypes[index], inputs.isOptional(index)));
        }
    }

    public InputType getInputType(int index) {
        return inputTypes[index];
    }

    public boolean isOptional(int index) {
        return isOptional[index];
    }

    @Override
    public void update(Node node, Node oldValue, Node newValue) {
        node.updateUsages(oldValue, newValue);
    }
}
