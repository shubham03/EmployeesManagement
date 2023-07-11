package com.sopraSteria.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sopraSteria.entity.EmployeeDetails;
import com.sopraSteria.request.AddEmpRequest;
import com.sopraSteria.request.UpdateEmpRequest;
import com.sopraSteria.response.AddEmpResponse;
import com.sopraSteria.response.UpdateEmpResponse;
import com.sopraSteria.service.AddEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class EmployeeController {

    @Autowired
    AddEmpService addEmpService;

   // private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
   private static final Logger log = Logger.getLogger(EmployeeController.class.getName());

    @Autowired
    private ObjectMapper mapper;


    @GetMapping("/home")
    public String home() {

        return "Welcome to Sopra Steria";
    }

    @PostMapping("/addEmployees")
    public AddEmpResponse addEmp(@RequestBody AddEmpRequest addEmpRequest) {
        log.log(Level.INFO, "/addEmpRequest - ; " + addEmpRequest.toString());

        AddEmpResponse addEmpResponse=addEmpService.addEmp(addEmpRequest);
        log.log(Level.INFO, "/addEmpResponse - &gt; " + addEmpResponse.toString());

        return addEmpResponse;
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeDetails> getAllEmp() {
        log.log(Level.INFO, "/getAllEmployee - ; " + "request get All emp");

        List<EmployeeDetails> allEmp=addEmpService.getAllEmp();
        log.log(Level.INFO, "/getAllEmployee - &gt; " + "response get All emp");

        return allEmp;
    }


    @GetMapping("/getEmployeesByID/{empId}")
    public EmployeeDetails getEmpById(@PathVariable String empId) {
        log.log(Level.INFO, "/getEmpById - ; " + "request get All emp");

        EmployeeDetails empDetails=addEmpService.getEmpDetails(empId);
        log.log(Level.INFO, "/getEmpById - &gt; " + "response get All emp");

        return empDetails;
    }

    @DeleteMapping("/deleteEmployeesByID/{empId}")
    public String  deleteEmpById(@PathVariable String empId) {
        log.log(Level.INFO, "/deleteEmployeeByID - ; " + "request get All emp");

        String response =addEmpService.deleteEmp(empId);
        log.log(Level.INFO, "/deleteEmployeeByID - &gt; " + "response get All emp");

        return response;
    }



    @PutMapping("/updateEmployees")
    public UpdateEmpResponse updateEmp(@RequestBody UpdateEmpRequest updateEmpRequest) {
        log.log(Level.INFO, "/updateEmployees - ; " +updateEmpRequest.toString());

        UpdateEmpResponse updateEmpResponse=addEmpService.updateEmp(updateEmpRequest);
        log.log(Level.INFO, "/updateEmployees - &gt; " + updateEmpResponse.toString());

        return updateEmpResponse;
    }

}
