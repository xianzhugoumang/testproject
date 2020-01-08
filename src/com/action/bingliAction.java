package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TBingliDAO;
import com.model.TBingli;
import com.model.TYisheng;
import com.opensymphony.xwork2.ActionSupport;

public class bingliAction extends ActionSupport
{
    	
	private int id;
	private String bianhao;
	private String xingming;
	private String xingbie;
	private String nianling;
	private String shengri;
	private String hunfou;
	private String zhuzhi;
	private String lianxi;
	private String shenfen;
	
	private String message;
	private String path;
	
	private TBingliDAO bingliDAO;
	
	//病例添加
	public String bingliAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		TYisheng yisheng = (TYisheng)request.getSession().getAttribute("user");
		
		TBingli bingli=new TBingli();
		
		bingli.setYishengId(yisheng.getId());
		bingli.setBianhao(bianhao);
		bingli.setXingming(xingming);
		bingli.setXingbie(xingbie);
		bingli.setNianling(nianling);
		bingli.setShengri(shengri);
		bingli.setHunfou(hunfou);
		bingli.setZhuzhi(zhuzhi);
		bingli.setLianxi(lianxi);
		bingli.setShenfen(shenfen);
		bingli.setDel("no");
		
		bingliDAO.save(bingli);
		
		//查询重复比例编号先不加
		
		this.setMessage("病历信息添加成功!");
		this.setPath("bingliMana.action");
		return "succeed";
	}
	
	//病例修改
	public String bingliUpd()
	{
		TBingli bingli=bingliDAO.findById(id);
		
		bingli.setXingming(xingming);
		bingli.setXingbie(xingbie);
		bingli.setNianling(nianling);
		bingli.setShengri(shengri);
		bingli.setHunfou(hunfou);
		bingli.setZhuzhi(zhuzhi);
		bingli.setLianxi(lianxi);
		bingli.setShenfen(shenfen);
		
		bingliDAO.getHibernateTemplate().update(bingli);

		this.setMessage("病历信息修改成功!");
		this.setPath("bingliMana.action");
		return "succeed";
	}
	
	//病例删除
	public String bingliDel()
	{
		String sql="update TBingli set del='yes' where id="+id;
		bingliDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("病历信息删除成功");
		this.setPath("bingliMana.action");
		return "succeed";
	}
	
	//病例管理
	public String bingliMana()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="from TBingli where del='no'";
		bianhao = bianhao==null?"":bianhao;
		if(!("".equals(bianhao)))
			sql += " and bianhao like '%"+bianhao+"%'";
		
		List bingliList=bingliDAO.getHibernateTemplate().find(sql);
		request.setAttribute("bingliList", bingliList);
		return ActionSupport.SUCCESS;
	}
	
	//病例列表
	public String bingliList()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="from TBingli where del='no'";
		bianhao = bianhao==null?"":bianhao;
		if(!("".equals(bianhao)))
			sql += " and bianhao like '%"+bianhao+"%'";
		
		List bingliList=bingliDAO.getHibernateTemplate().find(sql);
		request.setAttribute("bingliList", bingliList);
		return ActionSupport.SUCCESS;
	}
	
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getNianling() {
		return nianling;
	}

	public void setNianling(String nianling) {
		this.nianling = nianling;
	}

	public String getShengri() {
		return shengri;
	}

	public void setShengri(String shengri) {
		this.shengri = shengri;
	}

	public String getHunfou() {
		return hunfou;
	}

	public void setHunfou(String hunfou) {
		this.hunfou = hunfou;
	}

	public String getZhuzhi() {
		return zhuzhi;
	}

	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}

	public String getLianxi() {
		return lianxi;
	}

	public void setLianxi(String lianxi) {
		this.lianxi = lianxi;
	}

	public String getShenfen() {
		return shenfen;
	}

	public void setShenfen(String shenfen) {
		this.shenfen = shenfen;
	}

	public TBingliDAO getBingliDAO() {
		return bingliDAO;
	}

	public void setBingliDAO(TBingliDAO bingliDAO) {
		this.bingliDAO = bingliDAO;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
