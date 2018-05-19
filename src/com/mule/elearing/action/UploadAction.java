package com.mule.elearing.action;

import com.mule.elearing.po.Content;
import com.mule.elearing.util.UtilTool;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.mule.elearing.po.Course;
import com.mule.elearing.service.ContentService;
import com.mule.elearing.service.CourseService;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 1.1CVE-2017-5638漏洞简介
 Apache Struts 2是世界上最流行的JavaWeb服务器框架之一。然而在Struts 2上发现存在高危安全漏洞（CVE-2017-5638,S02-45）,该漏洞影响到：Struts 2.3.5 - Struts 2.3.31，Struts 2.5 - Struts2.5.10
 漏洞编号：CVE-2017-5638
 漏洞等级：HIGH
 漏洞名称：S2-045：Struts 2远程执行代码漏洞
 漏洞影响：基于JakartaMultipart解析器执行文件上传时可能的RCE
 影响版本：Struts 2.3.5 -Struts 2.3.31
 Struts 2.5 -Struts 2.5.10
 修补方案：
 升级到Struts2.3.32或Struts 2.5.10.1
 * Created by 85243 on 2017/4/25.
 */
public class UploadAction extends ActionSupport implements ServletContextAware {
    //这里需要要jsp页面里面的name = upload对应
    private List<File> uploads = new ArrayList<>();
    private List<String> uploadFileNames = new ArrayList<>();
    private List<String> uploadContentTypes = new ArrayList<>();

    /**
     * 分析,为什么这个必需动态注入,否则将出现 service里面dao对象为null
     */
    CourseService courseService ;
    ContentService contentService ;

    private String courseName;
    private String introduction;
    private String teacher;
    private String level;
    private String startTime;
    private String keyword;
    private String picUrl;
    private String contentName;
//    private String courseId;
    ServletContext servletContext ;
    private String courseId;

    public String uploadCourse() throws IOException {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        String savePath = servletContext.getRealPath("movie");

        String result = ERROR;
        Course course = new Course();
        course.setCourseId(UtilTool.getUUID());
        course.setCourseName(this.courseName);
        course.setIntroduction(this.introduction);
        course.setStudentNum(0);
        course.setTeacher(this.teacher);
        course.setLevel(this.level);
        course.setStartTime(this.startTime);
        course.setKeyword(this.keyword);
        List<Content> contents = new ArrayList<>();
        String[] contentNames = this.contentName.split(",");
        int contentNameIndex = 0;
        try {
            for(int i = 0;i<uploads.size();i++){
                String fileName  = UtilTool.getUUID()+uploadFileNames.get(i);
                File toFile = new File(savePath, fileName);
                fos = new FileOutputStream(toFile);
                fis = new FileInputStream(uploads.get(i));
                byte[] buffer = new byte[1024];
                int len = 0;
                while((len= fis.read(buffer))>0){
                    fos.write(buffer,0,len);
                }
                if(i==0){
                    course.setPicUrl("movie/"+fileName);
                }else{
//                    这里不使用File.separator因为在web里面的路径还是/与操作系统无关的,所以这里不能根据windows下面的分隔符,来保存文件路径
//                    contents.add(new Content(UtilTool.getUUID(),contentNames[contentNameIndex],course.getCourseId(),"movie"+File.separator+fileName,Integer.toString(i)));
                    contents.add(new Content(UtilTool.getUUID(),contentNames[contentNameIndex++],course.getCourseId(),"movie/"+fileName,Integer.toString(i)));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fos.close();
            fis.close();
        }
        courseService.Save(course);
        contentService.save(contents);
        ActionContext.getContext().put("courseId",course.getCourseId());
        result = SUCCESS;
        return result ;
    }

    public void saveFile(){

    }


    public List<File> getUpload() {
        return this.uploads;
    }

    public void setUpload(List<File> uploads) {
        this.uploads = uploads;
    }

    public List<String> getUploadFileName() {
        return this.uploadFileNames;
    }

    public void setUploadFileName(List<String> uploadFileNames) {
        this.uploadFileNames = uploadFileNames;
    }

    public List<String> getUploadContentType() {
        return this.uploadContentTypes;
    }

    public void setUploadContentType(List<String> contentTypes) {
        this.uploadContentTypes = contentTypes;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public ContentService getContentService() {
        return contentService;
    }

    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    @Override
    public void setServletContext(javax.servlet.ServletContext context) {
        servletContext =context;
    }

    /**
     * 为了迎合strut.xml里面的配置
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }
}
