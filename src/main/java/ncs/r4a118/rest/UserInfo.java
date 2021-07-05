package ncs.r4a118.rest;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {
	@Id
	private int id;
	private String name;
	private String passwd;
	@Column(name="registdate")
	private String registDate;
	@Column(name="updatedate")
	private String updateDate;
}
