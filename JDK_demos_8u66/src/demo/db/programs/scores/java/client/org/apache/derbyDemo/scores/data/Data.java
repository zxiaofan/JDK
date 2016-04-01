package demo.db.programs.scores.java.client.org.apache.derbyDemo.scores.data;
/*

   Derby - Class org.apache.derbyDemo.scores.data.Data

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
 * Data used by Scores application
 * </p>
 *
 */
public  class   Data
{
    ////////////////////////////////////////////////////////
    //
    // CONSTANTS
    //
    ////////////////////////////////////////////////////////

    private static  final   int     QUESTIONS_PER_TEMPLATE = 10;
    private static  final   double  IMPROVEMENT_PER_TAKING = 2.0;
    private static  final   double  GRAMMAR_SCHOOL_PENALTY = 20.0;
    private static  final   double  PER_STUDENT_FLUCTUATION = 3.0;
    private static  final   double  FLUCTATION_MULTIPLIER = 2.0;
    
    public  static  final   School  LincolnGrammar =
        new School( "Lincoln Grammar", true );
    public  static  final   School  WashingtonHS =
        new School( "Washington HS", false );

    public  static  final   Student AliceToklas = new Student
        ( "Alice", "Toklas", "1998-03-21", LincolnGrammar );
    public  static  final   Student GertrudeStein = new Student
        ( "Gertrude", "Stein", "1999-07-15", LincolnGrammar );
    public  static  final   Student HenryJames = new Student
        ( "Henry", "James", "2000-09-03", LincolnGrammar );
    public  static  final   Student GoreVidal = new Student
        ( "Gore", "Vidal", "2008-12-25", LincolnGrammar );

    public  static  final   Student TrumanCapote = new Student
        ( "Truman", "Capote", "1992-08-05", WashingtonHS );
    public  static  final   Student WaltWhitman = new Student
        ( "Walt", "Whitman", "1991-12-28", WashingtonHS );
    public  static  final   Student DorothyParker = new Student
        ( "Dorothy", "Parker", "1990-01-09", WashingtonHS );
    public  static  final   Student AndrewSullivan = new Student
        ( "Andrew", "Sullivan", "1989-02-20", WashingtonHS );

    public  static  final   Test GradeSchoolMath =
        new Test( "Grade School Math", true, 90.0 );
    public  static  final   Test GradeSchoolEnglish =
        new Test( "Grade School English", true, 85.0 );
    public  static  final   Test HighSchoolMath =
        new Test( "High School Math", false, 80.0 );
    public  static  final   Test HighSchoolEnglish =
        new Test( "High School English", false, 75.0 );

    public  static  final   Question    GSM_1 =
        new Question( "GSM_1", 1, 5, 2, GradeSchoolMath );
    public  static  final   Question    GSM_2 =
        new Question( "GSM_2", 2, 3, 1, GradeSchoolMath );
    public  static  final   Question    GSM_3 =
        new Question( "GSM_3", 3, 4, 3, GradeSchoolMath );
    
    public  static  final   Question    GSE_1 =
        new Question( "GSE_1", 3, 5, 2, GradeSchoolEnglish );
    public  static  final   Question    GSE_2 =
        new Question( "GSE_2", 2, 3, 1, GradeSchoolEnglish );
    public  static  final   Question    GSE_3 =
        new Question( "GSE_3", 1, 4, 3, GradeSchoolEnglish );

    public  static  final   Question    HSM_1 =
        new Question( "HSM_1", 1, 5, 2, HighSchoolMath );
    public  static  final   Question    HSM_2 =
        new Question( "HSM_2", 2, 3, 1, HighSchoolMath );
    public  static  final   Question    HSM_3 =
        new Question( "HSM_3", 3, 4, 3, HighSchoolMath );
    
