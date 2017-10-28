package io.renren.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.renren.erp.dao.entity.base.User;
import io.renren.erp.dao.entity.base.UserExample;
import io.renren.erp.dao.mapper.base.UserMapper;
import io.renren.erp.service.ErpService;

@Service
public class ErpServiceImpl implements ErpService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> listUser() {
		UserExample example = new UserExample();
		example.createCriteria().andNameIsNotNull();
		List<User>  ulist = userMapper.selectByExample(example);
		return ulist;
	}

}
