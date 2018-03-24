/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.objects;

import jdk.nashorn.internal.objects.annotations.Property;
import jdk.nashorn.internal.objects.annotations.ScriptClass;
import jdk.nashorn.internal.runtime.PropertyMap;
import jdk.nashorn.internal.runtime.ScriptObject;

@ScriptClass("IteratorResult")
public class IteratorResult extends ScriptObject {

    // initialized by nasgen
    private static PropertyMap $nasgenmap$;

    IteratorResult(final Object value, final Boolean done, final Global global) {
        super(global.getObjectPrototype(), $nasgenmap$);
        this.value = value;
        this.done = done;
    }

    /**
     * The result value property.
     */
    @Property
    public Object value;

    /**
     * The result status property.
     */
    @Property
    public Object done;

}
