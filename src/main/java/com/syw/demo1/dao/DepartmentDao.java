package com.syw.demo1.dao;

import com.syw.demo1.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department>departmentMap=null;
    static{
        departmentMap=new HashMap<>();
        departmentMap.put(1001,new Department(1001,"D-AA"));
        departmentMap.put(1002,new Department(1002,"D-BB"));
        departmentMap.put(1003,new Department(1003,"D-CC"));
        departmentMap.put(1004,new Department(1004,"D-DD"));
        departmentMap.put(1005,new Department(1005,"D-EE"));
        departmentMap.put(1006,new Department(1006,"D-FF"));
    }
    public Collection<Department> getAllDepartment(){
        return departmentMap.values();
    }
    public Department getDepartment(Integer id){
        return departmentMap.get(id);
    }
}
