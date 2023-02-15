package kh.member.model.service;

import java.sql.Connection;

import static kh.common.jdbc.JDBCTemplate.*;
import kh.member.model.dao.MemberDao;
import kh.member.model.vo.MemberVo;

public class MemberService {

	public MemberVo myInfo() {
		MemberVo result = null;
		Connection conn = getConnection();
		result = new MemberDao().login(conn, vo);
		close(conn);
		return result;
	}
	
	public MemberVo login(MemberVo vo) {
		MemberVo result = null;
		Connection conn = getConnection();
		result = new MemberDao().login(conn, vo);
		close(conn);
		return result;
	}
		
		
		
	public int enroll(MemberVo vo) {
		int result = -1;
		Connection conn = getConnection();
		result = new MemberDao().enroll(conn, vo);
		close(conn);
		return result;
	}
}
