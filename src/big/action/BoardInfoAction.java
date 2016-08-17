package big.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.action.Action;
import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.BoardBean;

public class BoardInfoAction implements Action{
	private String path;
	private boolean redirect;
	
	public BoardInfoAction() {
		super();
	}

	public BoardInfoAction(String path, boolean redirect) {
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
		request.setAttribute("info",bigDao.selectBoardInfo(no));		
		request.setAttribute("reply",bigDao.selectRePly(no));
		if(job!=null && job.equals("info")){
			path="boardFolder/infoPage.jsp";
		}
		if(job!=null && job.equals("modify")){
			path="boardFolder/modify.jsp?job=modify";
		}
		request.getSession().getAttribute("user");
		return new ActionForWard(path, redirect);
	}
	

}
