package application;


import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment =====");
		Department dept = new Department(2,null);
		
		List<Seller> list = sellerDao.findByDepartmento(dept);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll =====");
		
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller Insert =====");
		Seller newSeller = new Seller(null, "Aderosvaldo","adero3992@hotmail.com",new Date(),4000.0,dept);
		sellerDao.insert(newSeller);
		System.out.println("Inserted!!! New Id = "+newSeller.getId());
		

		System.out.println("\n=== TEST 5: seller Update =====");
		seller = sellerDao.findById(6);
		seller.setName("Bruce Wayne");
		sellerDao.update(seller);
		System.out.println("Updated Completed!");

	}

}
