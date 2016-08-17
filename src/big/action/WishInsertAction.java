package big.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.BoardBean;
import big.model.UserBean;

public class WishInsertAction implements Action {
	private String path;
	private boolean redirect;
	
	public WishInsertAction() {
		super();
	}

	public WishInsertAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UserBean user=(UserBean)request.getSession().getAttribute("user");
		int USERNO=user.getUserno();
		
		int ROOMNO=Integer.parseInt(request.getParameter("ROOMNO"));
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("USERNO",USERNO );
		map.put("ROOMNO",ROOMNO );
		
		try {
			bigDao.insertwish(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ActionForWard(path, redirect);
	}
	
	

}
