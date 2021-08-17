package com.cloudtechmasters;
import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    public Employee() {
    }
    public Employee(Long id, String empName, String empAddress, String empSal) {
        this.id = id;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empSal = empSal;
    }

    private String empName;
    private String empAddress;
    private String empSal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpSal() {
        return empSal;
    }

    public void setEmpSal(String empSal) {
        this.empSal = empSal;
    }
}
