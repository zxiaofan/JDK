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

final class VarHandleByteArrayAsShorts extends VarHandleByteArrayBase {

    static final JavaNioAccess NIO_ACCESS = SharedSecrets.getJavaNioAccess();

    static final int ALIGN = Short.BYTES - 1;
    
    static final ScopedMemoryAccess SCOPED_MEMORY_ACCESS = ScopedMemoryAccess.getScopedMemoryAccess();

    @ForceInline
    static short convEndian(boolean big, short n) {
        return big == BE ? n : Short.reverseBytes(n);
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
            return at.accessModeType(byte[].class, short.class, int.class);
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
        static short get(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return UNSAFE.getShortUnaligned(
                    ba,
                    ((long) index(ba, index)) + Unsafe.ARRAY_BYTE_BASE_OFFSET,
                    handle.be);
        }

        @ForceInline
        static void set(VarHandle ob, Object oba, int index, short value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putShortUnaligned(
                    ba,
                    ((long) index(ba, index)) + Unsafe.ARRAY_BYTE_BASE_OFFSET,
                    value,
                    handle.be);
        }

        @ForceInline
        static short getVolatile(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getShortVolatile(
                                      ba,
                                      address(ba, index(ba, index))));
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object oba, int index, short value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putShortVolatile(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static short getAcquire(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getShortAcquire(
                                      ba,
                                      address(ba, index(ba, index))));
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object oba, int index, short value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putShortRelease(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static short getOpaque(VarHandle ob, Object oba, int index) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            return convEndian(handle.be,
                              UNSAFE.getShortOpaque(
                                      ba,
                                      address(ba, index(ba, index))));
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object oba, int index, short value) {
            ArrayHandle handle = (ArrayHandle)ob;
            byte[] ba = (byte[]) oba;
            UNSAFE.putShortOpaque(
                    ba,
                    address(ba, index(ba, index)),
                    convEndian(handle.be, value));
        }

        static final VarForm FORM = new VarForm(ArrayHandle.class, byte[].class, short.class, int.class);
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
            return at.accessModeType(ByteBuffer.class, short.class, int.class);
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
        static short get(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return SCOPED_MEMORY_ACCESS.getShortUnaligned(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    ((long) index(bb, index)) + UNSAFE.getLong(bb, BUFFER_ADDRESS),
                    handle.be);
        }

        @ForceInline
        static void set(VarHandle ob, Object obb, int index, short value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putShortUnaligned(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    ((long) indexRO(bb, index)) + UNSAFE.getLong(bb, BUFFER_ADDRESS),
                    value,
                    handle.be);
        }

        @ForceInline
        static short getVolatile(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getShortVolatile(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, index(bb, index))));
        }

        @ForceInline
        static void setVolatile(VarHandle ob, Object obb, int index, short value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putShortVolatile(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static short getAcquire(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getShortAcquire(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, index(bb, index))));
        }

        @ForceInline
        static void setRelease(VarHandle ob, Object obb, int index, short value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putShortRelease(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, value));
        }

        @ForceInline
        static short getOpaque(VarHandle ob, Object obb, int index) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            return convEndian(handle.be,
                              SCOPED_MEMORY_ACCESS.getShortOpaque(scope(bb),
                                      UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                                      address(bb, index(bb, index))));
        }

        @ForceInline
        static void setOpaque(VarHandle ob, Object obb, int index, short value) {
            ByteBufferHandle handle = (ByteBufferHandle)ob;
            ByteBuffer bb = (ByteBuffer) Objects.requireNonNull(obb);
            SCOPED_MEMORY_ACCESS.putShortOpaque(scope(bb),
                    UNSAFE.getReference(bb, BYTE_BUFFER_HB),
                    address(bb, indexRO(bb, index)),
                    convEndian(handle.be, value));
        }

        static final VarForm FORM = new VarForm(ByteBufferHandle.class, ByteBuffer.class, short.class, int.class);
    }
}
