package com.itheima.crm.service;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.utils.Page;

public interface CustomerService {
	/**
	 * 根据queryVo分页查询数据
	 * 
	 * @param queryVo
	 * @return
	 */
	Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	/**
	 * 根据id查询客户信息
	 * @param id
	 * @return
	 */
	Customer queryCustomerById(Integer id);
	/**
	 * 根据id更新用户信息
	 * @param customer
	 */
	void updateCustomerById(Customer customer);
	/**
	 * 根据id删除用户信息
	 * @param customer
	 */
	void deleteCustomerById(Integer id);
}
