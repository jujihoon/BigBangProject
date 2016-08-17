package big.model;

public class ReservationBean {
	private int reno;
	private String rememo;
	private String recheckin;
	private String repay;
	private String resysdate;
	private int roomno;
	private int userno;
	private String recheckout;
	private String paymethod;
	private String paynumber;
	private String mangi;
	private String money;
	


	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getPaynumber() {
		return paynumber;
	}

	public void setPaynumber(String paynumber) {
		this.paynumber = paynumber;
	}

	public String getMangi() {
		return mangi;
	}

	public void setMangi(String mangi) {
		this.mangi = mangi;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public ReservationBean() {
		// TODO Auto-generated constructor stub
	}
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
	}
	public String getRememo() {
		return rememo;
	}
	public void setRememo(String rememo) {
		this.rememo = rememo;
	}
	public String getRecheckin() {
		return recheckin;
	}
	public void setRecheckin(String recheckin) {
		this.recheckin = recheckin;
	}
	public String getRepay() {
		return repay;
	}
	public void setRepay(String repay) {
		this.repay = repay;
	}
	public String getResysdate() {
		return resysdate;
	}
	public void setResysdate(String resysdate) {
		this.resysdate = resysdate;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getRecheckout() {
		return recheckout;
	}
	public void setRecheckout(String recheckout) {
		this.recheckout = recheckout;
	}

	@Override
	public String toString() {
		return "ReservationBean [reno=" + reno + ", rememo=" + rememo + ", recheckin=" + recheckin + ", repay=" + repay
				+ ", resysdate=" + resysdate + ", roomno=" + roomno + ", userno=" + userno + ", recheckout="
				+ recheckout + ", paymethod=" + paymethod + ", paynumber=" + paynumber + ", mangi=" + mangi + ", money="
				+ money + "]";
	}

	public ReservationBean(int reno, String rememo, String recheckin, String repay, String resysdate, int roomno,
			int userno, String recheckout, String paymethod, String paynumber, String mangi, String money) {
		super();
		this.reno = reno;
		this.rememo = rememo;
		this.recheckin = recheckin;
		this.repay = repay;
		this.resysdate = resysdate;
		this.roomno = roomno;
		this.userno = userno;
		this.recheckout = recheckout;
		this.paymethod = paymethod;
		this.paynumber = paynumber;
		this.mangi = mangi;
		this.money = money;
	}

	
	
}
