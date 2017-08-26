package com.itheima.ssm.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.ssm.pojo.Items;
import com.itheima.ssm.pojo.QueryVo;
import com.itheima.ssm.service.ItemService;

/** 
* @author lijin E-mail: lijin1@itcast.cn 
* @date   2017年8月18日 下午5:31:06 
* 类说明 
*/
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value={"list","listAll"},method=RequestMethod.GET)
	public ModelAndView listvyubinvybhj(){
		
		ModelAndView mv = new ModelAndView();
		
		//查询数据
		List<Items> list = itemService.queryItemList();
//		int a = 10/0;
		
		//放数据
		mv.addObject("itemList", list);
		
		//放页面
		mv.setViewName("itemList");
		
		return mv;
	}
	
	
	/**
	 * 当返回String类型时  分为三种情况   
	 * 1\简单的String类型  默认返回视图名称
	 * 2\复制类型之请求转发
	 * 3\复杂类型之重定向
	 * @return
	 */
	@RequestMapping("itemEdit")
	public String itemEdit(HttpServletRequest request, Model model){
		//Model : 模型  放数据用的
		String id = request.getParameter("id");
		
		//根据ID查询商品信息
		Items items = itemService.queryItemsById(Integer.parseInt(id));
		
		model.addAttribute("item", items);
		
		return "editItem";
	}
	
	/**
	 * 演示:绑定简单类型的
	 */
	/*@RequestMapping("updateitem")
	public String updateitem(String name, Float price, String detail){
		
		System.err.println("========="+ name + "====" + price);
		
		return "success";
	}*/
	
	/**
	 * 演示:绑定POJO对象类型的
	 * @param name
	 * @param price
	 * @param detail
	 * @return
	 */
	/*@RequestMapping("updateitem")
	public String updateitem(Items item){
		
		System.err.println("========="+ item.getName() + "====" + item.getDetail());
		
		return "success";
	}*/
	
	
	@RequestMapping("queryitem")
	public String queryitem(QueryVo vo ){
		
		System.err.println("========"+ vo.getItem().getName() + "========" + vo.getUser().getUsername());
		
		return "";
	}
	
	/*@RequestMapping("deleteItems")
	public String deleteItems(String[] ids){
		for (String id : ids) {
			System.out.println(id);
		}
		return "success";
	}*/
	
	@RequestMapping("deleteItems")
	public String deleteItems(QueryVo vo){
		for (String id : vo.getIds()) {
			System.out.println(id);
		}
		return "success";
	}
	
	@RequestMapping(value="updateItems",method=RequestMethod.GET )
	public String updateItems(QueryVo vo){
		for (Items item : vo.getItems()) {
			itemService.saveUpdateById(item);
			System.out.println(item);
		}
		return "success";
	}
	
	@RequestMapping(value="updateitem")
	public String updateitem(Items item,Model model,HttpServletRequest request){
		itemService.saveUpdateById(item);
//		request.setAttribute("id", item.getId());
		model.addAttribute("id", item.getId());
		return "redirect:itemEdit.action";
	}
	
	@RequestMapping("updateItem")
	public String updateItemById(Items item, MultipartFile pictureFile) throws Exception {
		String picName = UUID.randomUUID().toString();
		String oriName = pictureFile.getOriginalFilename();
		oriName.substring(oriName.lastIndexOf("."));
		//开始上传
		pictureFile.transferTo(new File("C:"));
		return "forward:/itemEdit.action";
	}
	
}
