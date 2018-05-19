package com.mule.elearing.dao;

import com.mule.elearing.po.Question;

import java.util.List;

/**
 * Created by 85243 on 2017/4/18.
 */
public interface QuestionDao {

    /**
     * 导入题目
     */
    public void save(Question question);

    /**
     * 获取n道题目
     *
     * @param
     */
    public List<Question> getQuestionsByCourseId(String courseId);


    public Question getQuestionById(String id);
}
