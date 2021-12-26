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

final class VarHandleReferences {

    static class FieldInstanceReadOnly extends VarHandle {
        final long fieldOffset;
        final Class<?> receiverType;
        final Class<?> fieldType;

        FieldInstanceReadOnly(Class<?> receiverType, long fieldOffset, Class<?> fieldType) {
            this(receiverType, fieldOffset, fieldType, FieldInstanceReadOnly.FORM, false);
        }

        protected FieldInstanceReadOnly(Class<?> receiverType, long fieldOffset, Class<?> fieldType,
                                        VarForm form, boolean exact) {
            super(form, exact);
            this.fieldOffset = fieldOffset;
            this.receiverType = receiverType;
            this.fieldType = fieldType;
        }

        @Override
        public FieldInstanceReadOnly withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new FieldInstanceReadOnly(receiverType, fieldOffset, fieldType, vform, true);
        }

        @Override
        public FieldInstanceReadOnly withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new FieldInstanceReadOnly(receiverType, fieldOffset, fieldType, vform, false);
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(receiverType, fieldType);
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var receiverTypeRef = receiverType.describeConstable();
            var fieldTypeRef = fieldType.describeConstable();
            if (!receiverTypeRef.isPresent() || !fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            String name = VarHandles.getFieldFromReceiverAndOffset(
                receiverType, fieldOffset, fieldType).getName();
            return Optional.of(VarHandleDesc.ofField(receiverTypeRef.get(), name, fieldTypeRef.get()));
        }

