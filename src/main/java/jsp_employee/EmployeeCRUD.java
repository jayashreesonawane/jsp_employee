package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "root");
	}

	public int signup(Employee employee) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());

		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;

	}

	public String getEmployee(String email) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMAIL=?");
		preparedStatement.setString(1, email);

		ResultSet resultset = preparedStatement.executeQuery();
		String password = null;
		while (resultset.next()) {
			password = resultset.getString("password");
		}
		connection.close();
		return password;
	}

	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Employee> list = new ArrayList<>();
		while (resultSet.next()) {
			Employee employee = new Employee();
			employee.setId(resultSet.getInt("id"));
			employee.setName(resultSet.getString("name"));
			employee.setPhone(resultSet.getLong("phone"));
			employee.setAddress(resultSet.getString("address"));
			employee.setEmail(resultSet.getString("email"));
			employee.setPassword(resultSet.getString("password"));

			list.add(employee);
		}
		connection.close();
		return list;
	}

	public int delete(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		preparedStatement.setInt(1, id);
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

	public Employee getEmployee(int id) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");
		preparedStatement.setInt(1, id);

		ResultSet resultset = preparedStatement.executeQuery();
		Employee employee = new Employee();
		while (resultset.next()) {
			employee.setId(resultset.getInt("id"));
			employee.setName(resultset.getString("name"));
			employee.setPhone(resultset.getLong("phone"));
			employee.setAddress(resultset.getString("address"));
			employee.setEmail(resultset.getString("email"));
			employee.setPassword(resultset.getString("password"));
		}
		connection.close();
		return employee;
	}

	public int updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE EMPLOYEE SET NAME=?,PHONE=?,ADDRESS=?,EMAIL=?,PASSWORD=? WHERE ID=?");
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setLong(2, employee.getPhone());
		preparedStatement.setString(3, employee.getAddress());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setInt(6, employee.getId());
		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;

	}
}
