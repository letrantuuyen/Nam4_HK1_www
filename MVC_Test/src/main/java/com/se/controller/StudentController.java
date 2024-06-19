package com.se.controller;

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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.se.entity.Student;
import com.se.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/") // home page
	public ModelAndView getList() {
		List<Student> students = studentService.getAllStudent();
		ModelAndView model = new ModelAndView("listStudent");
		model.addObject("students", students);
		return model;
	}
	
	
	// nut button khi bam se ra form
	@RequestMapping("/formAdd")
	private ModelAndView showFormForAdd() {
		ModelAndView model = new ModelAndView("studentForm");
		Student student = new Student();
		model.addObject("student",new Student());
		return model;
	}
	
	@RequestMapping("/addStudent")
	private ModelAndView addStudent(@Valid @ModelAttribute("student") Student student, BindingResult b) {
		if(b.hasErrors()) {
			return new ModelAndView("studentForm");
		}else {
		studentService.addStudent(student);
		ModelAndView model = new ModelAndView("redirect:/");
		return model;
		}
	}
	
	@RequestMapping("/delete/{id}") // home page
	public ModelAndView delete(@PathVariable("id") int id) {
		studentService.deleteStudent(id);
		ModelAndView model = new ModelAndView("redirect:/");
		return model;
	}
	
	//show form khi ấn vào update
	 @RequestMapping("/showFormForUpdate/{id}")
	    public ModelAndView showFormForUpdate(@PathVariable("id") int id) {
	        Student student = studentService.getStudentById(id);
	        ModelAndView model = new ModelAndView("updateStudentForm");
	        model.addObject("student",student);
	        return model;
	    }

	 @RequestMapping("/updateStudent")
	    public ModelAndView updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult b) {
	    	if(b.hasErrors()) {
	    		return new ModelAndView("updateStudentForm");
	    	}else {
	    	studentService.updateStudent(student);
	    	ModelAndView model = new ModelAndView("redirect:/");
	        return model;
	    }
	    }
}
