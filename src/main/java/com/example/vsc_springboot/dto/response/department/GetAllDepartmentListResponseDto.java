package com.example.vsc_springboot.dto.response.department;

import java.util.ArrayList;
import java.util.List;

import com.example.vsc_springboot.entity.DepartmentEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllDepartmentListResponseDto {
    
    //? 부서 코드
    private String departmentCode;
    //? 부서명
    private String name;
    //? 부서장
    private int chief;
    //? 부서전화번호
    private String telNumber;

    public GetAllDepartmentListResponseDto (DepartmentEntity departmentEntity) {
        this.departmentCode = departmentEntity.getDepartmentCode();
        this.name = departmentEntity.getName();
        this.chief = departmentEntity.getChief();
        this.telNumber = departmentEntity.getTelNumber();

    }

    public static List<GetAllDepartmentListResponseDto> copyList(List<DepartmentEntity> departmentEntities) {
        
        List<GetAllDepartmentListResponseDto> result = new ArrayList<GetAllDepartmentListResponseDto>();
        
        for (DepartmentEntity departmentEntity : departmentEntities) {
            GetAllDepartmentListResponseDto item = new GetAllDepartmentListResponseDto(departmentEntity);
            result.add(item);
        }

        return result;
    }

    
}
