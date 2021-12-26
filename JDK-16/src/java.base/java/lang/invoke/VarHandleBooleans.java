/*
 * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package java.lang.invoke;

import jdk.internal.util.Preconditions;
import jdk.internal.vm.annotation.ForceInline;

import java.lang.invoke.VarHandle.VarHandleDesc;
import java.util.Objects;
import java.util.Optional;

import static java.lang.invoke.MethodHandleStatics.UNSAFE;

// -- This file was mechanically generated: Do not edit! -- //

final class VarHandleBooleans {

    static class FieldInstanceReadOnly extends VarHandle {
        final long fieldOffset;
        final Class<?> receiverType;

        FieldInstanceReadOnly(Class<?> receiverType, long fieldOffset) {
            this(receiverType, fieldOffset, FieldInstanceReadOnly.FORM, false);
        }

        protected FieldInstanceReadOnly(Class<?> receiverType, long fieldOffset,
                                        VarForm form, boolean exact) {
            super(form, exact);
            this.fieldOffset = fieldOffset;
            this.receiverType = receiverType;
        }

        @Override
        public FieldInstanceReadOnly withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new FieldInstanceReadOnly(receiverType, fieldOffset, vform, true);
        }

        @Override
        public FieldInstanceReadOnly withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new FieldInstanceReadOnly(receiverType, fieldOffset, vform, false);
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(receiverType, boolean.class);
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var receiverTypeRef = receiverType.describeConstable();
            var fieldTypeRef = boolean.class.describeConstable();
            if (!receiverTypeRef.isPresent() || !fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            String name = VarHandles.getFieldFromReceiverAndOffset(
                receiverType, fieldOffset, boolean.class).getName();
            return Optional.of(VarHandleDesc.ofField(receiverTypeRef.get(), name, fieldTypeRef.get()));
        }

        @ForceInline
        static boolean get(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getBoolean(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static boolean getVolatile(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getBooleanVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static boolean getOpaque(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getBooleanOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static boolean getAcquire(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getBooleanAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadOnly.class, Object.class, boolean.class);
    }

    static final class FieldInstanceReadWrite extends FieldInstanceReadOnly {

        FieldInstanceReadWrite(Class<?> receiverType, long fieldOffset) {
            this(receiverType, fieldOffset, false);
        }

        private FieldInstanceReadWrite(Class<?> receiverType, long fieldOffset,
                                       boolean exact) {
            super(receiverType, fieldOffset, FieldInstanceReadWrite.FORM, exact);
        }

        @Override
        public FieldInstanceReadWrite withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new FieldInstanceReadWrite(receiverType, fieldOffset, true);
        }

        @Override
        public FieldInstanceReadWrite withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new FieldInstanceReadWrite(receiverType, fieldOffset, false);
        }

        @ForceInline
        static void set(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putBoolean(Objects.requireNonNull(handle.receiverType.cast(holder)),
                             handle.fieldOffset,
                             value);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putBooleanVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                     handle.fieldOffset,
                                     value);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putBooleanOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                   handle.fieldOffset,
                                   value);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putBooleanRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                    handle.fieldOffset,
                                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object holder, boolean expected, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndSetBoolean(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean compareAndExchange(VarHandle ob, Object holder, boolean expected, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeBoolean(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean compareAndExchangeAcquire(VarHandle ob, Object holder, boolean expected, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeBooleanAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean compareAndExchangeRelease(VarHandle ob, Object holder, boolean expected, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeBooleanRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object holder, boolean expected, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetBooleanPlain(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object holder, boolean expected, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetBoolean(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object holder, boolean expected, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetBooleanAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object holder, boolean expected, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetBooleanRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean getAndSet(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetBoolean(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static boolean getAndSetAcquire(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetBooleanAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static boolean getAndSetRelease(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetBooleanRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static boolean getAndBitwiseOr(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrBoolean(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseOrRelease(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrBooleanRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseOrAcquire(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrBooleanAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseAnd(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndBoolean(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseAndRelease(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndBooleanRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseAndAcquire(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndBooleanAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseXor(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorBoolean(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseXorRelease(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorBooleanRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseXorAcquire(VarHandle ob, Object holder, boolean value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorBooleanAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadWrite.class, Object.class, boolean.class);
    }


    static class FieldStaticReadOnly extends VarHandle {
        final Object base;
        final long fieldOffset;

        FieldStaticReadOnly(Object base, long fieldOffset) {
            this(base, fieldOffset, FieldStaticReadOnly.FORM, false);
        }

        protected FieldStaticReadOnly(Object base, long fieldOffset,
                                      VarForm form, boolean exact) {
            super(form, exact);
            this.base = base;
            this.fieldOffset = fieldOffset;
        }

        @Override
        public FieldStaticReadOnly withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new FieldStaticReadOnly(base, fieldOffset, vform, true);
        }

        @Override
        public FieldStaticReadOnly withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new FieldStaticReadOnly(base, fieldOffset, vform, false);
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var fieldTypeRef = boolean.class.describeConstable();
            if (!fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            var staticField = VarHandles.getStaticFieldFromBaseAndOffset(
                base, fieldOffset, boolean.class);
            var receiverTypeRef = staticField.getDeclaringClass().describeConstable();
            if (!receiverTypeRef.isPresent())
                return Optional.empty();
            return Optional.of(VarHandleDesc.ofStaticField(receiverTypeRef.get(), staticField.getName(), fieldTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(null, boolean.class);
        }

        @ForceInline
        static boolean get(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getBoolean(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static boolean getVolatile(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getBooleanVolatile(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static boolean getOpaque(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getBooleanOpaque(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static boolean getAcquire(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getBooleanAcquire(handle.base,
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadOnly.class, null, boolean.class);
    }

    static final class FieldStaticReadWrite extends FieldStaticReadOnly {

        FieldStaticReadWrite(Object base, long fieldOffset) {
            this(base, fieldOffset, false);
        }

        private FieldStaticReadWrite(Object base, long fieldOffset,
                                     boolean exact) {
            super(base, fieldOffset, FieldStaticReadWrite.FORM, exact);
        }

        @Override
        public FieldStaticReadWrite withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new FieldStaticReadWrite(base, fieldOffset, true);
        }

        @Override
        public FieldStaticReadWrite withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new FieldStaticReadWrite(base, fieldOffset, false);
        }

        @ForceInline
        static void set(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putBoolean(handle.base,
                             handle.fieldOffset,
                             value);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putBooleanVolatile(handle.base,
                                     handle.fieldOffset,
                                     value);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putBooleanOpaque(handle.base,
                                   handle.fieldOffset,
                                   value);
        }

        @ForceInline
        static void setRelease(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putBooleanRelease(handle.base,
                                    handle.fieldOffset,
                                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, boolean expected, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndSetBoolean(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }


        @ForceInline
        static boolean compareAndExchange(VarHandle ob, boolean expected, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeBoolean(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean compareAndExchangeAcquire(VarHandle ob, boolean expected, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeBooleanAcquire(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean compareAndExchangeRelease(VarHandle ob, boolean expected, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeBooleanRelease(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, boolean expected, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetBooleanPlain(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, boolean expected, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetBoolean(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, boolean expected, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetBooleanAcquire(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, boolean expected, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetBooleanRelease(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean getAndSet(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetBoolean(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static boolean getAndSetAcquire(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetBooleanAcquire(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static boolean getAndSetRelease(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetBooleanRelease(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static boolean getAndBitwiseOr(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrBoolean(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseOrRelease(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrBooleanRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseOrAcquire(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrBooleanAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseAnd(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndBoolean(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseAndRelease(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndBooleanRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseAndAcquire(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndBooleanAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseXor(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorBoolean(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseXorRelease(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorBooleanRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseXorAcquire(VarHandle ob, boolean value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorBooleanAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadWrite.class, null, boolean.class);
    }


    static final class Array extends VarHandle {
        final int abase;
        final int ashift;

        Array(int abase, int ashift) {
            this(abase, ashift, false);
        }

        private Array(int abase, int ashift, boolean exact) {
            super(Array.FORM, exact);
            this.abase = abase;
            this.ashift = ashift;
        }

        @Override
        public Array withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new Array(abase, ashift, true);
        }

        @Override
        public Array withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new Array(abase, ashift, false);
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var arrayTypeRef = boolean[].class.describeConstable();
            if (!arrayTypeRef.isPresent())
                return Optional.empty();

            return Optional.of(VarHandleDesc.ofArray(arrayTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(boolean[].class, boolean.class, int.class);
        }


        @ForceInline
        static boolean get(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return array[index];
        }

        @ForceInline
        static void set(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            array[index] = value;
        }

        @ForceInline
        static boolean getVolatile(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getBooleanVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            UNSAFE.putBooleanVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static boolean getOpaque(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getBooleanOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            UNSAFE.putBooleanOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static boolean getAcquire(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getBooleanAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            UNSAFE.putBooleanRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object oarray, int index, boolean expected, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.compareAndSetBoolean(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean compareAndExchange(VarHandle ob, Object oarray, int index, boolean expected, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.compareAndExchangeBoolean(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean compareAndExchangeAcquire(VarHandle ob, Object oarray, int index, boolean expected, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.compareAndExchangeBooleanAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean compareAndExchangeRelease(VarHandle ob, Object oarray, int index, boolean expected, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.compareAndExchangeBooleanRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object oarray, int index, boolean expected, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.weakCompareAndSetBooleanPlain(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object oarray, int index, boolean expected, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.weakCompareAndSetBoolean(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object oarray, int index, boolean expected, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.weakCompareAndSetBooleanAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object oarray, int index, boolean expected, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.weakCompareAndSetBooleanRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean getAndSet(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndSetBoolean(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static boolean getAndSetAcquire(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndSetBooleanAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static boolean getAndSetRelease(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndSetBooleanRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static boolean getAndBitwiseOr(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndBitwiseOrBoolean(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseOrRelease(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndBitwiseOrBooleanRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseOrAcquire(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndBitwiseOrBooleanAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseAnd(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndBitwiseAndBoolean(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseAndRelease(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndBitwiseAndBooleanRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseAndAcquire(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndBitwiseAndBooleanAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseXor(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndBitwiseXorBoolean(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseXorRelease(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndBitwiseXorBooleanRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static boolean getAndBitwiseXorAcquire(VarHandle ob, Object oarray, int index, boolean value) {
            Array handle = (Array)ob;
            boolean[] array = (boolean[]) oarray;
            return UNSAFE.getAndBitwiseXorBooleanAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        static final VarForm FORM = new VarForm(Array.class, boolean[].class, boolean.class, int.class);
    }
}
