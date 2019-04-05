package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

/**
 * 字典数据表业务逻辑接口
 * @author 14832
 *
 */
public interface BaseDictService {
	/*
	 * 根据字典编码查询字典列表
	 */
	List<BaseDict> getBaseDictByCode(String code);
}
