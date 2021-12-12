/*
 * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
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

import jdk.internal.access.JavaNioAccess;
import jdk.internal.access.SharedSecrets;
import jdk.internal.access.foreign.MemorySegmentProxy;
import jdk.internal.misc.ScopedMemoryAccess;
import jdk.internal.misc.ScopedMemoryAccess.Scope;
import jdk.internal.misc.Unsafe;
import jdk.internal.util.Preconditions;
import jdk.internal.vm.annotation.ForceInline;

import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

import static java.lang.invoke.MethodHandleStatics.UNSAFE;

// -- This file was mechanically generated: Do not edit! -- //

final class VarHandleByteArrayAsDoubles extends VarHandleByteArrayBase {

    static final JavaNioAccess NIO_ACCESS = SharedSecrets.getJavaNioAccess();

    static final int ALIGN = Double.BYTES - 1;
    
    static final ScopedMemoryAccess SCOPED_MEMORY_ACCESS = ScopedMemoryAccess.getScopedMemoryAccess();

    @ForceInline
    static long convEndian(boolean big, double v) {
        long rv = Double.doubleToRawLongBits(v);
        return big == BE ? rv : Long.reverseBytes(rv);
    }

    @ForceInline
    static double convEndian(boolean big, long rv) {
        rv = big == BE ? rv : Long.reverseBytes(rv);
        return Double.longBitsToDouble(rv);
    }


    private static abstract class ByteArrayViewVarHandle extends VarHandle {
        final boolean be;

        ByteArrayViewVarHandle(VarForm form, boolean be, boolean exact) {
            super(form, exact);
            this.be = be;
        }
    }

    static final class ArrayHandle extends ByteArrayViewVarHandle {

        ArrayHandle(boolean be) {
            this(be, false);
        }

        private ArrayHandle(boolean be, boolean exact) {
            super(ArrayHandle.FORM, be, exact);
        }

        @Override
        public ArrayHandle withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new ArrayHandle(be, true);
        }

        @Override
        public ArrayHandle withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new ArrayHandle(be, false);
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(byte[].class, double.class, int.class);
        }

        private static final BiFunction<String, List<Number>, ArrayIndexOutOfBoundsException>
            OOBEF = Preconditions.outOfBoundsExceptionFormatter(ArrayIndexOutOfBoundsException::new);

        @ForceInline
        static int index(byte[] ba, int index) {
            return Preconditions.checkIndex(index, ba.length - ALIGN, OOBEF);
        }

        @ForceInline
        static long address(byte[] ba, int index) {
            long address = ((long) index) + Unsafe.ARRAY_BYTE_BASE_OFFSET;
            if ((address & ALIGN) != 0)
                throw newIllegalStateExceptionForMisalignedAccess(index);
            return address;
        }

        @ForceInline
        static double get(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            long rawValue = UNSAFE.getLongUnaligned(
                    ba,
                    ((long) index(ba, index)) + Unsafe.ARRAY_BYTE_BASE_OFFSET,
                    handle.be);
            return Double.longBitsToDouble(rawValue);
        }

        @ForceInline
        static void set(VarHandle ob, Object oba, int index, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putLongUnaligned(
                    ba,
                    ((long) index(ba, index)) + Unsafe.ARRAY_BYTE_BASE_OFFSET,
                    Double.doubleToRawLongBits(value),
                    handle.be);
        }

        @ForceInline
        static double getVolatile(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getLongVolatile(
                                      ba,
                                      address(ba, index(ba, index))));
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object oba, int index, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putLongVolatile(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static double getAcquire(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getLongAcquire(
                                      ba,
                                      address(ba, index(ba, index))));
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object oba, int index, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putLongRelease(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static double getOpaque(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getLongOpaque(
                                      ba,
                                      address(ba, index(ba, index))));
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object oba, int index, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putLongOpaque(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object oba, int index, double expected, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.compareAndSetLong(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static double compareAndExchange(VarHandle ob, Object oba, int index, double expected, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.compareAndExchangeLong(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static double compareAndExchangeAcquire(VarHandle ob, Object oba, int index, double expected, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.compareAndExchangeLongAcquire(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static double compareAndExchangeRelease(VarHandle ob, Object oba, int index, double expected, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.compareAndExchangeLongRelease(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object oba, int index, double expected, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.weakCompareAndSetLongPlain(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object oba, int index, double expected, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.weakCompareAndSetLong(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object oba, int index, double expected, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.weakCompareAndSetLongAcquire(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object oba, int index, double expected, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.weakCompareAndSetLongRelease(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static double getAndSet(VarHandle ob, Object oba, int index, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getAndSetLong(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, value)));
        }

        @ForceInline
        static double getAndSetAcquire(VarHandle ob, Object oba, int index, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getAndSetLongAcquire(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, value)));
        }

        @ForceInline
        static double getAndSetRelease(VarHandle ob, Object oba, int index, double value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getAndSetLongRelease(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, value)));
        }

        static final VarForm FORM = new VarForm(ArrayHandle.class, byte[].class, double.class, int.class);
    }


    static final class ByteBufferHandle extends ByteArrayViewVarHandle {

        ByteBufferHandle(boolean be) {
            this(be, false);
        }

        private ByteBufferHandle(boolean be, boolean exact) {
            super(ByteBufferHandle.FORM, be, exact);
        }

        @Override
        public ByteBufferHandle withInvokeExactBehavior() {
            return hasInvokeExactBehavior()
                ? this
                : new ByteBufferHandle(be, true);
        }

        @Override
        public ByteBufferHandle withInvokeBehavior() {
            return !hasInvokeExactBehavior()
                ? this
                : new ByteBufferHandle(be, false);
        }

        @Override
        final MethodType accessModeTypeUncached(AccessType at) {
            return at.accessModeType(ByteBuffer.class, double.class, int.class);
        }

        @ForceInline
        static int index(ByteBuffer bb, int index) {
            MemorySegmentProxy segmentProxy = NIO_ACCESS.bufferSegment(bb);
            return Preconditions.checkIndex(index, UNSAFE.getInt(bb, BUFFER_LIMIT) - ALIGN, null);
        }

        @ForceInline
        static Scope scope(ByteBuffer bb) {
            MemorySegmentProxy segmentProxy = NIO_ACCESS.bufferSegment(bb);
            return segmentProxy != null ?
                    segmentProxy.scope() : null;
        }

        @ForceInline
        static int indexRO(ByteBuffer bb, int index) {
            if (UNSAFE.getBoolean(bb, BYTE_BUFFER_IS_READ_ONLY))
                throw new ReadOnlyBufferException();
            return index(bb, index);
        }

        @ForceInline
        static long address(ByteBuffer bb, int index) {
            long address = ((long) index) + UNSAFE.getLong(bb, BUFFER_ADDRESS);
            if ((address & ALIGN) != 0)
                throw newIllegalStateExceptionForMisalignedAccess(index);
            return address;
        }

        @ForceInline
        static double get(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            long rawValue = SCOPED_MEMORY_ACCESS.getLongUnaligned(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    ((long) index(bb, index)) + UNSAFE.getLong(bb, BUFFER_ADDRESS),
                    handle.be);
            return Double.longBitsToDouble(rawValue);
        }

        @ForceInline
        static void set(VarHandle ob, Object obb, int index, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putLongUnaligned(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    ((long) indexRO(bb, index)) + UNSAFE.getLong(bb, BUFFER_ADDRESS),
                    Double.doubleToRawLongBits(value),
                    handle.be);
        }

        @ForceInline
        static double getVolatile(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getLongVolatile(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, index(bb, index))));
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object obb, int index, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putLongVolatile(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static double getAcquire(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getLongAcquire(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, index(bb, index))));
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object obb, int index, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putLongRelease(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static double getOpaque(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getLongOpaque(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, index(bb, index))));
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object obb, int index, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putLongOpaque(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object obb, int index, double expected, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.compareAndSetLong(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static double compareAndExchange(VarHandle ob, Object obb, int index, double expected, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.compareAndExchangeLong(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static double compareAndExchangeAcquire(VarHandle ob, Object obb, int index, double expected, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.compareAndExchangeLongAcquire(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static double compareAndExchangeRelease(VarHandle ob, Object obb, int index, double expected, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.compareAndExchangeLongRelease(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object obb, int index, double expected, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.weakCompareAndSetLongPlain(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object obb, int index, double expected, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.weakCompareAndSetLong(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object obb, int index, double expected, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.weakCompareAndSetLongAcquire(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object obb, int index, double expected, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.weakCompareAndSetLongRelease(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static double getAndSet(VarHandle ob, Object obb, int index, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getAndSetLong(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, value)));
        }

        @ForceInline
        static double getAndSetAcquire(VarHandle ob, Object obb, int index, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getAndSetLongAcquire(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, value)));
        }

        @ForceInline
        static double getAndSetRelease(VarHandle ob, Object obb, int index, double value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getAndSetLongRelease(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, value)));
        }

        static final VarForm FORM = new VarForm(ByteBufferHandle.class, ByteBuffer.class, double.class, int.class);
    }
}
