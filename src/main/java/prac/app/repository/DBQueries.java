package prac.app.repository;

public class DBQueries {

    public static final String SEE_ALL_EMPLOYEES = "select * from employees limit ?, ?";
    
    public static final String SELECT_SPECIFIC_EMPLOYEE = "select * from employees where id = ?";

    public static final String ORDER_FROM_SPECIFIC_EMPLOYEE= "select e.id as employee_id, e.department, o.id as order_id, o.items, o.price from employees e, orders o where e.id = o.employee_id and employee_id = ?";
}
