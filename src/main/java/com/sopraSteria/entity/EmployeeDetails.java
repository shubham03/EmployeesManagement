package com.sopraSteria.entity;


import javax.persistence.*;

@Entity
@Table(name = "employee_data")
//@Document(collation = "employee_data")
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    @Column(name = "name")
    private String name;

    @Column(nullable = false, unique = true)
    private  String contactNo;

    @Column(name = "emp_id",unique = true)
    private  String empId;

    @Column(name = "address")
    private String address;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "Id=" + Id +
                ", Name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", empId='" + empId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
