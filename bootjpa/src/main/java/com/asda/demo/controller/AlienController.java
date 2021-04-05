package com.asda.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.asda.demo.dao.AlienRepo;
import com.asda.demo.model.Alien;


@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	@RequestMapping("/")
	public String home() {
		

		return "home.jsp";
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable("aid") int aid) {
		repo.deleteById(aid);
		return "deleted";
		
	}
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	
	}
	
	
	@PutMapping("/alien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	
	}
	
//	@RequestMapping("/getAlien")
	
//	public ModelAndView getAlien(int aid) {
//		ModelAndView mv= new ModelAndView("showAlien.jsp");
//		Alien alien = repo.findById(aid).orElse(new Alien());
		
//		System.out.println(repo.findByTech("Java"));
//		System.out.println(repo.findByAidGreaterThan(102));
//		
//		System.out.println(repo.findByTechSorted("Java"));
		
//		mv.addObject(alien);
//		return mv;
//	}
	
	@GetMapping("/aliens")
//	@ResponseBody
	public Iterable<Alien> getAlien() {
		
		return repo.findAll();
	
		
	}
	
	@RequestMapping("/alien/{aid}")
//	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		
//		return repo.findAll().toString();
		return repo.findById(aid);
		
	}
	

	
}
