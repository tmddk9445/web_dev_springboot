package com.example.vsc_springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vsc_springboot.common.constant.ResponseMessage;
import com.example.vsc_springboot.dto.request.department.PostDepartmentRequestDto;
import com.example.vsc_springboot.dto.response.ResponseDto;
import com.example.vsc_springboot.dto.response.department.DeleteDepartmentResponseDto;
import com.example.vsc_springboot.dto.response.department.GetAllDepartmentListResponseDto;
import com.example.vsc_springboot.dto.response.department.PostDepartmentResponseDto;
import com.example.vsc_springboot.entity.DepartmentEntity;
import com.example.vsc_springboot.repository.DepartmentRepository;
import com.example.vsc_springboot.repository.EmployeeRepository;

@Service
public class DepartmentService {
    
    @Autowired EmployeeRepository employeeRepository;
    @Autowired DepartmentRepository departmentRepository;

    public ResponseDto<PostDepartmentResponseDto> postDepartment(PostDepartmentRequestDto dto) {
        
        PostDepartmentResponseDto data = null;
        
        String departmentCode = dto.getDepartmentCode();
        int chiefEmployeeNumber = dto.getChief();

        try {

            boolean hasDepartment = departmentRepository.existsById(departmentCode);
            if (hasDepartment) return ResponseDto.setFail(ResponseMessage.EXIST_DEPARTMENT_CODE);

            boolean hasEmployee = employeeRepository.existsById(chiefEmployeeNumber);
            if (!hasEmployee) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_EMPLOYEE_NUMBER);

            DepartmentEntity departmentEntity = new DepartmentEntity(dto);
            departmentRepository.save(departmentEntity);

            data = new PostDepartmentResponseDto(departmentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<List<GetAllDepartmentListResponseDto>> getAllDepartmentList() {

        List<GetAllDepartmentListResponseDto> data = new ArrayList<GetAllDepartmentListResponseDto>();

        try {

            List<DepartmentEntity> departmentList = departmentRepository.findAll();
            data = GetAllDepartmentListResponseDto.copyList(departmentList);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    public ResponseDto<List<DeleteDepartmentResponseDto>> deleteDepartment(String departmentCode) {
        
        List<DeleteDepartmentResponseDto> data = null;
        
        try {

            boolean hasDepartCode = departmentRepository.existsById(departmentCode);
            if (!hasDepartCode) return ResponseDto.setFail(ResponseMessage.NOT_EXIST_DEPARTMENT_CODE);

            boolean hasReferencEmployee = employeeRepository.existsByDepartment(departmentCode);
            if (hasReferencEmployee) return ResponseDto.setFail(ResponseMessage.REFERENCE_EXIST);

            departmentRepository.deleteById(departmentCode);

            List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
            data = DeleteDepartmentResponseDto.copyList(departmentEntities);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.setFail(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
    
}
