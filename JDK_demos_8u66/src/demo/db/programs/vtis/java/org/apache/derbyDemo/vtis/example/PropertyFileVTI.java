package demo.db.programs.vtis.java.org.apache.derbyDemo.vtis.example;
/*

Derby - Class org.apache.derbyDemo.vtis.example.PropertyFileVTI

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
 * This VTI makes a table out of a property file.
 * </p>
 */
public    class   PropertyFileVTI  extends FlatFileVTI
{
    ///////////////////////////////////////////////////////////////////////////////////
    //
    // CONSTANTS
    //
    ///////////////////////////////////////////////////////////////////////////////////

    private static  final   String[]    COLUMN_NAMES =
    {
        "propKey", "propValue"
    };

    private static  final   int PROPERTY_KEY = 0;
    private static  final   int PROPERTY_VALUE = PROPERTY_KEY + 1;

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
     * Build a PropertyFileVTI given the name of a Derby message file in the
     * source tree.
     * </p>
     */
    public  PropertyFileVTI( String propertyFileName )
    {
        super( COLUMN_NAMES, propertyFileName );
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
    public  static  ResultSet   propertyFileVTI( String propertyFileName )
        throws SQLException
    {
        return new PropertyFileVTI( propertyFileName );
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
        String      oldLine = "";

        while( true )
        {
            boolean     isContinuationLine = ( oldLine.length() != 0 );
            
            nextLine = readLine();

            // if at EOF, get out of here
            if ( nextLine == null )
            {
                if ( !isContinuationLine ) { return null; }
                else { nextLine = oldLine; }
            }

            nextLine = nextLine.trim();

            // skip blank lines and lines which start with the comment character
            if ( nextLine.startsWith( "#" ) ) { continue; }
            else if ( nextLine.length() == 0 )
            {
                if ( !isContinuationLine ) { continue; }
            }

            // handle continuation lines
            nextLine = oldLine + nextLine;

            if ( nextLine.endsWith( "\\" ) )
            {
                oldLine = nextLine.substring( 0, nextLine.length() - 1 );
                continue;
            }

            break;
        }

        int         equalsIdx = nextLine.indexOf( '=' );

        try {
            if ( equalsIdx >= 0 )
            {
                newRow[ PROPERTY_KEY ] = nextLine.substring( 0, equalsIdx );
                newRow[ PROPERTY_VALUE ] = nextLine.substring( equalsIdx + 1, nextLine.length() );
            }
            else
            {
                newRow[ PROPERTY_KEY ] = nextLine;
                newRow[ PROPERTY_VALUE ] = "";
            }
        }
        catch (Throwable t)
        {
            SQLException    se = new SQLException
                (
                 "Unparseable line number " + getLineNumber() + " in file " + getTextFileName() + ": " + nextLine
                 );
            se.initCause( t );

            throw se;
        }

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
