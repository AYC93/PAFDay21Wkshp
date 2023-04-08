package prac.app.model;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Employees {
    
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String dept;
    private Double salary;

    public Employees() {
    }

    public Employees(int id, String lastName, String firstName, String email, String dept, Double salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    
    public String getDept() {return dept;}
    public void setDept(String dept) {this.dept = dept;}
    
    public Double getSalary() {return salary;}
    public void setSalary(Double salary) {this.salary = salary;}

    @Override
    public String toString() {
        return "Employees [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
                + ", dept=" + dept + ", salary=" + salary + "]";
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
                .add("id", this.getId())
                .add("last_name", this.getLastName())
                .add("first_name", this.getFirstName())
                .add("email", this.getEmail())
                .add("department", this.getDept())
                .add("salary", this.getSalary())
                .build();
    }
    
}
