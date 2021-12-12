/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.smartcardio;

import java.security.*;

import javax.smartcardio.*;
import static sun.security.util.SecurityConstants.PROVIDER_VER;

/**
 * Provider object for PC/SC.
 *
 * @since   1.6
 * @author  Andreas Sterbenz
 */
public final class SunPCSC extends Provider {

    private static final long serialVersionUID = 6168388284028876579L;

    private static final class ProviderService extends Provider.Service {

        ProviderService(Provider p, String type, String algo, String cn) {
            super(p, type, algo, cn, null, null);
        }

        @Override
        public Object newInstance(Object ctrParamObj)
            throws NoSuchAlgorithmException {
            String type = getType();
            String algo = getAlgorithm();
            try {
                if (type.equals("TerminalFactory") &&
                    algo.equals("PC/SC")) {
                    return new SunPCSC.Factory(ctrParamObj);
                }
            } catch (Exception ex) {
                throw new NoSuchAlgorithmException("Error constructing " +
                    type + " for " + algo + " using SunPCSC", ex);
            }
            throw new ProviderException("No impl for " + algo +
                " " + type);
        }
    }

    @SuppressWarnings("removal")
    public SunPCSC() {
        super("SunPCSC", PROVIDER_VER, "Sun PC/SC provider");

        final Provider p = this;
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                putService(new ProviderService(p, "TerminalFactory",
                           "PC/SC", "sun.security.smartcardio.SunPCSC$Factory"));
                return null;
            }
        });
    }

    public static final class Factory extends TerminalFactorySpi {
        public Factory(Object obj) throws PCSCException {
            if (obj != null) {
                throw new IllegalArgumentException
                    ("SunPCSC factory does not use parameters");
            }
            // make sure PCSC is available and that we can obtain a context
            PCSC.checkAvailable();
            PCSCTerminals.initContext();
        }
        /**
         * Returns the available readers.
         * This must be a new object for each call.
         */
        protected CardTerminals engineTerminals() {
            return new PCSCTerminals();
        }
    }

}
