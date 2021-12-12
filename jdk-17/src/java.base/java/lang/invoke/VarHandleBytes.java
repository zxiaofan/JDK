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

final class VarHandleBytes {

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
            return at.accessModeType(receiverType, byte.class);
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var receiverTypeRef = receiverType.describeConstable();
            var fieldTypeRef = byte.class.describeConstable();
            if (!receiverTypeRef.isPresent() || !fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            String name = VarHandles.getFieldFromReceiverAndOffset(
                receiverType, fieldOffset, byte.class).getName();
            return Optional.of(VarHandleDesc.ofField(receiverTypeRef.get(), name, fieldTypeRef.get()));
        }

        @ForceInline
        static byte get(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getByte(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static byte getVolatile(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getByteVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static byte getOpaque(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getByteOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static byte getAcquire(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getByteAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadOnly.class, Object.class, byte.class);
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
        static void set(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putByte(Objects.requireNonNull(handle.receiverType.cast(holder)),
                             handle.fieldOffset,
                             value);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putByteVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                     handle.fieldOffset,
                                     value);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putByteOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                   handle.fieldOffset,
                                   value);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putByteRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                    handle.fieldOffset,
                                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object holder, byte expected, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndSetByte(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static byte compareAndExchange(VarHandle ob, Object holder, byte expected, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeByte(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static byte compareAndExchangeAcquire(VarHandle ob, Object holder, byte expected, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeByteAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static byte compareAndExchangeRelease(VarHandle ob, Object holder, byte expected, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeByteRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object holder, byte expected, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetBytePlain(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object holder, byte expected, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetByte(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object holder, byte expected, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetByteAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object holder, byte expected, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetByteRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static byte getAndSet(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetByte(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static byte getAndSetAcquire(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetByteAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static byte getAndSetRelease(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetByteRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static byte getAndAdd(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddByte(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndAddAcquire(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddByteAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndAddRelease(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddByteRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }


        @ForceInline
        static byte getAndBitwiseOr(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrByte(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseOrRelease(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrByteRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseOrAcquire(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseOrByteAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseAnd(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndByte(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseAndRelease(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndByteRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseAndAcquire(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseAndByteAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseXor(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorByte(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseXorRelease(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorByteRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseXorAcquire(VarHandle ob, Object holder, byte value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndBitwiseXorByteAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadWrite.class, Object.class, byte.class);
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
            var fieldTypeRef = byte.class.describeConstable();
            if (!fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            var staticField = VarHandles.getStaticFieldFromBaseAndOffset(
                base, fieldOffset, byte.class);
            var receiverTypeRef = staticField.getDeclaringClass().describeConstable();
            if (!receiverTypeRef.isPresent())
                return Optional.empty();
            return Optional.of(VarHandleDesc.ofStaticField(receiverTypeRef.get(), staticField.getName(), fieldTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(null, byte.class);
        }

        @ForceInline
        static byte get(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getByte(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static byte getVolatile(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getByteVolatile(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static byte getOpaque(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getByteOpaque(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static byte getAcquire(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getByteAcquire(handle.base,
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadOnly.class, null, byte.class);
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
        static void set(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putByte(handle.base,
                             handle.fieldOffset,
                             value);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putByteVolatile(handle.base,
                                     handle.fieldOffset,
                                     value);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putByteOpaque(handle.base,
                                   handle.fieldOffset,
                                   value);
        }

        @ForceInline
        static void setRelease(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putByteRelease(handle.base,
                                    handle.fieldOffset,
                                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, byte expected, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndSetByte(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }


        @ForceInline
        static byte compareAndExchange(VarHandle ob, byte expected, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeByte(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static byte compareAndExchangeAcquire(VarHandle ob, byte expected, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeByteAcquire(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static byte compareAndExchangeRelease(VarHandle ob, byte expected, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeByteRelease(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, byte expected, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetBytePlain(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, byte expected, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetByte(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, byte expected, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetByteAcquire(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, byte expected, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetByteRelease(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static byte getAndSet(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetByte(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static byte getAndSetAcquire(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetByteAcquire(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static byte getAndSetRelease(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetByteRelease(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static byte getAndAdd(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddByte(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndAddAcquire(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddByteAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndAddRelease(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddByteRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseOr(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrByte(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseOrRelease(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrByteRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseOrAcquire(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseOrByteAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseAnd(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndByte(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseAndRelease(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndByteRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseAndAcquire(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseAndByteAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseXor(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorByte(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseXorRelease(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorByteRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseXorAcquire(VarHandle ob, byte value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndBitwiseXorByteAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadWrite.class, null, byte.class);
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
            var arrayTypeRef = byte[].class.describeConstable();
            if (!arrayTypeRef.isPresent())
                return Optional.empty();

            return Optional.of(VarHandleDesc.ofArray(arrayTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(byte[].class, byte.class, int.class);
        }


        @ForceInline
        static byte get(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return array[index];
        }

        @ForceInline
        static void set(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            array[index] = value;
        }

        @ForceInline
        static byte getVolatile(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getByteVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            UNSAFE.putByteVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static byte getOpaque(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getByteOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            UNSAFE.putByteOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static byte getAcquire(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getByteAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            UNSAFE.putByteRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object oarray, int index, byte expected, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.compareAndSetByte(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static byte compareAndExchange(VarHandle ob, Object oarray, int index, byte expected, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.compareAndExchangeByte(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static byte compareAndExchangeAcquire(VarHandle ob, Object oarray, int index, byte expected, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.compareAndExchangeByteAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static byte compareAndExchangeRelease(VarHandle ob, Object oarray, int index, byte expected, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.compareAndExchangeByteRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object oarray, int index, byte expected, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.weakCompareAndSetBytePlain(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object oarray, int index, byte expected, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.weakCompareAndSetByte(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object oarray, int index, byte expected, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.weakCompareAndSetByteAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object oarray, int index, byte expected, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.weakCompareAndSetByteRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static byte getAndSet(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndSetByte(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static byte getAndSetAcquire(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndSetByteAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static byte getAndSetRelease(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndSetByteRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static byte getAndAdd(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndAddByte(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static byte getAndAddAcquire(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndAddByteAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static byte getAndAddRelease(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndAddByteRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static byte getAndBitwiseOr(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndBitwiseOrByte(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseOrRelease(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndBitwiseOrByteRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseOrAcquire(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndBitwiseOrByteAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseAnd(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndBitwiseAndByte(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseAndRelease(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndBitwiseAndByteRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseAndAcquire(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndBitwiseAndByteAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseXor(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndBitwiseXorByte(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseXorRelease(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndBitwiseXorByteRelease(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        @ForceInline
        static byte getAndBitwiseXorAcquire(VarHandle ob, Object oarray, int index, byte value) {
            Array handle = (Array)ob;
            byte[] array = (byte[]) oarray;
            return UNSAFE.getAndBitwiseXorByteAcquire(array,
                                       (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                                       value);
        }

        static final VarForm FORM = new VarForm(Array.class, byte[].class, byte.class, int.class);
    }
}
