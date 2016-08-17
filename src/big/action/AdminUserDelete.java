package big.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.action.Action;
import big.control.ActionForWard;
import big.dao.bigDao;

public class AdminUserDelete implements Action{
	private String path;
	private boolean redirect;
	
	public AdminUserDelete() {
		super();
	}

	public AdminUserDelete(String path, boolean redirect) {
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
			//bigDao.AdmindeleteUser(no);
			/*무결성 제약조건(CH.FK_SUSER_TO_SROOMINFO)이 위배되었습니다- 자식 레코드가 발견되었습니다 수정*/
			//System.out.println(no+" "+job);
			
		}
		
		return new ActionForWard(path, redirect);
	}
	
	
	

}
