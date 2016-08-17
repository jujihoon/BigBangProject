 package big.model;

public class UserBean {
	private int userno;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String phone;
	private String regdate;
	private String power;
	private String birth;
	
	public UserBean(int userno, String name, String email, String password, String gender, String phone, String regdate,
			String power, String birth) {
		super();
		this.userno = userno;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.regdate = regdate;
		this.power = power;
		this.birth = birth;
	}
	public UserBean() {
		super();
	}
	@Override
	public String toString() {
		return "UserBean [userno=" + userno + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + ", phone=" + phone + ", regdate=" + regdate + ", power=" + power + ", birth="
				+ birth + "]";
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
	
	
		
}
