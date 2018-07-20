package com.lcm.springboot.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.lcm.springboot.api.IProvideService;
import com.lcm.springboot.bean.MUser;


@Controller

public class ProviderController {

	@Autowired
	private IProvideService ipProvideService;
	
	//restful风格 @PathVariable
	@RequestMapping(value="/provider/{id}",method=RequestMethod.GET)
	@ResponseBody
	public  List<MUser> getUsers(@PathVariable("id") String id)
	{
		
		return ipProvideService.getUser(id);
	}
	
	@RequestMapping(value="/jsp",method=RequestMethod.GET)
	
	public String getJsp(Model m)
	{
		m.addAttribute("name", "ok");
		return "index";
	}
	
}
