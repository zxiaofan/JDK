package demo.db.programs.nserverdemo;
/*

   Derby - Class nserverdemo.NsSample

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
 


import java.util.Properties;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.io.PrintWriter;


/**

 The Network Server sample demo program is a
 simple JDBC application that interacts with the Derby Network Server.
 The program:

 1.	starts the Derby Network Server
 2. creates the database if not already created
 3. checks to see if the schema is already created, and if not,
 4. creates the schema which includes the table SAMPLETBL and corresponding indexes.
 5. connects to the database
 6. loads the schema by inserting data
 7. starts client threads to perform database related operations
 8. has each of the clients perform DML operations (select, insert, delete, update) using JDBC calls,
    i)	 one client opens an embedded connection to perform database operations
         You can open an embedded connection in the same JVM that starts the Derby Network
         Server.
    ii)  one client opens a client connection to the Derby Network Server to perform database operations.
 9. waits for the client threads to finish the tasks
 10.shuts down the Derby Network Server at the end of the demo

 <P>
 Usage: java nserverdemo.NsSample
 <P>
 Please note, a file derby.log is created in the directory you run this program.
 This file contains the logging of connections made with the derby network server
 */

public class NsSample {

	public static final String DERBY_CLIENT_DRIVER = "org.apache.derby.jdbc.ClientDriver";
	public static int NUM_ROWS = 50; /* Number of rows to load initially */
	public static int ITERATIONS = 10;  //Each client does these many iterations
	public static int NUM_CLIENT_THREADS = 2;


	// network server control specific
	private static int NETWORKSERVER_PORT=1621;

	// Derby database connection URL for embedded environment
	public static final String CS_EMBED_DBURL="jdbc:derby:NSSampledb;";

	// To connect to Derby Network Server
	// This URL describes the target database for type 4 connectivity
	// Notice that the properties may be established via the URL syntax
        // URL for the Derby client JDBC driver.
	private static final String DERBY_CLIENT_URL= "jdbc:derby://localhost:"+NETWORKSERVER_PORT+"/NSSampledb;create=true;";

        // Default to using the Derby Client JDBC Driver for database connections
        String url = DERBY_CLIENT_URL;
        String jdbcDriver = DERBY_CLIENT_DRIVER;

	public static void main(String[] args) throws Exception {

                   new nserverdemo.NsSample().startSample(args);
        }
	public void startSample(String[] args) throws Exception {
	  NetworkServerUtil nwServer;

	  Connection conn = null;

	  PrintWriter pw = null;
          
      

	  try  {

		pw = new PrintWriter(System.out,true);	// to print messages
		pw.println("Using JDBC driver: " + jdbcDriver);

		/* Start - In order to start the network server do the following
		   In case you want to start the server as a script or another program
		   comment out the next block of code (i.e. until the comment line 'End - network server started')
		   Also, comment out the 'Shutdown Derby Network Server' line of code at the bottom
		   In case you decide to comment out the starting of the network server, make sure that the
		   client thread is not making an embedded connection but instead making only a client connection.
		   Also note, the server logs messages to the file derby.log in the
		   directory you run this program
		 */

		 	{
				nwServer = new NetworkServerUtil(NETWORKSERVER_PORT,pw);
				nwServer.start();

				boolean knowIfServerUp = false; //do we know if server is ready to accept connections
				int numTimes = 5;

				// Test to see if server is ready for connections, for 15 seconds.
				while(!knowIfServerUp && (numTimes >0)) {
					try {
						// testing for connection to see if the network server is up and running
						// if server is not ready yet, this method will throw an exception
						numTimes--;
						nwServer.testForConnection();
						knowIfServerUp = true;
					}
					catch(Exception e) {
						System.out.println("[NsSample] Unable to obtain a connection to network server, trying again after 3000 ms.");
						Thread.currentThread().sleep(3000);
					}
				}
				if(!knowIfServerUp) {
					pw.println("[NsSample] Exiting, since unable to connect to Derby Network Server.");
					pw.println("[NsSample] Please try to increase the amount of time to keep trying to connect to the Server.");
					System.exit(1);
				}

				pw.println("[NsSample] Derby Network Server started.");
			}
		/*End - network server started*/

		pw.println("[NsSample] Sample Derby Network Server program demo starting. ");
		pw.println("Please wait .....................");

		// See Derby documentation for description of properties that may be set
		//  in the context of the network server.
		Properties properties = new java.util.Properties();

		// The user and password properties are a must, required by JCC
		properties.setProperty("user","derbyuser");
		properties.setProperty("password","pass");

		// Get database connection via DriverManager api
		try	{
			
			conn =  (Connection) DriverManager.getConnection(url, properties);
		} catch(Exception e) {
			pw.println("[NsSample] Connection request unsuccessful, exception thrown was: ");
			pw.println("[NsSample] Please check if all the jar files are in the classpath and the dbUrl is set correctly.");
			e.printStackTrace();
			System.exit(1);  //critical error, so exit
		  }

		NsSampleWork.checkAndCreateSchema(conn,pw); // Check and create the necessary schema if not already created
		NsSampleWork.loadSchema(conn,NUM_ROWS,pw); // Insert rows into the table
		conn.close();

		// Start client threads to perform database related sql operations
		NsSampleClientThread clientThreads[] = new NsSampleClientThread[NUM_CLIENT_THREADS];


		/* Only the JVM that starts the Derby Network Server can obtain an embedded connection
		   Please pay attention to the database URL
		   Also, you need not load the org.apache.derby.jdbc.EmbeddedDriver since it is already loaded when
		   the network server starts up.
		   1. Derby embedded database url - jdbc:derby:databasename
		*/
		clientThreads[0] = new NsSampleClientThread(1,CS_EMBED_DBURL,properties,pw);
		clientThreads[0].start();


		/*
		   2. The below client threads obtain a client connection to Derby Network Server
		   One can also get a client connection from another JVM
		   Please be aware of the database URL for obtaining a client connection
		 */
		for (int i=1; i<NUM_CLIENT_THREADS; i++) {
			clientThreads[i] = new NsSampleClientThread(i+1,url,properties,pw);
			clientThreads[i].start();

		}

		// Wait for the client threads to complete all the work
		for (int i = 0; i < NUM_CLIENT_THREADS; i++)
		   clientThreads[i].join();

		 // Shutdown Derby network server
		 pw.println("[NsSample] Shutting down network server.");
		 nwServer.shutdown();
		 pw.println("[NsSample] End of Network server demo.");

   	  } catch (Exception e) {
		  e.printStackTrace();
		}
   	  finally
   	  {
		if(pw != null) pw.close();
      }
	 }


}
