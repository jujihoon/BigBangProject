package big.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.action.Action;
import big.control.ActionForWard;
import big.dao.bigDao;

public class BoardHitAction implements Action{
	private String path;
	private boolean redirect;
	
	public BoardHitAction() {
		super();
	}

	public BoardHitAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//dao.
		int no=Integer.parseInt(request.getParameter("no"));
		String job=request.getParameter("job");
		path+="&no="+no+"&job="+job;
		bigDao.updateHit(no);
		//System.out.println(path);
		return new ActionForWard(path, redirect);
	}
	

}
