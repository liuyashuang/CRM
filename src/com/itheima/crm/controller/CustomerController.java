package com.itheima.crm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;

/**
 * 客户请求信息处理
 * @author 14832
 *
 */

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Resource
	private BaseDictService baseDictService;
	
	@Resource
	private CustomerService customerService;
	
	@Value("${customer_from_type}")
	private String customer_from_type;
	
	@Value("${customer_industry_type}")
	private String customer_industry_type;
	
	@Value("${customer_level_type}")
	private String customer_level_type;
	
	@RequestMapping("list")
	public String list(Model model,QueryVo vo) {
		
		//查询来源
		List<BaseDict> fromType = baseDictService.getBaseDictByCode(customer_from_type);
		
		//查询行业
		List<BaseDict> industryType = baseDictService.getBaseDictByCode(customer_industry_type);
		
		//查询级别
		List<BaseDict> levelType = baseDictService.getBaseDictByCode(customer_level_type);
		
		//设置数据的返回
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//根绝查询条件分页查询用户列表
		Page<Customer> page = customerService.getCustomerByQueryVo(vo);
		
		model.addAttribute("page", page);
		
		//数据回显
		model.addAttribute("custName",vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Integer id) {
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(Customer customer) {
		String msg = "1";
		try {
			customerService.updateCustomer(customer);
			msg = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
		
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(Integer id) {
		String msg = "1";
		try {
			customerService.deleteCustomer(id);
			msg = "0";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
		
	}
}
