/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.util.prefs;
import java.util.*;

/**
 * A factory object that generates Preferences objects.  Providers of
 * new {@link Preferences} implementations should provide corresponding
 * {@code PreferencesFactory} implementations so that the new
 * {@code Preferences} implementation can be installed in place of the
 * platform-specific default implementation.
 *
 * <p><strong>This class is for {@code Preferences} implementers only.
 * Normal users of the {@code Preferences} facility should have no need to
 * consult this documentation.</strong>
 *
 * @author  Josh Bloch
 * @see     Preferences
 * @since   1.4
 */
public interface PreferencesFactory {
    /**
     * Returns the system root preference node.  (Multiple calls on this
     * method will return the same object reference.)
     * @return the system root preference node
     */
    Preferences systemRoot();

    /**
     * Returns the user root preference node corresponding to the calling
     * user.  In a server, the returned value will typically depend on
     * some implicit client-context.
     * @return the user root preference node corresponding to the calling
     * user
     */
    Preferences userRoot();
}
