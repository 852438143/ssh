package com.mule.elearing.dao.impl;

import com.mule.elearing.dao.CourseDao;
import com.mule.elearing.po.Course;
import com.mule.elearing.po.StudentCourse;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class CourseDaoImpl implements CourseDao{
	 private SessionFactory sf ;
	 @Override
	 @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly = true)
	 public List<Course> getCourse(){
	        String hql = "from Course";
	        /**
	         * （1）openSession每次打开都是新的Session,所以多次获取的Session实例是不同的，并且需要人为的调用close方法进行Session关闭。
	         （2）getCurrentSession是从当前上下文中获取Session并且会绑定到当前线程，第一次调用时会创建一个Session实例，如果该Session未关闭，
	            后续多次获取的是同一个Session实例；事务提交或者回滚时会自动关闭Sesison,无需人工关闭。
	         这里使用spring管理,所以使用getCurrentSession方法,需要数据源,这些东西
	         需要事务,如果没有事务的注释出现org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread
	         */
	        List<Course> courses = sf.getCurrentSession().createQuery(hql).list();
	        return courses;
	    }
	@Override
	public Course get(String courseId) {
		// TODO Auto-generated method stub
		Course course=null;
		try {
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			course=(Course)session.get(Course.class, courseId);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}

	public List<Course> getCourseByStudentId(String studentId) {
		// TODO Auto-generated method stub
		String hql1="from StudentCourse sc where sc.studentId= '"+studentId+"'";
		List<StudentCourse> scs = sf.getCurrentSession().createQuery(hql1).list();
		List<Course> courses = new ArrayList<Course>();
		for(StudentCourse sc:scs){
			System.out.println(studentId+"   "+sc.getCourseId());
			Session session =sf.getCurrentSession();
			session.beginTransaction();
			Course c=(Course)session.get(Course.class, sc.getCourseId());

			session.getTransaction().commit();
			courses.add(c);
			// System.out.println(c==null);
		}
		return courses;
	}

	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Override
	public List<Course> getByPage(int currentPage) {
		int pagesize=8;
		List<Course> courses=new ArrayList<Course>();
		try {
			Session session=sf.getCurrentSession();
			Query  query=session.createQuery("from Course");
			query.setFirstResult((currentPage-1)*pagesize);
			query.setMaxResults(pagesize);
			
			courses=query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1!!!!!"+courses.size());
		return courses;
	}
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<Course>();
		courses = sf.getCurrentSession().createQuery("from Course").list();
		return courses.size();
	}
	@Override
	public void Save(Course course) {
		// TODO Auto-generated method stub
		try {
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.save(course);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void Delete(String courseId) {
		// TODO Auto-generated method stub
		try {
			Course course=new Course();
			course.setCourseId(courseId);
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.delete(course);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void Update(Course course) {
		// TODO Auto-generated method stub
		try {
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			session.update(course);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Course getCourseById(String courseId) {
		// TODO Auto-generated method stub
		Course course=null;
		try {
			
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			course=(Course)session.get(Course.class, courseId);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return course;
	}
	@Override
	public void setTime(Course course) {
		// TODO Auto-generated method stub
		try {
			String hql="update Course c set c.time='"+course.getStartTime()+"'where c.courseId= '"+course.getCourseId()+"'";
			sf.getCurrentSession().createQuery(hql);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public List<Course> getCourseByKeywords(String keyword) {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<Course>();
		try {
			String sql="from Course c where c.keyword='"+keyword+"'";
			courses=sf.getCurrentSession().createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}
	@Override
	public List<Course> getCourseByKeywordsOrName(String keyword) {
		// TODO Auto-generated method stub
		List<Course> courses=new ArrayList<Course>();
		try {
			String sql="from Course c where c.keyword='"+keyword+"' or c.courseName= '"+keyword+"'";
			courses=sf.getCurrentSession().createQuery(sql).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}

	@Override
	public void removeStudentCourse(String studentId, String courseId) {
        String hql = "delete  from StudentCourse where studentId=? and courseId=?";
        sf.getCurrentSession().createQuery(hql).setString(0,studentId).setString(1,courseId).executeUpdate();
	}
	public void saveStudentCourse(String studentId,String courseId,String courseName){
		sf.getCurrentSession().save(new StudentCourse(studentId,courseId,courseName));
	}
}
