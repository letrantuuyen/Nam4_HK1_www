package com.sv.iuh.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sv.iuh.entity.LopHoc;
import com.sv.iuh.server.LopHocServer;

@Controller
public class LopHocController {
	@Autowired
	private LopHocServer lopHocServer;
	@GetMapping("/")
	public String getALl(Model model){
		List<LopHoc> list= lopHocServer.getALl();
		model.addAttribute("lopHocs", list);
		return "lopHoc-list";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		LopHoc lopHoc= new LopHoc();
		model.addAttribute("lopHoc", lopHoc);
		return "lopHoc-form";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("maLopHoc")int maLopHoc, Model model) {
		LopHoc lopHoc= lopHocServer.getById(maLopHoc);
		model.addAttribute("lopHoc", lopHoc);
		return "lopHoc-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("maLopHoc")int maLopHoc) {
		lopHocServer.delete(maLopHoc);
		return "redirect:/";
	}
	@PostMapping("/saveLopHoc")
	public String saveLopHoc(@Valid @ModelAttribute("lopHoc")LopHoc lopHoc, BindingResult theBindingResult, Model model) {
		if(theBindingResult.hasErrors()) {
			return "lopHoc-form"; 
		}else {
			lopHocServer.save(lopHoc);
			model.addAttribute("lopHoc", lopHoc);
			return "redirect:/";
		}
	}
	
}
