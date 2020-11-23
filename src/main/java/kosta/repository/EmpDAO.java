package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.DeptDTO;
import kosta.dto.EmpDTO;
import kosta.dto.SalGradeDTO;

public class EmpDAO {
	/**
	 * 사원의 부서 정보 
	 * */
	public static void selectEmp(int empno) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO>list = session.selectList("joinMapper.selectEmp", empno);
			for(EmpDTO dto:list) {
				System.out.print(dto.getEmpNo()+ " | ");
				System.out.print(dto.getEname()+ " | ");
				System.out.print(dto.getDept().getDname()+ " | ");
				System.out.println(dto.getDept().getLoc()+ " | ");
			}
			System.out.println();
		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 부서의 사원 정보
	 * */
	public static void selectDept(int deptNo) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<DeptDTO>dept = session.selectList("joinMapper.selectDept",deptNo);
			for(DeptDTO dto:dept) {
				System.out.println(dto.getDeptNo()+"번 부서의 사원 정보");
				System.out.print("부서이름 : "+dto.getDname()+ " | ");
				System.out.println("부서위치 : "+dto.getLoc()+" | ");
				for(EmpDTO emp:dto.getEmpList()) {
					System.out.print("사원번호 : "+emp.getEmpNo()+" | ");
					System.out.println("사원이름 : "+emp.getEname());
				}
			}
		} finally {
			// TODO: handle finally clause
		}
	}
	
	/**
	 * 사원의 급여 등급
	 * */
	public static void selectEmpGrade(int empNo) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO>list = session.selectList("joinMapper.selectEmpGrade", empNo);
			for(EmpDTO dto:list) {
				System.out.print(dto.getEmpNo()+ " | ");
				System.out.print(dto.getEname()+ " | ");
				System.out.print(dto.getJob()+ " | ");
				System.out.print(dto.getSal()+ " | ");
				System.out.print(dto.getSalGrade().getGrade()+ " | ");
				System.out.print(dto.getSalGrade().getLoSal()+ " | ");
				System.out.println(dto.getSalGrade().getHiSal()+ " | ");
			}
			System.out.println();
		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 각 등급별 사원의 정보 검색
	 * */
	public static void selectSalGrade(int grade) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<SalGradeDTO>list = session.selectList("joinMapper.selectSalGrade", grade);
			for(SalGradeDTO dto:list) {
				System.out.println(dto.getGrade()+"등급의 사원 정보");
				System.out.println(dto.getLoSal()+"이상 "+dto.getHiSal()+"이하의 급여");
				for(EmpDTO emp:dto.getList()) {
					System.out.print(emp.getEmpNo()+ " | ");
					System.out.print(emp.getEname()+ " | ");
					System.out.print(emp.getJob()+ " | ");
					System.out.println(emp.getSal()+ " | ");
				}
				System.out.println();
			}
				
		} finally {
			
		}
		
	}
}
