package kosta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpDTO {
	private int empNo;
	private String ename;
	private String job;
	private int mgr;
	private String hireDate;
	private int sal;
	private int comm;
	private int deptNo;
	
	private DeptDTO dept;
	private SalGradeDTO salGrade;
}
