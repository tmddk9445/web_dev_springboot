package com.example.vsc_springboot.dto.response.department;

import com.example.vsc_springboot.entity.DepartmentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDepartmentResponseDto {
    
    private String departmentCode;
    private String name;
    private int chief;
    private String telNumber;

    public PostDepartmentResponseDto(DepartmentEntity departmentEntity) {
        this.departmentCode = departmentEntity.getDepartmentCode();
        this.name = departmentEntity.getName();
        this.chief = departmentEntity.getChief();
        this.telNumber = departmentEntity.getTelNumber();
    }
    
}
