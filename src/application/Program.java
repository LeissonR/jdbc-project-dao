package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Department dept = new Department(2, "MFG");
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", sdf.parse("01/05/2023"), 3000.0, dept);

		System.out.println(seller);

	}

}
