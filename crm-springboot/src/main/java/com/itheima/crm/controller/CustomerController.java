package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDicService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private BaseDicService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 显示用户列表
	 * 
	 * @return
	 */
	@RequestMapping("list")
	public String queryCustomerList(Model model,QueryVo queryVo) {
		// 客户来源
		List<BaseDict> fromType = this.baseDictService.queryBaseDictByDictTypeCode("002");
		// 所属行业
		List<BaseDict> industryType = this.baseDictService.queryBaseDictByDictTypeCode("001");
		// 客户级别
		List<BaseDict> levelType = this.baseDictService.queryBaseDictByDictTypeCode("006");
		// 把前端页面需要显示的数据放到模型中
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		if(queryVo!=null){
			Page<Customer> page = customerService.queryCustomerByQueryVo(queryVo);
			model.addAttribute("page", page);
			// 数据回显
			model.addAttribute("custName", queryVo.getCustName());
			model.addAttribute("custSource", queryVo.getCustSource());
			model.addAttribute("custIndustry", queryVo.getCustIndustry());
			model.addAttribute("custLevel", queryVo.getCustLevel());
		}

		return "customer";
	}
	/**
	 * 编辑前查询客户信息
	 * @param id
	 */
	@RequestMapping(value="/edit")
	@ResponseBody
	public Customer editCustomer(Integer id){
		Customer customer = customerService.queryCustomerById(id);
		return customer;
	}
	/**
	 * 更新用户信息
	 * @param customer
	 * @return
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public String updateCustomer(Customer customer){
		customerService.updateCustomerById(customer);
		return "SUCCESS";
	}
	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String deleteCustomerById(Integer id) {
		customerService.deleteCustomerById(id);
		return "ok";
	}

}
