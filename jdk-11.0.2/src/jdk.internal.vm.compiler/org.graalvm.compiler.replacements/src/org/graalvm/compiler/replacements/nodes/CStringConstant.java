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


package org.graalvm.compiler.replacements.nodes;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import org.graalvm.compiler.core.common.type.DataPointerConstant;
import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node.ConstantNodeParameter;
import org.graalvm.compiler.graph.Node.NodeIntrinsic;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Represents a compile-time constant zero-terminated UTF-8 string installed with the generated
 * code.
 */
public final class CStringConstant extends DataPointerConstant {

    private static final Charset UTF8 = Charset.forName("utf8");

    private final String string;

    public CStringConstant(String string) {
        super(1);
        assert string != null;
        this.string = string;
    }

    @Override
    public int getSerializedSize() {
        return string.getBytes(UTF8).length + 1;
    }

    @Override
    public void serialize(ByteBuffer buffer) {
        byte[] bytes = string.getBytes(UTF8);
        buffer.put(bytes);
        buffer.put((byte) 0);
    }

    @Override
    public String toValueString() {
        return "c\"" + string + "\"";
    }

    public static boolean intrinsify(GraphBuilderContext b, @SuppressWarnings("unused") ResolvedJavaMethod targetMethod, String string) {
        b.addPush(JavaKind.Object, new ConstantNode(new CStringConstant(string), StampFactory.pointer()));
        return true;
    }

    @NodeIntrinsic
    public static native Word cstring(@ConstantNodeParameter String string);
}
