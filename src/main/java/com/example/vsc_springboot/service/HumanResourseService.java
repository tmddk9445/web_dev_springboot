package com.example.vsc_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vsc_springboot.dto.request.humanResource.PostHumanResourceRequestDto;
import com.example.vsc_springboot.dto.response.ResponseDto;
import com.example.vsc_springboot.dto.response.humanResponse.PostHumanResourceResponseDto;
import com.example.vsc_springboot.entity.DepartmentEntity;
import com.example.vsc_springboot.entity.EmployeeEntity;
import com.example.vsc_springboot.repository.EmployeeRepository;

@Service
public class HumanResourseService {
    
    @Autowired private EmployeeEntity employeeEntity;
    @Autowired private DepartmentEntity departmentEntity;
    @Autowired EmployeeRepository employeeRepository;

    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(PostHumanResourceRequestDto dto){

        PostHumanResourceResponseDto data = new PostHumanResourceResponseDto();

        String telNumber = dto.getTelNumber();

        try {

            boolean hasTelNumber = employeeRepository.existsByTelNumber(telNumber);
            if(hasTelNumber) return ResponseDto.setFail("Existed Telephone Number");

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail("Database Error");
        }

        return ResponseDto.setSuccess("Success", data);
    }
}
