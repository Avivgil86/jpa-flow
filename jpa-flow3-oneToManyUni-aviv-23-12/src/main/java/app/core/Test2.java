package app.core;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Company;
import app.core.entities.Employee;
import app.core.repos.Companyrepo;

//@Component
public class Test2 implements CommandLineRunner {
	@Autowired
	private Companyrepo companyrepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============== Test 2");

		try (Scanner scanner = new Scanner(System.in);) {
			System.out.println("enter company id: ");
			int companyid = scanner.nextInt();
			Optional<Company> opt = companyrepo.findById(companyid);
			if (opt.isPresent()) {
				Company company = opt.get();
				System.out.println(company);
				System.out.println(company.getEmployees());
				company.addEmployee(new Employee(0, "Yossi", 23));
				companyrepo.save(company);
				
			} else {
				System.out.println("company not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
