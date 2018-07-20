package com.lcm.springboot.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import com.lcm.springboot.api.IProvideService;
import com.lcm.springboot.bean.MUser;

@Controller

public class ConsumerController {
	//dubbo远程引用
	/*@Reference(version="1.0.0")
	private ImybatisService imybatis;*/
	
	
	@Reference(version="2.0.0",interfaceClass=IProvideService.class)
	private IProvideService ip;
	
	/*@RequestMapping(value="/consumergetuser",method=RequestMethod.GET)
	public List<MUser> getUsers() 
	{
		return imybatis.getUsers();
	}*/
	
	@RequestMapping(value="/consumergetuser1/{id}",method=RequestMethod.GET)
	@ResponseBody
	public List<com.lcm.springboot.bean.MUser> getUsers1(@PathVariable("id") String id) 
	{
		return ip.getUser(id);
	}
	
	
	@RequestMapping(value="/consumerthymeleaf/{id}")
	public String getThymeLeaf(@PathVariable String id,Model mode) 
	{
		List<MUser> muser= ip.getUser(id);
		mode.addAttribute("msg", "intergrater thymeleaf is successful");
		
		mode.addAttribute("muser", muser);
		return "index";
	}
	
}
