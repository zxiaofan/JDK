package demo.db.programs.scores.java.common.org.apache.derbyDemo.scores.util;
/*

   Derby - Class org.apache.derbyDemo.scores.util.Logger

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */


import java.io.*;

/**
 * <p>
 * Utility class for logging messages.
 * </p>
 *
 */
public  class   Logger
{
    ////////////////////////////////////////////////////////
    //
    // CONSTANTS
    //
    ////////////////////////////////////////////////////////

    private static  final   String  BANNER_BRACKET =
        "-----------------------------------------------------";
    private static  final   String  BANNER_INDENTATION =
        "-- ";
    
    ////////////////////////////////////////////////////////
    //
    // STATE
    //
    ////////////////////////////////////////////////////////

    private static      Logger      _logger;
    private             PrintStream _printStream;
    private             boolean     _loggingEnabled = true;
    
    ////////////////////////////////////////////////////////
    //
    // CONSTRUCTOR
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Construct out of thin air.
     * </p>
     */
    public  Logger()
    {
        _printStream = System.out;
    }

    ////////////////////////////////////////////////////////
    //
    // PUBLIC BEHAVIOR
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Get the logging tool.
     * </p>
     */
    public  static  Logger  getLogger()
    {
        if ( _logger == null ) { _logger = new Logger(); }
        
        return _logger;
    }

    /**
     * <p>
     * Report whether logging is enabled.
     * </p>
     */
    public  boolean isLoggingEnabled() { return _loggingEnabled; }

    /**
     * <p>
     * Enable or disable printing.
     * </p>
     */
    public  void    enableLogging( boolean enableLogging )
    {
        _loggingEnabled = enableLogging;
    }

    /**
     * <p>
     * Log a text message.
     * </p>
     */
    public  void    log( String text )
    {
        if ( _loggingEnabled) { _printStream.println( text ); }
    }

    /**
     * <p>
     * Log an exception.
     * </p>
     */
    public  void    log( Throwable t )
    {
        log( t.getMessage() );

        t.printStackTrace( _printStream );
    }

    /**
     * <p>
     * Get the PrintStream used by this Logger.
     * </p>
     */
    public  PrintStream getPrintStream() { return _printStream; }

    /**
     * <p>
     * Print a message inside a banner comment.
     * </p>
     */
    public  void    logBanner( String text )
    {
        log( "\n" );
        log( BANNER_BRACKET );
        log( BANNER_INDENTATION );
        log( BANNER_INDENTATION + text );
        log( BANNER_INDENTATION );
        log( BANNER_BRACKET );
        log( "\n" );
    }
    
}
