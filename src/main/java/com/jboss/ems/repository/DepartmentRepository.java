package com.jboss.ems.repository;

import com.jboss.ems.model.Department;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("depts")
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByName(String name);
}
