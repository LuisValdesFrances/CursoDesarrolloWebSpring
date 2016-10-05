package com.luis.cursospring.springtuto6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luis.cursospring.springtuto6.pojo.Admin;
import com.luis.cursospring.springtuto6.pojo.Direccion;
import com.luis.cursospring.springtuto6.service.AdminService;
import com.luis.cursospring.springtuto6.service.DireccionService;

/**
 * Para que toda esta fiesta funcione (Que el modelo pueda enviarse datos generados en la vista (quizas)
 * hay que recordar añadir en el dispatcher servlet.xml el namespace 'mvc'-> xmlns:mvc="http://www.springframework.org/schema/mvc"
 * @author Luis Valdes Frances
 *
 */
@Controller
@SessionAttributes("admin")
public class DireccionController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DireccionService direccionService;
	
	@RequestMapping("/direccion/{idAd}")
	public String getAll(Model model,
			@ModelAttribute("result") String res,
			@PathVariable("idAd") int id){
		
		Admin admin = adminService.findById(id);
		
		//Lo guardo en en modelo -> @SessionAttributes("admin")
		model.addAttribute("admin", admin);
		//Coloca una instancia vacia de la direccion
		model.addAttribute("direccion", new Direccion());
		
		model.addAttribute("result", res);
		
		model.addAttribute("direcciones", direccionService.findAll(id));
		
		return "direccion";
	}
	
	@RequestMapping("/direccion/save")
	public String save(Model model, RedirectAttributes ra,
			@ModelAttribute("direccion") Direccion direct,
			@ModelAttribute("admin") Admin ad){
		
		
		direccionService.save(ad, direct);
		ra.addFlashAttribute("result", "Cambios realiazados correctamente");
		
		return "redirect:/direccion/" + ad.getIdAd();
		
	}
	
	
}
