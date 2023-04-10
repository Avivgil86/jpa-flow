package app.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Student;
import app.core.repos.StudentRepo;
import app.core.repos.UniversityRepo;

@Component
public class Test1 implements CommandLineRunner {
	@Autowired
	private UniversityRepo universityrepo;
	@Autowired
	private StudentRepo Studentrepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============== Test 1");

		try {
			Student student1 = new Student(0, "aviv", 17, null);
			Student student2 = new Student(0, "lidor", 25, null);
			Studentrepo.save(student1);
			Studentrepo.save(student2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
