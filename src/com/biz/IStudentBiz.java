package com.biz;

import java.util.List;

import com.bean.Clazz;
import com.bean.Student;

public interface IStudentBiz {
   public boolean save(Student st);
   public boolean update(Student st);
   public boolean delById(int sid);
   public Student findById(int sid);
   //查询班级所有
   public List<Clazz> doinit();
   /**分页*/
   public List<Student> findPageAll(int page,int rows);
   /**总页数**/
   public int findMaxPage(int rows);
}
