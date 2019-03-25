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

/**
* This ReentrantContextProvider implementation uses a ThreadLocal to hold
 * the first ReentrantContext per thread and a ReentrantContextProviderCLQ to
 * store child ReentrantContext instances needed during recursion.
 *
 * Note: this implementation may keep up to one context in memory per thread.
 * Child contexts for recursive uses are stored in the queue using a WEAK
 * reference by default unless specified in the 2 argument constructor.
 *
 * @param <K> ReentrantContext subclass
 */
public abstract class ReentrantContextProviderTL<K extends ReentrantContext>
    extends ReentrantContextProvider<K>
{
    // Thread-local storage:
    private final ThreadLocal<Reference<K>> ctxTL
        = new ThreadLocal<Reference<K>>();

    // ReentrantContext CLQ provider for child contexts:
    private final ReentrantContextProviderCLQ<K> ctxProviderCLQ;

    /**
     * Create a new ReentrantContext provider using the given reference type
     * among hard, soft or weak.
     * It uses weak reference for the child contexts.
     *
     * @param refType reference type
     */
    public ReentrantContextProviderTL(final int refType) {
        this(refType, REF_WEAK);
    }

    /**
     * Create a new ReentrantContext provider using the given reference types
     * among hard, soft or weak
     *
     * @param refTypeTL reference type used by ThreadLocal
     * @param refTypeCLQ reference type used by ReentrantContextProviderCLQ
     */
    public ReentrantContextProviderTL(final int refTypeTL, final int refTypeCLQ)
    {
        super(refTypeTL);

        final ReentrantContextProviderTL<K> parent = this;

        this.ctxProviderCLQ = new ReentrantContextProviderCLQ<K>(refTypeCLQ) {
            @Override
            protected K newContext() {
                return parent.newContext();
            }
        };
    }

    /**
     * Give a ReentrantContext instance for the current thread
     *
     * @return ReentrantContext instance
     */
    @Override
    public final K acquire() {
        K ctx = null;
        final Reference<K> ref = ctxTL.get();
        if (ref != null) {
            ctx = ref.get();
        }
        if (ctx == null) {
            // create a new ReentrantContext if none is available
            ctx = newContext();
            // update thread local reference:
            ctxTL.set(getOrCreateReference(ctx));
        }
        // Check reentrance:
        if (ctx.usage == USAGE_TL_INACTIVE) {
           ctx.usage = USAGE_TL_IN_USE;
        } else {
            // get or create another ReentrantContext from CLQ provider:
            ctx = ctxProviderCLQ.acquire();
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
        if (ctx.usage == USAGE_TL_IN_USE) {
           ctx.usage = USAGE_TL_INACTIVE;
        } else {
            ctxProviderCLQ.release(ctx);
        }
    }
}
