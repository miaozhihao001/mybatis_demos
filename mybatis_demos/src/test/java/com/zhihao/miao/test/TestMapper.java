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

	//�˷�������ִ��testFindUserById֮ǰִ��
	@Before
	public void setUp() throws Exception {
		//����sqlSessionFactory
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����Ự����������mybatis�������ļ���Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception{
		SqlSession session = sqlSessionFactory.openSession();
		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//����userMapper�ķ���
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
		userCustom.setUsername("С��");
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
		userCustom.setUsername("С��");
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
		//userCustom.setUsername("С��");
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
		userCustom.setUsername("С��");
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