        @ForceInline
        static Object get(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getVolatile(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getReferenceVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getOpaque(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getReferenceOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getAcquire(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getReferenceAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadOnly.class, Object.class, Object.class);
    }

    static final class FieldInstanceReadWrite extends FieldInstanceReadOnly {

        FieldInstanceReadWrite(Class<?> receiverType, long fieldOffset, Class<?> fieldType) {
            this(receiverType, fieldOffset, fieldType, false);
        }

        private FieldInstanceReadWrite(Class<?> receiverType, long fieldOffset, Class<?> fieldType,
                                       boolean exact) {
            super(receiverType, fieldOffset, fieldType, FieldInstanceReadWrite.FORM, exact);
        }

        @Override
        public FieldInstanceReadWrite withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new FieldInstanceReadWrite(receiverType, fieldOffset, fieldType, true);
        }

        @Override
        public FieldInstanceReadWrite withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new FieldInstanceReadWrite(receiverType, fieldOffset, fieldType, false);
        }

        @ForceInline
        static void set(VarHandle ob, Object holder, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                             handle.fieldOffset,
                             handle.fieldType.cast(value));
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object holder, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putReferenceVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                     handle.fieldOffset,
                                     handle.fieldType.cast(value));
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object holder, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putReferenceOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                   handle.fieldOffset,
                                   handle.fieldType.cast(value));
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object holder, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putReferenceRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                    handle.fieldOffset,
                                    handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object holder, Object expected, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndSetReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object compareAndExchange(VarHandle ob, Object holder, Object expected, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object compareAndExchangeAcquire(VarHandle ob, Object holder, Object expected, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeReferenceAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object compareAndExchangeRelease(VarHandle ob, Object holder, Object expected, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeReferenceRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object holder, Object expected, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetReferencePlain(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object holder, Object expected, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object holder, Object expected, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetReferenceAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object holder, Object expected, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetReferenceRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSet(VarHandle ob, Object holder, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSetAcquire(VarHandle ob, Object holder, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetReferenceAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSetRelease(VarHandle ob, Object holder, Object value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetReferenceRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          handle.fieldType.cast(value));
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadWrite.class, Object.class, Object.class);
    }


    static class FieldStaticReadOnly extends VarHandle {
        final Object base;
        final long fieldOffset;
        final Class<?> fieldType;

        FieldStaticReadOnly(Object base, long fieldOffset, Class<?> fieldType) {
            this(base, fieldOffset, fieldType, FieldStaticReadOnly.FORM, false);
        }

        protected FieldStaticReadOnly(Object base, long fieldOffset, Class<?> fieldType,
                                      VarForm form, boolean exact) {
            super(form, exact);
            this.base = base;
            this.fieldOffset = fieldOffset;
            this.fieldType = fieldType;
        }

        @Override
        public FieldStaticReadOnly withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new FieldStaticReadOnly(base, fieldOffset, fieldType, vform, true);
        }

        @Override
        public FieldStaticReadOnly withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new FieldStaticReadOnly(base, fieldOffset, fieldType, vform, false);
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var fieldTypeRef = fieldType.describeConstable();
            if (!fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            var staticField = VarHandles.getStaticFieldFromBaseAndOffset(
                base, fieldOffset, fieldType);
            var receiverTypeRef = staticField.getDeclaringClass().describeConstable();
            if (!receiverTypeRef.isPresent())
                return Optional.empty();
            return Optional.of(VarHandleDesc.ofStaticField(receiverTypeRef.get(), staticField.getName(), fieldTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(null, fieldType);
        }

        @ForceInline
        static Object get(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getReference(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getVolatile(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getReferenceVolatile(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getOpaque(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getReferenceOpaque(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getAcquire(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getReferenceAcquire(handle.base,
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadOnly.class, null, Object.class);
    }

    static final class FieldStaticReadWrite extends FieldStaticReadOnly {

        FieldStaticReadWrite(Object base, long fieldOffset, Class<?> fieldType) {
            this(base, fieldOffset, fieldType, false);
        }

        private FieldStaticReadWrite(Object base, long fieldOffset, Class<?> fieldType,
                                     boolean exact) {
            super(base, fieldOffset, fieldType, FieldStaticReadWrite.FORM, exact);
        }

        @Override
        public FieldStaticReadWrite withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new FieldStaticReadWrite(base, fieldOffset, fieldType, true);
        }

        @Override
        public FieldStaticReadWrite withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new FieldStaticReadWrite(base, fieldOffset, fieldType, false);
        }

        @ForceInline
        static void set(VarHandle ob, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putReference(handle.base,
                             handle.fieldOffset,
                             handle.fieldType.cast(value));
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putReferenceVolatile(handle.base,
                                     handle.fieldOffset,
                                     handle.fieldType.cast(value));
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putReferenceOpaque(handle.base,
                                   handle.fieldOffset,
                                   handle.fieldType.cast(value));
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putReferenceRelease(handle.base,
                                    handle.fieldOffset,
                                    handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object expected, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndSetReference(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }


        @ForceInline
        static Object compareAndExchange(VarHandle ob, Object expected, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeReference(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object compareAndExchangeAcquire(VarHandle ob, Object expected, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeReferenceAcquire(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object compareAndExchangeRelease(VarHandle ob, Object expected, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeReferenceRelease(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object expected, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetReferencePlain(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object expected, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetReference(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object expected, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetReferenceAcquire(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object expected, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetReferenceRelease(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSet(VarHandle ob, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetReference(handle.base,
                                          handle.fieldOffset,
                                          handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSetAcquire(VarHandle ob, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetReferenceAcquire(handle.base,
                                          handle.fieldOffset,
                                          handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSetRelease(VarHandle ob, Object value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetReferenceRelease(handle.base,
                                          handle.fieldOffset,
                                          handle.fieldType.cast(value));
        }

        static final VarForm FORM = new VarForm(FieldStaticReadWrite.class, null, Object.class);
    }


    static final class Array extends VarHandle {
        final int abase;
        final int ashift;
        final Class<?> arrayType;
        final Class<?> componentType;

        Array(int abase, int ashift, Class<?> arrayType) {
            this(abase, ashift, arrayType, false);
        }

        private Array(int abase, int ashift, Class<?> arrayType, boolean exact) {
            super(Array.FORM, exact);
            this.abase = abase;
            this.ashift = ashift;
            this.arrayType = arrayType;
            this.componentType = arrayType.getComponentType();
        }

        @Override
        public Array withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new Array(abase, ashift, arrayType, true);
        }

        @Override
        public Array withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new Array(abase, ashift, arrayType, false);
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var arrayTypeRef = arrayType.describeConstable();
            if (!arrayTypeRef.isPresent())
                return Optional.empty();

            return Optional.of(VarHandleDesc.ofArray(arrayTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(arrayType, arrayType.getComponentType(), int.class);
        }

        @ForceInline
        static Object runtimeTypeCheck(Array handle, Object[] oarray, Object value) {
            if (handle.arrayType == oarray.getClass()) {
                // Fast path: static array type same as argument array type
                return handle.componentType.cast(value);
            } else {
                // Slow path: check value against argument array component type
                return reflectiveTypeCheck(oarray, value);
            }
        }

        @ForceInline
        static Object reflectiveTypeCheck(Object[] oarray, Object value) {
            try {
                return oarray.getClass().getComponentType().cast(value);
            } catch (ClassCastException e) {
                throw new ArrayStoreException();
            }
        }

        @ForceInline
        static Object get(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return array[index];
        }

        @ForceInline
        static void set(VarHandle ob, Object oarray, int index, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            array[index] = handle.componentType.cast(value);
        }

        @ForceInline
        static Object getVolatile(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getReferenceVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object oarray, int index, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            UNSAFE.putReferenceVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object getOpaque(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getReferenceOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object oarray, int index, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            UNSAFE.putReferenceOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object getAcquire(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getReferenceAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object oarray, int index, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            UNSAFE.putReferenceRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object oarray, int index, Object expected, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.compareAndSetReference(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object compareAndExchange(VarHandle ob, Object oarray, int index, Object expected, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.compareAndExchangeReference(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object compareAndExchangeAcquire(VarHandle ob, Object oarray, int index, Object expected, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.compareAndExchangeReferenceAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object compareAndExchangeRelease(VarHandle ob, Object oarray, int index, Object expected, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.compareAndExchangeReferenceRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object oarray, int index, Object expected, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.weakCompareAndSetReferencePlain(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object oarray, int index, Object expected, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.weakCompareAndSetReference(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object oarray, int index, Object expected, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.weakCompareAndSetReferenceAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object oarray, int index, Object expected, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.weakCompareAndSetReferenceRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object getAndSet(VarHandle ob, Object oarray, int index, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getAndSetReference(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object getAndSetAcquire(VarHandle ob, Object oarray, int index, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getAndSetReferenceAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object getAndSetRelease(VarHandle ob, Object oarray, int index, Object value) {
            Array handle = (Array)ob;
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getAndSetReferenceRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        static final VarForm FORM = new VarForm(Array.class, Object[].class, Object.class, int.class);
    }
}
