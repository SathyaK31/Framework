package com.training.bean;
//For getting values  and setting values to variables
public class UserBean {
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String login;
	
	private String password;
	

	private String profile;
	

	public UserBean() {
	}

	public UserBean(String firstname, String lastname, String email, String phone, String login, String password,String profile)  {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email=email;
		this.phone=phone;
		this.login=login;
		this.profile=profile;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return "UserBean [firstname=" + firstname + ",lastname=" + lastname+",email="+email+",phone=" + phone +",login=" + login + ", password=" + password + ",profile= "+ profile+"]";
	}
}

