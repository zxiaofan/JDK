/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.ldap;

import javax.naming.ldap.*;

/**
  * This class provides a basic implementation of the {@code Control}
  * interface. It represents an LDAPv3 Control as defined in RFC-2251.
  *
  * @author Vincent Ryan
  */
public class BasicControl implements Control {

    /**
     * The control's object identifier string.
     *
     * @serial
     */
    protected String id;

    /**
     * The control's criticality.
     *
     * @serial
     */
    protected boolean criticality = false; // default

    /**
     * The control's ASN.1 BER encoded value.
     *
     * @serial
     */
    protected byte[] value = null;

    private static final long serialVersionUID = -5914033725246428413L;

    /**
     * Constructs a new instance of BasicControl.
     * It is a non-critical control.
     *
     * @param   id      The control's object identifier string.
     *
     */
    public BasicControl(String id) {
        this.id = id;
    }

    /**
     * Constructs a new instance of BasicControl.
     *
     * @param   id              The control's object identifier string.
     * @param   criticality     The control's criticality.
     * @param   value           The control's ASN.1 BER encoded value.
     *                          May be null.
     */
    public BasicControl(String id, boolean criticality, byte[] value) {
        this.id = id;
        this.criticality = criticality;
        if (value != null) {
            this.value = value.clone();
        }
    }

    /**
      * Retrieves the control's object identifier string.
      *
      * @return The non-null object identifier string.
      */
    public String getID() {
        return id;
    }

    /**
      * Determines the control's criticality.
      *
      * @return true if the control is critical; false otherwise.
      */
    public boolean isCritical() {
        return criticality;
    }

    /**
      * Retrieves the control's ASN.1 BER encoded value.
      * The result is the raw BER bytes including the tag and length of
      * the control's value. It does not include the control's object
      * identifier string or criticality.
      *
      * @return A possibly null byte array representing the control's
      *         ASN.1 BER encoded value.
      */
    public byte[] getEncodedValue() {
        return value == null ? null : value.clone();
    }
}
