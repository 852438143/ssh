package com.mule.elearing.dao;

import com.mule.elearing.po.Paper;

import java.util.List;

/**
 * Created by 85243 on 2017/4/18.
 */
public interface PaperDao {
    /**
     * 保存或更新一个paper对象
     */
    public void save(Paper paper);
    /**
     * 通过paperId获取paper对象
     */
    public Paper getPaperByPaperId(String paperId);
    /**
     * 通过课程号获取Paper对象
     */
    public List<Paper> getPaperByStudentId(String studentId);

    /**
     * 获取所有的试卷,==>学生id为空的paper
     * @return
     */
    public List<Paper> getPaper();

    public List<Paper> getPaperByCourseId();

    public List<Paper> getPaperByCourseId(String courseId);

    public List<Paper> getPaperByCourseIdAndStudentId(String courseId,String studentId);
}
