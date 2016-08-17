package big.model;

public class InfoBean {

	/* suser */
	private String name;
	/*sroominfo */
	private String rtitle;
	private String rimage;
	private String rmemo;
	private String rlocation;
	private int rranking;
	private String rprice;
	/* srinfo */
	private int rcount;
	private int badroom;
	private int toilet;
	private String checkin;
	private String checkout;
	private String roomtype;
	/* sroption */
	private String aclass;
	private String bclass;
	private String cclass;
	private String dclass;
	private String eclass;
	
	
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
	public int getRcount() {
		return rcount;
	}
	public void setRcount(int rcount) {
		this.rcount = rcount;
	}
	public int getBadroom() {
		return badroom;
	}
	public void setBadroom(int badroom) {
		this.badroom = badroom;
	}
	public int getToilet() {
		return toilet;
	}
	public void setToilet(int toilet) {
		this.toilet = toilet;
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
	public String getAclass() {
		return aclass;
	}
	public void setAclass(String aclass) {
		this.aclass = aclass;
	}
	public String getBclass() {
		return bclass;
	}
	public void setBclass(String bclass) {
		this.bclass = bclass;
	}
	public String getCclass() {
		return cclass;
	}
	public void setCclass(String cclass) {
		this.cclass = cclass;
	}
	public String getDclass() {
		return dclass;
	}
	public void setDclass(String dclass) {
		this.dclass = dclass;
	}
	public String getEclass() {
		return eclass;
	}
	public void setEclass(String eclass) {
		this.eclass = eclass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRprice() {
		return rprice;
	}
	public void setRprice(String rprice) {
		this.rprice = rprice;
	}
	@Override
	public String toString() {
		return "InfoBean [name=" + name + ", rtitle=" + rtitle + ", rimage=" + rimage + ", rmemo=" + rmemo
				+ ", rlocation=" + rlocation + ", rranking=" + rranking + ", rprice=" + rprice + ", rcount=" + rcount
				+ ", badroom=" + badroom + ", toilet=" + toilet + ", checkin=" + checkin + ", checkout=" + checkout
				+ ", roomtype=" + roomtype + ", aclass=" + aclass + ", bclass=" + bclass + ", cclass=" + cclass
				+ ", dclass=" + dclass + ", eclass=" + eclass + "]";
	}
}
