/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.pipe.helper;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.pipe.Fiber;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.sun.xml.internal.ws.api.pipe.Pipe;
import com.sun.xml.internal.ws.api.pipe.PipeCloner;
import com.sun.xml.internal.ws.api.pipe.Tube;
import com.sun.xml.internal.ws.api.pipe.TubeCloner;

/**
 * {@link Tube} that invokes {@link Pipe}.
 *
 * <p>
 * This can be used to make a {@link Pipe} look like a {@link Tube}.
 *
 * @author Kohsuke Kawaguchi
 * @author Jitendra Kotamraju
 */
public class PipeAdapter extends AbstractTubeImpl {
    private final Pipe next;

    public static Tube adapt(Pipe p) {
        if (p instanceof Tube) {
            return (Tube) p;
        } else {
            return new PipeAdapter(p);
        }
    }

    public static Pipe adapt(Tube p) {
        if (p instanceof Pipe) {
            return (Pipe) p;
        } else {
            class TubeAdapter extends AbstractPipeImpl {
                private final Tube t;

                public TubeAdapter(Tube t) {
                    this.t = t;
                }

                private TubeAdapter(TubeAdapter that, PipeCloner cloner) {
                    super(that, cloner);
                    this.t = cloner.copy(that.t);
                }

                public Packet process(Packet request) {
                    return Fiber.current().runSync(t,request);
                }

                public Pipe copy(PipeCloner cloner) {
                    return new TubeAdapter(this,cloner);
                }
            }

            return new TubeAdapter(p);
        }
    }


    private PipeAdapter(Pipe next) {
        this.next = next;
    }

    /**
     * Copy constructor
     */
    private PipeAdapter(PipeAdapter that, TubeCloner cloner) {
        super(that,cloner);
        this.next = ((PipeCloner)cloner).copy(that.next);
    }

    /**
     * Uses the current fiber and runs the whole pipe to the completion
     * (meaning everything from now on will run synchronously.)
     */
    public @NotNull NextAction processRequest(@NotNull Packet p) {
        return doReturnWith(next.process(p));
    }

    public @NotNull NextAction processResponse(@NotNull Packet p) {
        throw new IllegalStateException();
    }

    @NotNull
    public NextAction processException(@NotNull Throwable t) {
        throw new IllegalStateException();
    }

    public void preDestroy() {
        next.preDestroy();
    }

    public PipeAdapter copy(TubeCloner cloner) {
        return new PipeAdapter(this,cloner);
    }

    public String toString() {
        return super.toString()+"["+next.toString()+"]";
    }
}
