package com.itheima.ssm.service;

import java.util.List;

import com.itheima.ssm.pojo.Items;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年8月18日 下午5:28:52 
* 类说明 
*/
public interface ItemService {

	/**
	 * 查询商品列表
	 * @return
	 */
	public List<Items> queryItemList();
	
	/**
	 * 根据主键查询商品信息
	 * @param id
	 * @return
	 */
	public Items queryItemsById(Integer id);
	
	/**
	 * 保存修改
	 */
	public void saveUpdateById(Items items);
	
}
