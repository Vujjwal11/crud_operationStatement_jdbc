package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BinOper.Employee;
import Service.EmployeeService;

public class EmployeeController {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EmployeeService service = new EmployeeService();
		
		Employee emp = new Employee();
//		emp.setEid(130);
//		emp.setEname("Yuvi Sarraf");
//		emp.setEsub("Java");
//	
//		service.insertEmployee(emp);
		while(true)
		{
			System.out.println("1.Insert\n2.GetById\n3.Delete\n4.Update\n5.Display\n6.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter the eid : ");
				int a = sc.nextInt();
				emp.setEid(a);
				System.out.println("Enter the name");
				String d = sc.next();
				d+=sc.nextLine();
				emp.setEname(d);
				System.out.println("Enter the subject");
				String f = sc.next();
				emp.setEsub(f);
			
				service.insertEmployee(emp);
			}break;
			case 2:{
				System.out.println("Enter the id");
				int id = sc.nextInt();
				service.getById(id);
			}break;
			case 3:
			{
				System.out.println("Enter the id");
				int b = sc.nextInt();
				service.delete(b);
			}break;
			case 4:
			{
				System.out.println("Enter the eid : ");
				int a = sc.nextInt();
				emp.setEid(a);
				
				System.out.println("1.update name\n2.update sub");
				int p = sc.nextInt();
				switch(p) {
				case 1:{
				System.out.println("Enter the name");
				String d = sc.next();
				d+=sc.nextLine();
				emp.setEname(d);
				}break;
				case 2:{
					System.out.println("Enter the sub");
					String v = sc.next();
					emp.setEsub(v);
				}break;
				}
				service.updateEmp(emp);
			}break;
			case 5:
			{
				List<Employee> l = service.display();
				
				for(Employee employee : l) {
					System.out.println("eid = " + employee.getEid());
					System.out.println("ename = " + employee.getEname());
					System.out.println("esub = " + employee.getEsub());
					System.out.println();
					System.out.println("-----------------------------------");
				}
			}break;
			case 6:
			{
				
			}break;
			}
		}
	}
}
