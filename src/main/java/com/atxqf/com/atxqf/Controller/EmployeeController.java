package com.atxqf.com.atxqf.Controller;

import com.atxqf.com.atxqf.dao.EmployeeDao;
import com.atxqf.com.atxqf.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Xqf
 * @version 1.0
 * <p>
 * 查询所有的员工信息-->/employee-->get
 * 跳转到添加页面-->/to/add-->get
 * 新增员工信息-->/employee-->post
 * 跳转到修改页面-->/empLoyee/1-->get
 * 修改员工信息-->/empLoyee->pud
 * 删除员工信息-->/empLoyee,/1-->delete
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    //查询所有用户
    @RequestMapping("/employee")
    public String allemp() {
        System.out.println("所有的用户信息" + employeeDao.getAll());
        return "hello";
    }

    @RequestMapping("/id")
    public String getByIdEmp() {
        Employee employee = employeeDao.get(1);
        System.out.println("查询结果：" + employee);
        return "hello";
    }

    @RequestMapping("/save")
    public String UpdateById() {
        employeeDao.save(new Employee());
        System.out.println("所有的用户信息" + employeeDao.getAll());
        return "hello";
    }

    @RequestMapping("/save/{id}")
    public String IncreaseEmp(@PathVariable Integer id) {

        employeeDao.save(new Employee(id, "1", "", 1));
        System.out.println("所有的用户信息" + employeeDao.getAll());
        return "hello";
    }

    @RequestMapping("/del/{id}")
    public String delById(@PathVariable Integer id) {
        employeeDao.delete(id);
        return "hello";
    }
}
