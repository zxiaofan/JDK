/*
 * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
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

package javax.smartcardio;

import java.util.*;

/**
 * The TerminalFactorySpi class defines the service provider interface.
 * Applications do not access this class directly, instead see
 * {@linkplain TerminalFactory}.
 *
 * <P>Service providers that want to write a new implementation should define
 * a concrete subclass of TerminalFactorySpi with a constructor that takes
 * an <code>Object</code> as parameter. That class needs to be registered
 * in a {@linkplain java.security.Provider}. The engine
 * {@linkplain java.security.Provider.Service#getType type} is
 * <code>TerminalFactory</code>.
 * Service providers also need to implement subclasses of the abstract classes
 * {@linkplain CardTerminals}, {@linkplain CardTerminal}, {@linkplain Card},
 * and {@linkplain CardChannel}.
 *
 * <p>For example:
 * <pre><em>file MyProvider.java:</em>
 *
 * package com.somedomain.card;
 *
 * import java.security.Provider;
 *
 * public class MyProvider extends Provider {
 *     public MyProvider() {
 *         super("MyProvider", 1.0d, "Smart Card Example");
 *         put("TerminalFactory.MyType", "com.somedomain.card.MySpi");
 *     }
 * }
 *
 *<em>file MySpi.java</em>
 *
 * package com.somedomain.card;
 *
 * import javax.smartcardio.*;
 *
 * public class MySpi extends TerminalFactoySpi {
 *      public MySpi(Object parameter) {
 *          // initialize as appropriate
 *      }
 *      protected CardTerminals engineTerminals() {
 *          // add implementation code here
 *      }
 * }
 * </pre>
 *
 * @see TerminalFactory
 * @see java.security.Provider
 *
 * @since   1.6
 * @author  Andreas Sterbenz
 * @author  JSR 268 Expert Group
 */
public abstract class TerminalFactorySpi {

    /**
     * Constructs a new TerminalFactorySpi object.
     *
     * <p>This class is part of the service provider interface and not accessed
     * directly by applications. Applications
     * should use TerminalFactory objects, which can be obtained by calling
     * one of the
     * {@linkplain TerminalFactory#getInstance TerminalFactory.getInstance()}
     * methods.
     *
     * <p>Concrete subclasses should define a constructor that takes an
     * <code>Object</code> as parameter. It will be invoked when an
     * application calls one of the {@linkplain TerminalFactory#getInstance
     * TerminalFactory.getInstance()} methods and receives the <code>params</code>
     * object specified by the application.
     */
    protected TerminalFactorySpi() {
        // empty
    }

    /**
     * Returns the CardTerminals created by this factory.
     *
     * @return the CardTerminals created by this factory.
     */
    protected abstract CardTerminals engineTerminals();

}
