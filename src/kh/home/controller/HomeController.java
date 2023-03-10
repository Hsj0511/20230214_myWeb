package kh.home.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.board.model.servicce.BoardService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/" )
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service= new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String aaa=request.getContextPath();
		
		//2. db다녀오기
	  //,dto, dao, service, controller, view 
	  // Paging 처리
	  // 1- 총 글 개수 알아오기(db에서)
		int cnt =0; //TODO
		cnt = service.getCountBoard();
	  // 2- 한페이지에 나타날 글수 정하기
		int pageSize = 3; //보통은 10개
		
	  // 3- 페이지 수 정하기  이전<<   >>이후
		int pageBlock =2; //보통은 5개
		
	  //4- 현재페이지 나타내기
		int currentPage =1; //default 1, 클릭할때마다 변경
		
		try {
		currentPage = Integer.parseInt(aaa);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	  //5- row num 범위 정하기
		int startRnum = 0;
		int endRnum = 0;
	
		startRnum= ((currentPage-1) * pageSize) +1;
		endRnum = (startRnum + pageSize -1> cnt) ? cnt: startRnum+pageSize-1 ;
		System.out.println(startRnum +"//" + endRnum );
		
		
		request.setAttribute("boardlist", service.getBoardList(startRnum,endRnum));

	  //6- 페이지 범위정하기
		int startPageNum = 0; 
		int endPageNum = 0; 
		startPageNum = (currentPage % pageBlock ==0)
				? ((currentPage/pageBlock -1 ) *pageBlock +1)
				:((currentPage/pageBlock ) *pageBlock +1) ;
		int pageCnt = (cnt / pageSize)+(cnt%pageSize==0? 0:1);
				
		endPageNum = (startPageNum  + pageBlock -1 > pageCnt) ? pageCnt: startPageNum+pageBlock-1;
				
				
				request.setAttribute("startPageNum", startPageNum);
				request.setAttribute("endPageNum", endPageNum);
				request.setAttribute("currentPage", currentPage);
				
				
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	
	}



}
