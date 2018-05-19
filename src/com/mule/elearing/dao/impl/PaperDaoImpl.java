package com.mule.elearing.dao.impl;

import com.mule.elearing.dao.PaperDao;
import com.mule.elearing.po.Paper;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 书卷的Model层,实现了试卷与数据库的交互
 * Created by 85243 on 2017/4/18.
 */
@Transactional
public class PaperDaoImpl implements PaperDao {
    /*
    通过application.xml配置文件，依赖注入SessionFactory 对象sf
     */
    SessionFactory sf;

    /**
     *通过传入Paper对象paper,将其存到数据库
     * @param paper
     */
    @Override
    public void save(Paper paper) {
        sf.getCurrentSession().saveOrUpdate(paper);
    }


    /**
     * 通过试卷Id获取试卷
     * @param paperId
     * @return
     */
    @Override
    public Paper getPaperByPaperId(String paperId) {
        Paper paper = sf.getCurrentSession().get(Paper.class,paperId);
        return paper;
    }



    @Override
    public List<Paper> getPaperByStudentId(String studentId) {
        String hql = "from Paper where studentId =?";
        List<Paper> papers= sf.getCurrentSession().createQuery(hql).setString(0,studentId).list();
        return papers;
    }

    @Override
    public List<Paper> getPaper() {
        String hql = "from Paper ";
        List<Paper> papers = sf.getCurrentSession().createQuery(hql).list();
        return papers;
    }

    /**
     * @
     * 通过查询课程分类的考试
     * @return
     */
    public List<Paper> getPaperByCourseId(){
        String hql = "from Paper group by courseId";
        List<Paper> papers = sf.getCurrentSession().createQuery(hql).list();
        return papers;
    }

    @Override
    public List<Paper> getPaperByCourseId(String courseId) {
        String hql ="from Paper where courseId=?";
        List<Paper> papers = sf.getCurrentSession().createQuery(hql).setString(0,courseId).list();
        return papers;
    }

    @Override
    public List<Paper> getPaperByCourseIdAndStudentId(String courseId, String studentId) {
        String hql = "from Paper where courseId=? and studentId=?";
        List<Paper> papers = sf.getCurrentSession().createQuery(hql).list();
        return papers;
    }

    public void setSf(SessionFactory sf){
        this.sf=sf;
    }
}
