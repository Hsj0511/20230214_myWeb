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
 * Servlet implementation class MyInfoController
 */
@WebServlet("/myinfo")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1
		//2 나의 id에 해당하는 정보를 db에서 읽어오기
		
		String id = null;
		if(request.getSession().getAttribute("lgnss") != null) {
		 id = ((MemberVo)(request.getSession().getAttribute("lgnss"))).getId();
		}
		if(id != null) {
			request.setAttribute("myinfo", new MemberService().myInfo(id));
		
	
	//3 페이지 이동 및 데이터 전달(셋 중 하나로 메소드 꼭 끝냄)
	//3-1 response.sendRedirect(request.getContextPath() + "url");   이동만, 데이터전달x
	//3-2 request.setAttribute("name1", "값");  
	//3-2 request.getRequestDispatcher("xxx.jsp").forward(request, response);  이동.데이터전달
	//3-3 out.println(값); out.flush(); out.close(); 이동x,데이터전달만
//	response.sendRedirect(request.getContextPath() + "/");
		request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);
		
		}else {
		//방법1 : 로그인 정보가 없을때 많은 jsp페이지에서 같은 코드를 작성해야하는 불편함
		//	request.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(request, response);
		//방법2 : 로그인 정보가 없을때 하나의 error page를 만들어줌

			request.setAttribute("errorMsg", "로그인되지 않아 정보를 확인할 수 없습니다");
			request.getRequestDispatcher("/WEB-INF/view/error/errorLogin.jsp").forward(request, response);
		}

	}
}