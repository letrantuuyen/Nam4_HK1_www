package com.sv.iuh.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sv.iuh.entity.LopHoc;
import com.sv.iuh.server.LopHocServer;

@Controller
@RequestMapping("/")
public class LopHocController {
	@Autowired
	private LopHocServer lopHocServer;

	@GetMapping("/")
	public String getALl(Model model) {
		List<LopHoc> list = lopHocServer.getALl();
		model.addAttribute("lopHocs", list);
		return "lopHoc-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		LopHoc lopHoc = new LopHoc();
		model.addAttribute("lopHoc", lopHoc);
		return "lopHoc-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("maLopHoc") int maLopHoc, Model model) {
		LopHoc lopHoc = lopHocServer.getById(maLopHoc);
		model.addAttribute("lopHoc", lopHoc);
		return "lopHocEdit";
	}

	@GetMapping("/map")
	public String getDelete(Model model) {
		List<LopHoc> list = lopHocServer.getALl();
		model.addAttribute("lopHocs", list);
		return "lopHoc-list";
	}

	@GetMapping("/delete/{maLopHoc}")
	public String delete(@PathVariable("maLopHoc") int maLopHoc) {
		lopHocServer.delete(maLopHoc);
		return "redirect:/";
	}

	@PostMapping("/saveLopHoc")
	public String saveLopHoc(@ModelAttribute("lopHoc") LopHoc lopHoc) {
		lopHocServer.save(lopHoc);
		return "redirect:/";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute("lopHoc") LopHoc lopHoc) {
		lopHocServer.save(lopHoc);
		return "redirect:/";
	}
}
