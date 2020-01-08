package com.model;

/**
 * TXiangmu entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TXiangmu implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer keshiId;
	private String mingcheng;
	private String del;

	// Constructors

	/** default constructor */
	public TXiangmu() {
	}

	/** full constructor */
	public TXiangmu(Integer keshiId, String mingcheng, String del) {
		this.keshiId = keshiId;
		this.mingcheng = mingcheng;
		this.del = del;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKeshiId() {
		return this.keshiId;
	}

	public void setKeshiId(Integer keshiId) {
		this.keshiId = keshiId;
	}

	public String getMingcheng() {
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}