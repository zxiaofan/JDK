package demo.db.programs.scores.java.client.org.apache.derbyDemo.scores.data;
/*

   Derby - Class org.apache.derbyDemo.scores.data.Database

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

import org.apache.derby.tools.JDBCDisplayUtil;

import org.apache.derbyDemo.scores.util.*;

/**
 * <p>
 * Top level object for accessing a SQL database. Implemented against
 * embedded Derby. Could be extended for use against another server.
 * </p>
 *
 */
public  class   Database
{
    ////////////////////////////////////////////////////////
    //
    // CONSTANTS
    //
    ////////////////////////////////////////////////////////

    public  static  final   String  DATABASE_NAME = "ScoresDB";

    private static  final   String  DERBY_EMBEDDED_DRIVER =
        "org.apache.derby.jdbc.EmbeddedDriver";
    private static  final   String  DERBY_PROTOCOL = "jdbc:derby:";
    private static  final   String  CREATE_ME = ";create=true";
    
    ////////////////////////////////////////////////////////
    //
    // STATE
    //
    ////////////////////////////////////////////////////////

    private Data            _data;
    private Connection      _conn;
    
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
    private Database()
    {
    }

    ////////////////////////////////////////////////////////
    //
    // STATIC BEHAVIOR
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Recode this method to return some subclass of Database if you
     * want to use a different data store than Derby. This method
     * creates the database if it does not already exist.
     * </p>
     */
    public  static  Database    getDatabase
        ( String serverJar, String mathJar )
        throws SQLException
    {
        Database    db = new Database();
        Logger      log = Logger.getLogger();

        db._data = new Data();

        //
        // This creates an empty database if it doesn't already exist.
        //
        Connection  conn = db.getConnection();

        //
        // If the database is empty, populate it.
        //
        if ( !db.schemaExists( conn ) )
        {
            db.createSchema( conn, serverJar, mathJar );

            // populate tables with initial slug of data
            db._data.initialize( db );

            log.logBanner( "Show schools, students, and tests..." );

            db.prettyPrintSchool( conn );
            db.prettyPrintStudent( conn );
            db.prettyPrintTest( conn );
            //db.prettyPrintQuestion( conn );
        }

        Utils.commit( conn );

        return db;
    }

    ////////////////////////////////////////////////////////
    //
    // OVERRIDABLE PUBLIC BEHAVIOR. OVERRIDE THESE METHODS
    // IF YOU WANT TO USE A DIFFERENT DATA STORE. THIS IMPLEMENTATION
    // WORKS AGAINST DERBY.
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Get a connection to the database.
     * </p>
     */
    public  Connection  getConnection()
        throws SQLException
    {
        if ( _conn != null ) { return _conn; }

        String      connectionURL =
            DERBY_PROTOCOL + DATABASE_NAME + CREATE_ME;

        _conn = DriverManager.getConnection( connectionURL );

        _conn.setAutoCommit( false );

        return _conn;
    }

    /////////
    //
    // SCHEMA
    //
    /////////

    /**
     * <p>
     * Return true if the schema exists.
     * </p>
     */
    protected   boolean schemaExists( Connection conn )
        throws SQLException
    {
        String              heartbeat =
            "select count(*) from sys.systables where tablename = 'SCHOOL'";

        PreparedStatement   ps = Utils.prepare( conn, heartbeat );
        ResultSet           rs = ps.executeQuery();

        rs.next();
        
        int                 count = rs.getInt( 1 );

        Utils.close( rs );
        Utils.close( ps );

        return ( count > 0 );
    }

