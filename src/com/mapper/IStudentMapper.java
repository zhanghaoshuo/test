package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bean.Clazz;
import com.bean.Student;

public interface IStudentMapper {
	public int save(Student st);
	   public int update(Student st);
	   public int delById(@Param("sid") int sid);
	   public Student findById(int sid);
	   //��ѯ�༶����
	   public List<Clazz> doinit();
	   /**��ҳ*/
	   public List<Student> findPageAll(@Param("page") int page,@Param("rows")int rows);
	   /**��ҳ��**/
	   public int findMaxPage();
  
}
