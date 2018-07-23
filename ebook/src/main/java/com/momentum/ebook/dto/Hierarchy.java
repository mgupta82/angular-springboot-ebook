package com.momentum.ebook.dto;

/**
 * Hierarchy Data Tranfer Object representing enployee name and level
 * @author mgupta82
 *
 */
public class Hierarchy {
	
	private String employeeName;
	
	private Integer level;

	public Hierarchy(String employeeName, Integer level) {
		super();
		this.employeeName = employeeName;
		this.level = level;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
