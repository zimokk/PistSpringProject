package com.websystique.springmvc.controller;

import com.websystique.springmvc.entities.WriteExcel;
import jxl.write.WriteException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class AppController {

	private int hotel = 0;
	private String country;
	private String excursion;
	private String wishes;

	@RequestMapping(method = RequestMethod.GET)
	public String getIndex(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String getDetails(ModelMap model, @RequestParam("country") String country) {
		if(country == null || country.equals("")){
			model.addAttribute("source","");
			return "404";
		}
		else{
			this.country = country;
		}
		return "details";
	}

	@RequestMapping(value = "/additional", method = RequestMethod.GET)
	public String getAdditional(ModelMap model, @RequestParam("hotel") int hotel, @RequestParam("excursion") String excursion) {
		if(hotel == 0 || excursion == null){
			model.addAttribute("source","details");
			return "404";
		}else{
			this.excursion = excursion;
			this.hotel = hotel;
		}
		return "additional";
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String getResult(ModelMap model, @RequestParam("wishes") String wishes) {
		this.wishes = wishes;
		model.addAttribute("hotel",this.hotel);
		model.addAttribute("excursion", this.excursion);
		model.addAttribute("country", this.country);
		model.addAttribute("wishes", this.wishes);
		WriteExcel w = new WriteExcel();
		w.setOutputFile("c:/temp/lars.xls");
		try {
			w.write();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "result";
	}

}