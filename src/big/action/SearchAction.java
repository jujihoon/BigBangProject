package big.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.*;

public class SearchAction implements Action {
	private String path;
	private boolean redirect;

	public SearchAction() {
		super();
	}

	public SearchAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	public void paging(HttpServletRequest request) throws Exception {
		
		int totalRow = 0;
		int pageScale = 9;
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		List<RoomBean> list = null;
		String[] alist = null;
		String[] blist= null;
		String[] clist= null;
		String[] dlist= null;
		String[] elist= null;
		
		String a = null;
		String b = null;
		String c = null;
		String d = null;
		String e = null;
		
		
		
		int currentPage = 1;
		String tempPage = "";
		String flag = null;
		flag=request.getParameter("flag");
		
		System.out.println(flag);
		
		if(!flag.equals("main")){
		try {
			
			tempPage = request.getParameter("page");
			if(tempPage.equals("")||tempPage==null){
				tempPage="1";
			}
			currentPage = Integer.parseInt(tempPage);
			a=request.getParameter("aclass");
			b=request.getParameter("bclass");
			c=request.getParameter("cclass");
			d=request.getParameter("dclass");
			e=request.getParameter("eclass");
			System.out.println("a:"+a+"b:"+b+"c:"+c+"d:"+d+"e:"+e);
			//System.out.println("a="+a+"b="+b+"c="+c+"d="+d+"e="+e);
			if(!a.equals("")){
				alist=a.split("#");
			}
			if(!b.equals("")){
				blist=b.split("#");
			}
			if(!c.equals("")){
				clist=c.split("#");
			}
			if(!d.equals("")){
				dlist=d.split("#");
			}
			if(!e.equals("")){
				elist=e.split("#");
			}
			
			
			
		} catch (Exception ee) {			
			ee.printStackTrace();
		}
		}else{
			
		}
		
		int start = 1 + (currentPage - 1) * pageScale;
		int end = pageScale + (currentPage - 1) * pageScale;
		map.put("start", start);
		map.put("end", end);
		map.put("aclass", alist);
		map.put("bclass", blist);
		map.put("cclass", clist);
		map.put("dclass", dlist);
		map.put("eclass", elist);
		
		
		
		String sido = request.getParameter("sido");
		String googoon = request.getParameter("googoon");
		String inwon = request.getParameter("inwon");		
		String date;
		
		if(request.getParameter("date")==null){
			Date todate=new Date();
			date = todate.toString();
			
		}else{
			date = request.getParameter("date");
		}
		if(date.length()>2){
			date = date.substring(2, date.length());
		}
		if(!inwon.equals("¸ðµÎ")){
			inwon = inwon.substring(0, 1);
			map.put("inwon", inwon);
			
		}else {
			map.put("inwon", inwon);
			
		}
		
		map.put("sido", sido);
		map.put("googoon", googoon);
		map.put("date", date);
		System.out.println(map);
		totalRow = bigDao.RgetTotalRow(map);
		System.out.println(totalRow);
		
		int totalPage = (totalRow % pageScale == 0) ? (totalRow / pageScale) : (totalRow / pageScale + 1);
		if (totalRow == 0)
			totalPage = 1;
		
		request.setAttribute("serach", map);
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		request.setAttribute("c", c);
		request.setAttribute("d", d);
		request.setAttribute("e", e);
		
		
		list = bigDao.RselectBoard(map);
		
		//list.get(0).getRimage();		
		System.out.println(list);
		request.setAttribute("list", list);
		
		int currentBlock = currentPage % pageScale == 0 ? currentPage / pageScale : currentPage / pageScale + 1;
		int startPage = 1 + (currentBlock - 1) * pageScale;
		int endPage = pageScale + (currentBlock - 1) * pageScale;

		if (totalPage < endPage) {
			
			endPage = totalPage;
		}
		
		request.setAttribute("pageBean", new PageBean(currentPage, totalPage, currentBlock, startPage, endPage));
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			paging(request);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return new ActionForWard(path, redirect);
	}

}
