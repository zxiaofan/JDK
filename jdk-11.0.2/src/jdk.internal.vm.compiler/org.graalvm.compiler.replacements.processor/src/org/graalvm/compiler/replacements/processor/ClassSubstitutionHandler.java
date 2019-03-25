/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.processor;

import static org.graalvm.compiler.processor.AbstractProcessor.getAnnotationValue;
import static org.graalvm.compiler.processor.AbstractProcessor.getAnnotationValueList;

import java.util.List;

import javax.annotation.processing.Messager;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic.Kind;

import org.graalvm.compiler.processor.AbstractProcessor;

/**
 * Handler for the {@value #CLASS_SUBSTITUTION_CLASS_NAME} annotation.
 */
public final class ClassSubstitutionHandler extends AnnotationHandler {

    static final String CLASS_SUBSTITUTION_CLASS_NAME = "org.graalvm.compiler.api.replacements.ClassSubstitution";

    public ClassSubstitutionHandler(AbstractProcessor env) {
        super(env, CLASS_SUBSTITUTION_CLASS_NAME);
    }

    @Override
    public void process(Element element, AnnotationMirror classSubstitution, PluginGenerator generator) {
        if (!element.getKind().isClass()) {
            assert false : "Element is guaranteed to be a class.";
            return;
        }
        TypeElement type = (TypeElement) element;

        TypeElement substitutionType = resolveOriginalType(processor, type, classSubstitution);
        if (substitutionType == null) {
            return;
        }
    }

    static TypeElement resolveOriginalType(AbstractProcessor processor, Element sourceElement, AnnotationMirror classSubstition) {
        TypeMirror type = getAnnotationValue(classSubstition, "value", TypeMirror.class);
        List<String> classNames = getAnnotationValueList(classSubstition, "className", String.class);
        boolean optional = getAnnotationValue(classSubstition, "optional", Boolean.class);

        Messager messager = processor.env().getMessager();
        if (type.getKind() != TypeKind.DECLARED) {
            messager.printMessage(Kind.ERROR, "The provided class must be a declared type.", sourceElement, classSubstition);
            return null;
        }

        if (!classSubstition.getAnnotationType().asElement().equals(((DeclaredType) type).asElement())) {
            if (classNames.size() != 0) {
                String msg = "The usage of value and className is exclusive.";
                messager.printMessage(Kind.ERROR, msg, sourceElement, classSubstition);
                messager.printMessage(Kind.ERROR, msg, sourceElement, classSubstition);
            }

            return (TypeElement) ((DeclaredType) type).asElement();
        }

        if (classNames.size() != 0) {
            TypeElement typeElement = null;
            for (String className : classNames) {
                typeElement = processor.getTypeElementOrNull(className);
                if (typeElement != null) {
                    break;
                }
            }
            if (typeElement == null && !optional) {
                messager.printMessage(Kind.ERROR, String.format("None of the classes %s were found on the classpath.", classNames), sourceElement, classSubstition);
            }

            return typeElement;
        }

        if (!optional) {
            messager.printMessage(Kind.ERROR, String.format("No value for 'value' or 'className' provided."), sourceElement, classSubstition);
        }

        return null;
    }

}
