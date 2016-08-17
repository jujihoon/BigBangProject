package big.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;
import big.dao.bigDao;

public class IdSearchAction implements Action{
	private String path;
	private boolean redirect;
	
	public IdSearchAction() {
		// TODO Auto-generated constructor stub
	}

	public IdSearchAction(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String birth = request.getParameter("birth");
		
		
		HashMap<Object, Object> map=new HashMap<Object,Object>();
		map.put("name", name);
		map.put("tel", tel);
		map.put("birth", birth);
		
		System.out.println(map);
		
		String email = bigDao.IdSearch(map);
		System.out.println(email);
		if(email!=null){
			path="/logPage/IdSuccess.jsp";
			request.setAttribute("email", email);
		}else{
			path="/logPage/IdSearch.jsp";
			request.setAttribute("email", "존재하는 Email이 없습니다");
		}
		
		return new ActionForWard(path , redirect);
	}
	
	
}
