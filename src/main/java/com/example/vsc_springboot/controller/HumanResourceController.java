package com.example.vsc_springboot.controller;

import com.example.vsc_springboot.common.constant.ApiMappingPattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vsc_springboot.dto.request.humanResource.PostHumanResourceRequestDto;
import com.example.vsc_springboot.dto.response.ResponseDto;
import com.example.vsc_springboot.dto.response.humanResponse.GetHumanResourceResponseDto;
import com.example.vsc_springboot.dto.response.humanResponse.PostHumanResourceResponseDto;
import com.example.vsc_springboot.service.HumanResourceService;

@RestController
@RequestMapping(ApiMappingPattern.HR)
public class HumanResourceController {
    
    @Autowired private HumanResourceService humanResourceService;

    private static final String POST_HUMAN_RESOURCE = "/";
    private static final String GET_HUMAN_RESOURCE = "/{employeeNumber}";

    @PostMapping(POST_HUMAN_RESOURCE)
    //? POST http://localhost:4040/apis/hr/
    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(@Valid @RequestBody PostHumanResourceRequestDto requestBody) {
        ResponseDto<PostHumanResourceResponseDto> response = 
            humanResourceService.postHumanResource(requestBody);
        return response;
    }

    @GetMapping(GET_HUMAN_RESOURCE)
    //? GET http://localhost:4040/apis/hr/사번
    public ResponseDto<GetHumanResourceResponseDto> getHumanResource(@PathVariable("employeeNumber") int employeeNumber) {
        ResponseDto<GetHumanResourceResponseDto> response =
            humanResourceService.getHumanResource(employeeNumber);
        return response;
    }
    
}
