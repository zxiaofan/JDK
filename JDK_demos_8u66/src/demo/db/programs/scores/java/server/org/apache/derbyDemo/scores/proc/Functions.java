package demo.db.programs.scores.java.server.org.apache.derbyDemo.scores.proc;
/*

   Derby - Class org.apache.derbyDemo.scores.proc.Functions

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


import java.sql.*;
import java.text.*;
import java.util.*;

import org.apache.commons.math3.stat.descriptive.rank.Median;

import org.apache.derbyDemo.scores.util.*;

/**
 * <p>
 * Functions used by the Scores application.
 * </p>
 *
 */
public class Functions
{
    ////////////////////////////////////////////////////////
    //
    // CONSTANTS
    //
    ////////////////////////////////////////////////////////

    public  static  final   long    MILLISECONDS_IN_YEAR =
        1000L * 60L * 60L * 24L * 365L;
    
    ////////////////////////////////////////////////////////
    //
    // STATE
    //
    ////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////
    //
    // STATIC BEHAVIOR
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Check that a legal answer was given to a question.
     * Throws an exception if it is not.
     * </p>
     */
    public static int vetChoice( int actualChoice, int questionID )
        throws SQLException
    {
        Connection          conn = getDefaultConnection();
        int                 column = 1;

        PreparedStatement   ps = Utils.prepare
            (
             conn,
             "select numberOfChoices, questionName\n" +
             "from Question\n" +
             "where questionID = ?\n"
             );
            
        ps.setInt( 1, questionID );
            
        ResultSet           rs = ps.executeQuery();

        rs.next();

        int                 numberOfChoices = rs.getInt( column++ );
        String              questionName = rs.getString( column++ );

        Utils.close(rs);
        Utils.close(ps);
        
        if ( ( actualChoice >= -1 ) && ( actualChoice < numberOfChoices ) )
        { return 1; }
        else
        {
            throw new SQLException
                (
                 "Illegal answer " + actualChoice +
                 " given to question " + questionName
                 );
        }
    }

    /**
     * <p>
     * Compute a Student's age given their birthday.
     * </p>
     */
    public static int computeAge( java.sql.Date date)
    {
        long    interval = System.currentTimeMillis() - date.getTime();
        return (int)(interval / MILLISECONDS_IN_YEAR);
    }

    /**
     * <p>
     * Compute the relative weight of a Question given its difficulty.
     * </p>
     */
    public static double weighQuestion(int difficulty)
    {
        return Utils.weighQuestion( difficulty );
    }

    /**
     * <p>
     * Compute the score for a question. A penalty is assessed
     * for guessing the wrong answer. If actualChoice is -1,
     * then the Student didn't guess and we don't assess a penalty.
     * </p>
     */
    public static double scoreAnswer
        (
         int difficulty,
         int numberOfChoices,
         int correctChoice,
         int actualChoice
         )
    {
        return Utils.scoreAnswer
            ( difficulty, numberOfChoices, correctChoice, actualChoice );
    }

    /**
     * <p>
     * Calculate the median score achieved on a Test.
     * </p>
     */
    public static double getMedianTestScore(int testID)
        throws SQLException
    {
        Logger              log = Logger.getLogger();
        boolean             loggingEnabled = log.isLoggingEnabled();
        Median              median = new Median();
        ArrayList           arraylist = new ArrayList();
        Connection          conn = getDefaultConnection();

        try {
            log.enableLogging( false );
            
            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "select tk.score\n" +
                 "from TestTaking tk, LastTaking lt\n" +
                 "where tk.takingID = lt.takingID\n" +
                 "and tk.testID = ?\n"
                 );
            
            ps.setInt( 1, testID );
            
            ResultSet           rs = ps.executeQuery();
            
            while( rs.next() )
            {
                arraylist.add(new Double(rs.getDouble(1)));
            }
            
            Utils.close(rs);
            Utils.close(ps);
        }
        finally
        {
            log.enableLogging( loggingEnabled );
        }

        int                 count = arraylist.size();
        double              values[] = new double[ count ];

        for ( int i = 0; i < count; i++)
        { values[ i ] = ((Double)arraylist.get(i)).doubleValue(); }

        return median.evaluate( values );
    }

    /**
     * <p>
     * Format a double as a percentage, suitable for printing.
     * </p>
     */
    public static String formatPercent(double score)
        throws SQLException
    {
        int             rounded = (int) score;
        NumberFormat    nf = NumberFormat.getNumberInstance();

        return nf.format( rounded );
    }
    
    /**
     * <p>
     * Get the default connection, called from inside the database engine.
     * </p>
     */
    static Connection getDefaultConnection()
        throws SQLException
    {
        return DriverManager.getConnection("jdbc:default:connection");
    }

}
