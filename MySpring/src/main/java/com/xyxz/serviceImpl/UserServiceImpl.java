package com.xyxz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.xyxz.mapper.Sys_userMapperCustom;
import com.xyxz.mapper.sys_userMapper;
import com.xyxz.model.sys_user;
import com.xyxz.service.UserService;
import com.xyxz.utils.MyMapper;

import tk.mybatis.mapper.entity.Example;
@Service
public class UserServiceImpl implements UserService {
 
	@Autowired
	private sys_userMapper sys_userMapper;
    
	@Autowired
	private Sys_userMapperCustom sys_userMapperCustom;
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveUser(sys_user user) {
		// TODO Auto-generated method stub
		sys_userMapper.insert(user);
	}

	@Override
	public void updateUser(sys_user user) {
		// TODO Auto-generated method stub
		sys_userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		sys_userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public sys_user queryUserById(long id) {
		// TODO Auto-generated method stub
		return sys_userMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<sys_user> queryUserListPaged(sys_user user, Integer page, Integer pageSize) {
		// 开始分页
        PageHelper.startPage(page, pageSize);
		
		Example example = new Example(sys_user.class);
		Example.Criteria criteria = example.createCriteria();
		
//		if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
//			criteria.andLike("nickname", "%" + user.getNickname() + "%");
//		}
		example.orderBy("id").desc();
		List<sys_user> userList = sys_userMapper.selectByExample(example);
		
		return userList;
	}

	@Override
	public List<sys_user> queryUserList() {
		// TODO Auto-generated method stub
		return sys_userMapper.selectAll();
	}
    public sys_user queryUserByIdCustom(Long id) {
    	sys_user user=sys_userMapperCustom.queryUserSimpleInfoById(id);
    	if(user!=null) {
    		return user;
    	}
    	return null;
    }
	
	

	

}
