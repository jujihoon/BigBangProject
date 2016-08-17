package big.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.action.Action;
import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.BoardBean;
import big.model.UserBean;

public class AdminUserModify implements Action{
	private String path;
	private boolean redirect;
	
	public AdminUserModify() {
		super();
	}

	public AdminUserModify(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//dao
		int no=Integer.parseInt(request.getParameter("no"));
		String job=request.getParameter("job");		
		
		
		if(job!=null && job.equals("info")){
			UserBean user=(UserBean)bigDao.selectUserInfo(no);
			String gender=user.getGender().trim();
			user.setGender(gender);
			System.out.println(user);
			request.setAttribute("info",user);
			
			path="adminFolder/adminUserMod.jsp";
		}
		if(job!=null && job.equals("modify")){
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String pass=request.getParameter("pass1");
			String gender=request.getParameter("gender");
			String phone=request.getParameter("tel");
			String birth=request.getParameter("birth");
			String power=request.getParameter("power");
			
			UserBean bean=new UserBean();
			bean.setUserno(no);
			bean.setName(name);
			bean.setEmail(email);
			bean.setPassword(pass);
			bean.setGender(gender);
			bean.setPhone(phone);
			bean.setBirth(birth);
			bean.setPower(power);
			
			System.out.println(bean);
			bigDao.updateUser(bean);
			System.out.println(bean);
			path="admin.do?cmd=adminUser";
		}
		/*request.getSession().getAttribute("user");*/
		return new ActionForWard(path, redirect);
	}
	

}
