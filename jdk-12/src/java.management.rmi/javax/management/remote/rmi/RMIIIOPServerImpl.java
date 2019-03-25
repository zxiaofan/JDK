/*
 * Copyright (c) 2003, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.management.remote.rmi;

import java.io.IOException;
import java.rmi.Remote;
import java.util.Map;
import javax.security.auth.Subject;

/**
 * <p>An {@link RMIServerImpl} that is exported through IIOP and that
 * creates client connections as RMI objects exported through IIOP.
 * User code does not usually reference this class directly.</p>
 *
 * @see RMIServerImpl
 *
 * @since 1.5
 * @deprecated This transport is no longer supported.
 */
@Deprecated
public class RMIIIOPServerImpl extends RMIServerImpl {
    /**
     * Throws {@linkplain UnsupportedOperationException}
     *
     * @param env the environment containing attributes for the new
     * <code>RMIServerImpl</code>.  Can be null, which is equivalent
     * to an empty Map.
     *
     * @throws IOException if the RMI object cannot be created.
     */
    public RMIIIOPServerImpl(Map<String,?> env)
            throws IOException {
        super(env);

        throw new UnsupportedOperationException();
    }

    @Override
    protected void export() throws IOException {
        throw new UnsupportedOperationException("Method not supported. JMX RMI-IIOP is deprecated");
    }

    @Override
    protected String getProtocol() {
        return "iiop";
    }

    @Override
    public Remote toStub() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected RMIConnection makeClient(String connectionId, Subject subject)
            throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void closeClient(RMIConnection client) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void closeServer() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    RMIConnection doNewClient(final Object credentials) throws IOException {
        throw new UnsupportedOperationException();
    }
}
