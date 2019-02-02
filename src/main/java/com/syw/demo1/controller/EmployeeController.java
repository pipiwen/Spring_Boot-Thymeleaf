package com.syw.demo1.controller;

import com.syw.demo1.dao.DepartmentDao;
import com.syw.demo1.dao.EmployeeDao;
import com.syw.demo1.entity.Department;
import com.syw.demo1.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("empList")
    public String empList(Model model){
       Collection<Employee>employees=  employeeDao.getAllEmployee();
       model.addAttribute("emps",employees);
        return "emp/empList";
    }

    @GetMapping("empForm")
    public String empForm(Model model){
        Collection<Department>departments =departmentDao.getAllDepartment();
        model.addAttribute("departments",departments);
        return "emp/empForm";
    }
    @PostMapping("addEdit")
    public String add(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emp/empList";
    }
    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){//@PathVariable restful路径变量
        Employee e=employeeDao.getEmployee(id);
        model.addAttribute("emp",e);
        model.addAttribute("departments",departmentDao.getAllDepartment());
        return "emp/empForm";
    }
    @PutMapping("addEdit")
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emp/empList";
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emp/empList";
    }
}

