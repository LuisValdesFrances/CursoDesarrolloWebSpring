package com.luis.cursospring.springtuto5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @RequestMapping
 * Acepta una peticion http y nos resuelva un nombe logico para que el dispatcher
 * servlet se encargue de el resto
 */
@Controller
@SessionAttributes("result")
//@SessionAttributes({"result", "message"})
public class IndexController {
	
	/**
	 * 
	 * @param session Perite definir atributos del modelo en el ambito de sesion
	 * @return
	 */
	//@RequestMapping("/")
	//public String showIndex(HttpSession session){
	//	session.setAttribute("result", "Mensaje desde index con ambito de session");
	//	return "index";
	//}
	
	@RequestMapping("/")
	public String showIndex(Model model){
		model.addAttribute("result", "Mensaje desde index con ambito de session");
		return "index";
	}
	
	/**
	 * 
	 * @param sessionStatus
	 * @return
	 */
	@RequestMapping("/about")
	public String showAbout(SessionStatus sessionStatus){
		//Limpia los atributos de con ambitos de sesion
		sessionStatus.setComplete();
		return "about";
	}
	
	
	
}
