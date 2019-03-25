/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.beans.decoder;

import com.sun.beans.finder.MethodFinder;

import java.lang.reflect.Method;

import sun.reflect.misc.MethodUtil;

/**
 * This class is intended to handle &lt;method&gt; element.
 * It describes invocation of the method.
 * The {@code name} attribute denotes
 * the name of the method to invoke.
 * If the {@code class} attribute is specified
 * this element invokes static method of specified class.
 * The inner elements specifies the arguments of the method.
 * For example:<pre>
 * &lt;method name="valueOf" class="java.lang.Long"&gt;
 *     &lt;string&gt;10&lt;/string&gt;
 * &lt;/method&gt;</pre>
 * is equivalent to {@code Long.valueOf("10")} in Java code.
 * <p>The following attributes are supported:
 * <dl>
 * <dt>name
 * <dd>the method name
 * <dt>class
 * <dd>the type of object for instantiation
 * <dt>id
 * <dd>the identifier of the variable that is intended to store the result
 * </dl>
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
final class MethodElementHandler extends NewElementHandler {
    private String name;

    /**
     * Parses attributes of the element.
     * The following attributes are supported:
     * <dl>
     * <dt>name
     * <dd>the method name
     * <dt>class
     * <dd>the type of object for instantiation
     * <dt>id
     * <dd>the identifier of the variable that is intended to store the result
     * </dl>
     *
     * @param name   the attribute name
     * @param value  the attribute value
     */
    @Override
    public void addAttribute(String name, String value) {
        if (name.equals("name")) { // NON-NLS: the attribute name
            this.name = value;
        } else {
            super.addAttribute(name, value);
        }
    }

    /**
     * Returns the result of method execution.
     *
     * @param type  the base class
     * @param args  the array of arguments
     * @return the value of this element
     * @throws Exception if calculation is failed
     */
    @Override
    protected ValueObject getValueObject(Class<?> type, Object[] args) throws Exception {
        Object bean = getContextBean();
        Class<?>[] types = getArgumentTypes(args);
        Method method = (type != null)
                ? MethodFinder.findStaticMethod(type, this.name, types)
                : MethodFinder.findMethod(bean.getClass(), this.name, types);

        if (method.isVarArgs()) {
            args = getArguments(args, method.getParameterTypes());
        }
        Object value = MethodUtil.invoke(method, bean, args);
        return method.getReturnType().equals(void.class)
                ? ValueObjectImpl.VOID
                : ValueObjectImpl.create(value);
    }
}
