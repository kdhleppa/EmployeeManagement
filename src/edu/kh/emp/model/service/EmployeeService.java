package edu.kh.emp.model.service;

import static edu.kh.emp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.emp.model.dao.EmployeeDAO;
import edu.kh.emp.model.vo.Employee;

public class EmployeeService {
	
	private EmployeeDAO dao = new EmployeeDAO();
	/**전체 사원 정보 조회 서비스
	 * 
	 */
	public List<Employee> selectAll() throws Exception{
		
		
		
		Connection conn = getConnection();
		
		List<Employee> list = dao.selectAll(conn);
		
		close(conn);
		
		return list;
	}
	/** 사원 정보 추가 서비스
	 * @param emp
	 * @return result
	 */
	public int insertEmployee(Employee emp) throws Exception{
		
		Connection conn = getConnection()	;
		
		int result = dao.insertEmployee(conn, emp);
		
		if(result > 0 ) commit(conn);
		else rollback(conn);
		
		close(conn);
		
				
		return result;
	}

}
