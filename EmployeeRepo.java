package com.example.Backend.Repository;

import com.example.Backend.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository <Employee , Long> {

}
