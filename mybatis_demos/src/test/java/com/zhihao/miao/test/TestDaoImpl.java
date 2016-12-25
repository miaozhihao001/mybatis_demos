package com.zhihao.miao.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zhihao.miao.dao.UserDao;
import com.zhihao.miao.dao.impl.UserDaoImpl;
import com.zhihao.miao.pojo.User;


public class TestDaoImpl {
	private SqlSessionFactory sqlSessionFactory;

	// �˷�������ִ��testFindUserById֮ǰִ��
	@Before
	public void setUp() throws Exception {
		// ����sqlSessionFactory
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����������mybatis�������ļ���Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		// ����UserDao�Ķ���
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		// ����UserDao�ķ���
		User user = userDao.findUserById(1);
		System.out.println(user);
	}
  
}
