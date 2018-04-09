package com.xyxz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.xyxz.model.IMoocJSONResult;
import com.xyxz.model.Resource;
import com.xyxz.model.User;

@Controller
@RequestMapping("/User")
public class Mycontroller {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private Resource resource;
	
	
	@RequestMapping("/tojson")
	@ResponseBody
	public User tojson() {
		User user=new User("lee","123456",30,new Date(),"<font color='green><b>hello</b></font>");			
		return user;
	}
	
	@RequestMapping("/resource")
	@ResponseBody
	public IMoocJSONResult resource() {
		Resource bean=new Resource();
		BeanUtils.copyProperties(resource, bean);
		return IMoocJSONResult.ok(bean);		
	}
	@RequestMapping("/index")
	public String index(ModelMap model) {
		logger.info("************index");
		model.addAttribute("name", "thymeleaf");
		return "/thymeleaf/index";
	}
	@RequestMapping("/center")
	public String center() {
		return "/thymeleaf/center";
	}
	
	@RequestMapping("/test")
	public String test(ModelMap model) {
		User user=new User("superadmin","123456",30,new Date(),"<font color='green'><b>hello</b></font>");
		model.addAttribute("user",user);
		User user1=new User("lisi","1015446215",18,new Date(),"我是lisi");
		User user2=new User("Tome","6216",19,new Date(),"我是tom");
		List<User> list=new ArrayList<User>();
		list.add(user);
		list.add(user1);
		list.add(user2);
		model.addAttribute("userlist", list);
		return "/thymeleaf/test";
	}
	@PostMapping("/postform")
	public String postform(User u) {
		logger.info("postform:"+u.getUsername());
		return "redirect:/User/test";
	}
	@RequestMapping("/error")
	public String error() {
		int a= 1/0;
		
		return "/thymeleaf/err";
	}
	
	
}
