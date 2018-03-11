/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.jmx.trace;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Example implementation of the {@link TraceDestination} interface. 
 * <br>
 * This implementation sends log records to a file (specified by the value of the 
 * <code>com.sun.jmx.trace.file</code> system property) or to the system
 * console if no file is specified. 
 * <br>
 * The log level is specified by the value of system property
 * <code>com.sun.jmx.trace.level</code>, which can be : <code>DEBUG</code>,
 * <code>TRACE</code>, <code>ERROR</code>. If no trace level is specified, the
 * default is <code>ERROR</code>.  
 * <br>
 * Note that this implementation does not provide any filtering based on the log
 * types. More precisely, the implementation of method {@link #isSelected} only
 * checks the provided log level.   
 *
 * @since 1.5
 */
public class TraceImplementation implements TraceDestination
{
  // output stream
  //
  private PrintWriter out;
  
  // log level
  //
  private int level;

  static TraceImplementation newDestination(int level) 
  {
      try {
	  final TraceImplementation impl = new TraceImplementation();
	  impl.level = level;
	  return impl;
      } catch (IOException x) {
	  return null;
      }
  }

  /**
   * Registers a new instance of class {@link TraceImplementation} as the
   * trace destination in class {@link Trace}.
   *
   * @exception IOException
   *              may be thrown when creating the new log file based on the
   *              value of system property <code>com.sun.jmx.trace.file</code>
   * @see Trace#setDestination
   */
  public static void init() throws IOException
  {
    Trace.setDestination(new TraceImplementation());
  }

  /**
   * Registers a new instance of class {@link TraceImplementation} as the
   * trace destination in class {@link Trace}.
   *
   * @param level Initial trace level (see {@link TraceTags})
   * @exception IOException
   *              may be thrown when creating the new log file based on the
   *              value of system property <code>com.sun.jmx.trace.file</code>
   * @see Trace#setDestination
   */
  public static void init(int level) throws IOException
  {
      final TraceImplementation impl = new TraceImplementation();
      impl.level = level;
      Trace.setDestination(impl);
  }

  /**
   * Constructor.
   * @exception IOException
   *              may be thrown when creating the new log file based on the
   *              value of system property <code>com.sun.jmx.trace.file</code>
   */
  public TraceImplementation() throws IOException
  {
    String filename;
    if ((filename = System.getProperty("com.sun.jmx.trace.file")) != null)
    {
      // Output sent to the specified log file
      //
      this.out = new PrintWriter(new FileOutputStream(filename), true);
    }
    else
    {
      // Output sent to the system console
      //
      this.out = new PrintWriter(System.err, true);
    }

    String level;
    if ((level = System.getProperty("com.sun.jmx.trace.level")) != null)
    {
      // Read log level from value of system property
      //
      if (level.equals("DEBUG"))
      {
        this.level = TraceTags.LEVEL_DEBUG;
      }
      else if (level.equals("TRACE"))
      {
        this.level = TraceTags.LEVEL_TRACE;
      }
      else 
      {
        this.level = TraceTags.LEVEL_ERROR;
      }
    }
    else
    {
      // Log level defaults to ERROR
      //
      this.level = TraceTags.LEVEL_ERROR;
    }
  }

  /**
   * Only tests whether the provided log level will generate some output if
   * used as an argument to {@link #send(int, int, String, String, Throwable)}
   * or  {@link #send(int, int, String, String, String)}
   *
   * @see TraceDestination#isSelected
   */
  public boolean isSelected(int level, int type)
  {
    return (level <= this.level);
  }

  /**
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
      out.println(((className!=null)?"Class:  " + className:"")+ 
                  ((methodName!=null)?"\nMethod: " + methodName:"") +
                  "\n\tlevel:   " + getLevel(level) +
                  "\n\ttype:    " + getType(type) +
                  "\n\tmessage: " + info);
      //out.flush();
      return true;
    }
    return false;
  }
  
  /**
   * @see TraceDestination#send(int, int, String, String, Throwable)
   */
  public boolean send(int level,
                      int type,
                      String className,
                      String methodName,
                      Throwable exception)
  {
      final boolean result = send(level, type, className, methodName, 
				  exception.toString());
      if (result) 
	  exception.printStackTrace(out);
      
      return result;
  }

  /**
   * Not implemented.
   *
   * @see TraceDestination#reset 
   **/
  public void reset() throws IOException
  {

  }

  /**
   * Return the string representation of a trace type, as defined in 
   * {@link TraceTags} 
   */
  private static String getType(int type) {
       
    switch (type) {
    
    case TraceTags.INFO_MBEANSERVER:
      return "INFO_MBEANSERVER";

    case TraceTags.INFO_ADAPTOR_SNMP:
      return "INFO_ADAPTOR_SNMP";

    case TraceTags.INFO_SNMP:
      return "INFO_SNMP";

    case TraceTags.INFO_MLET:
      return "INFO_MLET";

    case TraceTags.INFO_MONITOR:
      return "INFO_MONITOR";

    case TraceTags.INFO_TIMER:
      return "INFO_TIMER";

    case TraceTags.INFO_MISC:
      return "INFO_MISC";

    case TraceTags.INFO_NOTIFICATION:
      return "INFO_NOTIFICATION";

    case TraceTags.INFO_RELATION:
      return "INFO_RELATION";
   
    case TraceTags.INFO_MODELMBEAN:
      return "INFO_MODELMBEAN";

    default:
      return "UNKNOWN_TRACE_TYPE";
    }
  }

  /**
   * Return the string representation of a trace level, as defined in 
   * {@link TraceTags} 
   */
  private static String getLevel(int level) {
    
    switch (level) {
    
    case TraceTags.LEVEL_ERROR:
      return "LEVEL_ERROR";

    case TraceTags.LEVEL_TRACE:
      return "LEVEL_TRACE";

    case TraceTags.LEVEL_DEBUG:
      return "LEVEL_DEBUG";

    default :
      return "UNKNOWN_TRACE_LEVEL";
    }
  }
}
