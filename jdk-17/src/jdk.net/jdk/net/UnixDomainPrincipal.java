/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.net;

import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.GroupPrincipal;
import java.util.Objects;

/**
 * Represents the credentials of a peer connected to a
 * <a href="../../../java.base/java/nio/channels/package-summary.html#unixdomain">
 * Unix domain</a> socket.
 *
 * @param user the user identity
 * @param group the group identity
 *
 * @since 16
 */
public record UnixDomainPrincipal(UserPrincipal user, GroupPrincipal group) {

    /**
     * Creates a UnixDomainPrincipal.
     *
     * @param user the user identity
     * @param group the group identity
     *
     * @throws NullPointerException if {@code user} or {@code group} are {@code null}.
     */
    public UnixDomainPrincipal {
        Objects.requireNonNull(user);
        Objects.requireNonNull(group);
    }
}
