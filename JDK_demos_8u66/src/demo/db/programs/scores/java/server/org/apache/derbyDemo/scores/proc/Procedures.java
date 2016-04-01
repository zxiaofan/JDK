package demo.db.programs.scores.java.server.org.apache.derbyDemo.scores.proc;
/*

   Derby - Class org.apache.derbyDemo.scores.proc.Procedures

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

import org.apache.derbyDemo.scores.util.*;

/**
 * <p>
 * Procedures used by the Scores application.
 * </p>
 *
 */
public  class   Procedures
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

    private static  int     _scoringCount = 0;
    
    ////////////////////////////////////////////////////////
    //
    // STATIC BEHAVIOR
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Score a test run and update TestTaking with the score.
     * </p>
     */
    public  static  void    ScoreTestTaking( int takingID )
        throws SQLException
    {
        Connection          conn = Functions.getDefaultConnection();
        Logger              log = Logger.getLogger();
        boolean             loggingEnabled = log.isLoggingEnabled();

        try {
            //
            // Only print out the first test taking.
            // They all look alike.
            //
            if ( _scoringCount > 0 ) { log.enableLogging( false ); }

            log.log
                (
                 "Trigger has just fired and started " +
                 "the ScoreTestTaking procedure.\n"
                 ); 

            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "select \n" +
                 " sum( weighQuestion( q.difficulty ) ),\n" +
                 " sum( scoreAnswer( q.difficulty, q.numberOfChoices," +
                 " q.correctChoice, qt.actualChoice ) )\n" +
                 "from Question q, QuestionTaking qt\n" +
                 "where q.questionID = qt.questionID\n" +
                 "and qt.takingID = ?\n"
                 );
            ps.setInt( 1, takingID );

            ResultSet           rs = ps.executeQuery();

            rs.next();
        
            int                 column = 1;
            double              allCorrect = rs.getDouble( column++ );
            double              actual = rs.getDouble( column++ );
            double              score = Utils.finishScore
                ( allCorrect, actual );

            Utils.close( rs );
            Utils.close( ps );

            int                 param = 1;
            ps = Utils.prepare
                (
                 conn,
                 "update TestTaking set score = ? where takingID = ?\n"
             );
            ps.setDouble( param++, score );
            ps.setInt( param++, takingID );
            ps.executeUpdate();

            Utils.close( ps );

        }
        finally
        {
            log.enableLogging( loggingEnabled );
        }

        _scoringCount++;
    }

    ////////////////////////////////////////////////////////
    //
    // MINIONS
    //
    ////////////////////////////////////////////////////////


}
