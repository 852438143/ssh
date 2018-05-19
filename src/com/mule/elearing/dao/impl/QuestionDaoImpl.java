package com.mule.elearing.dao.impl;

import com.mule.elearing.dao.QuestionDao;
import com.mule.elearing.po.Question;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 85243 on 2017/4/18.
 */
@Transactional
public class QuestionDaoImpl implements QuestionDao{
    SessionFactory sf ;


    @Override
    public void save(Question question) {
        sf.getCurrentSession().save(question);
    }

    /*
    查询该课程的所有问题
     */
    @Override
    public List<Question> getQuestionsByCourseId(String courseId) {
        String hql  ="from Question where courseId=?";
        List<Question> questions ;
        questions = sf.getCurrentSession().createQuery(hql).setString(0,courseId).list();
        return questions;
    }

    @Override
    public Question getQuestionById(String id) {
        Question question = sf.getCurrentSession().get(Question.class,id);
        return question;
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }
}
