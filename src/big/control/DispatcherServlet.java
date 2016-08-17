package big.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.action.Action;

public class DispatcherServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("euc-kr");
		String cmd=req.getParameter("cmd");
		Action action= ActionFactory.getInstance().getAction(cmd);
	    ActionForWard af=action.execute(req, res);
	    if(af.isRedirect()){
	    	res.sendRedirect(af.getPath());
	    }else{
	    	RequestDispatcher rd=req.getRequestDispatcher(af.getPath());
	    	rd.forward(req, res);
	    }		
	}
}





