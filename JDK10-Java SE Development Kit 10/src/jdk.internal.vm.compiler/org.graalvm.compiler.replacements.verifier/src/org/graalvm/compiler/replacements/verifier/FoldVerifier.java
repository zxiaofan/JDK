/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeKind;
import javax.tools.Diagnostic.Kind;

import org.graalvm.compiler.api.replacements.Fold;

public final class FoldVerifier extends AbstractVerifier {

    public FoldVerifier(ProcessingEnvironment env) {
        super(env);
    }

    @Override
    public Class<? extends Annotation> getAnnotationClass() {
        return Fold.class;
    }

    @Override
    public void verify(Element element, AnnotationMirror annotation, PluginGenerator generator) {
        if (element.getKind() != ElementKind.METHOD) {
            assert false : "Element is guaranteed to be a method.";
            return;
        }

        ExecutableElement foldMethod = (ExecutableElement) element;
        if (foldMethod.getReturnType().getKind() == TypeKind.VOID) {
            env.getMessager().printMessage(Kind.ERROR,
                            String.format("A @%s method must not be void as it won't yield a compile-time constant (the reason for supporting folding!).", Fold.class.getSimpleName()), element,
                            annotation);
        } else if (foldMethod.getModifiers().contains(Modifier.PRIVATE)) {
            env.getMessager().printMessage(Kind.ERROR, String.format("A @%s method must not be private.", Fold.class.getSimpleName()), element, annotation);
        } else {
            generator.addPlugin(new GeneratedFoldPlugin(foldMethod));
        }
    }
}
