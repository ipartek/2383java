package com.ipartek.MVCompleto.controller;

import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.MVCompleto.domain.Cd;
import com.ipartek.MVCompleto.service.CdService;

@Controller
@RequestMapping("/cd")
public class CdController {
	
	@Autowired
	CdService cdService;

	//@RequestMapping(method=MethodType.GET)
	@GetMapping
	public String cdHome(ModelMap model) {
		List<Cd> cds = cdService.getCds();
		
		model.addAttribute("cds", cds);
		
		return "cd";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
