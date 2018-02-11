/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.codemodel.internal;




/**
 * A field that can have a {@link JDocComment} associated with it
 */
public class JFieldVar extends JVar implements JDocCommentable {

    /**
     * javadoc comments for this JFieldVar
     */
    private JDocComment jdoc = null;

    private final JDefinedClass owner;


    /**
     * JFieldVar constructor
     *
     * @param type
     *        Datatype of this variable
     *
     * @param name
     *        Name of this variable
     *
     * @param init
     *        Value to initialize this variable to
     */
    JFieldVar(JDefinedClass owner, JMods mods, JType type, String name, JExpression init) {
        super( mods, type, name, init );
        this.owner = owner;
    }

    @Override
    public void name(String name) {
        // make sure that the new name is available
        if(owner.fields.containsKey(name))
            throw new IllegalArgumentException("name "+name+" is already in use");
        String oldName = name();
        super.name(name);
        owner.fields.remove(oldName);
        owner.fields.put(name,this);
    }

    /**
     * Creates, if necessary, and returns the class javadoc for this
     * JDefinedClass
     *
     * @return JDocComment containing javadocs for this class
     */
    public JDocComment javadoc() {
        if( jdoc == null )
            jdoc = new JDocComment(owner.owner());
        return jdoc;
    }

    public void declare(JFormatter f) {
        if( jdoc != null )
            f.g( jdoc );
        super.declare( f );
    }


}
