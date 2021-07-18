package com.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mapper.IStudentMapper;

public class MybatisUtil {
	static SqlSessionFactory sessionFactory=null;
	static SqlSession session=null;
	static IStudentMapper studentmapper=null;
	 public static IStudentMapper showAdd() {
			
			try {
				//加载mybatis配置资源文件
				InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
				//获取sessionFactory
				sessionFactory=new SqlSessionFactoryBuilder().build(in);//使用资源文件流获取数据会话工厂
				//获取数据库会话
				session=sessionFactory.openSession();
				System.out.println("session===>"+session);
				//获取学生表映射接口对象
				 studentmapper=session.getMapper(IStudentMapper.class);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return studentmapper;
		}
	 public static void scommit(){
		 session.commit();
	 }
	 
}
