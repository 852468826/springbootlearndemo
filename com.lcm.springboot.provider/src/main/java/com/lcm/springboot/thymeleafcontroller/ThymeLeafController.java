package com.lcm.springboot.thymeleafcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.lcm.springboot.api.IProvideService;
import com.lcm.springboot.bean.MUser;

@Controller
public class ThymeLeafController {
	
	@Autowired
	private IProvideService ip;
	
	@RequestMapping(value="thymeleafindex/{id}")
	public String getThymeLeaf(@PathVariable String id,Model mode) 
	{
		List<MUser> muser= ip.getUser(id);
		mode.addAttribute("msg", "intergrater thymeleaf is successful");
		
		mode.addAttribute("muser", muser);
		return "index";
	}
}
