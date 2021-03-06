package com.ybtx.domain;
// Generated 2017-7-29 17:34:30 by Hibernate Tools 3.4.0.CR1

/**
 * Use generated by hbm2java
 */
public class Use implements java.io.Serializable {

	private int useId;
	private Employee employee;
	private Material material;
	private String useDate;
	private int useAmount;

	public Use() {
	}

	public Use(int useId, Employee employee, Material material, String useDate, int useAmount) {
		this.useId = useId;
		this.employee = employee;
		this.material = material;
		this.useDate = useDate;
		this.useAmount = useAmount;
	}

	public int getUseId() {
		return this.useId;
	}

	public void setUseId(int useId) {
		this.useId = useId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public String getUseDate() {
		return this.useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public int getUseAmount() {
		return this.useAmount;
	}

	public void setUseAmount(int useAmount) {
		this.useAmount = useAmount;
	}

}
