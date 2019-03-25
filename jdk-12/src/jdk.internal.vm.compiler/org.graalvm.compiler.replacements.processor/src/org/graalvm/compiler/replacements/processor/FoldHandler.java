/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.processor.AbstractProcessor.getSimpleName;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeKind;
import javax.tools.Diagnostic.Kind;

import org.graalvm.compiler.processor.AbstractProcessor;

/**
 * Handler for the {@value #FOLD_CLASS_NAME} annotation.
 */
public final class FoldHandler extends AnnotationHandler {

    static final String FOLD_CLASS_NAME = "org.graalvm.compiler.api.replacements.Fold";
    static final String INJECTED_PARAMETER_CLASS_NAME = "org.graalvm.compiler.api.replacements.Fold.InjectedParameter";

    public FoldHandler(AbstractProcessor processor) {
        super(processor, FOLD_CLASS_NAME);
    }

    @Override
    public void process(Element element, AnnotationMirror annotation, PluginGenerator generator) {
        if (element.getKind() != ElementKind.METHOD) {
            assert false : "Element is guaranteed to be a method.";
            return;
        }

        ExecutableElement foldMethod = (ExecutableElement) element;
        if (foldMethod.getReturnType().getKind() == TypeKind.VOID) {
            processor.env().getMessager().printMessage(Kind.ERROR,
                            String.format("A @%s method must not be void as it won't yield a compile-time constant (the reason for supporting folding!).", getSimpleName(FOLD_CLASS_NAME)), element,
                            annotation);
        } else if (foldMethod.getModifiers().contains(Modifier.PRIVATE)) {
            processor.env().getMessager().printMessage(Kind.ERROR, String.format("A @%s method must not be private.", getSimpleName(FOLD_CLASS_NAME)), element, annotation);
        } else {
            generator.addPlugin(new GeneratedFoldPlugin(foldMethod));
        }
    }
}
