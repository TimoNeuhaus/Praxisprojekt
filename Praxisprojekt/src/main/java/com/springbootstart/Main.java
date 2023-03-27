package com.springbootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/person")
public class Main {

	private final personRepository personRepository;

	public Main(personRepository personRepository) {
		this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@GetMapping
	public List<Person> getPerson() {
		return personRepository.findAll();
	}

	record NewPersonRequest(
			String name,
			String description,
			String imagePath,
			String details
	) {

	}

	@PostMapping
	public void addPerson(@RequestBody NewPersonRequest request) {
		Person person = new Person();
		person.setName(request.name());
		person.setDescription(request.description());
		person.setImagePath(request.imagePath());
		person.setDetails(request.details());
		personRepository.save(person);

	}

	@DeleteMapping("{personId}")
	public  void deletePerson(@PathVariable("personId") Integer id) {
		personRepository.deleteById(id);
	}


	@PutMapping("{personId}")
	public void updatePerson(@PathVariable("personId") Integer id,
							   @RequestBody Person person) {
		person.setId(id);
		personRepository.save(person);
	}



}
