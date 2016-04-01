/*
 *
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.jmx.trace;

// java import
//
import java.util.Properties;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import sun.misc.JavaAWTAccess;
import sun.misc.SharedSecrets;

/**
 * Sends trace to a pluggable destination.
 *
 * @since 1.5
 */
@Deprecated
public final class Trace implements TraceTags {

    private static TraceDestination out;

    // private constructor defined to "hide" the default public constructor
    private Trace() {

    }

    // Method used to test if the implementation of TraceDestination which relies
    // on the java.util.logging API (com.sun.jmx.trace.TraceManager) can be used
    // to initialize the trace destination. This is the case iff. we are running
    // J2SE 1.4 or higher. Otherwise, the trace destination is null, and needs to
    // be later initialized if we want to see traces !
    //
    private static TraceDestination initDestination()
    {
      // Attempt to locate class java.util.logging.LogManager
      //
      try
      {
        Class.forName("java.util.logging.LogManager");

        // Class could be loaded, use a new instance of TraceManager as the trace
        // destination
        //
        return new TraceManager();
      }
      catch (ClassNotFoundException e)
      {
        // Class could not be loaded, means that we are running J2SE 1.3 or below.
        //
        return null;
      }
    }

    // --------------
    // public methods
    // --------------

    /**
     * Set the trace destination.
     **/
    public static synchronized void setDestination(TraceDestination output) {
        JavaAWTAccess javaAWTAccess = SharedSecrets.getJavaAWTAccess();
        if (javaAWTAccess == null) {
            out = output; // Store the output object in the static field
        } else {
                          //  Store the output object in the appContext
           javaAWTAccess.put(TraceDestination.class, output);
        }
    }

    /**
     * Verify whether the specified info level and the info type are
     * selected by a listener.
     *
     * <P>It is strongly recommended to call this method before sending
     * an information to this Trace class.
     *
     * @param level the level of trace information.
     * @param type the type of the trace information.
     */
    public static boolean isSelected(int level, int type) {
        final TraceDestination output = out();
        if (output != null) return output.isSelected(level,type);
        return false;
    }


    /**
     * Send a new information to this Trace class
     *
     * @param level the level of trace information to be sent.
     * @param type the type of trace information to be sent.
     * @param className the name of the class from which the trace
     *        information is from.
     * @param methodName the name of the method from which the trace
     *        information is from.
     * @param info the trace information to be sent.
     * @return false if the level and the type are not selected.
     */
    public static boolean send(int level,
                               int type,
                               String className,
                               String methodName,
                               String info) {

        final TraceDestination output = out();
        if (output == null) return false;
        if (!(output.isSelected(level, type))) return false;
        return output.send(level,type,className,methodName,info);
    }

   /**
     * Send an exception to this Trace class.
     *
     * @param level the level of trace information to be sent.
     * @param type the type of trace information to be sent.
     * @param className the name of the class from which the trace
     *        information is from.
     * @param methodName the name of the method from which the trace
     *        information is from.
     * @param exception exception sent as the trace information.
     */
    public static boolean send(int level,
                               int type,
                               String className,
                               String methodName,
                               Throwable exception) {
        final TraceDestination output = out();
        if (output == null) return false;
        if (!(output.isSelected(level, type))) return false;
        return output.send(level,type,className,methodName,exception);
    }

    /**
     * Logs a warning message.
     * This is equivalent to
     * <code>Logger.getLogger(loggerName).warning(msg);</code>
     * This method is a hack for backward compatibility with J2SE 1.3.
     *
     **/
    public static void warning(String loggerName, String msg) {
        final TraceDestination output = out();
        if (output instanceof TraceManager)
            // Log a warning message
            ((TraceManager)output).warning(loggerName,msg);
        else if (output != null)
            // Best effort
            output.send(LEVEL_TRACE,INFO_MISC,null,null,msg);
    }

    /**
     * Logs a fine message.
     * This is equivalent to
     * <code>Logger.getLogger(loggerName).fine(msg);</code>
     * This method is a hack for backward compatibility with J2SE 1.3.
     *
     **/
    public static void fine(String loggerName, String msg) {
        final TraceDestination output = out();
        if (output instanceof TraceManager)
            // Log a fine message
            ((TraceManager)output).fine(loggerName,msg);
        else if (output != null)
            // Best effort
            output.send(LEVEL_TRACE,INFO_MISC,null,null,msg);
    }

    /**
     * Return the trace destination.
     **/
    private static synchronized TraceDestination out() {
        JavaAWTAccess javaAWTAccess = SharedSecrets.getJavaAWTAccess();
        if (javaAWTAccess == null) {
            if (out == null) {
                // First time: create the output object and store in the static field
                out = initDestination();
            }
            return out; // Get the output object from the static field
        }
        // Get the output object from the appContext
        TraceDestination output = (TraceDestination)javaAWTAccess.get(TraceDestination.class);
        if (output == null) {
            // First time: create the output object and store in the appContext
            output = initDestination();
            javaAWTAccess.put(TraceDestination.class, output);
        }
        return output;
    }

}
