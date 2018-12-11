package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.mapper.BaseDictMapper;
import com.itheima.crm.pojo.BaseDict;
@Service
@Transactional
public class BaseDicServiceImpl implements BaseDicService {
	@Autowired
	private BaseDictMapper baseDictMapper;
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		// TODO Auto-generated method stub
		return baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
	}

}
