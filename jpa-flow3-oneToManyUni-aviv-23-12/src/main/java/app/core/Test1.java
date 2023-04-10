package app.core;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Company;
import app.core.entities.Employee;
import app.core.repos.Companyrepo;

//@Component
public class Test1 implements CommandLineRunner {
	@Autowired
	private Companyrepo companyrepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============== Test 1");

		try {
			Company company1 = new Company(0, "Adidas", null);
			Company company2 = new Company(0, "Nike", null);
			Employee e1 = new Employee(0, "aviv", 34);
			Employee e2 = new Employee(0, "lior", 22);
			Employee e3 = new Employee(0, "amit", 45);
			Employee e4 = new Employee(0, "nitzan", 34);
			Employee e5 = new Employee(0, "mika", 23);
			List<Employee> comp1 = Arrays.asList(e1, e2, e3);
			List<Employee> comp2 = Arrays.asList(e4, e5);
			company1.setEmployees(comp1);
			company2.setEmployees(comp2);
			companyrepo.save(company1);
			companyrepo.save(company2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
