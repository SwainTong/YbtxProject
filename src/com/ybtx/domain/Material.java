package com.ybtx.domain;
// Generated 2017-7-29 17:34:30 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Material generated by hbm2java
 */
public class Material implements java.io.Serializable {

	private int materialId;
	private Product product;
	private String materialName;
	private int materialAmount;
	private Set receives = new HashSet(0);
	private Set uses = new HashSet(0);

	public Material() {
	}

	public Material(int materialId, Product product, String materialName, int materialAmount) {
		this.materialId = materialId;
		this.product = product;
		this.materialName = materialName;
		this.materialAmount = materialAmount;
	}

	public Material(int materialId, Product product, String materialName, int materialAmount, Set receives, Set uses) {
		this.materialId = materialId;
		this.product = product;
		this.materialName = materialName;
		this.materialAmount = materialAmount;
		this.receives = receives;
		this.uses = uses;
	}

	public int getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public int getMaterialAmount() {
		return this.materialAmount;
	}

	public void setMaterialAmount(int materialAmount) {
		this.materialAmount = materialAmount;
	}

	public Set getReceives() {
		return this.receives;
	}

	public void setReceives(Set receives) {
		this.receives = receives;
	}

	public Set getUses() {
		return this.uses;
	}

	public void setUses(Set uses) {
		this.uses = uses;
	}

}
