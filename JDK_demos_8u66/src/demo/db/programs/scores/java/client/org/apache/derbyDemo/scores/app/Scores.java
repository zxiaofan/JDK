package demo.db.programs.scores.java.client.org.apache.derbyDemo.scores.app;
/*

   Derby - Class org.apache.derbyDemo.scores.app.Scores

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


import org.apache.derbyDemo.scores.data.*;
import org.apache.derbyDemo.scores.util.*;

import java.sql.*;

/**
 * <p>
 * Application for showcasing Derby features using
 * an educational testing schema.
 * </p>
 *
 */
public  class   Scores
{
    ////////////////////////////////////////////////////////
    //
    // CONSTANTS
    //
    ////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////
    //
    // STATE
    //
    ////////////////////////////////////////////////////////

    private Logger  _logger;
    private String  _serverJar;
    private String  _mathJar;
    
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
    public  Scores()
    {
        _logger = new Logger();
    }

    ////////////////////////////////////////////////////////
    //
    // ENTRY POINT
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Run the Scores application, showcasing Derby features.
     * </p>
     *
     * <ul>
     * <li>args[ 0 ] = name of server jar</li>
     * <li>args[ 1 ] = name of math library</li>
     * </ul>
     */
    public  static  void    main( String[] args )
    {
        Scores      application = new Scores();
        int         argIdx = 0;

        try {
            application._serverJar = args[ argIdx++ ];
            application._mathJar = args[ argIdx++ ];

            application.execute();
        }
        catch (Throwable t)
        {
            Logger.getLogger().log( t );
        }
    }

    ////////////////////////////////////////////////////////
    //
    // APPLICATION BEHAVIOR
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Run the Scores application, showcasing Derby features.
     * </p>
     */
    private void    execute()
        throws Exception
    {
        Logger      log = Logger.getLogger();

        log.logBanner( "Starting Scores Application..." );

        Database    db = Database.getDatabase( _serverJar, _mathJar );

        Connection  conn = db.getConnection();
        Data        data = db.getData();

        log.logBanner
            (
             "Now the students take their tests." +
             " Watch for the trigger firing..."
             );
        data.takeTests( db );
        Utils.commit( conn );

        log.logBanner( "Show scores for latest takings..." );
        Database.prettyPrint
            (
             db.getConnection(),
             "select s.lastName, s.firstName, t.testName,\n" +
             "tk.takingID, formatPercent( tk.score ) score\n" +
             "from Student s, Test t, TestTaking tk, LastTaking lt\n" +
             "where t.testID = tk.testID\n" +
             "and s.studentID = tk.studentID\n" +
             "and tk.takingID = lt.takingID\n" +
             "order by s.lastName, s.firstName, t.testName, tk.takingID\n"
             );

        log.logBanner
            ( "Median Score Per Test. Note how we fake " +
              "a user-defined aggregate..." );
        db.prettyPrint
            (
             conn,
             "select testName, " +
             "formatPercent( getMedianTestScore( testID ) ) " +
             "as \"median score\"\n" +
             "from Test\n"
             );

        log.logBanner
            (
             "Who Needs Improvement? Note the filtering done " +
             "at the end of the WHERE clause..."
             );
        data.reportWhoNeedsImprovement
            ( db, Data.LincolnGrammar, "GSM_2_0" );

        log.logBanner( "Hoopla! Everything works!" );
    }

    ////////////////////////////////////////////////////////
    //
    // MINIONS
    //
    ////////////////////////////////////////////////////////

}
