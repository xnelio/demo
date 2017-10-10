package spring.boot.essentials.endpoint;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.essentials.errors.ResourceNotFoundException;
import spring.boot.essentials.model.Student;
import spring.boot.essentials.repository.StudentRepository;

@RestController
@RequestMapping("student")
public class StudentEndpoint {
	
	private final StudentRepository studentDao;

	@Autowired
	public StudentEndpoint(StudentRepository studentDao) {
		this.studentDao = studentDao;
	}
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(studentDao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
		Student student = studentDao.findOne(id);
		this.verifyIfStudentExists(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
		
	}

	@GetMapping(path = "/find={name}")
	public ResponseEntity<?> getStudentByName(@PathVariable("name") String name){
			
		return new ResponseEntity<>(studentDao.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<?> saveStudent(@RequestBody Student student){
		return new ResponseEntity<>(studentDao.save(student), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
		verifyIfStudentExists(id);
		studentDao.delete(studentDao.findOne(id));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> updateStudent(@RequestBody Student student){
		verifyIfStudentExists(student.getId());
		studentDao.save(student);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	private void verifyIfStudentExists(Long id) {
		;
		if(studentDao.findOne(id) == null) {
			throw new ResourceNotFoundException("Student not found for id: " + id);
		}
	}
}