    public  static  final   Question    HSE_1 =
        new Question( "HSE_1", 3, 5, 2, HighSchoolEnglish );
    public  static  final   Question    HSE_2 =
        new Question( "HSE_2", 2, 3, 1, HighSchoolEnglish );
    public  static  final   Question    HSE_3 =
        new Question( "HSE_3", 1, 4, 3, HighSchoolEnglish );

    public  static  final   Question[]      QUESTIONS =
    {
        GSM_1,
        GSM_2,
        GSM_3,
        
        GSE_1,
        GSE_2,
        GSE_3,
        
        HSM_1,
        HSM_2,
        HSM_3,
        
        HSE_1,
        HSE_2,
        HSE_3,
    };
    
    public  static  final   School[] SCHOOLS =
    {
        LincolnGrammar,
        WashingtonHS,
    };

    public  static  final   Student[]   STUDENTS =
    {
        AliceToklas,
        GertrudeStein,
        TrumanCapote,
        WaltWhitman,
        HenryJames,
        GoreVidal,
        DorothyParker,
        AndrewSullivan,
    };

    public  static  final   Test[]  TESTS =
    {
        GradeSchoolMath,
        GradeSchoolEnglish,
        HighSchoolMath,
        HighSchoolEnglish,
    };
    
    ////////////////////////////////////////////////////////
    //
    // STATE
    //
    ////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////
    //
    // INNER CLASSES
    //
    ////////////////////////////////////////////////////////

    public  abstract    static  class   KeyedObject
    {
        private Integer _key;
        
        public  void                create( Database database )
            throws SQLException
        {
            Logger  log = Logger.getLogger();
            boolean loggingEnabled = log.isLoggingEnabled();
            
            // don't print out the chatter from creating these rows.
            try {
                log.enableLogging( false );

                createMinion( database );
            }
            finally
            {
                log.enableLogging( loggingEnabled );
            }
        }

        protected   abstract    void    createMinion( Database database )
            throws SQLException;

        protected   abstract    PreparedStatement   getKeyFinder
            ( Database database )
            throws SQLException;

        public  int getPrimaryKey( Database database )
            throws SQLException
        {
            if ( _key == null )
            {
                PreparedStatement   ps = getKeyFinder( database );

                setPrimaryKey( Utils.getScalarValue( ps ) );
            }

            return _key.intValue();
        }

        private void    setPrimaryKey( int key )
        {
            _key = new Integer( key );          
        }

        public  SQLException    notImplemented()
        { return new SQLException( "Not implemented." ); }
    }


    public  static  class   School  extends KeyedObject
    {
        private String      _schoolName;
        private boolean     _isGrammarSchool;

        public  School( String schoolName, boolean isGrammarSchool )
        {
            _schoolName = schoolName;
            _isGrammarSchool = isGrammarSchool;
        }

        public  String      getSchoolName() { return _schoolName; }
        public  boolean     isGrammarSchool() { return _isGrammarSchool; }

        protected   void                createMinion( Database database )
            throws SQLException
        {
            Connection          conn = database.getConnection();

            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "insert into School( schoolName ) values ( ? )"
                 );

            ps.setString( 1, _schoolName );

            ps.execute();
            Utils.close( ps );
        }

        protected   PreparedStatement   getKeyFinder( Database database )
            throws SQLException
        {
            Connection          conn = database.getConnection();
            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "select schoolID from School where schoolName = ?"
                 );

            ps.setString( 1, _schoolName );

