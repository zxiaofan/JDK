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

final class VarHandleChars {

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
            return at.accessModeType(receiverType, char.class);
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var receiverTypeRef = receiverType.describeConstable();
            var fieldTypeRef = char.class.describeConstable();
            if (!receiverTypeRef.isPresent() || !fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            String name = VarHandles.getFieldFromReceiverAndOffset(
                receiverType, fieldOffset, char.class).getName();
            return Optional.of(VarHandleDesc.ofField(receiverTypeRef.get(), name, fieldTypeRef.get()));
        }

        @ForceInline
        static char get(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getChar(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static char getVolatile(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getCharVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static char getOpaque(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getCharOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static char getAcquire(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getCharAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadOnly.class, Object.class, char.class);
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
        static void set(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putChar(Objects.requireNonNull(handle.receiverType.cast(holder)),
                             handle.fieldOffset,
                             value);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putCharVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                     handle.fieldOffset,
                                     value);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putCharOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                   handle.fieldOffset,
                                   value);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putCharRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                    handle.fieldOffset,
                                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object holder, char expected, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndSetChar(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static char compareAndExchange(VarHandle ob, Object holder, char expected, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeChar(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static char compareAndExchangeAcquire(VarHandle ob, Object holder, char expected, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeCharAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static char compareAndExchangeRelease(VarHandle ob, Object holder, char expected, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeCharRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object holder, char expected, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetCharPlain(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object holder, char expected, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetChar(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object holder, char expected, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetCharAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object holder, char expected, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetCharRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static char getAndSet(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetChar(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static char getAndSetAcquire(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetCharAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static char getAndSetRelease(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetCharRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static char getAndAdd(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddChar(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndAddAcquire(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddCharAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndAddRelease(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddCharRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }


        @ForceInline
        static char getAndBitwiseOr(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrChar(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseOrRelease(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrCharRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseOrAcquire(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrCharAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseAnd(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndChar(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseAndRelease(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndCharRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseAndAcquire(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndCharAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseXor(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorChar(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseXorRelease(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorCharRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseXorAcquire(VarHandle ob, Object holder, char value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorCharAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadWrite.class, Object.class, char.class);
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
            var fieldTypeRef = char.class.describeConstable();
            if (!fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            var staticField = VarHandles.getStaticFieldFromBaseAndOffset(
                base, fieldOffset, char.class);
            var receiverTypeRef = staticField.getDeclaringClass().describeConstable();
            if (!receiverTypeRef.isPresent())
                return Optional.empty();
            return Optional.of(VarHandleDesc.ofStaticField(receiverTypeRef.get(), staticField.getName(), fieldTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(null, char.class);
        }

        @ForceInline
        static char get(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getChar(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static char getVolatile(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getCharVolatile(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static char getOpaque(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getCharOpaque(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static char getAcquire(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getCharAcquire(handle.base,
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadOnly.class, null, char.class);
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
        static void set(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putChar(handle.base,
                             handle.fieldOffset,
                             value);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putCharVolatile(handle.base,
                                     handle.fieldOffset,
                                     value);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putCharOpaque(handle.base,
                                   handle.fieldOffset,
                                   value);
        }

        @ForceInline
        static void setRelease(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putCharRelease(handle.base,
                                    handle.fieldOffset,
                                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, char expected, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndSetChar(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }


        @ForceInline
        static char compareAndExchange(VarHandle ob, char expected, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeChar(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static char compareAndExchangeAcquire(VarHandle ob, char expected, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeCharAcquire(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static char compareAndExchangeRelease(VarHandle ob, char expected, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeCharRelease(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, char expected, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetCharPlain(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, char expected, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetChar(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, char expected, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetCharAcquire(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, char expected, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetCharRelease(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static char getAndSet(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetChar(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static char getAndSetAcquire(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetCharAcquire(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static char getAndSetRelease(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetCharRelease(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static char getAndAdd(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddChar(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndAddAcquire(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddCharAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndAddRelease(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddCharRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseOr(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrChar(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseOrRelease(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrCharRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseOrAcquire(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrCharAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseAnd(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndChar(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseAndRelease(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndCharRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseAndAcquire(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndCharAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseXor(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorChar(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseXorRelease(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorCharRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseXorAcquire(VarHandle ob, char value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorCharAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadWrite.class, null, char.class);
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
            var arrayTypeRef = char[].class.describeConstable();
            if (!arrayTypeRef.isPresent())
                return Optional.empty();

            return Optional.of(VarHandleDesc.ofArray(arrayTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(char[].class, char.class, int.class);
        }


        @ForceInline
        static char get(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return array[index];
        }

        @ForceInline
        static void set(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            array[index] = value;
        }

        @ForceInline
        static char getVolatile(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getCharVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            UNSAFE.putCharVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static char getOpaque(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getCharOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            UNSAFE.putCharOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static char getAcquire(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getCharAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            UNSAFE.putCharRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object oarray, int index, char expected, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.compareAndSetChar(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static char compareAndExchange(VarHandle ob, Object oarray, int index, char expected, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.compareAndExchangeChar(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static char compareAndExchangeAcquire(VarHandle ob, Object oarray, int index, char expected, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.compareAndExchangeCharAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static char compareAndExchangeRelease(VarHandle ob, Object oarray, int index, char expected, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.compareAndExchangeCharRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object oarray, int index, char expected, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.weakCompareAndSetCharPlain(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object oarray, int index, char expected, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.weakCompareAndSetChar(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object oarray, int index, char expected, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.weakCompareAndSetCharAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object oarray, int index, char expected, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.weakCompareAndSetCharRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static char getAndSet(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndSetChar(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static char getAndSetAcquire(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndSetCharAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static char getAndSetRelease(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndSetCharRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static char getAndAdd(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndAddChar(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static char getAndAddAcquire(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndAddCharAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static char getAndAddRelease(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndAddCharRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static char getAndBitwiseOr(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndBitwiseOrChar(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseOrRelease(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndBitwiseOrCharRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseOrAcquire(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndBitwiseOrCharAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseAnd(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndBitwiseAndChar(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseAndRelease(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndBitwiseAndCharRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseAndAcquire(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndBitwiseAndCharAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseXor(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndBitwiseXorChar(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseXorRelease(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndBitwiseXorCharRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static char getAndBitwiseXorAcquire(VarHandle ob, Object oarray, int index, char value) {
            Array handle = (Array)ob;
            char[] array = (char[]) oarray;
            return UNSAFE.getAndBitwiseXorCharAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        static final VarForm FORM = new VarForm(Array.class, char[].class, char.class, int.class);
    }
}
