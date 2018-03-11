/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.jmx.trace;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides an implementation of the {@link com.sun.jmx.trace.TraceDestination}
 * interface which uses the J2SE logging API.
 * <br><br>
 * Note that this implementation can be used only with J2SE version 1.4 or
 * higher.
 * <br><br>
 * All {@link Logger}s are contained in the <code>javax.management</code> namespace, which corresponds
 * to the name of the root package hosting all public JMX interfaces. For each log type
 * defined in {@link TraceTags}, we use a dedicated {@link Logger} with the same name
 * under <code>javax.management</code>.
 * <br><br>
 * The table below shows the list of {@link Logger} objects used in this implementation and
 * their corresponding category of activity.
 * <br><br>
 *  <table cols="3" width="100%" border="1" align="center">
 *    <tr>
 *      <th>Logger Name</th>
 *      <th>JMX log type</th>
 *      <th>Information logged</th>
 *    </tr>
 *    <tr>
 *      <td><code>javax.management.mbeanserver</code></td>
 *      <td>{@link TraceTags#INFO_MBEANSERVER}</td>
 *      <td>Information about the MBean Server</td>
 *    </tr>
 *    <tr>
 *      <td><code>com.sun.jmx.snmp.daemon</code></td>
 *      <td>{@link TraceTags#INFO_ADAPTOR_SNMP}</td>
 *      <td>Information about the SNMP Adaptor</td>
 *    </tr>
 *    <tr>
 *      <td><code>com.sun.jmx.snmp</code></td>
 *      <td>{@link TraceTags#INFO_SNMP}</td>
 *      <td>Information about SNMP</td>
 *    </tr>
 *    <tr>
 *      <td><code>javax.management.mlet</code></td>
 *      <td>{@link TraceTags#INFO_MLET}</td>
 *      <td>Information from an MLet service</td>
 *    </tr>
 *    <tr>
 *      <td><code>javax.management.monitor</code></td>
 *      <td>{@link TraceTags#INFO_MONITOR}</td>
 *      <td>Information from a monitor</td>
 *    </tr>
 *    <tr>
 *      <td><code>javax.management.timer</code></td>
 *      <td>{@link TraceTags#INFO_TIMER}</td>
 *      <td>Information from a timer</td>
 *    </tr>
 *    <tr>
 *      <td><code>javax.management.notification</code></td>
 *      <td>{@link TraceTags#INFO_NOTIFICATION}</td>
 *      <td>Information from the notification mechanism</td>
 *    </tr>
 *    <tr>
 *      <td><code>javax.management.relation</code></td>
 *      <td>{@link TraceTags#INFO_RELATION}</td>
 *      <td>Information from the Relation Service</td>
 *    </tr>
 *    <tr>
 *      <td><code>javax.management.modelmbean</code></td>
 *      <td>{@link TraceTags#INFO_MODELMBEAN}</td>
 *      <td>Information from the Model MBean components</td>
 *    </tr>
 *    <tr>
 *      <td><code>javax.management.misc</code></td>
 *      <td>{@link TraceTags#INFO_MISC}</td>
 *      <td>Information sent from any other class</td>
 *    </tr>
 *  </table>
 * <br><br>
 * The mapping for the JMX log levels is the following:
 * <br><br>
 * <table cols="2" width="50%" border="1" align="center">
 *   <tr>
 *     <th>JMX log level</th>
 *     <th>J2SE logging API log level</th>
 *   </tr>
 *   <tr>
 *     <td><center>{@link TraceTags#LEVEL_DEBUG}</center></td>
 *     <td><center>{@link Level#FINEST}</center></td>
 *   </tr>
 *   <tr>
 *     <td><center>{@link TraceTags#LEVEL_TRACE}</center></td>
 *     <td><center>{@link Level#FINER}</center></td>
 *   </tr>
 *   <tr>
 *     <td><center>{@link TraceTags#LEVEL_ERROR}</center></td>
 *     <td><center>{@link Level#SEVERE}</center></td>
 *   </tr>
 * </table>
 *
 * @since 1.5
 */
@Deprecated
public class TraceManager implements TraceDestination {

  /**
   * Returns the {@link Level} corresponding to the integer value passed as
   * argument. This value is assumed to be part of the log levels defined by
   * class {@link TraceTags}.
   *
   * @return
   *   <ul>
   *     <li>{@link Level#FINEST} if value is {@link TraceTags#LEVEL_DEBUG}</li>
   *     <li>{@link Level#FINER} if value is {@link TraceTags#LEVEL_TRACE}</li>
   *     <li>{@link Level#SEVERE} if value is {@link TraceTags#LEVEL_ERROR}</li>
   *     <li><code>null</code> otherwise</li>
   *   </ul>
   */
  private static Level getLevel(int level)
  {
    switch(level)
    {
    case TraceTags.LEVEL_DEBUG:
      return Level.FINEST;
    case TraceTags.LEVEL_TRACE:
      return Level.FINER;
    case TraceTags.LEVEL_ERROR:
      return Level.SEVERE;
    default:
      return null;
    }
  }

  /**
   * Returns the {@link Logger} corresponding to the integer value passed as
   * argument. This value is assumed to be part of the log types defined by
   * class {@link TraceTags}.
   *
   * @return
   *   <ul>
   *     <li><code>Logger.getLogger(<b>"javax.management.mbeanserver"</b>)</code>if value is {@link TraceTags#INFO_MBEANSERVER}</li>
   *     <li><code>Logger.getLogger(<b>"javax.management.mlet"</b>)</code>if value is {@link TraceTags#INFO_MLET}</li>
   *     <li><code>Logger.getLogger(<b>"javax.management.monitor"</b>)</code>if value is {@link TraceTags#INFO_MONITOR}</li>
   *     <li><code>Logger.getLogger(<b>"javax.management.timer"</b>)</code>if value is {@link TraceTags#INFO_TIMER}</li>
   *     <li><code>Logger.getLogger(<b>"javax.management.misc"</b>)</code>if value is {@link TraceTags#INFO_MISC}</li>
   *     <li><code>Logger.getLogger(<b>"javax.management.notification"</b>)</code>if value is {@link TraceTags#INFO_NOTIFICATION}</li>
   *     <li><code>Logger.getLogger(<b>"javax.management.relation"</b>)</code>if value is {@link TraceTags#INFO_RELATION}</li>
   *     <li><code>Logger.getLogger(<b>"javax.management.modelmbean"</b>)</code>if value is {@link TraceTags#INFO_MODELMBEAN}</li>
   *     <li><code>Logger.getLogger(<b>"com.sun.jmx.snmp.daemon"</b>)</code>if value is {@link TraceTags#INFO_ADAPTOR_SNMP}</li>
   *     <li><code>Logger.getLogger(<b>"com.sun.jmx.snmp"</b>)</code>if value is {@link TraceTags#INFO_SNMP}</li>
   *     <li><code>null</code> otherwise</li>
   *   </ul>
   */
  private static Logger getLogger(int type)
  {
    switch(type)
    {
    case TraceTags.INFO_MBEANSERVER:
      return Logger.getLogger("javax.management.mbeanserver");
    case TraceTags.INFO_ADAPTOR_SNMP:
      return Logger.getLogger("com.sun.jmx.snmp.daemon");
    case TraceTags.INFO_SNMP:
      return Logger.getLogger("com.sun.jmx.snmp");
    case TraceTags.INFO_MLET:
      return Logger.getLogger("javax.management.mlet");
    case TraceTags.INFO_MONITOR:
      return Logger.getLogger("javax.management.monitor");
    case TraceTags.INFO_TIMER:
      return Logger.getLogger("javax.management.timer");
    case TraceTags.INFO_MISC:
      return Logger.getLogger("javax.management.misc");
    case TraceTags.INFO_NOTIFICATION:
      return Logger.getLogger("javax.management.notification");
    case TraceTags.INFO_RELATION:
      return Logger.getLogger("javax.management.relation");
    case TraceTags.INFO_MODELMBEAN:
      return Logger.getLogger("javax.management.modelmbean");
    default:
      return null;
    }
  }

  /**
   * @see TraceDestination#isSelected
   */
  public boolean isSelected(int level, int type)
  {
    Logger logger;
    Level  lvl;
    if (((logger = getLogger(type)) != null) &&
        ((lvl = getLevel(level)) != null))
    {
      return logger.isLoggable(lvl);
    }
    return false;
  }

  /**
   * Note that the provided log type and log level have to be part of the
   * enumerated values defined in class {@link TraceTags}. Otherwise, nothing is
   * logged.
   * @see TraceDestination#send(int, int, String, String, String)
   */
  public boolean send(int level,
                      int type,
                      String className,
                      String methodName,
                      String info)
  {
    if (isSelected(level, type))
    {
      getLogger(type).logp(getLevel(level), className, methodName, info);
      return true;
    }
    return false;
  }

  /**
   * Note that the provided log type and log level have to be part of the
   * enumerated values defined in class {@link TraceTags}. Otherwise, nothing is
   * logged.
   * @see TraceDestination#send(int, int, String, String, Throwable)
   */
  public boolean send(int level,
                      int type,
                      String className,
                      String methodName,
                      Throwable exception)
  {
      if (isSelected(level, type)) {
          getLogger(type).log(getLevel(level),
                  className + ": Exception occurred in " + methodName ,
                  exception);
          return true;
  }
      return false;
  }

  /**
   * Not implemented, as the control over log levels and output handler is
   * deferred to the J2SE logging API.
   * @see TraceDestination#reset
   **/
  public void reset() throws IOException
  {

  }

    /**
     * Logs a warning message.
     * This is equivalent to
     * <code>Logger.getLogger(loggerName).warning(msg);</code>
     *
     **/
    void warning(String loggerName, String msg) {
        Logger.getLogger(loggerName).warning(msg);
    }

    /**
     * Logs a fine message.
     * This is equivalent to
     * <code>Logger.getLogger(loggerName).fine(msg);</code>
     *
     **/
    void fine(String loggerName, String msg) {
        Logger.getLogger(loggerName).fine(msg);
    }

}
