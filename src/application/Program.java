package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("---x--- TEST 1: seller findById ---x---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n---x--- TEST 2: seller findByDepartment ---x---");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);

		System.out.println("\n---x--- TEST 3: seller findAll ---x---");
		list = sellerDao.findAll();
		list.forEach(System.out::println);

		System.out.println("\n---x--- TEST 4: seller insert ---x---");
		Seller newSeller = new Seller(null,"Test Blue" , "test@test.com", new Date(), 3000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n---x--- TEST 5: seller update ---x---");
		seller = sellerDao.findById(1);
		seller.setName("Hex Grug");
		sellerDao.update(seller);
		System.out.println("Seller Update completed");
		
		System.out.println("\n---x--- TEST 6: seller delete ---x---");
		System.out.print("Enter id for delete test: ");
		sellerDao.deleteById(sc.nextInt());
		System.out.println("Seller Delete completed");
		
		sc.close();
	}

}
