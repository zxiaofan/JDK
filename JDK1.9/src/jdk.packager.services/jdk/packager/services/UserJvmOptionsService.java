/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.packager.services;

import jdk.packager.services.userjvmoptions.PreferencesUserJvmOptions;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Runtime access to the UserJVMOptions.
 *
 * This class is not typically available in the Java Runtime, you must
 * explicitly include the 'jdk.packager.services' module from the jmod directory
 * of the JDK as part of your application bundle.
 *
 * @since 9
 */
public interface UserJvmOptionsService {

    /**
     * Get the instance of UserJvmOptionService to use.  Which one to use is
     * configured by the packager and the launcher.  Do not directly
     * instantiate any instance of this interface, use this method to get
     * an appropriate instance.
     *
     * @return the instance of UserJvmOptionsService for your application.
     */
    static UserJvmOptionsService getUserJVMDefaults() {
        ServiceLoader<UserJvmOptionsService> loader = ServiceLoader.load(UserJvmOptionsService.class);
        Iterator<UserJvmOptionsService> iter = loader.iterator();
        if (iter.hasNext()) {
            return iter.next();
        } else {
            return new PreferencesUserJvmOptions();
        }
    }

    /**
     * The "current" set of UserJVMOptions.
     *
     * This will take effect on the next application start, and this may not
     * reflect the current set of UserJVMOptions used to start this application.
     *
     * @return A map of the keys and values.  Alterations to this map will not
     *         change the stored UserJVMOptions
     */
    Map<String, String> getUserJVMOptions();

    /**
     * Sets the passed in options as the UserJVMOptions.
     *
     * If the application has specified default values and those keys are not
     * in this map, they will be replaced by the default values.
     *
     * No validation or error checking is performed on these values.  It is
     * entirely possible that you may provide a set of UserJVMOptions that
     * may prevent the normal startup of your application and may require
     * manual intervention to resolve.
     *
     * @param options The UserJVMOptions to set.
     */
    void setUserJVMOptions(Map<String, String> options);

    /**
     * The "default" set of UserJVMOptions.
     *
     * This returns the default set of keys and values that the application has
     * been configured to use.
     *
     * @return the keys and values of the default UserJVMOptions.
     * @throws UnsupportedOperationException if the defaults cannot be calculated.
     */
    Map<String, String> getUserJVMOptionDefaults();
}
