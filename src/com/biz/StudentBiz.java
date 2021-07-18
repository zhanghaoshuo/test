package com.biz;

import java.util.List;

import com.bean.Clazz;
import com.bean.Student;
import com.mapper.IStudentMapper;
import com.util.MybatisUtil;

public class StudentBiz implements IStudentBiz {
    private IStudentMapper idao=MybatisUtil.showAdd();
	@Override
	public boolean save(Student st) {
		if(st!=null){
		int rows=idao.save(st);
		if(rows>0){
			MybatisUtil.scommit();
			return true;
		}
		}
		return false;
	}

	@Override
	public boolean update(Student st) {
		int rows=idao.update(st);
		if(rows>0){
			MybatisUtil.scommit();
			return true;
		}
		return false;
	}

	@Override
	public boolean delById(int sid) {
		System.out.println("bbbbbbbbbbbbbb");
	int rows=idao.delById(sid);
	System.out.println("aaaaaaaaaaaa"+rows);
	if(rows>0){
		MybatisUtil.scommit();
		return true;
	}
		return false;
	}

	@Override
	public Student findById(int sid) {
		// TODO Auto-generated method stub
		return idao.findById(sid);
	}

	@Override
	public List<Clazz> doinit() {
		// TODO Auto-generated method stub
		return idao.doinit();
	}

	@Override
	public List<Student> findPageAll(int page, int rows) {
		int ipage=(page-1)*rows;
		// TODO Auto-generated method stub
		return idao.findPageAll(ipage, rows);
	}

	@Override
	public int findMaxPage(int rows) {
		int maxrows=idao.findMaxPage();//总记录数
		int maxpage=0;//总页数
		if(maxrows==0){
			maxpage=1;
		}else{
		maxpage=maxrows%rows==0?maxrows/rows:maxrows/rows+1;	
		}
		return maxpage;
	}

}
