package kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(request, response);
	      
	
	}
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login Post");
      //1
		MemberVo vo = new MemberVo();
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setEmail(request.getParameter("email"));
//		String id = request.getParameter("id");
//		String passwd = request.getParameter("passwd");
	
	  //2  db다녀오기
		MemberVo result = new MemberService().login(vo);
		if(result != null) {
			System.out.println("로그인 성공");
			request.getSession().setAttribute("lgnss", result);
		} else {
			System.out.println("로그인 실패");
		}
		response.sendRedirect(request.getContextPath()+"/");
	

		
		//3 페이지 이동 및 데이터 전달(셋 중 하나로 메소드 꼭 끝냄)
		//3-1 response.sendRedirect(request.getContextPath() + "url");   이동만, 데이터전달x
		//3-2 request.setAttribute("name1", "값");  
		//3-2 request.getRequestDispatcher("xxx.jsp").forward(request, response);  이동.데이터전달
		//3-3 out.println(값); out.flush(); out.close(); 이동x,데이터전달만
//		response.sendRedirect(request.getContextPath() + "/");
		
}
	
	



}
