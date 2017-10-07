/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

package java.util.spi;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * {@code ResourceBundleProvider} is a provider interface that is used for
 * loading resource bundles for named modules. Implementation classes of
 * this interface are loaded with {@link java.util.ServiceLoader ServiceLoader}
 * during a call to the
 * {@link ResourceBundle#getBundle(String, Locale, ClassLoader)
 * ResourceBundle.getBundle} method. The provider service type is determined by
 * {@code <package name> + ".spi." + <simple name> + "Provider"}.
 *
 * <p>
 * For example, if the base name is "com.example.app.MyResources",
 * {@code com.example.app.spi.MyResourcesProvider} will be the provider service type:
 * <pre>{@code
 * public interface MyResourcesProvider extends ResourceBundleProvider {
 * }
 * }</pre>
 *
 * <p>
 * This providers's {@link #getBundle(String, Locale) getBundle} method is called
 * through the resource bundle loading process instead of {@link
 * java.util.ResourceBundle.Control#newBundle(String, Locale, String, ClassLoader, boolean)
 * ResourceBundle.Control.newBundle()}. Refer to {@link ResourceBundle} for
 * details.
 *
 * @see <a href="../ResourceBundle.html#bundleprovider">
 *     Resource Bundles in Named Modules</a>
 * @see <a href="../ResourceBundle.html#RBP_support">
 *     ResourceBundleProvider Service Providers</a>
 * @since 9
 * @spec JPMS
 */
public interface ResourceBundleProvider {
    /**
     * Returns a {@code ResourceBundle} for the given bundle name and locale.
     * This method returns {@code null} if there is no {@code ResourceBundle}
     * found for the given parameters.
     *
     *
     * @param baseName
     *        the base bundle name of the resource bundle, a fully
     *        qualified class name
     * @param locale
     *        the locale for which the resource bundle should be loaded
     * @return the ResourceBundle created for the given parameters, or null if no
     *         {@code ResourceBundle} for the given parameters is found
     */
    public ResourceBundle getBundle(String baseName, Locale locale);
}
