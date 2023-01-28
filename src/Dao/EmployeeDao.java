package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BinOper.Employee;

public class EmployeeDao {
//	Insert the Employee 

	public void insertEmployee(Employee emp) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_employee";
			String username = "root";
			String pasword = "ajjubhai";

			con = DriverManager.getConnection(url, username, pasword);

			Statement s = con.createStatement();
			String i = "insert into employee values(" + emp.getEid() + ",'" + emp.getEname() + "','" + emp.getEsub()
					+ "')";
			s.execute(i);
			System.out.println("insert successfully");

		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

//	Details of Employee

	public int getById(int id) {
		Connection con1 = null;
		int id1 = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_employee";
			String username = "root";
			String pasword = "ajjubhai";

			con1 = DriverManager.getConnection(url, username, pasword);

			Statement s1 = con1.createStatement();
			String select = "select * from employee where eid = " + id + "";
			ResultSet res = s1.executeQuery(select);

			while (res.next()) {
				id1 = res.getInt("eid");
				System.out.println("Details of Employee are : ");
				System.out.println("eid = " + id1);
				System.out.println("ename = " + res.getString("ename"));
				System.out.println("esub = " + res.getString("esub"));
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				con1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id1;
	}

//	Delete the Employee

	public void delete(int id) {
		Connection con1 = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_employee";
			String username = "root";
			String pasword = "ajjubhai";

			con1 = DriverManager.getConnection(url, username, pasword);

			Statement s1 = con1.createStatement();
			String delete = "delete from employee where eid = " + id + "";
			s1.executeUpdate(delete);
			System.out.println("Delete Successfully");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				con1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	Update the Employee

	public void updateEmp(Employee emp) {
		
		
		Connection con1 = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_employee";
			String username = "root";
			String pasword = "ajjubhai";

			con1 = DriverManager.getConnection(url, username, pasword);

			Statement s1 = con1.createStatement();
			String update = "update Employee set ename='"+emp.getEname()+"',esub='"+emp.getEsub()+"' where eid = "+emp.getEid()+ "";
			int id = s1.executeUpdate(update);
			if(id!=0) {
				System.out.println("Update Successfully");
			}
			else {
				System.out.println("Id Not Found");
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				con1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	Display the Employee
	
	public List<Employee> display(){
		Connection con1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc_employee";
			String username = "root";
			String pasword = "ajjubhai";

			con1 = DriverManager.getConnection(url, username, pasword);

			Statement s1 = con1.createStatement();
			String display = "select * from employee";
			ResultSet res = s1.executeQuery(display);

			List<Employee> e = new ArrayList<Employee>();
			
			while (res.next()) {
				int id1 = res.getInt("eid");
				String name = res.getString("ename");
				String sub = res.getString("esub");
				
				Employee emp = new Employee();
				
				emp.setEid(id1);
				emp.setEname(name);
				emp.setEsub(sub);
				e.add(emp);
				
			}
			return e;
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		finally {
			try {
				con1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
