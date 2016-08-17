package big.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.UserBean;

public class InfoModifyAction implements Action{
	private String path;
	private boolean redirect;
	
	public InfoModifyAction() {
		super();
	}
	public InfoModifyAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}
	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub		
		
		String job=request.getParameter("job");
		
		
		UserBean getuser=(UserBean) request.getSession().getAttribute("user");
		String gender=getuser.getGender().trim();
		getuser.setGender(gender);
		request.setAttribute("info",getuser);
		
		if(job!=null && job.equals("modify")){
			Integer no=Integer.parseInt(request.getParameter("no"));
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String pass=request.getParameter("pass1");
			 gender=request.getParameter("gender");
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
			
			UserBean user=(UserBean)bigDao.selectUserInfo(no);
			gender=user.getGender().trim();
			user.setGender(gender);
			System.out.println(user);
			request.setAttribute("info",user);
			
		}
		return new ActionForWard(path,redirect);
		
	}
}
