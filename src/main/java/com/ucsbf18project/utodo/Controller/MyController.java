package com.ucsbf18project.utodo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController{
	
	@RequestMapping("/")
    public String Index(Model model) {

        return "index";
    }
	
	@RequestMapping("/login")
	public String Login(Model model){
		return "login";
	}
	
	@RequestMapping("/edit")
	public String Edit(Model model){
		return "edit";
	}
	
	@RequestMapping("/setting")
	public String Settings(Model model){
		return "settings";
	}
}