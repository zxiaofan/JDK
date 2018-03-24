/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package sun.java2d;

import java.lang.ref.Reference;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * This ReentrantContextProvider implementation uses one ConcurrentLinkedQueue
 * to store all ReentrantContext instances (thread and its child contexts)
 *
 * Note: this implementation keeps less contexts in memory depending on the
 * concurrent active threads in contrary to a ThreadLocal provider. However,
 * it is slower in highly concurrent workloads.
 *
 * @param <K> ReentrantContext subclass
 */
public abstract class ReentrantContextProviderCLQ<K extends ReentrantContext>
    extends ReentrantContextProvider<K>
{
    // ReentrantContext queue to store all contexts
    private final ConcurrentLinkedQueue<Reference<K>> ctxQueue
        = new ConcurrentLinkedQueue<Reference<K>>();

    /**
     * Create a new ReentrantContext provider using the given reference type
     * among hard, soft or weak based using a ConcurrentLinkedQueue storage
     *
     * @param refType reference type
     */
    public ReentrantContextProviderCLQ(final int refType) {
        super(refType);
    }

    /**
     * Give a ReentrantContext instance for the current thread
     *
     * @return ReentrantContext instance
     */
    @Override
    public final K acquire() {
        K ctx = null;
        // Drain queue if all referent are null:
        Reference<K> ref = null;
        while ((ctx == null) && ((ref = ctxQueue.poll()) != null)) {
            ctx = ref.get();
        }
        if (ctx == null) {
            // create a new ReentrantContext if none is available
            ctx = newContext();
            ctx.usage = USAGE_CLQ;
        }
        return ctx;
    }

    /**
     * Restore the given ReentrantContext instance for reuse
     *
     * @param ctx ReentrantContext instance
     */
    @Override
    public final void release(final K ctx) {
        if (ctx.usage == USAGE_CLQ) {
            ctxQueue.offer(getOrCreateReference(ctx));
        }
    }
}
