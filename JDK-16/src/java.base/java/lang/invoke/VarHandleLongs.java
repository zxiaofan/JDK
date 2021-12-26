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

final class VarHandleLongs {

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
            return at.accessModeType(receiverType, long.class);
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var receiverTypeRef = receiverType.describeConstable();
            var fieldTypeRef = long.class.describeConstable();
            if (!receiverTypeRef.isPresent() || !fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            String name = VarHandles.getFieldFromReceiverAndOffset(
                receiverType, fieldOffset, long.class).getName();
            return Optional.of(VarHandleDesc.ofField(receiverTypeRef.get(), name, fieldTypeRef.get()));
        }

        @ForceInline
        static long get(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getLong(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static long getVolatile(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getLongVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static long getOpaque(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getLongOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static long getAcquire(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getLongAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadOnly.class, Object.class, long.class);
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
        static void set(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putLong(Objects.requireNonNull(handle.receiverType.cast(holder)),
                             handle.fieldOffset,
                             value);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putLongVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                     handle.fieldOffset,
                                     value);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putLongOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                   handle.fieldOffset,
                                   value);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putLongRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                    handle.fieldOffset,
                                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object holder, long expected, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndSetLong(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static long compareAndExchange(VarHandle ob, Object holder, long expected, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeLong(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static long compareAndExchangeAcquire(VarHandle ob, Object holder, long expected, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeLongAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static long compareAndExchangeRelease(VarHandle ob, Object holder, long expected, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeLongRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object holder, long expected, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetLongPlain(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object holder, long expected, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetLong(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object holder, long expected, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetLongAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object holder, long expected, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetLongRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static long getAndSet(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetLong(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static long getAndSetAcquire(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetLongAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static long getAndSetRelease(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetLongRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static long getAndAdd(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddLong(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndAddAcquire(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddLongAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndAddRelease(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddLongRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }


        @ForceInline
        static long getAndBitwiseOr(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrLong(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseOrRelease(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrLongRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseOrAcquire(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrLongAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseAnd(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndLong(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseAndRelease(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndLongRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseAndAcquire(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndLongAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseXor(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorLong(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseXorRelease(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorLongRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseXorAcquire(VarHandle ob, Object holder, long value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorLongAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadWrite.class, Object.class, long.class);
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
            var fieldTypeRef = long.class.describeConstable();
            if (!fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            var staticField = VarHandles.getStaticFieldFromBaseAndOffset(
                base, fieldOffset, long.class);
            var receiverTypeRef = staticField.getDeclaringClass().describeConstable();
            if (!receiverTypeRef.isPresent())
                return Optional.empty();
            return Optional.of(VarHandleDesc.ofStaticField(receiverTypeRef.get(), staticField.getName(), fieldTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(null, long.class);
        }

        @ForceInline
        static long get(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getLong(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static long getVolatile(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getLongVolatile(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static long getOpaque(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getLongOpaque(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static long getAcquire(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getLongAcquire(handle.base,
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadOnly.class, null, long.class);
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
        static void set(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putLong(handle.base,
                             handle.fieldOffset,
                             value);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putLongVolatile(handle.base,
                                     handle.fieldOffset,
                                     value);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putLongOpaque(handle.base,
                                   handle.fieldOffset,
                                   value);
        }

        @ForceInline
        static void setRelease(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putLongRelease(handle.base,
                                    handle.fieldOffset,
                                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, long expected, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndSetLong(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }


        @ForceInline
        static long compareAndExchange(VarHandle ob, long expected, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeLong(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static long compareAndExchangeAcquire(VarHandle ob, long expected, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeLongAcquire(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static long compareAndExchangeRelease(VarHandle ob, long expected, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeLongRelease(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, long expected, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetLongPlain(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, long expected, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetLong(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, long expected, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetLongAcquire(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, long expected, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetLongRelease(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static long getAndSet(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetLong(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static long getAndSetAcquire(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetLongAcquire(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static long getAndSetRelease(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetLongRelease(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static long getAndAdd(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddLong(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndAddAcquire(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddLongAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndAddRelease(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddLongRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseOr(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrLong(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseOrRelease(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrLongRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseOrAcquire(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrLongAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseAnd(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndLong(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseAndRelease(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndLongRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseAndAcquire(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndLongAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseXor(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorLong(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseXorRelease(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorLongRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseXorAcquire(VarHandle ob, long value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorLongAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadWrite.class, null, long.class);
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
            var arrayTypeRef = long[].class.describeConstable();
            if (!arrayTypeRef.isPresent())
                return Optional.empty();

            return Optional.of(VarHandleDesc.ofArray(arrayTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(long[].class, long.class, int.class);
        }


        @ForceInline
        static long get(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return array[index];
        }

        @ForceInline
        static void set(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            array[index] = value;
        }

        @ForceInline
        static long getVolatile(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getLongVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            UNSAFE.putLongVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static long getOpaque(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getLongOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            UNSAFE.putLongOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static long getAcquire(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getLongAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            UNSAFE.putLongRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object oarray, int index, long expected, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.compareAndSetLong(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static long compareAndExchange(VarHandle ob, Object oarray, int index, long expected, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.compareAndExchangeLong(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static long compareAndExchangeAcquire(VarHandle ob, Object oarray, int index, long expected, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.compareAndExchangeLongAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static long compareAndExchangeRelease(VarHandle ob, Object oarray, int index, long expected, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.compareAndExchangeLongRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object oarray, int index, long expected, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.weakCompareAndSetLongPlain(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object oarray, int index, long expected, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.weakCompareAndSetLong(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object oarray, int index, long expected, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.weakCompareAndSetLongAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object oarray, int index, long expected, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.weakCompareAndSetLongRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static long getAndSet(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndSetLong(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static long getAndSetAcquire(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndSetLongAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static long getAndSetRelease(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndSetLongRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static long getAndAdd(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndAddLong(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static long getAndAddAcquire(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndAddLongAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static long getAndAddRelease(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndAddLongRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static long getAndBitwiseOr(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndBitwiseOrLong(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseOrRelease(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndBitwiseOrLongRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseOrAcquire(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndBitwiseOrLongAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseAnd(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndBitwiseAndLong(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseAndRelease(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndBitwiseAndLongRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseAndAcquire(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndBitwiseAndLongAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseXor(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndBitwiseXorLong(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseXorRelease(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndBitwiseXorLongRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static long getAndBitwiseXorAcquire(VarHandle ob, Object oarray, int index, long value) {
            Array handle = (Array)ob;
            long[] array = (long[]) oarray;
            return UNSAFE.getAndBitwiseXorLongAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        static final VarForm FORM = new VarForm(Array.class, long[].class, long.class, int.class);
    }
}
