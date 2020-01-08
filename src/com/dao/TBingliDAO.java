package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TBingli;

/**
 * A data access object (DAO) providing persistence and search support for
 * TBingli entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TBingli
 * @author MyEclipse Persistence Tools
 */

public class TBingliDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TBingliDAO.class);
	// property constants
	public static final String YISHENG_ID = "yishengId";
	public static final String BIANHAO = "bianhao";
	public static final String XINGMING = "xingming";
	public static final String XINGBIE = "xingbie";
	public static final String NIANLING = "nianling";
	public static final String SHENGRI = "shengri";
	public static final String HUNFOU = "hunfou";
	public static final String ZHUZHI = "zhuzhi";
	public static final String LIANXI = "lianxi";
	public static final String SHENFEN = "shenfen";
	public static final String DEL = "del";

	protected void initDao() {
		// do nothing
	}

	public void save(TBingli transientInstance) {
		log.debug("saving TBingli instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TBingli persistentInstance) {
		log.debug("deleting TBingli instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TBingli findById(java.lang.Integer id) {
		log.debug("getting TBingli instance with id: " + id);
		try {
			TBingli instance = (TBingli) getHibernateTemplate().get(
					"com.model.TBingli", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBingli instance) {
		log.debug("finding TBingli instance by example");
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
		log.debug("finding TBingli instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TBingli as model where model."
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

	public List findByBianhao(Object bianhao) {
		return findByProperty(BIANHAO, bianhao);
	}

	public List findByXingming(Object xingming) {
		return findByProperty(XINGMING, xingming);
	}

	public List findByXingbie(Object xingbie) {
		return findByProperty(XINGBIE, xingbie);
	}

	public List findByNianling(Object nianling) {
		return findByProperty(NIANLING, nianling);
	}

	public List findByShengri(Object shengri) {
		return findByProperty(SHENGRI, shengri);
	}

	public List findByHunfou(Object hunfou) {
		return findByProperty(HUNFOU, hunfou);
	}

	public List findByZhuzhi(Object zhuzhi) {
		return findByProperty(ZHUZHI, zhuzhi);
	}

	public List findByLianxi(Object lianxi) {
		return findByProperty(LIANXI, lianxi);
	}

	public List findByShenfen(Object shenfen) {
		return findByProperty(SHENFEN, shenfen);
	}

	public List findByDel(Object del) {
		return findByProperty(DEL, del);
	}

	public List findAll() {
		log.debug("finding all TBingli instances");
		try {
			String queryString = "from TBingli";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBingli merge(TBingli detachedInstance) {
		log.debug("merging TBingli instance");
		try {
			TBingli result = (TBingli) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBingli instance) {
		log.debug("attaching dirty TBingli instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TBingli instance) {
		log.debug("attaching clean TBingli instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TBingliDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TBingliDAO) ctx.getBean("TBingliDAO");
	}
}