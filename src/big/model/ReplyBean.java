package big.model;

public class ReplyBean {
	private int    no;
	private String id;
	private String contents;
	private int    ref;
	private int    step;
	private int    pnum;
	private int    infoPk;
	private int    reply;
	private String regdate;
	private String pnumId;
	
	
	
	public String getPnumId() {
		return pnumId;
	}
	public void setPnumId(String pnumId) {
		this.pnumId = pnumId;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getInfoPk() {
		return infoPk;
	}
	public void setInfoPk(int infoPk) {
		this.infoPk = infoPk;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "ReplyBean [no=" + no + ", id=" + id + ", contents=" + contents + ", ref=" + ref + ", step=" + step
				+ ", pnum=" + pnum + ", infoPk=" + infoPk + ", reply=" + reply + ", regdate=" + regdate + "]";
	}
	
	
	
	
	

}
