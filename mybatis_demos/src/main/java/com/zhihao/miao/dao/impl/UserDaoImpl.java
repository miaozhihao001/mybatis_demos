package com.zhihao.miao.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zhihao.miao.dao.UserDao;
import com.zhihao.miao.pojo.User;

/**
 * 
 * 使用dao实现的方式开发的缺点：
 * 
 * 1、dao接口实现类方法中存在大量模板方法，设想能否将这些代码提取出来，大大减轻程序员的工作量。
 * 2、调用sqlsession方法时将statement的id硬编码了
 * 3、调用sqlsession方法时传入的变量，由于sqlsession方法使用泛型，即使变量类型传入错误，在编译阶段也不报错，不利于程序员开发。
 * 
 * @author zhihao.miao
 */
public class UserDaoImpl implements UserDao {

	// 需要向dao实现类中注入SqlSessionFactory
	// 这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		// 释放资源
		sqlSession.close();
		return user;

	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("test.findUserByName", name);
		// 释放资源
		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行插入操作
		sqlSession.insert("test.insertUser", user);
		// 提交事务
		sqlSession.commit();
		// 释放资源
		sqlSession.close();

	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行插入操作
		sqlSession.delete("test.deleteUser", id);
		// 提交事务
		sqlSession.commit();
		// 释放资源
		sqlSession.close();

	}

}
