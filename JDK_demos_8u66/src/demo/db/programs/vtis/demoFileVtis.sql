--
--   Licensed to the Apache Software Foundation (ASF) under one or more
--   contributor license agreements.  See the NOTICE file distributed with
--   this work for additional information regarding copyright ownership.
--   The ASF licenses this file to You under the Apache License, Version 2.0
--   (the "License"); you may not use this file except in compliance with
--   the License.  You may obtain a copy of the License at
--
--      http://www.apache.org/licenses/LICENSE-2.0
--
--   Unless required by applicable law or agreed to in writing, software
--   distributed under the License is distributed on an "AS IS" BASIS,
--   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--   See the License for the specific language governing permissions and
--   limitations under the License.
--

----------------------------------------------------------------------------------------
--
-- This script demonstrates how to declare and use several sample
-- table functions.
--
----------------------------------------------------------------------------------------

connect 'jdbc:derby:memory:vtitest;create=true';

----------------------------------------------------------------------------------------
--
-- Declare the table functions.
--
----------------------------------------------------------------------------------------

--
-- Declare a table function which reads an Apache server log.
--
create function apacheNaturalLogFile( fileURL varchar( 32672 ) ) returns table
(
    IP varchar(100),
    accessDate timestamp,
    request clob,
    statusCode int,
    fileSize int,
    referrer varchar(200),
    userAgent clob
)
language java parameter style derby_jdbc_result_set no sql
external name 'org.apache.derbyDemo.vtis.example.ApacheServerLogVTI.apacheNaturalLogFile';

--
-- Declare a table function which reads a Derby JIRA report
--
create function apacheNaturalJiraReport( fileURL varchar( 32672 ) ) returns table
(
    keyCol int,
    type varchar(20),
    priority varchar(10),
    status varchar(20),
    component varchar(50),
    customfieldvalue varchar(200),
    title varchar(500)
)
language java parameter style derby_jdbc_result_set no sql
external name 'org.apache.derbyDemo.vtis.example.DerbyJiraReportVTI.apacheNaturalJiraReport';

--
-- Declare a table function which reads the output of an 'svn log' command
--
create function svnLogReader( logFileName varchar( 32672 ) )
returns TABLE
  (
     XID varchar( 15 ),
     committer    varchar( 20 ),
     commit_time  timestamp,
     line_count   varchar( 10 ),
     description  varchar( 32672 )
  )
language java
parameter style DERBY_JDBC_RESULT_SET
no sql
external name 'org.apache.derbyDemo.vtis.example.SubversionLogVTI.subversionLogVTI'
;

--
-- Register a table function to read a Derby message file
--
create function propertyFileVTI( fileName varchar( 32672 ) )
returns TABLE
  (
     messageID  varchar( 20 ),
     messageText varchar( 32672 )
  )
language java
parameter style DERBY_JDBC_RESULT_SET
no sql
external name 'org.apache.derbyDemo.vtis.example.PropertyFileVTI.propertyFileVTI'
;

----------------------------------------------------------------------------------------
--
-- Read a log file dumped as a flat file
--
----------------------------------------------------------------------------------------

-- how active were the committers in 2006?
select committer, count(*) as commits
from table( svnLogReader( 'svn_log.txt' ) ) s
where commit_time between timestamp( '2006-01-01 00:00:00' ) and timestamp( '2007-01-01 00:00:00' )
group by committer
;

----------------------------------------------------------------------------------------
--
-- Read a property file of Derby messages
--
----------------------------------------------------------------------------------------

-- find the messages which have not been translated into french
select messageID, substr( m_english.messageText, 1, 100 )
from table( propertyFileVTI( 'messages_en.properties' ) ) m_english
where m_english.messageID not in
(
    select m_french.messageID
    from table( propertyFileVTI( 'messages_fr.properties' ) ) m_french
);


----------------------------------------------------------------------------------------
--
-- XML VTIs
--
----------------------------------------------------------------------------------------

--
-- Read from the XML log file produced by an Apache web server
--

-- this vti treats accessDate as a timestamp and fileSize as an int
select s.*
from table( apacheNaturalLogFile( 'ApacheServerLog.xml' ) ) s
;

-- look for relevant status codes
select s.*
from table( apacheNaturalLogFile( 'ApacheServerLog.xml' ) ) s
where s.statusCode = 206
;

-- look for relevant IP addresses
select s.*
from table( apacheNaturalLogFile( 'ApacheServerLog.xml' ) ) s
where IP like '208%'
;

-- look for log records in a time range
select s.*
from table( apacheNaturalLogFile( 'ApacheServerLog.xml' ) ) s
where accessDate between timestamp( '2002-07-01 08:40:56.0' ) and timestamp( '2002-07-01 08:42:56.0' )
;

--
-- Read from the XML log file produced by a JIRA report
--

-- treat keys as ints and sort Derby JIRAs by key
select s.*
from table( apacheNaturalJiraReport( 'DerbyJiraReport.xml' ) ) s
where s.keyCol between 2800 and 2950
order by keyCol
;

-- eliminate uninteresting Derby JIRAs
select s.*
from table( apacheNaturalJiraReport( 'DerbyJiraReport.xml' ) ) s
where type != 'Sub-task'
order by keyCol
;
