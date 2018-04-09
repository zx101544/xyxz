package com.xyxz.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyxz.model.IMoocJSONResult;
import com.xyxz.model.sys_user;
import com.xyxz.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/test")
public class TestController {
   @Autowired
   private UserServiceImpl userServiceImpl;
   
   Logger logger=LoggerFactory.getLogger(this.getClass());
   /**
 * @return
 */
   @RequestMapping("/insert")
   public IMoocJSONResult insert() {
	   sys_user user=new sys_user();
	   user.setId(4l);
	   user.setUsername("Tom");
	   user.setPassword("zx123");
	   userServiceImpl.saveUser(user);
	   
	   return IMoocJSONResult.ok("保存成功");
   }
   @RequestMapping("/selectAll")
   public IMoocJSONResult selectAll(Integer page) {
	   if(page==null) {
		   page=1;
	   }
	   int pageSize=2;
	   sys_user user=new sys_user();
	   List<sys_user> list=userServiceImpl.queryUserListPaged(user, page, pageSize);
	   return IMoocJSONResult.ok(list);
   }
   @RequestMapping("/selectCustom")
   public IMoocJSONResult selectCustom() {
	   return IMoocJSONResult.ok(userServiceImpl.queryUserByIdCustom(1l));
   }

}
