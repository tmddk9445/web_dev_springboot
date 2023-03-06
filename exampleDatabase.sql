use EXAMPLE_DB;

-- employee_number, position, name, age, 
-- gender, academic_ability, birth, 
-- tel_number, address, address_detail, join_date,
-- resignation_date, department, annual_income,
-- note

-- DDL : CREATE, ALTER, DROP 
CREATE TABLE Employee ( 
		employee_number INT auto_increment Primary KEY comment '사번', 
        position VARCHAR(10) Not Null comment '직책', 
        name VARCHAR(20) Not Null comment '이름',
        age INT Not Null comment '나이',
        gender VARCHAR(10) NOT NULL comment '성별',
        academic_ability VARCHAR(20) NOT NULL COMMENT '학력',
		birth DATE NOT NULL COMMENT '생년월일',
        tel_number VARCHAR(15)  NOT NULL UNIQUE  COMMENT '휴대전화번호',
		address TEXT NOT NULL COMMENT '상세주소',
        address_detail TEXT NOT NULL COMMENT '상세주소',
        join_date DATE NOT NULL COMMENT '입사일',
        resignation_date DATE COMMENT '퇴사일',
        department VARCHAR(45) DEFAULT '미정' COMMENT '부서',
        annual_income INT NOT NULL COMMENT '연봉',
        note TEXT COMMENT '비고'
); 

CREATE TABLE Department ( 
		department_code VARCHAR(5) Primary KEY COMMENT '부서코드', 
        name VARCHAR(100) Not Null COMMENT '부서명', 
        cheif INT Not Null COMMENT '부서장',
        tel_number VARCHAR(15) Not Null COMMENT '부서전화번호',
        
        CONSTRAINT department_fk_cheif
        FOREIGN KEY (cheif)
        REFERENCES Employee (employee_number)
); 

DROP TABLE Department;

ALTER TABLE Employee MODIFY COLUMN department VARCHAR(5) COMMENT '부서코드';

ALTER TABLE employee 
ADD CONSTRAINT employee_fk_department
FOREIGN KEY (department)
REFERENCES Department (department_code);