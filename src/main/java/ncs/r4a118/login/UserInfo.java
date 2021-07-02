package ncs.r4a118.login;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class UserInfo implements Serializable {

	private int id;
	@NotEmpty
	//@Length(min = 5,max = 20)
	private String name;
	@NotEmpty
	private String passwd;
	private String registDate;
	private String updateDate;

	public UserInfo() {}

	public UserInfo(@NotEmpty String name, @NotEmpty String passwd) {
		super();
		this.name = name;
		this.passwd = passwd;
	}


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
