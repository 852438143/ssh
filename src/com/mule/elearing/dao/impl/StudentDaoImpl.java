package com.mule.elearing.dao.impl;

import com.mule.elearing.dao.StudentDao;
import com.mule.elearing.po.Person;
import com.mule.elearing.po.Student;
import com.mule.elearing.po.StudentCourse;
import com.mule.elearing.po.Course;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 85243 on 2017/4/10.
 */
@Transactional
public class StudentDaoImpl implements StudentDao {
    private SessionFactory sf ;
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly = true)
    public List<Student> getStudents() {
        String hql = "from Student";
        /**
         * （1）openSession每次打开都是新的Session,所以多次获取的Session实例是不同的，并且需要人为的调用close方法进行Session关闭。
         （2）getCurrentSession是从当前上下文中获取Session并且会绑定到当前线程，第一次调用时会创建一个Session实例，如果该Session未关闭，
            后续多次获取的是同一个Session实例；事务提交或者回滚时会自动关闭Sesison,无需人工关闭。
         这里使用spring管理,所以使用getCurrentSession方法,需要数据源,这些东西
         需要事务,如果没有事务的注释出现org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread
         */
        List<Student> persons = sf.getCurrentSession().createQuery(hql).list();
        return persons;
    }

    public Person getPerson(String id){
        return sf.getCurrentSession().get(Person.class,id);
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

	@Override
	public boolean StudentExists(Student student) {
		// TODO Auto-generated method stub
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		Student p=null;
		//System.out.println(student==null);
		if(student!=null){p=(Student)session.get(Student.class, student.getStudentId());}
		session.getTransaction().commit();
		if(p!=null&&p.getPassword().equals(student.getPassword()))return true;
		return false;
	}

	public void updateStudent(Student student){
		Session session = sf.getCurrentSession();
		session.saveOrUpdate(student);
	}

	@Override
	public Person getStudent(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCourse(String studentId) {
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

	@Override
	public Student getStudentById(String studentId) {
		Student student=null;
		try {
			Session session=sf.getCurrentSession();
			session.beginTransaction();
			student=(Student)session.get(Student.class,studentId );
			//System.out.println(student.getStudentId()+" !"+student.getStudentName());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
	}

	public void save(Student student){
		Session session  = sf.getCurrentSession();
		session.save(student);
	}

   
}
