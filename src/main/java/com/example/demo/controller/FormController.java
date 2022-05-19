package com.example.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.IEstudianteDAO;
import com.example.demo.entity.Estudiante;
import com.example.demo.service.IEstudianteService;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver;

@Controller
public class FormController {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping("/")
	public String form(Map<String, Object> model) {

		Estudiante estudiante = new Estudiante();
		model.put("estudiante", estudiante);
		model.put("titulo", "Formulario de estudiantes");
		return "form";
	}
	
	@PostMapping("/")
	public String guardar(@Valid Estudiante estudiante, BindingResult result, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			return "form";
		}
		
		estudianteService.guardar(estudiante);
		flash.addFlashAttribute("success","Estudiante guardado con éxito!");
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("estudiantes", estudianteService.listAllEstudients());
		model.addAttribute("titulo", "listado de estudiantes");
		model.addAttribute("encabezado", "Listado de estudiantes");
		
		return "list";
	}
	
	
}
