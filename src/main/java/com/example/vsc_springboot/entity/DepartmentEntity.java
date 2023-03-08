package com.example.vsc_springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.vsc_springboot.dto.request.department.PostDepartmentRequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Department")
@Table(name = "Department")
public class DepartmentEntity {
    @Id
    //? 부서 코드
    private String departmentCode;
    //? 부서명
    private String name;
    //? 부서장
    private int chief;
    //? 부서전화번호
    private String telNumber;

    public DepartmentEntity (PostDepartmentRequestDto dto) {
        this.departmentCode = dto.getDepartmentCode();
        this.name = dto.getName();
        this.chief = dto.getChief();
        this.telNumber = dto.getTelNumber();
    }
}
