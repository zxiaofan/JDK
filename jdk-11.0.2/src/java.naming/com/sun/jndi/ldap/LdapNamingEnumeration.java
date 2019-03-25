/*
 * Copyright (c) 1999, 2011, Oracle and/or its affiliates. All rights reserved.
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

import javax.naming.*;
import javax.naming.directory.*;

import com.sun.jndi.toolkit.ctx.Continuation;
import java.util.Vector;
import javax.naming.ldap.Control;


final class LdapNamingEnumeration
        extends AbstractLdapNamingEnumeration<NameClassPair> {

    private static final String defaultClassName = DirContext.class.getName();

    LdapNamingEnumeration(LdapCtx homeCtx, LdapResult answer, Name listArg,
                                 Continuation cont) throws NamingException {
        super(homeCtx, answer, listArg, cont);
    }

    @Override
    protected NameClassPair createItem(String dn, Attributes attrs,
            Vector<Control> respCtls) throws NamingException {

        Attribute attr;
        String className = null;

        // use the Java classname if present
        if ((attr = attrs.get(Obj.JAVA_ATTRIBUTES[Obj.CLASSNAME])) != null) {
            className = (String)attr.get();
        } else {
            className = defaultClassName;
        }
        CompositeName cn = new CompositeName();
        cn.add(getAtom(dn));

        NameClassPair ncp;
        if (respCtls != null) {
            ncp = new NameClassPairWithControls(
                        cn.toString(), className,
                        homeCtx.convertControls(respCtls));
        } else {
            ncp = new NameClassPair(cn.toString(), className);
        }
        ncp.setNameInNamespace(dn);
        return ncp;
    }

    @Override
    protected AbstractLdapNamingEnumeration<? extends NameClassPair> getReferredResults(
            LdapReferralContext refCtx) throws NamingException {
        // repeat the original operation at the new context
        return (AbstractLdapNamingEnumeration<? extends NameClassPair>)refCtx.list(listArg);
    }
}
