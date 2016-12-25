package com.zhihao.miao.helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.zhihao.miao.pojo.User;

public class TestMybatis {
	
	public static SqlSession getSession() throws IOException{
		//mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
	// ����id��ѯ�û���Ϣ���õ�һ����¼���
	@Test
	public void findUserByIdTest() throws Exception {
		SqlSession sqlSession = getSession();

		// ͨ��SqlSession�������ݿ�
		// ��һ��������ӳ���ļ���statement��id������=namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���
		// sqlSession.selectOne��� ����ӳ���ļ�����ƥ���resultType���͵Ķ���
		// selectOne��ѯ��һ����¼
		User user = sqlSession.selectOne("test.findUserById", 1);

		System.out.println(user);
		// �ͷ���Դ
		sqlSession.close();

	}
	
	//�����û�������ģ����ѯ
	@Test
	public void findUserByName() throws Exception{
		SqlSession sqlSession = getSession();
		//list�е�User�������;���resultType�����ͣ�mybatis�����ļ��з�������û��List������ͣ��������ͺ�����������;����֣������������ͣ�Map���ͣ�ʵ����POJO
		List<User> list = sqlSession.selectList("test.findUserByName", "С��");
		for(User user:list){
			System.out.println(user);
		}
		// �ͷ���Դ
		sqlSession.close();
	}
	
	@Test
	public void insertUser() throws Exception{
		SqlSession sqlSession = getSession();
		User user = new User();
		user.setUsername("miaozhihao");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("��������");
		sqlSession.insert("test.insertUser", user);
		System.out.println(user.getId());
		//�ύ����
		sqlSession.commit();
		// �ͷ���Դ
		sqlSession.close();
	}
	
	@Test
	public void deleteUser() throws Exception{
		SqlSession sqlSession = getSession();
		sqlSession.delete("test.deleteUser",28);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void updateUserById() throws Exception{
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = getSession();
		// �����û���Ϣ
		User user = new User();
		// ��������id
		user.setId(26);
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("����֣��");

		sqlSession.update("test.updateUserById", user);

		// �ύ����
		sqlSession.commit();

		// �رջỰ
		sqlSession.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
