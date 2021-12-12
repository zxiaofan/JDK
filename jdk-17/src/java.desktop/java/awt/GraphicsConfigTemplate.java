/*
 * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.awt;

import java.io.Serial;
import java.io.Serializable;

/**
 * The {@code GraphicsConfigTemplate} class is used to obtain a valid
 * {@link GraphicsConfiguration}.  A user instantiates one of these
 * objects and then sets all non-default attributes as desired.  The
 * {@link GraphicsDevice#getBestConfiguration} method found in the
 * {@link GraphicsDevice} class is then called with this
 * {@code GraphicsConfigTemplate}.  A valid
 * {@code GraphicsConfiguration} is returned that meets or exceeds
 * what was requested in the {@code GraphicsConfigTemplate}.
 * @see GraphicsDevice
 * @see GraphicsConfiguration
 *
 * @since       1.2
 */
public abstract class GraphicsConfigTemplate implements Serializable {

    /**
     * Use serialVersionUID from JDK 1.6 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -8061369279557787079L;

    /**
     * This class is an abstract class so only subclasses can be
     * instantiated.
     */
    public GraphicsConfigTemplate() {
    }

    /**
     * Value used for "Enum" (Integer) type.  States that this
     * feature is required for the {@code GraphicsConfiguration}
     * object.  If this feature is not available, do not select the
     * {@code GraphicsConfiguration} object.
     */
    public static final int REQUIRED    = 1;

    /**
     * Value used for "Enum" (Integer) type.  States that this
     * feature is desired for the {@code GraphicsConfiguration}
     * object.  A selection with this feature is preferred over a
     * selection that does not include this feature, although both
     * selections can be considered valid matches.
     */
    public static final int PREFERRED   = 2;

    /**
     * Value used for "Enum" (Integer) type.  States that this
     * feature is not necessary for the selection of the
     * {@code GraphicsConfiguration} object.  A selection
     * without this feature is preferred over a selection that
     * includes this feature since it is not used.
     */
    public static final int UNNECESSARY = 3;

    /**
     * Returns the "best" configuration possible that passes the
     * criteria defined in the {@code GraphicsConfigTemplate}.
     * @param gc the array of {@code GraphicsConfiguration}
     * objects to choose from.
     * @return a {@code GraphicsConfiguration} object that is
     * the best configuration possible.
     * @see GraphicsConfiguration
     */
    public abstract GraphicsConfiguration
      getBestConfiguration(GraphicsConfiguration[] gc);

    /**
     * Returns a {@code boolean} indicating whether or
     * not the specified {@code GraphicsConfiguration} can be
     * used to create a drawing surface that supports the indicated
     * features.
     * @param gc the {@code GraphicsConfiguration} object to test
     * @return {@code true} if this
     * {@code GraphicsConfiguration} object can be used to create
     * surfaces that support the indicated features;
     * {@code false} if the {@code GraphicsConfiguration} can
     * not be used to create a drawing surface usable by this Java(tm)
     * API.
     */
    public abstract boolean
      isGraphicsConfigSupported(GraphicsConfiguration gc);

}
