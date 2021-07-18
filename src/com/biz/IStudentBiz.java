package com.biz;

import java.util.List;

import com.bean.Clazz;
import com.bean.Student;

public interface IStudentBiz {
   public boolean save(Student st);
   public boolean update(Student st);
   public boolean delById(int sid);
   public Student findById(int sid);
   //��ѯ�༶����
   public List<Clazz> doinit();
   /**��ҳ*/
   public List<Student> findPageAll(int page,int rows);
   /**��ҳ��**/
   public int findMaxPage(int rows);
}
