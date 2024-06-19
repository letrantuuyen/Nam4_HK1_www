package com.fit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fit.entity.TuyenXe;
import com.fit.service.TuyenXeService;

@Controller
@RequestMapping("/")
public class TuyenXeController {
	@Autowired
	private TuyenXeService tuyenXeService;
	
	@RequestMapping("/") //home page
	public ModelAndView getList() {
		List<TuyenXe> tuyenXes = tuyenXeService.getAll();
		ModelAndView model = new ModelAndView("get-list");
		model.addObject("tuyenXes", tuyenXes);
		return model;
	}
	
	@RequestMapping("/show-form-add")
	public ModelAndView showFormAdd () {
		ModelAndView model = new ModelAndView("form-add-tuyenxe");
		model.addObject("tuyenXe", new TuyenXe());
		return model;
	}
	
	@RequestMapping("/insert")
	public ModelAndView insert(@Valid @ModelAttribute ("tuyenXe") TuyenXe tx, BindingResult b) {
		if(b.hasErrors()) {
			return new ModelAndView("form-add-tuyenxe");
		}
		else {
			tuyenXeService.insert(tx);
			ModelAndView model = new ModelAndView("redirect:/");
			return model;
		}
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView insert (@PathVariable("id") int id) {
		tuyenXeService.delete(id);
		ModelAndView model = new ModelAndView("redirect:/");
		return model;
	}
	
	@RequestMapping("/show-form-update/{id}")
	public ModelAndView showFormUpdate(@PathVariable("id")int id) {
		TuyenXe tuyenXe = tuyenXeService.getTuyenXeById(id);
		ModelAndView model = new ModelAndView("form-update-tuyenxe");
		model.addObject("tuyenXe", tuyenXe);
		return model;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("tuyenXe") TuyenXe tx, BindingResult b) {
	    if(b.hasErrors()) {
	        return new ModelAndView("form-update-tuyenxe");
	    } else {
	        tuyenXeService.update(tx);
	        ModelAndView model = new ModelAndView("redirect:/");
	        return model;
	    }
	}

	
	
}
