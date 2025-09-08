package com.example.Backend.Service;

import com.example.Backend.Dto.EmployeeDto;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId , EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);
}
