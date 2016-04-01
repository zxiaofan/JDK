package demo.db.programs.nserverdemo;
/*

   Derby - Class SimpleNetworkServerSample

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

import org.apache.derby.drda.NetworkServerControl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * In order for a database to be consistent, only one JVM is allowed
 * to access it at a time. The embedded driver is loaded when the Network Server
 * is started. Hence, the JVM that starts the Network Server can get an
 * embedded connection to the same database that Network Server is accessing
 * to serve the clients from other JVMs. This solution allows you to take
 * advantage of the performance benefits of the embedded driver as well as allow
 * for client connections from other JVMs to connect to the same database.
 *
 *
 * In particular, this sample program
 * 1) 	starts the Derby Network Server using a property and
 *		also loads the embedded driver
 * 2)	checks if the Derby Network Server is up and running
 * 3)	creates the database 'NSSimpleDB' if not already created
 * 4)	obtains an embedded database connection
 * 5)	tests the database connection by executing a sample query
 * 6)	allows for client connections to connect to the server until
 *      the user decides to stop the server and exit the program
 * 7)	closes the connections
 * 8)	shuts down the Derby Network Server before exiting the program.
 *
 * Note: On running this program, there will be a NSSimpleDB database directory
 * created if not present already, and there will be a derby.log file which
 * contains messages from Derby.
 *
 *  <P>
 *  Usage: java SimpleNetworkServerSample
 *
 */
public class SimpleNetworkServerSample
{

	/*
	 * The database is located in the same directory where this program is being
	 * run. Alternatively, you can specify the absolute path of the database location
	 */
	private static String DBNAME="NSSimpleDB";


	public static void main (String[] args)
		throws Exception
	{
		Connection embeddedConn = null;

		try
		{
			startNetworkServer();

			/*
			  Can now spawn threads to do many things with
			  embedded connections but allow others to connect via
			  Network Server. But for sample purposes, an embedded connection
			  will be obtained and a sample query executed before waiting for
			  the user to give input to shut down the server.
			*/

		}
		catch (Exception e)
		{
			System.out.println("Failed to start NetworkServer: " + e);
			System.exit(1);
		}

		try
		{
			// get an embedded connection
			// Since the Network Server was started in this JVM, this JVM can get an embedded
			// connection to the same database that the Network Server
			// is accessing to serve clients from other JVMs.
			// The embedded connection will be faster than going across the
			// network
			embeddedConn = getEmbeddedConnection(DBNAME,"create=true;");
			System.out.println("Got an embedded connection.");


			System.out.println("Testing embedded connection by executing a sample query ");
			// test connections by doing some work
			test(embeddedConn);

			// print how to connect to the network server using ij
			String howToConnect = ijUsage();
			System.out.println(howToConnect);

			waitForExit();

		}
		catch (SQLException sqle)
		{
			System.out.println("Failure making connection: " + sqle);
			sqle.printStackTrace();
		}
		finally
		{

			if(embeddedConn != null)
				embeddedConn.close();
			try
			{
				// shut down Derby Network Server
				DriverManager.getConnection("jdbc:derby:;shutdown=true");
			}
			catch(SQLException se)
			{
				//ignore se
			}

		}

	}

	/**
	 *  Setting the derby.drda.startNetworkServer property to true,
	 *  either in the System properties as we do here or in
	 *  the derby.properties file, will cause the Network Server to
	 *  start as soon as Derby is loaded.
	 *
	 *  To load Derby, we just need to load the embedded
	 *  driver with:
	 *  Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
	 *
	 *  Then we will test for a while and make sure it is up, before
	 *  we give up.
  	 *
	 *  Alternatively, the Network Server might be started from the command
	 *  line or from some other program. Note: only the JVM that starts
	 *  Network Server can make an embedded connection.
	 */

	public static void startNetworkServer() throws Exception
	{
		// Start the Network Server using the property
		// and then wait for the server to start by testing a connection
		startWithProperty();
		waitForStart();
	}

	/**
	 * Start Derby Network Server using the property
	 * derby.drda.startNetworkServer. This property can be set as a system property or
	 * or in the derby.properties file.
	 * Setting this property to true starts the Network Server when
	 * Derby boots up.
	 * The port at which the Derby Network Server listens can be changed
	 * by setting the derby.drda.portNumber property. By default, the server starts
	 * at port 1527.
	 * Server output goes to derby.log.
	 */

