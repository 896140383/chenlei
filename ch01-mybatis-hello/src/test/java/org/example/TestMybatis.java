package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
//    测试方法 测试功能
    @Test
    public void Insert() throws IOException {
        //访问mybatis读取student数据
//        1.定义mybatis主配置文件的名称 从类路径开始(target/classes)
        String config="mybatis.xml";
//        2.读取这个config表示的文件
        InputStream in= Resources.getResourceAsStream(config);
//        3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
//      4.创建SqlSessionFactory对象
        SqlSessionFactory factory=builder.build(in);
//        5.(重要)获取SqlSession对象从SqlSessionFactory中获取SqlSession
        SqlSession sqlsession=factory.openSession();
//        6.指定要执行的Sql语句的标识 sql映射文件中的namespace+“.”+标签的id值
        String sqlId="org.mybatis.example.BlogMapper"+"."+"insertStudent";
//        7.执行sql语句 通过sqlId找到语句
        Student student=new Student();
        student.setId(5);
        student.setName("睾哥");
        student.setPassword("123456000");
        student.setSex("男");
        student.setAddress("南京");
        student.setEmail("@qq.com");
        int num= sqlsession.insert(sqlId,student);
//        8.输出结果
        System.out.println("执行的insert结果"+num);
//        mybatis默认不会提交事务 所以在insert delete update后要手动提交事务
        sqlsession.commit();
//        9.关闭SqlSession对象
        sqlsession.close();
    }
}
