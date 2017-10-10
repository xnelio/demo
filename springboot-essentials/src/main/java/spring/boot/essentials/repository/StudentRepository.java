package spring.boot.essentials.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.boot.essentials.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findByNameIgnoreCaseContaining(String name);
	
}
