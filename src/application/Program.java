package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
;
        SellerDao sellerdao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: Seller FindById ====");
        Seller seller = sellerdao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Seller FindByDepartement ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerdao.findByDepartment(new Department(2, null));
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: Seller FindByAll ====");
        list = sellerdao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: Seller Insert ====");
        Seller newseller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerdao.insert(newseller);
        System.out.println("Insert a new seller wit ID: " + newseller.getId());

        System.out.print("\n=== TEST 5: Seller Update ====");
        seller = sellerdao.findById(1);
        seller.setName("Martha Waine");
        sellerdao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 6: Seller Delete ====");
        System.out.println("Enter a ID for delete teste: ");
        int id = sc.nextInt();
        sellerdao.delete(id);
        System.out.println("Delete completed");

        sc.close();
    }
}