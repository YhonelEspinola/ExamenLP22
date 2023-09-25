package com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.entity.Empleado;
import com.cibertec.interfaceService.IempleadoService;

@Controller
@RequestMapping
public class EmpleadosController {
	
	@Autowired
	private IempleadoService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Empleado>empleados=service.listar();
		model.addAttribute("empleados", empleados);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("empleado",new Empleado());
		return "formulario";
	}
	
	@PostMapping("/save")
	public String save(@Valid Empleado e,Model model) {
		service.save(e);
		
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable long id, Model model) {
		Optional<Empleado>empleado=service.listarId(id);
		model.addAttribute("empleado", empleado);
		
		return "formulario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable long id, Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	
}
