package TranHoangLong_20065391;

import java.util.Date;

public class Customer {
	private String id;
	private String name;
	private String mobileno;
	private String address;
	private Date birthday;
	private String email;
	
	public Customer(String name, String mobileno, String address, Date birthday, String email) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.address = address;
		this.birthday = birthday;
		this.email = email;
	}
	public Customer(String id, String name, String mobileno, String address, Date birthday, String email) {
		super();
		this.id = id;
		this.name = name;
		this.mobileno = mobileno;
		this.address = address;
		this.birthday = birthday;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", address=" + address
				+ ", birthday=" + birthday + ", email=" + email + "]";
	}
	
}
