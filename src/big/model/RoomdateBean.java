package big.model;

public class RoomdateBean {
	private int rdno;//
	private int roomno;//
	private String checkindate;//
	private String checkoutdate;//
	
	public RoomdateBean() {
		// TODO Auto-generated constructor stub
	}

	public int getRdno() {
		return rdno;
	}

	public void setRdno(int rdno) {
		this.rdno = rdno;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	public String getCheckindate() {
		return checkindate;
	}

	public void setCheckindate(String checkindate) {
		this.checkindate = checkindate;
	}

	public String getCheckoutdate() {
		return checkoutdate;
	}

	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
	}

	@Override
	public String toString() {
		return "RoomdateBean [rdno=" + rdno + ", roomno=" + roomno + ", checkindate=" + checkindate + ", checkoutdate="
				+ checkoutdate + "]";
	}
	
	
	
}
