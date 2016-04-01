package demo.db.programs.vtis.java.org.apache.derbyDemo.vtis.example;
/*

Derby - Class org.apache.derbyDemo.vtis.example.DerbyJiraReportVTI

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


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;

import org.apache.derby.vti.XmlVTI;
import org.apache.derbyDemo.vtis.core.*;

/**
 * <p>
 * This is an XML-reading VTI which has been tweaked to handle
 * the formatting of JIRA ids found in Derby JIRA reports.
 * </p>
 *
  */
public  class   DerbyJiraReportVTI  extends XmlVTI
{
    ///////////////////////////////////////////////////////////////////////////////////
    //
    // CONSTANTS
    //
    ///////////////////////////////////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////
    //
    // STATE
    //
    ///////////////////////////////////////////////////////////////////////////////////

    private SimpleDateFormat    _dateFormatter;
    
    ///////////////////////////////////////////////////////////////////////////////////
    //
    // CONSTRUCTORS
    //
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * <p>
     * Construct from the same arguments as our superclass.
     * </p>
     */
    public  DerbyJiraReportVTI( InputStream is )
    {
        super
            (
             is,
             "item",
             0,
             "key", "type", "priority", "status", "component", "customfieldvalue", "title"
             );
    }
    
    ///////////////////////////////////////////////////////////////////////////////////
    //
    // FUNCTION ENTRY POINT (BOUND BY THE CREATE FUNCTION STATEMENT)
    //
    ///////////////////////////////////////////////////////////////////////////////////

    /** Create from an file name identifying the server log file */
    public  static  DerbyJiraReportVTI  apacheNaturalJiraReport( String xmlResourceName )
        throws Exception
    {
        return new DerbyJiraReportVTI( new FileInputStream( xmlResourceName ) );
    }
    
    ///////////////////////////////////////////////////////////////////////////////////
    //
    // ResultSet BEHAVIOR
    //
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     * <p>
     * JIRA prepends "DERBY-" to the issue key. Strip off this prefix so that we
     * can sort the key as an integer value.
     * </p>
     */
    public String getString( int columnIndex ) throws SQLException
    {
        String  rawValue = super.getString( columnIndex );

        if ( !"key".equals( getColumnName( columnIndex ) ) )
        { return rawValue; }
        else
        { return rawValue.substring( 6 ); }
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //
    // MINIONS
    //
    ///////////////////////////////////////////////////////////////////////////////////

}
