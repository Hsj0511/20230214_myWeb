package kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.board.model.vo.BoardVo;
import kh.common.jdbc.JDBCTemplate;

public class BoardDao {
	
	public int getCountBoard(Connection conn) {
		
		int	result = 0; 
		String sql =" select count(*) cnt from board" ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (Exception e) {

		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	





	public List<BoardVo> getBoardList(Connection conn) {
		List<BoardVo> result = null;
		
		String sql = "select BOARD_NUM,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME\r\n"
				+ ", BOARD_RENAME_FILENAME,BOARD_DATE,BOARD_LEVEL,BOARD_REF,BOARD_REPLY_SEQ,BOARD_READCOUNT\r\n"
				+ " from board\r\n"
				+ "  order by BOARD_REF desc,BOARD_REPLY_SEQ asc";		
		
		// ""안에는 ; 없애야 함, \r\n도 없애기
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//다중행
			result = new ArrayList<BoardVo>();
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBoardContent(rs.getString("board_Content"));
				vo.setBoardDate(rs.getDate("board_Date"));
				vo.setBoardLevel(rs.getInt("board_Level"));
				vo.setBoardNum(rs.getInt("board_Num"));
				vo.setBoardOriginalFilename(rs.getString("board_Original_Filename"));
				vo.setBoardReadcount(rs.getInt("board_Readcount"));
				vo.setBoardRef(rs.getInt("Board_Ref"));
				vo.setBoardRenameFilename(rs.getString("board_Rename_Filename"));
				vo.setBoardReplySeq(rs.getInt("board_Reply_Seq"));
				vo.setBoardTitle(rs.getString("board_Title"));
				vo.setBoardWriter(rs.getString("board_Writer"));
				result.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("dao" + result);
		return result;
	}
	
	
	
	
	public List<BoardVo> getBoardList(Connection conn, int srnum, int ernum) {
		List<BoardVo> result = null;
		
		String sql = "select BOARD_NUM,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT,BOARD_ORIGINAL_FILENAME\r\n"
				+ ", BOARD_RENAME_FILENAME,BOARD_DATE,BOARD_LEVEL,BOARD_REF,BOARD_REPLY_SEQ,BOARD_READCOUNT\r\n"
				+ " from board\r\n"
				+ "  order by BOARD_REF desc,BOARD_REPLY_SEQ asc";		
		
		// ""안에는 ; 없애야 함, \r\n도 없애기
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//다중행
			result = new ArrayList<BoardVo>();
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBoardContent(rs.getString("board_Content"));
				vo.setBoardDate(rs.getDate("board_Date"));
				vo.setBoardLevel(rs.getInt("board_Level"));
				vo.setBoardNum(rs.getInt("board_Num"));
				vo.setBoardOriginalFilename(rs.getString("board_Original_Filename"));
				vo.setBoardReadcount(rs.getInt("board_Readcount"));
				vo.setBoardRef(rs.getInt("Board_Ref"));
				vo.setBoardRenameFilename(rs.getString("board_Rename_Filename"));
				vo.setBoardReplySeq(rs.getInt("board_Reply_Seq"));
				vo.setBoardTitle(rs.getString("board_Title"));
				vo.setBoardWriter(rs.getString("board_Writer"));
				result.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}
