/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.generator.bean;

import com.sun.codemodel.internal.JDefinedClass;
import com.sun.codemodel.internal.JExpr;
import com.sun.codemodel.internal.JMod;
import com.sun.codemodel.internal.JPackage;
import com.sun.tools.internal.xjc.model.CElementInfo;
import com.sun.tools.internal.xjc.model.Model;

/**
 * {@link ObjectFactoryGenerator} used when we generate
 * interfaces and implementations in separate packages.
 *
 * <p>
 * {@link #publicOFG} and {@link #privateOFG} gives you access to
 * {@code ObjectFactory}s in both packages, if you need to.
 *
 * @author Kohsuke Kawaguchi
 */
public final class DualObjectFactoryGenerator extends ObjectFactoryGenerator {
    public final ObjectFactoryGenerator publicOFG;
    public final ObjectFactoryGenerator privateOFG;

    DualObjectFactoryGenerator(BeanGenerator outline, Model model, JPackage targetPackage) {
        this.publicOFG = new PublicObjectFactoryGenerator(outline,model,targetPackage);
        this.privateOFG = new PrivateObjectFactoryGenerator(outline,model,targetPackage);

        // put the marker so that we can detect missing jaxb.properties
        publicOFG.getObjectFactory().field(JMod.PRIVATE|JMod.STATIC|JMod.FINAL,
                Void.class, "_useJAXBProperties", JExpr._null());
    }

    void populate(CElementInfo ei) {
        publicOFG.populate(ei);
        privateOFG.populate(ei);
    }

    void populate(ClassOutlineImpl cc) {
        publicOFG.populate(cc);
        privateOFG.populate(cc);
    }

    /**
     * Returns the private version (which is what gets used at runtime.)
     */
    public JDefinedClass getObjectFactory() {
        return privateOFG.getObjectFactory();
    }
}