    /**
     * <p>
     * Create all schema objects.
     * </p>
     */
    protected   void    createSchema
        ( Connection conn, String serverJar, String mathJar )
        throws SQLException
    {
        Logger      log = Logger.getLogger();

        log.logBanner
            (
             "Loading jar files into database and " +
             "wiring-up the database classpath..." );

        Utils.executeCall
            (
             conn,
             "call sqlj.install_jar\n" +
             "(\n" +
             "    '" + serverJar + "',\n" +
             "    'APP.SCORES_SERVER',\n" +
             "    0\n" +
             ")\n"
             );
        Utils.executeCall
            (
             conn,
             "call sqlj.install_jar\n" +
             "(\n" +
             "    '" + mathJar +"',\n" +
             "    'APP.APACHE_COMMONS_MATH',\n" +
             "    0\n" +
             ")\n"
             );
        Utils.executeCall
            (
             conn,
             "call syscs_util.syscs_set_database_property\n" +
             "(\n" +
             "    'derby.database.classpath',\n" +
             "    'APP.SCORES_SERVER:APP.APACHE_COMMONS_MATH'\n" +
             ")\n"
             );

        log.logBanner
            ( "Creating functions..." );

        Utils.executeDDL
            (
             conn,
             "create function formatPercent\n" +
             "(\n" +
             "    score double\n" +
             ")\n" +
             "returns varchar( 7 )\n" +
             "language java\n" +
             "parameter style java\n" +
             "no sql\n" +
             "external name 'org.apache.derbyDemo.scores.proc.Functions.formatPercent'\n"
             );
        Utils.executeDDL
            (
             conn,
             "create function weighQuestion\n" +
             "(\n" +
             "    difficulty int\n" +
             ")\n" +
             "returns double\n" +
             "language java\n" +
             "parameter style java\n" +
             "no sql\n" +
             "external name 'org.apache.derbyDemo.scores.proc.Functions.weighQuestion'\n"
             );
        Utils.executeDDL
            (
             conn,
             "create function scoreAnswer\n" +
             "(\n" +
             "    difficulty      int,\n" +
             "    numberOfChoices int,\n" +
             "    correctChoice   int,\n" +
             "    actualChoice    int\n" +
             ")\n" +
             "returns double\n" +
             "language java\n" +
             "parameter style java\n" +
             "no sql\n" +
             "external name 'org.apache.derbyDemo.scores.proc.Functions.scoreAnswer'\n"
             );
        Utils.executeDDL
            (
             conn,
             "create function computeAge\n" +
             "(\n" +
             "    birthday date\n" +
             ")\n" +
             "returns int\n" +
             "language java\n" +
             "parameter style java\n" +
             "no sql\n" +
             "external name 'org.apache.derbyDemo.scores.proc.Functions.computeAge'\n"
             );
        Utils.executeDDL
            (
             conn,
             "create function getMedianTestScore\n" +
             "(\n" +
             "    testID int\n" +
             ")\n" +
             "returns double\n" +
             "language java\n" +
             "parameter style java\n" +
             "reads sql data\n" +
             "external name " +
             "'org.apache.derbyDemo.scores.proc.Functions.getMedianTestScore'\n"
             );
        Utils.executeDDL
            (
             conn,
             "create function vetChoice\n" +
             "(\n" +
             "    actualChoice int,\n" +
             "    questionID   int\n" +
             ")\n" +
             "returns int\n" +
             "language java\n" +
             "parameter style java\n" +
             "reads sql data\n" +
             "external name 'org.apache.derbyDemo.scores.proc.Functions.vetChoice'\n"
             );

        log.logBanner
            ( "Creating procedures..." );

        Utils.executeDDL
            (
             conn,
             "create procedure ScoreTestTaking\n" +
             "( in takingID int )\n" +
             "language java\n" +
             "parameter style java\n" +
             "modifies sql data\n" +
             "external name 'org.apache.derbyDemo.scores.proc.Procedures.ScoreTestTaking'\n"
             );

        log.logBanner
            (
             "Creating tables. Note the function " +
             "in the check constraint on QuestionTaking..." );

        Utils.executeDDL
            (
             conn,
             "create table School\n" +
             "(\n" +
             " schoolID   int primary key generated always as identity,\n" +
             " schoolName varchar( 20 ) not null,\n" +
             "\n" +
             " unique( schoolName )\n" +
             ")\n"
             );
        Utils.executeDDL
            (
             conn,
             "create table Student\n" +
             "(\n" +
             " studentID int primary key generated always as identity,\n" +
             " schoolID  int not null references School( schoolID ),\n" +
             " lastName  varchar( 10 ) not null,\n" +
             " firstName varchar( 10 ) not null,\n" +
             " birthday  date not null,\n" +
             "\n" +
             " unique( lastName, firstName )\n" +
             ")\n"
             );
        Utils.executeDDL
            (
             conn,
             "create table Test\n" +
             "(\n" +
             " testID   int primary key generated always as identity,\n" +
             " testName varchar( 20 ) not null,\n" +
             "\n" +
             " unique( testName )\n" +
             ")\n"
             );
        Utils.executeDDL
            (
             conn,
             "create table TestTaking\n" +
             "(\n" +
             " takingID   int primary key generated always as identity,\n" +
             " studentID  int not null references Student( studentID ),\n" +
             " testID     int not null references Test( testID ),\n" +
             " takingDate date,\n" +
             " score      double not null\n" +
             ")\n"
             );
        Utils.executeDDL
            (
             conn,
             "create table Question\n" +
             "(\n" +
             " questionID      int primary key " +
             "   generated always as identity,\n" +
             " testID          int not null references Test( testID ),\n" +
             " questionName    varchar( 10 ) not null unique,\n" +
             " difficulty      int not null,\n" +
             " numberOfChoices int not null,\n" +
             " correctChoice   int not null,\n" +
             "\n" +
             " check ( ( correctChoice > -1 ) " +
             " and ( correctChoice < numberOfChoices ) )\n" +
             ")\n"
             );
        Utils.executeDDL
            (
             conn,
             "create table QuestionTaking\n" +
             "(\n" +
             " questionID   int not null" +
             "  references Question( questionID ),\n" +
             " takingID     int not null" +
             "  references TestTaking( takingID ),\n" +
             " actualChoice int not null,\n" +
             "\n" +
             " unique( questionID, takingID ),\n" +
             " check ( vetChoice( actualChoice, questionID ) > 0 )\n" +
             ")\n"
             );

        log.logBanner( "Creating views..." );

        Utils.executeDDL
            (
             conn,
             "create view LastTaking\n" +
             "(\n" +
             "    takingID,\n" +
             "    studentID,\n" +
             "    testID\n" +
             ")\n" +
             "as select max( takingID ), studentID, testID\n" +
             "from TestTaking\n" +
             "group by studentID, testID\n"
             );

        log.logBanner
            (
             "Creating triggers. Note that the trigger " +
             "invokes a procedure..."
             );

        Utils.executeDDL
            (
             conn,
             "create trigger ScoreTestWhenDone\n" +
             "after update of takingDate\n" +
             "on TestTaking\n" +
             "referencing new as testTakingRow\n" +
             "for each row mode db2sql\n" +
             "call ScoreTestTaking( testTakingRow.takingID )\n"
             );
    }

    
    ////////////////////////////////////////////////////////
    //
    // PRETTY PRINITING
    //
    ////////////////////////////////////////////////////////

