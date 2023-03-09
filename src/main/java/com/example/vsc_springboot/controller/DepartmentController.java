package com.example.vsc_springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vsc_springboot.common.constant.ApiMappingPattern;
import com.example.vsc_springboot.dto.request.department.PostDepartmentRequestDto;
import com.example.vsc_springboot.dto.response.ResponseDto;
import com.example.vsc_springboot.dto.response.department.DeleteDepartmentResponseDto;
import com.example.vsc_springboot.dto.response.department.GetAllDepartmentListResponseDto;
import com.example.vsc_springboot.dto.response.department.PostDepartmentResponseDto;
import com.example.vsc_springboot.service.DepartmentService;

@RestController
@RequestMapping(ApiMappingPattern.DEPARTMENT)
public class DepartmentController {
    
    @Autowired DepartmentService departmentService;

    private static final String POST_DEPARTMENT = "/";
    private static final String GET_ALL_DEPARTMENT_LIST = "/all";
    private static final String DELETE_DEPARTMENT = "/{departmentCode}";

    @PostMapping(POST_DEPARTMENT)
    //? POST http://localhost:4080/apis/department/
    public ResponseDto<PostDepartmentResponseDto> postDepartment(@Valid @RequestBody PostDepartmentRequestDto requestBody) {
        ResponseDto<PostDepartmentResponseDto> response = departmentService.postDepartment(requestBody);
        return response;
    }

    @GetMapping(GET_ALL_DEPARTMENT_LIST)
    //? GET http://localhost:4080/apis/department/all
    public ResponseDto<List<GetAllDepartmentListResponseDto>> getAllDepartmentList() {
        ResponseDto<List<GetAllDepartmentListResponseDto>> response = departmentService.getAllDepartmentList();
        return response;
    }
    
    @DeleteMapping(DELETE_DEPARTMENT)
    //? Delete http://localhost:4080/apis/department/{departmentCode}
    public ResponseDto<List<DeleteDepartmentResponseDto>> deleteDepartment(@PathVariable("departmentCode") String departmentCode) {
        ResponseDto<List<DeleteDepartmentResponseDto>> response = departmentService.deleteDepartment(departmentCode);
        return response;
    }

}