            return ps;
        }

    }
    
    public  static  class   Student extends KeyedObject
    {
        private String  _firstName;
        private String  _lastName;
        private String  _birthday;
        private School  _school;

        public  Student
            (
             String firstName,
             String lastName,
             String birthday,
             School school
             )
        {
            _firstName = firstName;
            _lastName = lastName;
            _birthday = birthday;
            _school = school;
        }

        public  String  getFirstName() { return _firstName; }
        public  String  getLastName() { return _lastName; }
        public  String  getBirthday() { return _birthday; }
        public  School  getSchool() { return _school; }

        protected   void                createMinion( Database database )
            throws SQLException
        {
            int                 param = 1;
            Connection          conn = database.getConnection();
            java.sql.Date       sqlDate =
                java.sql.Date.valueOf( _birthday );

            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "insert into Student\n" +
                 "( schoolID, lastName, firstName, birthday )\n" +
                 "values( ?, ?, ?, ? )"
                 );

            ps.setInt( param++, _school.getPrimaryKey( database ) );
            ps.setString( param++, _lastName );
            ps.setString( param++, _firstName );
            ps.setDate( param++, sqlDate );

            ps.execute();
            Utils.close( ps );
        }

        protected   PreparedStatement   getKeyFinder( Database database )
            throws SQLException
        {
            Connection          conn = database.getConnection();
            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "select studentID from Student\n" +
                 "where lastName = ? and firstName = ?"
                 );

            ps.setString( 1, _lastName );
            ps.setString( 2, _firstName );

            return ps;
        }

    }
    
    public  static  class   Test    extends KeyedObject
    {
        private String      _testName;
        private boolean     _grammarSchoolTest;
        private double      _highSchoolScore;

        public  Test
            (
             String     testName,
             boolean    grammarSchoolTest,
             double     highSchoolScore
             )
        {
            _testName = testName;
            _grammarSchoolTest = grammarSchoolTest;
            _highSchoolScore = highSchoolScore;
        }

        public  String      getTestName() { return _testName; }
        
        public  boolean     isGrammarSchoolTest()
        { return _grammarSchoolTest; }
        
        public  double      getHighSchoolScore()
        { return _highSchoolScore; }

        protected   void                createMinion( Database database )
            throws SQLException
        {
            Connection          conn = database.getConnection();

            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "insert into Test( testName ) values ( ? )"
                 );

            ps.setString( 1, _testName );

            ps.execute();
            Utils.close( ps );
        }

        protected   PreparedStatement   getKeyFinder( Database database )
            throws SQLException
        {
            Connection          conn = database.getConnection();
            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "select testID from Test where testName = ?"
                 );

            ps.setString( 1, _testName );

            return ps;
        }
    }

    public  static  class   TestTaking  extends KeyedObject
    {
        private Student _student;
        private Test    _test;

        public  TestTaking( Student student, Test test )
        {
            _student = student;
            _test = test;
        }

        public  Student     getStudent() { return _student; }
        public  Test        getTest() { return _test; }

        protected   void                createMinion( Database database )
            throws SQLException
        {
            Connection          conn = database.getConnection();
            int                 param = 1;

            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "insert into TestTaking\n" +
                 "( studentID, testID, score ) values ( ?, ?, ? )"
                 );

            ps.setInt( param++, _student.getPrimaryKey( database ) );
            ps.setInt( param++, _test.getPrimaryKey( database ) );
            ps.setInt( param++, -1 );

            ps.execute();
            Utils.close( ps );
        }

        protected   PreparedStatement   getKeyFinder( Database database )
            throws SQLException
        {
            Connection          conn = database.getConnection();
            int                 param = 1;
            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "select max( takingID ) from TestTaking\n" +
                 "where studentID = ? and testID = ?"
                 );

            ps.setInt( param++, _student.getPrimaryKey( database ) );
            ps.setInt( param++, _test.getPrimaryKey( database ) );

            return ps;
        }
    }

    public  static  class   Question    extends KeyedObject
    {
        private String  _questionName;
        private int     _difficulty;
        private int     _numberOfChoices;
        private int     _correctChoice;
        private Test    _test;

        public  Question
            (
             String questionName,
             int    difficulty,
             int    numberOfChoices,
             int    correctChoice,
             Test   test
             )
        {
            _questionName = questionName;
            _difficulty = difficulty;
            _numberOfChoices = numberOfChoices;
            _correctChoice = correctChoice;
            _test = test;
        }

        public  String      getQuestionName() { return _questionName; }
        
        public  int         getDifficulty() { return _difficulty; }
        
        public  int         getNumberOfChoices()
        { return _numberOfChoices; }
        
        public  int         getCorrectChoice() { return _correctChoice; }
        public  Test        getTest() { return _test; }

        protected   void                createMinion( Database database )
            throws SQLException
        {
            Connection          conn = database.getConnection();
            int                 param = 1;

            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "insert into Question\n" +
                 "( testID, questionName, difficulty, " +
                 "numberOfChoices, correctChoice )\n" +
                 "values ( ?, ?, ?, ?, ? )"
                 );

            ps.setInt( param++, _test.getPrimaryKey( database ) );
            ps.setString( param++, _questionName );
            ps.setInt( param++, _difficulty );
            ps.setInt( param++, _numberOfChoices );
            ps.setInt( param++, _correctChoice );

            ps.execute();
            Utils.close( ps );
        }

        protected   PreparedStatement   getKeyFinder( Database database )
            throws SQLException
        {
            Connection          conn = database.getConnection();
            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "select questionID from Question where questionName = ?"
                 );

            ps.setString( 1, _questionName );

            return ps;
        }

    }

    public  static  class   QuestionTaking  extends KeyedObject
    {
        private TestTaking  _testTaking;
        private Question    _question;
        private int         _actualChoice;

        public  QuestionTaking
            (
             TestTaking testTaking,
             Question   question,
             int        actualChoice
             )
        {
            _testTaking = testTaking;
            _question = question;
            _actualChoice = actualChoice;
        }

        public  TestTaking  getTestTaking() { return _testTaking; }
        public  Question    getQuestion() { return _question; }
        public  int         getActualChoice() { return _actualChoice; }

        protected   void                createMinion( Database database )
            throws SQLException
        {
            Connection          conn = database.getConnection();
            int                 param = 1;

            PreparedStatement   ps = Utils.prepare
                (
                 conn,
                 "insert into QuestionTaking\n" +
                 "( questionID, takingID, actualChoice ) values ( ?, ?, ? )"
                 );

            ps.setInt( param++, _question.getPrimaryKey( database ) );
            ps.setInt( param++, _testTaking.getPrimaryKey( database ) );
            ps.setInt( param++, _actualChoice );

            ps.execute();
            Utils.close( ps );
        }

        protected   PreparedStatement   getKeyFinder( Database database )
            throws SQLException
        {
            // no primary key for this table!
            throw notImplemented();
        }
    }

    ////////////////////////////////////////////////////////
    //
    // CONSTRUCTOR
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Create an object to populate the tables for the Scores application.
     * </p>
     */
    public  Data()
    {
    }
    
    ////////////////////////////////////////////////////////
    //
    // PUBLIC BEHAVIOR
    //
    ////////////////////////////////////////////////////////

    /**
     * <p>
     * Initialize the Scores application with data.
     * </p>
     */
    public  void    initialize( Database database )
        throws SQLException
    {
        initialize( database, SCHOOLS );
        initialize( database, STUDENTS );
        initialize( database, TESTS );
        initializeQuestions( database );
    }

    /**
     * <p>
     * Make the students take their tests.
     * </p>
     */
    public  void    takeTests( Database database )
        throws SQLException
    {
        int                 testCount = TESTS.length;
        int                 takings = 0;

        for ( int i = 0; i < testCount; i++ )
        {
            takings = takeTest( database, TESTS[ i ], takings );
        }
    }

    /**
     * <p>
     * Make all eligible students take the test.
     * Grammar school tests are taken
     * by all students. High school tests are only taken by high school
     * students. Returns the number of test takings so far (this is used
     * to throttle diagnostic noise.
     * </p>
     */
    public  int takeTest( Database database, Test test, int takings )
        throws SQLException
    {
        Logger      log = Logger.getLogger();
        boolean     loggingEnabled = log.isLoggingEnabled();
        int         studentCount = STUDENTS.length;
        double      highSchoolScore = test.getHighSchoolScore();
        double      grammarSchoolScore =
            highSchoolScore - GRAMMAR_SCHOOL_PENALTY;
        double      fluctuation;
        double      targetScore;

        for ( int i = 0; i < studentCount; i++ )
        {
            Student     student = STUDENTS[ i ];
            boolean     grammarSchoolStudent =
                student.getSchool().isGrammarSchool();

            if ( grammarSchoolStudent && (!test.isGrammarSchoolTest()) )
            { continue; }

            if ( grammarSchoolStudent )
            { targetScore = grammarSchoolScore; }
            else
            { targetScore = highSchoolScore; }

            fluctuation = (((double) i) * FLUCTATION_MULTIPLIER) * (-1.0);
            targetScore += fluctuation;

            try {
                //
                // Only print out the first test taking.
                // They all look alike.
                //
                if ( takings > 0 ) { log.enableLogging( false ); }

                takeTest( database, student, test, targetScore );
                takings++;
            }
            finally
            {
                log.enableLogging( loggingEnabled );
            }
        }

        return takings;
    }

    /**
     * <p>
     * Take a test.
     * </p>
     */
    public  void    takeTest
        (
         Database   database,
         Student    student,
         Test       test,
         double     initialTargetScore
         )
        throws SQLException
    {
        Logger      log = Logger.getLogger();
        boolean     loggingEnabled = log.isLoggingEnabled();
        TestTaking  testTaking;
        
        // don't print out the chatter from creating these rows.
        try {
            log.enableLogging( false );
            
            testTaking = takeTestingMinion
                ( database, student, test, initialTargetScore );
        }
        finally
        {
            log.enableLogging( loggingEnabled );
        }

        // I want to see this, though
        finishTest( database, testTaking );
    }

    /**
     * <p>
     * The guts of test taking, removed here
     * to a separate method so that we can turn off logging.
     * </p>
     */
    private TestTaking  takeTestingMinion
        (
         Database   database,
         Student    student,
         Test       test,
         double     initialTargetScore
         )
        throws SQLException
    {
        TestTaking          testTaking = new TestTaking( student, test );
        Connection          conn = database.getConnection();
        double              targetScore = makeTargetScore
            ( database, student, test, initialTargetScore );

        //
        // Initiate the test.
        //
        testTaking.create( database );

        //
        // Now get the questions which have to be answered.
        //

        PreparedStatement   ps = Utils.prepare
            (
             conn,
             "select questionName, difficulty, numberOfChoices, " +
             "correctChoice from Question\n" +
             "where testID = ?"
             );
        ps.setInt( 1, test.getPrimaryKey( database ) );

        ResultSet           rs = ps.executeQuery();
        
        double              weightSoFar = 0.0;
        double              answersSoFar = 0.0;
        double              scoreSoFar = 0.0;

        while( rs.next() )
        {
            int             column = 1;
            Question        question = new Question
                (
                 rs.getString( column++ ),
                 rs.getInt( column++ ),
                 rs.getInt( column++ ),
                 rs.getInt( column++ ),
                 test
                 );
            int             correctChoice = question.getCorrectChoice();
            int             difficulty = question.getDifficulty();
            int             actualChoice;

            //
            // Answer the question correctly if we haven't achieved our
            // target score.
            //
            if ( scoreSoFar <= targetScore )
            { actualChoice = correctChoice; }
            else
            { actualChoice = correctChoice - 1; }

            weightSoFar += Utils.weighQuestion( difficulty );
            answersSoFar += Utils.scoreAnswer
                (
                 difficulty,
                 question.getNumberOfChoices(),
                 correctChoice,
                 actualChoice
                 );
            scoreSoFar = Utils.finishScore( weightSoFar, answersSoFar );

            QuestionTaking  questionTaking =
                new QuestionTaking( testTaking, question, actualChoice );

            questionTaking.create( database );
        }

        return testTaking;
    }

    /**
     * <p>
     * The student's grade should improve with each taking.
     * </p>
     */
    private double  makeTargetScore
        (
         Database   database,
         Student    student,
         Test       test,
         double     initialTargetScore
         )
        throws SQLException
    {
        int                 param = 1;
        PreparedStatement   ps = Utils.prepare
            (
             database.getConnection(),
             "select count(*) from TestTaking\n" +
             "where studentID = ? and testID = ?"
             );

        ps.setInt( param++, student.getPrimaryKey( database ) );
        ps.setInt( param++, test.getPrimaryKey( database ) );
        
        int     takingCount = Utils.getScalarValue( ps );

        return
            (((double) takingCount) * IMPROVEMENT_PER_TAKING) +
            initialTargetScore;
    }

    /**
     * <p>
     * Finish taking a Test. This involves updating the datestamp and
     * triggering Test scoring.
     * </p>
     */
    private void    finishTest( Database database, TestTaking testTaking )
        throws SQLException
    {
        Connection          conn = database.getConnection();
        int                 param = 1;
        java.sql.Date       date =
            new java.sql.Date( System.currentTimeMillis() );
        PreparedStatement   ps = Utils.prepare
            (
             conn,
             "update TestTaking set takingDate = ? where takingID = ?\n"
             );

        ps.setDate( param++, date );
        ps.setInt( param++, testTaking.getPrimaryKey( database ) );

        ps.execute();

        Utils.close( ps );
    }

    /**
     * <p>
     * Report which students in the given school incorrectly answered the
     * given question.
     * </p>
     */
    public void    reportWhoNeedsImprovement
        ( Database database, School school, String questionName )
        throws SQLException
    {
        Connection          conn = database.getConnection();
        int                 param = 1;
        PreparedStatement   ps = Utils.prepare
            (
             conn,
             "select st.lastName, st.firstName\n" +
             "from School sc, Student st,\n" +
             "     LastTaking lt, QuestionTaking qt,\n" +
             "     Question q\n" +
             "where\n" +
             "q.questionName = ?\n" +
             "and sc.schoolID = ?\n" +
             "\n" +
             "and q.questionID = qt.questionID\n" +
             "and sc.schoolID = st.schoolID\n" +
             "\n" +
             "and lt.testID = q.testID\n" +
             "and lt.studentID = st.studentID\n" +
             "and lt.takingID = qt.takingID\n" +
             "\n" +
             "and scoreAnswer"+
             "( q.difficulty, q.numberOfChoices, " +
             "q.correctChoice, qt.actualChoice )\n" +
             "  < weighQuestion( q.difficulty )\n" +
             "\n" +
             "order by st.lastName, st.firstName\n"
             );

        ps.setString( param++, questionName );
        ps.setInt( param++, school.getPrimaryKey( database ) );

        ResultSet   rs = ps.executeQuery();

        Database.prettyPrint( conn, rs );

        Utils.close( rs );
        Utils.close( ps );
    }

    ////////////////////////////////////////////////////////
    //
    // MINIONS
    //
    ////////////////////////////////////////////////////////
    
    /**
     * <p>
     * Create a bunch of questions from the template questions.
     * </p>
     */
    private void    initializeQuestions( Database database )
        throws SQLException
    {
        int     count = QUESTIONS.length;

        for ( int i = 0; i < count; i++ )
        {
            Question    template = QUESTIONS[ i ];

            for ( int j = 0; j < QUESTIONS_PER_TEMPLATE; j++ )
            {
                Question    clone = new Question
                    (
                     template.getQuestionName() + '_' + j,
                     template.getDifficulty(),
                     template.getNumberOfChoices(),
                     template.getCorrectChoice(),
                     template.getTest()
                     );

                clone.create( database );
            }
        }
    }

    /**
     * <p>
     * Populate a table with its objects.
     * </p>
     */
    private void    initialize( Database database, KeyedObject[] objects )
        throws SQLException
    {
        int     count = objects.length;

        for ( int i = 0; i < count; i++ )
        { objects[ i ].create( database ); }
    }

}
