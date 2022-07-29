package com.repository;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Student;
import com.entity.User;

import net.bytebuddy.description.NamedElement.WithOptionalName;




@Repository
public interface StuRepository extends JpaRepository<Student,Integer>
{
	
	Page<Student> findByName(String name,Pageable paging,Class<Student> student);
    Page<Student> findByOrderById(Pageable paging,Class<Student> student);
	
}
