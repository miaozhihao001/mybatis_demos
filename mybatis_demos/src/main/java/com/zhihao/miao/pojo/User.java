package com.zhihao.miao.pojo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;


/**
 * �����������lombokע����������
 * @Data��ע�������ϣ��ṩ���������Ե� getting�� setting���������⻹�ṩ��equals��canEqual��hashCode��toString ����
 * @Setter��ע���������ϣ�Ϊ�����ṩ setting ����
 * @Getter��ע���������ϣ�Ϊ�����ṩ getting ����
 * @Log4j��ע�������ϣ�Ϊ���ṩһ�� ������Ϊlog �� log4j ��־����
 * @NoArgsConstructor��ע�������ϣ�Ϊ���ṩһ���޲εĹ��췽��
 * @AllArgsConstructor��ע�������ϣ�Ϊ���ṩһ��ȫ�εĹ��췽��
 * @ToString ����Ҫ�Լ�дһ�����field����toString����
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User {
	//�����������ݿ����ֶζ�Ӧ
	private int id;
	private String username;//�û�����
	private String sex;//�Ա�
	private Date birthday;//����
	private String address;//��ַ
	
}
