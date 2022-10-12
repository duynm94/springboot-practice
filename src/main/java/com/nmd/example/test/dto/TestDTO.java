package com.nmd.example.test.dto;

import java.io.Serializable;

public class TestDTO implements Serializable {

	private static final long serialVersionUID = 7007818983942961059L;

	private Integer id;
	private String msg;
	private String description;

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
