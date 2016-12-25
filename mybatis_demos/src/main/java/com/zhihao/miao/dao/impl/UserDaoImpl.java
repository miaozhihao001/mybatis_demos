package com.zhihao.miao.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zhihao.miao.dao.UserDao;
import com.zhihao.miao.pojo.User;

/**
 * 
 * ʹ��daoʵ�ֵķ�ʽ������ȱ�㣺
 * 
 * 1��dao�ӿ�ʵ���෽���д��ڴ���ģ�巽���������ܷ���Щ������ȡ���������������Ա�Ĺ�������
 * 2������sqlsession����ʱ��statement��idӲ������
 * 3������sqlsession����ʱ����ı���������sqlsession����ʹ�÷��ͣ���ʹ�������ʹ�������ڱ���׶�Ҳ�����������ڳ���Ա������
 * 
 * @author zhihao.miao
 */
public class UserDaoImpl implements UserDao {

	// ��Ҫ��daoʵ������ע��SqlSessionFactory
	// ����ͨ�����췽��ע��
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		// �ͷ���Դ
		sqlSession.close();
		return user;

	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("test.findUserByName", name);
		// �ͷ���Դ
		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ִ�в������
		sqlSession.insert("test.insertUser", user);
		// �ύ����
		sqlSession.commit();
		// �ͷ���Դ
		sqlSession.close();

	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ִ�в������
		sqlSession.delete("test.deleteUser", id);
		// �ύ����
		sqlSession.commit();
		// �ͷ���Դ
		sqlSession.close();

	}

}
