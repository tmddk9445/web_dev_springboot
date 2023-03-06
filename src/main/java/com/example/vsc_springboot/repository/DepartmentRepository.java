package com.example.vsc_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vsc_springboot.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, String>{
    
}
