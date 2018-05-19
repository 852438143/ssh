package com.mule.elearing.dao.impl;

import com.mule.elearing.po.Comment;
import com.mule.elearing.dao.CommentDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Transactional
public class CommentDaoImpl implements CommentDao {
	 private SessionFactory sf ;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Comment> getComment() {
		String hql = "from Comment";
		List<Comment> comments = sf.getCurrentSession().createQuery(hql).list();
		return comments;
	}
	
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public boolean save(Comment comment) {
		// TODO Auto-generated method stub
		try {
			comment.setCommentId(UUID.randomUUID().toString().replaceAll("-", ""));
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.save(comment);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Comment> getByPage(int currentPage,String id,int index) {
		int pagesize=5;
		String[] hql = {"from Comment c where c.courseId='"+id+"' order by c.time desc",
				"from Comment c where c.contentId='"+id+"' order by c.time desc"
		};

		List<Comment> comments=new ArrayList<Comment>();
		try {
			Session session=sf.getCurrentSession();
//			Query  query=session.createQuery("from Comment c where c.contentId ='"+contentId+"' order by c.time desc");
			Query  query=session.createQuery(hql[index]);
			query.setFirstResult((currentPage-1)*pagesize);
			query.setMaxResults(pagesize);
			
			comments=query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1!!!!!"+comments.size());
		return comments;
	}
	@Override
	public int getTotal(String courseId) {
		// TODO Auto-generated method stub
		List<Comment> comments=new ArrayList<Comment>();
		comments = sf.getCurrentSession().createQuery("from Comment c where c.courseId='"+courseId+"'").list();
		return comments.size();
	}
}
