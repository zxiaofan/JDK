/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.misc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.Reference;
import java.io.FileDescriptor;
import java.nio.Buffer;
import java.nio.ByteBuffer;

import jdk.internal.access.JavaNioAccess;
import jdk.internal.access.SharedSecrets;
import jdk.internal.access.foreign.MemorySegmentProxy;
import jdk.internal.util.ArraysSupport;
import jdk.internal.vm.annotation.ForceInline;
import jdk.internal.vm.vector.VectorSupport;


/**
 * This class defines low-level methods to access on-heap and off-heap memory. The methods in this class
 * can be thought of as thin wrappers around methods provided in the {@link Unsafe} class. All the methods in this
 * class, accept one or more {@link Scope} parameter, which is used to validate as to whether access to memory
 * can be performed in a safe fashion - more specifically, to ensure that the memory being accessed has not
 * already been released (which would result in a hard VM crash).
 * <p>
 * Accessing and releasing memory from a single thread is not problematic - after all, a given thread cannot,
 * at the same time, access a memory region <em>and</em> free it. But ensuring correctness of memory access
 * when multiple threads are involved is much trickier, as there can be cases where a thread is accessing
 * a memory region while another thread is releasing it.
 * <p>
 * This class provides tools to manage races when multiple threads are accessing and/or releasing the same memory
 * region concurrently. More specifically, when a thread wants to release a memory region, it should call the
 * {@link #closeScope(jdk.internal.misc.ScopedMemoryAccess.Scope)} method provided by this class. This method initiates
 * thread-local handshakes with all the other VM threads, which are then stopped one by one. If any thread is found
 * accessing memory that is associated to the very scope object being closed, that thread execution is asynchronously
 * interrupted with a {@link Scope.ScopedAccessError}.
 * <p>
 * This synchronization strategy relies on the idea that accessing memory is atomic with respect to checking the
 * validity of the scope associated with that memory region - that is, a thread that wants to perform memory access will be
 * suspended either <em>before</em> a scope check or <em>after</em> the memory access. To ensure this atomicity,
 * all methods in this class are marked with the special {@link Scoped} annotation, which is recognized by the VM,
 * and used during the thread-local handshake to detect (and stop) threads performing potentially problematic memory access
 * operations. Additionally, to make sure that the scope object(s) of the memory being accessed is always
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

    public boolean closeScope(Scope scope) {
        return closeScope0(scope, Scope.ScopedAccessError.INSTANCE);
    }

    native boolean closeScope0(Scope scope, Scope.ScopedAccessError exception);

    private ScopedMemoryAccess() {}

    private static final ScopedMemoryAccess theScopedMemoryAccess = new ScopedMemoryAccess();

    public static ScopedMemoryAccess getScopedMemoryAccess() {
        return theScopedMemoryAccess;
    }

    /**
     * Scope interface used during scoped memory access operations. A scope can be thought of as an object
     * which embodies the temporal checks associated with a given memory region.
     */
    public interface Scope {

       interface Handle {
            Scope scope();
        }

        void checkValidState();

        Thread ownerThread();

        boolean isImplicit();

        Handle acquire();

        void release(Handle handle);

        /**
         * Error thrown when memory access fails because the memory has already been released.
         * Note: for performance reasons, this exception is never created by client; instead a shared instance
         * is thrown (sometimes, this instance can be thrown asynchronously inside VM code). For this reason,
         * it is important for clients to always catch this exception and throw a regular exception instead
         * (which contains full stack information).
         */
        final class ScopedAccessError extends Error {
            private ScopedAccessError() {
                super("Attempt to access an already released memory resource", null, false, false);
            }
            static final long serialVersionUID = 1L;

            public static final ScopedAccessError INSTANCE = new ScopedAccessError();
        }
    }

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Scoped { }

    // bulk ops

    @ForceInline
    public void copyMemory(Scope srcScope, Scope dstScope,
                                   Object srcBase, long srcOffset,
                                   Object destBase, long destOffset,
                                   long bytes) {
          try {
              copyMemoryInternal(srcScope, dstScope, srcBase, srcOffset, destBase, destOffset, bytes);
          } catch (Scope.ScopedAccessError ex) {
              throw new IllegalStateException("This segment is already closed");
          }
    }

    @ForceInline @Scoped
    private void copyMemoryInternal(Scope srcScope, Scope dstScope,
                               Object srcBase, long srcOffset,
                               Object destBase, long destOffset,
                               long bytes) {
        try {
            if (srcScope != null) {
                srcScope.checkValidState();
            }
            if (dstScope != null) {
                dstScope.checkValidState();
            }
            UNSAFE.copyMemory(srcBase, srcOffset, destBase, destOffset, bytes);
        } finally {
            Reference.reachabilityFence(srcScope);
            Reference.reachabilityFence(dstScope);
        }
    }

    @ForceInline
    public void copySwapMemory(Scope srcScope, Scope dstScope,
                                   Object srcBase, long srcOffset,
                                   Object destBase, long destOffset,
                                   long bytes, long elemSize) {
          try {
              copySwapMemoryInternal(srcScope, dstScope, srcBase, srcOffset, destBase, destOffset, bytes, elemSize);
          } catch (Scope.ScopedAccessError ex) {
              throw new IllegalStateException("This segment is already closed");
          }
    }

    @ForceInline @Scoped
    private void copySwapMemoryInternal(Scope srcScope, Scope dstScope,
                               Object srcBase, long srcOffset,
                               Object destBase, long destOffset,
                               long bytes, long elemSize) {
        try {
            if (srcScope != null) {
                srcScope.checkValidState();
            }
            if (dstScope != null) {
                dstScope.checkValidState();
            }
            UNSAFE.copySwapMemory(srcBase, srcOffset, destBase, destOffset, bytes, elemSize);
        } finally {
            Reference.reachabilityFence(srcScope);
            Reference.reachabilityFence(dstScope);
        }
    }

    @ForceInline
    public void setMemory(Scope scope, Object o, long offset, long bytes, byte value) {
        try {
            setMemoryInternal(scope, o, offset, bytes, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void setMemoryInternal(Scope scope, Object o, long offset, long bytes, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.setMemory(o, offset, bytes, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int vectorizedMismatch(Scope aScope, Scope bScope,
                                             Object a, long aOffset,
                                             Object b, long bOffset,
                                             int length,
                                             int log2ArrayIndexScale) {
        try {
            return vectorizedMismatchInternal(aScope, bScope, a, aOffset, b, bOffset, length, log2ArrayIndexScale);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int vectorizedMismatchInternal(Scope aScope, Scope bScope,
                                             Object a, long aOffset,
                                             Object b, long bOffset,
                                             int length,
                                             int log2ArrayIndexScale) {
        try {
            if (aScope != null) {
                aScope.checkValidState();
            }
            if (bScope != null) {
                bScope.checkValidState();
            }
            return ArraysSupport.vectorizedMismatch(a, aOffset, b, bOffset, length, log2ArrayIndexScale);
        } finally {
            Reference.reachabilityFence(aScope);
            Reference.reachabilityFence(bScope);
        }
    }

    @ForceInline
    public boolean isLoaded(Scope scope, long address, boolean isSync, long size) {
        try {
            return isLoadedInternal(scope, address, isSync, size);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    public boolean isLoadedInternal(Scope scope, long address, boolean isSync, long size) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return SharedSecrets.getJavaNioAccess().isLoaded(address, isSync, size);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void load(Scope scope, long address, boolean isSync, long size) {
        try {
            loadInternal(scope, address, isSync, size);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    public void loadInternal(Scope scope, long address, boolean isSync, long size) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            SharedSecrets.getJavaNioAccess().load(address, isSync, size);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void unload(Scope scope, long address, boolean isSync, long size) {
        try {
            unloadInternal(scope, address, isSync, size);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    public void unloadInternal(Scope scope, long address, boolean isSync, long size) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            SharedSecrets.getJavaNioAccess().unload(address, isSync, size);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void force(Scope scope, FileDescriptor fd, long address, boolean isSync, long index, long length) {
        try {
            forceInternal(scope, fd, address, isSync, index, length);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    public void forceInternal(Scope scope, FileDescriptor fd, long address, boolean isSync, long index, long length) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            SharedSecrets.getJavaNioAccess().force(fd, address, isSync, index, length);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    // ByteBuffer vector access ops

    // Buffer access constants, to be initalized when required.
    // Avoids a null value for NIO_ACCESS, due to class initalization dependencies
    static final class BufferAccess {
        // Buffer.address
        static final long BUFFER_ADDRESS
                = UNSAFE.objectFieldOffset(Buffer.class, "address");

        // ByteBuffer.hb
        static final long BYTE_BUFFER_HB
                = UNSAFE.objectFieldOffset(ByteBuffer.class, "hb");

        @ForceInline
        static Object bufferBase(ByteBuffer bb) {
            return UNSAFE.getReference(bb, BYTE_BUFFER_HB);
        }

        @ForceInline
        static long bufferAddress(ByteBuffer bb, long offset) {
            return UNSAFE.getLong(bb, BUFFER_ADDRESS) + offset;
        }

        static final JavaNioAccess NIO_ACCESS = SharedSecrets.getJavaNioAccess();

        @ForceInline
        static ScopedMemoryAccess.Scope scope(ByteBuffer bb) {
            MemorySegmentProxy segmentProxy = NIO_ACCESS.bufferSegment(bb);
            return segmentProxy != null ?
                    segmentProxy.scope() : null;
        }
    }

    @ForceInline
    public static
    <V extends VectorSupport.Vector<E>, E, S extends VectorSupport.VectorSpecies<E>>
    V loadFromByteBuffer(Class<? extends V> vmClass, Class<E> e, int length,
                          ByteBuffer bb, int offset,
                          S s,
                          VectorSupport.LoadOperation<ByteBuffer, V, E, S> defaultImpl) {
        try {
            return loadFromByteBufferScoped(
                    BufferAccess.scope(bb),
                    vmClass, e, length,
                    bb, offset,
                    s,
                    defaultImpl);
        } catch (ScopedMemoryAccess.Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @Scoped
    @ForceInline
    private static
    <V extends VectorSupport.Vector<E>, E, S extends VectorSupport.VectorSpecies<E>>
    V loadFromByteBufferScoped(ScopedMemoryAccess.Scope scope,
                          Class<? extends V> vmClass, Class<E> e, int length,
                          ByteBuffer bb, int offset,
                          S s,
                          VectorSupport.LoadOperation<ByteBuffer, V, E, S> defaultImpl) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }

            return VectorSupport.load(vmClass, e, length,
                    BufferAccess.bufferBase(bb), BufferAccess.bufferAddress(bb, offset),
                    bb, offset, s,
                    defaultImpl);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public static
    <V extends VectorSupport.Vector<E>, E>
    void storeIntoByteBuffer(Class<? extends V> vmClass, Class<E> e, int length,
                             V v,
                             ByteBuffer bb, int offset,
                             VectorSupport.StoreVectorOperation<ByteBuffer, V> defaultImpl) {
        try {
            storeIntoByteBufferScoped(
                    BufferAccess.scope(bb),
                    vmClass, e, length,
                    v,
                    bb, offset,
                    defaultImpl);
        } catch (ScopedMemoryAccess.Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @Scoped
    @ForceInline
    private static
    <V extends VectorSupport.Vector<E>, E>
    void storeIntoByteBufferScoped(ScopedMemoryAccess.Scope scope,
                                   Class<? extends V> vmClass, Class<E> e, int length,
                                   V v,
                                   ByteBuffer bb, int offset,
                                   VectorSupport.StoreVectorOperation<ByteBuffer, V> defaultImpl) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }

            VectorSupport.store(vmClass, e, length,
                    BufferAccess.bufferBase(bb), BufferAccess.bufferAddress(bb, offset),
                    v,
                    bb, offset,
                    defaultImpl);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }


    // typed-ops here

    // Note: all the accessor methods defined below take advantage of argument type profiling
    // (see src/hotspot/share/oops/methodData.cpp) which greatly enhances performance when the same accessor
    // method is used repeatedly with different 'base' objects.
    @ForceInline
    public byte getByte(Scope scope, Object base, long offset) {
        try {
            return getByteInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getByteInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getByte(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putByte(Scope scope, Object base, long offset, byte value) {
        try {
            putByteInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putByteInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putByte(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }


    @ForceInline
    public byte getByteVolatile(Scope scope, Object base, long offset) {
        try {
            return getByteVolatileInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getByteVolatileInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getByteVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putByteVolatile(Scope scope, Object base, long offset, byte value) {
        try {
            putByteVolatileInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putByteVolatileInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putByteVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getByteAcquire(Scope scope, Object base, long offset) {
        try {
            return getByteAcquireInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getByteAcquireInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getByteAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putByteRelease(Scope scope, Object base, long offset, byte value) {
        try {
            putByteReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putByteReleaseInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putByteRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getByteOpaque(Scope scope, Object base, long offset) {
        try {
            return getByteOpaqueInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getByteOpaqueInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getByteOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public void putByteOpaque(Scope scope, Object base, long offset, byte value) {
        try {
            putByteOpaqueInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putByteOpaqueInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putByteOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndAddByte(Scope scope, Object base, long offset, byte delta) {
        try {
            return getAndAddByteInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndAddByteInternal(Scope scope, Object base, long offset, byte delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddByte(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndAddByteAcquire(Scope scope, Object base, long offset, byte delta) {
        try {
            return getAndAddByteAcquireInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndAddByteAcquireInternal(Scope scope, Object base, long offset, byte delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddByteAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndAddByteRelease(Scope scope, Object base, long offset, byte delta) {
        try {
            return getAndAddByteReleaseInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndAddByteReleaseInternal(Scope scope, Object base, long offset, byte delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddByteRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndBitwiseOrByte(Scope scope, Object base, long offset, byte value) {
        try {
            return getAndBitwiseOrByteInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseOrByteInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrByte(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndBitwiseOrByteAcquire(Scope scope, Object base, long offset, byte value) {
        try {
            return getAndBitwiseOrByteAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseOrByteAcquireInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrByteAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndBitwiseOrByteRelease(Scope scope, Object base, long offset, byte value) {
        try {
            return getAndBitwiseOrByteReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseOrByteReleaseInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrByteRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndBitwiseAndByte(Scope scope, Object base, long offset, byte value) {
        try {
            return getAndBitwiseAndByteInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseAndByteInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndByte(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndBitwiseAndByteAcquire(Scope scope, Object base, long offset, byte value) {
        try {
            return getAndBitwiseAndByteAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseAndByteAcquireInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndByteAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndBitwiseAndByteRelease(Scope scope, Object base, long offset, byte value) {
        try {
            return getAndBitwiseAndByteReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseAndByteReleaseInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndByteRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndBitwiseXorByte(Scope scope, Object base, long offset, byte value) {
        try {
            return getAndBitwiseXorByteInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseXorByteInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorByte(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndBitwiseXorByteAcquire(Scope scope, Object base, long offset, byte value) {
        try {
            return getAndBitwiseXorByteAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseXorByteAcquireInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorByteAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public byte getAndBitwiseXorByteRelease(Scope scope, Object base, long offset, byte value) {
        try {
            return getAndBitwiseXorByteReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private byte getAndBitwiseXorByteReleaseInternal(Scope scope, Object base, long offset, byte value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorByteRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public short getShort(Scope scope, Object base, long offset) {
        try {
            return getShortInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getShortInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getShort(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putShort(Scope scope, Object base, long offset, short value) {
        try {
            putShortInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putShortInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putShort(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getShortUnaligned(Scope scope, Object base, long offset, boolean be) {
        try {
            return getShortUnalignedInternal(scope, base, offset, be);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getShortUnalignedInternal(Scope scope, Object base, long offset, boolean be) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getShortUnaligned(base, offset, be);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putShortUnaligned(Scope scope, Object base, long offset, short value, boolean be) {
        try {
            putShortUnalignedInternal(scope, base, offset, value, be);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putShortUnalignedInternal(Scope scope, Object base, long offset, short value, boolean be) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putShortUnaligned(base, offset, value, be);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getShortVolatile(Scope scope, Object base, long offset) {
        try {
            return getShortVolatileInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getShortVolatileInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getShortVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putShortVolatile(Scope scope, Object base, long offset, short value) {
        try {
            putShortVolatileInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putShortVolatileInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putShortVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getShortAcquire(Scope scope, Object base, long offset) {
        try {
            return getShortAcquireInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getShortAcquireInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getShortAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putShortRelease(Scope scope, Object base, long offset, short value) {
        try {
            putShortReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putShortReleaseInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putShortRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getShortOpaque(Scope scope, Object base, long offset) {
        try {
            return getShortOpaqueInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getShortOpaqueInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getShortOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public void putShortOpaque(Scope scope, Object base, long offset, short value) {
        try {
            putShortOpaqueInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putShortOpaqueInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putShortOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndAddShort(Scope scope, Object base, long offset, short delta) {
        try {
            return getAndAddShortInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndAddShortInternal(Scope scope, Object base, long offset, short delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddShort(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndAddShortAcquire(Scope scope, Object base, long offset, short delta) {
        try {
            return getAndAddShortAcquireInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndAddShortAcquireInternal(Scope scope, Object base, long offset, short delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddShortAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndAddShortRelease(Scope scope, Object base, long offset, short delta) {
        try {
            return getAndAddShortReleaseInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndAddShortReleaseInternal(Scope scope, Object base, long offset, short delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddShortRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndBitwiseOrShort(Scope scope, Object base, long offset, short value) {
        try {
            return getAndBitwiseOrShortInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseOrShortInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrShort(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndBitwiseOrShortAcquire(Scope scope, Object base, long offset, short value) {
        try {
            return getAndBitwiseOrShortAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseOrShortAcquireInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrShortAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndBitwiseOrShortRelease(Scope scope, Object base, long offset, short value) {
        try {
            return getAndBitwiseOrShortReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseOrShortReleaseInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrShortRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndBitwiseAndShort(Scope scope, Object base, long offset, short value) {
        try {
            return getAndBitwiseAndShortInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseAndShortInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndShort(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndBitwiseAndShortAcquire(Scope scope, Object base, long offset, short value) {
        try {
            return getAndBitwiseAndShortAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseAndShortAcquireInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndShortAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndBitwiseAndShortRelease(Scope scope, Object base, long offset, short value) {
        try {
            return getAndBitwiseAndShortReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseAndShortReleaseInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndShortRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndBitwiseXorShort(Scope scope, Object base, long offset, short value) {
        try {
            return getAndBitwiseXorShortInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseXorShortInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorShort(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndBitwiseXorShortAcquire(Scope scope, Object base, long offset, short value) {
        try {
            return getAndBitwiseXorShortAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseXorShortAcquireInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorShortAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public short getAndBitwiseXorShortRelease(Scope scope, Object base, long offset, short value) {
        try {
            return getAndBitwiseXorShortReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private short getAndBitwiseXorShortReleaseInternal(Scope scope, Object base, long offset, short value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorShortRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public char getChar(Scope scope, Object base, long offset) {
        try {
            return getCharInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getCharInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getChar(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putChar(Scope scope, Object base, long offset, char value) {
        try {
            putCharInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putCharInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putChar(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getCharUnaligned(Scope scope, Object base, long offset, boolean be) {
        try {
            return getCharUnalignedInternal(scope, base, offset, be);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getCharUnalignedInternal(Scope scope, Object base, long offset, boolean be) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getCharUnaligned(base, offset, be);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putCharUnaligned(Scope scope, Object base, long offset, char value, boolean be) {
        try {
            putCharUnalignedInternal(scope, base, offset, value, be);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putCharUnalignedInternal(Scope scope, Object base, long offset, char value, boolean be) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putCharUnaligned(base, offset, value, be);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getCharVolatile(Scope scope, Object base, long offset) {
        try {
            return getCharVolatileInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getCharVolatileInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getCharVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putCharVolatile(Scope scope, Object base, long offset, char value) {
        try {
            putCharVolatileInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putCharVolatileInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putCharVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getCharAcquire(Scope scope, Object base, long offset) {
        try {
            return getCharAcquireInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getCharAcquireInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getCharAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putCharRelease(Scope scope, Object base, long offset, char value) {
        try {
            putCharReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putCharReleaseInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putCharRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getCharOpaque(Scope scope, Object base, long offset) {
        try {
            return getCharOpaqueInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getCharOpaqueInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getCharOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public void putCharOpaque(Scope scope, Object base, long offset, char value) {
        try {
            putCharOpaqueInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putCharOpaqueInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putCharOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndAddChar(Scope scope, Object base, long offset, char delta) {
        try {
            return getAndAddCharInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndAddCharInternal(Scope scope, Object base, long offset, char delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddChar(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndAddCharAcquire(Scope scope, Object base, long offset, char delta) {
        try {
            return getAndAddCharAcquireInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndAddCharAcquireInternal(Scope scope, Object base, long offset, char delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddCharAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndAddCharRelease(Scope scope, Object base, long offset, char delta) {
        try {
            return getAndAddCharReleaseInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndAddCharReleaseInternal(Scope scope, Object base, long offset, char delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddCharRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndBitwiseOrChar(Scope scope, Object base, long offset, char value) {
        try {
            return getAndBitwiseOrCharInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseOrCharInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrChar(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndBitwiseOrCharAcquire(Scope scope, Object base, long offset, char value) {
        try {
            return getAndBitwiseOrCharAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseOrCharAcquireInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrCharAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndBitwiseOrCharRelease(Scope scope, Object base, long offset, char value) {
        try {
            return getAndBitwiseOrCharReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseOrCharReleaseInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrCharRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndBitwiseAndChar(Scope scope, Object base, long offset, char value) {
        try {
            return getAndBitwiseAndCharInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseAndCharInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndChar(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndBitwiseAndCharAcquire(Scope scope, Object base, long offset, char value) {
        try {
            return getAndBitwiseAndCharAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseAndCharAcquireInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndCharAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndBitwiseAndCharRelease(Scope scope, Object base, long offset, char value) {
        try {
            return getAndBitwiseAndCharReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseAndCharReleaseInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndCharRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndBitwiseXorChar(Scope scope, Object base, long offset, char value) {
        try {
            return getAndBitwiseXorCharInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseXorCharInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorChar(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndBitwiseXorCharAcquire(Scope scope, Object base, long offset, char value) {
        try {
            return getAndBitwiseXorCharAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseXorCharAcquireInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorCharAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public char getAndBitwiseXorCharRelease(Scope scope, Object base, long offset, char value) {
        try {
            return getAndBitwiseXorCharReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private char getAndBitwiseXorCharReleaseInternal(Scope scope, Object base, long offset, char value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorCharRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public int getInt(Scope scope, Object base, long offset) {
        try {
            return getIntInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getIntInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getInt(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putInt(Scope scope, Object base, long offset, int value) {
        try {
            putIntInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putIntInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putInt(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getIntUnaligned(Scope scope, Object base, long offset, boolean be) {
        try {
            return getIntUnalignedInternal(scope, base, offset, be);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getIntUnalignedInternal(Scope scope, Object base, long offset, boolean be) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getIntUnaligned(base, offset, be);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putIntUnaligned(Scope scope, Object base, long offset, int value, boolean be) {
        try {
            putIntUnalignedInternal(scope, base, offset, value, be);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putIntUnalignedInternal(Scope scope, Object base, long offset, int value, boolean be) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putIntUnaligned(base, offset, value, be);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getIntVolatile(Scope scope, Object base, long offset) {
        try {
            return getIntVolatileInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getIntVolatileInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getIntVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putIntVolatile(Scope scope, Object base, long offset, int value) {
        try {
            putIntVolatileInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putIntVolatileInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putIntVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getIntAcquire(Scope scope, Object base, long offset) {
        try {
            return getIntAcquireInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getIntAcquireInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getIntAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putIntRelease(Scope scope, Object base, long offset, int value) {
        try {
            putIntReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putIntReleaseInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putIntRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getIntOpaque(Scope scope, Object base, long offset) {
        try {
            return getIntOpaqueInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getIntOpaqueInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getIntOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public void putIntOpaque(Scope scope, Object base, long offset, int value) {
        try {
            putIntOpaqueInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putIntOpaqueInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putIntOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public boolean compareAndSetInt(Scope scope, Object base, long offset, int expected, int value) {
        try {
            return compareAndSetIntInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean compareAndSetIntInternal(Scope scope, Object base, long offset, int expected, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndSetInt(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int compareAndExchangeInt(Scope scope, Object base, long offset, int expected, int value) {
        try {
            return compareAndExchangeIntInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int compareAndExchangeIntInternal(Scope scope, Object base, long offset, int expected, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeInt(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int compareAndExchangeIntAcquire(Scope scope, Object base, long offset, int expected, int value) {
        try {
            return compareAndExchangeIntAcquireInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int compareAndExchangeIntAcquireInternal(Scope scope, Object base, long offset, int expected, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeIntAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int compareAndExchangeIntRelease(Scope scope, Object base, long offset, int expected, int value) {
        try {
            return compareAndExchangeIntReleaseInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int compareAndExchangeIntReleaseInternal(Scope scope, Object base, long offset, int expected, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeIntRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetIntPlain(Scope scope, Object base, long offset, int expected, int value) {
        try {
            return weakCompareAndSetIntPlainInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetIntPlainInternal(Scope scope, Object base, long offset, int expected, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetIntPlain(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetInt(Scope scope, Object base, long offset, int expected, int value) {
        try {
            return weakCompareAndSetIntInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetIntInternal(Scope scope, Object base, long offset, int expected, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetInt(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetIntAcquire(Scope scope, Object base, long offset, int expected, int value) {
        try {
            return weakCompareAndSetIntAcquireInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetIntAcquireInternal(Scope scope, Object base, long offset, int expected, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetIntAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetIntRelease(Scope scope, Object base, long offset, int expected, int value) {
        try {
            return weakCompareAndSetIntReleaseInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetIntReleaseInternal(Scope scope, Object base, long offset, int expected, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetIntRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndSetInt(Scope scope, Object base, long offset, int value) {
        try {
            return getAndSetIntInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndSetIntInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetInt(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndSetIntAcquire(Scope scope, Object base, long offset, int value) {
        try {
            return getAndSetIntAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndSetIntAcquireInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetIntAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndSetIntRelease(Scope scope, Object base, long offset, int value) {
        try {
            return getAndSetIntReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndSetIntReleaseInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetIntRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndAddInt(Scope scope, Object base, long offset, int delta) {
        try {
            return getAndAddIntInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndAddIntInternal(Scope scope, Object base, long offset, int delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddInt(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndAddIntAcquire(Scope scope, Object base, long offset, int delta) {
        try {
            return getAndAddIntAcquireInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndAddIntAcquireInternal(Scope scope, Object base, long offset, int delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddIntAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndAddIntRelease(Scope scope, Object base, long offset, int delta) {
        try {
            return getAndAddIntReleaseInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndAddIntReleaseInternal(Scope scope, Object base, long offset, int delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddIntRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndBitwiseOrInt(Scope scope, Object base, long offset, int value) {
        try {
            return getAndBitwiseOrIntInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseOrIntInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrInt(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndBitwiseOrIntAcquire(Scope scope, Object base, long offset, int value) {
        try {
            return getAndBitwiseOrIntAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseOrIntAcquireInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrIntAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndBitwiseOrIntRelease(Scope scope, Object base, long offset, int value) {
        try {
            return getAndBitwiseOrIntReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseOrIntReleaseInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrIntRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndBitwiseAndInt(Scope scope, Object base, long offset, int value) {
        try {
            return getAndBitwiseAndIntInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseAndIntInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndInt(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndBitwiseAndIntAcquire(Scope scope, Object base, long offset, int value) {
        try {
            return getAndBitwiseAndIntAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseAndIntAcquireInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndIntAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndBitwiseAndIntRelease(Scope scope, Object base, long offset, int value) {
        try {
            return getAndBitwiseAndIntReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseAndIntReleaseInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndIntRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndBitwiseXorInt(Scope scope, Object base, long offset, int value) {
        try {
            return getAndBitwiseXorIntInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseXorIntInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorInt(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndBitwiseXorIntAcquire(Scope scope, Object base, long offset, int value) {
        try {
            return getAndBitwiseXorIntAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseXorIntAcquireInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorIntAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public int getAndBitwiseXorIntRelease(Scope scope, Object base, long offset, int value) {
        try {
            return getAndBitwiseXorIntReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private int getAndBitwiseXorIntReleaseInternal(Scope scope, Object base, long offset, int value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorIntRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public long getLong(Scope scope, Object base, long offset) {
        try {
            return getLongInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getLongInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getLong(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putLong(Scope scope, Object base, long offset, long value) {
        try {
            putLongInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putLongInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putLong(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getLongUnaligned(Scope scope, Object base, long offset, boolean be) {
        try {
            return getLongUnalignedInternal(scope, base, offset, be);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getLongUnalignedInternal(Scope scope, Object base, long offset, boolean be) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getLongUnaligned(base, offset, be);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putLongUnaligned(Scope scope, Object base, long offset, long value, boolean be) {
        try {
            putLongUnalignedInternal(scope, base, offset, value, be);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putLongUnalignedInternal(Scope scope, Object base, long offset, long value, boolean be) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putLongUnaligned(base, offset, value, be);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getLongVolatile(Scope scope, Object base, long offset) {
        try {
            return getLongVolatileInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getLongVolatileInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getLongVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putLongVolatile(Scope scope, Object base, long offset, long value) {
        try {
            putLongVolatileInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putLongVolatileInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putLongVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getLongAcquire(Scope scope, Object base, long offset) {
        try {
            return getLongAcquireInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getLongAcquireInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getLongAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putLongRelease(Scope scope, Object base, long offset, long value) {
        try {
            putLongReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putLongReleaseInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putLongRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getLongOpaque(Scope scope, Object base, long offset) {
        try {
            return getLongOpaqueInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getLongOpaqueInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getLongOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public void putLongOpaque(Scope scope, Object base, long offset, long value) {
        try {
            putLongOpaqueInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putLongOpaqueInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putLongOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public boolean compareAndSetLong(Scope scope, Object base, long offset, long expected, long value) {
        try {
            return compareAndSetLongInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean compareAndSetLongInternal(Scope scope, Object base, long offset, long expected, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndSetLong(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long compareAndExchangeLong(Scope scope, Object base, long offset, long expected, long value) {
        try {
            return compareAndExchangeLongInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long compareAndExchangeLongInternal(Scope scope, Object base, long offset, long expected, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeLong(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long compareAndExchangeLongAcquire(Scope scope, Object base, long offset, long expected, long value) {
        try {
            return compareAndExchangeLongAcquireInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long compareAndExchangeLongAcquireInternal(Scope scope, Object base, long offset, long expected, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeLongAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long compareAndExchangeLongRelease(Scope scope, Object base, long offset, long expected, long value) {
        try {
            return compareAndExchangeLongReleaseInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long compareAndExchangeLongReleaseInternal(Scope scope, Object base, long offset, long expected, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeLongRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetLongPlain(Scope scope, Object base, long offset, long expected, long value) {
        try {
            return weakCompareAndSetLongPlainInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetLongPlainInternal(Scope scope, Object base, long offset, long expected, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetLongPlain(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetLong(Scope scope, Object base, long offset, long expected, long value) {
        try {
            return weakCompareAndSetLongInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetLongInternal(Scope scope, Object base, long offset, long expected, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetLong(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetLongAcquire(Scope scope, Object base, long offset, long expected, long value) {
        try {
            return weakCompareAndSetLongAcquireInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetLongAcquireInternal(Scope scope, Object base, long offset, long expected, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetLongAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetLongRelease(Scope scope, Object base, long offset, long expected, long value) {
        try {
            return weakCompareAndSetLongReleaseInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetLongReleaseInternal(Scope scope, Object base, long offset, long expected, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetLongRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndSetLong(Scope scope, Object base, long offset, long value) {
        try {
            return getAndSetLongInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndSetLongInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetLong(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndSetLongAcquire(Scope scope, Object base, long offset, long value) {
        try {
            return getAndSetLongAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndSetLongAcquireInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetLongAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndSetLongRelease(Scope scope, Object base, long offset, long value) {
        try {
            return getAndSetLongReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndSetLongReleaseInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetLongRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndAddLong(Scope scope, Object base, long offset, long delta) {
        try {
            return getAndAddLongInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndAddLongInternal(Scope scope, Object base, long offset, long delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddLong(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndAddLongAcquire(Scope scope, Object base, long offset, long delta) {
        try {
            return getAndAddLongAcquireInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndAddLongAcquireInternal(Scope scope, Object base, long offset, long delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddLongAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndAddLongRelease(Scope scope, Object base, long offset, long delta) {
        try {
            return getAndAddLongReleaseInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndAddLongReleaseInternal(Scope scope, Object base, long offset, long delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddLongRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndBitwiseOrLong(Scope scope, Object base, long offset, long value) {
        try {
            return getAndBitwiseOrLongInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseOrLongInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrLong(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndBitwiseOrLongAcquire(Scope scope, Object base, long offset, long value) {
        try {
            return getAndBitwiseOrLongAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseOrLongAcquireInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrLongAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndBitwiseOrLongRelease(Scope scope, Object base, long offset, long value) {
        try {
            return getAndBitwiseOrLongReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseOrLongReleaseInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseOrLongRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndBitwiseAndLong(Scope scope, Object base, long offset, long value) {
        try {
            return getAndBitwiseAndLongInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseAndLongInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndLong(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndBitwiseAndLongAcquire(Scope scope, Object base, long offset, long value) {
        try {
            return getAndBitwiseAndLongAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseAndLongAcquireInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndLongAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndBitwiseAndLongRelease(Scope scope, Object base, long offset, long value) {
        try {
            return getAndBitwiseAndLongReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseAndLongReleaseInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseAndLongRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndBitwiseXorLong(Scope scope, Object base, long offset, long value) {
        try {
            return getAndBitwiseXorLongInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseXorLongInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorLong(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndBitwiseXorLongAcquire(Scope scope, Object base, long offset, long value) {
        try {
            return getAndBitwiseXorLongAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseXorLongAcquireInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorLongAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public long getAndBitwiseXorLongRelease(Scope scope, Object base, long offset, long value) {
        try {
            return getAndBitwiseXorLongReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private long getAndBitwiseXorLongReleaseInternal(Scope scope, Object base, long offset, long value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndBitwiseXorLongRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public float getFloat(Scope scope, Object base, long offset) {
        try {
            return getFloatInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float getFloatInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getFloat(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putFloat(Scope scope, Object base, long offset, float value) {
        try {
            putFloatInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putFloatInternal(Scope scope, Object base, long offset, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putFloat(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }


    @ForceInline
    public float getFloatVolatile(Scope scope, Object base, long offset) {
        try {
            return getFloatVolatileInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float getFloatVolatileInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getFloatVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putFloatVolatile(Scope scope, Object base, long offset, float value) {
        try {
            putFloatVolatileInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putFloatVolatileInternal(Scope scope, Object base, long offset, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putFloatVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float getFloatAcquire(Scope scope, Object base, long offset) {
        try {
            return getFloatAcquireInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float getFloatAcquireInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getFloatAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putFloatRelease(Scope scope, Object base, long offset, float value) {
        try {
            putFloatReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putFloatReleaseInternal(Scope scope, Object base, long offset, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putFloatRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float getFloatOpaque(Scope scope, Object base, long offset) {
        try {
            return getFloatOpaqueInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float getFloatOpaqueInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getFloatOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public void putFloatOpaque(Scope scope, Object base, long offset, float value) {
        try {
            putFloatOpaqueInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putFloatOpaqueInternal(Scope scope, Object base, long offset, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putFloatOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public boolean compareAndSetFloat(Scope scope, Object base, long offset, float expected, float value) {
        try {
            return compareAndSetFloatInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean compareAndSetFloatInternal(Scope scope, Object base, long offset, float expected, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndSetFloat(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float compareAndExchangeFloat(Scope scope, Object base, long offset, float expected, float value) {
        try {
            return compareAndExchangeFloatInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float compareAndExchangeFloatInternal(Scope scope, Object base, long offset, float expected, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeFloat(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float compareAndExchangeFloatAcquire(Scope scope, Object base, long offset, float expected, float value) {
        try {
            return compareAndExchangeFloatAcquireInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float compareAndExchangeFloatAcquireInternal(Scope scope, Object base, long offset, float expected, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeFloatAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float compareAndExchangeFloatRelease(Scope scope, Object base, long offset, float expected, float value) {
        try {
            return compareAndExchangeFloatReleaseInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float compareAndExchangeFloatReleaseInternal(Scope scope, Object base, long offset, float expected, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeFloatRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetFloatPlain(Scope scope, Object base, long offset, float expected, float value) {
        try {
            return weakCompareAndSetFloatPlainInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetFloatPlainInternal(Scope scope, Object base, long offset, float expected, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetFloatPlain(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetFloat(Scope scope, Object base, long offset, float expected, float value) {
        try {
            return weakCompareAndSetFloatInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetFloatInternal(Scope scope, Object base, long offset, float expected, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetFloat(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetFloatAcquire(Scope scope, Object base, long offset, float expected, float value) {
        try {
            return weakCompareAndSetFloatAcquireInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetFloatAcquireInternal(Scope scope, Object base, long offset, float expected, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetFloatAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetFloatRelease(Scope scope, Object base, long offset, float expected, float value) {
        try {
            return weakCompareAndSetFloatReleaseInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetFloatReleaseInternal(Scope scope, Object base, long offset, float expected, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetFloatRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float getAndSetFloat(Scope scope, Object base, long offset, float value) {
        try {
            return getAndSetFloatInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float getAndSetFloatInternal(Scope scope, Object base, long offset, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetFloat(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float getAndSetFloatAcquire(Scope scope, Object base, long offset, float value) {
        try {
            return getAndSetFloatAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float getAndSetFloatAcquireInternal(Scope scope, Object base, long offset, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetFloatAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float getAndSetFloatRelease(Scope scope, Object base, long offset, float value) {
        try {
            return getAndSetFloatReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float getAndSetFloatReleaseInternal(Scope scope, Object base, long offset, float value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetFloatRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float getAndAddFloat(Scope scope, Object base, long offset, float delta) {
        try {
            return getAndAddFloatInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float getAndAddFloatInternal(Scope scope, Object base, long offset, float delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddFloat(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float getAndAddFloatAcquire(Scope scope, Object base, long offset, float delta) {
        try {
            return getAndAddFloatAcquireInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float getAndAddFloatAcquireInternal(Scope scope, Object base, long offset, float delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddFloatAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public float getAndAddFloatRelease(Scope scope, Object base, long offset, float delta) {
        try {
            return getAndAddFloatReleaseInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private float getAndAddFloatReleaseInternal(Scope scope, Object base, long offset, float delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddFloatRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double getDouble(Scope scope, Object base, long offset) {
        try {
            return getDoubleInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double getDoubleInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getDouble(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putDouble(Scope scope, Object base, long offset, double value) {
        try {
            putDoubleInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putDoubleInternal(Scope scope, Object base, long offset, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putDouble(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }


    @ForceInline
    public double getDoubleVolatile(Scope scope, Object base, long offset) {
        try {
            return getDoubleVolatileInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double getDoubleVolatileInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getDoubleVolatile(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putDoubleVolatile(Scope scope, Object base, long offset, double value) {
        try {
            putDoubleVolatileInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putDoubleVolatileInternal(Scope scope, Object base, long offset, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putDoubleVolatile(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double getDoubleAcquire(Scope scope, Object base, long offset) {
        try {
            return getDoubleAcquireInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double getDoubleAcquireInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getDoubleAcquire(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public void putDoubleRelease(Scope scope, Object base, long offset, double value) {
        try {
            putDoubleReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putDoubleReleaseInternal(Scope scope, Object base, long offset, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putDoubleRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double getDoubleOpaque(Scope scope, Object base, long offset) {
        try {
            return getDoubleOpaqueInternal(scope, base, offset);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double getDoubleOpaqueInternal(Scope scope, Object base, long offset) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getDoubleOpaque(base, offset);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public void putDoubleOpaque(Scope scope, Object base, long offset, double value) {
        try {
            putDoubleOpaqueInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private void putDoubleOpaqueInternal(Scope scope, Object base, long offset, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            UNSAFE.putDoubleOpaque(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }
    @ForceInline
    public boolean compareAndSetDouble(Scope scope, Object base, long offset, double expected, double value) {
        try {
            return compareAndSetDoubleInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean compareAndSetDoubleInternal(Scope scope, Object base, long offset, double expected, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndSetDouble(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double compareAndExchangeDouble(Scope scope, Object base, long offset, double expected, double value) {
        try {
            return compareAndExchangeDoubleInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double compareAndExchangeDoubleInternal(Scope scope, Object base, long offset, double expected, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeDouble(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double compareAndExchangeDoubleAcquire(Scope scope, Object base, long offset, double expected, double value) {
        try {
            return compareAndExchangeDoubleAcquireInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double compareAndExchangeDoubleAcquireInternal(Scope scope, Object base, long offset, double expected, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeDoubleAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double compareAndExchangeDoubleRelease(Scope scope, Object base, long offset, double expected, double value) {
        try {
            return compareAndExchangeDoubleReleaseInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double compareAndExchangeDoubleReleaseInternal(Scope scope, Object base, long offset, double expected, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.compareAndExchangeDoubleRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetDoublePlain(Scope scope, Object base, long offset, double expected, double value) {
        try {
            return weakCompareAndSetDoublePlainInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetDoublePlainInternal(Scope scope, Object base, long offset, double expected, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetDoublePlain(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetDouble(Scope scope, Object base, long offset, double expected, double value) {
        try {
            return weakCompareAndSetDoubleInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetDoubleInternal(Scope scope, Object base, long offset, double expected, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetDouble(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetDoubleAcquire(Scope scope, Object base, long offset, double expected, double value) {
        try {
            return weakCompareAndSetDoubleAcquireInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetDoubleAcquireInternal(Scope scope, Object base, long offset, double expected, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetDoubleAcquire(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public boolean weakCompareAndSetDoubleRelease(Scope scope, Object base, long offset, double expected, double value) {
        try {
            return weakCompareAndSetDoubleReleaseInternal(scope, base, offset, expected, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private boolean weakCompareAndSetDoubleReleaseInternal(Scope scope, Object base, long offset, double expected, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.weakCompareAndSetDoubleRelease(base, offset, expected, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double getAndSetDouble(Scope scope, Object base, long offset, double value) {
        try {
            return getAndSetDoubleInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double getAndSetDoubleInternal(Scope scope, Object base, long offset, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetDouble(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double getAndSetDoubleAcquire(Scope scope, Object base, long offset, double value) {
        try {
            return getAndSetDoubleAcquireInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double getAndSetDoubleAcquireInternal(Scope scope, Object base, long offset, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetDoubleAcquire(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double getAndSetDoubleRelease(Scope scope, Object base, long offset, double value) {
        try {
            return getAndSetDoubleReleaseInternal(scope, base, offset, value);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double getAndSetDoubleReleaseInternal(Scope scope, Object base, long offset, double value) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndSetDoubleRelease(base, offset, value);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double getAndAddDouble(Scope scope, Object base, long offset, double delta) {
        try {
            return getAndAddDoubleInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double getAndAddDoubleInternal(Scope scope, Object base, long offset, double delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddDouble(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double getAndAddDoubleAcquire(Scope scope, Object base, long offset, double delta) {
        try {
            return getAndAddDoubleAcquireInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double getAndAddDoubleAcquireInternal(Scope scope, Object base, long offset, double delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddDoubleAcquire(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

    @ForceInline
    public double getAndAddDoubleRelease(Scope scope, Object base, long offset, double delta) {
        try {
            return getAndAddDoubleReleaseInternal(scope, base, offset, delta);
        } catch (Scope.ScopedAccessError ex) {
            throw new IllegalStateException("This segment is already closed");
        }
    }

    @ForceInline @Scoped
    private double getAndAddDoubleReleaseInternal(Scope scope, Object base, long offset, double delta) {
        try {
            if (scope != null) {
                scope.checkValidState();
            }
            return UNSAFE.getAndAddDoubleRelease(base, offset, delta);
        } finally {
            Reference.reachabilityFence(scope);
        }
    }

}
