package net.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import net.registration.model.Employee;

public class EmployeeDao {

	public int Register(Employee employee) throws ClassNotFoundException
	{
		int result = 0;
		String jdbcURL = "jdbc:mysql://localhost:3306/employees";
	    String username = "root";
	    String password = "123456";
	    String SQL_INSERT = "INSERT INTO employee "
	                + "(first_name, last_name, username, password, address, contact)"
	                + " VALUES (?, ?, ?, ?, ?, ?)";

	    Class.forName("com.mysql.cj.jdbc.Driver");
	        try(Connection conn = DriverManager.getConnection(jdbcURL, username, password)) {
	            PreparedStatement statement = conn.prepareStatement(SQL_INSERT);

	            statement.setString(1, employee.getFirstName());
	            statement.setString(2, employee.getLastName());
	            statement.setString(3, employee.getUsername());
	            statement.setString(4, employee.getPassword());
	            statement.setString(5, employee.getAddress());
	            statement.setString(6, employee.getContact());

	            System.out.println(statement);
	            
	            result = statement.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
		return result;
		
	}
}
