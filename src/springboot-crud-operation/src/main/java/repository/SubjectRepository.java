package repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.Repository;

import bean.Subject;

public interface SubjectRepository extends CrudRepository<Subject,String> {

	

}
