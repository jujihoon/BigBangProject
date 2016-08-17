package big.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.UserBean;

public class JoinAction implements Action{
	private String path;
	private boolean redirect;
	private static int count=1;
	
	public JoinAction() {
		// TODO Auto-generated constructor stub
	}
		
	public JoinAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}


	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("passl");
		String gender=request.getParameter("gender");
		String birth=request.getParameter("birthl");
		String power=request.getParameter("power");
		String phone=request.getParameter("phone");
		
		int no = bigDao.selectSeq();
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

		
		
		bigDao.joinDao(bean);
		

		return new ActionForWard(path, redirect);
	}

}
