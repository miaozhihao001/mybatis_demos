package com.zhihao.miao.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zhihao.miao.mapper.UserMapper;
import com.zhihao.miao.pojo.User;
import com.zhihao.miao.pojo.UserCustom;
import com.zhihao.miao.pojo.UserQueryVo;

public class TestMapper {

	private SqlSessionFactory sqlSessionFactory;

	//此方法是在执行testFindUserById之前执行
	@Before
	public void setUp() throws Exception {
		//创建sqlSessionFactory
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//调用userMapper的方法
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserList() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		for(UserCustom user :list){
			System.out.println(user);
		}
	}
	
	@Test
	public void TestFindUserCount() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);
		int totalNum = userMapper.findUserCount(userQueryVo);
		System.out.println(totalNum);
	}
	
	@Test
	public void TestFindUserByIdResultMap() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findUserByIdResultMap(10);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserListDynamic() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		//userCustom.setSex("1");
		//userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.findUserListDynamic(userQueryVo);
		for(UserCustom user :list){
			System.out.println(user);
		}
	}
	
	@Test
	public void testFindUserListSqlClip() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.findUserListSqlClip(userQueryVo);
		for(UserCustom user :list){
			System.out.println(user);
		}
	}
	
	@Test
	public void testFindUserListForeach() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(10);
		ids.add(26);
		userQueryVo.setIds(ids);
		List<UserCustom> list = userMapper.findUserListForeach(userQueryVo);
		for(UserCustom user :list){
			System.out.println(user);
		}
	}
	
}
