package com.zhihao.miao.mapper;

import java.util.List;

import com.zhihao.miao.pojo.User;
import com.zhihao.miao.pojo.UserCustom;
import com.zhihao.miao.pojo.UserQueryVo;

/**
 * ����Ա����Ҫ��дmapper.xmlӳ���ļ�
 * ����Ա��дmapper�ӿ���Ҫ��ѭһЩ�����淶��mybatis�����Զ�����mapper�ӿ�ʵ����������
 * 
 * 
 * ע��㣺
 * 1��UserMapper.xml�е�namespace����UserMapper��ַ��
 * 2��mapper.java�ӿ��еķ�������mapper.xml��statement��idһ��
 * 3��mapper.java�ӿ��еķ�������������ͺ�mapper.xml��statement��parameterTypeָ��������һ�¡�
 * 4��mapper.java�ӿ��еķ�������ֵ���ͺ�mapper.xml��statement��resultTypeָ��������һ�¡�
 *
 */
public interface UserMapper {
	//����id��ѯ�û���Ϣ
	//���mapper�������ص���pojo���󣨷Ǽ��϶��󣩣���������ڲ�ͨ��selectOne��ѯ���ݿ⡣
	//���mapper�������ؼ��϶��󣬴�������ڲ�ͨ��selectList��ѯ���ݿ⡣
	public User findUserById(int id) throws Exception;
	
	//�û���Ϣ�ۺϲ�ѯ��ʹ�ð�װ����в�ѯ
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//�û���Ϣ�ۺϲ�ѯ����
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//����id��ѯ�û���Ϣ��ʹ��resultMap���
	public User findUserByIdResultMap(int id) throws Exception;
	
	//ʹ�ö�̬sql������ؿ���
	public List<UserCustom> findUserListDynamic(UserQueryVo userQueryVo) throws Exception;
	
	//ʹ��sqlƬ��
	public List<UserCustom> findUserListSqlClip(UserQueryVo userQueryVo) throws Exception;
	
	
	//ʹ��foreach
    public List<UserCustom> findUserListForeach(UserQueryVo userQueryVo) throws Exception;
}

