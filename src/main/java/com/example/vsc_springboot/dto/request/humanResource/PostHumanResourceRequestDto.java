package com.example.vsc_springboot.dto.request.humanResource;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostHumanResourceRequestDto {
        //? 직급
        @NotBlank
        @Length(min=0, max=5)
        private String position;

        //? 이름
        @NotBlank
        @Length(min=0, max=10)
        private String name;

        //? 나이
        @Range(min=0, max=120)
        private int age;
        
        //? 성별
        @NotBlank
        @Length(min=0, max=5)
        private String gender;

        //? 학력
        @NotBlank
        @Length(min=0, max=10)
        private String academicAbility;

        //? 생년월일
        @NotBlank
        private String birth;

        //? 휴대전화번호
        @NotBlank
        private String telNumber;

        //? 주소
        @NotBlank
        private String Address;

        //? 상세주소
        @NotBlank
        private String AddressDetail;

        //? 입사일
        @NotBlank
        private String joinDate;

        //? 퇴사일
        private String resignationDate;

        //? 부서 코드
        @NotBlank
        @Length(min=0, max=5)
        private String department;

        //? 연봉
        @Min(0)
        private int annualIncome;

        //? 비고
        private String note;
}
