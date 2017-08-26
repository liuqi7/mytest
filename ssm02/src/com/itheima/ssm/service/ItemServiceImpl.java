package com.itheima.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.ssm.mapper.ItemsMapper;
import com.itheima.ssm.pojo.Items;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年8月18日 下午5:30:01 
* 类说明 
*/
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	public List<Items> queryItemList() {
		List<Items> list = itemsMapper.selectByExample(null);
		return list;
	}

	public Items queryItemsById(Integer id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	public void saveUpdateById(Items items) {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}

}
