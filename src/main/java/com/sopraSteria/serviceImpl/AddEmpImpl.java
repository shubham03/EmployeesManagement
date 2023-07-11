package com.sopraSteria.serviceImpl;


import com.sopraSteria.entity.EmployeeDetails;
import com.sopraSteria.repository.EmployeeRepository;
import com.sopraSteria.request.AddEmpRequest;
import com.sopraSteria.request.UpdateEmpRequest;
import com.sopraSteria.response.AddEmpResponse;
import com.sopraSteria.response.UpdateEmpResponse;
import com.sopraSteria.service.AddEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AddEmpImpl implements AddEmpService {

    private static final Logger LOG = Logger.getLogger(AddEmpImpl.class.getName());

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public AddEmpResponse addEmp(AddEmpRequest addEmpRequest) {
        LOG.log(Level.INFO, "impl class request  ; " + addEmpRequest);
        AddEmpResponse addEmpResponse = new AddEmpResponse();
        try {
            EmployeeDetails empInfo = new EmployeeDetails();
            empInfo.setName(addEmpRequest.getFirstName() + " " + addEmpRequest.getLastName());
            empInfo.setAddress(addEmpRequest.getAddress());
            empInfo.setContactNo(addEmpRequest.getContactNo());
            empInfo.setEmpId(addEmpRequest.getEmpId());
            employeeRepository.save(empInfo);
        } catch (Exception e) {

            addEmpResponse.setMessage(e.getMessage());
            addEmpResponse.setStatusCode("400");
            return addEmpResponse;
        }
        addEmpResponse.setMessage("successfully added Employee.....");
        addEmpResponse.setStatusCode("200");

        return addEmpResponse;

    }

    @Override
    public List<EmployeeDetails> getAllEmp() {
        List<EmployeeDetails> allEmpDetails = employeeRepository.findAll();
        return allEmpDetails;
    }

    @Override
    public EmployeeDetails getEmpDetails(String empId) {
        EmployeeDetails getData = employeeRepository.findByEmpId(empId);
        return getData;
    }

    @Override
    public String deleteEmp(String empId) {
        EmployeeDetails employeeDetails=employeeRepository.findByEmpId(empId);
        if(employeeDetails != null) {
            employeeRepository.delete(employeeDetails);
            return "Employee delete successfully...";
        }
        return "Employee not found ...";


    }

    @Override
    public UpdateEmpResponse updateEmp(UpdateEmpRequest updateEmpRequest) {
        LOG.log(Level.INFO, "impl class request  ; " + updateEmpRequest);
        UpdateEmpResponse updateEmpResponse = new UpdateEmpResponse();
        EmployeeDetails employeeDetails = employeeRepository.findByContactNo(updateEmpRequest.getContactNo());
        if (employeeDetails != null) {
            employeeDetails.setAddress(updateEmpRequest.getAddress());
            employeeDetails.setContactNo(updateEmpRequest.getContactNo());
            employeeDetails.setEmpId(updateEmpRequest.getEmpId());
            employeeRepository.save(employeeDetails);
            updateEmpResponse.setMessage("successfully Update Employee.....");
            updateEmpResponse.setStatusCode("200");
            return updateEmpResponse;

        }

        updateEmpResponse.setMessage("Employee not Found...");
        updateEmpResponse.setStatusCode("400");

        return updateEmpResponse;

    }
}