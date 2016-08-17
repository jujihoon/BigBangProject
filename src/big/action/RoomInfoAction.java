package big.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.action.Action;
import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.BoardBean;

public class RoomInfoAction implements Action{
	private String path;
	private boolean redirect;
	
	public RoomInfoAction() {
		super();
	}

	public RoomInfoAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//dao
		int roomno=Integer.parseInt(request.getParameter("roomno"));
		System.out.println(bigDao.RselectBoardInfo(roomno));
		request.setAttribute("info",bigDao.RselectBoardInfo(roomno));
		request.setAttribute("roomno", roomno);
		request.setAttribute("reply_info",bigDao.BoardInfoReply(roomno));
		
		
		return new ActionForWard(path, redirect);
	}
	

}
