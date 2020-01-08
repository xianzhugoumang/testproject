package com.model;

import java.util.List;

/**
 * TJilu entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TJilu implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer yishengId;
	private Integer bingliId;
	private String shijian;
	private String del;
	
	private TBingli bingli;
	private List neirongList;
	

	// Constructors

	/** default constructor */
	public TJilu() {
	}

	/** full constructor */
	public TJilu(Integer yishengId, Integer bingliId, String shijian) {
		this.yishengId = yishengId;
		this.bingliId = bingliId;
		this.shijian = shijian;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYishengId() {
		return this.yishengId;
	}

	public void setYishengId(Integer yishengId) {
		this.yishengId = yishengId;
	}

	public Integer getBingliId() {
		return this.bingliId;
	}

	public void setBingliId(Integer bingliId) {
		this.bingliId = bingliId;
	}

	public String getShijian() {
		return this.shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
	}
	
	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public TBingli getBingli() {
		return bingli;
	}

	public void setBingli(TBingli bingli) {
		this.bingli = bingli;
	}

	public List getNeirongList() {
		return neirongList;
	}

	public void setNeirongList(List neirongList) {
		this.neirongList = neirongList;
	}
}