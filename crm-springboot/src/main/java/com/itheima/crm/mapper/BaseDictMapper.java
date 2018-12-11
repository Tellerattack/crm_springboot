package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;
public interface BaseDictMapper {
	/**
	 * 根据类别代码查询数据
	 * @param dictTypeCode
	 * @return
	 */
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
