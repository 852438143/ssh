package com.mule.elearing.action;

import com.mule.elearing.service.CourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.mule.elearing.po.Course;
import com.mule.elearing.po.Paper;
import com.mule.elearing.po.Question;
import com.mule.elearing.po.Student;
import com.mule.elearing.service.PaperService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 85243 on 2017/4/20.
 */
public class PaperAction extends ActionSupport implements ModelDriven {
    /**
     * 使用request对象可以选择实现ServletRequestAware
     */
    PaperService paperService;
    CourseService courseService;
    Paper paper = new Paper();
    List<Question> questions;

    public String showPaperByCourseId(){
        String result = ERROR;
        try {
            this.paper = paperService.getPapersByCourseId(paper.getCourseId()).get(0);
            if (paper != null) {
                result = SUCCESS;
            }
            ActionContext.getContext().put("paper", paper);
        }catch(Exception e){
            ActionContext.getContext().put("msg","该课程尚未添加试卷");
        }
        return result;
    }

    public String showPapersByCourseId(){
        String result = "error";
        try {
            List<Paper> papers = new ArrayList<>();
            papers = paperService.getPapersByCourseId(paper.getCourseId());
            papers.sort((o1, o2) -> Integer.parseInt(o2.getScore()) - Integer.parseInt(o1.getScore()));
            if (papers != null) {
                ActionContext.getContext().put("papers", papers);
                ActionContext.getContext().put("courseId", papers.get(0).getCourseId());
                result = SUCCESS;
            }
        }catch (Exception e){
            ActionContext.getContext().put("msg","该课程暂无学习情况");
        }finally{
            return result;
        }
    }
    public String showPapers(){
        String  result = ERROR;
        List<Paper> papers = paperService.getPapers();
        if(papers!=null&& papers.size()>0){
            result=SUCCESS;
        }
        papers.sort((o1,o2)->Integer.parseInt(o2.getScore())-Integer.parseInt(o1.getScore()));
        ActionContext.getContext().put("papers",papers);
        return result;
    }

    /**
     * 创建试卷,这里面的studentId设为空,
     * 这里面创建的试卷是对应课程的,所以studentId为空判断这门课程的id
     * 这里面课程id不能为空,要不然这个试卷没法用
     * 还有这里的试卷名字field2最好不要为空,为了方便,以及时间field3不要为空
     * @return
     */
    public String createPaper(){
        String result = ERROR;
        Course course = courseService.getCourse(this.paper.getCourseId());
        this.paper.setField2(course.getCourseName());
        this.questions = paperService.createPaper(this.paper);
        if(questions!=null){
            ActionContext.getContext().put("questions",this.questions);
            ActionContext.getContext().put("paper",this.paper);
            result = SUCCESS;
        }
        return result;
    }

    /**
     * 开始考试,通过paperId获取试卷,并把试卷返回到startTestPaper.jsp页面
     * @return
     */
    public String startTestPaper(){
        String result =SUCCESS;
        this.paper = paperService.getPaperByPaperId(this.paper.getPaperId());
        this.questions = paperService.getQuestionsByQuestionIds(this.paper.getQuestionIds());
        ActionContext.getContext().put("questions",this.questions);
        ActionContext.getContext().put("paper",this.paper);
        return result;
    }

    /**
     * 结束考试,把考试结果返回到afterTestPaper.jsp页面
     * 先获取前端的result 把后端的paper数据copy一份,然后把paperId更换,加入学生的信息,
     * @return
     */
    public String afterTestPaper(){
        String result = SUCCESS;
        System.out.println(paper);
        System.out.println(paper.getResult());
        this.paper.setStudentId(((Student) ActionContext.getContext().getSession().get("student")).getStudentId());
        this.paper.setField1(((Student) ActionContext.getContext().getSession().get("student")).getStudentName());
        this.paper.setField3(new SimpleDateFormat().format(new Date()));
        paperService.saveAfterTest(this.paper);
        this.paper = paperService.getPaperByPaperId(paper.getPaperId());
        this.questions = paperService.getQuestionsByQuestionIds(this.paper.getQuestionIds());
        ActionContext.getContext().put("questions",this.questions);
        ActionContext.getContext().put("paper",this.paper);
        return result;
    }

    /**
     * @return
     */
    public String showPaperByPaperId(){
        String result = SUCCESS;
        this.paper = paperService.getPaperByPaperId(paper.getPaperId());
        this.questions = paperService.getQuestionsByQuestionIds(this.paper.getQuestionIds());
        ActionContext.getContext().put("questions",this.questions);
        ActionContext.getContext().put("paper",this.paper);
        return result;
    }

    public String showPapersByStudentId(){
        String result= ERROR;
        List<Paper> papers = this.paperService.getPapersByStudentId(((Student)ActionContext.getContext().getSession().get("student")).getStudentId());
        System.out.println(papers);
        if(papers!=null && papers.size()>0){
            result=SUCCESS;
        }
        papers.sort((o1,o2)->Integer.parseInt(o2.getScore())-Integer.parseInt(o1.getScore()));
        ActionContext.getContext().put("papers",papers);
        return result;
    }


    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public PaperService getPaperService() {
        return paperService;
    }

    public void setPaperService(PaperService paperService) {
        this.paperService = paperService;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public Object getModel() {
        return paper;
    }
}
