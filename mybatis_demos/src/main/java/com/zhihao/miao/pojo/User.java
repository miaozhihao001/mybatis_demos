package com.zhihao.miao.pojo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;


/**
 * 在这边我是用lombok注解来开发，
 * @Data：注解在类上；提供类所有属性的 getting和 setting方法，此外还提供了equals、canEqual、hashCode、toString 方法
 * @Setter：注解在属性上；为属性提供 setting 方法
 * @Getter：注解在属性上；为属性提供 getting 方法
 * @Log4j：注解在类上；为类提供一个 属性名为log 的 log4j 日志对象
 * @NoArgsConstructor：注解在类上；为类提供一个无参的构造方法
 * @AllArgsConstructor：注解在类上；为类提供一个全参的构造方法
 * @ToString 不需要自己写一个类的field包含toString方法
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User {
	//属性名和数据库表的字段对应
	private int id;
	private String username;//用户姓名
	private String sex;//性别
	private Date birthday;//生日
	private String address;//地址
	
}
