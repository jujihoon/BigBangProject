package big.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.UserBean;

public class LoginAction implements Action{
	private String path;
	private boolean redirect;
	
	public LoginAction() {
		// TODO Auto-generated constructor stub
	}
		
	public LoginAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}


	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String email=request.getParameter("email_l");
		String cp=request.getParameter("pass_l");
		
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		map.put("email", email);
		map.put("cp", cp);
		
		System.out.println(email+"::"+cp+"로그인액션");
		System.out.println(request.getRequestURL()+"로그인액션");
		
		UserBean user=bigDao.selectIdCheck(map);
		
		if(user==null){
			//아이디나 비밀번호가 없으면
			path="/Project_BigBang151130/mainPage/mainPage.jsp?check=f";
		}else{
			
			HttpSession session = request.getSession(); // 창원 : 세션처리추가 
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(60000);
			
			path="/Project_BigBang151130/mainPage/index.jsp";
			/*path = request.getRequestURL()+"";*/
		}
		return new ActionForWard(path, redirect);
	}

}
