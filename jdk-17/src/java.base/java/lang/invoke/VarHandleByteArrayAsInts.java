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

final class VarHandleByteArrayAsInts extends VarHandleByteArrayBase {

    static final JavaNioAccess NIO_ACCESS = SharedSecrets.getJavaNioAccess();

    static final int ALIGN = Integer.BYTES - 1;
    
    static final ScopedMemoryAccess SCOPED_MEMORY_ACCESS = ScopedMemoryAccess.getScopedMemoryAccess();

    @ForceInline
    static int convEndian(boolean big, int n) {
        return big == BE ? n : Integer.reverseBytes(n);
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
            return at.accessModeType(byte[].class, int.class, int.class);
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
        static int get(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.getIntUnaligned(
                    ba,
                    ((long) index(ba, index)) + Unsafe.ARRAY_BYTE_BASE_OFFSET,
                    handle.be);
        }

        @ForceInline
        static void set(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putIntUnaligned(
                    ba,
                    ((long) index(ba, index)) + Unsafe.ARRAY_BYTE_BASE_OFFSET,
                    value,
                    handle.be);
        }

        @ForceInline
        static int getVolatile(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getIntVolatile(
                                      ba,
                                      address(ba, index(ba, index))));
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putIntVolatile(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static int getAcquire(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getIntAcquire(
                                      ba,
                                      address(ba, index(ba, index))));
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putIntRelease(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static int getOpaque(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getIntOpaque(
                                      ba,
                                      address(ba, index(ba, index))));
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putIntOpaque(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object oba, int index, int expected, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.compareAndSetInt(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static int compareAndExchange(VarHandle ob, Object oba, int index, int expected, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.compareAndExchangeInt(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static int compareAndExchangeAcquire(VarHandle ob, Object oba, int index, int expected, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.compareAndExchangeIntAcquire(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static int compareAndExchangeRelease(VarHandle ob, Object oba, int index, int expected, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.compareAndExchangeIntRelease(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object oba, int index, int expected, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.weakCompareAndSetIntPlain(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object oba, int index, int expected, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.weakCompareAndSetInt(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object oba, int index, int expected, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.weakCompareAndSetIntAcquire(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object oba, int index, int expected, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.weakCompareAndSetIntRelease(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static int getAndSet(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getAndSetInt(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, value)));
        }

        @ForceInline
        static int getAndSetAcquire(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getAndSetIntAcquire(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, value)));
        }

        @ForceInline
        static int getAndSetRelease(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getAndSetIntRelease(
                                      ba,
                                      address(ba, index(ba, index)),
                                      convEndian(handle.be, value)));
        }

        @ForceInline
        static int getAndAdd(VarHandle ob, Object oba, int index, int delta) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndAddInt(
                        ba,
                        address(ba, index(ba, index)),
                        delta);
            } else {
                return getAndAddConvEndianWithCAS(ba, index, delta);
            }
        }

        @ForceInline
        static int getAndAddAcquire(VarHandle ob, Object oba, int index, int delta) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndAddIntAcquire(
                        ba,
                        address(ba, index(ba, index)),
                        delta);
            } else {
                return getAndAddConvEndianWithCAS(ba, index, delta);
            }
        }

        @ForceInline
        static int getAndAddRelease(VarHandle ob, Object oba, int index, int delta) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndAddIntRelease(
                        ba,
                        address(ba, index(ba, index)),
                        delta);
            } else {
                return getAndAddConvEndianWithCAS(ba, index, delta);
            }
        }

        @ForceInline
        static int getAndAddConvEndianWithCAS(byte[] ba, int index, int delta) {
            int nativeExpectedValue, expectedValue;
            long offset = address(ba, index(ba, index));
            do {
                nativeExpectedValue = UNSAFE.getIntVolatile(ba, offset);
                expectedValue = Integer.reverseBytes(nativeExpectedValue);
            } while (!UNSAFE.weakCompareAndSetInt(ba, offset,
                    nativeExpectedValue, Integer.reverseBytes(expectedValue + delta)));
            return expectedValue;
        }

        @ForceInline
        static int getAndBitwiseOr(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndBitwiseOrInt(
                        ba,
                        address(ba, index(ba, index)),
                        value);
            } else {
                return getAndBitwiseOrConvEndianWithCAS(ba, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseOrRelease(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndBitwiseOrIntRelease(
                        ba,
                        address(ba, index(ba, index)),
                        value);
            } else {
                return getAndBitwiseOrConvEndianWithCAS(ba, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseOrAcquire(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndBitwiseOrIntAcquire(
                        ba,
                        address(ba, index(ba, index)),
                        value);
            } else {
                return getAndBitwiseOrConvEndianWithCAS(ba, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseOrConvEndianWithCAS(byte[] ba, int index, int value) {
            int nativeExpectedValue, expectedValue;
            long offset = address(ba, index(ba, index));
            do {
                nativeExpectedValue = UNSAFE.getIntVolatile(ba, offset);
                expectedValue = Integer.reverseBytes(nativeExpectedValue);
            } while (!UNSAFE.weakCompareAndSetInt(ba, offset,
                    nativeExpectedValue, Integer.reverseBytes(expectedValue | value)));
            return expectedValue;
        }

        @ForceInline
        static int getAndBitwiseAnd(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndBitwiseAndInt(
                        ba,
                        address(ba, index(ba, index)),
                        value);
            } else {
                return getAndBitwiseAndConvEndianWithCAS(ba, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseAndRelease(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndBitwiseAndIntRelease(
                        ba,
                        address(ba, index(ba, index)),
                        value);
            } else {
                return getAndBitwiseAndConvEndianWithCAS(ba, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseAndAcquire(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndBitwiseAndIntAcquire(
                        ba,
                        address(ba, index(ba, index)),
                        value);
            } else {
                return getAndBitwiseAndConvEndianWithCAS(ba, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseAndConvEndianWithCAS(byte[] ba, int index, int value) {
            int nativeExpectedValue, expectedValue;
            long offset = address(ba, index(ba, index));
            do {
                nativeExpectedValue = UNSAFE.getIntVolatile(ba, offset);
                expectedValue = Integer.reverseBytes(nativeExpectedValue);
            } while (!UNSAFE.weakCompareAndSetInt(ba, offset,
                    nativeExpectedValue, Integer.reverseBytes(expectedValue & value)));
            return expectedValue;
        }

        @ForceInline
        static int getAndBitwiseXor(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndBitwiseXorInt(
                        ba,
                        address(ba, index(ba, index)),
                        value);
            } else {
                return getAndBitwiseXorConvEndianWithCAS(ba, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseXorRelease(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndBitwiseXorIntRelease(
                        ba,
                        address(ba, index(ba, index)),
                        value);
            } else {
                return getAndBitwiseXorConvEndianWithCAS(ba, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseXorAcquire(VarHandle ob, Object oba, int index, int value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            if (handle.be == BE) {
                return UNSAFE.getAndBitwiseXorIntAcquire(
                        ba,
                        address(ba, index(ba, index)),
                        value);
            } else {
                return getAndBitwiseXorConvEndianWithCAS(ba, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseXorConvEndianWithCAS(byte[] ba, int index, int value) {
            int nativeExpectedValue, expectedValue;
            long offset = address(ba, index(ba, index));
            do {
                nativeExpectedValue = UNSAFE.getIntVolatile(ba, offset);
                expectedValue = Integer.reverseBytes(nativeExpectedValue);
            } while (!UNSAFE.weakCompareAndSetInt(ba, offset,
                    nativeExpectedValue, Integer.reverseBytes(expectedValue ^ value)));
            return expectedValue;
        }

        static final VarForm FORM = new VarForm(ArrayHandle.class, byte[].class, int.class, int.class);
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
            return at.accessModeType(ByteBuffer.class, int.class, int.class);
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
        static int get(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.getIntUnaligned(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    ((long) index(bb, index)) + UNSAFE.getLong(bb, BUFFER_ADDRESS),
                    handle.be);
        }

        @ForceInline
        static void set(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putIntUnaligned(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    ((long) indexRO(bb, index)) + UNSAFE.getLong(bb, BUFFER_ADDRESS),
                    value,
                    handle.be);
        }

        @ForceInline
        static int getVolatile(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getIntVolatile(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, index(bb, index))));
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putIntVolatile(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static int getAcquire(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getIntAcquire(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, index(bb, index))));
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putIntRelease(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static int getOpaque(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getIntOpaque(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, index(bb, index))));
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putIntOpaque(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static boolean compareAndSet(VarHandle ob, Object obb, int index, int expected, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.compareAndSetInt(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static int compareAndExchange(VarHandle ob, Object obb, int index, int expected, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.compareAndExchangeInt(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static int compareAndExchangeAcquire(VarHandle ob, Object obb, int index, int expected, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.compareAndExchangeIntAcquire(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static int compareAndExchangeRelease(VarHandle ob, Object obb, int index, int expected, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.compareAndExchangeIntRelease(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, expected), convEndian(handle.be, value)));
        }

        @ForceInline
        static boolean weakCompareAndSetPlain(VarHandle ob, Object obb, int index, int expected, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.weakCompareAndSetIntPlain(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSet(VarHandle ob, Object obb, int index, int expected, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.weakCompareAndSetInt(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSetAcquire(VarHandle ob, Object obb, int index, int expected, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.weakCompareAndSetIntAcquire(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static boolean weakCompareAndSetRelease(VarHandle ob, Object obb, int index, int expected, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.weakCompareAndSetIntRelease(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, expected), convEndian(handle.be, value));
        }

        @ForceInline
        static int getAndSet(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getAndSetInt(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, value)));
        }

        @ForceInline
        static int getAndSetAcquire(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getAndSetIntAcquire(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, value)));
        }

        @ForceInline
        static int getAndSetRelease(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getAndSetIntRelease(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, indexRO(bb, index)),
                                      convEndian(handle.be, value)));
        }

        @ForceInline
        static int getAndAdd(VarHandle ob, Object obb, int index, int delta) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndAddInt(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        delta);
            } else {
                return getAndAddConvEndianWithCAS(bb, index, delta);
            }
        }

        @ForceInline
        static int getAndAddAcquire(VarHandle ob, Object obb, int index, int delta) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndAddIntAcquire(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        delta);
            } else {
                return getAndAddConvEndianWithCAS(bb, index, delta);
            }
        }

        @ForceInline
        static int getAndAddRelease(VarHandle ob, Object obb, int index, int delta) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndAddIntRelease(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        delta);
            } else {
                return getAndAddConvEndianWithCAS(bb, index, delta);
            }
        }

        @ForceInline
        static int getAndAddConvEndianWithCAS(ByteBuffer bb, int index, int delta) {
            int nativeExpectedValue, expectedValue;
            Object base = UNSAFE.getReference(bb, BYTE_BUFFER_HB);
            long offset = address(bb, indexRO(bb, index));
            do {
                nativeExpectedValue = SCOPED_MEMORY_ACCESS.getIntVolatile(scope(bb), base, offset);
                expectedValue = Integer.reverseBytes(nativeExpectedValue);
            } while (!UNSAFE.weakCompareAndSetInt(base, offset,
                    nativeExpectedValue, Integer.reverseBytes(expectedValue + delta)));
            return expectedValue;
        }

        @ForceInline
        static int getAndBitwiseOr(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndBitwiseOrInt(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        value);
            } else {
                return getAndBitwiseOrConvEndianWithCAS(bb, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseOrRelease(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndBitwiseOrIntRelease(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        value);
            } else {
                return getAndBitwiseOrConvEndianWithCAS(bb, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseOrAcquire(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndBitwiseOrIntAcquire(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        value);
            } else {
                return getAndBitwiseOrConvEndianWithCAS(bb, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseOrConvEndianWithCAS(ByteBuffer bb, int index, int value) {
            int nativeExpectedValue, expectedValue;
            Object base = UNSAFE.getReference(bb, BYTE_BUFFER_HB);
            long offset = address(bb, indexRO(bb, index));
            do {
                nativeExpectedValue = SCOPED_MEMORY_ACCESS.getIntVolatile(scope(bb), base, offset);
                expectedValue = Integer.reverseBytes(nativeExpectedValue);
            } while (!UNSAFE.weakCompareAndSetInt(base, offset,
                    nativeExpectedValue, Integer.reverseBytes(expectedValue | value)));
            return expectedValue;
        }

        @ForceInline
        static int getAndBitwiseAnd(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndBitwiseAndInt(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        value);
            } else {
                return getAndBitwiseAndConvEndianWithCAS(bb, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseAndRelease(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndBitwiseAndIntRelease(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        value);
            } else {
                return getAndBitwiseAndConvEndianWithCAS(bb, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseAndAcquire(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndBitwiseAndIntAcquire(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        value);
            } else {
                return getAndBitwiseAndConvEndianWithCAS(bb, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseAndConvEndianWithCAS(ByteBuffer bb, int index, int value) {
            int nativeExpectedValue, expectedValue;
            Object base = UNSAFE.getReference(bb, BYTE_BUFFER_HB);
            long offset = address(bb, indexRO(bb, index));
            do {
                nativeExpectedValue = SCOPED_MEMORY_ACCESS.getIntVolatile(scope(bb), base, offset);
                expectedValue = Integer.reverseBytes(nativeExpectedValue);
            } while (!UNSAFE.weakCompareAndSetInt(base, offset,
                    nativeExpectedValue, Integer.reverseBytes(expectedValue & value)));
            return expectedValue;
        }


        @ForceInline
        static int getAndBitwiseXor(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndBitwiseXorInt(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        value);
            } else {
                return getAndBitwiseXorConvEndianWithCAS(bb, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseXorRelease(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndBitwiseXorIntRelease(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        value);
            } else {
                return getAndBitwiseXorConvEndianWithCAS(bb, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseXorAcquire(VarHandle ob, Object obb, int index, int value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            if (handle.be == BE) {
                return SCOPED_MEMORY_ACCESS.getAndBitwiseXorIntAcquire(scope(bb),
                        UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                        address(bb, indexRO(bb, index)),
                        value);
            } else {
                return getAndBitwiseXorConvEndianWithCAS(bb, index, value);
            }
        }

        @ForceInline
        static int getAndBitwiseXorConvEndianWithCAS(ByteBuffer bb, int index, int value) {
            int nativeExpectedValue, expectedValue;
            Object base = UNSAFE.getReference(bb, BYTE_BUFFER_HB);
            long offset = address(bb, indexRO(bb, index));
            do {
                nativeExpectedValue = SCOPED_MEMORY_ACCESS.getIntVolatile(scope(bb), base, offset);
                expectedValue = Integer.reverseBytes(nativeExpectedValue);
            } while (!UNSAFE.weakCompareAndSetInt(base, offset,
                    nativeExpectedValue, Integer.reverseBytes(expectedValue ^ value)));
            return expectedValue;
        }

        static final VarForm FORM = new VarForm(ByteBufferHandle.class, ByteBuffer.class, int.class, int.class);
    }
}
