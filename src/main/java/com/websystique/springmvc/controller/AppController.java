package com.websystique.springmvc.controller;

import com.websystique.springmvc.entities.Tour;
import com.websystique.springmvc.entities.WriteExcel;
import jxl.write.WriteException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;

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
	public String getDetails(ModelMap model, @RequestParam(value = "country", required = false) String country, @RequestParam(value =
	"errorPage", required = false) String errorPage) {
		if(errorPage == null){
			if(country == null || country.equals("")){
				model.addAttribute("source","");
				return "404";
			} else if(country.equals("no")){
				this.country = null;
			}
			else{
				this.country = country;
			}
		}
		return "details";
	}

	@RequestMapping(value = "/additional", method = RequestMethod.GET)
	public String getAdditional(ModelMap model, @RequestParam(value = "hotel", required = false) String hotel, @RequestParam(value = "excursion", required = false) String excursion, @RequestParam(value =
			"errorPage", required = false) String errorPage) {
		if(errorPage == null){
			if(hotel == null){
				model.addAttribute("source","details");
				return "404";
			}else{
				this.excursion = excursion;
				this.hotel = Integer.parseInt(hotel);
			}
		}
		return "additional";
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String getResult(ModelMap model, @RequestParam(value = "wishes", required = false) String wishes) {
		this.wishes = wishes;
		model.addAttribute("hotel",this.hotel);
		model.addAttribute("excursion", this.excursion);
		model.addAttribute("country", this.country);
		model.addAttribute("wishes", this.wishes);
		WriteExcel w = new WriteExcel();
		w.setOutputFile("c:/temp/lars.xls");
        ArrayList<Tour> tourList = null;
		try {
            tourList = w.write(this.hotel, this.excursion, this.country, this.wishes);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        model.addAttribute("tourList", tourList);
		return "result";
	}

}