package big.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;
import big.dao.bigDao;

public class IdCheckAction implements Action{
	private String path;
	private boolean redirect;
	
	public IdCheckAction() {
		super();
	}

	public IdCheckAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String id = bigDao.selectId(email);
		String flag ="";
		if(id==null){
			flag ="가능";
			request.setAttribute("email", email);
		}
		else if(id!=null){
			flag="불가능";
		}
		request.setAttribute("flag", flag);
		
		return new ActionForWard(path,redirect);
	}
	
	
}
