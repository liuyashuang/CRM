package com.itheima.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.BaseDictMapper;
import com.itheima.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	@Resource
	private BaseDictMapper baseDictMapper;
	@Override
	public List<BaseDict> getBaseDictByCode(String code) {
		return baseDictMapper.getBaseDictByCode(code);
	}

}
