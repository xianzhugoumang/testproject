package com.model;

/**
 * TYisheng entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TYisheng implements java.io.Serializable {

	// Fields

	private Integer id;
	private String loginname;
	private String loginpw;
	private Integer keshiId;
	private String xingming;
	private String xingbie;
	private String nianling;
	private String zhiwu;
	private String del;

	private TKeshi keshi;
	// Constructors

	/** default constructor */
	public TYisheng() {
	}

	/** full constructor */
	public TYisheng(String loginname, String loginpw, Integer keshiId,
			String xingming, String xingbie, String nianling, String zhiwu,
			String del) {
		this.loginname = loginname;
		this.loginpw = loginpw;
		this.keshiId = keshiId;
		this.xingming = xingming;
		this.xingbie = xingbie;
		this.nianling = nianling;
		this.zhiwu = zhiwu;
		this.del = del;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpw() {
		return this.loginpw;
	}

	public void setLoginpw(String loginpw) {
		this.loginpw = loginpw;
	}

	public Integer getKeshiId() {
		return this.keshiId;
	}

	public void setKeshiId(Integer keshiId) {
		this.keshiId = keshiId;
	}

	public String getXingming() {
		return this.xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getXingbie() {
		return this.xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getNianling() {
		return this.nianling;
	}

	public void setNianling(String nianling) {
		this.nianling = nianling;
	}

	public String getZhiwu() {
		return this.zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

	public TKeshi getKeshi() {
		return keshi;
	}

	public void setKeshi(TKeshi keshi) {
		this.keshi = keshi;
	}
}