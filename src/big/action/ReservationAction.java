package big.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import big.control.ActionForWard;
import big.dao.bigDao;
import big.model.ReservationBean;

public class ReservationAction implements Action{
	private String path;
	private boolean redirect;
	
	public ReservationAction() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	
	public ReservationAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}



	@Override
	public ActionForWard execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		String checkin=request.getParameter("checkin");
		String checkout=request.getParameter("checkout");
		String etc=request.getParameter("etc");
		String pay=request.getParameter("pay");
		String moo=request.getParameter("moo");
		String card=request.getParameter("card");
		String cardnumber=request.getParameter("cardnumber");
		String mangi=request.getParameter("mangi");
		int userno=0;
		int roomno=0;
		try {
			userno=Integer.parseInt(request.getParameter("userno"));
			roomno=Integer.parseInt(request.getParameter("roomno"));			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String money=(request.getParameter("money"));
		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd", Locale.KOREA );
		Date currentTime = new Date ( );
		String mTime = mSimpleDateFormat.format ( currentTime );
		
		int reno=bigDao.addReserve();
		
		System.out.println(new ReservationBean(reno, etc, checkin, pay, mTime, roomno, userno, checkout, moo, cardnumber, mangi, money));
		
		ReservationBean bean=new ReservationBean(reno, etc, checkin, pay, mTime, roomno, userno, checkout, moo, cardnumber, mangi, money);
		bigDao.insertReservation(bean);
		
		return new ActionForWard(path, redirect);
	}

}
