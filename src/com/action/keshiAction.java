package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TKeshiDAO;
import com.model.TKeshi;
import com.opensymphony.xwork2.ActionSupport;

public class keshiAction extends ActionSupport
{
    	
	private int id;
	private String mingcheng;
	
	private String message;
	private String path;
	
	private TKeshiDAO keshiDAO;
	
	public String keshiAdd()
	{
		TKeshi keshi=new TKeshi();
		
		keshi.setMingcheng(mingcheng);
		keshi.setDel("no");
		
		keshiDAO.save(keshi);
		
		this.setMessage("科室信息添加成功!");
		this.setPath("keshiMana.action");
		return "succeed";
	}
	
	public String keshiUpd()
	{
		TKeshi keshi = keshiDAO.findById(id);
		keshi.setMingcheng(mingcheng);
		
		keshiDAO.getHibernateTemplate().update(keshi);

		this.setMessage("科室信息修改成功!");
		this.setPath("keshiMana.action");
		return "succeed";
	}
	
	public String keshiDel()
	{
		String sql="update TKeshi set del='yes' where id="+id;
		keshiDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("科室信息删除成功");
		this.setPath("keshiMana.action");
		return "succeed";
	}
	
	public String keshiMana()
	{
		String sql="from TKeshi where del='no'";
		
		List keshiList=keshiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("keshiList", keshiList);
		return ActionSupport.SUCCESS;
	}
	
	public String keshiSele()
	{
		String sql="from TKeshi where del='no'";
		
		List keshiList=keshiDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("keshiList", keshiList);
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

	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public TKeshiDAO getKeshiDAO() {
		return keshiDAO;
	}

	public void setKeshiDAO(TKeshiDAO keshiDAO) {
		this.keshiDAO = keshiDAO;
	}
}
