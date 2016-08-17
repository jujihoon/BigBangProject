package big.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.action.Action;
import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.ReplyBean;

public class BoardReplyInsertAction implements Action{
	private String path;
	private boolean redirect;
	
	public BoardReplyInsertAction() {
		super();
	}

	public BoardReplyInsertAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ReplyBean bean = new ReplyBean();
		try {
			bean.setNo(bigDao.selectSequence());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		bean.setId(request.getParameter("id"));
		bean.setContents(request.getParameter("contents"));
		bean.setInfoPk(Integer.parseInt(request.getParameter("infoPk")));
		String job=request.getParameter("job");
		if(job.equals("new")){
			bean.setRef(bean.getNo());
			bean.setPnum(bean.getNo());
		}else{
			bean.setPnum(Integer.parseInt(request.getParameter("pnum")));
			bean.setRef(Integer.parseInt(request.getParameter("ref")));
		}
		//[]------------------------
				//  []ÀÌ¿µ¾Ö -------
				//  []
				//NO  REF  PNUM  REPLY  INFOPK
				// 1   1    1      1      50
				// 2   1    1      0      50
				// 3   3    3      1      57
				// 4   3    3      1      57
				// 5   3    4      0      57 
		System.out.println(bean+job);
		bigDao.replyAdd(bean);
		
//		System.out.println(id+" "+job+" "+pnum+" "+infoPk);
		path+="&job=info&no="+bean.getInfoPk();
		return new ActionForWard(path, redirect);
	}
	
	

}
