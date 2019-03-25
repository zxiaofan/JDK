/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.ldap.*;

/**
 * This class represents a factory for creating LDAPv3 response controls.
 * The following response controls are supported:
 * <ul>
 * <li>
 * Paged results, as defined in
 * <a href="http://www.ietf.org/rfc/rfc2696.txt">RFC 2696</a>.
 * <li>
 * Server-side sorting, as defined in
 * <a href="http://www.ietf.org/rfc/rfc2891.txt">RFC 2891</a>.
 * <li>
 * Entry change response control, as defined in
 * <a href="http://www.ietf.org/internet-drafts/draft-ietf-ldapext-psearch-02.txt">draft-ietf-ldapext-psearch-02.txt</a>.
 * </ul>
 *
 * @see javax.naming.ldap.SortResponseControl
 * @see javax.naming.ldap.PagedResultsResponseControl
 * @see PersistentSearchControl
 * @see EntryChangeResponseControl
 * @author Vincent Ryan
 */
public class DefaultResponseControlFactory extends ControlFactory {

    /**
     * Constructs a new instance of the response control factory.
     */
    public DefaultResponseControlFactory() {
    }

    /**
     * Creates an instance of a response control class from a more
     * generic control class (BasicControl).
     *
     * @param ctl A non-null control.
     * @return    The LDAP control created or null if it cannot be created.
     *            Null indicates that another factory should be attempted.
     * @exception NamingException if this control factory encountered an
     *            error condition while attempting to create the LDAP control,
     *            and no other control factories are to be tried.
     */
    public Control getControlInstance(Control ctl)
        throws NamingException {

        String id = ctl.getID();
//System.out.println(id);

        try {
            if (id.equals(SortResponseControl.OID)) {
                return new SortResponseControl(id, ctl.isCritical(),
                    ctl.getEncodedValue());

            } else if (id.equals(PagedResultsResponseControl.OID)) {
                return new PagedResultsResponseControl(id, ctl.isCritical(),
                    ctl.getEncodedValue());

            } else if (id.equals(EntryChangeResponseControl.OID)) {
                return new EntryChangeResponseControl(id, ctl.isCritical(),
                    ctl.getEncodedValue());

            }
        } catch (IOException e) {
            NamingException ne = new NamingException();
            ne.setRootCause(e);
            throw ne;
        }
        return null;
    }
}
