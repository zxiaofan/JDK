/*
 * Copyright (c) 2008, 2011, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.invoke;

import static java.lang.invoke.LambdaForm.*;
import static java.lang.invoke.MethodHandleNatives.Constants.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A method handle whose behavior is determined only by its LambdaForm.
 * @author jrose
 */
final class SimpleMethodHandle extends MethodHandle {
    private SimpleMethodHandle(MethodType type, LambdaForm form) {
        super(type, form);
    }

    /*non-public*/ static SimpleMethodHandle make(MethodType type, LambdaForm form) {
        return new SimpleMethodHandle(type, form);
    }

    @Override
    MethodHandle bindArgument(int pos, char basicType, Object value) {
        MethodType type2 = type().dropParameterTypes(pos, pos+1);
        LambdaForm form2 = internalForm().bind(1+pos, BoundMethodHandle.SpeciesData.EMPTY);
        return BoundMethodHandle.bindSingle(type2, form2, basicType, value);
    }

    @Override
    MethodHandle dropArguments(MethodType srcType, int pos, int drops) {
        LambdaForm newForm = internalForm().addArguments(pos, srcType.parameterList().subList(pos, pos+drops));
        return new SimpleMethodHandle(srcType, newForm);
    }

    @Override
    MethodHandle permuteArguments(MethodType newType, int[] reorder) {
        LambdaForm form2 = internalForm().permuteArguments(1, reorder, basicTypes(newType.parameterList()));
        return new SimpleMethodHandle(newType, form2);
    }

    @Override
    MethodHandle copyWith(MethodType mt, LambdaForm lf) {
        return new SimpleMethodHandle(mt, lf);
    }

}
