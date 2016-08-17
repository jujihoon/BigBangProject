package big.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.action.Action;
import big.control.ActionForWard;
import big.dao.bigDao;

public class AdminBoardDelete implements Action{
	private String path;
	private boolean redirect;
	
	public AdminBoardDelete() {
		super();
	}

	public AdminBoardDelete(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int no=Integer.parseInt(request.getParameter("no"));
		String job=request.getParameter("job");
		if(job.equals("delete")){
			bigDao.deleteBoard(no);
			System.out.println(no+" "+job);
			
		}
		
		return new ActionForWard(path, redirect);
	}
	
	
	

}
