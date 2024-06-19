package com.fit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fit.entity.Student;
import com.fit.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/") // home page
	public ModelAndView getList() {
		List<Student> students = studentService.getAll();
		ModelAndView model = new ModelAndView("get-list");
		model.addObject("students", students);
		return model;
	}
	
	@RequestMapping("/show-form-add") // home page
	public ModelAndView showFormAdd() {
		ModelAndView model = new ModelAndView("form-add-student");
		model.addObject("student", new Student());
		return model;
	}
	
	@RequestMapping("/insert") // home page
	public ModelAndView insert(@Valid @ModelAttribute("student") Student s , BindingResult b) {
		
		if (b.hasErrors()) {	
			return new ModelAndView("form-add-student");
		} else {
			studentService.insert(s);
			ModelAndView model = new ModelAndView("redirect:/");
			return model;	
		}
	}
	
	@RequestMapping("/delete/{id}") // home page
	public ModelAndView insert(@PathVariable("id") int id) {
		studentService.delete(id);
		ModelAndView model = new ModelAndView("redirect:/");
		return model;
	}
	
	@RequestMapping("/show-form-update/{id}") // home page
	public ModelAndView showFormUpdate(@PathVariable("id") int id) {
		Student student = studentService.getStudentById(id);
		ModelAndView model = new ModelAndView("form-update-student");
		model.addObject("student", student);
		return model;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("student") Student s , BindingResult b) {
		if (b.hasErrors()) {	
			return new ModelAndView("form-update-student");
		} else {
			studentService.update(s);
			ModelAndView model = new ModelAndView("redirect:/");
			return model;	
		}
	}
}
