package com.ybtx.domain;
// Generated 2017-7-28 23:24:18 by Hibernate Tools 3.4.0.CR1

/**
 * Receive generated by hbm2java
 */
public class Receive implements java.io.Serializable {

	private ReceiveId id;
	private Company company;
	private Material material;

	public Receive() {
	}

	public Receive(ReceiveId id) {
		this.id = id;
	}

	public Receive(ReceiveId id, Company company, Material material) {
		this.id = id;
		this.company = company;
		this.material = material;
	}

	public ReceiveId getId() {
		return this.id;
	}

	public void setId(ReceiveId id) {
		this.id = id;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}
