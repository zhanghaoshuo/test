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
				//����mybatis������Դ�ļ�
				InputStream in=Resources.getResourceAsStream("mybatis-config.xml");
				//��ȡsessionFactory
				sessionFactory=new SqlSessionFactoryBuilder().build(in);//ʹ����Դ�ļ�����ȡ���ݻỰ����
				//��ȡ���ݿ�Ự
				session=sessionFactory.openSession();
				System.out.println("session===>"+session);
				//��ȡѧ����ӳ��ӿڶ���
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
