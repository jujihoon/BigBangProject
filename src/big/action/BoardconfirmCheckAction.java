package big.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.action.Action;
import big.control.ActionForWard;
import big.dao.bigDao;

public class BoardconfirmCheckAction implements Action{
	private String path;
	private boolean redirect;

	public BoardconfirmCheckAction() {
		super();
	}
	public BoardconfirmCheckAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}
	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String job=request.getParameter("job");
		int no=Integer.parseInt(request.getParameter("no"));
		String page=request.getParameter("page");
		//System.out.println(job+no+page);
		String cp=request.getParameter("pass");
		
		try {
			String dbPass=bigDao.getPass(no);
			if(dbPass!=null&&dbPass.equals(cp)){
				if(job.equals("delete")){
					path="boarddelete.do?cmd=boarddelete&no="+no;
				}else if(job.equals("modify")){
					path="boardInfo.do?cmd=boardInfo&no="+no+"&job=modify";
				}
			}else{//´Ù¸£¸é 
				path="jsp/confirm.jsp?no="+no+"&job="+job;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ActionForWard(path, redirect);
	}
	

}
