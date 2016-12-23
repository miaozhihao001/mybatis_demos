package com.zhihao.miao.helloworld;

import java.io.IOException;
import java.io.InputStream;
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
		
	}

}
