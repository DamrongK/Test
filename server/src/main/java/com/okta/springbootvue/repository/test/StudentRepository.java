package com.okta.springbootvue.repository.test;

import com.okta.springbootvue.entity.test.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Collection;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public
interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(long id);

    Collection<Student> findByStuCode(String stuCode);
}