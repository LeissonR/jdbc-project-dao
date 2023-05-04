package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("----- Test #01 insert Departament -----");
		Department department = new Department(null, "Snacks");
		departmentDao.insert(department);
		System.out.println("Department inserted with id#: " + department.getId());
		
		System.out.println("\n----- Test #02 Delete Departament -----");
		System.out.print("Enter the Department Id to delete: ");
		departmentDao.deleteById(sc.nextInt());
		System.out.println("Department was deleted");
		
		System.out.println("\n----- Test #03 findById Departament -----");
		department = departmentDao.findById(4);
		System.out.println(department);
		
		
		System.out.println("\n----- Test #04 Update Departament -----");
		department = departmentDao.findById(4);
		department.setName("Foods");
		departmentDao.update(department);
		System.out.println("Department updated id#: " + department.getId());

		System.out.println("\n----- Test #05 find all Departament -----");
		List<Department> dep = departmentDao.findAll();
		dep.forEach(System.out::println);
		
		
		sc.close();
	}
}