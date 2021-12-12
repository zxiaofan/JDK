/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.net.URI;
import java.util.Objects;
import java.util.Optional;


/**
 * A reference to a module's content.
 *
 * <p> A module reference is a concrete implementation of this class that
 * implements the abstract methods defined by this class. It contains the
 * module's descriptor and its location, if known.  It also has the ability to
 * create a {@link ModuleReader} in order to access the module's content, which
 * may be inside the Java run-time system itself or in an artifact such as a
 * modular JAR file.
 *
 * @see ModuleFinder
 * @see ModuleReader
 * @since 9
 */

public abstract class ModuleReference {

    private final ModuleDescriptor descriptor;
    private final URI location;

    /**
     * Constructs a new instance of this class.
     *
     * @param descriptor
     *        The module descriptor
     * @param location
     *        The module location or {@code null} if not known
     */
    protected ModuleReference(ModuleDescriptor descriptor, URI location) {
        this.descriptor = Objects.requireNonNull(descriptor);
        this.location = location;
    }

    /**
     * Returns the module descriptor.
     *
     * @return The module descriptor
     */
    public final ModuleDescriptor descriptor() {
        return descriptor;
    }

    /**
     * Returns the location of this module's content, if known.
     *
     * <p> This URI, when present, can be used as the {@linkplain
     * java.security.CodeSource#getLocation location} value of a {@link
     * java.security.CodeSource CodeSource} so that a module's classes can be
     * granted specific permissions when loaded by a {@link
     * java.security.SecureClassLoader SecureClassLoader}.
     *
     * @return The location or an empty {@code Optional} if not known
     */
    public final Optional<URI> location() {
        return Optional.ofNullable(location);
    }

    /**
     * Opens the module content for reading.
     *
     * @return A {@code ModuleReader} to read the module
     *
     * @throws IOException
     *         If an I/O error occurs
     * @throws SecurityException
     *         If denied by the security manager
     */
    public abstract ModuleReader open() throws IOException;
}
