/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
 */
package org.graalvm.compiler.replacements.verifier;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;

public abstract class AbstractVerifier {

    protected final ProcessingEnvironment env;

    public AbstractVerifier(ProcessingEnvironment env) {
        this.env = env;
    }

    public abstract void verify(Element element, AnnotationMirror annotation, PluginGenerator generator);

    public abstract Class<? extends Annotation> getAnnotationClass();

    @SuppressWarnings("unchecked")
    protected static <T> T resolveAnnotationValue(Class<T> expectedType, AnnotationValue value) {
        if (value == null) {
            return null;
        }
        if (expectedType.isArray()) {
            ArrayList<Object> result = new ArrayList<>();
            List<AnnotationValue> l = (List<AnnotationValue>) value.getValue();
            for (AnnotationValue el : l) {
                result.add(resolveAnnotationValue(expectedType.getComponentType(), el));
            }
            return (T) result.toArray((Object[]) Array.newInstance(expectedType.getComponentType(), result.size()));
        }
        Object unboxedValue = value.getValue();
        if (unboxedValue != null) {
            if (expectedType == TypeMirror.class && unboxedValue instanceof String) {
                /*
                 * Happens if type is invalid when using the ECJ compiler. The ECJ does not match
                 * AP-API specification here.
                 */
                return null;
            }
            if (!expectedType.isAssignableFrom(unboxedValue.getClass())) {
                throw new ClassCastException(unboxedValue.getClass().getName() + " not assignable from " + expectedType.getName());
            }
        }
        return (T) unboxedValue;
    }

    protected static AnnotationValue findAnnotationValue(AnnotationMirror mirror, String name) {
        ExecutableElement valueMethod = null;
        for (ExecutableElement method : ElementFilter.methodsIn(mirror.getAnnotationType().asElement().getEnclosedElements())) {
            if (method.getSimpleName().toString().equals(name)) {
                valueMethod = method;
                break;
            }
        }

        if (valueMethod == null) {
            return null;
        }

        AnnotationValue value = mirror.getElementValues().get(valueMethod);
        if (value == null) {
            value = valueMethod.getDefaultValue();
        }

        return value;
    }

}
