package big.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.BoardBean;
import big.model.RoomBean;
import big.model.UserBean;

public class WishListAction implements Action {
	private String path;
	private boolean redirect;
	
	public WishListAction() {
		super();
	}

	public WishListAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UserBean user=(UserBean)request.getSession().getAttribute("user");
		int USERNO=user.getUserno();
		String job=request.getParameter("job");
		List<RoomBean> list = null;
		
		if (job!=null && job.equals("del")) {
			int wishno=Integer.parseInt(request.getParameter("wishno"));
			bigDao.deletewish(wishno);	
			try {
				list = bigDao.selectwish(USERNO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			list = bigDao.selectwish(USERNO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		
		return new ActionForWard(path, redirect);
	}
	
	

}
