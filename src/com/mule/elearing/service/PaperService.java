package com.mule.elearing.service;

import com.mule.elearing.po.Paper;
import com.mule.elearing.po.Question;

import java.util.List;

/**
 * Created by 85243 on 2017/4/18.
 */
public interface PaperService {
    /*
        通过courseId查找Papers
     */
    List<Paper> getPapersByCourseId(String courseId);

    /*
    通过questionIds获取试题
     */
    public List<Question> getQuestionsByQuestionIds(String questionIds);

    /*
    通过PaperID查找一个paper,并返回一个
     */
    Paper getPaperByPaperId(String paperId);

    /*
    通过学生Id查找该学生的所有试卷
     */
    List<Paper> getPapersByStudentId(String Id);

    /*
    通过studentid和courseId获取Papers
     */
    List<Paper> getPaperByCourseIdAndStudentId(String courseId, String studentId);

    /*
        通过Paper对象创建一个Paper对象,并返回题目集,这里的参数引用不可以变,要不影响paper对象的生成
     */
    List<Question> createPaper(Paper paper);


    /**
     * 为学生对应的该课程生成一份试卷
     */
    void saveAfterTest(Paper paper);

    List<Paper> getPapers();

}
