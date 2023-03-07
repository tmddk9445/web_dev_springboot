package com.example.vsc_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vsc_springboot.common.constant.ResponseMessage;
import com.example.vsc_springboot.dto.request.humanResource.PostHumanResourceRequestDto;
import com.example.vsc_springboot.dto.response.ResponseDto;
import com.example.vsc_springboot.dto.response.humanResponse.GetHumanResourceResponseDto;
import com.example.vsc_springboot.dto.response.humanResponse.PostHumanResourceResponseDto;
import com.example.vsc_springboot.entity.EmployeeEntity;
import com.example.vsc_springboot.repository.DepartmentRepository;
import com.example.vsc_springboot.repository.EmployeeRepository;

// import static com.example.vsc_springboot.common.constant.ResponseMessage.EXIST_TELEPHONE_NUMBER;

@Service
public class HumanResourceService {
    
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;

    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(PostHumanResourceRequestDto dto) {
        
        PostHumanResourceResponseDto data = null;

        String telNumber = dto.getTelNumber();
        String departmentCode = dto.getDepartment();

        try {
            
            boolean hasTelNumber = employeeRepository.existsByTelNumber(telNumber);
            if (hasTelNumber) return ResponseDto.setFail(ResponseMessage.EXIST_TELEPHONE_NUMBER);
            
            if (departmentCode != null) {
                boolean hasDepartment = departmentRepository.existsById(departmentCode);
                if (!hasDepartment) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_DEPARTMENT_CODE);
            }

            EmployeeEntity employeeEntity = new EmployeeEntity(dto);
            employeeRepository.save(employeeEntity);

            data = new PostHumanResourceResponseDto(employeeEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<GetHumanResourceResponseDto> getHumanResource(int employeeNumber) {

        GetHumanResourceResponseDto data = null;

        try {
            // boolean hasEmployee = employeeRepository.existsById(employeeNumber);
            // if (!hasEmployee) return ResponseDto.setFail("존재 X");
            // EmployeeEntity employeeEntity = employeeRepository.findById(employeeNumber).get();

            EmployeeEntity employeeEntity = employeeRepository.findByEmployeeNumber(employeeNumber);
            if (employeeEntity == null) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_EMPLOYEE_NUMBER);

            data = new GetHumanResourceResponseDto(employeeEntity);
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

}