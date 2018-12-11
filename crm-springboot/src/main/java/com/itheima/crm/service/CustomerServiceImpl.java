package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.mapper.CustomerMapper;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.utils.Page;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired 
	private CustomerMapper customerMapper;
	//查询客户
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		// TODO Auto-generated method stub
		Page<Customer> page = new Page<Customer>();
		//补充page对象的相关属性
		queryVo.setRows(5);
		// 设置查询条件,从哪一条数据开始查
		queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());
		// 查询数据结果集
		List<Customer> list = customerMapper.queryCustomerByQueryVo(queryVo);
		// 查询到的数据总条数
		int total = customerMapper.queryCountByQueryVo(queryVo);
		page.setTotal(total);
		page.setPage(queryVo.getPage());
		page.setRows(list);
		page.setSize(queryVo.getRows());
		return page;
	}
	public Customer queryCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerMapper.queryCustomerById(id);
	}
	public void updateCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.updateCustomerById(customer);
	}
	public void deleteCustomerById(Integer id) {
		// TODO Auto-generated method stub
		customerMapper.deleteCustomerById(id);
	}
}
