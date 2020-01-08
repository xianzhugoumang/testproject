package com.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.TBingliDAO;
import com.dao.TJiluDAO;
import com.dao.TNeirongDAO;
import com.dao.TXiangmuDAO;
import com.model.TJilu;
import com.model.TNeirong;
import com.model.TXiangmu;
import com.model.TYisheng;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DateUtils;

public class jiluAction extends ActionSupport
{
    	
	private int id;
	private int bingliId;
	private String xiangmuIds;
	
	private String message;
	private String path;
	
	private TXiangmuDAO xiangmuDAO;
	private TBingliDAO bingliDAO;
	private TJiluDAO jiluDAO;
	private TNeirongDAO neirongDAO;
	
	//跳转到诊疗记录添加
	public String jiluToAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		TYisheng yisheng = (TYisheng)request.getSession().getAttribute("user");
		
		String sql="from TXiangmu where del='no' and keshi_id="+yisheng.getKeshiId();
		
		List xiangmuList=xiangmuDAO.getHibernateTemplate().find(sql);
		
		request.setAttribute("bingli", bingliDAO.findById(bingliId));
		request.setAttribute("xiangmuList", xiangmuList);
		request.setAttribute("xiangmuIds", getXiangmuIds(xiangmuList));
		return ActionSupport.SUCCESS;
	}
	
	//跳转到诊疗记录添加
	public String jiluToUpd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String sql="from TNeirong where jilu_id="+id;
		
		List neirongList=neirongDAO.getHibernateTemplate().find(sql);
		for (Object object : neirongList) {
			TNeirong neirong = (TNeirong)object;
			neirong.setXiangmu(xiangmuDAO.findById(neirong.getXiangmuId()));
		}
		
		request.setAttribute("jilu", jiluDAO.findById(id));
		request.setAttribute("bingli", bingliDAO.findById(bingliId));
		request.setAttribute("neirongList", neirongList);
		request.setAttribute("xiangmuIds", getXiangmuIdsByNeirong(neirongList));
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String jiluDel()
	{
		TJilu jilu = jiluDAO.findById(id);
		jilu.setDel("yes");
		
		jiluDAO.getHibernateTemplate().update(jilu);
		
		this.setMessage("诊疗记录删除成功!");
		this.setPath("jiluMana.action");
		return "succeed";
	}
	public String jiluUpd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		xiangmuIds = request.getParameter("xiangmuIds");
		String[] arrIds = xiangmuIds.split(",");
		for(int i=0;i<arrIds.length;i++)
		{
			String txtNr = request.getParameter("txt_"+arrIds[i]);
			
			String sql = "from TNeirong where xiangmu_id="+arrIds[i];
			TNeirong neirong = (TNeirong)neirongDAO.getHibernateTemplate().find(sql).get(0);
			
			neirong.setNeirong(txtNr);
			neirongDAO.getHibernateTemplate().update(neirong);
		}
		
		this.setMessage("诊疗记录修改成功!");
		this.setPath("jiluMana.action");
		return "succeed";
	}
	public String jiluAdd()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		TYisheng yisheng = (TYisheng)request.getSession().getAttribute("user");		
		
		int jiluId = 0;
		
		Session session = jiluDAO.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		TJilu jilu = new TJilu();
		jilu.setYishengId(yisheng.getId());
		jilu.setBingliId(bingliId);
		jilu.setShijian(DateUtils.formatDate2Str(new Date(), "yyyy-MM-dd HH:mm:ss"));
		jilu.setDel("no");
		session.save(jilu);
		jiluId = jilu.getId();
		tx.commit();
		session.close();
		
		xiangmuIds = request.getParameter("xiangmuIds");
		String[] arrIds = xiangmuIds.split(",");
		for(int i=0;i<arrIds.length;i++)
		{
			String txtNr = request.getParameter("txt_"+arrIds[i]);
			
			TNeirong neirong = new TNeirong();
			neirong.setJiluId(jiluId);
			neirong.setXiangmuId(Integer.parseInt(arrIds[i]));
			neirong.setNeirong(txtNr);
			neirongDAO.save(neirong);
		}
		
		this.setMessage("诊疗记录添加成功!");
		this.setPath("jiluMana.action");
		return "succeed";
	}
	
	
	public String jiluMana()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		TYisheng yisheng = (TYisheng)request.getSession().getAttribute("user");		
		
		String sql = "from TJilu where del='no' and yisheng_id="+yisheng.getId();
		List jiluList = jiluDAO.getHibernateTemplate().find(sql);
		for (Object object : jiluList) {
			TJilu jilu = (TJilu)object;
			jilu.setBingli(bingliDAO.findById(jilu.getBingliId()));
			
			sql = "from TNeirong where jilu_id="+jilu.getId();
			List neirongList = xiangmuDAO.getHibernateTemplate().find(sql);
			for (Object object2 : neirongList) {
				TNeirong neirong = (TNeirong)object2;
				neirong.setXiangmu(xiangmuDAO.findById(neirong.getXiangmuId()));
			}
			jilu.setNeirongList(neirongList);
		}
		
		request.setAttribute("jiluList", jiluList);
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

	public String getXiangmuIds() {
		return xiangmuIds;
	}

	public int getBingliId() {
		return bingliId;
	}

	public void setBingliId(int bingliId) {
		this.bingliId = bingliId;
	}

	public void setXiangmuIds(String xiangmuIds) {
		this.xiangmuIds = xiangmuIds;
	}

	public TXiangmuDAO getXiangmuDAO() {
		return xiangmuDAO;
	}

	public void setXiangmuDAO(TXiangmuDAO xiangmuDAO) {
		this.xiangmuDAO = xiangmuDAO;
	}

	public TJiluDAO getJiluDAO() {
		return jiluDAO;
	}

	public void setJiluDAO(TJiluDAO jiluDAO) {
		this.jiluDAO = jiluDAO;
	}


	public TNeirongDAO getNeirongDAO() {
		return neirongDAO;
	}

	public void setNeirongDAO(TNeirongDAO neirongDAO) {
		this.neirongDAO = neirongDAO;
	}
	
	public TBingliDAO getBingliDAO() {
		return bingliDAO;
	}

	public void setBingliDAO(TBingliDAO bingliDAO) {
		this.bingliDAO = bingliDAO;
	}
	
	private String getXiangmuIds(List xiangmuList)
	{
		String result = "";
		for(int i=0;i<xiangmuList.size();i++)
		{
			TXiangmu xiangmu = (TXiangmu)xiangmuList.get(i);
			if(i+1 == xiangmuList.size())
				result += xiangmu.getId();
			else 
				result += xiangmu.getId()+",";
		}
		return result;
	}

	private String getXiangmuIdsByNeirong(List neirongList)
	{
		String result = "";
		for(int i=0;i<neirongList.size();i++)
		{
			TNeirong neirong = (TNeirong)neirongList.get(i);
			if(i+1 == neirongList.size())
				result += neirong.getXiangmu().getId();
			else 
				result += neirong.getXiangmu().getId()+",";
		}
		return result;
	}
}
