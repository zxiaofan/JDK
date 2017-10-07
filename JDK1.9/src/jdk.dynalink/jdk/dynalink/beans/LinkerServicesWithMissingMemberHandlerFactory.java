/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.dynalink.beans;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.function.Supplier;
import jdk.dynalink.SecureLookupSupplier;
import jdk.dynalink.linker.ConversionComparator.Comparison;
import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.LinkRequest;
import jdk.dynalink.linker.LinkerServices;

final class LinkerServicesWithMissingMemberHandlerFactory implements LinkerServices {
    final LinkerServices linkerServices;
    final MissingMemberHandlerFactory missingMemberHandlerFactory;

    static LinkerServices get(final LinkerServices linkerServices, final MissingMemberHandlerFactory missingMemberHandlerFactory) {
        if (missingMemberHandlerFactory == null) {
            return linkerServices;
        }
        return new LinkerServicesWithMissingMemberHandlerFactory(linkerServices, missingMemberHandlerFactory);
    }

    private LinkerServicesWithMissingMemberHandlerFactory(final LinkerServices linkerServices, final MissingMemberHandlerFactory missingMemberHandlerFactory) {
        this.linkerServices = linkerServices;
        this.missingMemberHandlerFactory = missingMemberHandlerFactory;
    }

    @Override
    public MethodHandle asType(final MethodHandle handle, final MethodType fromType) {
        return linkerServices.asType(handle, fromType);
    }

    @Override
    public MethodHandle getTypeConverter(final Class<?> sourceType, final Class<?> targetType) {
        return linkerServices.getTypeConverter(sourceType, targetType);
    }

    @Override
    public boolean canConvert(final Class<?> from, final Class<?> to) {
        return linkerServices.canConvert(from, to);
    }

    @Override
    public GuardedInvocation getGuardedInvocation(final LinkRequest linkRequest) throws Exception {
        return linkerServices.getGuardedInvocation(linkRequest);
    }

    @Override
    public Comparison compareConversion(final Class<?> sourceType, final Class<?> targetType1, final Class<?> targetType2) {
        return linkerServices.compareConversion(sourceType, targetType1, targetType2);
    }

    @Override
    public MethodHandle filterInternalObjects(final MethodHandle target) {
        return linkerServices.filterInternalObjects(target);
    }

    @Override
    public <T> T getWithLookup(final Supplier<T> operation, final SecureLookupSupplier lookupSupplier) {
        return linkerServices.getWithLookup(operation, lookupSupplier);
    }
}
