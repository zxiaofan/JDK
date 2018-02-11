/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.hotspot;

import static jdk.vm.ci.hotspot.CompilerToVM.compilerToVM;
import static jdk.vm.ci.hotspot.HotSpotJVMCIRuntime.runtime;

import java.lang.invoke.MethodHandle;
import java.util.Objects;

import jdk.vm.ci.common.JVMCIError;
import jdk.vm.ci.meta.ConstantReflectionProvider;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.MethodHandleAccessProvider;
import jdk.vm.ci.meta.ResolvedJavaField;
import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.meta.ResolvedJavaType;

public class HotSpotMethodHandleAccessProvider implements MethodHandleAccessProvider {

    private final ConstantReflectionProvider constantReflection;

    public HotSpotMethodHandleAccessProvider(ConstantReflectionProvider constantReflection) {
        this.constantReflection = constantReflection;
    }

    /**
     * Lazy initialization to break class initialization cycle. Field and method lookup is only
     * possible after the {@link HotSpotJVMCIRuntime} is fully initialized.
     */
    static class LazyInitialization {
        static final ResolvedJavaType lambdaFormType;
        static final ResolvedJavaField methodHandleFormField;
        static final ResolvedJavaField lambdaFormVmentryField;
        static final HotSpotResolvedJavaField memberNameVmtargetField;

        /**
         * Search for an instance field with the given name in a class.
         *
         * @param declaringType the type declaring the field
         * @param fieldName name of the field to be searched
         * @param fieldType resolved Java type of the field
         * @return resolved Java field
         * @throws NoSuchFieldError
         */
        private static ResolvedJavaField findFieldInClass(ResolvedJavaType declaringType, String fieldName, ResolvedJavaType fieldType) {
            ResolvedJavaField[] fields = declaringType.getInstanceFields(false);
            for (ResolvedJavaField field : fields) {
                if (field.getName().equals(fieldName) && field.getType().equals(fieldType)) {
                    return field;
                }
            }
            throw new NoSuchFieldError(fieldType.getName() + " " + declaringType + "." + fieldName);
        }

        private static ResolvedJavaType resolveType(Class<?> c) {
            return runtime().fromClass(c);
        }

        private static ResolvedJavaType resolveType(String className) throws ClassNotFoundException {
            return resolveType(Class.forName(className));
        }

        static {
            try {
                ResolvedJavaType methodHandleType = resolveType(MethodHandle.class);
                ResolvedJavaType memberNameType = resolveType("java.lang.invoke.MemberName");
                lambdaFormType = resolveType("java.lang.invoke.LambdaForm");
                methodHandleFormField = findFieldInClass(methodHandleType, "form", lambdaFormType);
                lambdaFormVmentryField = findFieldInClass(lambdaFormType, "vmentry", memberNameType);
                memberNameVmtargetField = (HotSpotResolvedJavaField) findFieldInClass(memberNameType, "vmtarget", resolveType(long.class));
            } catch (Throwable ex) {
                throw new JVMCIError(ex);
            }
        }
    }

    @Override
    public IntrinsicMethod lookupMethodHandleIntrinsic(ResolvedJavaMethod method) {
        int intrinsicId = ((HotSpotResolvedJavaMethodImpl) method).intrinsicId();
        if (intrinsicId != 0) {
            return getMethodHandleIntrinsic(intrinsicId);
        }
        return null;
    }

    public static IntrinsicMethod getMethodHandleIntrinsic(int intrinsicId) {
        HotSpotVMConfig config = runtime().getConfig();
        if (intrinsicId == config.vmIntrinsicInvokeBasic) {
            return IntrinsicMethod.INVOKE_BASIC;
        } else if (intrinsicId == config.vmIntrinsicLinkToInterface) {
            return IntrinsicMethod.LINK_TO_INTERFACE;
        } else if (intrinsicId == config.vmIntrinsicLinkToSpecial) {
            return IntrinsicMethod.LINK_TO_SPECIAL;
        } else if (intrinsicId == config.vmIntrinsicLinkToStatic) {
            return IntrinsicMethod.LINK_TO_STATIC;
        } else if (intrinsicId == config.vmIntrinsicLinkToVirtual) {
            return IntrinsicMethod.LINK_TO_VIRTUAL;
        }
        return null;
    }

    @Override
    public ResolvedJavaMethod resolveInvokeBasicTarget(JavaConstant methodHandle, boolean forceBytecodeGeneration) {
        if (methodHandle.isNull()) {
            return null;
        }

        /* Load non-public field: LambdaForm MethodHandle.form */
        JavaConstant lambdaForm = constantReflection.readFieldValue(LazyInitialization.methodHandleFormField, methodHandle);
        if (lambdaForm == null || lambdaForm.isNull()) {
            return null;
        }

        JavaConstant memberName = constantReflection.readFieldValue(LazyInitialization.lambdaFormVmentryField, lambdaForm);
        if (memberName.isNull() && forceBytecodeGeneration) {
            Object lf = ((HotSpotObjectConstant) lambdaForm).asObject(LazyInitialization.lambdaFormType);
            compilerToVM().compileToBytecode(Objects.requireNonNull(lf));
            memberName = constantReflection.readFieldValue(LazyInitialization.lambdaFormVmentryField, lambdaForm);
            assert memberName.isNonNull();
        }
        return getTargetMethod(memberName);
    }

    @Override
    public ResolvedJavaMethod resolveLinkToTarget(JavaConstant memberName) {
        return getTargetMethod(memberName);
    }

    /**
     * Returns the {@link ResolvedJavaMethod} for the vmtarget of a java.lang.invoke.MemberName.
     */
    private static ResolvedJavaMethod getTargetMethod(JavaConstant memberName) {
        if (memberName.isNull()) {
            return null;
        }

        Object object = ((HotSpotObjectConstantImpl) memberName).object();
        /* Read the ResolvedJavaMethod from the injected field MemberName.vmtarget */
        return compilerToVM().getResolvedJavaMethod(object, LazyInitialization.memberNameVmtargetField.offset());
    }
}
