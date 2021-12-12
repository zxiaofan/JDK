/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.util.locale.provider;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ServiceConfigurationError;
import java.util.spi.LocaleServiceProvider;

/**
 * LocaleProviderAdapter implementation for the host locale data.
 * Currently it is only implemented on Windows Vista or later.
 *
 * @author Naoto Sato
 */
public class HostLocaleProviderAdapter extends AuxLocaleProviderAdapter {

    /**
     * Returns the type of this LocaleProviderAdapter
     */
    @Override
    public LocaleProviderAdapter.Type getAdapterType() {
        return LocaleProviderAdapter.Type.HOST;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected <P extends LocaleServiceProvider> P findInstalledProvider(final Class<P> c) {
        try {
            return (P)Class.forName(
                        "sun.util.locale.provider.HostLocaleProviderAdapterImpl")
                    .getMethod("get" + c.getSimpleName(), (Class<?>[]) null)
                    .invoke(null, (Object[]) null);
        } catch (ClassNotFoundException |
                 NoSuchMethodException ex) {
            // permissible exceptions as platform may not support host adapter
            return null;
        } catch (IllegalAccessException |
                 IllegalArgumentException |
                 InvocationTargetException ex) {
            throw new ServiceConfigurationError(
                "Host locale provider cannot be located.", ex);
        }
    }

    /**
     * Utility to make the decimal format specific to integer, called
     * by the platform dependent adapter implementations.
     *
     * @param df A DecimalFormat object
     * @return The same DecimalFormat object in the argument, modified
     *          to allow integer formatting/parsing only.
     */
    static DecimalFormat makeIntegerFormatter(DecimalFormat df) {
        df.setMaximumFractionDigits(0);
        df.setDecimalSeparatorAlwaysShown(false);
        df.setParseIntegerOnly(true);
        return df;
    }
}
