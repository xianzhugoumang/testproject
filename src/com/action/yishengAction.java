package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TKeshiDAO;
import com.dao.TYishengDAO;
import com.model.TYisheng;
import com.opensymphony.xwork2.ActionSupport;

public class yishengAction extends ActionSupport
{
    	
	private int id;
	private String loginname;
	private String loginpw;
	private int keshiId;
	private String xingming;
	private String xingbie;
	private String nianling;
	private String zhiwu;
	
	private String message;
	private String path;
	
	private TYishengDAO yishengDAO;
	private TKeshiDAO keshiDAO;
	
	public String yishengAdd()
	{
		TYisheng yisheng=new TYisheng();
		
		yisheng.setLoginname(loginname);
		yisheng.setLoginpw(loginpw);
		yisheng.setKeshiId(keshiId);
		yisheng.setXingming(xingming);
		yisheng.setXingbie(xingbie);
		yisheng.setNianling(nianling);
		yisheng.setZhiwu(zhiwu);
		yisheng.setDel("no");
		
		yishengDAO.save(yisheng);
		
		this.setMessage("医生信息添加成功!");
		this.setPath("yishengMana.action");
		return "succeed";
	}
	
	public String yishengUpd()
	{
		TYisheng yisheng=yishengDAO.findById(id);
		
		yisheng.setLoginpw(loginpw);
		yisheng.setXingming(xingming);
		yisheng.setXingbie(xingbie);
		yisheng.setNianling(nianling);
		yisheng.setZhiwu(zhiwu);
		
		yishengDAO.getHibernateTemplate().update(yisheng);

		this.setMessage("个人信息修改成功!");
		this.setPath("yishengToUpd.action");
		return "succeed";
	}
	
	public String yishengDel()
	{
		String sql="update TYisheng set del='yes' where id="+id;
		yishengDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("医生信息删除成功");
		this.setPath("yishengMana.action");
		return "succeed";
	}
	
	public String yishengToUpd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		TYisheng yisheng = (TYisheng)request.getSession().getAttribute("user");	
		
		TYisheng yishengInfo = yishengDAO.findById(yisheng.getId());
		yishengInfo.setKeshi(keshiDAO.findById(yisheng.getKeshiId()));
		
		request.setAttribute("yisheng",yishengInfo);
		return ActionSupport.SUCCESS;
	}
	
	public String yishengMana()
	{
		String sql="from TYisheng where del='no'";
		
		List yishengList=yishengDAO.getHibernateTemplate().find(sql);
		for (Object object : yishengList) {
			TYisheng yisheng = (TYisheng)object;
			yisheng.setKeshi(keshiDAO.findById(yisheng.getKeshiId()));
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("yishengList", yishengList);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpw() {
		return loginpw;
	}

	public void setLoginpw(String loginpw) {
		this.loginpw = loginpw;
	}

	public int getKeshiId() {
		return keshiId;
	}

	public void setKeshiId(int keshiId) {
		this.keshiId = keshiId;
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

	public String getZhiwu() {
		return zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	public TYishengDAO getYishengDAO() {
		return yishengDAO;
	}

	public void setYishengDAO(TYishengDAO yishengDAO) {
		this.yishengDAO = yishengDAO;
	}

	public TKeshiDAO getKeshiDAO() {
		return keshiDAO;
	}

	public void setKeshiDAO(TKeshiDAO keshiDAO) {
		this.keshiDAO = keshiDAO;
	}
}
