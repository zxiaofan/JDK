package demo.db.programs.scores.java.common.org.apache.derbyDemo.scores.util;
/*

   Derby - Class org.apache.derbyDemo.scores.util.Utils

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
import java.sql.*;

/**
 * <p>
 * Utility methods for the Scores application
 * </p>
 *
 */
public  class   Utils
{
    ////////////////////////////////////////////////////////
    //
    // CONSTANTS
    //
    ////////////////////////////////////////////////////////

    /* private static  final   String  PREPARE_PREAMBLE = "Preparing..."; */
    private static  final   String  PREPARE_PREAMBLE = "";
    
    ////////////////////////////////////////////////////////
    //
    // STATE
    //
    ////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////
    //
    // CONSTRUCTOR
    //
    ////////////////////////////////////////////////////////

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
        return Logger.getLogger();
    }

    ////////////////////////////////////////////////////////
    //
    // METHODS CALLED BY CALLED BY CLIENT CODE AND SERVER-SIDE FUNCTIONS
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Compute the relative weight of a Question given its difficulty.
     * </p>
     */
    public static double weighQuestion(int difficulty)
    {
        return (double) difficulty;
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
        if( actualChoice < 0 ) { return 0.0; }
        
        double weight = weighQuestion(difficulty);
        
        if ( correctChoice == actualChoice ) { return weight; }
        else
        {
            double penaltyRatio = 1.0 / ((double) numberOfChoices);
            return -(weight * penaltyRatio);
        }
    }

    /**
     * <p>
     * Calculate the final score as a percentage, given the highest possible
     * score and the actual score achieved.
     * </p>
     */
    public static double finishScore(double allCorrect, double actual)
    {
        if ( actual < 0.0D ) { return 0.0D; }
        else { return (100D * actual) / allCorrect; }
    }

    ////////////////////////////////////////////////////////
    //
    // SQL MINIONS
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Commit a transaction
     * </p>
     */
    public  static  void    commit( Connection conn )
        throws SQLException
    {
        getLogger().log( "Committing..." );

        conn.commit();
    }
    
    /**
     * <p>
     * Execute a DDL statement for creating a schema object.
     * </p>
     */
    public  static  void    executeDDL( Connection conn, String text )
        throws SQLException
    {
        PreparedStatement   ps = prepare( conn, text );

        ps.execute();

        close( ps );
    }
    
    /**
     * <p>
     * Execute a call statement.
     * </p>
     */
    public  static  void    executeCall( Connection conn, String text )
        throws SQLException
    {
        CallableStatement   cs = prepareCall( conn, text );

        cs.execute();

        close( cs );
    }
    
    /**
     * <p>
     * Prepare a SQL statement.
     * </p>
     */
    public  static  PreparedStatement   prepare
        ( Connection conn, String text )
        throws SQLException
    {
        getLogger().log( PREPARE_PREAMBLE + text );

        return conn.prepareStatement( text );
    }

    /**
     * <p>
     * Prepare a SQL CALL statement.
     * </p>
     */
    public  static  CallableStatement   prepareCall
        ( Connection conn, String text )
        throws SQLException
    {
        getLogger().log( PREPARE_PREAMBLE + text );

        return conn.prepareCall( text );
    }

    /**
     * <p>
     * Close a PreparedStatement, releasing its resources.
     * </p>
     */
    public  static  void    close( PreparedStatement ps )
        throws SQLException
    {
        if ( ps != null ) { ps.close(); }
    }
    
    /**
     * <p>
     * Close a ResultSet, releasing its resources.
     * </p>
     */
    public  static  void    close( ResultSet rs )
        throws SQLException
    {
        if ( rs != null ) { rs.close(); }
    }
    
    /**
     * <p>
     * Close a Connection, releasing its resources.
     * </p>
     */
    public  static  void    close( Connection conn )
        throws SQLException
    {
        if ( conn != null ) { conn.close(); }
    }
    
    /**
     * <p>
     * Get a scalar value from a PreparedStatement.
     * </p>
     */
    public  static  int getScalarValue( PreparedStatement ps )
        throws SQLException
    {
        ResultSet           rs = ps.executeQuery();

        rs.next();

        try {
            return rs.getInt( 1 );
        }
        finally
        {
            close( rs );
            close( ps );
        }
    }
    
    ////////////////////////////////////////////////////////
    //
    // MINIONS
    //
    ////////////////////////////////////////////////////////


}
