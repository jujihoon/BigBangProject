package big.model;

public class RoomReplyBean {
	private int notino;
	private int roomno;
	private int userno;
	private String rnmemo;
	private int pnotino;
	private int prank;
	private String ndate;
	public int getNotino() {
		return notino;
	}
	public void setNotino(int notino) {
		this.notino = notino;
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
	public String getRnmemo() {
		return rnmemo;
	}
	public void setRnmemo(String rnmemo) {
		this.rnmemo = rnmemo;
	}
	public int getPnotino() {
		return pnotino;
	}
	public void setPnotino(int pnotino) {
		this.pnotino = pnotino;
	}
	public int getPrank() {
		return prank;
	}
	public void setPrank(int prank) {
		this.prank = prank;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	@Override
	public String toString() {
		return "RoomReplyBean [notino=" + notino + ", roomno=" + roomno + ", userno=" + userno + ", rnmemo=" + rnmemo
				+ ", pnotino=" + pnotino + ", prank=" + prank + ", ndate=" + ndate + "]";
	}
	
	

}
