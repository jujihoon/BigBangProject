package big.model;

//import java.util.function.Predicate;

public class RoomBean {
	private int wishno;
	private int roomno;
	private int userno;
	private String rtitle;
	private String rimage;
	private String rmemo;
	private String rprice;
	private String rlocation;
	private int rranking;
	private String rdate;
	private String confirm;

	public RoomBean() {
		// TODO Auto-generated constructor stub
	}

	
	
	

	






	public RoomBean(int wishno, int roomno, int userno, String rtitle, String rimage, String rmemo, String rprice,
			String rlocation, int rranking, String rdate, String confirm) {
		super();
		this.wishno = wishno;
		this.roomno = roomno;
		this.userno = userno;
		this.rtitle = rtitle;
		this.rimage = rimage;
		this.rmemo = rmemo;
		this.rprice = rprice;
		this.rlocation = rlocation;
		this.rranking = rranking;
		this.rdate = rdate;
		this.confirm = confirm;
	}












	@Override
	public String toString() {
		return "RoomBean [wishno=" + wishno + ", roomno=" + roomno + ", userno=" + userno + ", rtitle=" + rtitle
				+ ", rimage=" + rimage + ", rmemo=" + rmemo + ", rprice=" + rprice + ", rlocation=" + rlocation
				+ ", rranking=" + rranking + ", rdate=" + rdate + ", confirm=" + confirm + "]";
	}



	public int getWishno() {
		return wishno;
	}



	public void setWishno(int wishno) {
		this.wishno = wishno;
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

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public String getRimage() {
		return rimage;
	}

	public void setRimage(String rimage) {
		this.rimage = rimage;
	}

	public String getRmemo() {
		return rmemo;
	}

	public void setRmemo(String rmemo) {
		this.rmemo = rmemo;
	}

	public String getRprice() {
		return rprice;
	}

	public void setRprice(String rprice) {
		this.rprice = rprice;
	}

	public String getRlocation() {
		return rlocation;
	}

	public void setRlocation(String rlocation) {
		this.rlocation = rlocation;
	}

	public int getRranking() {
		return rranking;
	}

	public void setRranking(int rranking) {
		this.rranking = rranking;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

}
