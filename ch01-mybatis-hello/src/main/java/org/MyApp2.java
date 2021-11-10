package org;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Student;
import org.utils.MyBatisUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {
//       有了工具类前四点可以省略
//        5.(重要)获取SqlSession对象从SqlSessionFactory中获取SqlSession
        SqlSession sqlsession= MyBatisUtils.getSqlSession();
//        6.指定要执行的Sql语句的标识 sql映射文件中的namespace+“.”+标签的id值
        String sqlId="org.mybatis.example.BlogMapper"+"."+"selectStudents";
//        7.执行sql语句 通过sqlId找到语句
        List<Student> studentList= sqlsession.selectList(sqlId);
//        8.输出结果
        studentList.forEach(stu-> System.out.println(stu));
//       第二种输出方式
//       for(Student stu:studentList){
//          System.out.println("查询的学生"+stu);
//     }
//        9.关闭SqlSession对象
        sqlsession.close();
    }
}
