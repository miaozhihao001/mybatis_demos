package com.zhihao.miao.dao;

import java.util.List;

import com.zhihao.miao.pojo.User;

public interface UserDao {
	//����id��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;

	//�����û����в�ѯ�û��б�
	public List<User> findUserByName(String name) throws Exception;

	//����û���Ϣ
	public void insertUser(User user) throws Exception;

	//ɾ���û���Ϣ
	public void deleteUser(int id) throws Exception;
}
