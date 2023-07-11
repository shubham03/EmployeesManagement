package com.sopraSteria.service;

import com.sopraSteria.entity.EmployeeDetails;
import com.sopraSteria.request.AddEmpRequest;
import com.sopraSteria.request.UpdateEmpRequest;
import com.sopraSteria.response.AddEmpResponse;
import com.sopraSteria.response.UpdateEmpResponse;

import java.util.List;

public interface AddEmpService {

    public AddEmpResponse addEmp(AddEmpRequest addEmpRequest);
    public List<EmployeeDetails> getAllEmp();
    public EmployeeDetails getEmpDetails( String empId);

    public String deleteEmp( String empId);
    public UpdateEmpResponse updateEmp(UpdateEmpRequest updateEmpRequest);
}
