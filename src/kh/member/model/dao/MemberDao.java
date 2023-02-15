package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static kh.common.jdbc.JDBCTemplate.*;
import kh.member.model.vo.MemberVo;

public class MemberDao {
	//내정보보기
	public MemberVo myInfo(Connection conn, String id) {
		MemberVo result =null;
		String sql ="select ID, NAME, EMAIL from test_member";
		sql+= " where id=? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);     //물음표 채우기
			rs = pstmt.executeQuery();
			if(rs.next()) {   //rs있다면 값 넣기
				result = new MemberVo();
				result.setEmail(rs.getString("email"));
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(result);
			close(rs);
			close(pstmt);
		}
		return result;
		
		
	}
	
	
	
	//로그인
	public MemberVo login(Connection conn, MemberVo vo) {
		MemberVo result = null;
		String sql ="select ID, NAME, EMAIL from test_member";
		sql+= " where id=? and passwd=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());     //물음표 채우기
			pstmt.setString(2, vo.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {   //rs있다면 값 넣기
				result = new MemberVo();
				result.setEmail(rs.getString("email"));
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(result);
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}

	//회원가입
	public int enroll(Connection conn, MemberVo vo) {
		int result = -1;
		String query ="insert into Test_Member values ";
		query += " (?,?,?,?)";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			//? 에 채워주기
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			
			//pstmt 실행
			//결과값 result에 대입
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("DAO return: "+result);
		return result;
		
	}
}
