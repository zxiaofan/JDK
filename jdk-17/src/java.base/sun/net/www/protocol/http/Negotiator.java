/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.www.protocol.http;

import java.io.IOException;
import java.lang.reflect.Constructor;
import sun.util.logging.PlatformLogger;

/**
 * This abstract class is a bridge to connect NegotiteAuthentication and
 * NegotiatorImpl, so that JAAS and JGSS calls can be made
 */
public abstract class Negotiator {
    static Negotiator getNegotiator(HttpCallerInfo hci) {

        // These lines are equivalent to
        // return new NegotiatorImpl(hci);
        // The current implementation will make sure NegotiatorImpl is not
        // directly referenced when compiling, thus smooth the way of building
        // the J2SE platform where HttpURLConnection is a bootstrap class.
        //
        // Makes NegotiatorImpl, and the security classes it references, a
        // runtime dependency rather than a static one.

        Class<?> clazz;
        Constructor<?> c;
        try {
            clazz = Class.forName("sun.net.www.protocol.http.spnego.NegotiatorImpl",
                                  true,
                                  ClassLoader.getPlatformClassLoader());
            c = clazz.getConstructor(HttpCallerInfo.class);
        } catch (ClassNotFoundException cnfe) {
            finest(cnfe);
            return null;
        } catch (ReflectiveOperationException roe) {
            // if the class is there then something seriously wrong if
            // the constructor is not.
            throw new AssertionError(roe);
        }

        try {
            return (Negotiator) (c.newInstance(hci));
        } catch (ReflectiveOperationException roe) {
            finest(roe);
            Throwable t = roe.getCause();
            if (t instanceof Exception exception)
                finest(exception);
            return null;
        }
    }

    public abstract byte[] firstToken() throws IOException;

    public abstract byte[] nextToken(byte[] in) throws IOException;

    private static void finest(Exception e) {
        PlatformLogger logger = HttpURLConnection.getHttpLogger();
        if (logger.isLoggable(PlatformLogger.Level.FINEST)) {
            logger.finest("NegotiateAuthentication: " + e);
        }
    }
}

