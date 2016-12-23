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
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
	// 根据id查询用户信息，得到一条记录结果
	@Test
	public void findUserByIdTest() throws Exception {
		SqlSession sqlSession = getSession();

		// 通过SqlSession操作数据库
		// 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		// sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
		// selectOne查询出一条记录
		User user = sqlSession.selectOne("test.findUserById", 1);

		System.out.println(user);
		// 释放资源
		sqlSession.close();

	}
	
	//根据用户名进行模糊查询
	@Test
	public void findUserByName() throws Exception{
		SqlSession sqlSession = getSession();
		//list中的User对象类型就是resultType的类型，mybatis配置文件中返回类型没有List这个类型，返回类型和输入参数类型就三种，基本数据类型，Map类型，实体类POJO
		List<User> list = sqlSession.selectList("test.findUserByName", "小明");
		for(User user:list){
			System.out.println(user);
		}
		
	}

}
