package org.Dao;

import org.example.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {
//    查询student表的所有数据
    public List<Student> selectStudents();
//    插入方法
//    参数：student 表示要插入数据库的行数
//    返回值：int 表示执行insert操作后影响数据库的行数
    public int insertStudent(Student student);
}
