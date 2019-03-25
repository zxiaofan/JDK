/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.objects.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Optimistic annotation is used for builtins that can throw UnwarrantedOptimism
 * exception if they are wrong, whose callsite is optimistic and contains a program
 * point. Every optimistic builtin callsite needs to bind its programPoint to an
 * argument of the implementation at compile time
 *
 * Typical use case would be something like: if you want to do an optimistic "push" function
 * in NativeArray that takes an int, write
 *
 *  <pre>
 *  {@literal @}SpecializedFunction {@literal @}Optimistic
 *  public static int push(final Object self, final int x, final int programPoint) {
 *    try {
 *    //push code assuming that this is an int array
 *    //return new length of array, assuming it's an int
 *    } catch (ArrayWasWrong e) {
 *       //undo any array modifications
 *       throw new UnwarrantedOptimismExceptionArrayType(x, programPoint);
 *    } catch (LengthOverFlowed e) {
 *       //undo any array modifications
 *       throw new UnwarratnedOptimismExceptionArrayLength(uint32lenThatOverFlowed, programPoint)
 *    }
 *  }
 *  </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Optimistic {
    //empty
}
