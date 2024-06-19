package com.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.fit.entity.Xe;
import com.fit.service.XeService;

import java.util.List;

@Controller
@RequestMapping("/")
public class XeController {

    @Autowired
    private XeService xeService;

    @GetMapping
    @RequestMapping("/list")
    public String getAllTuyenXe(Model theModel) {
       List<Xe> xes = xeService.getAllXe();
       theModel.addAttribute("xes", xes);
       return "listXe";
    }
  
    public void addXe(@RequestBody Xe tuyenXe) {
    	xeService.addXe(tuyenXe);
    }

   
    public void updateTuyenXe(@PathVariable int id, @RequestBody Xe xe) {
    	xeService.update(id, xe);
    }

   
    public void deleteTuyenXe(@PathVariable int id) {
    	xeService.delete(id);
    }
}