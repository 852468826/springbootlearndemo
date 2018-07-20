package com.lcm.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcm.springboot.api.IProvideService;
import com.lcm.springboot.bean.MUser;
import com.lcm.springboot.mapper.MUserMapper;
@org.springframework.stereotype.Service
@Service(version="2.0.0",interfaceClass=IProvideService.class)
public class ProvideServiceImpl implements IProvideService {

	@Autowired
	private MUserMapper muserMapper;
	
	public List<MUser> getUser(String id) {
		if ("all".equals(id) ) 
		{
			List<MUser> muser = muserMapper.getAll();
			MUser muser1 = muser.get(0);
			muser.remove(muser1);
			muser1.setAddress("他的地址是");
			muser.add(0, muser1);
			return muser;
		}else 
		{
			List<MUser> li = new ArrayList<MUser>();
			li.add(muserMapper.selectByPrimaryKey(id));
			return li;
		}
		
		
	}

	

}
