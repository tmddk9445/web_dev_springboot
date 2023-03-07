package com.example.vsc_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vsc_springboot.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
    
    public boolean existsByTelNumber(String telNumber);

    public EmployeeEntity findByEmployeeNumber(int employeeNumber);
    
}
