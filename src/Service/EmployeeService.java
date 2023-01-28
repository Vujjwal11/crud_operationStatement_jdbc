package Service;

import java.util.List;

import BinOper.Employee;
import Dao.EmployeeDao;

public class EmployeeService {
	EmployeeDao dao = new EmployeeDao();

	public void insertEmployee(Employee emp) {
		if (emp.getEsub().equalsIgnoreCase("Java")) {
			dao.insertEmployee(emp);
		} else {
			System.out.println("Hey please check what data you pass.........");

		}
	}

//	Details of Employee
	public int getById(int id) {
//		return dao.getById(id);  //??we can write this also
		int id2 = dao.getById(id);
		if (id2 == id) {

		} else {
			System.out.println("Id Not Found");
		}
		return id2;
	}

//	Delete the Employee

	public void delete(int id) {
		int id3 = dao.getById(id);
		if (id3 == id) {
			dao.delete(id3);
		} else {
			System.out.println("Id NOt Found");
		}
	}

//	Update the Employee

	public void updateEmp(Employee emp) {
		dao.updateEmp(emp);
	}
	
//	Display the employee
	public List<Employee> display() {
	return dao.display();	
	}
}
