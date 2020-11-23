package kosta.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptDTO {
	private int deptNo;
	private String dname;
	private String loc;
	
	private List<EmpDTO>empList;
}
