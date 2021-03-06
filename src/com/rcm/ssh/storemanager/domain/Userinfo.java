package com.rcm.ssh.storemanager.domain;
// Generated 2017-2-18 12:40:09 by Hibernate Tools 3.2.2.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Userinfo generated by hbm2java
 */
@Entity
@Table(name = "userinfo", catalog = "ssh_store")
public class Userinfo implements java.io.Serializable {

	private String id;
	private String name;
	private String password;

	@Override
	public String toString() {
		return "Userinfo [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	public Userinfo() {
	}

	public Userinfo(String name, String password) {
		this.name = name;
		this.password = password;
	}

	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false, length = 40)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
