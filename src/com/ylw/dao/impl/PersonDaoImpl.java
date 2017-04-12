package com.ylw.dao.impl;

import com.ylw.dao.PersonDao;
import com.ylw.po.Person;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 85243 on 2017/4/10.
 */
@Transactional
public class PersonDaoImpl implements PersonDao{
    private SessionFactory sf ;
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly = true)
    public List<Person> getPersons() {
        String hql = "from Person";
        /**
         * （1）openSession每次打开都是新的Session,所以多次获取的Session实例是不同的，并且需要人为的调用close方法进行Session关闭。
         （2）getCurrentSession是从当前上下文中获取Session并且会绑定到当前线程，第一次调用时会创建一个Session实例，如果该Session未关闭，
            后续多次获取的是同一个Session实例；事务提交或者回滚时会自动关闭Sesison,无需人工关闭。
         这里使用spring管理,所以使用getCurrentSession方法,需要数据源,这些东西
         需要事务,如果没有事务的注释出现org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread
         */
        List<Person> persons = sf.getCurrentSession().createQuery(hql).list();
        return persons;
    }

    public Person getPerson(String id){
        return sf.getCurrentSession().get(Person.class,id);
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    /**
     * 使用jdbc和数据源操作的
     */
//    private JdbcTemplate jdbcTemplate;
//
//    public void setDataSource(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//
//    }
//    @Transactional(rollbackFor = Exception.class)//对哪种异常进行事务回滚
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)//不使用事务
//    public void delete(String id) {
//        jdbcTemplate.update("delete from person where id=?", new Object[]{id},
//                new int[]{java.sql.Types.VARCHAR});
//    }
}
