package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TJilu;

/**
 * A data access object (DAO) providing persistence and search support for TJilu
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.model.TJilu
 * @author MyEclipse Persistence Tools
 */

public class TJiluDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TJiluDAO.class);
	// property constants
	public static final String YISHENG_ID = "yishengId";
	public static final String BINGLI_ID = "bingliId";
	public static final String SHIJIAN = "shijian";

	protected void initDao() {
		// do nothing
	}

	public void save(TJilu transientInstance) {
		log.debug("saving TJilu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJilu persistentInstance) {
		log.debug("deleting TJilu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJilu findById(java.lang.Integer id) {
		log.debug("getting TJilu instance with id: " + id);
		try {
			TJilu instance = (TJilu) getHibernateTemplate().get(
					"com.model.TJilu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJilu instance) {
		log.debug("finding TJilu instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TJilu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TJilu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByYishengId(Object yishengId) {
		return findByProperty(YISHENG_ID, yishengId);
	}

	public List findByBingliId(Object bingliId) {
		return findByProperty(BINGLI_ID, bingliId);
	}

	public List findByShijian(Object shijian) {
		return findByProperty(SHIJIAN, shijian);
	}

	public List findAll() {
		log.debug("finding all TJilu instances");
		try {
			String queryString = "from TJilu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJilu merge(TJilu detachedInstance) {
		log.debug("merging TJilu instance");
		try {
			TJilu result = (TJilu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJilu instance) {
		log.debug("attaching dirty TJilu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJilu instance) {
		log.debug("attaching clean TJilu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TJiluDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TJiluDAO) ctx.getBean("TJiluDAO");
	}
}