package com.mule.elearing.service.impl;

import com.mule.elearing.util.UtilTool;
import com.mule.elearing.dao.PaperDao;
import com.mule.elearing.dao.QuestionDao;
import com.mule.elearing.po.Paper;
import com.mule.elearing.po.Question;
import com.mule.elearing.service.PaperService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * Created by 85243 on 2017/4/18.
 */
public class PaperServiceImpl implements PaperService {
    PaperDao paperDao;
    QuestionDao questionDao;



    @Override
    public List<Paper> getPapersByCourseId(String courseId) {
        return paperDao.getPaperByCourseId(courseId);
    }

    @Override
    public Paper getPaperByPaperId(String paperId) {
        return paperDao.getPaperByPaperId(paperId);
    }

    public List<Question> getQuestionsByQuestionIds(String questionIds){
        String[] ids  = questionIds.split(",");
        List<Question> questions = new ArrayList<>();
        for(String id: ids){
            questions.add(questionDao.getQuestionById(id));
        }
        return questions;
    }

    @Override
    public List<Paper> getPapersByStudentId(String id) {
        return paperDao.getPaperByStudentId(id);
    }

    @Override
    public List<Paper> getPaperByCourseIdAndStudentId(String courseId, String studentId) {
        return paperDao.getPaperByCourseIdAndStudentId(courseId, studentId);
    }

    /**
     * 为课程随机生成一份试卷
     * @param paper
     * @return
     */
    @Override
    public List<Question> createPaper(Paper paper) {
        List<Question> questions = questionDao.getQuestionsByCourseId(paper.getCourseId());
        List<Question> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        int count = 5;
        while (count > 0) {
            int index = rand.nextInt(questions.size());
            sb.append(questions.get(index).getQuestionId());
            sb.append(",");
            result.add(questions.get(index));
            questions.remove(index);
            count--;
        }
        paper.setPaperId(UtilTool.getUUID());
        if (sb.toString().endsWith(",")) {
            paper.setQuestionIds(sb.toString().substring(0, sb.toString().lastIndexOf(",")));
        }
        paper.setStudentId(null);
        paperDao.save(paper);
        return result;
    }

    @Override
    public void saveAfterTest(Paper paper){
        int score = 0;
        Paper oldPaper = paperDao.getPaperByPaperId(paper.getPaperId());
        paper.setQuestionIds(oldPaper.getQuestionIds());
        paper.setCourseId(oldPaper.getCourseId());
        paper.setField2(oldPaper.getField2());
//        paper.setField3(oldPaper.getField3());
        List<Question>  questions = getQuestionsByQuestionIds(paper.getQuestionIds());
        String[] results= paper.getResult().split(",");
        int i=0;
        for(Question question: questions){
            if(results[i++].equals(question.getAnswer())){
                score++;
            }
        }
        score*=20;
        paper.setScore(Integer.toString(score));
        System.out.println(paper);
        paperDao.save(paper);
    }

    @Override
    public List<Paper> getPapers() {
        List<Paper> papers = paperDao.getPaper();
        return papers;
    }


    public PaperDao getPaperDao() {
        return paperDao;
    }

    public void setPaperDao(PaperDao paperDao) {
        this.paperDao = paperDao;
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }
}
