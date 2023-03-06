package com.example.vsc_springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vsc_springboot.dto.request.humanResource.PostHumanResourceRequestDto;
import com.example.vsc_springboot.dto.response.ResponseDto;
import com.example.vsc_springboot.dto.response.humanResponse.PostHumanResourceResponseDto;
import com.example.vsc_springboot.service.HumanResourseService;

@RestController
@RequestMapping("/apis/hr")
public class HumanResourceController {
    
    @Autowired private HumanResourseService humanResourseService;

    // Post의 주된 역할
    // 클라이언트로 부터 입력값을 받고 / 결괏값을 돌려주는 것
    @PostMapping("/")
    public ResponseDto<PostHumanResourceResponseDto> postHumanResource(@Valid @RequestBody PostHumanResourceRequestDto requestBody){
        ResponseDto<PostHumanResourceResponseDto> response = humanResourseService.postHumanResource(requestBody);

        return response;
    }
    
}
