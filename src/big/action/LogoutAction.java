package big.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;

public class LogoutAction implements Action{
	private String path;
	private boolean redirect;

	public LogoutAction() {
		super();
	}
	
	public LogoutAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}
	
	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		request.getSession().invalidate();
		
		return new ActionForWard(path , redirect);
	}
	
}
