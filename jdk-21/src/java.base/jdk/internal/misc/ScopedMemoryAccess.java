/*
 * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.misc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.foreign.MemorySegment;
import java.lang.ref.Reference;
import java.io.FileDescriptor;
import java.util.function.Supplier;

import jdk.internal.access.JavaNioAccess;
import jdk.internal.access.SharedSecrets;
import jdk.internal.foreign.AbstractMemorySegmentImpl;
import jdk.internal.foreign.MemorySessionImpl;
import jdk.internal.util.ArraysSupport;
import jdk.internal.vm.annotation.ForceInline;
import jdk.internal.vm.vector.VectorSupport;


/**
 * This class defines low-level methods to access on-heap and off-heap memory. The methods in this class
 * can be thought of as thin wrappers around methods provided in the {@link Unsafe} class. All the methods in this
 * class accept one or more {@link MemorySessionImpl} parameter, which is used to validate as to whether access to memory
 * can be performed in a safe fashion - more specifically, to ensure that the memory being accessed has not
 * already been released (which would result in a hard VM crash).
 * <p>
 * Accessing and releasing memory from a single thread is not problematic - after all, a given thread cannot,
 * at the same time, access a memory region <em>and</em> free it. But ensuring correctness of memory access
 * when multiple threads are involved is much trickier, as there can be cases where a thread is accessing
 * a memory region while another thread is releasing it.
 * <p>
 * This class provides tools to manage races when multiple threads are accessing and/or releasing the same memory
 * session concurrently. More specifically, when a thread wants to release a memory session, it should call the
 * {@link ScopedMemoryAccess#closeScope(MemorySessionImpl)} method. This method initiates thread-local handshakes with all the other VM threads,
 * which are then stopped one by one. If any thread is found accessing a resource associated to the very memory session
 * being closed, the handshake fails, and the session will not be closed.
 * <p>
 * This synchronization strategy relies on the idea that accessing memory is atomic with respect to checking the
 * validity of the session associated with that memory region - that is, a thread that wants to perform memory access will be
 * suspended either <em>before</em> a liveness check or <em>after</em> the memory access. To ensure this atomicity,
 * all methods in this class are marked with the special {@link Scoped} annotation, which is recognized by the VM,
 * and used during the thread-local handshake to detect (and stop) threads performing potentially problematic memory access
 * operations. Additionally, to make sure that the session object(s) of the memory being accessed is always
 * reachable during an access operation, all the methods in this class add reachability fences around the underlying
 * unsafe access.
 * <p>
 * This form of synchronization allows APIs to use plain memory access without any other form of synchronization
 * which might be deemed to expensive; in other words, this approach prioritizes the performance of memory access over
 * that of releasing a shared memory resource.
 */
public class ScopedMemoryAccess {

    private static final Unsafe UNSAFE = Unsafe.getUnsafe();

    private static native void registerNatives();
    static {
        registerNatives();
    }

    public boolean closeScope(MemorySessionImpl session) {
        return closeScope0(session);
    }

    native boolean closeScope0(MemorySessionImpl session);

    private ScopedMemoryAccess() {}

    private static final ScopedMemoryAccess theScopedMemoryAccess = new ScopedMemoryAccess();

    public static ScopedMemoryAccess getScopedMemoryAccess() {
        return theScopedMemoryAccess;
    }

    public static final class ScopedAccessError extends Error {

        @SuppressWarnings("serial")
        private final Supplier<RuntimeException> runtimeExceptionSupplier;

        public ScopedAccessError(Supplier<RuntimeException> runtimeExceptionSupplier) {
            super("Invalid memory access", null, false, false);
            this.runtimeExceptionSupplier = runtimeExceptionSupplier;
        }

        static final long serialVersionUID = 1L;

        public final RuntimeException newRuntimeException() {
            return runtimeExceptionSupplier.get();
        }
    }

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Scoped { }

    // bulk ops

    @ForceInline
    public void copyMemory(MemorySessionImpl srcSession, MemorySessionImpl dstSession,
                                   Object srcBase, long srcOffset,
                                   Object destBase, long destOffset,
                                   long bytes) {
          try {
              copyMemoryInternal(srcSession, dstSession, srcBase, srcOffset, destBase, destOffset, bytes);
          } catch (ScopedAccessError ex) {
              throw ex.newRuntimeException();
          }
    }

    @ForceInline @Scoped
    private void copyMemoryInternal(MemorySessionImpl srcSession, MemorySessionImpl dstSession,
                               Object srcBase, long srcOffset,
                               Object destBase, long destOffset,
                               long bytes) {
        try {
            if (srcSession != null) {
                srcSession.checkValidStateRaw();
            }
            if (dstSession != null) {
                dstSession.checkValidStateRaw();
            }
            UNSAFE.copyMemory(srcBase, srcOffset, destBase, destOffset, bytes);
        } finally {
            Reference.reachabilityFence(srcSession);
            Reference.reachabilityFence(dstSession);
        }
    }

    @ForceInline
    public void copySwapMemory(MemorySessionImpl srcSession, MemorySessionImpl dstSession,
                                   Object srcBase, long srcOffset,
                                   Object destBase, long destOffset,
                                   long bytes, long elemSize) {
          try {
              copySwapMemoryInternal(srcSession, dstSession, srcBase, srcOffset, destBase, destOffset, bytes, elemSize);
          } catch (ScopedAccessError ex) {
              throw ex.newRuntimeException();
          }
    }

