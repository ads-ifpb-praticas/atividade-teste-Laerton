/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author laerton
 */
public class CriaBase {
 
    public static Connection getConnection () throws SQLException{
        Connection connection =
				DriverManager.getConnection("jdbc:h2:mem:;" +
						"INIT=RUNSCRIPT FROM './src/main/resources/schema.sql'\\;", "sa", "");
        return connection;
		
    }
}
