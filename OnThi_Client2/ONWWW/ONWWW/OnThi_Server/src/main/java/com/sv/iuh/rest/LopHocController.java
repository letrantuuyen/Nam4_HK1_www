package com.sv.iuh.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.iuh.entity.LopHoc;
import com.sv.iuh.server.LopHocServer;

@RestController
@RequestMapping("/api")
public class LopHocController {
	
	@Autowired
	private LopHocServer lopHocServer;
	
	@GetMapping("/lopHocs")
	public List<LopHoc> getALl(){
		return lopHocServer.getALl();
	}
	@GetMapping("/lopHocs/{maLopHoc}")
	public LopHoc getById (@PathVariable int maLopHoc) {
		return lopHocServer.getById(maLopHoc);
	}
	@PostMapping("/lopHocs")
	public LopHoc save(@RequestBody LopHoc lopHoc) {
		lopHoc.setMaLopHoc(0);
		lopHocServer.save(lopHoc);
		return lopHoc;
	}
	@PutMapping("/lopHocs")
	public LopHoc update(@RequestBody LopHoc lopHoc) {
		
		lopHocServer.save(lopHoc);
		return lopHoc;
	}
	@DeleteMapping("/lopHocs/{maLopHoc}")
	public void delete(@PathVariable int maLopHoc) {
		lopHocServer.delete(maLopHoc);
	}
}
