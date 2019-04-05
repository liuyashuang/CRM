package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

/**
 * 字典数据包持久化接口
 * @author 14832
 *
 */
public interface BaseDictMapper {
	/*
	 * 根据字典编码查询字典列表
	 */
	List<BaseDict> getBaseDictByCode(String code);
}
