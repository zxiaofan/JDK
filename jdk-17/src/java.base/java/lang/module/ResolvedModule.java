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

package java.lang.module;

import java.util.Objects;
import java.util.Set;

/**
 * A module in a graph of <em>resolved modules</em>.
 *
 * <p> {@code ResolvedModule} defines the {@link #configuration configuration}
 * method to get the configuration that the resolved module is in. It defines
 * the {@link #reference() reference} method to get the reference to the
 * module's content.
 *
 * @since 9
 * @see Configuration#modules()
 */
public final class ResolvedModule {

    private final Configuration cf;
    private final ModuleReference mref;

    ResolvedModule(Configuration cf, ModuleReference mref) {
        this.cf = Objects.requireNonNull(cf);
        this.mref = Objects.requireNonNull(mref);
    }

    /**
     * Returns the configuration that this resolved module is in.
     *
     * @return The configuration that this resolved module is in
     */
    public Configuration configuration() {
        return cf;
    }

    /**
     * Returns the reference to the module's content.
     *
     * @return The reference to the module's content
     */
    public ModuleReference reference() {
        return mref;
    }

    /**
     * Returns the module descriptor.
     *
     * This convenience method is the equivalent to invoking:
     * <pre> {@code
     *     reference().descriptor()
     * }</pre>
     *
     * @return The module descriptor
     */
    ModuleDescriptor descriptor() {
        return mref.descriptor();
    }

    /**
     * Returns the module name.
     *
     * This convenience method is the equivalent to invoking:
     * <pre> {@code
     *     reference().descriptor().name()
     * }</pre>
     *
     * @return The module name
     */
    public String name() {
        return mref.descriptor().name();
    }

    /**
     * Returns the set of resolved modules that this resolved module reads.
     *
     * @return A possibly-empty unmodifiable set of resolved modules that
     *         this resolved module reads
     */
    public Set<ResolvedModule> reads() {
        return cf.reads(this);
    }

    /**
     * Computes a hash code for this resolved module.
     *
     * <p> The hash code is based upon the components of the resolved module
     * and satisfies the general contract of the {@link Object#hashCode
     * Object.hashCode} method. </p>
     *
     * @return The hash-code value for this resolved module
     */
    @Override
    public int hashCode() {
        return cf.hashCode() ^ mref.hashCode();
    }

    /**
     * Tests this resolved module for equality with the given object.
     *
     * <p> If the given object is not a {@code ResolvedModule} then this
     * method returns {@code false}. Two {@code ResolvedModule} objects are
     * equal if they are in the same configuration and have equal references
     * to the module content. </p>
     *
     * <p> This method satisfies the general contract of the {@link
     * java.lang.Object#equals(Object) Object.equals} method. </p>
     *
     * @param   ob
     *          the object to which this object is to be compared
     *
     * @return  {@code true} if, and only if, the given object is a module
     *          reference that is equal to this module reference
     */
    @Override
    public boolean equals(Object ob) {
        return (ob instanceof ResolvedModule that)
            && Objects.equals(this.cf, that.cf)
            && Objects.equals(this.mref, that.mref);
    }

    /**
     * Returns a string describing this resolved module.
     *
     * @return A string describing this resolved module
     */
    @Override
    public String toString() {
        return System.identityHashCode(cf) + "/" + name();
    }

}
