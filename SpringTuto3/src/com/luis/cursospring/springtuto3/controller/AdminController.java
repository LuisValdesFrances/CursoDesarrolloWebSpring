package com.luis.cursospring.springtuto3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luis.cursospring.springtuto3.pojo.Admin;

/**
 * Para que toda esta fiesta funcione (Que el modelo pueda enviarse datos generados en la vista (quizas)
 * hay que recordar añadir en el dispatcher servlet.xml el namespace 'mvc'-> xmlns:mvc="http://www.springframework.org/schema/mvc"
 * @author Luis Valdes Frances
 *
 */
@Controller
public class AdminController {
	
	/**
	 * Perite definir atributos del modelo en el ambito de este metodo controlador
	 * @param model
	 * @param result Atributo enviado desde otro controlador
	 * @return
	 */
	@RequestMapping("/admin")
	public String showAdmin(Model model, 
			@ModelAttribute("result") String result){
		//'admin' es la clave que se especifico desde la vista .jsp -> commandName
		Admin admin = new Admin();
		//Lo envio a la vista
		model.addAttribute("admin", admin);
		model.addAttribute("result", result);
		return "admin";
	}
	
	/**
	 * Responde a metodos post(formulario) lanzados desde /admin
	 * @param adminForm
	 * @param model
	 * @param ra Permite redirigir la llamada a otro controlador ->No queremos que se llame a este metodo cada vez que el usuario recarge la pagina
	 * @param estado Atributo suelto desdela vista
	 * @return Retorna una direccion (No una vista) para que lo capture el controlador adecuado
	 */
	@RequestMapping(value="/admin/save", method=RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Admin adminForm, 
			Model model, 
			RedirectAttributes ra, 
			@RequestParam("estado") String estado){
		
		System.out.println("Test @ModelAtribute:");
		System.out.println(adminForm);
		System.out.println("Request param: " + estado);
		
		//Lo envio a la vista
		//model.addAttribute("adminForm", adminForm);
		
		//Lo envia a otro controlador (clave-valor)
		ra.addFlashAttribute("result", "Cambios realizados con exito");
		
		return "redirect:/admin";
	}

}
