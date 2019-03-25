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


package org.graalvm.compiler.core.common.spi;

import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.options.Option;
import org.graalvm.compiler.options.OptionKey;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaType;
import jdk.vm.ci.meta.MetaAccessProvider;
import jdk.vm.ci.meta.ResolvedJavaField;
import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * Utility for default constant folding semantics for Java fields.
 */
public abstract class JavaConstantFieldProvider implements ConstantFieldProvider {

    static class Options {
        @Option(help = "Determines whether to treat final fields with default values as constant.")//
        public static final OptionKey<Boolean> TrustFinalDefaultFields = new OptionKey<>(true);
    }

    protected JavaConstantFieldProvider(MetaAccessProvider metaAccess) {
        try {
            this.stringValueField = metaAccess.lookupJavaField(String.class.getDeclaredField("value"));
            this.stringHashField = metaAccess.lookupJavaField(String.class.getDeclaredField("hash"));
        } catch (NoSuchFieldException | SecurityException e) {
            throw new GraalError(e);
        }
    }

    @Override
    public <T> T readConstantField(ResolvedJavaField field, ConstantFieldTool<T> tool) {
        if (isStableField(field, tool)) {
            JavaConstant value = tool.readValue();
            if (value != null && isStableFieldValueConstant(field, value, tool)) {
                return foldStableArray(value, field, tool);
            }
        }
        if (isFinalField(field, tool)) {
            JavaConstant value = tool.readValue();
            if (value != null && isFinalFieldValueConstant(field, value, tool)) {
                return tool.foldConstant(value);
            }
        }
        return null;
    }

    protected <T> T foldStableArray(JavaConstant value, ResolvedJavaField field, ConstantFieldTool<T> tool) {
        return tool.foldStableArray(value, getArrayDimension(field.getType()), isDefaultStableField(field, tool));
    }

    private static int getArrayDimension(JavaType type) {
        int dimensions = 0;
        JavaType componentType = type;
        while ((componentType = componentType.getComponentType()) != null) {
            dimensions++;
        }
        return dimensions;
    }

    private static boolean isArray(ResolvedJavaField field) {
        JavaType fieldType = field.getType();
        return fieldType instanceof ResolvedJavaType && ((ResolvedJavaType) fieldType).isArray();
    }

    @SuppressWarnings("unused")
    protected boolean isStableFieldValueConstant(ResolvedJavaField field, JavaConstant value, ConstantFieldTool<?> tool) {
        return !value.isDefaultForKind();
    }

    @SuppressWarnings("unused")
    protected boolean isFinalFieldValueConstant(ResolvedJavaField field, JavaConstant value, ConstantFieldTool<?> tool) {
        return !value.isDefaultForKind() || Options.TrustFinalDefaultFields.getValue(tool.getOptions());
    }

    @SuppressWarnings("unused")
    protected boolean isStableField(ResolvedJavaField field, ConstantFieldTool<?> tool) {
        if (isSyntheticEnumSwitchMap(field)) {
            return true;
        }
        if (isWellKnownImplicitStableField(field)) {
            return true;
        }
        if (field.equals(stringHashField)) {
            return true;
        }
        return false;
    }

    protected boolean isDefaultStableField(ResolvedJavaField field, ConstantFieldTool<?> tool) {
        assert isStableField(field, tool);
        if (isSyntheticEnumSwitchMap(field)) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("unused")
    protected boolean isFinalField(ResolvedJavaField field, ConstantFieldTool<?> tool) {
        return field.isFinal();
    }

    protected boolean isSyntheticEnumSwitchMap(ResolvedJavaField field) {
        if (field.isSynthetic() && field.isStatic() && isArray(field)) {
            String name = field.getName();
            if (field.isFinal() && name.equals("$VALUES") || name.equals("ENUM$VALUES")) {
                // generated int[] field for EnumClass::values()
                return true;
            } else if (name.startsWith("$SwitchMap$") || name.startsWith("$SWITCH_TABLE$")) {
                // javac and ecj generate a static field in an inner class for a switch on an enum
                // named $SwitchMap$p$k$g$EnumClass and $SWITCH_TABLE$p$k$g$EnumClass, respectively
                return true;
            }
        }
        return false;
    }

    private final ResolvedJavaField stringValueField;
    private final ResolvedJavaField stringHashField;

    protected boolean isWellKnownImplicitStableField(ResolvedJavaField field) {
        return field.equals(stringValueField);
    }
}
