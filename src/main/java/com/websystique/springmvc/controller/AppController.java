package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class AppController {

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String getDetails(ModelMap model, @RequestParam("country") String country) {
		model.addAttribute("title", "Tourfirm");
		return "details";
	}

	@RequestMapping(value = "/additional", method = RequestMethod.GET)
	public String getAdditional(ModelMap model) {
		return "additional";
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String getResult(ModelMap model) {
		return "result";
	}

}