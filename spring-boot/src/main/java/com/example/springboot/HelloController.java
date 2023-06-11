package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
//@RequestMapping("/spring-boot")
public class HelloController {
    @Autowired
    private StudentRepository studentRepo;

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/jpa_insert")
	public void jpa_insert(){
		// https://www.codejava.net/frameworks/spring/understand-spring-data-jpa-with-simple-example
		Student s = new Student();
		s.setEmail("test_email@domain");
		s.setName("Test username");
		studentRepo.save(s);
	}

	@GetMapping("/jpa_select")
	public String jpa_select(){
		Iterable<Student> iterator = studentRepo.findAll();
		iterator.forEach(student -> System.out.println(student));
		return "Number of student: " + studentRepo.count();
	}

	@GetMapping("/jdbc_insert")
	public String jdbc_insert(){
		String sql = "INSERT INTO students (name, email) VALUES ("
                + "'Nam Ha Minh', 'nam@codejava.net')";
         
        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
		return "Inserted a static row into students table";
	}

	@PostMapping("/jpa_put/{email}/{name}")
	public String jpa_put(@PathVariable String email, @PathVariable String name){
		Student s = new Student();
		s.setEmail(email);
		s.setName(name);
		studentRepo.save(s);
		return String.format("Got student with email %s and name %s", email, name);
	}
}