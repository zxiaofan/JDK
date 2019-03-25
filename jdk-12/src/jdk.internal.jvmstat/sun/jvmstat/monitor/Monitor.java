/*
 * Copyright (c) 2004, 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvmstat.monitor;

/**
 * Interface provided by Instrumentation Monitoring Objects.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public interface Monitor  {

    /**
     * Returns the name of this instrumentation object.
     *
     * @return String - the name assigned to this instrumentation monitoring
     *                  object
     */
    String getName();

    /**
     * Returns the base name of this instrumentation object.
     * The base name is the component of the name following the last
     * "." character in the name.
     *
     * @return String - the base name of the name assigned to this
     *                  instrumentation monitoring object.
     */
    String getBaseName();

    /**
     * Returns the Units for this instrumentation monitoring object.
     *
     * @return Units - the units of measure attribute
     */
    Units getUnits();

    /**
     * Returns the Variability for this instrumentation object.
     *
     *@return Variability - the variability attribute
     */
    Variability getVariability();

    /**
     * Test if the instrumentation object is a vector type.
     *
     * @return boolean - true if this instrumentation object is a vector type,
     *                   false otherwise.
     */
    boolean isVector();

    /**
     * Return the length of the vector.
     * @return int - the length of the vector or zero if this instrumentation
     *               object is a scalar type.
     */
    int getVectorLength();

    /**
     * Test if the instrumentation object is supported.
     */
    boolean isSupported();

    /**
     * Return an Object that encapsulates this instrumentation object's
     * current data value.
     */
    Object getValue();
}
