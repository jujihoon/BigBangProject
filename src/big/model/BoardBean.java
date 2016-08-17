package big.model;
public class BoardBean {
	private int    no;
	private String writer;
	private String title;
	private String pass;
	private String contents;
	private String regdate;
	private String fileName;
	private int    hit;
	private int    ref;
	private int    step;
	private int    lev;
	private int    pnum;
	private int    reply;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
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
	public int getLev() {
		return lev;
	}
	public void setLev(int lev) {
		this.lev = lev;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	@Override
	public String toString() {
		return "BoardBean [no=" + no + ", writer=" + writer + ", title=" + title + ", pass=" + pass + ", contents="
				+ contents + ", regdate=" + regdate + ", fileName=" + fileName + ", hit=" + hit + ", ref=" + ref
				+ ", step=" + step + ", lev=" + lev + ", pnum=" + pnum + ", reply=" + reply + "]";
	}
	
	}
