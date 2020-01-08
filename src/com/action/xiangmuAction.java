package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TKeshiDAO;
import com.dao.TXiangmuDAO;
import com.model.TKeshi;
import com.model.TXiangmu;
import com.model.TYisheng;
import com.opensymphony.xwork2.ActionSupport;

public class xiangmuAction extends ActionSupport
{
    	
	private int id;
	private int keshiId;
	private String mingcheng;
	
	private String message;
	private String path;
	
	private TXiangmuDAO xiangmuDAO;
	private TKeshiDAO keshiDAO;
	
	public String xiangmuAdd()
	{
		TXiangmu xiangmu=new TXiangmu();
		
		xiangmu.setKeshiId(keshiId);
		xiangmu.setMingcheng(mingcheng);
		xiangmu.setDel("no");
		
		xiangmuDAO.save(xiangmu);
		
		this.setMessage("科室项目添加成功!");
		this.setPath("xiangmuMana.action?keshiId="+keshiId);
		return "succeed";
	}
	
	public String xiangmuUpd()
	{
		TXiangmu xiangmu=xiangmuDAO.findById(id);
		
		xiangmu.setMingcheng(mingcheng);
		
		xiangmuDAO.getHibernateTemplate().update(xiangmu);

		this.setMessage("科室项目修改成功!");
		this.setPath("xiangmuMana.action?keshiId="+keshiId);
		return "succeed";
	}
	
	public String xiangmuDel()
	{
		String sql="update TXiangmu set del='yes' where id="+id;
		xiangmuDAO.getHibernateTemplate().bulkUpdate(sql);
		
		this.setMessage("科室项目删除成功!");
		this.setPath("xiangmuMana.action?keshiId="+keshiId);
		return "succeed";
	}
	
	public String xiangmuMana()
	{
		String sql="from TXiangmu where del='no' and keshi_id="+keshiId;
		
		List xiangmuList=xiangmuDAO.getHibernateTemplate().find(sql);
		
		TKeshi keshi = keshiDAO.findById(keshiId);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xiangmuList", xiangmuList);
		request.put("keshi", keshi);
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

	public int getKeshiId() {
		return keshiId;
	}

	public void setKeshiId(int keshiId) {
		this.keshiId = keshiId;
	}

	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public TXiangmuDAO getXiangmuDAO() {
		return xiangmuDAO;
	}

	public void setXiangmuDAO(TXiangmuDAO xiangmuDAO) {
		this.xiangmuDAO = xiangmuDAO;
	}

	public TKeshiDAO getKeshiDAO() {
		return keshiDAO;
	}

	public void setKeshiDAO(TKeshiDAO keshiDAO) {
		this.keshiDAO = keshiDAO;
	}
}
