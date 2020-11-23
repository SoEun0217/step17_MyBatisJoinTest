package kosta.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalGradeDTO {
	private int grade;
	private int loSal;
	private int hiSal;
	
	private List<EmpDTO>list;
}
