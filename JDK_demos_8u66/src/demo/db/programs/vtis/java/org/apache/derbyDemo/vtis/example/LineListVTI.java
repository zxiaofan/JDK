package demo.db.programs.vtis.java.org.apache.derbyDemo.vtis.example;
/*

Derby - Class org.apache.derbyDemo.vtis.example.LineListVTI

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
import java.text.SimpleDateFormat;

import org.apache.derbyDemo.vtis.core.*;

/**
 * <p>
 * This VTI makes a table out of a text file. The table has one column,
 * containing the contents of a line in the file. Leading and trailing white
 * space are trimmed.
 * </p>
 */
public    class   LineListVTI  extends FlatFileVTI
{
    ///////////////////////////////////////////////////////////////////////////////////
    //
    // CONSTANTS
    //
    ///////////////////////////////////////////////////////////////////////////////////

    private static  final   String[]    COLUMN_NAMES =
    {
        "line"
    };

    private static  final   int LINE = 0;

    ///////////////////////////////////////////////////////////////////////////////////
    //
    // STATE
    //
    ///////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////////////
    //
    // CONSTRUCTORS
    //
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * <p>
     * Build a LineListVTI given the name of a file.
     * </p>
     */
    public  LineListVTI( String fileName )
    {
        super( COLUMN_NAMES, fileName );
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //
    // TABLE FUNCTION METHOD
    //
    ///////////////////////////////////////////////////////////////////////////////////


    /**
     * <p>
     * This is the method which is registered as a table function.
     * </p>
     */
    public  static  ResultSet   lineListVTI( String fileName )
        throws SQLException
    {
        return new LineListVTI( fileName );
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //
    // FlatFileVTI BEHAVIOR TO BE IMPLEMENTED BY SUBCLASSES
    //
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * <p>
     * Parse the next chunk of text, using readLine(), and return the next row.
     * Returns null if the file is exhausted.
     * </p>
     */
    protected  String[]  parseRow( ) throws SQLException
    {
        String[]    newRow = new String[ COLUMN_NAMES.length ];
        String      nextLine = null;

        nextLine = readLine();

        // if at EOF, get out of here
        if ( nextLine == null ) { return null; }

        nextLine = nextLine.trim();

        newRow[ LINE ] = nextLine;

        return newRow;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //
    // ResultSet METHODS
    //
    ///////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////
    //
    // MINIONS
    //
    ///////////////////////////////////////////////////////////////////////////////////


}
