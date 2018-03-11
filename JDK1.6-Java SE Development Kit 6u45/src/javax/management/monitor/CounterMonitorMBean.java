/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.management.monitor; 

// jmx imports
//
import javax.management.ObjectName;

/**
 * Exposes the remote management interface of the counter monitor MBean.
 *
 * @version     %I%     %G%
 * @author      Sun Microsystems, Inc
 *
 * @since 1.5
 */
public interface CounterMonitorMBean extends MonitorMBean { 
        
    // GETTERS AND SETTERS
    //--------------------    
    
    /**
     * Gets the derived gauge.
     *
     * @return The derived gauge.
     * @deprecated As of JMX 1.2, replaced by {@link #getDerivedGauge(ObjectName)}
     */
    @Deprecated
    public Number getDerivedGauge();
    
    /**
     * Gets the derived gauge timestamp.
     *
     * @return The derived gauge timestamp.
     * @deprecated As of JMX 1.2, replaced by {@link #getDerivedGaugeTimeStamp(ObjectName)}
     */
    @Deprecated
    public long getDerivedGaugeTimeStamp();
    
    /**
     * Gets the threshold value.
     *
     * @return The threshold value.
     *
     * @see #setThreshold(Number)
     *
     * @deprecated As of JMX 1.2, replaced by {@link #getThreshold(ObjectName)}
     */
    @Deprecated
    public Number getThreshold(); 

    /**
     * Sets the threshold value.
     *
     * @see #getThreshold()
     *
     * @param value The threshold value.
     * @exception java.lang.IllegalArgumentException The specified threshold is null or the threshold value is less than zero.
     * @deprecated As of JMX 1.2, replaced by {@link #setInitThreshold}
     */
    @Deprecated
    public void setThreshold(Number value) throws java.lang.IllegalArgumentException; 

    /**
     * Gets the derived gauge for the specified MBean.
     *
     * @param object the MBean for which the derived gauge is to be returned
     * @return The derived gauge for the specified MBean if this MBean is in the
     *         set of observed MBeans, or <code>null</code> otherwise.
     *
     * @since.unbundled JMX 1.2
     */
    public Number getDerivedGauge(ObjectName object);
    
    /**
     * Gets the derived gauge timestamp for the specified MBean.
     *
     * @param object the MBean for which the derived gauge timestamp is to be returned
     * @return The derived gauge timestamp for the specified MBean if this MBean
     *         is in the set of observed MBeans, or <code>null</code> otherwise.
     *
     * @since.unbundled JMX 1.2
     */
    public long getDerivedGaugeTimeStamp(ObjectName object);
    
    /**
     * Gets the threshold value for the specified MBean.
     *
     * @param object the MBean for which the threshold value is to be returned
     * @return The threshold value for the specified MBean if this MBean
     *         is in the set of observed MBeans, or <code>null</code> otherwise.
     *
     * @see #setThreshold
     *
     * @since.unbundled JMX 1.2
     */
    public Number getThreshold(ObjectName object); 

    /**
     * Gets the initial threshold value common to all observed objects.
     *
     * @return The initial threshold value.
     *
     * @see #setInitThreshold
     *
     * @since.unbundled JMX 1.2
     */
    public Number getInitThreshold();
    
    /**
     * Sets the initial threshold value common to all observed MBeans.
     *
     * @param value The initial threshold value.
     * @exception java.lang.IllegalArgumentException The specified
     * threshold is null or the threshold value is less than zero.
     *
     * @see #getInitThreshold
     *
     * @since.unbundled JMX 1.2
     */
    public void setInitThreshold(Number value) throws java.lang.IllegalArgumentException;

    /**
     * Gets the offset value.
     *
     * @see #setOffset(Number)
     *
     * @return The offset value.
     */
    public Number getOffset(); 

    /**
     * Sets the offset value.
     *
     * @param value The offset value.
     * @exception java.lang.IllegalArgumentException The specified
     * offset is null or the offset value is less than zero.
     *
     * @see #getOffset()
     */
    public void setOffset(Number value) throws java.lang.IllegalArgumentException; 

    /**
     * Gets the modulus value.
     *
     * @return The modulus value.
     *
     * @see #setModulus
     */
    public Number getModulus(); 

    /**
     * Sets the modulus value.
     *
     * @param value The modulus value.
     * @exception java.lang.IllegalArgumentException The specified
     * modulus is null or the modulus value is less than zero.
     *
     * @see #getModulus
     */
    public void setModulus(Number value) throws java.lang.IllegalArgumentException; 
    
    /**
     * Gets the notification's on/off switch value.
     *
     * @return <CODE>true</CODE> if the counter monitor notifies when
     * exceeding the threshold, <CODE>false</CODE> otherwise.
     *
     * @see #setNotify
     */
    public boolean getNotify(); 

    /**
     * Sets the notification's on/off switch value.
     *
     * @param value The notification's on/off switch value.
     *
     * @see #getNotify
     */
    public void setNotify(boolean value); 

    /**
     * Gets the difference mode flag value.
     *
     * @return <CODE>true</CODE> if the difference mode is used,
     * <CODE>false</CODE> otherwise.
     *
     * @see #setDifferenceMode
     */
    public boolean getDifferenceMode(); 

    /**
     * Sets the difference mode flag value.
     *
     * @param value The difference mode flag value.
     *
     * @see #getDifferenceMode
     */
    public void setDifferenceMode(boolean value); 
}
