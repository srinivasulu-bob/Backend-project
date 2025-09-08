package com.example.Backend.Service.Impl;

import com.example.Backend.Dto.EmployeeDto;
import com.example.Backend.Entity.Employee;
import com.example.Backend.Exception.ResourceNotFoundException;
import com.example.Backend.Mapper.EmployeeMapper;
import com.example.Backend.Repository.EmployeeRepo;
import com.example.Backend.Service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepo repo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = repo.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


     @Override
    public EmployeeDto getEmployeeById(Long employeeId){

        Employee employee = repo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("employee id is not found :" +employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees(){

        List<Employee> employees = repo.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = repo.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("employee is not exist:"+employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = repo.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = repo.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("employee not exist:" +employeeId)
        );

        repo.deleteById(employeeId);
    }
}