    /** <p>Pretty print the School table.</p> */
    public  void    prettyPrintSchool( Connection conn )
        throws SQLException
    {
        prettyPrint( conn, "select * from School order by schoolName\n" );
    }

    /** <p>Pretty print the Student table.</p> */
    public  void    prettyPrintStudent( Connection conn )
        throws SQLException
    {
        prettyPrint
            (
             conn,
             "select st.studentID, sc.schoolName," +
             " st.lastName, st.firstName, st.birthday\n" +
             "from Student st, School sc\n" +
             "where st.schoolID = sc.schoolID\n" +
             "order by st.lastName, st.firstName\n"
             );
    }

    /** <p>Pretty print the Test table.</p> */
    public  void    prettyPrintTest( Connection conn )
        throws SQLException
    {
        prettyPrint( conn, "select * from Test order by testName\n" );
    }

    /** <p>Pretty print the Question table.</p> */
    public  void    prettyPrintQuestion( Connection conn )
        throws SQLException
    {
        prettyPrint
            (
             conn,
             "select * from Question order by testID, questionID\n"
             );
    }

    /** <p>Pretty print the QuestionTaking table.</p> */
    public  void    prettyPrintQuestionTaking( Connection conn )
        throws SQLException
    {
        prettyPrint
            (
             conn,
             "select * from QuestionTaking order by takingID, questionID\n"
             );
    }

    /** <p>Pretty print the TestTaking table.</p> */
    public  void    prettyPrintTestTaking( Connection conn )
        throws SQLException
    {
        prettyPrint( conn, "select * from TestTaking order by takingID\n" );
    }

    /**
     * <p>
     * Pretty print the results of a query, given its text.
     * </p>
     */
    public  static  void    prettyPrint( Connection conn, String text )
        throws SQLException
    {
        PreparedStatement   ps = Utils.prepare( conn, text );
        ResultSet           rs = ps.executeQuery();

        prettyPrint( conn, rs );

        Utils.close( rs );
        Utils.close( ps );
    }
    
    /**
     * <p>
     * Print a ResultSet, using Derby's pretty-printing tool.
     * </p>
     */
    public  static  void    prettyPrint( Connection conn, ResultSet rs )
        throws SQLException
    {
        Logger      log = Logger.getLogger();

        JDBCDisplayUtil.DisplayResults
            ( log.getPrintStream(), rs, conn );

        log.log( "\n" );
    }

    ////////////////////////////////////////////////////////
    //
    // OTHER MINIONS
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Get the Data populating tool.
     * </p>
     */
    public  Data    getData() { return _data; }
    
}
