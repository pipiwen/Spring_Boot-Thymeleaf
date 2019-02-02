package com.syw.demo1.dao;

import com.syw.demo1.entity.Department;
import com.syw.demo1.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    @Autowired
    private DepartmentDao departmentDao;
    private static Map<Integer, Employee>employeeMap=null;
    static{
        employeeMap=new HashMap<>();
        employeeMap.put(101,new Employee(101,"张三","110@qq.com",1,new Department(1001,"D-AA")));
        employeeMap.put(102,new Employee(102,"李四","111@qq.com",1,new Department(1001,"D-AA")));
        employeeMap.put(103,new Employee(103,"王五","112@qq.com",1,new Department(1002,"D-BB")));
        employeeMap.put(104,new Employee(104,"赵六","113@qq.com",1,new Department(1003,"D-CC")));
        employeeMap.put(105,new Employee(105,"小丽","114@qq.com",0,new Department(1004,"D-DD")));
        employeeMap.put(106,new Employee(106,"美美","115@qq.com",0,new Department(1006,"D-EE")));
    }
    private static Integer empId=107;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(empId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }
    public Collection<Employee>getAllEmployee(){
        return employeeMap.values();
    }
    public Employee getEmployee(Integer id){
        return employeeMap.get(id);
    }
    public void delete(Integer id){
        employeeMap.remove(id);
    }
}
