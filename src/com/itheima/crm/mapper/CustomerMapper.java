package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

/**
 * 客户信息持久化接口
 * @author 14832
 *
 */
public interface CustomerMapper {
	/**
	 * 根据查询条件，分页查询列表
	 * @param vo
	 * @return
	 */
	List<Customer> getCustomerByQueryVo(QueryVo vo);
	/**
	 * 根据查询条件查询总数
	 * @param vo
	 * @return
	 */
	Integer getCountByQueryVo(QueryVo vo);
	/**
	 * 根据Id查询用户信息
	 * @param id
	 * @return
	 */
	Customer getCustomerById(Integer id);
	/**
	 * 更新用户信息
	 * @param customer
	 */
	void updateCustomer(Customer customer);
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteCustomer(Integer id);
	
}
