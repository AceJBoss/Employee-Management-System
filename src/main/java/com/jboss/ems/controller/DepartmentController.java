package com.jboss.ems.controller;

import com.jboss.ems.model.Department;
import com.jboss.ems.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/create-department")
    public Department createDepartment(@RequestBody Department department){
        return departmentRepository.save(department);
    }
    @GetMapping("/view-departments")
    public List<Department> fetchDepartments(){
        return departmentRepository.findAll();
    }
    @GetMapping("/view-department/{id}")
    public Department fetchDepartment(@PathVariable(value = "id") int id){
        return departmentRepository.findById(id).orElse(null);
    }
    @GetMapping("/search/{name}")
    public Department fetchDeptName(String deptName){
        return departmentRepository.findByName(deptName);
    }
    @PutMapping("/update-department/{id}")
    public Department updateDepartment(@RequestBody Department department, int id){
        Department defaultDepartment = departmentRepository.findById(id).orElse(null);
        defaultDepartment.setDeptName(department.getDeptName());
        defaultDepartment.setDeptDesc(department.getDeptDesc());
        return departmentRepository.save(defaultDepartment);
    }
    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable(value = "id") int id){
        departmentRepository.deleteById(id);
        return "Department with ID " + id + " Successfully deleted.";
    }
}
