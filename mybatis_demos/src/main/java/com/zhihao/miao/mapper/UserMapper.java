package com.zhihao.miao.mapper;

import java.util.List;

import com.zhihao.miao.pojo.User;
import com.zhihao.miao.pojo.UserCustom;
import com.zhihao.miao.pojo.UserQueryVo;

/**
 * 程序员还需要编写mapper.xml映射文件
 * 程序员编写mapper接口需要遵循一些开发规范，mybatis可以自动生成mapper接口实现类代理对象。
 * 
 * 
 * 注意点：
 * 1、UserMapper.xml中的namespace等于UserMapper地址。
 * 2、mapper.java接口中的方法名和mapper.xml中statement的id一致
 * 3、mapper.java接口中的方法输入参数类型和mapper.xml中statement的parameterType指定的类型一致。
 * 4、mapper.java接口中的方法返回值类型和mapper.xml中statement的resultType指定的类型一致。
 *
 */
public interface UserMapper {
	//根据id查询用户信息
	//如果mapper方法返回单个pojo对象（非集合对象），代理对象内部通过selectOne查询数据库。
	//如果mapper方法返回集合对象，代理对象内部通过selectList查询数据库。
	public User findUserById(int id) throws Exception;
	
	//用户信息综合查询，使用包装类进行查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//用户信息综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;
	
	//使用动态sql进行相关开发
	public List<UserCustom> findUserListDynamic(UserQueryVo userQueryVo) throws Exception;
	
	//使用sql片段
	public List<UserCustom> findUserListSqlClip(UserQueryVo userQueryVo) throws Exception;
	
	
	//使用foreach
    public List<UserCustom> findUserListForeach(UserQueryVo userQueryVo) throws Exception;
}

