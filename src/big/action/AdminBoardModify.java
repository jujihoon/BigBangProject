package big.action;
import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;

import big.action.Action;
import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.BoardBean;
import big.model.UserBean;

public class AdminBoardModify implements Action{
	private String path;
	private boolean redirect;
	
	public AdminBoardModify() {
		super();
	}

	public AdminBoardModify(String path, boolean redirect) {
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
			BoardBean info=(BoardBean)bigDao.selectBoardInfo(no);
			request.setAttribute("info",info);
			
			path="adminFolder/adminBoardMod.jsp";
		}
		/*request.getSession().getAttribute("user");*/
		return new ActionForWard(path, redirect);
	}
	

}
