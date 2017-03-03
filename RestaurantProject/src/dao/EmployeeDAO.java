package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.MySQLHelper;

public class EmployeeDAO {
	public boolean validId(String id){
		boolean result = false;
		String sql = "select count(*) from employee where id = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int count = rs.getInt(1); 
				if(count == 0){
					result = true;
				}
			}
			rs.close();
			ps.close();
			MySQLHelper.cloesDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
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
	public List<Employee> selectAll(){
		List<Employee> employees = new ArrayList<>();
		String sql = "select * from employee";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				int position = rs.getInt(3);
				int salary = rs.getInt(4);
				
				Employee employee = new Employee(id, name, position, salary);
				
				employees.add(employee);
			}
			rs.close();
			ps.close();
			MySQLHelper.cloesDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
}
