package test;

import com.ylw.dao.PersonDao;
import com.ylw.po.Person;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by 85243 on 2017/4/10.
 */
public class Demo1 {
    /**
     * 检测能否从数据源里面操作数据库,
     */
    @Test
    public void test00(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
//        personDao.delete("1");
    }

    //测试hibernate和spring是否配置成功
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sf = (SessionFactory) applicationContext.getBean("localSessionFactoryBean");
        System.out.println(sf);
    }
//    测试是否能从数据库获取数据
    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
        List<Person> persons = personDao.getPersons();
        for(Person person: persons){
            System.out.println(person);
        }
    }
    /**
     * 查看二级缓存
     *
     * 第一次编译的时候需要时间比较长,第一次访问数据库的时候使用时间是第二次访问相同数据的时候访问缓存的使用时间两倍
     */
    @Test
    public void test03(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
        Date start = null;
        Date end = null;
        start = new Date();
        Person person = personDao.getPerson("2");
        System.out.println(person);
        end  = new Date();
        System.out.println("第一次访问使用时间: "+(end.getTime()-start.getTime()));

//        try {
//            System.out.println("请关闭数据库");
//            Thread.sleep(1000*15);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        start = new Date();
        System.out.println("第二次开始获取");
        person = personDao.getPerson("2");
        System.out.println(person);
        end  = new Date();
        System.out.println("第二次访问使用时间: "+(end.getTime()-start.getTime()));


        start = new Date();
        System.out.println("第二次开始获取");
        person = personDao.getPerson("2");
        System.out.println(person);
        end  = new Date();
        System.out.println("第二次访问使用时间: "+(end.getTime()-start.getTime()));



        start = new Date();
        System.out.println("第3次开始获取");
        person = personDao.getPerson("3");
        System.out.println(person);
        end  = new Date();
        System.out.println("第一次访问使用时间: "+(end.getTime()-start.getTime()));


        start = new Date();
        System.out.println("第二次开始获取");
        person = personDao.getPerson("3");
        System.out.println(person);
        end  = new Date();
        System.out.println("第二次访问使用时间: "+(end.getTime()-start.getTime()));}
}
