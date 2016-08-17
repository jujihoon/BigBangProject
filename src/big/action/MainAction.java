package big.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;
import big.dao.bigDao;

public class MainAction implements Action{
	private String path;
	private boolean redirect;

	public MainAction() {
		super();
	}
	
	public MainAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}
	
	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<String> sido = bigDao.addrSido();
		List<String> gogun = bigDao.addrGogun();
		
		request.setAttribute("sido", sido);
		request.setAttribute("gogun", gogun);
		
		
		return new ActionForWard(path , redirect);
	}
	
}
