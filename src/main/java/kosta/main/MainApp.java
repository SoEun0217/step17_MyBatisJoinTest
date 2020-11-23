package kosta.main;

import kosta.repository.EmpDAO;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("1. 사원별 사원정보와 부서정보 ");
		EmpDAO.selectEmp(0);
		EmpDAO.selectEmp(7521);
		
		System.out.println("2. 부서별 사원정보와 부서정보");
		EmpDAO.selectDept(0);
		
		System.out.println("3. 사원의 급여 등급");
		EmpDAO.selectEmpGrade(0);
		
		System.out.println("4. 각 등급별 사원의 정보 검색");
		EmpDAO.selectSalGrade(3);
	}

}
