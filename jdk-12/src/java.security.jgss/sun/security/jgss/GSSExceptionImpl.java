/*
 * Copyright (c) 2000, 2006, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.jgss;

import org.ietf.jgss.*;

/**
 * This class helps overcome a limitation of the org.ietf.jgss.GSSException
 * class that does not allow the thrower to set a string corresponding to
 * the major code.
 */
public class GSSExceptionImpl extends GSSException {

    private static final long serialVersionUID = 4251197939069005575L;

    private String majorMessage;

    /**
     * A constructor that takes the majorCode as well as the mech oid that
     * will be appended to the standard message defined in its super class.
     */
    GSSExceptionImpl(int majorCode, Oid mech) {
        super(majorCode);
        this.majorMessage = super.getMajorString() + ": " + mech;
    }

    /**
     * A constructor that takes the majorCode as well as the message that
     * corresponds to it.
     */
    public GSSExceptionImpl(int majorCode, String majorMessage) {
        super(majorCode);
        this.majorMessage = majorMessage;
    }

    /**
     * A constructor that takes the majorCode and the exception cause.
     */
    public GSSExceptionImpl(int majorCode, Exception cause) {
        super(majorCode);
        initCause(cause);
    }

    /**
     * A constructor that takes the majorCode, the message that
     * corresponds to it, and the exception cause.
     */
    public GSSExceptionImpl(int majorCode, String majorMessage,
        Exception cause) {
        this(majorCode, majorMessage);
        initCause(cause);
    }

    /**
     * Returns the message that was embedded in this object, otherwise it
     * returns the default message that an org.ietf.jgss.GSSException
     * generates.
     */
    public String getMessage() {
        if (majorMessage != null)
            return majorMessage;
        else
            return super.getMessage();
    }

}
