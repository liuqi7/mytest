package com.itheima.ssm.pojo;

import java.util.List;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年8月18日 下午6:19:17 
* 类说明 
*/
public class QueryVo {

	private User user;
	
	private Items item;
	
	private String[] ids;
	
	private List<Items> items;

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}
	
}
