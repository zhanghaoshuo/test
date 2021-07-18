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
	   //查询班级所有
	   public List<Clazz> doinit();
	   /**分页*/
	   public List<Student> findPageAll(@Param("page") int page,@Param("rows")int rows);
	   /**总页数**/
	   public int findMaxPage();
  
}
