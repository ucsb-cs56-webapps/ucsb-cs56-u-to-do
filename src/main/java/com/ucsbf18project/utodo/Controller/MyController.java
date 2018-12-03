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
	
    @RequestMapping("/setting")
    public String Settings(Model model){
	return "settings";
    }

}
