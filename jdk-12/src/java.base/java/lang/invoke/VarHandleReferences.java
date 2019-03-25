/*
 * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
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
            this(receiverType, fieldOffset, fieldType, FieldInstanceReadOnly.FORM);
        }

        protected FieldInstanceReadOnly(Class<?> receiverType, long fieldOffset, Class<?> fieldType,
                                        VarForm form) {
            super(form);
            this.fieldOffset = fieldOffset;
            this.receiverType = receiverType;
            this.fieldType = fieldType;
        }

        @Override
        final MethodType accessModeTypeUncached(AccessMode accessMode) {
            return accessMode.at.accessModeType(receiverType, fieldType);
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
        static Object get(FieldInstanceReadOnly handle, Object holder) {
            return UNSAFE.getReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getVolatile(FieldInstanceReadOnly handle, Object holder) {
            return UNSAFE.getReferenceVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getOpaque(FieldInstanceReadOnly handle, Object holder) {
            return UNSAFE.getReferenceOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getAcquire(FieldInstanceReadOnly handle, Object holder) {
            return UNSAFE.getReferenceAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadOnly.class, Object.class, Object.class);
    }

    static final class FieldInstanceReadWrite extends FieldInstanceReadOnly {

        FieldInstanceReadWrite(Class<?> receiverType, long fieldOffset, Class<?> fieldType) {
            super(receiverType, fieldOffset, fieldType, FieldInstanceReadWrite.FORM);
        }

        @ForceInline
        static void set(FieldInstanceReadWrite handle, Object holder, Object value) {
            UNSAFE.putReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                             handle.fieldOffset,
                             handle.fieldType.cast(value));
        }

        @ForceInline
        static void setVolatile(FieldInstanceReadWrite handle, Object holder, Object value) {
            UNSAFE.putReferenceVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                     handle.fieldOffset,
                                     handle.fieldType.cast(value));
        }

        @ForceInline
        static void setOpaque(FieldInstanceReadWrite handle, Object holder, Object value) {
            UNSAFE.putReferenceOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                   handle.fieldOffset,
                                   handle.fieldType.cast(value));
        }

        @ForceInline
        static void setRelease(FieldInstanceReadWrite handle, Object holder, Object value) {
            UNSAFE.putReferenceRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                    handle.fieldOffset,
                                    handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean compareAndSet(FieldInstanceReadWrite handle, Object holder, Object expected, Object value) {
            return UNSAFE.compareAndSetReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object compareAndExchange(FieldInstanceReadWrite handle, Object holder, Object expected, Object value) {
            return UNSAFE.compareAndExchangeReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object compareAndExchangeAcquire(FieldInstanceReadWrite handle, Object holder, Object expected, Object value) {
            return UNSAFE.compareAndExchangeReferenceAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object compareAndExchangeRelease(FieldInstanceReadWrite handle, Object holder, Object expected, Object value) {
            return UNSAFE.compareAndExchangeReferenceRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(FieldInstanceReadWrite handle, Object holder, Object expected, Object value) {
            return UNSAFE.weakCompareAndSetReferencePlain(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSet(FieldInstanceReadWrite handle, Object holder, Object expected, Object value) {
            return UNSAFE.weakCompareAndSetReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(FieldInstanceReadWrite handle, Object holder, Object expected, Object value) {
            return UNSAFE.weakCompareAndSetReferenceAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(FieldInstanceReadWrite handle, Object holder, Object expected, Object value) {
            return UNSAFE.weakCompareAndSetReferenceRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSet(FieldInstanceReadWrite handle, Object holder, Object value) {
            return UNSAFE.getAndSetReference(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSetAcquire(FieldInstanceReadWrite handle, Object holder, Object value) {
            return UNSAFE.getAndSetReferenceAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSetRelease(FieldInstanceReadWrite handle, Object holder, Object value) {
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
            this(base, fieldOffset, fieldType, FieldStaticReadOnly.FORM);
        }

        protected FieldStaticReadOnly(Object base, long fieldOffset, Class<?> fieldType,
                                      VarForm form) {
            super(form);
            this.base = base;
            this.fieldOffset = fieldOffset;
            this.fieldType = fieldType;
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
        final MethodType accessModeTypeUncached(AccessMode accessMode) {
            return accessMode.at.accessModeType(null, fieldType);
        }

        @ForceInline
        static Object get(FieldStaticReadOnly handle) {
            return UNSAFE.getReference(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getVolatile(FieldStaticReadOnly handle) {
            return UNSAFE.getReferenceVolatile(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getOpaque(FieldStaticReadOnly handle) {
            return UNSAFE.getReferenceOpaque(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static Object getAcquire(FieldStaticReadOnly handle) {
            return UNSAFE.getReferenceAcquire(handle.base,
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadOnly.class, null, Object.class);
    }

    static final class FieldStaticReadWrite extends FieldStaticReadOnly {

        FieldStaticReadWrite(Object base, long fieldOffset, Class<?> fieldType) {
            super(base, fieldOffset, fieldType, FieldStaticReadWrite.FORM);
        }

        @ForceInline
        static void set(FieldStaticReadWrite handle, Object value) {
            UNSAFE.putReference(handle.base,
                             handle.fieldOffset,
                             handle.fieldType.cast(value));
        }

        @ForceInline
        static void setVolatile(FieldStaticReadWrite handle, Object value) {
            UNSAFE.putReferenceVolatile(handle.base,
                                     handle.fieldOffset,
                                     handle.fieldType.cast(value));
        }

        @ForceInline
        static void setOpaque(FieldStaticReadWrite handle, Object value) {
            UNSAFE.putReferenceOpaque(handle.base,
                                   handle.fieldOffset,
                                   handle.fieldType.cast(value));
        }

        @ForceInline
        static void setRelease(FieldStaticReadWrite handle, Object value) {
            UNSAFE.putReferenceRelease(handle.base,
                                    handle.fieldOffset,
                                    handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean compareAndSet(FieldStaticReadWrite handle, Object expected, Object value) {
            return UNSAFE.compareAndSetReference(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }


        @ForceInline
        static Object compareAndExchange(FieldStaticReadWrite handle, Object expected, Object value) {
            return UNSAFE.compareAndExchangeReference(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object compareAndExchangeAcquire(FieldStaticReadWrite handle, Object expected, Object value) {
            return UNSAFE.compareAndExchangeReferenceAcquire(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object compareAndExchangeRelease(FieldStaticReadWrite handle, Object expected, Object value) {
            return UNSAFE.compareAndExchangeReferenceRelease(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(FieldStaticReadWrite handle, Object expected, Object value) {
            return UNSAFE.weakCompareAndSetReferencePlain(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSet(FieldStaticReadWrite handle, Object expected, Object value) {
            return UNSAFE.weakCompareAndSetReference(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(FieldStaticReadWrite handle, Object expected, Object value) {
            return UNSAFE.weakCompareAndSetReferenceAcquire(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(FieldStaticReadWrite handle, Object expected, Object value) {
            return UNSAFE.weakCompareAndSetReferenceRelease(handle.base,
                                               handle.fieldOffset,
                                               handle.fieldType.cast(expected),
                                               handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSet(FieldStaticReadWrite handle, Object value) {
            return UNSAFE.getAndSetReference(handle.base,
                                          handle.fieldOffset,
                                          handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSetAcquire(FieldStaticReadWrite handle, Object value) {
            return UNSAFE.getAndSetReferenceAcquire(handle.base,
                                          handle.fieldOffset,
                                          handle.fieldType.cast(value));
        }

        @ForceInline
        static Object getAndSetRelease(FieldStaticReadWrite handle, Object value) {
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
            super(Array.FORM);
            this.abase = abase;
            this.ashift = ashift;
            this.arrayType = arrayType;
            this.componentType = arrayType.getComponentType();
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var arrayTypeRef = arrayType.describeConstable();
            if (!arrayTypeRef.isPresent())
                return Optional.empty();

            return Optional.of(VarHandleDesc.ofArray(arrayTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessMode accessMode) {
            return accessMode.at.accessModeType(arrayType, arrayType.getComponentType(), int.class);
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
        static Object get(Array handle, Object oarray, int index) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return array[index];
        }

        @ForceInline
        static void set(Array handle, Object oarray, int index, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            array[index] = handle.componentType.cast(value);
        }

        @ForceInline
        static Object getVolatile(Array handle, Object oarray, int index) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getReferenceVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setVolatile(Array handle, Object oarray, int index, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            UNSAFE.putReferenceVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object getOpaque(Array handle, Object oarray, int index) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getReferenceOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setOpaque(Array handle, Object oarray, int index, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            UNSAFE.putReferenceOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object getAcquire(Array handle, Object oarray, int index) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getReferenceAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setRelease(Array handle, Object oarray, int index, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            UNSAFE.putReferenceRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static boolean compareAndSet(Array handle, Object oarray, int index, Object expected, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.compareAndSetReference(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object compareAndExchange(Array handle, Object oarray, int index, Object expected, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.compareAndExchangeReference(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object compareAndExchangeAcquire(Array handle, Object oarray, int index, Object expected, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.compareAndExchangeReferenceAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object compareAndExchangeRelease(Array handle, Object oarray, int index, Object expected, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.compareAndExchangeReferenceRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(Array handle, Object oarray, int index, Object expected, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.weakCompareAndSetReferencePlain(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static boolean weakCompareAndSet(Array handle, Object oarray, int index, Object expected, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.weakCompareAndSetReference(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(Array handle, Object oarray, int index, Object expected, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.weakCompareAndSetReferenceAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(Array handle, Object oarray, int index, Object expected, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.weakCompareAndSetReferenceRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    handle.componentType.cast(expected),
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object getAndSet(Array handle, Object oarray, int index, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getAndSetReference(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object getAndSetAcquire(Array handle, Object oarray, int index, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getAndSetReferenceAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        @ForceInline
        static Object getAndSetRelease(Array handle, Object oarray, int index, Object value) {
            Object[] array = (Object[]) handle.arrayType.cast(oarray);
            return UNSAFE.getAndSetReferenceRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    runtimeTypeCheck(handle, array, value));
        }

        static final VarForm FORM = new VarForm(Array.class, Object[].class, Object.class, int.class);
    }
}
