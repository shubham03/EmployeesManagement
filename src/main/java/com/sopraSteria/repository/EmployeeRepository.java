package com.sopraSteria.repository;

import com.sopraSteria.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails,Integer> {

    public EmployeeDetails findByEmpId(String emdId);
    public EmployeeDetails findByContactNo(String emdId);

}
