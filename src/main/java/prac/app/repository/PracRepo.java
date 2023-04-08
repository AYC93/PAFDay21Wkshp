package prac.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import prac.app.model.Employees;
import prac.app.model.Order;

import static prac.app.repository.DBQueries.*;

@Repository
public class PracRepo {

    @Autowired
    private JdbcTemplate template;

    public List<Employees> getEmployees(int offset, int limit){
        
        offset = 0;

        limit = 5;

        List<Employees> result = new ArrayList<>();

        SqlRowSet rs = template.queryForRowSet(SEE_ALL_EMPLOYEES, offset, limit);

        while (rs.next()){
            Employees emp = new Employees();
            emp.setId(rs.getInt("id"));
            emp.setLastName(rs.getString("last_name"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setEmail(rs.getString("email"));
            emp.setDept(rs.getString("department"));
            emp.setSalary(rs.getDouble("salary"));

            result.add(emp);

        }
        return result;
    }

    public Employees pickEmployeeWithId(int employeeId){

        SqlRowSet rs = template.queryForRowSet(SELECT_SPECIFIC_EMPLOYEE, employeeId);
        Employees emp = new Employees();

        while (rs.next()){
            emp.setId(rs.getInt("id"));
            emp.setLastName(rs.getString("last_name"));
            emp.setFirstName(rs.getString("first_name"));
            emp.setEmail(rs.getString("email"));
            emp.setDept(rs.getString("department"));
            emp.setSalary(rs.getDouble("salary"));
        }
            return emp;
    }

    public List<Order> pickOrderWithEmployeeId(int employeeId){

        List<Order> orderList = new ArrayList<>();

        SqlRowSet rs = template.queryForRowSet(ORDER_FROM_SPECIFIC_EMPLOYEE, employeeId);

        while (rs.next()){
            Order ord = new Order();
            ord.setId(rs.getInt("id"));
            ord.setCustomerId(rs.getInt("employee_id"));
            ord.setItems(rs.getString("items"));
            ord.setPrice(rs.getDouble("price"));

            orderList.add(ord);
        }
        return orderList;
    }
}
