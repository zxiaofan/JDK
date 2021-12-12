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

final class VarHandleDoubles {

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
            return at.accessModeType(receiverType, double.class);
        }

        @Override
        public Optional<VarHandleDesc> describeConstable() {
            var receiverTypeRef = receiverType.describeConstable();
            var fieldTypeRef = double.class.describeConstable();
            if (!receiverTypeRef.isPresent() || !fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            String name = VarHandles.getFieldFromReceiverAndOffset(
                receiverType, fieldOffset, double.class).getName();
            return Optional.of(VarHandleDesc.ofField(receiverTypeRef.get(), name, fieldTypeRef.get()));
        }

        @ForceInline
        static double get(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getDouble(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static double getVolatile(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getDoubleVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static double getOpaque(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getDoubleOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        @ForceInline
        static double getAcquire(VarHandle ob, Object holder) {
            FieldInstanceReadOnly handle = (FieldInstanceReadOnly)ob;
            return UNSAFE.getDoubleAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldInstanceReadOnly.class, Object.class, double.class);
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
        static void set(VarHandle ob, Object holder, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putDouble(Objects.requireNonNull(handle.receiverType.cast(holder)),
                             handle.fieldOffset,
                             value);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object holder, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putDoubleVolatile(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                     handle.fieldOffset,
                                     value);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object holder, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putDoubleOpaque(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                   handle.fieldOffset,
                                   value);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object holder, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            UNSAFE.putDoubleRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                    handle.fieldOffset,
                                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object holder, double expected, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndSetDouble(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static double compareAndExchange(VarHandle ob, Object holder, double expected, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeDouble(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static double compareAndExchangeAcquire(VarHandle ob, Object holder, double expected, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeDoubleAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static double compareAndExchangeRelease(VarHandle ob, Object holder, double expected, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.compareAndExchangeDoubleRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object holder, double expected, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetDoublePlain(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object holder, double expected, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetDouble(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object holder, double expected, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetDoubleAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object holder, double expected, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.weakCompareAndSetDoubleRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static double getAndSet(VarHandle ob, Object holder, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetDouble(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static double getAndSetAcquire(VarHandle ob, Object holder, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetDoubleAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static double getAndSetRelease(VarHandle ob, Object holder, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndSetDoubleRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static double getAndAdd(VarHandle ob, Object holder, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddDouble(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static double getAndAddAcquire(VarHandle ob, Object holder, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddDoubleAcquire(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static double getAndAddRelease(VarHandle ob, Object holder, double value) {
            FieldInstanceReadWrite handle = (FieldInstanceReadWrite)ob;
            return UNSAFE.getAndAddDoubleRelease(Objects.requireNonNull(handle.receiverType.cast(holder)),
                                       handle.fieldOffset,
                                       value);
        }


        static final VarForm FORM = new VarForm(FieldInstanceReadWrite.class, Object.class, double.class);
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
            var fieldTypeRef = double.class.describeConstable();
            if (!fieldTypeRef.isPresent())
                return Optional.empty();

            // Reflect on this VarHandle to extract the field name
            var staticField = VarHandles.getStaticFieldFromBaseAndOffset(
                base, fieldOffset, double.class);
            var receiverTypeRef = staticField.getDeclaringClass().describeConstable();
            if (!receiverTypeRef.isPresent())
                return Optional.empty();
            return Optional.of(VarHandleDesc.ofStaticField(receiverTypeRef.get(), staticField.getName(), fieldTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(null, double.class);
        }

        @ForceInline
        static double get(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getDouble(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static double getVolatile(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getDoubleVolatile(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static double getOpaque(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getDoubleOpaque(handle.base,
                                 handle.fieldOffset);
        }

        @ForceInline
        static double getAcquire(VarHandle ob) {
            FieldStaticReadOnly handle = (FieldStaticReadOnly)ob;
            return UNSAFE.getDoubleAcquire(handle.base,
                                 handle.fieldOffset);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadOnly.class, null, double.class);
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
        static void set(VarHandle ob, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putDouble(handle.base,
                             handle.fieldOffset,
                             value);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putDoubleVolatile(handle.base,
                                     handle.fieldOffset,
                                     value);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putDoubleOpaque(handle.base,
                                   handle.fieldOffset,
                                   value);
        }

        @ForceInline
        static void setRelease(VarHandle ob, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            UNSAFE.putDoubleRelease(handle.base,
                                    handle.fieldOffset,
                                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, double expected, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndSetDouble(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }


        @ForceInline
        static double compareAndExchange(VarHandle ob, double expected, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeDouble(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static double compareAndExchangeAcquire(VarHandle ob, double expected, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeDoubleAcquire(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static double compareAndExchangeRelease(VarHandle ob, double expected, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.compareAndExchangeDoubleRelease(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, double expected, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetDoublePlain(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, double expected, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetDouble(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, double expected, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetDoubleAcquire(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, double expected, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.weakCompareAndSetDoubleRelease(handle.base,
                                               handle.fieldOffset,
                                               expected,
                                               value);
        }

        @ForceInline
        static double getAndSet(VarHandle ob, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetDouble(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static double getAndSetAcquire(VarHandle ob, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetDoubleAcquire(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static double getAndSetRelease(VarHandle ob, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndSetDoubleRelease(handle.base,
                                          handle.fieldOffset,
                                          value);
        }

        @ForceInline
        static double getAndAdd(VarHandle ob, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddDouble(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static double getAndAddAcquire(VarHandle ob, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddDoubleAcquire(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        @ForceInline
        static double getAndAddRelease(VarHandle ob, double value) {
            FieldStaticReadWrite handle = (FieldStaticReadWrite)ob;
            return UNSAFE.getAndAddDoubleRelease(handle.base,
                                       handle.fieldOffset,
                                       value);
        }

        static final VarForm FORM = new VarForm(FieldStaticReadWrite.class, null, double.class);
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
            var arrayTypeRef = double[].class.describeConstable();
            if (!arrayTypeRef.isPresent())
                return Optional.empty();

            return Optional.of(VarHandleDesc.ofArray(arrayTypeRef.get()));
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(double[].class, double.class, int.class);
        }


        @ForceInline
        static double get(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return array[index];
        }

        @ForceInline
        static void set(VarHandle ob, Object oarray, int index, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            array[index] = value;
        }

        @ForceInline
        static double getVolatile(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.getDoubleVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object oarray, int index, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            UNSAFE.putDoubleVolatile(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static double getOpaque(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.getDoubleOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object oarray, int index, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            UNSAFE.putDoubleOpaque(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static double getAcquire(VarHandle ob, Object oarray, int index) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.getDoubleAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase);
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object oarray, int index, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            UNSAFE.putDoubleRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object oarray, int index, double expected, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.compareAndSetDouble(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static double compareAndExchange(VarHandle ob, Object oarray, int index, double expected, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.compareAndExchangeDouble(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static double compareAndExchangeAcquire(VarHandle ob, Object oarray, int index, double expected, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.compareAndExchangeDoubleAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static double compareAndExchangeRelease(VarHandle ob, Object oarray, int index, double expected, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.compareAndExchangeDoubleRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object oarray, int index, double expected, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.weakCompareAndSetDoublePlain(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object oarray, int index, double expected, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.weakCompareAndSetDouble(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object oarray, int index, double expected, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.weakCompareAndSetDoubleAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object oarray, int index, double expected, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.weakCompareAndSetDoubleRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    expected,
                    value);
        }

        @ForceInline
        static double getAndSet(VarHandle ob, Object oarray, int index, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.getAndSetDouble(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static double getAndSetAcquire(VarHandle ob, Object oarray, int index, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.getAndSetDoubleAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static double getAndSetRelease(VarHandle ob, Object oarray, int index, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.getAndSetDoubleRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static double getAndAdd(VarHandle ob, Object oarray, int index, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.getAndAddDouble(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static double getAndAddAcquire(VarHandle ob, Object oarray, int index, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.getAndAddDoubleAcquire(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        @ForceInline
        static double getAndAddRelease(VarHandle ob, Object oarray, int index, double value) {
            Array handle = (Array)ob;
            double[] array = (double[]) oarray;
            return UNSAFE.getAndAddDoubleRelease(array,
                    (((long) Preconditions.checkIndex(index, array.length, AIOOBE_SUPPLIER)) << handle.ashift) + handle.abase,
                    value);
        }

        static final VarForm FORM = new VarForm(Array.class, double[].class, double.class, int.class);
    }
}
