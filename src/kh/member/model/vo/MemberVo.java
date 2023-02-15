package kh.member.model.vo;

/**
 * 
 * @author hsj
 *-TEST_MEMBER 테이블을 이욯하여
 *0. 첫화면("/") -index.jsp include header - 로그인(login Get)/로그아웃(logout Get) 버튼 토글, nav 내정보보기(myinfo get)버튼
 *   로그인 화면 - 로그인(login post) / 회원가입(enroll get) 버튼
 *1. 회원가입("/enroll") - get enroll.jsp , post회원가입DB 다녀와서 / 이동
 *   회원가입화면 -회원가입(enroll post) 버튼
 *2. 로그인("/login") - Get login.jsp로 forward,  Post 로그인DB 다녀와서 session("lgnss")등록(이름,email,id) /이동
 *3. 로그아웃("logout") - Get 세션만료후 /이동
 *4. 내정보보기("/myinfo") - get myinfo.jsp
 *내정보보기 화면에서 하단에 수정(infoupdate get), 탈퇴 버튼
 *5. 내정보수정하기("/infoupdate get")
 *내정보보기 수정 화면에서 수정(infoupdate.post)
 */

public class MemberVo {
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}


}
