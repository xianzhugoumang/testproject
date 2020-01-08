package com.model;

/**
 * TBingli entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TBingli implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer yishengId;
	private String bianhao;
	private String xingming;
	private String xingbie;
	private String nianling;
	private String shengri;
	private String hunfou;
	private String zhuzhi;
	private String lianxi;
	private String shenfen;
	private String del;

	// Constructors

	/** default constructor */
	public TBingli() {
	}

	/** full constructor */
	public TBingli(Integer yishengId, String bianhao, String xingming,
			String xingbie, String nianling, String shengri, String hunfou,
			String zhuzhi, String lianxi, String shenfen, String del) {
		this.yishengId = yishengId;
		this.bianhao = bianhao;
		this.xingming = xingming;
		this.xingbie = xingbie;
		this.nianling = nianling;
		this.shengri = shengri;
		this.hunfou = hunfou;
		this.zhuzhi = zhuzhi;
		this.lianxi = lianxi;
		this.shenfen = shenfen;
		this.del = del;
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

	public String getBianhao() {
		return this.bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
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

	public String getShengri() {
		return this.shengri;
	}

	public void setShengri(String shengri) {
		this.shengri = shengri;
	}

	public String getHunfou() {
		return this.hunfou;
	}

	public void setHunfou(String hunfou) {
		this.hunfou = hunfou;
	}

	public String getZhuzhi() {
		return this.zhuzhi;
	}

	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}

	public String getLianxi() {
		return this.lianxi;
	}

	public void setLianxi(String lianxi) {
		this.lianxi = lianxi;
	}

	public String getShenfen() {
		return this.shenfen;
	}

	public void setShenfen(String shenfen) {
		this.shenfen = shenfen;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}