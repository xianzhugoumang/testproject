package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TXiangmu;

/**
 * A data access object (DAO) providing persistence and search support for
 * TXiangmu entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TXiangmu
 * @author MyEclipse Persistence Tools
 */

public class TXiangmuDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TXiangmuDAO.class);
	// property constants
	public static final String KESHI_ID = "keshiId";
	public static final String MINGCHENG = "mingcheng";
	public static final String DEL = "del";

	protected void initDao() {
		// do nothing
	}

	public void save(TXiangmu transientInstance) {
		log.debug("saving TXiangmu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TXiangmu persistentInstance) {
		log.debug("deleting TXiangmu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TXiangmu findById(java.lang.Integer id) {
		log.debug("getting TXiangmu instance with id: " + id);
		try {
			TXiangmu instance = (TXiangmu) getHibernateTemplate().get(
					"com.model.TXiangmu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TXiangmu instance) {
		log.debug("finding TXiangmu instance by example");
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
		log.debug("finding TXiangmu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TXiangmu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByKeshiId(Object keshiId) {
		return findByProperty(KESHI_ID, keshiId);
	}

	public List findByMingcheng(Object mingcheng) {
		return findByProperty(MINGCHENG, mingcheng);
	}

	public List findByDel(Object del) {
		return findByProperty(DEL, del);
	}

	public List findAll() {
		log.debug("finding all TXiangmu instances");
		try {
			String queryString = "from TXiangmu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TXiangmu merge(TXiangmu detachedInstance) {
		log.debug("merging TXiangmu instance");
		try {
			TXiangmu result = (TXiangmu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TXiangmu instance) {
		log.debug("attaching dirty TXiangmu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TXiangmu instance) {
		log.debug("attaching clean TXiangmu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TXiangmuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TXiangmuDAO) ctx.getBean("TXiangmuDAO");
	}
}