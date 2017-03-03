package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Employee;
import util.MySQLHelper;

public class EmployeeDAO {
	public boolean insert(Employee employee){
		boolean result = false;
		String sql = "insert into employee(id, name, position, salary) values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setInt(3, employee.getPosition());
			ps.setInt(4, employee.getSalary());
			
			int row = ps.executeUpdate();
			
			if(row > 0){
				result = true;
			}
			
			ps.close();
			MySQLHelper.cloesDB();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	}
}