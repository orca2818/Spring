package ncs.r4a118.login;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class UserInfo implements Serializable {

	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String passwd;
	private String registDate;
	private String updateDate;

	public UserInfo() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
