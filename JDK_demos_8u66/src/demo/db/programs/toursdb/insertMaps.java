package demo.db.programs.toursdb;
/*

   Derby - Class SimpleApp

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


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.SQLException;


public class insertMaps {

	public static final String CSdriver = new String("org.apache.derby.jdbc.EmbeddedDriver");
	public static final String dbURLCS = new String("jdbc:derby:toursdb");

	public static void main(String[] args) throws Exception {

		System.out.println("Loading the Derby jdbc driver...");
		Class.forName(CSdriver).newInstance();
	
		System.out.println("Getting Derby database connection...");
		Connection connCS = DriverManager.getConnection(dbURLCS);
		System.out.println("Successfully got the Derby database connection...");

		System.out.println("Inserted " + insertRows(null, connCS) +
						   " rows into the ToursDB");

		connCS.close();

		// Shut down the database cleanly before exiting.
		try {
			DriverManager.getConnection(dbURLCS + ";shutdown=true");
		} catch (SQLException sqle) {
			// Database shutdown is expected to raise SQLState 08006.
			// Report any other exception.
			if (!"08006".equals(sqle.getSQLState())) {
				throw sqle;
			}
		}
	}
	
	public static int insertRows(String path, Connection conn) 
	throws SQLException, FileNotFoundException, IOException {
		PreparedStatement ps = null;

		ps = conn.prepareStatement
		("insert into maps (map_name, region, area, photo_format, picture) values (?,?,?,?,?)");

		ps.setString(1,"North Ocean");
		ps.setString(2,"Cup Island");
		ps.setBigDecimal(3, new BigDecimal("1776.11"));
		ps.setString(4,"gif");
		String fileName;
		if (path == null)
			fileName="cupisle.gif";
		else
			fileName=path + File.separator + "cupisle.gif";
		File file = new File (fileName);
		InputStream fileIn = new FileInputStream(file);
		ps.setBinaryStream(5, fileIn, (int)file.length());
		int numrows = ps.executeUpdate();
		fileIn.close();

		ps.setString(1,"Middle Ocean");
		ps.setString(2,"Small Island");
		ps.setBigDecimal(3, new BigDecimal("1166.77"));
		ps.setString(4,"gif");
		if (path == null)
			fileName="smallisle.gif";
		else
			fileName=path + File.separator + "smallisle.gif";
		file = new File (fileName);
		fileIn = new FileInputStream(file);
		ps.setBinaryStream(5, fileIn, (int)file.length());
		numrows = numrows + ps.executeUpdate();
		fileIn.close();

		ps.setString(1,"South Ocean");
		ps.setString(2,"Witch Island");
		ps.setBigDecimal(3, new BigDecimal("9117.90"));
		ps.setString(4,"gif");
		if (path == null)
			fileName="witchisle.gif";
		else
			fileName=path + File.separator + "witchisle.gif";
		file = new File (fileName);
		fileIn = new FileInputStream(file);
		ps.setBinaryStream(5, fileIn, (int)file.length());
		numrows = numrows + ps.executeUpdate();

		fileIn.close();
		ps.close();
		
		return numrows;
	}

}
