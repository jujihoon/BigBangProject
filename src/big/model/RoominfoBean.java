package big.model;

public class RoominfoBean {
	private int srno;//
	private int rcount;//
	private int toilet;//
	private int  badroom;//
	private String checkin;//
	private String checkout;//
	private String roomtype;//
	private int roomno;//

	public RoominfoBean() {
		// TODO Auto-generated constructor stub
	}

	public int getSrno() {
		return srno;
	}

	public void setSrno(int srno) {
		this.srno = srno;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public int getToilet() {
		return toilet;
	}

	public void setToilet(int toilet) {
		this.toilet = toilet;
	}

	public int getBadroom() {
		return badroom;
	}

	public void setBadroom(int badroom) {
		this.badroom = badroom;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	@Override
	public String toString() {
		return "RoominfoBean [srno=" + srno + ", rcount=" + rcount + ", toilet=" + toilet + ", badroom=" + badroom
				+ ", checkin=" + checkin + ", checkout=" + checkout + ", roomtype=" + roomtype + ", roomno=" + roomno
				+ "]";
	}
	
	
	
}
