/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdeprscan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;

import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.ModuleElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("*")
public class TraverseProc extends AbstractProcessor {
    Elements elements;
    Messager messager;
    final List<String> moduleRoots;
    Map<PackageElement, List<TypeElement>> publicTypes;

    TraverseProc(List<String> roots) {
        moduleRoots = roots;
    }

    @Override
    public void init(ProcessingEnvironment pe) {
        super.init(pe);
        elements = pe.getElementUtils();
        messager = pe.getMessager();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (roundEnv.processingOver()) {
            return false;
        }

        Set<ModuleElement> modules = new HashSet<>();
        for (String mname : moduleRoots) {
            ModuleElement me = elements.getModuleElement(mname);
            if (me == null) {
                messager.printMessage(Diagnostic.Kind.ERROR,
                                      String.format("module %s not found%n", mname));
            } else {
                modules.addAll(findModules(me));
            }
        }

        Set<PackageElement> packages = findPackages(modules);

        publicTypes = findPublicTypes(packages);

        return true;
    }

    void printPublicTypes() {
        printPublicTypes(publicTypes);
    }

    public Map<PackageElement, List<TypeElement>> getPublicTypes() {
        return publicTypes;
    }

    void printPublicTypes(Map<PackageElement, List<TypeElement>> types) {
        System.out.println("All public types:");
        types.entrySet().stream()
             .sorted(Comparator.comparing(e -> e.getKey().toString()))
             .forEach(e -> {
                 System.out.println("  " + e.getKey());
                 e.getValue().stream()
                         .sorted(Comparator.comparing(TypeElement::toString))
                         .forEach(t -> System.out.println("    " + t));
             });
        System.out.println();
        System.out.flush();
    }

    Set<ModuleElement> findModules(ModuleElement root) {
        return findModules0(root, new HashSet<>(), 0);
    }

    Set<ModuleElement> findModules0(ModuleElement m, Set<ModuleElement> set, int nesting) {
        set.add(m);
        for (ModuleElement.Directive dir : m.getDirectives()) {
            if (dir.getKind() == ModuleElement.DirectiveKind.REQUIRES) {
                ModuleElement.RequiresDirective req = (ModuleElement.RequiresDirective)dir;
                findModules0(req.getDependency(), set, nesting + 1);
            }
        }
        return set;
    }

    Set<PackageElement> findPackages(Collection<ModuleElement> mods) {
        Set<PackageElement> set = new HashSet<>();
        for (ModuleElement m : mods) {
            for (ModuleElement.Directive dir : m.getDirectives()) {
                if (dir.getKind() == ModuleElement.DirectiveKind.EXPORTS) { //XXX
                    ModuleElement.ExportsDirective exp = (ModuleElement.ExportsDirective)dir;
                    if (exp.getTargetModules() == null) {
                        set.add(exp.getPackage());
                    }
                }
            }
        }
        return set;
    }

    Map<PackageElement, List<TypeElement>> findPublicTypes(Collection<PackageElement> pkgs) {
        Map<PackageElement, List<TypeElement>> map = new HashMap<>();
        for (PackageElement pkg : pkgs) {
            List<TypeElement> enclosed = new ArrayList<>();
            for (Element e : pkg.getEnclosedElements()) {
                addPublicTypes(enclosed, e);
            }
            map.put(pkg, enclosed);
        }
        return map;
    }

    void addPublicTypes(List<TypeElement> list, Element e) {
        ElementKind kind = e.getKind();
        if ((kind.isClass() || kind.isInterface())
                && e.getModifiers().contains(Modifier.PUBLIC)) {
            list.add((TypeElement)e);
            for (Element enc : e.getEnclosedElements()) {
                addPublicTypes(list, enc);
            }
        }
    }
}