    @ForceInline @Scoped
    private void copySwapMemoryInternal(MemorySessionImpl srcSession, MemorySessionImpl dstSession,
                               Object srcBase, long srcOffset,
                               Object destBase, long destOffset,
                               long bytes, long elemSize) {
        try {
            if (srcSession != null) {
                srcSession.checkValidStateRaw();
            }
            if (dstSession != null) {
                dstSession.checkValidStateRaw();
            }
            UNSAFE.copySwapMemory(srcBase, srcOffset, destBase, destOffset, bytes, elemSize);
        } finally {
            Reference.reachabilityFence(srcSession);
            Reference.reachabilityFence(dstSession);
        }
    }

    @ForceInline
    public void setMemory(MemorySessionImpl session, Object o, long offset, long bytes, byte value) {
        try {
            setMemoryInternal(session, o, offset, bytes, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void setMemoryInternal(MemorySessionImpl session, Object o, long offset, long bytes, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.setMemory(o, offset, bytes, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int vectorizedMismatch(MemorySessionImpl aSession, MemorySessionImpl bSession,
                                             Object a, long aOffset,
                                             Object b, long bOffset,
                                             int length,
                                             int log2ArrayIndexScale) {
        try {
            return vectorizedMismatchInternal(aSession, bSession, a, aOffset, b, bOffset, length, log2ArrayIndexScale);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int vectorizedMismatchInternal(MemorySessionImpl aSession, MemorySessionImpl bSession,
                                             Object a, long aOffset,
                                             Object b, long bOffset,
                                             int length,
                                             int log2ArrayIndexScale) {
        try {
            if (aSession != null) {
                aSession.checkValidStateRaw();
            }
            if (bSession != null) {
                bSession.checkValidStateRaw();
            }
            return ArraysSupport.vectorizedMismatch(a, aOffset, b, bOffset, length, log2ArrayIndexScale);
        } finally {
            Reference.reachabilityFence(aSession);
            Reference.reachabilityFence(bSession);
        }
    }

    @ForceInline
    public boolean isLoaded(MemorySessionImpl session, long address, boolean isSync, long size) {
        try {
            return isLoadedInternal(session, address, isSync, size);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    public boolean isLoadedInternal(MemorySessionImpl session, long address, boolean isSync, long size) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return SharedSecrets.getJavaNioAccess().isLoaded(address, isSync, size);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void load(MemorySessionImpl session, long address, boolean isSync, long size) {
        try {
            loadInternal(session, address, isSync, size);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    public void loadInternal(MemorySessionImpl session, long address, boolean isSync, long size) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            SharedSecrets.getJavaNioAccess().load(address, isSync, size);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void unload(MemorySessionImpl session, long address, boolean isSync, long size) {
        try {
            unloadInternal(session, address, isSync, size);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    public void unloadInternal(MemorySessionImpl session, long address, boolean isSync, long size) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            SharedSecrets.getJavaNioAccess().unload(address, isSync, size);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void force(MemorySessionImpl session, FileDescriptor fd, long address, boolean isSync, long index, long length) {
        try {
            forceInternal(session, fd, address, isSync, index, length);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    public void forceInternal(MemorySessionImpl session, FileDescriptor fd, long address, boolean isSync, long index, long length) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            SharedSecrets.getJavaNioAccess().force(fd, address, isSync, index, length);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    // MemorySegment vector access ops

    @ForceInline
    public static
    <V extends VectorSupport.Vector<E>, E, S extends VectorSupport.VectorSpecies<E>>
    V loadFromMemorySegment(Class<? extends V> vmClass, Class<E> e, int length,
                         AbstractMemorySegmentImpl msp, long offset,
                         S s,
                         VectorSupport.LoadOperation<AbstractMemorySegmentImpl, V, S> defaultImpl) {
        // @@@ Smarter alignment checking if accessing heap segment backing non-byte[] array
        if (msp.maxAlignMask() > 1) {
            throw new IllegalArgumentException();
        }

        try {
            return loadFromMemorySegmentScopedInternal(
                    msp.sessionImpl(),
                    vmClass, e, length,
                    msp, offset,
                    s,
                    defaultImpl);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @Scoped
    @ForceInline
    private static
    <V extends VectorSupport.Vector<E>, E, S extends VectorSupport.VectorSpecies<E>>
    V loadFromMemorySegmentScopedInternal(MemorySessionImpl session,
                                          Class<? extends V> vmClass, Class<E> e, int length,
                                          AbstractMemorySegmentImpl msp, long offset,
                                          S s,
                                          VectorSupport.LoadOperation<AbstractMemorySegmentImpl, V, S> defaultImpl) {
        try {
            session.checkValidStateRaw();

            return VectorSupport.load(vmClass, e, length,
                    msp.unsafeGetBase(), msp.unsafeGetOffset() + offset,
                    msp, offset, s,
                    defaultImpl);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public static
    <V extends VectorSupport.Vector<E>, E, S extends VectorSupport.VectorSpecies<E>,
     M extends VectorSupport.VectorMask<E>>
    V loadFromMemorySegmentMasked(Class<? extends V> vmClass, Class<M> maskClass, Class<E> e,
                                  int length, AbstractMemorySegmentImpl msp, long offset, M m, S s, int offsetInRange,
                                  VectorSupport.LoadVectorMaskedOperation<AbstractMemorySegmentImpl, V, S, M> defaultImpl) {
        // @@@ Smarter alignment checking if accessing heap segment backing non-byte[] array
        if (msp.maxAlignMask() > 1) {
            throw new IllegalArgumentException();
        }

        try {
            return loadFromMemorySegmentMaskedScopedInternal(
                    msp.sessionImpl(),
                    vmClass, maskClass, e, length,
                    msp, offset, m,
                    s, offsetInRange,
                    defaultImpl);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @Scoped
    @ForceInline
    private static
    <V extends VectorSupport.Vector<E>, E, S extends VectorSupport.VectorSpecies<E>,
     M extends VectorSupport.VectorMask<E>>
    V loadFromMemorySegmentMaskedScopedInternal(MemorySessionImpl session, Class<? extends V> vmClass,
                                                Class<M> maskClass, Class<E> e, int length,
                                                AbstractMemorySegmentImpl msp, long offset, M m,
                                                S s, int offsetInRange,
                                                VectorSupport.LoadVectorMaskedOperation<AbstractMemorySegmentImpl, V, S, M> defaultImpl) {
        try {
            session.checkValidStateRaw();

            return VectorSupport.loadMasked(vmClass, maskClass, e, length,
                    msp.unsafeGetBase(), msp.unsafeGetOffset() + offset, m, offsetInRange,
                    msp, offset, s,
                    defaultImpl);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public static
    <V extends VectorSupport.Vector<E>, E>
    void storeIntoMemorySegment(Class<? extends V> vmClass, Class<E> e, int length,
                                V v,
                                AbstractMemorySegmentImpl msp, long offset,
                                VectorSupport.StoreVectorOperation<AbstractMemorySegmentImpl, V> defaultImpl) {
        // @@@ Smarter alignment checking if accessing heap segment backing non-byte[] array
        if (msp.maxAlignMask() > 1) {
            throw new IllegalArgumentException();
        }

        try {
            storeIntoMemorySegmentScopedInternal(
                    msp.sessionImpl(),
                    vmClass, e, length,
                    v,
                    msp, offset,
                    defaultImpl);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @Scoped
    @ForceInline
    private static
    <V extends VectorSupport.Vector<E>, E>
    void storeIntoMemorySegmentScopedInternal(MemorySessionImpl session,
                                              Class<? extends V> vmClass, Class<E> e, int length,
                                              V v,
                                              AbstractMemorySegmentImpl msp, long offset,
                                              VectorSupport.StoreVectorOperation<AbstractMemorySegmentImpl, V> defaultImpl) {
        try {
            session.checkValidStateRaw();

            VectorSupport.store(vmClass, e, length,
                    msp.unsafeGetBase(), msp.unsafeGetOffset() + offset,
                    v,
                    msp, offset,
                    defaultImpl);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public static
    <V extends VectorSupport.Vector<E>, E, M extends VectorSupport.VectorMask<E>>
    void storeIntoMemorySegmentMasked(Class<? extends V> vmClass, Class<M> maskClass, Class<E> e,
                                      int length, V v, M m,
                                      AbstractMemorySegmentImpl msp, long offset,
                                      VectorSupport.StoreVectorMaskedOperation<AbstractMemorySegmentImpl, V, M> defaultImpl) {
        // @@@ Smarter alignment checking if accessing heap segment backing non-byte[] array
        if (msp.maxAlignMask() > 1) {
            throw new IllegalArgumentException();
        }

        try {
            storeIntoMemorySegmentMaskedScopedInternal(
                    msp.sessionImpl(),
                    vmClass, maskClass, e, length,
                    v, m,
                    msp, offset,
                    defaultImpl);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @Scoped
    @ForceInline
    private static
    <V extends VectorSupport.Vector<E>, E, M extends VectorSupport.VectorMask<E>>
    void storeIntoMemorySegmentMaskedScopedInternal(MemorySessionImpl session,
                                                    Class<? extends V> vmClass, Class<M> maskClass,
                                                    Class<E> e, int length, V v, M m,
                                                    AbstractMemorySegmentImpl msp, long offset,
                                                    VectorSupport.StoreVectorMaskedOperation<AbstractMemorySegmentImpl, V, M> defaultImpl) {
        try {
            session.checkValidStateRaw();

            VectorSupport.storeMasked(vmClass, maskClass, e, length,
                    msp.unsafeGetBase(), msp.unsafeGetOffset() + offset,
                    v, m,
                    msp, offset,
                    defaultImpl);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    // typed-ops here

    // Note: all the accessor methods defined below take advantage of argument type profiling
    // (see src/hotspot/share/oops/methodData.cpp) which greatly enhances performance when the same accessor
    // method is used repeatedly with different 'base' objects.
    @ForceInline
    public byte getByte(MemorySessionImpl session, Object base, long offset) {
        try {
            return getByteInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getByteInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getByte(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putByte(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            putByteInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putByteInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putByte(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }


    @ForceInline
    public byte getByteVolatile(MemorySessionImpl session, Object base, long offset) {
        try {
            return getByteVolatileInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getByteVolatileInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getByteVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putByteVolatile(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            putByteVolatileInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putByteVolatileInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putByteVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getByteAcquire(MemorySessionImpl session, Object base, long offset) {
        try {
            return getByteAcquireInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getByteAcquireInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getByteAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putByteRelease(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            putByteReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putByteReleaseInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putByteRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getByteOpaque(MemorySessionImpl session, Object base, long offset) {
        try {
            return getByteOpaqueInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getByteOpaqueInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getByteOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public void putByteOpaque(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            putByteOpaqueInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putByteOpaqueInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putByteOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndAddByte(MemorySessionImpl session, Object base, long offset, byte delta) {
        try {
            return getAndAddByteInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndAddByteInternal(MemorySessionImpl session, Object base, long offset, byte delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddByte(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndAddByteAcquire(MemorySessionImpl session, Object base, long offset, byte delta) {
        try {
            return getAndAddByteAcquireInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndAddByteAcquireInternal(MemorySessionImpl session, Object base, long offset, byte delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddByteAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndAddByteRelease(MemorySessionImpl session, Object base, long offset, byte delta) {
        try {
            return getAndAddByteReleaseInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndAddByteReleaseInternal(MemorySessionImpl session, Object base, long offset, byte delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddByteRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndBitwiseOrByte(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            return getAndBitwiseOrByteInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseOrByteInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrByte(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndBitwiseOrByteAcquire(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            return getAndBitwiseOrByteAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseOrByteAcquireInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrByteAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndBitwiseOrByteRelease(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            return getAndBitwiseOrByteReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseOrByteReleaseInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrByteRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndBitwiseAndByte(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            return getAndBitwiseAndByteInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseAndByteInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndByte(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndBitwiseAndByteAcquire(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            return getAndBitwiseAndByteAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseAndByteAcquireInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndByteAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndBitwiseAndByteRelease(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            return getAndBitwiseAndByteReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseAndByteReleaseInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndByteRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndBitwiseXorByte(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            return getAndBitwiseXorByteInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseXorByteInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorByte(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndBitwiseXorByteAcquire(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            return getAndBitwiseXorByteAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseXorByteAcquireInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorByteAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public byte getAndBitwiseXorByteRelease(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            return getAndBitwiseXorByteReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseXorByteReleaseInternal(MemorySessionImpl session, Object base, long offset, byte value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorByteRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public short getShort(MemorySessionImpl session, Object base, long offset) {
        try {
            return getShortInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getShortInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getShort(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putShort(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            putShortInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putShortInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putShort(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getShortUnaligned(MemorySessionImpl session, Object base, long offset, boolean be) {
        try {
            return getShortUnalignedInternal(session, base, offset, be);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getShortUnalignedInternal(MemorySessionImpl session, Object base, long offset, boolean be) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getShortUnaligned(base, offset, be);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putShortUnaligned(MemorySessionImpl session, Object base, long offset, short value, boolean be) {
        try {
            putShortUnalignedInternal(session, base, offset, value, be);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putShortUnalignedInternal(MemorySessionImpl session, Object base, long offset, short value, boolean be) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putShortUnaligned(base, offset, value, be);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getShortVolatile(MemorySessionImpl session, Object base, long offset) {
        try {
            return getShortVolatileInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getShortVolatileInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getShortVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putShortVolatile(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            putShortVolatileInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putShortVolatileInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putShortVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getShortAcquire(MemorySessionImpl session, Object base, long offset) {
        try {
            return getShortAcquireInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getShortAcquireInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getShortAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putShortRelease(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            putShortReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putShortReleaseInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putShortRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getShortOpaque(MemorySessionImpl session, Object base, long offset) {
        try {
            return getShortOpaqueInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getShortOpaqueInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getShortOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public void putShortOpaque(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            putShortOpaqueInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putShortOpaqueInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putShortOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndAddShort(MemorySessionImpl session, Object base, long offset, short delta) {
        try {
            return getAndAddShortInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndAddShortInternal(MemorySessionImpl session, Object base, long offset, short delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddShort(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndAddShortAcquire(MemorySessionImpl session, Object base, long offset, short delta) {
        try {
            return getAndAddShortAcquireInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndAddShortAcquireInternal(MemorySessionImpl session, Object base, long offset, short delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddShortAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndAddShortRelease(MemorySessionImpl session, Object base, long offset, short delta) {
        try {
            return getAndAddShortReleaseInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndAddShortReleaseInternal(MemorySessionImpl session, Object base, long offset, short delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddShortRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndBitwiseOrShort(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            return getAndBitwiseOrShortInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseOrShortInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrShort(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndBitwiseOrShortAcquire(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            return getAndBitwiseOrShortAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseOrShortAcquireInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrShortAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndBitwiseOrShortRelease(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            return getAndBitwiseOrShortReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseOrShortReleaseInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrShortRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndBitwiseAndShort(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            return getAndBitwiseAndShortInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseAndShortInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndShort(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndBitwiseAndShortAcquire(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            return getAndBitwiseAndShortAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseAndShortAcquireInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndShortAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndBitwiseAndShortRelease(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            return getAndBitwiseAndShortReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseAndShortReleaseInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndShortRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndBitwiseXorShort(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            return getAndBitwiseXorShortInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseXorShortInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorShort(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndBitwiseXorShortAcquire(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            return getAndBitwiseXorShortAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseXorShortAcquireInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorShortAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public short getAndBitwiseXorShortRelease(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            return getAndBitwiseXorShortReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseXorShortReleaseInternal(MemorySessionImpl session, Object base, long offset, short value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorShortRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public char getChar(MemorySessionImpl session, Object base, long offset) {
        try {
            return getCharInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getCharInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getChar(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putChar(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            putCharInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putCharInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putChar(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getCharUnaligned(MemorySessionImpl session, Object base, long offset, boolean be) {
        try {
            return getCharUnalignedInternal(session, base, offset, be);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getCharUnalignedInternal(MemorySessionImpl session, Object base, long offset, boolean be) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getCharUnaligned(base, offset, be);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putCharUnaligned(MemorySessionImpl session, Object base, long offset, char value, boolean be) {
        try {
            putCharUnalignedInternal(session, base, offset, value, be);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putCharUnalignedInternal(MemorySessionImpl session, Object base, long offset, char value, boolean be) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putCharUnaligned(base, offset, value, be);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getCharVolatile(MemorySessionImpl session, Object base, long offset) {
        try {
            return getCharVolatileInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getCharVolatileInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getCharVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putCharVolatile(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            putCharVolatileInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putCharVolatileInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putCharVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getCharAcquire(MemorySessionImpl session, Object base, long offset) {
        try {
            return getCharAcquireInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getCharAcquireInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getCharAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putCharRelease(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            putCharReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putCharReleaseInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putCharRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getCharOpaque(MemorySessionImpl session, Object base, long offset) {
        try {
            return getCharOpaqueInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getCharOpaqueInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getCharOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public void putCharOpaque(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            putCharOpaqueInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putCharOpaqueInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putCharOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndAddChar(MemorySessionImpl session, Object base, long offset, char delta) {
        try {
            return getAndAddCharInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndAddCharInternal(MemorySessionImpl session, Object base, long offset, char delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddChar(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndAddCharAcquire(MemorySessionImpl session, Object base, long offset, char delta) {
        try {
            return getAndAddCharAcquireInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndAddCharAcquireInternal(MemorySessionImpl session, Object base, long offset, char delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddCharAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndAddCharRelease(MemorySessionImpl session, Object base, long offset, char delta) {
        try {
            return getAndAddCharReleaseInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndAddCharReleaseInternal(MemorySessionImpl session, Object base, long offset, char delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddCharRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndBitwiseOrChar(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            return getAndBitwiseOrCharInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseOrCharInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrChar(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndBitwiseOrCharAcquire(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            return getAndBitwiseOrCharAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseOrCharAcquireInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrCharAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndBitwiseOrCharRelease(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            return getAndBitwiseOrCharReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseOrCharReleaseInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrCharRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndBitwiseAndChar(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            return getAndBitwiseAndCharInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseAndCharInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndChar(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndBitwiseAndCharAcquire(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            return getAndBitwiseAndCharAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseAndCharAcquireInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndCharAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndBitwiseAndCharRelease(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            return getAndBitwiseAndCharReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseAndCharReleaseInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndCharRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndBitwiseXorChar(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            return getAndBitwiseXorCharInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseXorCharInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorChar(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndBitwiseXorCharAcquire(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            return getAndBitwiseXorCharAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseXorCharAcquireInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorCharAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public char getAndBitwiseXorCharRelease(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            return getAndBitwiseXorCharReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseXorCharReleaseInternal(MemorySessionImpl session, Object base, long offset, char value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorCharRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public int getInt(MemorySessionImpl session, Object base, long offset) {
        try {
            return getIntInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getIntInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getInt(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putInt(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            putIntInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putIntInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putInt(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getIntUnaligned(MemorySessionImpl session, Object base, long offset, boolean be) {
        try {
            return getIntUnalignedInternal(session, base, offset, be);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getIntUnalignedInternal(MemorySessionImpl session, Object base, long offset, boolean be) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getIntUnaligned(base, offset, be);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putIntUnaligned(MemorySessionImpl session, Object base, long offset, int value, boolean be) {
        try {
            putIntUnalignedInternal(session, base, offset, value, be);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putIntUnalignedInternal(MemorySessionImpl session, Object base, long offset, int value, boolean be) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putIntUnaligned(base, offset, value, be);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getIntVolatile(MemorySessionImpl session, Object base, long offset) {
        try {
            return getIntVolatileInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getIntVolatileInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getIntVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putIntVolatile(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            putIntVolatileInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putIntVolatileInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putIntVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getIntAcquire(MemorySessionImpl session, Object base, long offset) {
        try {
            return getIntAcquireInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getIntAcquireInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getIntAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putIntRelease(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            putIntReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putIntReleaseInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putIntRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getIntOpaque(MemorySessionImpl session, Object base, long offset) {
        try {
            return getIntOpaqueInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getIntOpaqueInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getIntOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public void putIntOpaque(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            putIntOpaqueInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putIntOpaqueInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putIntOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public boolean compareAndSetInt(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            return compareAndSetIntInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean compareAndSetIntInternal(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndSetInt(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int compareAndExchangeInt(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            return compareAndExchangeIntInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int compareAndExchangeIntInternal(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeInt(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int compareAndExchangeIntAcquire(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            return compareAndExchangeIntAcquireInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int compareAndExchangeIntAcquireInternal(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeIntAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int compareAndExchangeIntRelease(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            return compareAndExchangeIntReleaseInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int compareAndExchangeIntReleaseInternal(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeIntRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetIntPlain(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            return weakCompareAndSetIntPlainInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetIntPlainInternal(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetIntPlain(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetInt(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            return weakCompareAndSetIntInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetIntInternal(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetInt(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetIntAcquire(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            return weakCompareAndSetIntAcquireInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetIntAcquireInternal(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetIntAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetIntRelease(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            return weakCompareAndSetIntReleaseInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetIntReleaseInternal(MemorySessionImpl session, Object base, long offset, int expected, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetIntRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndSetInt(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndSetIntInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndSetIntInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetInt(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndSetIntAcquire(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndSetIntAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndSetIntAcquireInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetIntAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndSetIntRelease(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndSetIntReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndSetIntReleaseInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetIntRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndAddInt(MemorySessionImpl session, Object base, long offset, int delta) {
        try {
            return getAndAddIntInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndAddIntInternal(MemorySessionImpl session, Object base, long offset, int delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddInt(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndAddIntAcquire(MemorySessionImpl session, Object base, long offset, int delta) {
        try {
            return getAndAddIntAcquireInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndAddIntAcquireInternal(MemorySessionImpl session, Object base, long offset, int delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddIntAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndAddIntRelease(MemorySessionImpl session, Object base, long offset, int delta) {
        try {
            return getAndAddIntReleaseInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndAddIntReleaseInternal(MemorySessionImpl session, Object base, long offset, int delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddIntRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndBitwiseOrInt(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndBitwiseOrIntInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseOrIntInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrInt(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndBitwiseOrIntAcquire(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndBitwiseOrIntAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseOrIntAcquireInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrIntAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndBitwiseOrIntRelease(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndBitwiseOrIntReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseOrIntReleaseInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrIntRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndBitwiseAndInt(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndBitwiseAndIntInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseAndIntInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndInt(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndBitwiseAndIntAcquire(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndBitwiseAndIntAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseAndIntAcquireInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndIntAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndBitwiseAndIntRelease(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndBitwiseAndIntReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseAndIntReleaseInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndIntRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndBitwiseXorInt(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndBitwiseXorIntInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseXorIntInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorInt(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndBitwiseXorIntAcquire(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndBitwiseXorIntAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseXorIntAcquireInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorIntAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public int getAndBitwiseXorIntRelease(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            return getAndBitwiseXorIntReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseXorIntReleaseInternal(MemorySessionImpl session, Object base, long offset, int value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorIntRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public long getLong(MemorySessionImpl session, Object base, long offset) {
        try {
            return getLongInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getLongInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getLong(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putLong(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            putLongInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putLongInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putLong(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getLongUnaligned(MemorySessionImpl session, Object base, long offset, boolean be) {
        try {
            return getLongUnalignedInternal(session, base, offset, be);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getLongUnalignedInternal(MemorySessionImpl session, Object base, long offset, boolean be) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getLongUnaligned(base, offset, be);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putLongUnaligned(MemorySessionImpl session, Object base, long offset, long value, boolean be) {
        try {
            putLongUnalignedInternal(session, base, offset, value, be);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putLongUnalignedInternal(MemorySessionImpl session, Object base, long offset, long value, boolean be) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putLongUnaligned(base, offset, value, be);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getLongVolatile(MemorySessionImpl session, Object base, long offset) {
        try {
            return getLongVolatileInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getLongVolatileInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getLongVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putLongVolatile(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            putLongVolatileInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putLongVolatileInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putLongVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getLongAcquire(MemorySessionImpl session, Object base, long offset) {
        try {
            return getLongAcquireInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getLongAcquireInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getLongAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putLongRelease(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            putLongReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putLongReleaseInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putLongRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getLongOpaque(MemorySessionImpl session, Object base, long offset) {
        try {
            return getLongOpaqueInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getLongOpaqueInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getLongOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public void putLongOpaque(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            putLongOpaqueInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putLongOpaqueInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putLongOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public boolean compareAndSetLong(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            return compareAndSetLongInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean compareAndSetLongInternal(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndSetLong(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long compareAndExchangeLong(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            return compareAndExchangeLongInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long compareAndExchangeLongInternal(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeLong(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long compareAndExchangeLongAcquire(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            return compareAndExchangeLongAcquireInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long compareAndExchangeLongAcquireInternal(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeLongAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long compareAndExchangeLongRelease(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            return compareAndExchangeLongReleaseInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long compareAndExchangeLongReleaseInternal(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeLongRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetLongPlain(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            return weakCompareAndSetLongPlainInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetLongPlainInternal(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetLongPlain(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetLong(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            return weakCompareAndSetLongInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetLongInternal(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetLong(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetLongAcquire(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            return weakCompareAndSetLongAcquireInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetLongAcquireInternal(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetLongAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetLongRelease(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            return weakCompareAndSetLongReleaseInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetLongReleaseInternal(MemorySessionImpl session, Object base, long offset, long expected, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetLongRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndSetLong(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndSetLongInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndSetLongInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetLong(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndSetLongAcquire(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndSetLongAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndSetLongAcquireInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetLongAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndSetLongRelease(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndSetLongReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndSetLongReleaseInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetLongRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndAddLong(MemorySessionImpl session, Object base, long offset, long delta) {
        try {
            return getAndAddLongInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndAddLongInternal(MemorySessionImpl session, Object base, long offset, long delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddLong(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndAddLongAcquire(MemorySessionImpl session, Object base, long offset, long delta) {
        try {
            return getAndAddLongAcquireInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndAddLongAcquireInternal(MemorySessionImpl session, Object base, long offset, long delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddLongAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndAddLongRelease(MemorySessionImpl session, Object base, long offset, long delta) {
        try {
            return getAndAddLongReleaseInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndAddLongReleaseInternal(MemorySessionImpl session, Object base, long offset, long delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddLongRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndBitwiseOrLong(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndBitwiseOrLongInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseOrLongInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrLong(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndBitwiseOrLongAcquire(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndBitwiseOrLongAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseOrLongAcquireInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrLongAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndBitwiseOrLongRelease(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndBitwiseOrLongReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseOrLongReleaseInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseOrLongRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndBitwiseAndLong(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndBitwiseAndLongInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseAndLongInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndLong(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndBitwiseAndLongAcquire(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndBitwiseAndLongAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseAndLongAcquireInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndLongAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndBitwiseAndLongRelease(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndBitwiseAndLongReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseAndLongReleaseInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseAndLongRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndBitwiseXorLong(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndBitwiseXorLongInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseXorLongInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorLong(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndBitwiseXorLongAcquire(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndBitwiseXorLongAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseXorLongAcquireInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorLongAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public long getAndBitwiseXorLongRelease(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            return getAndBitwiseXorLongReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseXorLongReleaseInternal(MemorySessionImpl session, Object base, long offset, long value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndBitwiseXorLongRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public float getFloat(MemorySessionImpl session, Object base, long offset) {
        try {
            return getFloatInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float getFloatInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getFloat(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putFloat(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            putFloatInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putFloatInternal(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putFloat(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }


    @ForceInline
    public float getFloatVolatile(MemorySessionImpl session, Object base, long offset) {
        try {
            return getFloatVolatileInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float getFloatVolatileInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getFloatVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putFloatVolatile(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            putFloatVolatileInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putFloatVolatileInternal(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putFloatVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float getFloatAcquire(MemorySessionImpl session, Object base, long offset) {
        try {
            return getFloatAcquireInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float getFloatAcquireInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getFloatAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putFloatRelease(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            putFloatReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putFloatReleaseInternal(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putFloatRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float getFloatOpaque(MemorySessionImpl session, Object base, long offset) {
        try {
            return getFloatOpaqueInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float getFloatOpaqueInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getFloatOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public void putFloatOpaque(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            putFloatOpaqueInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putFloatOpaqueInternal(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putFloatOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public boolean compareAndSetFloat(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            return compareAndSetFloatInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean compareAndSetFloatInternal(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndSetFloat(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float compareAndExchangeFloat(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            return compareAndExchangeFloatInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float compareAndExchangeFloatInternal(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeFloat(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float compareAndExchangeFloatAcquire(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            return compareAndExchangeFloatAcquireInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float compareAndExchangeFloatAcquireInternal(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeFloatAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float compareAndExchangeFloatRelease(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            return compareAndExchangeFloatReleaseInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float compareAndExchangeFloatReleaseInternal(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeFloatRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetFloatPlain(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            return weakCompareAndSetFloatPlainInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetFloatPlainInternal(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetFloatPlain(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetFloat(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            return weakCompareAndSetFloatInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetFloatInternal(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetFloat(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetFloatAcquire(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            return weakCompareAndSetFloatAcquireInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetFloatAcquireInternal(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetFloatAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetFloatRelease(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            return weakCompareAndSetFloatReleaseInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetFloatReleaseInternal(MemorySessionImpl session, Object base, long offset, float expected, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetFloatRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float getAndSetFloat(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            return getAndSetFloatInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float getAndSetFloatInternal(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetFloat(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float getAndSetFloatAcquire(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            return getAndSetFloatAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float getAndSetFloatAcquireInternal(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetFloatAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float getAndSetFloatRelease(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            return getAndSetFloatReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float getAndSetFloatReleaseInternal(MemorySessionImpl session, Object base, long offset, float value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetFloatRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float getAndAddFloat(MemorySessionImpl session, Object base, long offset, float delta) {
        try {
            return getAndAddFloatInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float getAndAddFloatInternal(MemorySessionImpl session, Object base, long offset, float delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddFloat(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float getAndAddFloatAcquire(MemorySessionImpl session, Object base, long offset, float delta) {
        try {
            return getAndAddFloatAcquireInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float getAndAddFloatAcquireInternal(MemorySessionImpl session, Object base, long offset, float delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddFloatAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public float getAndAddFloatRelease(MemorySessionImpl session, Object base, long offset, float delta) {
        try {
            return getAndAddFloatReleaseInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private float getAndAddFloatReleaseInternal(MemorySessionImpl session, Object base, long offset, float delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddFloatRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double getDouble(MemorySessionImpl session, Object base, long offset) {
        try {
            return getDoubleInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double getDoubleInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getDouble(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putDouble(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            putDoubleInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putDoubleInternal(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putDouble(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }


    @ForceInline
    public double getDoubleVolatile(MemorySessionImpl session, Object base, long offset) {
        try {
            return getDoubleVolatileInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double getDoubleVolatileInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getDoubleVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putDoubleVolatile(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            putDoubleVolatileInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putDoubleVolatileInternal(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putDoubleVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double getDoubleAcquire(MemorySessionImpl session, Object base, long offset) {
        try {
            return getDoubleAcquireInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double getDoubleAcquireInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getDoubleAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public void putDoubleRelease(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            putDoubleReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putDoubleReleaseInternal(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putDoubleRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double getDoubleOpaque(MemorySessionImpl session, Object base, long offset) {
        try {
            return getDoubleOpaqueInternal(session, base, offset);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double getDoubleOpaqueInternal(MemorySessionImpl session, Object base, long offset) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getDoubleOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public void putDoubleOpaque(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            putDoubleOpaqueInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private void putDoubleOpaqueInternal(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            UNSAFE.putDoubleOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }
    @ForceInline
    public boolean compareAndSetDouble(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            return compareAndSetDoubleInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean compareAndSetDoubleInternal(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndSetDouble(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double compareAndExchangeDouble(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            return compareAndExchangeDoubleInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double compareAndExchangeDoubleInternal(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeDouble(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double compareAndExchangeDoubleAcquire(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            return compareAndExchangeDoubleAcquireInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double compareAndExchangeDoubleAcquireInternal(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeDoubleAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double compareAndExchangeDoubleRelease(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            return compareAndExchangeDoubleReleaseInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double compareAndExchangeDoubleReleaseInternal(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.compareAndExchangeDoubleRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetDoublePlain(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            return weakCompareAndSetDoublePlainInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetDoublePlainInternal(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetDoublePlain(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetDouble(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            return weakCompareAndSetDoubleInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetDoubleInternal(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetDouble(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetDoubleAcquire(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            return weakCompareAndSetDoubleAcquireInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetDoubleAcquireInternal(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetDoubleAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetDoubleRelease(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            return weakCompareAndSetDoubleReleaseInternal(session, base, offset, expected, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetDoubleReleaseInternal(MemorySessionImpl session, Object base, long offset, double expected, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.weakCompareAndSetDoubleRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double getAndSetDouble(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            return getAndSetDoubleInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double getAndSetDoubleInternal(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetDouble(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double getAndSetDoubleAcquire(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            return getAndSetDoubleAcquireInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double getAndSetDoubleAcquireInternal(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetDoubleAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double getAndSetDoubleRelease(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            return getAndSetDoubleReleaseInternal(session, base, offset, value);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double getAndSetDoubleReleaseInternal(MemorySessionImpl session, Object base, long offset, double value) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndSetDoubleRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double getAndAddDouble(MemorySessionImpl session, Object base, long offset, double delta) {
        try {
            return getAndAddDoubleInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double getAndAddDoubleInternal(MemorySessionImpl session, Object base, long offset, double delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddDouble(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double getAndAddDoubleAcquire(MemorySessionImpl session, Object base, long offset, double delta) {
        try {
            return getAndAddDoubleAcquireInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double getAndAddDoubleAcquireInternal(MemorySessionImpl session, Object base, long offset, double delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddDoubleAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

    @ForceInline
    public double getAndAddDoubleRelease(MemorySessionImpl session, Object base, long offset, double delta) {
        try {
            return getAndAddDoubleReleaseInternal(session, base, offset, delta);
        } catch (ScopedAccessError ex) {
            throw ex.newRuntimeException();
        }
    }

    @ForceInline @Scoped
    private double getAndAddDoubleReleaseInternal(MemorySessionImpl session, Object base, long offset, double delta) {
        try {
            if (session != null) {
                session.checkValidStateRaw();
            }
            return UNSAFE.getAndAddDoubleRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(session);
        }
    }

}
