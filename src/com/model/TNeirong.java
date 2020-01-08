package com.model;

/**
 * TNeirong entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TNeirong implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer jiluId;
	private Integer xiangmuId;
	private String neirong;

	private TXiangmu xiangmu;
	// Constructors

	/** default constructor */
	public TNeirong() {
	}

	/** full constructor */
	public TNeirong(Integer jiluId, Integer xiangmuId, String neirong) {
		this.jiluId = jiluId;
		this.xiangmuId = xiangmuId;
		this.neirong = neirong;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getJiluId() {
		return this.jiluId;
	}

	public void setJiluId(Integer jiluId) {
		this.jiluId = jiluId;
	}

	public Integer getXiangmuId() {
		return this.xiangmuId;
	}

	public void setXiangmuId(Integer xiangmuId) {
		this.xiangmuId = xiangmuId;
	}

	public String getNeirong() {
		return this.neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	public TXiangmu getXiangmu() {
		return xiangmu;
	}

	public void setXiangmu(TXiangmu xiangmu) {
		this.xiangmu = xiangmu;
	}
}