	private static void startWithProperty() throws Exception
	{
		System.out.println("Starting Network Server");
		System.setProperty("derby.drda.startNetworkServer","true");

		// Booting Derby
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
	}



	/**
	 * Tries to check if the Network Server is up and running by calling ping
	 * If successful, it returns; otherwise, it tries for 50 seconds before giving up and throwing
	 * an exception.
	 * @throws Exception when there is a problem with testing if the Network Server is up
	 * and running
	 */
	private static void waitForStart() throws Exception
	{

		// Server instance for testing connection
		org.apache.derby.drda.NetworkServerControl server = null;

		// Use NetworkServerControl.ping() to wait for the
		// Network Server to come up.  We could have used
		// NetworkServerControl to start the server, but the property is
		// easier.
		server = new NetworkServerControl();

		System.out.println("Testing if Network Server is up and running!");
		for (int i = 0; i < 10 ; i ++)
		{
			try {

				Thread.currentThread().sleep(5000);
				server.ping();
			}
			catch (Exception e)
			{
				System.out.println("Try #" + i + " " +e.toString());
				if (i == 9 )
				{
					System.out.println("Giving up trying to connect to Network Server!");
					throw e;
				}
			}
		}
		System.out.println("Derby Network Server now running");

	}

	/**
	 * Used to return an embedded Derby connection.
	 * The protocol used is "jdbc:derby:dbName" where dbName is the database name
	 * @pre the Derby embedded JDBC driver must be loaded before calling
	 * this method
	 * Alternatively, if the Derby Network Server is started in this JVM, the embedded driver
	 * org.apache.derby.jdbc.EmbeddedDriver is already loaded and it need not be loaded again.
	 * @param	dbName	database name (ie location of the database)
	 * @param 	attributes attributes for the database connection
	 *			(for example, create=true;
	 *					 upgrade=true;)
	 * @return	returns embedded database connection
	 * @throws Exception if there is any error
	 */
	public static Connection getEmbeddedConnection(String database,String attributes)
		throws Exception
	{
		String dbUrl = "jdbc:derby:"+database +";"+attributes;
		Connection conn = DriverManager.getConnection(dbUrl);
		return conn;
	}



	/**
	 * Test a connection by executing a sample query
	 * @param	conn 	database connection
	 * @throws Exception if there is any error
	 */
	public static void test(Connection conn)
		throws Exception
	{

	  Statement stmt = null;
	  ResultSet rs = null;
	  try
	  {
		// To test our connection, we will try to do a select from the system catalog tables
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select count(*) from sys.systables");
		while(rs.next())
			System.out.println("number of rows in sys.systables = "+ rs.getInt(1));

	  }
	  catch(SQLException sqle)
	  {
		  System.out.println("SQLException when querying on the database connection; "+ sqle);
		  throw sqle;
  	  }
  	  finally
  	  {
		  if(rs != null)
		  	rs.close();
		  if(stmt != null)
		  	stmt.close();
 	  }

	}


	/**
	 * This method waits until the user presses Enter to stop the server
	 * and eventually exit this program
	 * Allows clients to continue to connect using client connections from other
	 * JVMs to the Derby Network Server that was started in this program
	 */
 	private static void waitForExit() throws Exception
 	{
		System.out.println("Clients can continue to connect: ");
 		BufferedReader in =
 			new BufferedReader(new InputStreamReader(System.in));
 		System.out.println("Press [Enter] to stop Server");
 		in.readLine();
	}

	/**
	 * Returns a string with information as to how to connect to Derby Network Server
	 */
	private static String ijUsage()
	{

		String ijUsage = "\nWhile my app is busy with embedded work, ";
		ijUsage += "ij might connect like this:\n\n";
		ijUsage +=  "\t$ java -Dij.user=me -Dij.password=pw -Dij.protocol=jdbc:derby://localhost:1527/ org.apache.derby.tools.ij\n";
		ijUsage += "\tij> connect '" + DBNAME + "';\n\n";

		return ijUsage;
	}
}






