package big.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.BoardBean;
import big.model.PageBean;
import big.model.UserBean;

public class AdminBoardAction implements Action{
	private String path;
	private boolean redirect;
	
	public AdminBoardAction() {
		super();
	}
	
	public AdminBoardAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}
	
	public void paging(HttpServletRequest request)throws Exception{
		int totalRow =0;
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		String query=null;
		String search=null;
		try {
			query=request.getParameter("query");
			search=request.getParameter("search");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(query!=null && search!=null){//�˻�� ���Դ�
			map.put("query", query);
			map.put("search", search);
			totalRow=bigDao.getTotalRow(map);//�Ѱ���
			request.setAttribute("query", query);
			request.setAttribute("search", search);
			
		}else{
			totalRow=bigDao.getTotalRow(null);//�Ѱ���
		}

		
		//totalRow=bigDao.getTotalRow();//dao		
		
		List<BoardBean> list = null;
		int pageScale = 10;	
		 
		int totalPage = (totalRow % pageScale == 0) ? (totalRow / pageScale) : (totalRow / pageScale + 1);
		if (totalRow == 0)
			totalPage = 1;
		int currentPage = 1;
		String tempPage = "";
		tempPage = request.getParameter("page");
		try {
			currentPage = Integer.parseInt(tempPage);
		} catch (Exception e) {

		}
		int start = 1 + (currentPage - 1) * pageScale;
		int end = pageScale + (currentPage - 1) * pageScale;
		map.put("start", start);
		map.put("end", end);
		
		list = bigDao.selectBoard(map);		
		request.setAttribute("list", list);
		int currentBlock = currentPage % pageScale == 0 ? currentPage / pageScale : currentPage / pageScale + 1;
		int startPage = 1 + (currentBlock - 1) * pageScale;
		int endPage = pageScale + (currentBlock - 1) * pageScale;

		if (totalPage < endPage) {
			endPage = totalPage;
		}
		request.getSession().getAttribute("user");
		request.setAttribute("PageBean", new PageBean(currentPage, totalPage, currentBlock, startPage, endPage));
	}
	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//HashMap<Object, Object> map = new HashMap<Object, Object>();
		try {
			paging(request);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return new ActionForWard(path , redirect);
	}
	
	
}