package com.mule.elearing.dao.impl;

import com.mule.elearing.dao.ContentDao;
import com.mule.elearing.po.Content;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ContentDaoImpl implements ContentDao {
	private SessionFactory sf ;
	 @Override
	 @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly = true)
	 public List<Content>  getContentsByCourseId(String courseId){
		 	System.out.println("~~~"+courseId);
	        String hql = "from Content c where c.courseId= '"+courseId+"'";
	        List<Content> contents = sf.getCurrentSession().createQuery(hql).list();
	        return contents;
	    }
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	public Content getContentById(String contentId) {
		// TODO Auto-generated method stub
		Content content=null;
		try {
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			content=(Content)session.get(Content.class, contentId);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}

	@Override
	public void save(Content content) {
		Session session = sf.getCurrentSession();
		session.save(content);
	}

}
