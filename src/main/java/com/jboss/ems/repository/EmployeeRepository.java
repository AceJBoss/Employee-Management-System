package com.jboss.ems.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jboss.ems.model.Employee;

@Qualifier("emps")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
